package ExchangeCalculator;


import java.util.Scanner;

public class Calculator {

        Scanner scanner = new Scanner(System.in);

        private String firstChoice;
        private String secondaryChoice;
        final private String[] currency =
                {"Euro", "American Dollar", "Australian Dollar", "Polish Zloty", "Indian Rupee","Japanese Yen",
                "Chinese Yuan", "British Pound", "Norwegian Crown", null};


    final private double[] interest = {1.0, 1.02, 1.47, 4.71, 81.79, 137.12, 6.96, 0.84, 9.84};




        public double Calculation(String value) {
            double afterSec = Security(value);
            selectingChoice();

            if (!firstChoice.equalsIgnoreCase(secondaryChoice)){
                for (int i = 0; i < currency.length -1; i++) {
                    if (currency[i].equalsIgnoreCase(firstChoice)){
                        afterSec = afterSec / interest[i];
                    }
                }
                for (int i = 0; i < currency.length -1; i++) {
                    if (!currency[i].equals("Euro")&&
                            currency[i].equals(secondaryChoice)){
                        afterSec = afterSec * interest[i];
                    }
                }
            }
            return Math.round(afterSec * 100.0) / 100.0;

        }
    protected double Security(String object){
        boolean test = true;
        double transfer = 0;
        object = object.replace(",", ".");
        while(test){
            try {
                transfer = Double.parseDouble(object);
                test = false;
            }catch (Exception e){
                System.out.print("Please retype value: ");
                object = scanner.next();
            }
        }
        return transfer;
    }

    private String choosePanel(String choice){
            int select = 0;
            try {
                select = scanner.nextInt();
                switch (select) {
                    case 0 -> choice = currency[0];
                    case 1 -> choice = currency[1];
                    case 2 -> choice = currency[2];
                    case 3 -> choice = currency[3];
                    case 4 -> choice = currency[4];
                    case 5 -> choice = currency[5];
                    case 6 -> choice = currency[6];
                    case 7 -> choice = currency[7];
                    case 8 -> choice = currency[8];
                }
            } catch (Exception e) {
                System.out.println("Try again");
                select = scanner.nextInt();
            }
            return choice;
        }

    private void selectingChoice(){

        System.out.println("Please select the currency you want it to be changed:");
        for (int i = 0; i < currency.length - 1; i++) {
            System.out.println(i + "." + currency[i]);
        }
        System.out.print("Your choice:");
        firstChoice = choosePanel(firstChoice);
        System.out.println(" ");

        System.out.println("Please select the currency to be changed:");
        for (int i = 0; i < currency.length - 1; i++) {
            System.out.println(i + "." + currency[i]);
        }
        System.out.print("Your choice:");
        secondaryChoice = choosePanel(secondaryChoice);
        System.out.println(" ");

    }
}
