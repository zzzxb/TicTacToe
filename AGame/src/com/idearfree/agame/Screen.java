package com.idearfree.agame;

import com.idearfree.agame.tictactoe.GameFrame;

import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame{
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JButton[] button = new JButton[3];
    Screen() {
        init();
    }

    public void init() {
        JLabel label = new JLabel(GameSetteings.getTitle());
        Font font = new Font("Chiller",1, 200);
        button[0] = new JButton("TicTacToe");
        button[1] = new JButton("About");
        button[2] = new JButton("Exit");


        label.setFont(font);
        label.setForeground(Color.RED);
        panel.setLayout(new BorderLayout());
        panel2.setLayout(new GridLayout(9, 5));
        for(int i = 0; i < 45 ; i++){
            if (i == 17)
                panel2.add(button[0]);
            else if (i == 22)
                panel2.add(button[1]);
            else if (i == 27)
                panel2.add(button[2]);
            else
                panel2.add(new Label());
        }
        panel.setBackground(Color.BLACK);
        panel1.setBackground(Color.BLACK);
        panel2.setBackground(Color.BLACK);

        panel.add(panel1, BorderLayout.NORTH);
        panel.add(panel2, BorderLayout.CENTER);
        panel1.add(label);
        add(panel);
        button[0].addActionListener(e ->tictactoe());
        button[1].addActionListener(e ->begin());
        button[2].addActionListener(e ->System.exit(0));
    }

    public void ScreenSetting() {
        Screen frame = new Screen();
        frame.setTitle(GameSetteings.getTitle());
        frame.setSize(GameSetteings.getScreenX(),
                GameSetteings.getScreenY());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void tictactoe() {
        dispose();
        GameFrame gf = new GameFrame();
        gf.setFrame();
    }
    public void begin() {
        dispose();
        test t = new test();
        t.test1();
    }

}
