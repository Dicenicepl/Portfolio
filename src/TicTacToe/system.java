package TicTacToe;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class system {
    static String[] board;
    String turn;
    String winner = null;

    public void chooseFirstTurn(String turn){
        if (turn.equalsIgnoreCase("X")  || turn.equalsIgnoreCase("O")){
            this.turn = turn.toUpperCase();
        }else {
            System.out.println("Wybrano błędny String, proszę ponowić");
            Scanner scanner = new Scanner(System.in);
            chooseFirstTurn(scanner.next());
        }

    }
    public String[] fillBoard(){
        for (int i = 0; i <9; i++){
            board[i] = String.valueOf(i + 1);
        }
        return new String[0];
    }

    public String checkWin() {
        for (int a = 0; a < 8; a++) {
            String line = null;
            switch (a) {

                case 0 -> line = board[0] + board[1] + board[2];
                case 1 -> line = board[3] + board[4] + board[5];
                case 2 -> line = board[6] + board[7] + board[8];

                case 3 -> line = board[0] + board[3] + board[6];
                case 4 -> line = board[1] + board[4] + board[7];
                case 5 -> line = board[2] + board[5] + board[8];

                case 6 -> line = board[0] + board[4] + board[8];
                case 7 -> line = board[2] + board[4] + board[6];


            }
            if (line.equals("XXX")) {
                a= 10;
                return winner = "X";
            } else if (line.equals("OOO")) {
                a= 10;
                return winner = "O";
            }

        }
        for (int a = 0; a< 9; a++){
            if (Arrays.asList(board).contains(
                    String.valueOf(a + 1))) {
                break;
            }
            else if (a == 8) {
                return "Remis";
            }
        }

        return null;
    }

    public static void printBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|");

    }
}