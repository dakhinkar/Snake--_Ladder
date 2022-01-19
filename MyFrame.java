package com.Game.GUI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MyFrame extends JFrame {
    public static final int WIDTH = 10;
    public static final int HEIGHT = 7;
    Panel panel;
    JButton button = new JButton("Ok");
    JButton button2 = new JButton("Bad");

    public MyFrame() throws IOException {

        panel = new Panel();
        panel.setLayout(null);

        panel.setBounds(0,0,620,620);
        this.add(panel);
        this.setLayout(null);
        this.setSize(700,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

//    private void init(){
//
//        for(int i =0;i <10; i++){
//            for(int j =0; j<10; j++){
//                Rectangle rectangle = new Rectangle();
//                rectangle.setBounds(i * WIDTH, j * HEIGHT, WIDTH, HEIGHT);
//
//
//
//            }
//        }
//
//    }



}
