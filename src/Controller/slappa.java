package src.Controller;

import javax.swing.*;
import src.ui.MainPage;


public class slappa {
    private void start(){
        JFrame frame = new JFrame("MainPage");
        frame.setContentPane(new MainPage().cs304);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main (String args[]){
        slappa slappa = new slappa();
        slappa.start();
    }
}
