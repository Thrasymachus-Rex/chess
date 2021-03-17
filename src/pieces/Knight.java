package pieces;

public class Knight extends Piece {

    public Knight(int x, int y, boolean white) {
        super(x, y, white);
    }

    @Override
    public String toString() {
        if(white) return "wN";
        else return "bN";
    }
}
