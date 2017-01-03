/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.server;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.*;

/**
 *
 * @author Markus
 */
public class DatabaseManager {

    static String ipAddress, portNr, groupID;

    static String sqlConnectionUrl = "jdbc:sqlserver://hitsql-db.hb.se:56077;database=oomuht1601;user=oomuht1601;password=plux66";
    static ResultSet resultSet;
    static Statement statement;
    static Connection connection;
    static DatabaseMetaData metaData;

    public DatabaseManager() throws SQLException, ClassNotFoundException, UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        
        /* Server info */
        ipAddress = inetAddress.getHostAddress();
        portNr = "6969";
        groupID = "02";

        initializeDatabase();
        if (!getMetaData()) {
            /* insert om tabellen inte finns */
            createTable();
            insertToTable();
        } else {
            /* annars Update*/
            String updateStatement = "UPDATE OnlinePlayers SET groupID = '" + groupID + "', ipAddress = '" + ipAddress + "', port = '" + portNr + "' WHERE groupID = '02'";
            statement.executeUpdate(updateStatement);
            //update
        }

        connection.close(); // Close the connection
    }

    /**
     * Initierar kopplingen till våran databas
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    private static void initializeDatabase() throws SQLException, ClassNotFoundException {
        connection = DriverManager.getConnection(sqlConnectionUrl);
        statement = connection.createStatement(); // Create a statement

    }

    /**
     * Skriver ut allt som finns i OnlinePlayers tabellen
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void getData() throws SQLException, ClassNotFoundException {
        try {
            initializeDatabase();
            resultSet = statement.executeQuery("select * from OnlinePlayers ");
            // Iterera igenom och visa resultatet
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("funkar inte");
        }
    }

    /**
     * Boolean method som kollar om det finns något
     * i databasen.
     * @return
     * @throws SQLException 
     */
    static public boolean getMetaData() throws SQLException {
        metaData = connection.getMetaData();
        ResultSet rs = metaData.getTables("oomuht1601", "dbo", "OnlinePlayer", new String[]{"TABLE"});
        System.out.println("" + rs.toString());
        if (rs.next()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Skapar en ny Tabell om vi inte har någon
     * (groupID, ipAdress, portNr) alla av typen
     * varchar.
     * @throws SQLException
     */
    private void createTable() throws SQLException {
        statement.executeUpdate("CREATE TABLE OnlinePlayers " + "( groupID VARCHAR(2) NOT NULL," + "ipAddress VARCHAR(30) NOT NULL," + "port VARCHAR(4) NOT NULL);");

    }

    /**
     * sätter in en ny rad i våran databas 
     * (groupID, ipAdress, portNr) allt som behövs
     * veta om en server.
     * @throws SQLException
     */
    public void insertToTable() throws SQLException {
        String insertStatement = "INSERT INTO OnlinePlayers VALUES ('" + groupID + "', '" + ipAddress + "', '" + portNr + "')";
        statement.executeUpdate(insertStatement);

    }

    /**
     * Hämtar information om servern genom att skicka in group id som parameter
     * vilket skall representera en specifik server.
     * @param GroupID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    static public String[] getServerConnectionDetails(int GroupID) throws SQLException, ClassNotFoundException {
        String[] serverInfo = new String[]{};
            initializeDatabase();
            /* anropar lagrad procedur */
            CallableStatement statement = connection.prepareCall("{call GetConnectionDetails(" + GroupID + ")}");
            resultSet = statement.executeQuery();
            /* hämtar resultated från anropet */
            if (resultSet.next()) {
                /* 1 = IPadress, 2 = port */
                serverInfo = new String[]{resultSet.getString(1), resultSet.getString(2)};
                System.out.println(serverInfo[0] + " " + serverInfo[1]); // debugging
            }
            return serverInfo;
    }
}
