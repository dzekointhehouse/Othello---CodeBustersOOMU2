package grupp01othello.controller;

import grupp01othello.view.dialog.WinnerDialog;
import grupp01othello.model.players.Player;
import grupp01othello.view.GameFrame;
import grupp01othello.view.GameBoard;
import javafx.stage.Stage;
import grupp01othello.model.*;
import javafx.application.Platform;

/**
 * Created by optimusprime (Elvir) on 2016-09-27.
 */
public class GameManager implements Runnable {

    WinnerDialog win;
    GameFrame gameframe;
    private final int SIZE = 8;
    String winner;
    OthelloGrid gamegrid;
    GameBoard gameboard;
    PlayerFactory managePlayers;
    Player player1, player2;

    public GameManager(Stage primaryStage) {
        this.win = new WinnerDialog();
        gameframe = new GameFrame(primaryStage);
        gamegrid = new OthelloGrid(SIZE); // Subject
        gameboard = new GameBoard(gamegrid, SIZE); // Observer
        managePlayers = new PlayerFactory(gamegrid, gameboard);
    }

    private void setupGameBoard() {
        gameframe.setAllComponents(gameboard.getBoard());
        gameframe.showFrame();

    }

    @Override
    public void run() {

        try {
            setupGameBoard();
            gamegrid.initiateGameGrid();
            player1 = managePlayers.getPlayerOne();
            player2 = managePlayers.getPlayerTwo();

            playerTurn();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    /**
     * Denna metoden hanterar hämtningen av det lagliga draget och skickar det
     * vidare för att bearbetas.
     *
     * @param player
     */
    public void handleMove(Player player) {

        /* getMove hämtar draget från spelaren */
        Move move = player.getMove();

        /* När ett drag har gjorts så skall det exekveras på javaFX tråd,
           GUIn uppdateras när gamegrid uppdateras enligt observer mönstret. Det går
           också att skapa en ny tråd i gamegrid, varje gång GUIn ska uppdateras i gamegrid. */
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                /* uppdaterar griden, och därmed även alla observers */
                gamegrid.playMove(move, player.markerID);
            }
        });
    }

    /**
     * Denna metod skiftar spelarnas tur, spelaren som skickas som första
     * parameter är den som väntar på draget från användaren.
     */
    public void playerTurn() { //playgame istället? typ

        new Thread(() -> {

            int turns = 0;

            while (true) {
                if (gamegrid.boardIsFull()) {
                    System.out.println("" + gamegrid.win());
                    //anropa dialogen
                    Platform.runLater(() -> {
                        // dialogen ska skriva namnet ist inte färg.
                        win.winBox(gamegrid.win());
                    });

                    break;
                }
                if (turns % 2 == 0) {
                    showAvailableMoves(player1);
                    handleMove(player1);
                    turns++;
                } else {
                    showAvailableMoves(player2);
                    handleMove(player2);
                    turns++;
                }
            }
        }).start();

    }

    public void showAvailableMoves(Player player) {
        Platform.runLater(() -> {
            gameboard.showLegalMoves(gamegrid.getLegalMoves(player.markerID));
        });
    }
}
