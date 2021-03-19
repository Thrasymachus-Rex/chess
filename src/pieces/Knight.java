package pieces;

public class Knight extends Piece {

    public Knight(int row, int col, boolean white) { super(row, col, white); }

    @Override
    public boolean isMoveLegal(int endRow, int endCol) {
        int x = Math.abs(this.row - endRow);
        int y = Math.abs(this.col - endCol);
        return x * y == 2;
    }

    @Override
    public String toString() {
        if(white) return "wN";
        else return "bN";
    }
}