/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.server;

import grupp01othello.controller.GameManager;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import static javafx.application.Application.launch;

/**
 *
 * @author Markus
 */
public class Othelloserver {

    /**
     * Othelloserver, våran server för RemoteComputerPlayer
     */
    public class Server {

        int port = 6969;
        DataInputStream in;
        DataOutputStream out;
        ServerSocket server;
        Socket socket;

        public void Server() throws IOException {
            serverStartup();
        }

/**
 * Metoden serverStartup gör vad det låter som, den startar våran server.
 * @throws IOException 
 */     
      public void serverStartup() throws IOException{
            server = new ServerSocket(port);
            socket = server.accept();
            socket.getInetAddress().getHostAddress();
        
        }

        public int handleMove(/*något in, typ storleken av arrayen in här*/) {
            int drag = 0;
            Random move = new Random();
            drag = move.nextInt();
            return drag;
        }
    }

}
