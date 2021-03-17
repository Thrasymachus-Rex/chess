package pieces;

public class King extends Piece {

    public King(int x, int y, boolean white) {
        super(x, y, white);
    }

    @Override
    public String toString() {
        if(white) return "wK";
        else return "bK";
    }
}
