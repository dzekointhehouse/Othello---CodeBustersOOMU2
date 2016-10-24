package grupp01othello.controller;

import grupp01othello.model.players.Player;
import grupp01othello.view.GameFrame;
import grupp01othello.view.GameBoard;
import javafx.stage.Stage;
import grupp01othello.model.*;
import grupp01othello.model.players.HumanPlayer;
import javafx.application.Platform;
/**
 * Created by optimusprime (Elvir) on 2016-09-27.
 */
public class GameManager implements Runnable {
    Object key = new Object();
    GameFrame gameframe;


    GameGrid gamegrid = new GameGrid(); // Subject
    GameBoard gameboard = new GameBoard(gamegrid); // Observer
    int gameTurn = 0;
    PlayerFactory managePlayers = new PlayerFactory(gamegrid, gameboard);
    Player player1, player2;

    // PlayerMoveHandler handler = new PlayerMoveHAndler();
    public GameManager(Stage primaryStage) {

      
        gameframe = new GameFrame(primaryStage);

    }

    private void setupGameBoard() {
        gameframe.setAllComponents(gameboard.getBoard());
        gameframe.showFrame();

    }
    //@Override
    public void run() {
        
        try {
            setupGameBoard();
            gamegrid.initiateGameGrid();
            player1 = managePlayers.getPlayerOne();
            player2 = managePlayers.getPlayerTwo();
            
            playerTurn(player1, player2);
          
        } catch (Exception e) {

        }
    }

    public void handleMove(Player player) {
        // jag vill skapa en tråd här
        Move move = player.getMove();
        
        Platform.runLater(new Runnable() {

            public void run() {
                gamegrid.playMove(move, player.markerID);
            }
        });

    }

    /**
     * Denna metod skiftar spelarnas tur, spelaren som skickas
     * som första parameter är den som väntar på draget från användaren.
     * @param player
     * @param player2 
     */
    public void playerTurn(Player player, Player player2) {

        new Thread(new Runnable() {

            public void run() {
                    System.out.println("innei  ny tråd");
                int i = 0;
                while (true) {
                    if (i % 2 == 0) {                       
                        handleMove(player);
                        i++;
                    } else {
                        handleMove(player2);
                        i++;
                    }
                }
            }
        }).start();

    }
}
