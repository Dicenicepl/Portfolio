package ExchangeCalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.print("Please enter some currency amount: ");
        System.out.println(calculator.Calculation(scanner.next()));

    }
}
