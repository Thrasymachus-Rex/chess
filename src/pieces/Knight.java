package pieces;

public class Knight extends Piece {

    public Knight(int row, int col, boolean white) { super(row, col, white); }

    @Override
    public boolean isMoveLegal(int endRow, int endCol) {
        return false;
    }

    @Override
    public String toString() {
        if(white) return "wN";
        else return "bN";
    }
}
