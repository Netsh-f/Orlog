package com.zwj;

import javax.swing.*;
import java.awt.*;

public class UpdateUI implements Runnable {
    public void work() {
        while (true) {
            MainFrame.mainFrame.playerStateLabel1.setText("<html><body>" + Player.player1.name + "<br>HP:" + Player.player1.hp +
                    "<br>magic:" + Player.player1.magic + "<body></html>");
            MainFrame.mainFrame.playerStateLabel2.setText("<html><body>" + Player.player2.name + "<br>HP:" + Player.player2.hp +
                    "<br>magic:" + Player.player2.magic + "<body></html>");
            for (int i = 0; i < 6; i++) {
                if (Player.player1.selected[i] == 0) {
                    ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/" + DiceSide.sideName[Player.player1.randomSide[i]] + ".png"));
                    diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                    MainFrame.mainFrame.diceLabels1[i].setIcon(diceImageIcon);
                } else {
                    ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/none.png"));
                    diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                    MainFrame.mainFrame.diceLabels1[i].setIcon(diceImageIcon);
                }
            }
            for (int i = 0; i < 6; i++) {
                if (Player.player2.selected[i] == 0) {
                    ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/" + DiceSide.sideName[Player.player2.randomSide[i]] + ".png"));
                    diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                    MainFrame.mainFrame.diceLabels2[i].setIcon(diceImageIcon);
                } else {
                    ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/none.png"));
                    diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                    MainFrame.mainFrame.diceLabels2[i].setIcon(diceImageIcon);
                }
            }//dice

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    int k = i * 5 + j;
                    if (Player.player1.hp >= 15 - k) {
                        ImageIcon stoneImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/stone" + k + ".png"));
                        stoneImageIcon.setImage(stoneImageIcon.getImage().getScaledInstance(40, 50, Image.SCALE_DEFAULT));
                        MainFrame.mainFrame.hpLabels1[k].setIcon(stoneImageIcon);
                    } else {
                        ImageIcon stoneImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/stoneEmpty.png"));
                        stoneImageIcon.setImage(stoneImageIcon.getImage().getScaledInstance(40, 50, Image.SCALE_DEFAULT));
                        MainFrame.mainFrame.hpLabels1[k].setIcon(stoneImageIcon);
                    }
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    int k = i * 5 + j;
                    if (Player.player2.hp >= 15 - k) {
                        ImageIcon stoneImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/stone" + k + ".png"));
                        stoneImageIcon.setImage(stoneImageIcon.getImage().getScaledInstance(40, 50, Image.SCALE_DEFAULT));
                        MainFrame.mainFrame.hpLabels2[k].setIcon(stoneImageIcon);
                    } else {
                        ImageIcon stoneImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/stoneEmpty.png"));
                        stoneImageIcon.setImage(stoneImageIcon.getImage().getScaledInstance(40, 50, Image.SCALE_DEFAULT));
                        MainFrame.mainFrame.hpLabels2[k].setIcon(stoneImageIcon);
                    }
                }
            }//hp

//            for (int i = 0; i < Player.player1.hp; i++) {
//                ImageIcon magicImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/magic.png"));
//                magicImageIcon.setImage(magicImageIcon.getImage().getScaledInstance(40, 50, Image.SCALE_DEFAULT));
//                hpLabels1[k] = new HPJLabel(stoneImageIcon);
//                hpLabels1[k].setOpaque(false);
////                hpLabels1[k].setFont(new Font("ºÚÌå", Font.PLAIN, 12));
////                hpLabels1[k].setBackground(Color.RED);
//                hpLabels1[k].setBounds(50 + 50 * j, 30 + 50 * i, 40, 50);
//                mainGamePanel.add(hpLabels1[k]);
//            }
        }
    }

    @Override
    public void run() {
        work();
    }
}
