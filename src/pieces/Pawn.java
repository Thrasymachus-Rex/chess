package pieces;

public class Pawn extends Piece {

    boolean firstMove = true;

    public Pawn(int row, int col, boolean white) { super(row, col, white); }

    @Override
    public boolean isMoveLegal(int endRow, int endCol) {
        if(this.col!=endCol) return false; //can't move sideways except en passant and kill (implement later)
        if(this.white && endRow>=this.row || !this.white && endRow<=this.row) return false; //can't move backwards
        int steps = Math.abs(this.row-endRow);
        if(!firstMove && steps > 1 || firstMove && steps>2) return false;
        if(firstMove) firstMove = false;
        return true;
    }

    @Override
    public String toString() {
        if(white) return "wp";
        else return "bp";
    }
}
