package pieces;

public class Queen extends Piece {

    public Queen(int row, int col, boolean white) { super(row, col, white); }

    @Override
    public boolean isMoveLegal(int endRow, int endCol) {
        return false;
    }

    @Override
    public String toString() {
        if(white) return "wQ";
        else return "bQ";
    }
}
