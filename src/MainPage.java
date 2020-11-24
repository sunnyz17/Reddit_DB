package ca.ubc.cs304.ui;

import ca.ubc.cs304.model.BranchModel;
import ca.ubc.cs304.model.CommentModel;
import ca.ubc.cs304.model.PostModel;
import ca.ubc.cs304.model.UserModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MainPage {
    private JTextField textField1;
    private JTextField textField2;
    private JPasswordField passwordField1;
    private JButton submitButton;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JButton submitButton2;
    private JButton submitButton4;
    private JTextField textField13;
    private JTextField textField14;
    public JPanel cs304;
    private JButton submitButton3;
    private JTextField textField7;
    private JTextField textField8;
    private JButton getButton;
    private JTextField textField15;
    private JButton getButton1;
    private JTextPane textPane1;
    private JTextPane textPane2;
    private JTextField textField9;
    private JButton getButton2;
    private JTextPane textPane3;
    private JButton getButton3;
    private JTextPane textPane4;
    private JTextField textField16;
    private JButton getButton4;
    private JTextPane textPane5;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainPage");
        frame.setContentPane(new MainPage().cs304);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public MainPage() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                int UserID = rand.nextInt(10000);
                String Username = textField1.getText();
                String Email = textField2.getText();
                String Pass = passwordField1.getPassword().toString();
                int Karma = 0;
                UserModel model = new UserModel(Email,
                        Pass,
                        Karma,
                        UserID,
                        Username);

            }
        });
        submitButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                int PostID = rand.nextInt(10000);
                String Content = textField5.getText();
                int UserID = Integer.parseInt(textField6.getText());
                String time = new SimpleDateFormat("yyyy.MM.dd").format(new Date());
                PostModel model = new PostModel(PostID,
                        Content,
                        UserID,
                        time);
            }
        });
        submitButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                int CommentID = rand.nextInt(10000);
                int UserID = Integer.parseInt(textField11.getText());
                int PostID = Integer.parseInt(textField12.getText());
                String time = new SimpleDateFormat("yyyy.MM.dd").format(new Date());
                String content = textField10.getText();
                CommentModel model = new CommentModel(CommentID,
                        UserID,
                        PostID,
                        time,
                        content);
            }
        });

        getButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double Latitude = Double.parseDouble(textField7.getText());
                double Longitude = Double.parseDouble(textField8.getText());
            }
        });
        getButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int UserID = Integer.parseInt(textField15.getText());
            }
        });
        getButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Content = textField9.getText();
            }
        });
        getButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] time = textField16.getText().toCharArray();

            }
        });
        getButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
