package pieces;

public class Bishop extends Piece {

    public Bishop(int x, int y, boolean white) {
        super(x, y, white);
    }

    @Override
    public String toString() {
        if(white) return "wB";
        else return "bB";
    }
}
