package grupp01othello.controller;

import grupp01othello.view.BoardCell;
import grupp01othello.view.GameFrame;
import grupp01othello.view.GameBoard;
import javafx.stage.Stage;
import grupp01othello.model.*;

/**
 * Created by optimusprime (Elvir) on 2016-09-27.
 */
public class GameManager implements Runnable {

    GameFrame gameframe;

    PlayerFactory managePlayers = new PlayerFactory();
    GameGrid gamegrid = new GameGrid(); // Subject
    GameBoard gameboard = new GameBoard(gamegrid); // Observer
    int gameTurn = 0;
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
        player2 = managePlayers.getPlayerTwo();

        playerTurn(player1, player2);

    }

    public void handleMove(Player player, GameGrid gameGrid) {
        Move move = player.getMove();
        gamegrid.updateGameGrid(move, player.markerID);
    }
    
    /**
     * Denna metod skiftar spelarnas tur rekursivt, spelaren som skickas
     * som första parameter är den som väntar på draget från användaren.
     * @param player
     * @param player2 
     */
    public void playerTurn(Player player, Player player2) {
        
        /* Skickar spelaren till gameboard som mottagare när ett event sker */
        gameboard.handleGameBoard(player);
        
        /* hasMadeMoveProperty blir true när spelaren får row och column, sen hanteras draget och det blir nästa spelares tur */
        player.hasMadeMoveProperty().addListener(e -> {
            
            //Måste kolla så att det finns drag kvar att göra!!!!!
            if (player.hasMadeMoveProperty().get()) {
                handleMove(player, gamegrid);         
                playerTurn(player2, player);
            }
        });
    }

}
