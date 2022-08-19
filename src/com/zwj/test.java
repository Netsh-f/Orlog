package com.zwj;

import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class test {
    public static void main(String[] args) throws Exception {

        MainFrame.mainFrame.init();
        MusicPlayer.startMusic1.start(false);
        MusicPlayer.startMusic2.start(true);

        Thread uiThread = new Thread(new UpdateUI());
        uiThread.start();

        MainFrame.mainFrame.textArea.setText("点击Play以开始对局");

        while (true) {
            switch (ButtonAction.startFlag) {
                case 1:
                    MainFrame.mainFrame.textArea.setText("player1决定正面还是背面？\n通过掷硬币来决定先手");
                    UpdateUI.gameState = UpdateUI.SELECTCOIN;

                    ButtonAction.coinFlag = -1;
                    while (true) {
                        if (ButtonAction.coinFlag != -1) {
                            break;
                        }
                    }
                    UpdateUI.gameState = UpdateUI.NORMAL;

                    Player.coinNum = getRandom.getRandomCoin();
                    if (ButtonAction.coinFlag == Player.coinNum) {
                        Player.firstPlayer = Player.player1;
                        coinPaint();
                        while (Player.player1.hp > 0 && Player.player2.hp > 0) {
                            playAll(Player.player1, Player.player2);
                        }
                    } else {
                        Player.firstPlayer = Player.player2;
                        coinPaint();
                        while (Player.player1.hp > 0 && Player.player2.hp > 0) {
                            playAll(Player.player2, Player.player1);
                        }
                    }
                    ButtonAction.startFlag = 0;
                    break;
            }
        }
    }

    public static void playAll(Player p1, Player p2) {
        UpdateUI.gameState = UpdateUI.SELECT;
        Player.bothSelect(p1, p2);
        UpdateUI.gameState = UpdateUI.GODSGRACE;
        Player.settle1(p1, p2);
        Player.godsGrace(p1, p2);
        UpdateUI.gameState = UpdateUI.SETTLE;
        Player.settle2(p1, p2);
        Player.isLose(p1, p2);
        MainFrame.mainFrame.okButton.setVisible(true);
        UpdateUI.gameState = UpdateUI.NORMAL;
        while (true) {
            if (ButtonAction.okFlag == 1) {
                break;
            }
        }
        for (int i = 0; i < 12; i++) {
            MainFrame.mainFrame.settleLabels[0][i].setVisible(false);
            MainFrame.mainFrame.settleLabels[1][i].setVisible(false);
        }
        ButtonAction.okFlag = 0;
    }

    public static void coinPaint() {
        MainFrame.mainFrame.coinTextLabel1.setText(Player.firstPlayer.name + "获得了先手");
        MainFrame.mainFrame.coinTextLabel1.setVisible(true);
        MainFrame.mainFrame.coinLabels[Player.coinNum].setVisible(true);
        while (true) {
            if (ButtonAction.okFlag == 1) {
                break;
            }
        }
        ButtonAction.okFlag = 0;
        MainFrame.mainFrame.coinTextLabel1.setVisible(false);
        MainFrame.mainFrame.coinLabels[Player.coinNum].setVisible(false);
    }
}
