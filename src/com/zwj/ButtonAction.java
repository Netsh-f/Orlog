package com.zwj;

public class ButtonAction {

    public static volatile int startFlag = 0;
    public static volatile int coinFlag = -1;//0���� 1����
    public static volatile int okFlag = 0;
    public static volatile int godsFlag = -1;//��1 ��0 δѡ��-1
    public static volatile int godsGraceNum = 0;//1Ϊ����ŭϮ 2Ϊ������ķ֮��
    public static volatile int godsLevelNum = 0;//0δѡ�� 1 2 3�ȼ�

    public static void startBtnAction() {
        ButtonAction.startFlag = 1;
    }

    public static void coinBtn1Action() {
        ButtonAction.coinFlag = 1;
    }

    public static void coinBtn2Action() {
        ButtonAction.coinFlag = 0;
    }

    public static void diceSelectdAction(Player player, int num) {
        if (player.selected[num] == 0) {
            if (player.diceSelected[num] == 0) {
                player.diceSelected[num] = player.randomSide[num];
            } else {
                player.diceSelected[num] = 0;
            }
        }
    }

    public static void okBtnAction() {
        ButtonAction.okFlag = 1;
    }

    public static void godsGraceAction1() {
        godsFlag = 1;
    }

    public static void godsGraceAction2() {
        godsFlag = 0;
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
