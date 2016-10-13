package grupp01othello.controller;

import grupp01othello.view.GameFrame;
import grupp01othello.view.GameBoard;
import javafx.stage.Stage;
import grupp01othello.model.*;

/**
 * Created by optimusprime on 2016-09-27.
 */
public class GameManager implements Runnable {
   
    
    GameFrame gameframe;

    GameGrid gamegrid = new GameGrid(); // Subject
    GameBoard gameboard = new GameBoard(gamegrid); // Observer
    
   // PlayerMoveHandler handler = new PlayerMoveHAndler();
    public GameManager(Stage primaryStage) {
        this.Player1 = new HumanPlayer(1,"Markus");
        gameframe = new GameFrame(primaryStage);
         Player player1,player2;
    }

    private void setupGameBoard() {
        gameframe.setAllComponents(gameboard.getBoard());
        gameframe.showFrame();

    }
 

    public void run() {
        
        setupGameBoard();
        
        this.gamegrid.initiateGameGrid();
        //vänta på klickning.
        player1.getMove();
        // this.gamegrid.updateGameGrid(3, 4, 0); //uppdaterar gamegrid med dessa värden
        }

    }


