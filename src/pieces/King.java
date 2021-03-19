package pieces;

public class King extends Piece {

    public King(int row, int col, boolean white) { super(row, col, white); }

    @Override
    public boolean isMoveLegal(int endRow, int endCol) {
        int x = Math.abs(this.row - endRow);
        int y = Math.abs(this.col - endCol);
        return (x<2 && y<2);
    }

    @Override
    public String toString() {
        if(white) return "wK";
        else return "bK";
    }
}