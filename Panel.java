package com.Game.GUI;

import com.Game.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

// To store the location of x & y direction
class Pair{
    int x_pos , y_pos;

    public Pair(int x, int y){
        x_pos = x;
        y_pos = y;
    }
}

public class Panel extends JPanel { // Separate Board to snake and ladder
    int preFix = 10;
    int x = 0, y = 0;
    int width = 60 , height = 60; // (60 X 60 ) in box
    String win = ""; // Winner Declare
    BufferedImage image; // Image of snake & ladder game
    JLabel label; // to  Assign image to this label

    JLabel player1, player2; // player  position label
    int p1_currPos = 1, p2_currPos = 1; // Ini position of both player (1)

    HashMap<Integer, Pair> numberMap = new HashMap<>(); // to store numberPosition with respect to direction X & Y
    HashMap<Integer, Integer> snakeLadder = new HashMap<>(); // Store start , ending position of ladder and Snake

    public Panel() throws IOException {
        iniSnakeLadder(); // Initialise snake & ladder Map
        image = ImageIO.read( new File("C:\\Users\\prani\\Desktop\\image\\ladderAndSnake3.jpg")); // snake & ladder board image
        label = new JLabel(new ImageIcon(image));
        label.setBounds(preFix,preFix,600,600);     // board dimension (600 X 600)


        // set both player at start position at 1
        player1 = new JLabel(new ImageIcon("C:\\Users\\prani\\Desktop\\image\\brown.png") );

        player2 = new JLabel(new ImageIcon("C:\\Users\\prani\\Desktop\\image\\purple.png"));
        player1.setBounds(10+30,550+30,15,15); // (x, y) = (10, 550)  & (30,30) for the spacing
        player2.setBounds(10+30, 550+30,14,14);

        this.add(player1);
        this.add(player2);
    }
    public void iniSnakeLadder(){       // store starting & ending point of ladder and snake in snakeLadder map
        // Ladder start & ending point
        snakeLadder.put(1,38);
        snakeLadder.put(4,14);
        snakeLadder.put(9,31);
        snakeLadder.put(21,42);
        snakeLadder.put(28,84);
        snakeLadder.put(51,67);
        snakeLadder.put(72,91);
        snakeLadder.put(80,99);

        // Snake starting and ending point
        snakeLadder.put(17,7);
        snakeLadder.put(54,34);
        snakeLadder.put(62,19);
        snakeLadder.put(64,60);
        snakeLadder.put(87,36);
        snakeLadder.put(92,73);
        snakeLadder.put(95,75);
        snakeLadder.put(98,79);
    }
    // set new position to the player
    public void setLocation(boolean isPlayer1, int pos){
        if(isPlayer1){              // PLayer 1 throws the dice
            set_Player1_Loc(pos);
        }else{                      // Player 2 throws the dice
            set_Player2_Loc(pos);
        }
    }
    private void set_Player1_Loc(int pos){
        if(p1_currPos +pos <= 100)   // Upper bound if previous loc 96 and now dice get 5 no.. then player will not move forward
            p1_currPos += pos;        // update new position and check in map for is there any ladder or snake
        if(snakeLadder.containsKey(p1_currPos))
            p1_currPos = snakeLadder.get(p1_currPos);

        Pair location = numberMap.get(p1_currPos);      // get x & y co-ordinates for particular points
        player1.setLocation(location.x_pos+30,location.y_pos+30);   // set the image on x & Y co-ord
        if(p1_currPos == 100){          // winner
            win = "Player1";
            winner();
        }
    }
    private void set_Player2_Loc(int pos){
        if(p2_currPos +pos <= 100)
            p2_currPos += pos;
        if(snakeLadder.containsKey(p2_currPos))
            p2_currPos = snakeLadder.get(p2_currPos);
        Pair location = numberMap.get(p2_currPos);
        player2.setLocation(location.x_pos+30,location.y_pos+30);
        if(p2_currPos == 100){
            win = "Player2";
            winner();
        }
    }
    // Winner declaration
    private void winner(){
        JOptionPane.showMessageDialog(null,
                "Congratulation " + win + " you win the game","",
                JOptionPane.INFORMATION_MESSAGE);
        player1.setBounds(10+30,550+30,15,15); // (x, y) = (10, 550)  & (30,30) for the spacing
        player2.setBounds(10+30, 550+30,14,14);
        p1_currPos = 1;
        p2_currPos = 1;
        new Main();
    }
    // need graphics interface for image and draw rectangle
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);            // call in build paintComponent methods
        int loc_Number = 100; // Number on the board;
        boolean dir = true; // true for left to right , false for right to left
        for(x = 0; x<10; x+=1){
            for (y = 0; y <10; y+=1){
                int x_pos = preFix+ (x * height); // get x co-ordinates - height is the height of box
                int y_pos = preFix +(y* width);    //  get x co-ordinates - height is the height of box
                numberMap.put(loc_Number, new Pair(y_pos,x_pos));       // store (x,y) co-ordinates for particular no
                if(dir)       // left to right decrement  loc_number & right to left increment loc_number
                    loc_Number--;
                else{
                    loc_Number++;
                }
            }
            if(dir){
                loc_Number = loc_Number -9;
            }else{
                loc_Number = loc_Number -11;
            }
            dir = !dir; // change the direction
        }
        this.add(label);
    }
}
