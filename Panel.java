package com.Game.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Panel extends JPanel {
    int preFix = 10;
    int x = 0;
    int y = 0;
    int width = 60;
    int height = 60;
   BufferedImage image;
   JLabel label;

   Graphics g2;

   JLabel player1;
   JLabel player2;

    public Panel() throws IOException {
        //image = new BufferedImage();
        //.create();
        image = ImageIO.read( new File("C:\\Users\\prani\\Desktop\\image\\ladderAndSnake3.jpg"));





        label = new JLabel(new ImageIcon(image));
        label.setBounds(preFix,preFix,600,600);
        player1 = new JLabel(new ImageIcon("C:\\Users\\prani\\Desktop\\image\\red.png"));
        player2 = new JLabel(new ImageIcon("C:\\Users\\prani\\Desktop\\image\\pink.jpg"));
        player1.setBounds(15,90,15,15);
        player2.setBounds(15,90,14,14);

        // player1.setText("Hello");
        //player1.setVisible(true);
        this.add(player1);
        this.add(player2);
        loc();


    }
    private void loc(){
        player1.setLocation(350,500);
        player2.setLocation(250,500);

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(x = 0; x<10; x+=1){
            for (y = 0; y <10; y+=1){
                g.drawRect(preFix+ (x * height), preFix +(y* width), width, height);
            }
        }
      //  g.drawImage(image,preFix,preFix,600,600,null);
        this.add(label);


    }




}
