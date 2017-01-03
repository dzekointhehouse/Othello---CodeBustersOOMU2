package grupp01othello.view;

import grupp01othello.controller.GameManager;
import grupp01othello.model.players.Player;
import javafx.scene.layout.GridPane;
import grupp01othello.model.GameGrid;
import grupp01othello.model.Move;
import java.util.ArrayList;

/**
 * Created by optimusprime (Elvir) on 2016-09-27.
 */
public class GameBoard implements GridObserver {

    private GridPane board;
    private final int SIZE;
    private BoardTile[][] tile;

    private GameGrid gamegrid;
    private GameManager gm;

    /* konstruktorn: tar in ett objekt att observera, och storleken på brädan */
    public GameBoard(GameManager gm, GameGrid gamegrid, int size) {

        SIZE = size;
        board = new GridPane();
        tile = new BoardTile[8][8];

        /* lägger till GameGrid instansen och registrerar sig på den som observer. */
        this.gamegrid = gamegrid;
        gamegrid.register(this);
        this.gm = gm;
        InitializeGameBoard();

    }

    /**
     * Initialiserar brädan, genom att lägga in en BoardTile i varje ruta, och
     * skickar med row och col. Vilket gör det lättare att referera till dem
     * senare. Här får också brädan sin rutiga charm.
     */
    private void InitializeGameBoard() {

        board.setMaxWidth(900);
        board.setMaxHeight(900);

        for (int row = 0; row < SIZE; row++) {

            for (int col = 0; col < SIZE; col++) {
                /* Vi skickar med en referens till gamemanager som hanterar event från BoardTile */
                board.add(tile[row][col] = new BoardTile(gm, row, col), col, row); //lägger in celler

                if ((row + col) % 2 == 0) {
                    tile[row][col].setStyle("-fx-background-color: rgba(255, 255, 255, 0.61)");
                } else {
                    tile[row][col].setStyle("-fx-background-color: rgba(0, 0, 0, 0.61)");
                }
            }
        }

        //board.setGridLinesVisible(false);
    }

    /**
     * retunerar brädan från denna instansen.
     *
     * @return GridPane
     */
    public GridPane getBoard() {
        return this.board;
    }

    /**
     * updateGrid uppdaterar GUIn när den underliggande observerade objektet
     * uppdateras. (då anropar den denna metod).
     *
     * @param gameGrid
     */
    public void updateGrid(int[][] gameGrid) {

        int[][] grid = gamegrid.getGrid();

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                /* Om cellen inte är tom, så tas brickan bort */
                if (!tile[row][col].getChildren().isEmpty()) {
                    tile[row][col].getChildren().clear();
                }
                tile[row][col].getChildren().add(tile[row][col].addPiece(grid[row][col]));
            }
        }
    }

    /**
     * Får in alla lagliga drag som parameter och lägger in en "bricka" som då
     * ska symbolisera att det draget är lagligt att göra i GUIn
     *
     * @param allPossibleMoves
     */
    public void showLegalMoves(ArrayList<Move> allPossibleMoves) {
        Move move;
        for (int i = 0; i < allPossibleMoves.size(); i++) {
            move = allPossibleMoves.get(i);
            int row = move.getRow();
            int col = move.getColumn();
            tile[row][col].getChildren().add(tile[row][col].addPiece(666));
        }
    }

}
