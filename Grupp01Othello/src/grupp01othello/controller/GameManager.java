package grupp01othello.controller;

import grupp01othello.view.dialog.WinnerDialog;
import grupp01othello.model.players.Player;
import grupp01othello.view.GameFrame;
import grupp01othello.view.GameBoard;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import grupp01othello.model.*;
import grupp01othello.model.players.HumanPlayer;
import grupp01othello.view.BoardTile;
import grupp01othello.view.dialog.DrawDialog;
import javafx.application.Platform;
import javafx.scene.input.MouseEvent;

/**
 * Created by optimusprime (Elvir) on 2016-09-27.
 */
public class GameManager implements Runnable, EventHandler<MouseEvent> {

    private DrawDialog draw;
    private final WinnerDialog win;
    private final GameFrame gameframe;
    private final int SIZE = 8;
    private String winner, colorOfWinner;
    private final OthelloGrid gamegrid;
    private final GameBoard gameboard;
    private final PlayerFactory managePlayers;
    private Player player1, player2;
    private int activeplayer = 1;

    /* Konstruktor */
    public GameManager(Stage primaryStage) {
        this.win = new WinnerDialog();
        gameframe = new GameFrame(primaryStage);
        gamegrid = new OthelloGrid(SIZE); // Subject
        gameboard = new GameBoard(this, gamegrid, SIZE); // Observer
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
            /* skickar spelar namnen till Gameboard så att de kan visas för användaren */
            gameframe.setPlayerInfo(player1.getName(), player2.getName());
            executeGameTurns();

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
    private void handleMove(Player player) {

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
     * Denna metod exekverar spelets omgångar mellan spelarna.
     */
    private void executeGameTurns() {

        new Thread(() -> {

            while (true) {
                if (gamegrid.boardIsFull()) {
                    System.out.println("" + gamegrid.getWinner());

                    colorOfWinner = gamegrid.getWinner();
                    if (colorOfWinner == "Black") {
                        winner = player1.getName().toString();
                    } else {
                        winner = player2.getName().toString();

                    }
                    Platform.runLater(() -> {
                        if (!gamegrid.getWinner().equals("Draw")) {
                            win.winBox(winner);
                        }
                        draw.drawBox();

                    });

                    break;
                }
                /* hanteringen av spelaren */
                playerTurn();
            }
        }).start();

    }

    /**
     * Hämtar lagliga drag från gamegrid och skickar till gameboard så det visas
     * för användaren.
     *
     * @param player
     */
    private void showAvailableMoves(Player player) {
        Platform.runLater(() -> {
            gameboard.showLegalMoves(gamegrid.getLegalMoves(player.markerID));
        });
    }

    /**
     * Returnerar den aktiva spelaren.
     * @return aktiva spelaren
     */
    Player getActivePlayer() {
        switch (activeplayer) {
            case 1:
                return player1;
            case 2:
                return player2;
            default:
                return null;
        }
    }

    /**
     * Denna metoden utför den aktiva spelarens omgång och sätter nästa
     * aktiva spelaren, anrop för att visa lagliga drag, utförande av spelarens
     * drag och uppdatering av antet brickor vardera spelare har.
     */
    private void playerTurn() {
        Player player = getActivePlayer();
        gameframe.updateScore(gamegrid.scoreBoard());
        showAvailableMoves(player);
        handleMove(player);
        gameframe.updateScore(gamegrid.scoreBoard());
        /* Sätter den den aktiva spelaren för nästa turn */
        if (activeplayer == 1) {
            activeplayer = 2;
        } else {
            activeplayer = 1;
        }
    }

    /**
     * Hantering av event från mänskliga spelare
     * @param event 
     */
    public void handle(MouseEvent event) {
        /* Hämtar den aktiva spelaren som ska då 
           hantera eventet som fås från den clickade BoardTile instansen */
        Player player = getActivePlayer();

        /* Hanterar bara eventet om användaren är av typen HumanPlayer */
        if (player instanceof HumanPlayer) {
            /* hämtar source objektet som är en BoardTile och skickar dess plats till spelaren */
            BoardTile tile = (BoardTile) event.getSource();
            //System.out.println(tile.getRow() + tile.getCol());
            ((HumanPlayer) player).setMove(tile.getRow(), tile.getCol());
        } else {
            return;
        }
    }
}
