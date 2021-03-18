package pieces;

public abstract class Piece {

    int row, col;

    boolean white;

    public Piece(int row, int col, boolean white) {
        this.row = row;
        this.col = col;
        this.white = white;
    }

    public boolean isWhite() {
        return white;
    }

    public void setCoordinates(int row, int col){
        this.row = row;
        this.col = col;
    }

    public abstract boolean isMoveLegal(int endRow, int endCol);

}
