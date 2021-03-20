package pieces;

public class Rook extends Piece {

    public Rook(int row, int col, boolean white) { super(row, col, white); }

    @Override
    public boolean isMoveLegal(int endRow, int endCol, Piece[][] board) {

        if(!(this.row == endRow || this.col == endCol)) return false;

        if(this.row==endRow) {
            for(int c = Math.min(this.col,endCol)+1;c<Math.max(this.col, endCol);c++){
                if(board[this.row][c]!=null) return false;
            }
        }

        else {
            for(int r = Math.min(this.row,endRow)+1;r<Math.max(this.row, endRow);r++){
                if(board[r][this.col]!=null) return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        if(white) return "wR";
        else return "bR";
    }
}