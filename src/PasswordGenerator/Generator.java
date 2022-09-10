package PasswordGenerator;


import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;



public class Generator {
    private  final int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final String[] lowerCase = {"a","b","c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y","z"};
    private final String[] upperCase ={"A","B","C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y","Z"};

    Random random = new Random();
    FileWriter writer;
    {
        try {writer = new FileWriter("Password.txt",true);
        } catch (IOException e) {throw new RuntimeException(e);
        }
    }

    public void generatingCode(int caseLenght,boolean userLower, boolean userUpper,boolean userNumbers) throws IOException {
        ArrayList<String> passCode = new ArrayList<String>();
        int a = 0;
        while(a < caseLenght){
            int getRandom = random.nextInt(0,3);

            if (userLower && (getRandom == 0)) {
                passCode.add(lowerCase[random.nextInt(lowerCase.length)]);
                a++;
            }
            else if (userUpper&& (getRandom == 1)) {
                passCode.add(upperCase[random.nextInt(upperCase.length)]);
                a++;
            }
            else if (userNumbers && (getRandom == 2)){
                passCode.add(String.valueOf(numbers[random.nextInt(numbers.length)]));
                a++;
            }
        }
        new UserChoice().setNamePassword(writer);

        String password = String.join("",passCode);
        writer.write(password);
        writer.close();

        JOptionPane.showMessageDialog(null,"Your password is: "+ password);

    }
}