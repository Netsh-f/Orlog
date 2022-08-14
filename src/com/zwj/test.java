package com.zwj;

import java.io.File;
import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {

//        System.out.println(test.class.getClassLoader().getResource("image/test1.png"));

        MainFrame.mainFrame.init();
        Thread uiThread = new Thread(new UpdateUI());
        uiThread.start();
        MainFrame.mainFrame.textArea.setText("点击Play以开始对局");

        while (true) {
            switch (ButtonAction.startFlag) {
                case 1 -> {
                    MainFrame.mainFrame.textArea.setText("player1决定正面还是背面？\n通过掷硬币来决定先手");

                    while (true) {
                        if (ButtonAction.coinFlag != -1) {
                            break;
                        }
                    }

                    if (ButtonAction.coinFlag == getRandom.getRandomCoin()) {
                        MainFrame.mainFrame.textArea.setText("player1获得先手");
                        while (Player.player1.hp > 0 && Player.player2.hp > 0) {
                            playAll(Player.player1, Player.player2);
                        }
                    } else {
                        MainFrame.mainFrame.textArea.setText("player2获得先手");
                        while (Player.player1.hp > 0 && Player.player2.hp > 0) {
                            playAll(Player.player2, Player.player1);
                        }
                    }
                    ButtonAction.startFlag = 0;
                }
                default -> {
                }
            }
        }
    }

    public static void playAll(Player p1, Player p2) {
        Player.bothSelect(p1, p2);
        Player.godsGrace(p1, p2);
        Player.settle(p1, p2);
        Player.isLose(p1, p2);
        MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText()+"\n点击确认以进行下一回合");
        while (true){
            if(ButtonAction.okFlag == 1){
                break;
            }
        }
        ButtonAction.okFlag = 0;
    }
}
