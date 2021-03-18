package pieces;

public class King extends Piece {

    public King(int row, int col, boolean white) { super(row, col, white); }

    @Override
    public boolean isMoveLegal(int endRow, int endCol) {
        return false;
    }

    @Override
    public String toString() {
        if(white) return "wK";
        else return "bK";
    }
}
