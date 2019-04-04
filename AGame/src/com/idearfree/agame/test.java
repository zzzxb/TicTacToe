package com.idearfree.agame;

import javax.swing.*;
import java.awt.*;

public class test extends JFrame {
    test() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1));
        Font font = new Font("宋体",1,60);
        JLabel lb = new JLabel("井字棋",JLabel.CENTER);
        JLabel lb1 = new JLabel("于新乡留庄营社区",JLabel.CENTER);
        JLabel lb2 = new JLabel("2018-9-20",JLabel.CENTER);
        JLabel lb3 = new JLabel("Zzzxb",JLabel.CENTER);
        lb.setForeground(Color.WHITE);
        lb.setFont(font);
        lb1.setFont(font);
        lb2.setFont(font);
        lb3.setFont(font);
        panel.setBackground(Color.BLACK);

        panel.add(lb);
        panel.add(lb1);
        panel.add(lb2);
        panel.add(lb3);
        add(panel);
    }

    public void test1() {
       test t = new test();
       t.setTitle("A Bout");
       t.setSize(800,650);
       t.setDefaultCloseOperation(EXIT_ON_CLOSE);
       t.setLocationRelativeTo(null);
       t.setVisible(true);
    }
}
