/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.server;

import grupp01othello.controller.ExitHandler;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Markus
 */
public class OthelloClient {

    private int port;
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

        connectToServer();

    }

    /**
     * Anslutnings metoden till servern, skapar in- och
     * ut strömmar.
     *
     * @throws IOException
     */
    private void connectToServer() throws IOException {
        try {
            /* hämtar server informationen genom den lagrade proceduren */
            String[] serverInfo = DatabaseManager.getServerConnectionDetails(2);
            host = serverInfo[0];
            port = Integer.parseInt(serverInfo[1]);
            /* Ansluter till servern*/
            socket = new Socket(host, port);
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            /* Stänger av om inte uppkopplingen fungerar */
            e.printStackTrace();
            new ExitHandler().exit();
        }
    }

    /**
     * skickar meddelande av typen int 
     * till servern.
     * @param message
     * @throws IOException 
     */
    public void sendtoServer(int message) throws IOException {
        toServer.write(message);
        toServer.flush();
    }
   
    /**
     * tar emot meddelande av typen int
     * från servern.
     * @return
     * @throws IOException 
     */
    public int recieveFromServer() throws IOException {
        int answer = fromServer.read();
        return answer;
    }

}
