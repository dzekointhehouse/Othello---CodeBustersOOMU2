/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.model;

import grupp01othello.view.GridObserver;
import java.util.ArrayList;

/**
 *
 * @author Markus, Elvir
 */
public class GameGrid implements Subject {

    private final int SIZE = 8;
    private int[][] grid;
    private ArrayList<GridObserver> observer;
    ArrayList<Move> allLegalMoves;

    public GameGrid() {
        grid = new int[SIZE][SIZE];
        observer = new ArrayList<GridObserver>();
        allLegalMoves = new ArrayList<>();

    }

    /**
     * initialiserar game griden till rätt storlek och med de fyra första
     * pjäserna anpassat för othello
     */
    public void initiateGameGrid() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                grid[row][col] = 0;
            }

        }
        grid[3][3] = 1;
        grid[3][4] = 2;
        grid[4][4] = 1;
        grid[4][3] = 2;

        notifyObserver(); // notifierar observer så GUIn får start pjäserna.
    }

    /**
     * boardIsFull loopar genom alla platser i matrisen och returnerar true om
     * hela matrisen är full med spelpjäser
     */
    boolean boardIsFull() {
        int flag = 0;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (grid[row][col] != 0) {
                    flag = 1;
                }
            }
            if (flag == 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * win metoden loopar genom hela matrisen och ökar 2 variablar beroende på
     * om den träffar på en svart eller vit spelpjäs och den returnerar sedan
     * vilken som har mest antal spelpjäser av sin färg dvs. räknar ut vem som
     * har vunnit
     */
    int win() {
        int black = 0, white = 0;
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (grid[x][y] != 0) {
                    if (grid[x][y] == 1) {
                        black += 1;
                    } else {
                        white += 1;
                    }
                }
            }
        }
        if (black > white) {
            return black;
        }

        return white;
    }

    @Override
    public void register(GridObserver newObserver) {

        observer.add(newObserver);
    }

    @Override
    public void unregister(GridObserver deleteObserver) {

        observer.remove(deleteObserver);

    }

    @Override
    public void notifyObserver() {

        for (GridObserver observer : observer) {

            observer.update(grid); // skickar uppdaterade spel griden till observers.
        }
    }

    public void playMove(Move move, int playerID) {

        processMove(playerID, move.getRow(), move.getColumn());
        notifyObserver();
    }

    public void processMove(int player, int row, int col) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                flipChip(player, row + i, col + j, i, j);
            }
        }
        grid[row][col] = player;
        notifyObserver();
    }

    private boolean flipChip(int colour, int row, int col, int nextRow, int nextCol) {
        if ((row < 0) || (col < 0) || (row >= 8) || (col >= 8)) {
            return false;
        }
        if (grid[row][col] == 0) {
            return false;
        }
        if ((grid[row][col] == colour)) {
            if (grid[row - nextRow][col - nextCol] != 0 ) {
                return true;
            } else {
                return false;
            }
        }
        if (flipChip(colour, row + nextRow, col + nextCol, nextRow, nextCol)) {
            grid[row][col] = colour;
            return true;
        } else {
            return false;
        }
    }

    public boolean legalMove(int playerID, int row, int col) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (isLegalPath(playerID, row + i, col + j, i, j)) {
                    System.out.println(row + " " + col);
                    return true;
                }
            }
        }
        return false;

    }

    private boolean isLegalPath(int colour, int row, int col, int nextRow, int nextCol) {
        if ((row < 0) || (col < 0) || (row >= 8) || (col >= 8)) {
            return false;
        }
        if (grid[row][col] == 0) {
            return false;
        }
        if ((grid[row][col] == colour)) {
            if (grid[row - nextRow][col - nextCol] != 0) {
                return true;
            } else {
                return false;
            }
        }
        if (flipChip(colour, row + nextRow, col + nextCol, nextRow, nextCol)) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Move> GetAllLegalMoves(int playerID) {

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (grid[row][col] == 0) { // så algoritmen inte testar sätta in från "existerande" pjäser.
                    if (legalMove(playerID, row, col)) {
                        allLegalMoves.add(new Move(row, col));
                    }
                }

            }
        }
        return allLegalMoves;
    }

}
