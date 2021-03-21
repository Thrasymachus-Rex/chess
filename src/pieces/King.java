package pieces;

public class King extends Piece {

    boolean hasMoved = false;

    public King(int row, int col, boolean white) { super(row, col, white); }

    @Override
    public boolean isMoveLegal(int endRow, int endCol, Piece[][] board) {
        int x = Math.abs(this.row - endRow);
        int y = Math.abs(this.col - endCol);

        if(board[endRow][endCol] instanceof Rook && !this.hasMoved && !((Rook)board[endRow][endCol]).hasMoved()){
            for(int c = Math.min(this.col,endCol)+1; c < Math.max(this.col,endCol); c++){
                if(board[endRow][c]!=null) return false;
            }
            return true;
        }


        if (x<2 && y<2) {
            hasMoved = true;
            return true;
        }

        return false;
    }

    public void setMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    @Override
    public String toString() {
        if(white) return "wK";
        else return "bK";
    }
}