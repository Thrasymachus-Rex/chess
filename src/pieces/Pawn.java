package pieces;

public class Pawn extends Piece {

    boolean firstMove = true;
    boolean enpassant = false;

    public Pawn(int row, int col, boolean white) { super(row, col, white); }

    @Override
    public boolean isMoveLegal(int endRow, int endCol, Piece[][] board) {
        if (this.white && endRow >= this.row || !this.white && endRow <= this.row) return false; //can't move backwards
        int steps = Math.abs(this.row - endRow);
        if (Math.abs(endCol - this.col) == 1 && steps == 1 && board[endRow][endCol] != null) return true; //kill
        if (((this.row == 3 && white) || (this.row == 4 && !white)) && Math.abs(endCol - this.col) == 1 && steps == 1 && board[endRow][endCol] == null && (board[endRow + 1][endCol] instanceof Pawn || board[endRow - 1][endCol] instanceof Pawn))
            return true;
        if (this.col != endCol) return false; //can't move sideways except enpassant and kill
        if (!firstMove && steps > 1 || firstMove && steps > 2) return false;
        if (board[endRow][this.col] != null) return false; //cant kill straight
        if (steps == 2 && board[(this.row + endRow) / 2][this.col] != null) return false; //cant jump over piece
        return true;
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

    @Override
    public String toString() {
        if (white) return "wp";
        else return "bp";
    }
}
