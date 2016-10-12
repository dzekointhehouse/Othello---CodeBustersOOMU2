package grupp01othello.controller;

import grupp01othello.view.GameFrame;
import grupp01othello.view.GameBoard;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import grupp01othello.model.*;
import static grupp01othello.view.setUpGameDialog.infoBox;


/**
 * Created by optimusprime on 2016-09-27.
 */
public class GameManager {

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
   }
   
    
    /* Handle a mouse click event */
    public static void handleMouseClick(int row, int col) {
        
        // 1. isLegal - om den valda rutan är laglig - > setNextMove(row,col);
        // 2. getNextMove
        // 3. skicka det till griden?.. uppdatera board.
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

}
