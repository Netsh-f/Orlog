package com.zwj;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Player {
    public String name;
    public int hp = 15;
    public int magic = 0;
    public Dice[] dice = new Dice[6];
    //对局单阶段过程变量

    public int godsGraceFlag = -1;//-1为不使用众神恩惠
    public int godsGraceNum = 0;//选择哪一个众神恩惠，0为索尔怒袭，1为海姆达尔之眼
    public int godsGraceLevel = 0;//众神恩惠等级
    public int blockCnt = 0;

    //    public int[] selectedNum = new int[6];
//    public int selectedCnt = 0;
//    public int[] diceSelected = new int[6];//设置-1为未选择，其他数字为选择，且储存选择哪一个面的信息
//    public int[] randomSide = new int[6];//储存每一次掷骰得到的随机面
//    public int[] selected = new int[6];//储存一大个回合已经被选出来的骰子
    public int[] unSelectedDice = new int[6];//还没有被选出来的骰子，存抽到的点数
    public int[] selectedDice = new int[6];//存已经选择出来的骰子的点数
    public int selectedDiceCnt = 0;//存已经选择出来的骰子的数量
    public int roundSelectedDiceCnt = 0;//存这一次选择出来的骰子的数量
    public int[] roundSelected = new int[6];//用来存这一次这个位置的骰子有没有被选中
    public int[] sideCnt = new int[9];//存每种面的总数 0斧 12弓 34头盔 56盾 78偷

    public int roundCnt = 0;

    public static Player player1 = new Player("玩家1");
    public static Player player2 = new Player("玩家2");
    public static Player roundPlayer = null;
    public static Player firstPlayer = null;
    public static int coinNum = 0;

    public Player(String name) {
        dice[0] = Dice.dice0;
        dice[1] = Dice.dice1;
        dice[2] = Dice.dice2;
        dice[3] = Dice.dice3;
        dice[4] = Dice.dice4;
        dice[5] = Dice.dice5;
        this.name = name;
    }

    public static void initDiceSelected(Player player) {
        //设置0为未选择，其他数字为选择，且储存选择哪一个面的信息
//        Arrays.fill(player.diceSelected, 0);
//        Arrays.fill(player.selected, 0);
//        Arrays.fill(player.selectedNum, 0);
//        player.selectedCnt = 0;
        Arrays.fill(player.unSelectedDice, 0);
        Arrays.fill(player.selectedDice, 0);
        player.selectedDiceCnt = 0;
        player.roundSelectedDiceCnt = 0;
    }

    public static void playerSelect(Player player) {
        Arrays.fill(player.roundSelected, 0);
        MainFrame.mainFrame.textArea.setText("====掷骰阶段====" + "\n" + "现在由" + player.name + "进行选择\n");
        for (int i = 0; i < 6 - player.selectedDiceCnt; i++) {
            player.unSelectedDice[i] = getRandom.getRandomSide();
            if (player == Player.player1) {
                MainFrame.mainFrame.diceLabels1[i].setVisible(true);
            } else {
                MainFrame.mainFrame.diceLabels2[i].setVisible(true);
            }
        }
        MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() + "选择骰子保留点数，之后确定");
        MainFrame.mainFrame.okButton.setVisible(true);

        while (true) {
            if (ButtonAction.okFlag == 1) {
                break;
            }
        }
        ButtonAction.okFlag = 0;

        if (player.roundCnt == 2) {
            for (int i = 0; i < 6 - player.selectedDiceCnt; i++) {
                player.selectedDice[player.selectedDiceCnt + player.roundSelectedDiceCnt] = player.unSelectedDice[i];
                player.unSelectedDice[i] = 0;
                player.roundSelectedDiceCnt++;
                player.roundSelected[i] = 1;
            }
        }

        if (player == Player.player1) {
            for (int i = 0; i < 6; i++) {
                MainFrame.mainFrame.diceLabels1[i].setVisible(false);
            }
        } else {
            for (int i = 0; i < 6; i++) {
                MainFrame.mainFrame.diceLabels2[i].setVisible(false);
            }
        }

        player.selectedDiceCnt += player.roundSelectedDiceCnt;
        player.roundSelectedDiceCnt = 0;

//        MainFrame.mainFrame.textArea.setText("");
//        for (int i = 0; i < 6; i++) {
//            if (player.selected[i] == 0 && player.diceSelected[i] != 0) {//输出刚刚选择的骰子(上一次没有被选出)
////                System.out.println("选择的骰子为" + i + "号骰子，且为" + DiceSide.sideName[player.diceSelected[i]] + "面");
//                player.selected[i] = 1;
//                MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() + "选择的骰子为" + i + "号骰子，且为" + DiceSide.sideName[player.diceSelected[i]] + "面\n");
//            }
//        }
//
//        MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() + "点击确定以继续");
//        while (true) {
//            if (ButtonAction.okFlag == 1) {
//                break;
//            }
//        }
//        ButtonAction.okFlag = 0;
//        System.out.println("暂停");
//        int num = myScanner.nextInt();
    }

    public static void playerLastSelect(Player player) {
        MainFrame.mainFrame.textArea.setText("====掷骰阶段====\n" + "现在由" + player.name + "进行选择\n");
        for (int i = 0; i < 6 - player.selectedDiceCnt; i++) {
            player.unSelectedDice[i] = getRandom.getRandomSide();
            if (player == Player.player1) {
                MainFrame.mainFrame.diceLabels1[i].setVisible(true);
            } else {
                MainFrame.mainFrame.diceLabels2[i].setVisible(true);
            }
        }
//        System.out.println("最后一轮选择，现在必须全选，没得选择，输入1以继续");//现在选择的格式是固定的，都必须输入六个数字，待后期改进
//        int[] selected = new int[6];
//        for (int i = 0; i < 6; i++) {
//            selected[i] = myScanner.nextInt();
//        }
//        int num = myScanner.nextInt();
        MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() + "最后一轮选择，按确定以继续");
        while (true) {
            if (ButtonAction.okFlag == 1) {
                break;
            }
        }
        ButtonAction.okFlag = 0;
