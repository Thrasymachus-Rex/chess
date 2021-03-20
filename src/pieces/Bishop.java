package pieces;

public class Bishop extends Piece {

    public Bishop(int row, int col, boolean white) { super(row, col, white); }

    @Override
    public boolean isMoveLegal(int endRow, int endCol, Piece[][] board) {
        int x = Math.abs(this.row - endRow);
        int y = Math.abs(this.col - endCol);
        if(x!=y) return false;

        int r = this.row, c = this.col;

        while (r != endRow || c != endCol) {
            if (endRow - r > 0) r++;
            else r--;
            if (endCol - c > 0) c++;
            else c--;
            if (r==endRow && c==endCol) break;
            if (board[r][c] != null) return false;
        }

        return true;
    }

    @Override
    public String toString() {
        if(white) return "wB";
        else return "bB";
    }
}
