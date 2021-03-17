package pieces;

public class Rook extends Piece {

    public Rook(int x, int y, boolean white) { super(x, y, white); }

    @Override
    public String toString() {
        if(white) return "wR";
        else return "bR";
    }
}
