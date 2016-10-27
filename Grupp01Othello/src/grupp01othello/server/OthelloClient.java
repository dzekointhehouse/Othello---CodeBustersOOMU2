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
import java.util.Random;

/**
 *
 * @author Markus
 */
public class OthelloClient {

    int port = 6969;
    String host = "localhost";
    DataInputStream fromServer;
    DataOutputStream toServer;
    Socket socket;

    /**
     * våran othelloclient som ansluter till servern
     *
     * @throws IOException
     */
    public OthelloClient() throws IOException {

        connectToServer();

    }
/**
 * Anslutnings metoden till servern
 * @throws IOException 
 */
    private void connectToServer() throws IOException {
        try {
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
            socket = new Socket(host, port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
