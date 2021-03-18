package chess;

import java.util.Scanner;

public class Chess {

    public static void main(String[] args) {

        Board board = new Board();
        boolean turn = true;

        Scanner scanner = new Scanner(System.in);
        String input;

        while(true){ // run permanently until stopped for testing purposes
            board.printBoard();
            if(turn) System.out.print("White's Move: ");
            else System.out.print("Black's Move: ");
            input = scanner.nextLine();
            while(!board.movePiece(input, turn)){
                System.out.println("Illegal Move, try again");
                if(turn) System.out.print("White's Move: ");
                else System.out.print("Black's Move: ");
                input = scanner.nextLine();
            }
            turn = !turn;
        }

    }

}