//        MainFrame.mainFrame.textArea.setText("");
//        for (int i = 0; i < 6; i++) {
//            if (player.selected[i] == 0) {//如果之前没有被选择
//                player.selected[i] = 1;
//                player.diceSelected[i] = player.randomSide[i];
//                player.selectedNum[player.selectedCnt] = player.diceSelected[i];
//                player.selectedCnt++;
////                System.out.println("选择的骰子为" + i + "号骰子，且为" + DiceSide.sideName[player.randomSide[i]] + "面");
//                MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() + "选择的骰子为" + i + "号骰子，且为" + DiceSide.sideName[player.randomSide[i]] + "面\n");
//            }
//        }
//        MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() + "点击确定以继续");
//        while (true) {
//            if (ButtonAction.okFlag == 1) {
//                break;
//            }
//        }
//        ButtonAction.okFlag = 0;
    }

    public static void bothSelect(Player p1, Player p2) {
        p1.roundCnt = 0;
        p2.roundCnt = 0;
        Player.initDiceSelected(p1);
        Player.initDiceSelected(p2);

        Player.roundPlayer = p1;
        Player.playerSelect(p1);
        p1.roundCnt++;

        Player.roundPlayer = p2;
        Player.playerSelect(p2);
        p2.roundCnt++;

        Player.roundPlayer = p1;
        Player.playerSelect(p1);
        p1.roundCnt++;

        Player.roundPlayer = p2;
        Player.playerSelect(p2);
        p2.roundCnt++;

        Player.roundPlayer = p1;
        Player.playerSelect(p1);
        p1.roundCnt++;

        Player.roundPlayer = p2;
        Player.playerSelect(p2);
        p2.roundCnt++;
    }

    public static void settle1(Player p1, Player p2) {
        UpdateUI.gameState = UpdateUI.SETTLE;
        Arrays.fill(p1.sideCnt, 0);
        Arrays.fill(p2.sideCnt, 0);
        for (int i = 0; i < 6; i++) {
            if (p1.selectedDice[i] == DiceSide.axe ||
                    p1.selectedDice[i] == DiceSide.axe1 ||
                    p1.selectedDice[i] == DiceSide.axe2 ||
                    p1.selectedDice[i] == DiceSide.axe3) {
                p1.sideCnt[0]++;
            } else if (p1.selectedDice[i] == DiceSide.arrow) {
                p1.sideCnt[1]++;
            } else if (p1.selectedDice[i] == DiceSide.arrowMagic) {
                p1.sideCnt[2]++;
            } else if (p1.selectedDice[i] == DiceSide.helmet) {
                p1.sideCnt[3]++;
            } else if (p1.selectedDice[i] == DiceSide.helmetMagic) {
                p1.sideCnt[4]++;
            } else if (p1.selectedDice[i] == DiceSide.shield) {
                p1.sideCnt[5]++;
            } else if (p1.selectedDice[i] == DiceSide.shieldMagic) {
                p1.sideCnt[6]++;
            } else if (p1.selectedDice[i] == DiceSide.steal) {
                p1.sideCnt[7]++;
            } else if (p1.selectedDice[i] == DiceSide.stealMagic) {
                p1.sideCnt[8]++;
            }
            if (p2.selectedDice[i] == DiceSide.axe ||
                    p2.selectedDice[i] == DiceSide.axe1 ||
                    p2.selectedDice[i] == DiceSide.axe2 ||
                    p2.selectedDice[i] == DiceSide.axe3) {
                p2.sideCnt[0]++;
            } else if (p2.selectedDice[i] == DiceSide.arrow) {
                p2.sideCnt[1]++;
            } else if (p2.selectedDice[i] == DiceSide.arrowMagic) {
                p2.sideCnt[2]++;
            } else if (p2.selectedDice[i] == DiceSide.helmet) {
                p2.sideCnt[3]++;
            } else if (p2.selectedDice[i] == DiceSide.helmetMagic) {
                p2.sideCnt[4]++;
            } else if (p2.selectedDice[i] == DiceSide.shield) {
                p2.sideCnt[5]++;
            } else if (p2.selectedDice[i] == DiceSide.shieldMagic) {
                p2.sideCnt[6]++;
            } else if (p2.selectedDice[i] == DiceSide.steal) {
                p2.sideCnt[7]++;
            } else if (p2.selectedDice[i] == DiceSide.stealMagic) {
                p2.sideCnt[8]++;
            }
        }//统计结果

//        for (int i = 0; i < 9; i++) {
//            System.out.print(i + "-" + p1.sideCnt[i] + "  ");
//        }
//        System.out.println();
//        for (int i = 0; i < 9; i++) {
//            System.out.print(i + "-" + p2.sideCnt[i] + "  ");
//        }
//        System.out.println();

        int k1 = 0;
        int k2 = 1;
        if (Player.firstPlayer == Player.player1) {
            k1 = 0;
            k2 = 1;
        } else {
            k1 = 1;
            k2 = 0;
        }
        int pos = 0;
        pos = Math.max(p1.sideCnt[0], p2.sideCnt[3] + p2.sideCnt[4]);
        for (int i = 0; i < pos; i++) {
            if (i < p1.sideCnt[0]) {
                ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/axe.png"));
                diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                MainFrame.mainFrame.settleLabels[k1][i].setIcon(diceImageIcon);
                MainFrame.mainFrame.settleLabels[k1][i].setVisible(true);
            } else {
                MainFrame.mainFrame.settleLabels[k1][i].setVisible(false);
            }
            if (i < p2.sideCnt[3]) {
                ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/helmet.png"));
                diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                MainFrame.mainFrame.settleLabels[k2][i].setIcon(diceImageIcon);
                MainFrame.mainFrame.settleLabels[k2][i].setVisible(true);
            } else if (i < p2.sideCnt[3] + p2.sideCnt[4]) {
                ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/helmetMagic.png"));
                diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                MainFrame.mainFrame.settleLabels[k2][i].setIcon(diceImageIcon);
                MainFrame.mainFrame.settleLabels[k2][i].setVisible(true);
            } else {
                MainFrame.mainFrame.settleLabels[k2][i].setVisible(false);
            }
        }//结算先手斧子

        for (int i = pos; i < pos + Math.max(p1.sideCnt[1] + p1.sideCnt[2], p2.sideCnt[5] + p2.sideCnt[6]); i++) {
            if (i < pos + p1.sideCnt[1]) {
                ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/arrow.png"));
                diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                MainFrame.mainFrame.settleLabels[k1][i].setIcon(diceImageIcon);
                MainFrame.mainFrame.settleLabels[k1][i].setVisible(true);
            } else if (i < pos + p1.sideCnt[1] + p1.sideCnt[2]) {
                ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/arrowMagic.png"));
                diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                MainFrame.mainFrame.settleLabels[k1][i].setIcon(diceImageIcon);
                MainFrame.mainFrame.settleLabels[k1][i].setVisible(true);
            } else {
                MainFrame.mainFrame.settleLabels[k1][i].setVisible(false);
            }
            if (i < pos + p2.sideCnt[5]) {
                ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/shield.png"));
                diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                MainFrame.mainFrame.settleLabels[k2][i].setIcon(diceImageIcon);
                MainFrame.mainFrame.settleLabels[k2][i].setVisible(true);
            } else if (i < pos + p2.sideCnt[5] + p2.sideCnt[6]) {
                ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/shieldMagic.png"));
                diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                MainFrame.mainFrame.settleLabels[k2][i].setIcon(diceImageIcon);
                MainFrame.mainFrame.settleLabels[k2][i].setVisible(true);
            } else {
                MainFrame.mainFrame.settleLabels[k2][i].setVisible(false);
            }
        }
        //结算先手弓箭
        pos = pos + Math.max(p1.sideCnt[1] + p1.sideCnt[2], p2.sideCnt[5] + p2.sideCnt[6]);

        for (int i = pos; i < pos + Math.max(p1.sideCnt[3] + p1.sideCnt[4], p2.sideCnt[0]); i++) {
            if (i < pos + p1.sideCnt[3]) {
                ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/helmet.png"));
                diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                MainFrame.mainFrame.settleLabels[k1][i].setIcon(diceImageIcon);
                MainFrame.mainFrame.settleLabels[k1][i].setVisible(true);
            } else if (i < pos + p1.sideCnt[3] + p1.sideCnt[4]) {
                ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/helmetMagic.png"));
                diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                MainFrame.mainFrame.settleLabels[k1][i].setIcon(diceImageIcon);
                MainFrame.mainFrame.settleLabels[k1][i].setVisible(true);
            } else {
                MainFrame.mainFrame.settleLabels[k1][i].setVisible(false);
            }
            if (i < pos + p2.sideCnt[0]) {
                ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/axe.png"));
                diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                MainFrame.mainFrame.settleLabels[k2][i].setIcon(diceImageIcon);
                MainFrame.mainFrame.settleLabels[k2][i].setVisible(true);
            } else {
                MainFrame.mainFrame.settleLabels[k2][i].setVisible(false);
            }
        }
        //后手斧子
        pos = pos + Math.max(p1.sideCnt[3] + p1.sideCnt[4], p2.sideCnt[0]);

        for (int i = pos; i < pos + Math.max(p1.sideCnt[5] + p1.sideCnt[6], p2.sideCnt[1] + p2.sideCnt[2]); i++) {
            if (i < pos + p1.sideCnt[5]) {
                ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/shield.png"));
                diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                MainFrame.mainFrame.settleLabels[k1][i].setIcon(diceImageIcon);
                MainFrame.mainFrame.settleLabels[k1][i].setVisible(true);
            } else if (i < pos + p1.sideCnt[5] + p1.sideCnt[6]) {
                ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/shieldMagic.png"));
                diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                MainFrame.mainFrame.settleLabels[k1][i].setIcon(diceImageIcon);
                MainFrame.mainFrame.settleLabels[k1][i].setVisible(true);
            } else {
                MainFrame.mainFrame.settleLabels[k1][i].setVisible(false);
            }
            if (i < pos + p2.sideCnt[1]) {
                ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/arrow.png"));
                diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                MainFrame.mainFrame.settleLabels[k2][i].setIcon(diceImageIcon);
                MainFrame.mainFrame.settleLabels[k2][i].setVisible(true);
            } else if (i < pos + p2.sideCnt[1] + p2.sideCnt[2]) {
                ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/arrowMagic.png"));
                diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                MainFrame.mainFrame.settleLabels[k2][i].setIcon(diceImageIcon);
                MainFrame.mainFrame.settleLabels[k2][i].setVisible(true);
            } else {
                MainFrame.mainFrame.settleLabels[k2][i].setVisible(false);
            }
        }
        //后手弓箭
        pos = pos + Math.max(p1.sideCnt[5] + p1.sideCnt[6], p2.sideCnt[1] + p2.sideCnt[2]);

        for (int i = pos; i < pos + Math.max(p1.sideCnt[7] + p1.sideCnt[8], p2.sideCnt[7] + p2.sideCnt[8]); i++) {
            if (i < pos + p1.sideCnt[7]) {
                ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/steal.png"));
                diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                MainFrame.mainFrame.settleLabels[k1][i].setIcon(diceImageIcon);
                MainFrame.mainFrame.settleLabels[k1][i].setVisible(true);
            } else if (i < pos + p1.sideCnt[7] + p1.sideCnt[8]) {
                ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/stealMagic.png"));
                diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                MainFrame.mainFrame.settleLabels[k1][i].setIcon(diceImageIcon);
                MainFrame.mainFrame.settleLabels[k1][i].setVisible(true);
            }
            if (i < pos + p2.sideCnt[7]) {
                ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/steal.png"));
                diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                MainFrame.mainFrame.settleLabels[k2][i].setIcon(diceImageIcon);
                MainFrame.mainFrame.settleLabels[k2][i].setVisible(true);
            } else if (i < pos + p2.sideCnt[7] + p2.sideCnt[8]) {
                ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/stealMagic.png"));
                diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                MainFrame.mainFrame.settleLabels[k2][i].setIcon(diceImageIcon);
                MainFrame.mainFrame.settleLabels[k2][i].setVisible(true);
            }
        }
        //steal


    }

    public static void settle2(Player p1, Player p2) {
        int pos = 0;
        p1.blockCnt = 0;
        p2.blockCnt = 0;

        if (p1.sideCnt[2] + p1.sideCnt[4] + p1.sideCnt[6] + p1.sideCnt[8] + p2.sideCnt[2] + p2.sideCnt[4] + p2.sideCnt[6] + p2.sideCnt[8] != 0) {
            MainFrame.mainFrame.okButton.setVisible(true);
            ButtonAction.okFlag = 0;
            while (true) {
                if (ButtonAction.okFlag == 1) {
                    break;
                }
            }
            ButtonAction.okFlag = 0;

            p1.magic = p1.magic + p1.sideCnt[2] + p1.sideCnt[4] + p1.sideCnt[6] + p1.sideCnt[8];
            p2.magic = p2.magic + p2.sideCnt[2] + p2.sideCnt[4] + p2.sideCnt[6] + p2.sideCnt[8];
        }

        if (p1.sideCnt[0] + p2.sideCnt[3] + p2.sideCnt[4] != 0) {
            MainFrame.mainFrame.okButton.setVisible(true);
            ButtonAction.okFlag = 0;
            while (true) {
                if (ButtonAction.okFlag == 1) {
                    break;
                }
            }
            ButtonAction.okFlag = 0;

            for (int i = 0; i < Math.max(p1.sideCnt[0], p2.sideCnt[3] + p2.sideCnt[4]); i++) {
                MainFrame.mainFrame.settleLabels[0][i].setVisible(false);
                MainFrame.mainFrame.settleLabels[1][i].setVisible(false);
            }
            pos = Math.max(p1.sideCnt[0], p2.sideCnt[3] + p2.sideCnt[4]);
            p2.blockCnt += Math.min(p1.sideCnt[0], p2.sideCnt[3] + p2.sideCnt[4]);
            if (p1.sideCnt[0] > p2.sideCnt[3] + p2.sideCnt[4]) {
                p2.hp = p2.hp - (p1.sideCnt[0] - (p2.sideCnt[3] + p2.sideCnt[4]));
            }
            isLose(p1, p2);
            if (ButtonAction.loseFlag == 1) {
                return;
            }
        }

        if (p1.sideCnt[1] + p1.sideCnt[2] + p2.sideCnt[5] + p2.sideCnt[6] != 0) {
            MainFrame.mainFrame.okButton.setVisible(true);
            ButtonAction.okFlag = 0;
            while (true) {
                if (ButtonAction.okFlag == 1) {
                    break;
                }
            }
            ButtonAction.okFlag = 0;

            for (int i = pos; i < pos + Math.max(p1.sideCnt[1] + p1.sideCnt[2], p2.sideCnt[5] + p2.sideCnt[6]); i++) {
                MainFrame.mainFrame.settleLabels[0][i].setVisible(false);
                MainFrame.mainFrame.settleLabels[1][i].setVisible(false);
            }
            pos = pos + Math.max(p1.sideCnt[1] + p1.sideCnt[2], p2.sideCnt[5] + p2.sideCnt[6]);
            p2.blockCnt += Math.min(p1.sideCnt[1] + p1.sideCnt[2], p2.sideCnt[5] + p2.sideCnt[6]);
            if (p1.sideCnt[1] + p1.sideCnt[2] > p2.sideCnt[5] + p2.sideCnt[6]) {
                p2.hp = p2.hp - ((p1.sideCnt[1] + p1.sideCnt[2]) - (p2.sideCnt[5] + p2.sideCnt[6]));
            }
            isLose(p1, p2);
            if (ButtonAction.loseFlag == 1) {
                return;
            }
        }

        if (p1.sideCnt[3] + p1.sideCnt[4] + p2.sideCnt[0] != 0) {
            MainFrame.mainFrame.okButton.setVisible(true);
            ButtonAction.okFlag = 0;
            while (true) {
                if (ButtonAction.okFlag == 1) {
                    break;
                }
            }
            ButtonAction.okFlag = 0;

            for (int i = pos; i < pos + Math.max(p1.sideCnt[3] + p1.sideCnt[4], p2.sideCnt[0]); i++) {
                MainFrame.mainFrame.settleLabels[0][i].setVisible(false);
                MainFrame.mainFrame.settleLabels[1][i].setVisible(false);
            }
            pos = pos + Math.max(p1.sideCnt[3] + p1.sideCnt[4], p2.sideCnt[0]);
            p1.blockCnt += Math.min(p1.sideCnt[3] + p1.sideCnt[4], p2.sideCnt[0]);
            if (p1.sideCnt[3] + p1.sideCnt[4] < p2.sideCnt[0]) {
                p1.hp = p1.hp - (p2.sideCnt[0] - (p1.sideCnt[3] + p1.sideCnt[4]));
            }
            isLose(p1, p2);
            if (ButtonAction.loseFlag == 1) {
                return;
            }
        }

        if (p1.sideCnt[5] + p1.sideCnt[6] + p2.sideCnt[1] + p2.sideCnt[2] != 0) {
            MainFrame.mainFrame.okButton.setVisible(true);
            ButtonAction.okFlag = 0;
            while (true) {
                if (ButtonAction.okFlag == 1) {
                    break;
                }
            }
            ButtonAction.okFlag = 0;

            for (int i = pos; i < pos + Math.max(p1.sideCnt[5] + p1.sideCnt[6], p2.sideCnt[1] + p2.sideCnt[2]); i++) {
                MainFrame.mainFrame.settleLabels[0][i].setVisible(false);
                MainFrame.mainFrame.settleLabels[1][i].setVisible(false);
            }
            pos = pos + Math.max(p1.sideCnt[5] + p1.sideCnt[6], p2.sideCnt[1] + p2.sideCnt[2]);
            p1.blockCnt += Math.min(p1.sideCnt[5] + p1.sideCnt[6], p2.sideCnt[1] + p2.sideCnt[2]);
            if (p2.sideCnt[1] + p2.sideCnt[2] > p1.sideCnt[5] + p1.sideCnt[6]) {
                p1.hp = p1.hp - ((p2.sideCnt[1] + p2.sideCnt[2]) - (p1.sideCnt[5] + p1.sideCnt[6]));
            }
            isLose(p1, p2);
            if (ButtonAction.loseFlag == 1) {
                return;
            }
        }

        if (p1.sideCnt[7] + p1.sideCnt[8] + p2.sideCnt[7] + p2.sideCnt[8] != 0) {
            MainFrame.mainFrame.okButton.setVisible(true);
            ButtonAction.okFlag = 0;
            while (true) {
                if (ButtonAction.okFlag == 1) {
                    break;
                }
            }
            ButtonAction.okFlag = 0;

            for (int i = 0; i < 12; i++) {
                MainFrame.mainFrame.settleLabels[0][i].setVisible(false);
                MainFrame.mainFrame.settleLabels[1][i].setVisible(false);
            }
            p1.magic = p1.magic + Math.min(p1.sideCnt[7] + p1.sideCnt[8], p2.magic);
            p2.magic = p2.magic - Math.min(p1.sideCnt[7] + p1.sideCnt[8], p2.magic);

            p2.magic = p2.magic + Math.min(p2.sideCnt[7] + p2.sideCnt[8], p1.magic);
            p1.magic = p1.magic - Math.min(p2.sideCnt[7] + p2.sideCnt[8], p1.magic);
        }

        if (p1.godsGraceNum != 0) {
            ButtonAction.okFlag = 0;
            while (true) {
                if (ButtonAction.okFlag == 1) {
                    break;
                }
            }
            ButtonAction.okFlag = 0;

            switch (p1.godsGraceNum) {
                case 1:
                    Gods.thor(p1, p2, p1.godsGraceLevel);
                    break;
                case 2:
                    Gods.heimdallr(p1, p2, p1.godsGraceLevel);
                    break;
            }
            p1.godsGraceNum = 0;
            isLose(p1, p2);
        }

        if (p2.godsGraceNum != 0) {
            ButtonAction.okFlag = 0;
            while (true) {
                if (ButtonAction.okFlag == 1) {
                    break;
                }
            }
            ButtonAction.okFlag = 0;

            switch (p2.godsGraceNum) {
                case 1:
                    Gods.thor(p2, p1, p2.godsGraceLevel);
                    break;
                case 2:
                    Gods.heimdallr(p2, p1, p2.godsGraceLevel);
                    break;
            }
            p2.godsGraceNum = 0;
            isLose(p2, p1);
        }

        Player.initDiceSelected(p1);
        Player.initDiceSelected(p2);
    }

    public static void settle(Player p1, Player p2) {
        UpdateUI.gameState = UpdateUI.SETTLE;
        MainFrame.mainFrame.textArea.setText("====结算阶段====\n");
        int magic1 = 0, axe1 = 0, helmat1 = 0, arrow1 = 0, shield1 = 0, steal1 = 0;
        int magic2 = 0, axe2 = 0, helmat2 = 0, arrow2 = 0, shield2 = 0, steal2 = 0;
        p1.blockCnt = 0;
        p2.blockCnt = 0;
        for (int i = 0; i < 6; i++) {//结算
            if (DiceSide.isMagic(p1.selectedDice[i])) {
                magic1++;
            }
            if (p1.selectedDice[i] == DiceSide.axe || p1.selectedDice[i] == DiceSide.axe1 || p1.selectedDice[i] == DiceSide.axe2 || p1.selectedDice[i] == DiceSide.axe3) {
                axe1++;
            }
            if (p1.selectedDice[i] == DiceSide.helmet || p1.selectedDice[i] == DiceSide.helmetMagic) {
                helmat1++;
            }
            if (p1.selectedDice[i] == DiceSide.arrow || p1.selectedDice[i] == DiceSide.arrowMagic) {
                arrow1++;
            }
            if (p1.selectedDice[i] == DiceSide.shield || p1.selectedDice[i] == DiceSide.shieldMagic) {
                shield1++;
            }
            if (p1.selectedDice[i] == DiceSide.steal || p1.selectedDice[i] == DiceSide.stealMagic) {
                steal1++;
            }

            if (DiceSide.isMagic(p2.selectedDice[i])) {
                magic2++;
            }
            if (p2.selectedDice[i] == DiceSide.axe || p2.selectedDice[i] == DiceSide.axe1 || p2.selectedDice[i] == DiceSide.axe2 || p2.selectedDice[i] == DiceSide.axe3) {
                axe2++;
            }
            if (p2.selectedDice[i] == DiceSide.helmet || p2.selectedDice[i] == DiceSide.helmetMagic) {
                helmat2++;
            }
            if (p2.selectedDice[i] == DiceSide.arrow || p2.selectedDice[i] == DiceSide.arrowMagic) {
                arrow2++;
            }
            if (p2.selectedDice[i] == DiceSide.shield || p2.selectedDice[i] == DiceSide.shieldMagic) {
                shield2++;
            }
            if (p2.selectedDice[i] == DiceSide.steal || p2.selectedDice[i] == DiceSide.stealMagic) {
                steal2++;
            }
        }

//        int paintSettleCnt1 = 0;
//        int paintSettleCnt2 = 0;
//        if (Player.firstPlayer == Player.player1) {
//            for (int i = 0; i < 6; i++) {
//                if (Player.player1.selectedDice[i] == DiceSide.axe ||
//                        Player.player1.selectedDice[i] == DiceSide.axe1 ||
//                        Player.player1.selectedDice[i] == DiceSide.axe2 ||
//                        Player.player1.selectedDice[i] == DiceSide.axe3) {
//                    ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/axe.png"));
//                    diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
//                    MainFrame.mainFrame.settleLabels1[paintSettleCnt1].setIcon(diceImageIcon);
//                    MainFrame.mainFrame.settleLabels1[paintSettleCnt1].setVisible(true);
//                    paintSettleCnt1++;
//                }
//            }
//            for (int i = 0; i < 6; i++) {
//                if (Player.player2.selectedDice[i] == DiceSide.helmet) {
//                    ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/helmet.png"));
//                    diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
//                    MainFrame.mainFrame.settleLabels2[paintSettleCnt2].setIcon(diceImageIcon);
//                    MainFrame.mainFrame.settleLabels2[paintSettleCnt2].setVisible(true);
//                    paintSettleCnt2++;
//                }else if(Player.player2.selectedDice[i] == DiceSide.helmetMagic){
//                    ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/helmetMagic.png"));
//                    diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
//                    MainFrame.mainFrame.settleLabels2[paintSettleCnt2].setIcon(diceImageIcon);
//                    MainFrame.mainFrame.settleLabels2[paintSettleCnt2].setVisible(true);
//                    paintSettleCnt2++;
//                }
//            }
//            if (paintSettleCnt1 < paintSettleCnt2) {
//                for (int i = paintSettleCnt1; i < paintSettleCnt2; i++) {
//                    MainFrame.mainFrame.settleLabels1[i].setVisible(false);
//                }
//            } else {
//                for (int i = paintSettleCnt2; i < paintSettleCnt1; i++) {
//                    MainFrame.mainFrame.settleLabels2[i].setVisible(false);
//                }
//            }
//            paintSettleCnt1 = paintSettleCnt2 = Math.max(paintSettleCnt1, paintSettleCnt2);
//            //先手斧头对后手头盔
//
//            for (int i = 0; i < 6; i++) {
//                if(Player.player1.selectedDice[i] == DiceSide.arrow){
//                    ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/arrow.png"));
//                    diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
//                    MainFrame.mainFrame.settleLabels1[paintSettleCnt1].setIcon(diceImageIcon);
//                    MainFrame.mainFrame.settleLabels1[paintSettleCnt1].setVisible(true);
//                    paintSettleCnt1++;
//                }else if(Player.player1.selectedDice[i] == DiceSide.arrowMagic){
//                    ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/arrowMagic.png"));
//                    diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
//                    MainFrame.mainFrame.settleLabels1[paintSettleCnt1].setIcon(diceImageIcon);
//                    MainFrame.mainFrame.settleLabels1[paintSettleCnt1].setVisible(true);
//                    paintSettleCnt1++;
//                }
//            }
//            for (int i = 0; i < 6; i++) {
//                if(Player.player2.selectedDice[i] == DiceSide.shield){
//                    ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/shield.png"));
//                    diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
//                    MainFrame.mainFrame.settleLabels2[paintSettleCnt2].setIcon(diceImageIcon);
//                    MainFrame.mainFrame.settleLabels2[paintSettleCnt2].setVisible(true);
//                    paintSettleCnt2++;
//                }else if(Player.player2.selectedDice[i] == DiceSide.shieldMagic){
//                    ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/shieldMagic.png"));
//                    diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
//                    MainFrame.mainFrame.settleLabels2[paintSettleCnt2].setIcon(diceImageIcon);
//                    MainFrame.mainFrame.settleLabels2[paintSettleCnt2].setVisible(true);
//                    paintSettleCnt2++;
//                }
//            }
//            if (paintSettleCnt1 < paintSettleCnt2) {
//                for (int i = paintSettleCnt1; i < paintSettleCnt2; i++) {
//                    MainFrame.mainFrame.settleLabels1[i].setVisible(false);
//                }
//            } else {
//                for (int i = paintSettleCnt2; i < paintSettleCnt1; i++) {
//                    MainFrame.mainFrame.settleLabels2[i].setVisible(false);
//                }
//            }
//            paintSettleCnt1 = paintSettleCnt2 = Math.max(paintSettleCnt1, paintSettleCnt2);
//            //先手弓箭对后手盾牌
//        }

        p1.magic += magic1;
        p2.magic += magic2;
        MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                p1.name + "的magic +" + magic1 + "\n");
        MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                p2.name + "的magic +" + magic2 + "\n");

        if (axe1 - helmat2 > 0) {//斧子扣血
            p2.hp = p2.hp - (axe1 - helmat2);
            MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                    p2.name + "被斧子伤害" + (axe1 - helmat2) + "点血量\n");
        } else {
            MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                    p2.name + "没有被斧子伤害\n");
        }
        p2.blockCnt += Math.min(axe1, helmat2);
        isLose(p1, p2);

        if (arrow1 - shield2 > 0) {
            p2.hp = p2.hp - arrow1 - shield2;
            MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                    p2.name + "被弓箭伤害" + (arrow1 - shield2) + "点血量\n");
        } else {
            MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                    p2.name + "没有被弓箭伤害\n");
        }
        p2.blockCnt += Math.min(arrow1, shield2);
        isLose(p1, p2);

        if (axe2 - helmat1 > 0) {//斧子扣血
            p1.hp = p1.hp - (axe2 - helmat1);
            MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                    p1.name + "被斧子伤害" + (axe2 - helmat1) + "点血量\n");
        } else {
            MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                    p1.name + "没有被斧子伤害\n");
        }
        p1.blockCnt += Math.min(axe2, helmat1);
        isLose(p2, p1);

        if (arrow2 - shield1 > 0) {
            p1.hp = p1.hp - arrow2 - shield1;
            MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                    p1.name + "被弓箭伤害" + (arrow2 - shield1) + "点血量\n");
        } else {
            MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                    p1.name + "没有被弓箭伤害\n");
        }
        p1.blockCnt += Math.min(arrow2, shield1);
        isLose(p2, p1);

        if (steal1 > 0 && p2.magic > 0) {
            int t = Math.min(steal1, p2.magic);
            p2.magic -= t;
            MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                    p2.name + "被偷走" + t + "点魔力\n");
        } else {
            MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                    p2.name + "没有被偷走魔力\n");
        }

        if (steal2 > 0 && p1.magic > 0) {
            int t = Math.min(steal2, p1.magic);
            p1.magic -= t;
            MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                    p1.name + "被偷走" + t + "点魔力\n");
        } else {
            MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                    p1.name + "没有被偷走魔力\n");
        }

        switch (p1.godsGraceNum) {
            case 1:
                Gods.thor(p1, p2, p1.godsGraceLevel);
                break;
            case 2:
                Gods.heimdallr(p1, p2, p1.godsGraceLevel);
                break;
        }
        p1.godsGraceNum = 0;
        isLose(p1, p2);
        switch (p2.godsGraceNum) {
            case 1:
                Gods.thor(p2, p1, p2.godsGraceLevel);
                break;
            case 2:
                Gods.heimdallr(p2, p1, p2.godsGraceLevel);
                break;
        }
        p2.godsGraceNum = 0;

        Player.initDiceSelected(p1);
        Player.initDiceSelected(p2);

        isLose(p2, p1);
    }

    public static void godsGracePlay(Player player) {
        MainFrame.mainFrame.textArea.setText("====众神恩惠阶段====\n" + "请" + player.name + "选择是否要使用众神恩惠(是/否)");
        MainFrame.mainFrame.godsGraceBtn1.setVisible(true);
        MainFrame.mainFrame.godsGraceBtn2.setVisible(true);
        MainFrame.mainFrame.coinTextLabel1.setVisible(true);
        MainFrame.mainFrame.coinTextLabel2.setVisible(true);
        MainFrame.mainFrame.coinTextLabel1.setText("————众神恩惠阶段————");
        MainFrame.mainFrame.coinTextLabel2.setText(player.name + "选择是否要使用众神恩惠");
        MainFrame.mainFrame.okButton.setVisible(false);
        MainFrame.mainFrame.coinTextLabel1.setVisible(true);
        MainFrame.mainFrame.coinTextLabel2.setVisible(true);
        ButtonAction.godsFlag = -1;
        while (true) {
            if (ButtonAction.godsFlag != -1) {
                break;
            }
        }
        if (ButtonAction.godsFlag == 1) {
            ButtonAction.godsFlag = -1;
            MainFrame.mainFrame.textArea.setText("请" + player.name + "选择向哪位众神献祭\n" + "-索尔怒袭--1\n" + "-海姆达尔之眼--2\n");
            MainFrame.mainFrame.coinTextLabel1.setText(Player.roundPlayer.name + "选择众神进行献祭");
            MainFrame.mainFrame.coinTextLabel2.setText("索尔怒袭/海姆达尔之眼");
            MainFrame.mainFrame.coinTextLabel1.setVisible(true);
            MainFrame.mainFrame.coinTextLabel2.setVisible(true);
            while (true) {
                if (ButtonAction.godsGraceNum != 0) {
                    break;
                }
            }
            MainFrame.mainFrame.coinTextLabel1.setVisible(false);
            MainFrame.mainFrame.coinTextLabel2.setVisible(false);
            player.godsGraceNum = ButtonAction.godsGraceNum;
            ButtonAction.godsGraceNum = 0;

            for (int i = 0; i < 3; i++) {
                MainFrame.mainFrame.levelBtns[i].setVisible(true);
            }
            MainFrame.mainFrame.coinTextLabel1.setText("请选择献祭等级");
            MainFrame.mainFrame.coinTextLabel1.setVisible(true);

            switch (player.godsGraceNum) {
                case 1:
                    MainFrame.mainFrame.textArea.setText("请选择消耗的魔力值(索尔怒袭)\n"
                            + "level1-消耗4点魔力造成2点伤害-\n"
                            + "level2-消耗8点魔力造成5点伤害-\n"
                            + "level3-消耗12点魔力造成8点伤害-");
                    while (true) {
                        if (ButtonAction.godsLevelNum != 0) {
                            break;
                        }
                    }
                    player.godsGraceLevel = ButtonAction.godsLevelNum;
                    ButtonAction.godsLevelNum = 0;
                    break;
                case 2:
                    MainFrame.mainFrame.textArea.setText("请选择消耗的魔力值(海姆达尔之眼)\n"
                            + "level1-消耗4点魔力每格挡一次攻击+1点生命值-\n"
                            + "level2-消耗7点魔力每格挡一次攻击+2点生命值-\n"
                            + "level3-消耗10点魔力每格挡一次攻击+3点生命值-");
                    while (true) {
                        if (ButtonAction.godsLevelNum != 0) {
                            break;
                        }
                    }
                    player.godsGraceLevel = ButtonAction.godsLevelNum;
                    ButtonAction.godsLevelNum = 0;
                    break;
            }

            for (int i = 0; i < 3; i++) {
                MainFrame.mainFrame.levelBtns[i].setVisible(false);
            }
            MainFrame.mainFrame.coinTextLabel1.setVisible(false);

        }
        MainFrame.mainFrame.coinTextLabel1.setVisible(false);
        MainFrame.mainFrame.coinTextLabel2.setVisible(false);
    }

    public static void godsGrace(Player p1, Player p2) {
        Player.roundPlayer = p1;
        godsGracePlay(p1);
        Player.roundPlayer = p2;
        godsGracePlay(p2);
    }

    public static void isLose(Player p1, Player p2) {
        if (p2.hp <= 0) {
            MainFrame.mainFrame.coinTextLabel2.setText("游戏结束，" + p1.name + "战胜了" + p2.name);
            MainFrame.mainFrame.coinTextLabel2.setVisible(true);
            ButtonAction.loseFlag = 1;
        }
        if (p1.hp <= 0) {
            MainFrame.mainFrame.coinTextLabel2.setText("游戏结束，" + p1.name + "战胜了" + p2.name);
            MainFrame.mainFrame.coinTextLabel2.setVisible(true);
            ButtonAction.loseFlag = 1;
        }
    }
}
