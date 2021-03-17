package pieces;

public abstract class Piece {

    int x, y;

    boolean white;

    public Piece(int x, int y, boolean white) {
        this.x = x;
        this.y = y;
        this.white = white;
    }

}
