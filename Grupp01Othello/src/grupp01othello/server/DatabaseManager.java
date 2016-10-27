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

    String sqlConnectionUrl = "jdbc:sqlserver://hitsql-db.hb.se:56077;database=oomuht1601;user=oomuht1601;password=plux66";
    static ResultSet resultSet;
    static Statement statement;
    static Connection connection;
    static DatabaseMetaData metaData;

    public DatabaseManager() throws SQLException, ClassNotFoundException, UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        initializeDatabase();
        ipAddress = inetAddress.getHostAddress();
        portNr = "6969";
        groupID = "02";

        initializeDatabase();
        if (!getMetaData()) {
            createTable();
            insertToTable();
        } else {
            String updateStatement = "UPDATE OnlinePlayers SET groupID = '" + groupID + "', ipAddress = '" + ipAddress + "', port = '" + portNr + "' WHERE groupID = '02'";
            statement.executeUpdate(updateStatement);
            //update
        }

        connection.close(); // Close the connection
    }

    /**
     * Initierar våran databas
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void initializeDatabase() throws SQLException, ClassNotFoundException {
        connection = DriverManager.getConnection(sqlConnectionUrl);
        statement = connection.createStatement(); // Create a statement

    }

    public ResultSet getData() throws SQLException {
        resultSet = statement.executeQuery("select * from OnlinePlayers ");
// Iterera igenom och visa resultatet
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
        }
        return resultSet;
    }

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
     *
     * @throws SQLException
     */
 
    static public void createTable() throws SQLException {
        statement.executeUpdate("CREATE TABLE OnlinePlayers " + "( groupID VARCHAR(2) NOT NULL," + "ipAddress VARCHAR(30) NOT NULL," + "port VARCHAR(4) NOT NULL);");

    }

    /**
     * sätter in en ny rad i våran databas
     *
     * @throws SQLException
     */
    static public void insertToTable() throws SQLException {
        String insertStatement = "INSERT INTO OnlinePlayers VALUES ('" + groupID + "', '" + ipAddress + "', '" + portNr + "')";
        statement.executeUpdate(insertStatement);

    }
}