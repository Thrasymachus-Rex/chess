package pieces;

public class Rook extends Piece {

    public Rook(int row, int col, boolean white) { super(row, col, white); }

    @Override
    public boolean isMoveLegal(int endRow, int endCol) {
        return false;
    }

    @Override
    public String toString() {
        if(white) return "wR";
        else return "bR";
    }
}
