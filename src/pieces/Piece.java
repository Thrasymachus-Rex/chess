package pieces;

/**
 * An abstract class that describes a generic chess pieces
 *
 * @author Sreekar Vedula
 * @author Quan Li
 */
public abstract class Piece {

    int row, col;

    boolean white;

    /**
     * Creates a new piece object with the specified parameters
     *
     * @param row   The row of the piece on the chess board
     * @param col   The column of the piece on the chess board
     * @param white True if the piece is white, false if black
     */
    public Piece(int row, int col, boolean white) {
        this.row = row;
        this.col = col;
        this.white = white;
    }

    /**
     * Gets the color of the current piece
     *
     * @return True if white, false if black
     */
    public boolean isWhite() {
        return white;
    }

    /**
     * Updates the row and column fields of the piece
     *
     * @param row The current row
     * @param col The current column
     */
    public void setCoordinates(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Gets the current row
     *
     * @return Row on board from 1-8
     */
    public int getRow() {
        return row;
    }

    /**
     * Gets the current column
     *
     * @return Column on board from 1-8
     */
    public int getCol() {
        return col;
    }

    /**
     * Determines whether the specified move is legal for the piece type
     *
     * @param endRow The destination row of the move
     * @param endCol The destination column of the move
     * @param board  The game board which holds all the pieces
     * @return True if the move is legal, false if illegal
     */
    public abstract boolean isMoveLegal(int endRow, int endCol, Piece[][] board);

}
