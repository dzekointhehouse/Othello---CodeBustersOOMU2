package grupp01othello.controller;

import grupp01othello.view.BoardCell;
import grupp01othello.view.GameFrame;
import grupp01othello.view.GameBoard;
import javafx.stage.Stage;
import grupp01othello.model.*;

/**
 * Created by optimusprime on 2016-09-27.
 */
public class GameManager implements Runnable {

    GameFrame gameframe;

    PlayerManager managePlayers = new PlayerManager();
    GameGrid gamegrid = new GameGrid(); // Subject
    GameBoard gameboard = new GameBoard(gamegrid); // Observer

    Player player1, player2;

    // PlayerMoveHandler handler = new PlayerMoveHAndler();
    public GameManager(Stage primaryStage) {

        gameframe = new GameFrame(primaryStage);

    }

    private void setupGameBoard() {
        gameframe.setAllComponents(gameboard.getBoard());
        gameframe.showFrame();

    }

    public void run() {

        setupGameBoard();
        gamegrid.initiateGameGrid();
        player1 = managePlayers.getPlayerOne();
        gameboard.handleGameBoard(player1);

        //System.out.println(player1);
        player1.hasMadeMoveProperty().addListener(e -> {
            if(player1.hasMadeMoveProperty().get())
                handleMove(player1, gamegrid);
        });
        //player1.getMoveTest();
    }
    
    public void handleMove(Player player, GameGrid gameGrid){
        Move move = player.getMove();
        gamegrid.updateGameGrid(move, 1);
    }

}
