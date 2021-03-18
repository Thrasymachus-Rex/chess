package pieces;

public class Bishop extends Piece {

    public Bishop(int row, int col, boolean white) { super(row, col, white); }

    @Override
    public boolean isMoveLegal(int endRow, int endCol) {
        return false;
    }

    @Override
    public String toString() {
        if(white) return "wB";
        else return "bB";
    }
}
