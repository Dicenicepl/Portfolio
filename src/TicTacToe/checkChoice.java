package TicTacToe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class checkChoice {
    int numInput;
    boolean errorCheck = true;
    Scanner scanner = new Scanner(System.in);


    public void sprawdzaniePrzedzialow(){
        while (!(numInput > 0 && numInput <= 9) && errorCheck) {
            try {
                System.out.print("Proszę zrobić wybór:");
                numInput = scanner.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println("Podano błędny przedział, proszę ponowić próbę");
                }
            } catch (Exception e) {
                numInput = 0;
            }if(numInput == 0){

                try {
                    numInput = Integer.parseInt(scanner.nextLine());
                }catch (Exception e ){
                    System.out.println("Wystąpił błąd, proszę ponowić wybór");
                    system.printBoard();
                    sprawdzaniePrzedzialow();
                }
            }
        }


    }

}