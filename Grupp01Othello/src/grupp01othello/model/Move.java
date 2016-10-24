/*
 * Denna klassen är till för att kunna skicka koordinaterna för spel matrisen, mellan 
 * olika klasser som behöver bearbeta rad och kolumn. Objekt-orientering används istället
 * för att skicka primitiva data typer.
 */
package grupp01othello.model;
//exit
/**
 *
 * @author optimusprime (Elvir Dzeko)
 */
public class Move {

    /* privata attribut som lagrar koordinater till matrisen */
    private int row, column;

    /* konstruktorn initialiserar detta objekt med koordinater. */
    public Move(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * setter metod för att ge detta objektet en nytt row värde.
     * @param row 
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * setter metod för att ge detta objektet en nytt column värde.
     * @param column 
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * Getter metod för row.
     * @return 
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Getter metod för column.
     * @return 
     */
    public int getColumn() {
        return this.column;
    }
}
