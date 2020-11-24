package src.ui;

import src.Model.*;
import src.Controller.*;


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
    private JButton getButton5;
    private JTextPane textPane6;
    private JButton getButton6;
    private JTextPane textPane7;
    private JTextField textField3;
    private JButton deleteButton;
    private JTextField textField4;
    private JButton updateButton;

    private TerminalTransactionsDelegate delegate = null;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainPage");
        frame.setContentPane(new MainPage().cs304);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public MainPage() {
        this.delegate = delegate;
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
                delegate.insertUser(model);
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
                delegate.insertPost(model);
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
                delegate.insertComment(model);
            }
        });

        getButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BigDecimal Latitude = BigDecimal.valueOf(Double.parseDouble(textField7.getText()));
                BigDecimal Longitude = BigDecimal.valueOf(Double.parseDouble(textField8.getText()));
                String[] result = delegate.selectPostByLocation(Latitude, Longitude);
                StringBuilder sb = new StringBuilder(65536);
                for (String tmp : result)
                    sb.append(tmp).append('\n');

                textPane1.setText(sb.toString());
            }
        });
        getButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Username = textField15.getText();
                String[] result = delegate.selectPostByUser(Username);
                StringBuilder sb = new StringBuilder(65536);
                for (String tmp : result)
                    sb.append(tmp).append('\n');

                textPane2.setText(sb.toString());
            }
        });
        getButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String PostID = textField9.getText();
                String[] result = delegate.findTrendingPosts(PostID);
                StringBuilder sb = new StringBuilder(65536);
                for (String tmp : result)
                    sb.append(tmp).append('\n');

                textPane3.setText(sb.toString());
            }
        });
        getButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String time = textField16.getText();
                String[] result = delegate.findTopicWithPostsOnDate(time);
                StringBuilder sb = new StringBuilder(65536);
                for (String tmp : result)
                    sb.append(tmp).append('\n');

                textPane5.setText(sb.toString());
            }
        });
        getButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] result = delegate.postPerDay();
                StringBuilder sb = new StringBuilder(65536);
                for (String tmp : result)
                    sb.append(tmp).append('\n');

                textPane4.setText(sb.toString());
            }
        });
        getButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] result = delegate.highestReplyNumber();
                StringBuilder sb = new StringBuilder(65536);
                for (String tmp : result)
                    sb.append(tmp).append('\n');

                textPane6.setText(sb.toString());
            }
        });
        getButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] result = delegate.userInAllVotes();
                StringBuilder sb = new StringBuilder(65536);
                for (String tmp : result)
                    sb.append(tmp).append('\n');

                textPane7.setText(sb.toString());
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int UserID = Integer.parseInt(textField4.getText());
                String Username = textField13.getText();
                delegate.updateUserName(UserID, Username);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int PostID = Integer.parseInt(textField3.getText());
                delegate.deletePost(PostID);
            }
        });
    }
}
