package grupp01othello.controller;

import grupp01othello.view.GameFrame;
import grupp01othello.view.GameBoard;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import grupp01othello.model.*;
import static grupp01othello.view.setUpGameDialog.infoBox;


/**
 * Created by optimusprime on 2016-09-27.
 */
public class GameManager implements EventHandler<MouseEvent> {

    GameFrame othelloFrame;
    GameBoard othelloBoard;
    String player;
    static HumanPlayer Player1;
    static GameGrid grid;
    public GameManager(Stage primaryStage) {
        this.Player1 = new HumanPlayer();
       othelloFrame = new GameFrame(primaryStage);
        othelloBoard = new GameBoard();
         grid = new GameGrid();
    }

    private void setupGameBoard(){
        othelloFrame.setAllComponents(othelloBoard.getBoard());
        othelloFrame.InitializeMainFrame();

    }
    
    public void run(){
        
    setupGameBoard();
    player = infoBox();
    
    this.othelloFrame.btExit.setOnAction((ActionEvent e) -> {
    Platform.exit();});
    
    

    }
   
    
    /* Handle a mouse click event */
    public static void handleMouseClick(int row, int col) {
        System.out.println("row:"+row+"col:"+col);
        Player1.getMove(row,col, grid);
  
    }
//  
//        /**
//         * detta hanteras inte än på rätt sätt. men används nu för att testa
//         * programmet.
//         */
//        public void handleMouseClick() {
//
//            this.getChildren().add(setBrick(2));
//        }

    @Override
    public void handle(MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
