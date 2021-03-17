package pieces;

public class Queen extends Piece {

    public Queen(int x, int y, boolean white) {
        super(x, y, white);
    }

    @Override
    public String toString() {
        if(white) return "wQ";
        else return "bQ";
    }
}
