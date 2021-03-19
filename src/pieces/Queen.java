package pieces;

public class Queen extends Piece {

    public Queen(int row, int col, boolean white) { super(row, col, white); }

    @Override
    public boolean isMoveLegal(int endRow, int endCol) {
        boolean straight = this.row == endRow || this.col == endCol;
        int x = Math.abs(this.row - endRow);
        int y = Math.abs(this.col - endCol);
        boolean diagonal = (x == y);
        return (diagonal || straight);
    }

    @Override
    public String toString() {
        if(white) return "wQ";
        else return "bQ";
    }
}