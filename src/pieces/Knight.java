package pieces;

/**
 * The Knight class extends the Piece class
 *
 * @author Sreekar Vedula
 * @author Quan Li
 */
public class Knight extends Piece {

    public Knight(int row, int col, boolean white) {
        super(row, col, white);
    }

    @Override
    public boolean isMoveLegal(int endRow, int endCol, Piece[][] board) {
        int y = Math.abs(this.row - endRow);
        int x = Math.abs(this.col - endCol);
        return x * y == 2;
    }

    @Override
    public String toString() {
        if (white) return "wN";
        else return "bN";
    }
}