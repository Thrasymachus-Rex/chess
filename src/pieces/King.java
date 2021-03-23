package pieces;

/**
 * The King class extends the Piece class
 *
 * @author Sreekar Vedula
 * @author Quan Li
 */
public class King extends Piece {

    boolean hasMoved = false;

    public King(int row, int col, boolean white) {
        super(row, col, white);
    }

    @Override
    public boolean isMoveLegal(int endRow, int endCol, Piece[][] board) {
        int y = Math.abs(this.row - endRow);
        int x = Math.abs(this.col - endCol);

        if (x == 2 && endCol == 6) endCol = 7;
        if (x == 2 && endCol == 2) endCol = 0;

        if (x == 2 && board[endRow][endCol] instanceof Rook && !this.hasMoved && !((Rook) board[endRow][endCol]).hasMoved()) {
            for (int c = Math.min(this.col, endCol) + 1; c < Math.max(this.col, endCol); c++) {
                if (board[endRow][c] != null) return false;
            }
            return true;
        }


        return x < 2 && y < 2;
    }

    /**
     * Setter for field that checks if king has moved from default position
     *
     * @param hasMoved False if king has moved from the initial position
     */
    public void setMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    @Override
    public String toString() {
        if (white) return "wK";
        else return "bK";
    }
}