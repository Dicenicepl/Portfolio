package TicTacToe;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        system system = new system();

        System.out.print("Wybierzcie pierwszego kto będzie się ruszać:");
        system.chooseFirstTurn(scanner.nextLine());

        String[] board = (system.board = new String[9]);

        system.fillBoard();
        system.printBoard();

        while (system.winner == null) {
            checkChoice checkChoice = new checkChoice();
            checkChoice.sprawdzaniePrzedzialow();
            int numInput = checkChoice.numInput;

            if (numInput == 0){
                system.winner = "error";
                break;
            }
            if (board[numInput - 1].equals(String.valueOf(numInput))) {
                board[numInput - 1] = system.turn;

                if (system.turn.equals("X")) {
                    system.turn = "O";

                } else system.turn = "X";

                system.printBoard();
                system.winner = system.checkWin();

            } else System.out.println("Slot został już zajęty, proszę wybrać inny:");


        }

        if (system.winner.equalsIgnoreCase("Remis")) {
            System.out.println("Mamy remis");
        }
        /*else if (system.winner.equalsIgnoreCase("error")){
            System.out.println("Gra napotkała błąd, aplikacja wyłączy działanie");

        }*/
        else if (system.winner.equalsIgnoreCase("X") ||
                (system.winner.equalsIgnoreCase("O"))){
            System.out.println("Wygrał " + system.winner );
        }

    }
}