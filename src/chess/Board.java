package chess;

import pieces.*;

public class Board {

    Piece[][] board;
    King whiteKing;
    King blackKing;
    Piece checkPiece;
    Piece enPassant;

    public Board() {

        board = new Piece[8][8];

        board[0][0] = new Rook(0, 0, false);
        board[0][1] = new Knight(0, 1, false);
        board[0][2] = new Bishop(0, 2, false);
        board[0][3] = new Queen(0, 3, false);
        board[0][4] = new King(0, 4, false);
        board[0][5] = new Bishop(0, 5, false);
        board[0][6] = new Knight(0, 6, false);
        board[0][7] = new Rook(0, 7, false);

        board[7][0] = new Rook(7, 0, true);
        board[7][1] = new Knight(7, 1, true);
        board[7][2] = new Bishop(7, 2, true);
        board[7][3] = new Queen(7, 3, true);
        board[7][4] = new King(7, 4, true);
        board[7][5] = new Bishop(7, 5, true);
        board[7][6] = new Knight(7, 6, true);
        board[7][7] = new Rook(7, 7, true);

        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(1, i, false);
            board[6][i] = new Pawn(6, i, true);
        }

        whiteKing = (King) board[7][4];
        blackKing = (King) board[0][4];

    }

    public void printBoard() {
        System.out.println();
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (board[r][c] != null) System.out.print(board[r][c] + " ");
                else if (c % 2 != r % 2) System.out.print("## ");
                else System.out.print("   ");
            }
            System.out.println(8 - r);
        }
        System.out.println(" a  b  c  d  e  f  g  h\n");

    }

    public boolean movePiece(String[] input, boolean turn) {
        int startRow, startCol, endRow, endCol;
        if (input.length == 4) {
            startRow = Integer.parseInt(input[0]);
            startCol = Integer.parseInt(input[1]);
            endRow = Integer.parseInt(input[2]);
            endCol = Integer.parseInt(input[3]);
        } else {
            startCol = input[0].charAt(0) - 'a';
            startRow = 7 - (input[0].charAt(1) - '1');
            endCol = input[1].charAt(0) - 'a';
            endRow = 7 - (input[1].charAt(1) - '1');
        }

        if (board[startRow][startCol] == null) return false; // no piece to move from start
        if (startRow == endRow && startCol == endCol) return false; // can't move to same location !!
        if (board[startRow][startCol].isWhite() != turn) return false; // check if input is of opposite team

        if (!board[startRow][startCol].isMoveLegal(endRow, endCol, board))
            return false; //check if move is valid for piece type

        if (board[endRow][endCol] == null && enPassant == null && board[startRow][startCol] instanceof Pawn && startCol != endCol)
            return false;
        if (board[startRow][startCol] instanceof Pawn && board[endRow][endCol] == null && enPassant != null && Math.abs(endRow - startRow) == 1 && Math.abs(endCol - startCol) == 1 && (enPassant.getRow() != startRow || enPassant.isWhite() == board[startRow][startCol].isWhite() || enPassant.getCol() != endCol))
            return false;

        if (!isCheck(turn) && board[startRow][startCol] instanceof King && Math.abs(endCol - startCol) > 1 && input.length != 4) {
            if (endCol == 6) endCol = 7;
            if (endCol == 2) endCol = 0;
            for (int c = Math.min(startCol, endCol) + 1; c < Math.max(startCol, endCol); c++) {
                board[endRow][c] = board[startRow][startCol];
                board[endRow][c].setCoordinates(endRow, c);
                board[startRow][startCol] = null;
                if (isCheck(turn)) {
                    board[startRow][startCol] = board[endRow][c];
                    board[startRow][startCol].setCoordinates(startRow, startCol);
                    board[endRow][c] = null;
                    return false;
                }
                board[startRow][startCol] = board[endRow][c];
                board[startRow][startCol].setCoordinates(startRow, startCol);
                board[endRow][c] = null;
            }
            Rook rook = (Rook) board[endRow][endCol];
            rook.setMoved(true);
            King king = ((King) board[startRow][startCol]);
            king.setMoved(true);

            board[startRow][startCol] = null;
            board[endRow][endCol] = null;

            int kingCol = endCol == 7 ? 6 : 2;
            int rookCol = endCol == 7 ? 5 : 3;

            king.setCoordinates(endRow, kingCol);
            rook.setCoordinates(endRow, rookCol);
            board[endRow][kingCol] = king;
            board[endRow][rookCol] = rook;
            enPassant = null;
            printBoard();
            return true;
        } else if (board[endRow][endCol] == null || board[endRow][endCol].isWhite() != turn) {
            Piece temp = board[endRow][endCol];
            if (board[startRow][startCol] instanceof Pawn && enPassant != null && enPassant.getRow() == startRow && enPassant.isWhite() != board[startRow][startCol].isWhite() && enPassant.getCol() == endCol) {
                board[enPassant.getRow()][enPassant.getCol()] = null;
                enPassant = null;
            }
            board[endRow][endCol] = board[startRow][startCol];
            board[startRow][startCol] = null;
            if ((endRow == 7 || endRow == 0) && board[endRow][endCol] instanceof Pawn && input.length != 4) {
                if (input.length == 3) {
                    char promo = input[2].charAt(0);
                    switch (promo) {
                        case 'R':
                            board[endRow][endCol] = new Rook(endRow, endCol, turn);
                            break;
                        case 'N':
                            board[endRow][endCol] = new Knight(endRow, endCol, turn);
                            break;
                        case 'B':
                            board[endRow][endCol] = new Bishop(endRow, endCol, turn);
                            break;
                        default:
                            board[endRow][endCol] = new Queen(endRow, endCol, turn);
                            break;
                    }
                } else board[endRow][endCol] = new Queen(endRow, endCol, turn);
            }
            board[endRow][endCol].setCoordinates(endRow, endCol);

            if (input.length == 4 && !isCheck(turn)) {
                board[startRow][startCol] = board[endRow][endCol];
                board[endRow][endCol] = temp;
                board[startRow][startCol].setCoordinates(startRow, startCol);
                return true;
            }

            if (isCheck(turn)) {
                board[startRow][startCol] = board[endRow][endCol];
                board[endRow][endCol] = temp;
                board[startRow][startCol].setCoordinates(startRow, startCol);
                return false;
            }

            if (board[endRow][endCol] instanceof Rook) ((Rook) board[endRow][endCol]).setMoved(true);
            else if (board[endRow][endCol] instanceof King) ((King) board[endRow][endCol]).setMoved(true);
            else if (board[endRow][endCol] instanceof Pawn) ((Pawn) board[endRow][endCol]).setFirstMove(false);

            if (board[endRow][endCol] instanceof Pawn && Math.abs(startRow - endRow) == 2)
                enPassant = board[endRow][endCol];
            else enPassant = null;

            if (input.length != 4) printBoard();
            return true;
        }

        return false;
    }

    public boolean isCheck(boolean white) {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (board[r][c] != null && board[r][c].isWhite() != white && (white ? board[r][c].isMoveLegal(whiteKing.getRow(), whiteKing.getCol(), board) : board[r][c].isMoveLegal(blackKing.getRow(), blackKing.getCol(), board))) {
                    checkPiece = board[r][c];
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCheckMate(boolean white) {
        if (!isCheck(white)) return false;

        King king = white ? whiteKing : blackKing;

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (movePiece(new String[]{String.valueOf(king.getRow()), String.valueOf(king.getCol()), String.valueOf(r), String.valueOf(c)}, white))
                    return false;
                if (board[r][c] != null && board[r][c].isWhite() == white && board[r][c].isMoveLegal(checkPiece.getRow(), checkPiece.getCol(), board))
                    return false;

                for (int r2 = 0; r2 < 8; r2++) {
                    for (int c2 = 0; c2 < 8; c2++) {
                        if (board[r][c] != null && board[r][c].isWhite() == white && movePiece(new String[]{String.valueOf(r), String.valueOf(c), String.valueOf(r2), String.valueOf(c2)}, white))
                            return false;
                    }
                }

            }
        }

        return true;
    }

}
