package com.Game.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

public class MyFrame extends JFrame implements ActionListener {
    Panel panel;
    JButton dice;
    ImageIcon diceImage;
    JLabel player1, player2;
    JLabel p1_loc,p2_loc;
    JLabel num, result;
    Random random; // generate no 1-6
    boolean isPlayer1 = true; // True - player1, false - player 2

    public MyFrame() throws IOException {
        // Player  and position label declaration
        player1 = new JLabel("Player1 : ");
        player2 = new JLabel("Player2 : ");
        p1_loc = new JLabel("1");
        p2_loc = new JLabel("1");
        player1.setBounds(680,100,100,50);
        player2.setBounds(680,130,100,50);
        p1_loc.setBounds(750,100,50,50); // Display player position in num
        p2_loc.setBounds(750,130,50,50); //
        //  Adding player & location label to the Main Frame
        this.add(p1_loc);
        this.add(p2_loc);
        this.add(player1);
        this.add(player2);

        // After dice Throw how many position player is shifted

        num = new JLabel("Steps : "); // Fixed
        result = new JLabel("0"); // shown How many digit player is shift
        num.setBounds(680,160,50,50);
        result.setBounds(750,160,50,50);
        this.add(num);
        this.add(result);

        // Dice Button
        random = new Random(); // No generated in between 1-6;
        dice = new JButton("");
        diceImage = new ImageIcon("C:\\Users\\prani\\Desktop\\image\\dice.jpg"); // Dice image
        dice.setIcon(diceImage);
        dice.setBounds(680,310,50,50);
        dice.addActionListener(this); // Action perform for to update player position
        this.add(dice); // add dice to the main Frame

        panel = new Panel();
        panel.setLayout(null); // set default layout
        panel.setBounds(0,0,620,620); // (620 X 620)
        this.add(panel);

        this.setLayout(null); // set default layout
        this.setSize(900,700); // (900 X 700)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int val=1;
        if(e.getSource() == dice){
            val = random.nextInt(6);
            if(val == 0)
                val = 1;
        }
        // Set location for player 1,2
        panel.setLocation(isPlayer1, val);
        isPlayer1 = !isPlayer1; // flip player
        p1_loc.setText("" + panel.p1_currPos); // update player1 label position
        p2_loc.setText("" + panel.p2_currPos); // update player1 label position
        result.setText("" + val); // Update dice label
    }

}
