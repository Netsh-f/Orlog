package com.zwj;

import javax.swing.*;
import java.awt.*;

public class UpdateUI implements Runnable {

    public static int gameState = 0;// 1-select 2-settle
    public static final int SELECT = 1;
    public static final int SETTLE = 2;
    public static final int NORMAL = 0;

    public void work() {
        while (true) {
            MainFrame.mainFrame.playerStateLabel1.setText("<html><body>" + Player.player1.name + "<br>HP:" + Player.player1.hp +
                    "<br>magic:" + Player.player1.magic + "<body></html>");
            MainFrame.mainFrame.playerStateLabel2.setText("<html><body>" + Player.player2.name + "<br>HP:" + Player.player2.hp +
                    "<br>magic:" + Player.player2.magic + "<body></html>");

            for (int i = 0; i < 6 - Player.player1.selectedDiceCnt - Player.player1.roundSelectedDiceCnt; i++) {
                ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/" + DiceSide.sideName[Player.player1.unSelectedDice[i]] + ".png"));
                diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                MainFrame.mainFrame.diceLabels1[i].setIcon(diceImageIcon);
            }
            for (int i = 0; i < 6; i++) {
                if (Player.player1.roundSelected[i] == 1) {
                    MainFrame.mainFrame.diceLabels1[i].setVisible(false);
                }
            }
            for (int i = 0; i < 6 - Player.player2.selectedDiceCnt - Player.player2.roundSelectedDiceCnt; i++) {
                if (Player.player2.roundSelected[i] == 1) {
                    MainFrame.mainFrame.diceLabels2[i].setVisible(false);
                }
                ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/" + DiceSide.sideName[Player.player2.unSelectedDice[i]] + ".png"));
                diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                MainFrame.mainFrame.diceLabels2[i].setIcon(diceImageIcon);
            }//dice
            for (int i = 0; i < 6; i++) {
                if (Player.player2.roundSelected[i] == 1) {
                    MainFrame.mainFrame.diceLabels2[i].setVisible(false);
                }
            }

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

            int cntVisible = 0;
            for (int i = 0; i < 6; i++) {
                for (int j = 4; j >= 0; j--) {
                    int k = i * 5 + j;
                    if (cntVisible < Player.player1.magic) {
                        MainFrame.mainFrame.magicLabels1[k].setVisible(true);
                        cntVisible++;
                    } else {
                        MainFrame.mainFrame.magicLabels1[k].setVisible(false);
                        cntVisible++;
                    }
                }
            }

            cntVisible = 0;
            for (int i = 0; i < 6; i++) {
                for (int j = 4; j >= 0; j--) {
                    int k = i * 5 + j;
                    if (cntVisible < Player.player2.magic) {
                        MainFrame.mainFrame.magicLabels2[k].setVisible(true);
                        cntVisible++;
                    } else {
                        MainFrame.mainFrame.magicLabels2[k].setVisible(false);
                        cntVisible++;
                    }
                }
            }

            if (UpdateUI.gameState == UpdateUI.SELECT) {
                for (int i = 0; i < Player.player1.selectedDiceCnt + Player.player1.roundSelectedDiceCnt; i++) {
                    ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource(
                            "image/" + DiceSide.sideName[Player.player1.selectedDice[i]] + ".png"));
                    diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                    MainFrame.mainFrame.settleLabels1[i].setIcon(diceImageIcon);
                    MainFrame.mainFrame.settleLabels1[i].setVisible(true);
                }
                for (int i = 0; i < Player.player2.selectedDiceCnt + Player.player2.roundSelectedDiceCnt; i++) {
                    ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource(
                            "image/" + DiceSide.sideName[Player.player2.selectedDice[i]] + ".png"));
                    diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                    MainFrame.mainFrame.settleLabels2[i].setIcon(diceImageIcon);
                    MainFrame.mainFrame.settleLabels2[i].setVisible(true);
                }
            } else {
                for (int i = 0; i < 6; i++) {
                    MainFrame.mainFrame.settleLabels1[i].setVisible(false);
                    MainFrame.mainFrame.settleLabels2[i].setVisible(false);
                }
            }
        }
    }

    @Override
    public void run() {
        work();
    }
}
