/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.ResultSet;

/**
 *
 * @author Markus
 */
public class OthelloClient {

    private int port = 6969;
    private String host;
    private DataInputStream fromServer;
    private DataOutputStream toServer;
    private Socket socket;

    /**
     * våran othelloclient som ansluter till servern
     *
     * @throws IOException
     */
    public OthelloClient() throws IOException {
        this.host = "localhost";

        connectToServer();

    }

    /**
     * Anslutnings metoden till servern
     *
     * @throws IOException
     */
    private void connectToServer() throws IOException {
        try {
            DatabaseManager db = new DatabaseManager();
            db.getData();
            socket = new Socket(host, port);
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Skickar meddelande till servern. */
    public void sendtoServer(int message) throws IOException {
        toServer.write(message);
        toServer.flush();
    }
    /* Läser retur värde från servern. */
    public int recieveFromServer() throws IOException {
        int answer = fromServer.read();
        return answer;
    }

}
