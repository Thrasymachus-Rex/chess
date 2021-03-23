package pieces;

public class Queen extends Piece {

    public Queen(int row, int col, boolean white) {
        super(row, col, white);
    }

    @Override
    public boolean isMoveLegal(int endRow, int endCol, Piece[][] board) {
        Rook rook = new Rook(this.row, this.col, this.white);
        Bishop bishop = new Bishop(this.row, this.col, this.white);
        return (rook.isMoveLegal(endRow, endCol, board) || bishop.isMoveLegal(endRow, endCol, board));
    }

    @Override
    public String toString() {
        if (white) return "wQ";
        else return "bQ";
    }
}