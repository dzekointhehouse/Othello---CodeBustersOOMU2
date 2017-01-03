/*
 * Mer abstraktion skulle kunna göras med gamegriden, separera griden och regler skulle nog kunna gå
 * men fokus ligger på annat pga tidspress.
 */
package grupp01othello.model;

import grupp01othello.view.GridObserver;
import java.util.ArrayList;

/**
 *
 * @author Markus, Elvir
 */
public class OthelloGrid implements GameGrid {

    private final int SIZE;
    private int usedTiles = 4;
    private int[][] grid;
    private ArrayList<GridObserver> observers;

    /* Konstruktor */
    public OthelloGrid(int size) {
        SIZE = size;
        grid = new int[SIZE][SIZE];
        observers = new ArrayList<GridObserver>();

    }

    /**
     * initialiserar game griden till rätt storlek och med de fyra första
     * brickorna insatta, anpassat för othello.
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
       // displayGrid();
        notifyObserver(); // notifierar observer så GUIn får start pjäserna.
    }

    /**
     * metoden jämför om fullboard är lika med storleken på brädan.
     *
     * @return true om brädan är full, annars false.
     */
    public boolean boardIsFull() {
        return (usedTiles >= SIZE * SIZE);

    }

    /**
     * getWinner metoden loopar genom hela matrisen och ökar 2 variablar
     * beroende på om den träffar på en svart eller vit spelpjäs och den
     * returnerar sedan vilken som har mest antal spelpjäser av sin färg dvs,
     * räknar ut vem som har vunnit, såklart är getWinner ett mer intuitivt namn
     * än win :)
     *
     * @return
     */
    public String getWinner() {
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
            return "black";
        } else if (white > black) {
            return "white";
        }
        return "draw";
    }

    @Override
    public void register(GridObserver newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void unregister(GridObserver deleteObserver) {
        observers.remove(deleteObserver);

    }

    @Override
    public void notifyObserver() {

        for (GridObserver observer : observers) {
            observer.updateGrid(this.grid); // skickar uppdaterade spel griden till observers.
        }
    }

    /**
     * Utför draget som fås av en spelare i gamemanager på othellogriden, och
     * notifierar observern så att GUIn uppdateras.
     *
     * @param move
     * @param markerID
     */
    public void playMove(Move move, int markerID) {
        if ((move.getRow() >= 0) && (move.getColumn() >= 0)) {
            usedTiles++;
            processMove(markerID, move.getRow(), move.getColumn());
        }
       // displayGrid();
        notifyObserver();
    }

    /**
     * processMove ör huvudmetoden för att vända de markörer som skall vändas
     * när spelaren har gjort sitt drag, metoden tar in spelarens markörID och
     * placeringen av markören.
     *
     * @param markerID
     * @param row
     * @param col
     */
    public void processMove(int markerID, int row, int col) {
        /* Loopar åt alla riktninger från spelarens markör.*/
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                processPath(markerID, row + i, col + j, i, j);
            }
        }
        /* När de andra markörerna har ändrats så ändrar vi också där spelaren la sin*/
        grid[row][col] = markerID;
    }

    /**
     * Processerar en specific riktning, och vänder till spelarens markörID
     * enligt othellos spelregler.
     *
     * @param markerID
     * @param row
     * @param col
     * @param nextRow
     * @param nextCol
     * @return om riktningen är giltig.
     */
    private boolean processPath(int markerID, int row, int col, int nextRow, int nextCol) {
        if ((row < 0) || (col < 0) || (row >= SIZE) || (col >= SIZE)) {
            return false;
        }
        if (grid[row][col] == 0) {
            return false;
        }
        if ((grid[row][col] == markerID)) {
            if (grid[row - nextRow][col - nextCol] != 0) {
                return true;
            } else {
                return false;
            }
        }
        if (processPath(markerID, row + nextRow, col + nextCol, nextRow, nextCol)) {
            /* om riktningen visar sig vara giltig så vänder vi brickorna på tillbakavägen */
            grid[row][col] = markerID;
            return true;
        } else {
            return false;
        }
    }

    /**
     * legalMove startar den rekursiva processen att kolla om det är lagligt för
     * spelaren att lägga en spelbricka på den platsen som får som in parameter.
     *
     * @param markerID
     * @param row
     * @param col
     * @return om draget är giltigt.
     */
    public boolean legalMove(int markerID, int row, int col) {
        /* Loopar åt alla riktninger från spelarens markör.*/
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                /* Om en väg är riktigt så räcker det för att returnera true */
                if (isLegalPath(markerID, row + i, col + j, i, j)) {
                    //System.out.println(row + " " + col);
                    return true;
                }
            }
        }
        return false;

    }

    /**
     * Metoden fungerar som processPath, fast den kollar om riktningen är giltig
     * utan att vända brickorna.
     *
     * @param markerID
     * @param row
     * @param col
     * @param nextRow
     * @param nextCol
     * @return boolean om riktningen är giltig.
     */
    private boolean isLegalPath(int markerID, int row, int col, int nextRow, int nextCol) {
        /* så vi inte hamnar utanför spelbrädan */
        if ((row < 0) || (col < 0) || (row >= 8) || (col >= 8)) {
            return false;
        }
        /* om vi kommer till en "tom" plats */
        if (grid[row][col] == 0) {
            return false;
        }
        /* Kollar så att den föregående markören är likadan och inte tom. När vi stöter på
           en markör som är likadan som spelarens i slutet så kommer vi få att det är en giltigt väg. */
        if ((grid[row][col] == markerID)) {
            if (grid[row - nextRow][col - nextCol] != 0) {
                return true;
            } else {
                return false;
            }
        }
        /* vi ökar row och col och flyttar ett steg hela tiden och så flyttar vi så rekursivt 
           och om den sista är sann så är det en giltig väg, annars ej. */
        if (isLegalPath(markerID, row + nextRow, col + nextCol, nextRow, nextCol)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Hämtar alla lagliga drag för spelaren som skickas in som parameter till
     * metoden, alla drag lagras i en arraylist av typen Move.
     *
     * @param markerID
     * @return en arraylist med lagliga drag.
     */
    public ArrayList<Move> getLegalMoves(int markerID) {

        ArrayList<Move> legalmoves = new ArrayList<Move>();

        /* Loopar igenom griden */
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (grid[row][col] == 0) { // så algoritmen inte testar sätta in från "existerande" pjäser.
                    if (legalMove(markerID, row, col)) {
                        legalmoves.add(new Move(row, col));
                    }
                }

            }
        }
        return legalmoves;
    }

    @Override
    public int[][] getGrid() {
        return this.grid;
    }

    /**
     * Denna metod skickar tillbaka en sträng med antal markörer för vardera
     * spelare.
     *
     * @return
     */
    public String scoreBoard() {
        int black = 0, white = 0;
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (grid[x][y] == 1) {
                    black += 1;
                }
                if ((grid[x][y] == 2)) {
                    white += 1;
                }
            }
        }
        String Score = "Black pieces: " + black
                + "\nWhite pieces: " + white;
        return Score;
    }

    /**
     * För att debugga.
     */
    public void displayGrid() {
        for (int row = 0; row < SIZE; row++) {
            System.out.print("\n" + row + ": ");
            for (int col = 0; col < SIZE; col++) {
                System.out.print(grid[row][col] + " ");
            }

        }
    }
}
