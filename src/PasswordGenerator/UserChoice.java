package PasswordGenerator;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.io.FileWriter;
import java.io.IOException;

public class UserChoice extends WindowAdapter {

    int length;
    int i = 0;
    String[] settings = {"Lower case","Upper case","Numbers"};
    boolean[] optionPick = new boolean[3];

    public int setDialogButton(String description) {
        int dialogButton = JOptionPane.showConfirmDialog(null, description, "Ustawienia",
                JOptionPane.YES_NO_OPTION);
        if (dialogButton ==JOptionPane.YES_OPTION){
            return 0;
        }else return 1;
    }

    public void setLetters() throws IOException {

        try{
            length = Integer.parseInt(JOptionPane.showInputDialog(null,"How many letters you want in password:"));
        }

        catch (Exception e){
            System.out.print("Error:");
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"Error, you put bad argument in Input Dialog","Error",JOptionPane.WARNING_MESSAGE);
            length = 0;

        }
        if (length != 0){
            while(i<=2){
                if (setDialogButton(settings[i])==JOptionPane.YES_OPTION) {
                    optionPick[i] =true;
                }
                else optionPick[i] = false;

                System.out.println(optionPick[i]);
                i++;
            }
            new Generator().generatingCode(length,optionPick[0],optionPick[1],optionPick[2]);

        }else {
            setLetters();
        }
    }
    public void setNamePassword(FileWriter writer) throws IOException {
            String name = JOptionPane.showInputDialog(null, "Pleasa name your password:");

            if (name != null && name.length() != 0) {
                writer.write("\n" + name + "-");
            }else{
                JOptionPane.showMessageDialog(null,"Error, you put bad argument in Input Dialog","Error",JOptionPane.WARNING_MESSAGE);
                setNamePassword(writer);
            }
    }
}
