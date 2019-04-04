package com.idearfree.agame.tictactoe;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.*;
import java.net.URL;

/**
 * 马马虎虎吧，代码不咋地，等学什么新的知识了再来更改吧。
 * @Author Zzzxb 2018年9月16日 15点12分
 */
public class GameFrame extends JFrame {
    static JButton [] jb = new JButton[9];
    static int flag[] = new int[9];
    static int count = 1;
    static String message[] = {"Welcome to Tic Tac Toe !", "Cross ", "Ring ", "🤝 DogFall !"};
    static JLabel jlabel = new JLabel(message[0], JLabel.CENTER);
    static int stepNumber = 0;

    public GameFrame() {
        //生成jar包后不能从内部打开图片，所以使用的另一种方法
        URL url = GameFrame.class.getResource("images/bg.png");
        URL url1 = GameFrame.class.getResource("images/true.png");
        URL url2 = GameFrame.class.getResource("images/false.png");

        Image img = null;
        Image img1 = null;
        Image img2 = null;

        try{
            InputStream input = url.openStream();
            img = javax.imageio.ImageIO.read(input);
            InputStream input1 = url1.openStream();
            img1 = javax.imageio.ImageIO.read(input1);
            InputStream input2 = url2.openStream();
            img2 = javax.imageio.ImageIO.read(input2);
        }catch(IOException e){
            e.printStackTrace();
        }
        ImageIcon bgIcon = new ImageIcon(img);
        ImageIcon bgFalse = new ImageIcon(img1);
        ImageIcon bgTrue = new ImageIcon(img2);

        JPanel p0 = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel(new GridLayout(3,3));
        p1.setBackground(Color.BLACK);

        Font font = new Font("Courier", 2, 20);
        jlabel.setBorder(BorderFactory.createEtchedBorder());
        jlabel.setBackground(Color.BLUE);
        jlabel.setFont(font);

        for(int i = 0 ; i < 9 ; i ++) {
            jb[i] = new JButton();
            jb[i].setBackground(Color.BLACK);
            p1.add(jb[i]);
        }

        init(bgIcon);
        buttonListener(bgTrue,bgFalse);

        setLayout(new BorderLayout());

        p0.add(jlabel, BorderLayout.NORTH);
        p0.add(p1, BorderLayout.CENTER);
        add(p0);
    }

    public void setFrame() {
        GameFrame  frame = new GameFrame();
        frame.setTitle("Tic Tac Toe");
        frame.setSize(450,450);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void click(int i,ImageIcon bgTrue, ImageIcon bgFalse) {
        if(flag[i] == 1 || flag[i] == -1 || count == 0) {
            // No Change
        }else {
            flag[i] = count;
            if (count == 1) {
                jb[i].setIcon(bgTrue);
                count = -1;
                stepNumber ++;
                jlabel.setText("Cross");
            } else {
                jb[i].setIcon(bgFalse);
                count = 1;
                stepNumber ++;
                jlabel.setText("Ring");
            }
            winStandard();
        }
    }

    public void winStandard(){
        int n = 0;
        win(3,4,5,0); win(6,7,8,0); win(0,3,6,0);
        win(1,4,7,0); win(2,5,8,0); win(0,4,8, 0);
        win(2,4,6,0); win(0,1,2,0);
    }

    //这里判断胜利条件太麻烦，有更简单的-懒得写了
    //只要判断所下的棋子是第几步和周围(横竖斜)是否有相同的即可
    public int win(int x,int y,int z,int n) {
        int sign;
        int sum = flag[x] + flag[y] + flag[z];

        if(n == 1) {
            return 1;
        }
        else if(sum == 3 || sum ==-3){
            count = 0;
            sign = count == 3 ? 2 : 1;
            jlabel.setText(message[sign] + "You Win!");
            changeColor(2);

            //restart
//            init();

            /*这里写的有点问题了,这个判断胜利的条件不知道该怎么写
            * 这里的z==2 在winStandard()方法里的调用是最后一条
            * 判断，起个结束的作用，等胜利条件判断完再判断平局*/
            return 1;
        }else if(z == 2 && stepNumber == 9) {
            jlabel.setText(message[3]);
            changeColor(2);
            return 1;
        }
        return 0;
    }

    public void buttonListener(ImageIcon bgTrue, ImageIcon bgFalse) {
        jb[0].addActionListener(e -> click(0,bgTrue,bgFalse)); jb[1].addActionListener(e -> click(1,bgTrue,bgFalse));
        jb[2].addActionListener(e -> click(2,bgTrue,bgFalse)); jb[3].addActionListener(e -> click(3,bgTrue,bgFalse));
        jb[4].addActionListener(e -> click(4,bgTrue,bgFalse)); jb[5].addActionListener(e -> click(5,bgTrue,bgFalse));
        jb[6].addActionListener(e -> click(6,bgTrue,bgFalse)); jb[7].addActionListener(e -> click(7,bgTrue,bgFalse));
        jb[8].addActionListener(e -> click(8,bgTrue,bgFalse));
    }

    public void init(ImageIcon bgIcon) {
        jlabel.setText(message[0]);
        changeColor(1);
        count = 1;
        stepNumber = 0;

        for(int i = 0 ; i < 9 ; i ++) {
            flag[i] = 0;
            jb[i].setIcon(bgIcon);
        }
    }

    public void changeColor(int i) {
        if(i == 1) {
            jlabel.setForeground(Color.BLACK);
        }else if(i == 2){
            jlabel.setForeground(Color.RED);
        }

    }

}
