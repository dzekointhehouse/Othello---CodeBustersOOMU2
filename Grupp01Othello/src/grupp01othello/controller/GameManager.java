package grupp01othello.controller;

import grupp01othello.view.GameFrame;
import grupp01othello.view.GameBoard;
import javafx.stage.Stage;
import grupp01othello.model.*;

import static grupp01othello.view.setUpGameDialog.infoBox;

/**
 * Created by optimusprime on 2016-09-27.
 */
public class GameManager {

    String player;
    static HumanPlayer Player1;
    
    GameFrame gameframe;

    GameGrid gamegrid = new GameGrid(); // Subject
    GameBoard gameboard = new GameBoard(gamegrid); // Observer

    public GameManager(Stage primaryStage) {
        this.Player1 = new HumanPlayer();
        gameframe = new GameFrame(primaryStage);
        
    }

    private void setupGameBoard() {
        gameframe.setAllComponents(gameboard.getBoard());
        gameframe.showFrame();

    }

    public void run() {

        player = infoBox();
        setupGameBoard();
        this.gamegrid.initiateGameGrid();
        this.gamegrid.updateGameGrid(3, 4, 0); //uppdaterar gamegrid med dessa värden

    }

    /* Handle a mouse click event */
    public static void handleMouseClick(int row, int col) {

        // 1. isLegal - om den valda rutan är laglig - > setNextMove(row,col);
        // 2. getNextMove
        // 3. skicka det till griden?.. uppdatera board.
        System.out.println("row:" + row + "col:" + col);

       // Player1.getMove(row, col, grid);

    }

}
