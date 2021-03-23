package chess;

import java.util.Scanner;

public class Chess {

    public static void main(String[] args) {

        Board board = new Board();
        boolean turn = true;

        Scanner scanner = new Scanner(System.in);
        String[] input;

        board.printBoard();

        while (true) {
            if (turn) System.out.print("White's move: ");
            else System.out.print("Black's move: ");
            input = scanner.nextLine().split(" ");
            if (input[0].equals("resign") || (input.length > 2 && input[2].equals("draw?"))) break;
            if (!board.movePiece(input, turn)) System.out.println("Illegal move, try again");
            else {
                turn = !turn;
                if (board.isCheckMate(turn)) {
                    System.out.println("Checkmate");
                    break;
                }
                if (board.isCheck(turn)) System.out.println("Check");
            }
        }

        if (input.length > 2 && input[2].equals("draw?")) System.out.println("draw");
        else if (turn) System.out.println("Black wins");
        else System.out.println("White wins");

    }

}
