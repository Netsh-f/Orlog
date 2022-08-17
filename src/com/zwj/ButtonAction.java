package com.zwj;

import javax.swing.*;
import java.awt.*;

public class ButtonAction {

    public static volatile int startFlag = 0;
    public static volatile int coinFlag = -1;//0反面 1正面
    public static volatile int okFlag = 0;
    public static volatile int godsFlag = -1;//是1 否0 未选择-1
    public static volatile int godsGraceNum = 0;//1为索尔怒袭 2为海尔达姆之眼
    public static volatile int godsLevelNum = 0;//0未选择 1 2 3等级
    public static volatile int loseFlag = 0;//1为对局已经结束但还没有刷新屏幕

    public static void returnBtnAction() {
        MainFrame.mainFrame.helpText.setVisible(false);
        MainFrame.mainFrame.returnBtn.setVisible(false);
        MainFrame.mainFrame.helpBtn.setVisible(true);
        MainFrame.mainFrame.startBtn.setVisible(true);
        MainFrame.mainFrame.titleLabel.setVisible(true);
    }

    public static void helpBtnAction() {
        MainFrame.mainFrame.helpText.setVisible(true);
        MainFrame.mainFrame.returnBtn.setVisible(true);
        MainFrame.mainFrame.helpBtn.setVisible(false);
        MainFrame.mainFrame.startBtn.setVisible(false);
        MainFrame.mainFrame.titleLabel.setVisible(false);
    }

    public static void startBtnAction() {
        ButtonAction.startFlag = 1;

        MusicPlayer.gamingMusic1.start(true);
        MusicPlayer.startMusic1.stop();
        MusicPlayer.startMusic2.stop();

        MainFrame.mainFrame.coinTextLabel1.setVisible(true);
        MainFrame.mainFrame.coinTextLabel2.setVisible(true);
        MainFrame.mainFrame.coinBtn1.setVisible(true);
        MainFrame.mainFrame.coinBtn2.setVisible(true);
        MainFrame.mainFrame.playerLabel1.setVisible(true);
        MainFrame.mainFrame.playerLabel2.setVisible(true);

        for (int i = 0; i < MainFrame.mainFrame.hpLabels1.length; i++) {
            MainFrame.mainFrame.hpLabels1[i].setVisible(true);
            MainFrame.mainFrame.hpLabels2[i].setVisible(true);
        }
        for (int i = 0; i < MainFrame.mainFrame.godsLabels1.length; i++) {
            MainFrame.mainFrame.godsLabels1[i].setVisible(true);
            MainFrame.mainFrame.godsLabels2[i].setVisible(true);
        }
        MainFrame.mainFrame.startBtn.setVisible(false);
        MainFrame.mainFrame.helpBtn.setVisible(false);
        MainFrame.mainFrame.titleLabel.setVisible(false);
    }

    public static void coinBtn1Action() {
        ButtonAction.coinFlag = 1;
        MainFrame.mainFrame.coinBtn1.setVisible(false);
        MainFrame.mainFrame.coinBtn2.setVisible(false);
//        MainFrame.mainFrame.coinTextLabel1.setVisible(false);
        MainFrame.mainFrame.coinTextLabel2.setVisible(false);
        MainFrame.mainFrame.okButton.setVisible(true);
    }

    public static void coinBtn2Action() {
        ButtonAction.coinFlag = 0;
        MainFrame.mainFrame.coinBtn1.setVisible(false);
        MainFrame.mainFrame.coinBtn2.setVisible(false);
//        MainFrame.mainFrame.coinTextLabel1.setVisible(false);
        MainFrame.mainFrame.coinTextLabel2.setVisible(false);
        MainFrame.mainFrame.okButton.setVisible(true);
    }

    public static void diceSelectdAction(Player player, int num) {
//        if (player.selected[num] == 0 && player.diceSelected[num] == 0) {
//            player.diceSelected[num] = player.randomSide[num];
//            player.selectedNum[player.selectedCnt] = player.diceSelected[num];
//            player.selectedCnt++;
//        }
        if (num < 6 - player.selectedDiceCnt) {
            if (player.roundCnt >= 2) {
                MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() + "\n最后一轮，请直接点击确定选择全部骰子以继续");
            } else {
                player.selectedDice[player.selectedDiceCnt + player.roundSelectedDiceCnt] = player.unSelectedDice[num];
                player.unSelectedDice[num] = 0;
                player.roundSelectedDiceCnt++;
                player.roundSelected[num] = 1;
            }
        }
    }

    public static void okBtnAction() {
        ButtonAction.okFlag = 1;
//        if(Player.player1.roundCnt == 3 || Player.player2.roundCnt == 3){
//            MainFrame.mainFrame.okButton.setVisible(false);
//        }
        if (ButtonAction.loseFlag == 1) {
            ButtonAction.loseFlag = 0;
            UpdateUI.gameState = UpdateUI.MENU;
            MusicPlayer.gamingMusic1.stop();
            MusicPlayer.startMusic2.start(true);
            MainFrame.mainFrame.coinTextLabel1.setVisible(false);
            MainFrame.mainFrame.coinTextLabel2.setVisible(false);
            MainFrame.mainFrame.okButton.setVisible(false);
            MainFrame.mainFrame.playerLabel1.setVisible(false);
            MainFrame.mainFrame.playerLabel2.setVisible(false);
        }
    }

    public static void godsGraceAction1() {
        godsFlag = 1;
        MainFrame.mainFrame.godsGraceBtn1.setVisible(false);
        MainFrame.mainFrame.godsGraceBtn2.setVisible(false);
    }

    public static void godsGraceAction2() {
        godsFlag = 0;
        MainFrame.mainFrame.godsGraceBtn1.setVisible(false);
        MainFrame.mainFrame.godsGraceBtn2.setVisible(false);
    }

    public static void godsGraceNum1() {
        godsGraceNum = 1;
    }

    public static void godsGraceNum2() {
        godsGraceNum = 2;
    }

    public static void levelAction(int num) {
        godsLevelNum = num;
    }
}
