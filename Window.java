package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {
    JButton[] buttons = new JButton[9];
    JPanel title = new JPanel();
    JPanel game = new JPanel();
    JLabel GameTitle = new JLabel();
    boolean isPlaying = true;

    public Window() {
        setSize(400, 400);
        //setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setEnabled(true);
        getContentPane().setBackground(new Color(150, 150, 150));
        setVisible(true);
        setLayout(new BorderLayout());
        game.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.BOLD, 90));
            buttons[i].setForeground(Color.CYAN);
            buttons[i].setBackground(Color.gray);
            buttons[i].addActionListener(this);
            game.add(buttons[i], BorderLayout.CENTER);
            buttons[i].setFocusable(false);


        }
        add(game);
        add(title, BorderLayout.NORTH);
        title.add(GameTitle);
        GameTitle.setForeground(Color.green);
        title.setBackground(Color.PINK);
        GameTitle.setText("Tic Tac Toe");
        GameTitle.setFont(new Font("Times new roman", Font.BOLD, 40));
        title.setBounds(0, 0, 180, 20);
    }
    public void Owins(int a, int b, int c) {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
//        Object[] options = {"Yes, please",
//                "No, thanks",
//                "No eggs, no ham!"};
//        int n = JOptionPane.showOptionDialog(null,
//                "Would you like some green eggs to go "
//                        + "with that ham?",
//                "A Silly Question",
//                JOptionPane.YES_NO_CANCEL_OPTION,
//                JOptionPane.QUESTION_MESSAGE,
//                null,
//                options,
//                options[2]);
    }

    public void Xwins(int a, int b, int c) {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
//        Object[] options = {"Yes, please",
//                "No, thanks",
//                "No eggs, no ham!"};
//        int n = JOptionPane.showOptionDialog(null,
//                "Would you like some green eggs to go "
//                        + "with that ham?",
//                "A Silly Question",
//                JOptionPane.YES_NO_CANCEL_OPTION,
//                JOptionPane.QUESTION_MESSAGE,
//                null,
//                options,
//                options[2]);
    }

    public void PlayerX() {
        if (buttons[0].getText().equals("X")
                && buttons[1].getText().equals("X") &&
                buttons[2].getText().equals("X")) {
            Owins(0, 1, 2);
        }
        if (buttons[3].getText().equals("X")
                && buttons[4].getText().equals("X") &&
                buttons[5].getText().equals("X")) {
            Owins(3, 4, 5);
        }
        if (buttons[6].getText().equals("X")
                && buttons[7].getText().equals("X") &&
                buttons[8].getText().equals("X")) {
            Owins(6, 7, 8);
        }
        if (buttons[0].getText().equals("X")
                && buttons[4].getText().equals("X") &&
                buttons[8].getText().equals("X")) {
            Owins(0, 4, 8);
        }
        if (buttons[2].getText().equals("X")
                && buttons[4].getText().equals("X") &&
                buttons[6].getText().equals("X")) {
            Owins(2, 4, 6);
        }

        if (buttons[0].getText().equals("X")
                && buttons[3].getText().equals("X") &&
                buttons[6].getText().equals("X")) {
            Owins(0, 3, 6);
        }
        if (buttons[1].getText().equals("X")
                && buttons[4].getText().equals("X") &&
                buttons[7].getText().equals("X")) {
            Owins(1, 4, 7);
        }
        if (buttons[2].getText().equals("X")
                && buttons[5].getText().equals("X") &&
                buttons[8].getText().equals("X")) {
            Owins(2, 5, 8);
        }
    }
    public void PlayerO() {
        if (buttons[0].getText().equals("O")
                && buttons[1].getText().equals("O") &&
                buttons[2].getText().equals("O")) {
            Owins(0, 1, 2);
        }
        if (buttons[3].getText().equals("O")
                && buttons[4].getText().equals("O") &&
                buttons[5].getText().equals("O")) {
            Owins(3, 4, 5);
        }
        if (buttons[6].getText().equals("O")
                && buttons[7].getText().equals("O") &&
                buttons[8].getText().equals("O")) {
            Owins(6, 7, 8);
        }
        if (buttons[0].getText().equals("O")
                && buttons[4].getText().equals("O") &&
                buttons[8].getText().equals("O")) {
            Owins(0, 4, 8);
        }
        if (buttons[2].getText().equals("O")
                && buttons[4].getText().equals("O") &&
                buttons[6].getText().equals("O")) {
            Owins(2, 4, 6);
        }

        if (buttons[0].getText().equals("O")
                && buttons[3].getText().equals("O") &&
                buttons[6].getText().equals("O")) {
            Owins(0, 3, 6);
        }
        if (buttons[1].getText().equals("O")
                && buttons[4].getText().equals("O") &&
                buttons[7].getText().equals("O")) {
            Xwins(1, 4, 7);
        }
        if (buttons[2].getText().equals("O")
                && buttons[5].getText().equals("O") &&
                buttons[8].getText().equals("O")) {
            Xwins(2, 5, 8);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                    if (isPlaying) {
                        GameTitle.setText("Player X turn");
                        buttons[i].setText("X");
                        buttons[i].setForeground(Color.blue);
                        PlayerX();

                        isPlaying = false;

                    } else {
                            buttons[i].setText("O");
                            buttons[i].setForeground(Color.red);
                            GameTitle.setText("Player O turn");
                            PlayerO();
                            isPlaying = true;
                    }
                
            }
        }
    }
}
