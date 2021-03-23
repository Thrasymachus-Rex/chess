package chess;

import java.util.Scanner;

/**
 * The Chess class contains the main method that runs the program
 *
 * @author Sreekar Vedula
 * @author Quan Li
 */
public class Chess {
    /**
     * Runs the game and accepts moves until a checkmate or draw/resign is detected
     *
     * @param args
     */
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

        if (input.length > 2 && input[2].equals("draw?")){
            System.out.println("'draw' to accept");
            turn = !turn;
            if(turn) System.out.print("White's move: ");
            else System.out.print("Black's move: ");
            input = scanner.nextLine().split(" ");
            while(!input[0].equals("draw")) {
                System.out.println("Illegal move");
                if(turn) System.out.print("White's move: ");
                else System.out.print("Black's move: ");
                input = scanner.nextLine().split(" ");
            }
            System.out.println("Draw");

        }
        else if (turn) System.out.println("Black wins");
        else System.out.println("White wins");

    }

}
