package pieces;

public class Pawn extends Piece {

    public Pawn(int x, int y, boolean white) {
        super(x, y, white);
    }

    @Override
    public String toString() {
        if(white) return "wp";
        else return "bp";
    }
}
