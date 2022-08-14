package com.zwj;

import java.util.Arrays;
import java.util.Scanner;

public class Player {
    public String name;
    public int hp = 15;
    public int magic = 0;
    public Dice[] dice = new Dice[6];
    //对局单阶段过程变量
    public int[] diceSelected = new int[6];//设置-1为未选择，其他数字为选择，且储存选择哪一个面的信息
    public int[] randomSide = new int[6];//储存每一次掷骰得到的随机面
    public int[] selected = new int[6];//储存一大个回合已经被选出来的骰子
    public int godsGraceFlag = -1;//-1为不使用众神恩惠
    public int godsGraceNum = 0;//选择哪一个众神恩惠，0为索尔怒袭，1为海姆达尔之眼
    public int godsGraceLevel = 0;//众神恩惠等级
    public int blockCnt = 0;

    public static Player player1 = new Player("player1");
    public static Player player2 = new Player("player2");

    public Player(String name) {
        dice[0] = Dice.dice0;
        dice[1] = Dice.dice1;
        dice[2] = Dice.dice2;
        dice[3] = Dice.dice3;
        dice[4] = Dice.dice4;
        dice[5] = Dice.dice5;
        this.name = name;
    }

    public static void initDiceSelected(int[] arr) {
        //设置-1为未选择，其他数字为选择，且储存选择哪一个面的信息
        Arrays.fill(arr, 0);
    }

    public static void playerSelect(Player player) {
        Scanner myScanner = new Scanner(System.in);
//        System.out.println("====掷骰阶段====");
//        System.out.println("现在由" + player.name + "进行选择");
        MainFrame.mainFrame.textArea.setText("====掷骰阶段====" + "\n" + "现在由" + player.name + "进行选择\n");
        for (int i = 0; i < 6; i++) {
            if (player.diceSelected[i] == 0) {//如果这个骰子还没有被选择
                player.randomSide[i] = getRandom.getRandomSide();
//                System.out.println("骰子" + i + "为" + DiceSide.sideName[player.randomSide[i]]);
                MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() + "骰子" + i + "为" + DiceSide.sideName[player.randomSide[i]] + "\n");
            }
        }
//        System.out.println("选择骰子保留点数，之后确定(格式如0 1 0 1 1 0)");//现在选择的格式是固定的，都必须输入六个数字，待后期改进
        MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() + "选择骰子保留点数，之后确定");

        while (true) {
            if (ButtonAction.okFlag == 1) {
                break;
            }
        }
        ButtonAction.okFlag = 0;

        MainFrame.mainFrame.textArea.setText("");
        for (int i = 0; i < 6; i++) {
            if (player.selected[i] == 0 && player.diceSelected[i] != 0) {//输出刚刚选择的骰子(上一次没有被选出)
//                System.out.println("选择的骰子为" + i + "号骰子，且为" + DiceSide.sideName[player.diceSelected[i]] + "面");
                player.selected[i] = 1;
                MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() + "选择的骰子为" + i + "号骰子，且为" + DiceSide.sideName[player.diceSelected[i]] + "面\n");
            }
        }

        MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() + "点击确定以继续");
        while (true) {
            if (ButtonAction.okFlag == 1) {
                break;
            }
        }
        ButtonAction.okFlag = 0;
//        System.out.println("暂停");
//        int num = myScanner.nextInt();
    }

    public static void playerLastSelect(Player player) {
        Scanner myScanner = new Scanner(System.in);//记得删掉
//        System.out.println("====掷骰阶段====");
//        System.out.println("现在由" + player.name + "进行选择");
        MainFrame.mainFrame.textArea.setText("====掷骰阶段====\n" + "现在由" + player.name + "进行选择\n");
        for (int i = 0; i < 6; i++) {
            if (player.selected[i] == 0) {//如果这个骰子还没有被选择
                player.randomSide[i] = getRandom.getRandomSide();
//                System.out.println("骰子" + i + "为" + DiceSide.sideName[player.randomSide[i]]);
                MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() + "骰子" + i + "为" + DiceSide.sideName[player.randomSide[i]] + "\n");
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
        MainFrame.mainFrame.textArea.setText("");
        for (int i = 0; i < 6; i++) {
            if (player.selected[i] == 0) {//如果之前没有被选择
                player.selected[i] = 1;
                player.diceSelected[i] = player.randomSide[i];
//                System.out.println("选择的骰子为" + i + "号骰子，且为" + DiceSide.sideName[player.randomSide[i]] + "面");
                MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() + "选择的骰子为" + i + "号骰子，且为" + DiceSide.sideName[player.randomSide[i]] + "面\n");
            }
        }
        MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() + "点击确定以继续");
        while (true) {
            if (ButtonAction.okFlag == 1) {
                break;
            }
        }
        ButtonAction.okFlag = 0;
    }

    public static void bothSelect(Player p1, Player p2) {
        Player.initDiceSelected(p1.diceSelected);
        Player.initDiceSelected(p2.diceSelected);
        Player.initDiceSelected(p1.selected);
        Player.initDiceSelected(p2.selected);//初始化为-1
        Player.playerSelect(p1);
        Player.playerSelect(p2);
        Player.playerSelect(p1);
        Player.playerSelect(p2);
        Player.playerLastSelect(p1);
        Player.playerLastSelect(p2);
    }

    public static void settle(Player p1, Player p2) {
        MainFrame.mainFrame.textArea.setText("====结算阶段====\n");
        int magic1 = 0, axe1 = 0, helmat1 = 0, arrow1 = 0, shield1 = 0, steal1 = 0;
        int magic2 = 0, axe2 = 0, helmat2 = 0, arrow2 = 0, shield2 = 0, steal2 = 0;
        p1.blockCnt = 0;
        p2.blockCnt = 0;
        for (int i = 0; i < 6; i++) {//结算魔力magic值
            if (DiceSide.isMagic(p1.diceSelected[i])) {
                magic1++;
            }
            if (p1.diceSelected[i] == DiceSide.axe || p1.diceSelected[i] == DiceSide.axe1 || p1.diceSelected[i] == DiceSide.axe2 || p1.diceSelected[i] == DiceSide.axe3) {
                axe1++;
            }
            if (p1.diceSelected[i] == DiceSide.helmet || p1.diceSelected[i] == DiceSide.helmetMagic) {
                helmat1++;
            }
            if (p1.diceSelected[i] == DiceSide.arrow || p1.diceSelected[i] == DiceSide.arrowMagic) {
                arrow1++;
            }
            if (p1.diceSelected[i] == DiceSide.shield || p1.diceSelected[i] == DiceSide.shieldMagic) {
                shield1++;
            }
            if (p1.diceSelected[i] == DiceSide.steal || p1.diceSelected[i] == DiceSide.stealMagic) {
                steal1++;
            }

            if (DiceSide.isMagic(p2.diceSelected[i])) {
                magic2++;
            }
            if (p2.diceSelected[i] == DiceSide.axe || p2.diceSelected[i] == DiceSide.axe1 || p2.diceSelected[i] == DiceSide.axe2 || p2.diceSelected[i] == DiceSide.axe3) {
                axe2++;
            }
            if (p2.diceSelected[i] == DiceSide.helmet || p2.diceSelected[i] == DiceSide.helmetMagic) {
                helmat2++;
            }
            if (p2.diceSelected[i] == DiceSide.arrow || p2.diceSelected[i] == DiceSide.arrowMagic) {
                arrow2++;
            }
            if (p2.diceSelected[i] == DiceSide.shield || p2.diceSelected[i] == DiceSide.shieldMagic) {
                shield2++;
            }
            if (p2.diceSelected[i] == DiceSide.steal || p2.diceSelected[i] == DiceSide.stealMagic) {
                steal2++;
            }
        }

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
            case 1 -> {
                Gods.thor(p1, p2, p1.godsGraceLevel);
            }
            case 2 -> {
                Gods.heimdallr(p1, p2, p1.godsGraceLevel);
            }
        }
        p1.godsGraceNum = 0;
        isLose(p1, p2);
        switch (p2.godsGraceNum) {
            case 1 -> {
                Gods.thor(p2, p1, p2.godsGraceLevel);
            }
            case 2 -> {
                Gods.heimdallr(p2, p1, p2.godsGraceLevel);
            }
        }
        p2.godsGraceNum = 0;
        isLose(p2, p1);
    }

//    public static void rintPlayerState(Player player) {
//        System.out.println("====" + player.name + "的状态====");
//        System.out.println(player.name + "的血量:" + player.hp);
//        System.out.println(player.name + "的魔力:" + player.magic);
//    }

    public static void godsGracePlay(Player player) {
        MainFrame.mainFrame.textArea.setText("====众神恩惠阶段====\n" + "请" + player.name + "选择是否要使用众神恩惠(是/否)");
        ButtonAction.godsFlag = -1;
        while (true) {
            if (ButtonAction.godsFlag != -1) {
                break;
            }
        }
        if (ButtonAction.godsFlag == 1) {
            ButtonAction.godsFlag = -1;
            MainFrame.mainFrame.textArea.setText("请" + player.name + "选择向哪位众神献祭\n" + "-索尔怒袭--1\n" + "-海姆达尔之眼--2\n");
            while (true) {
                if (ButtonAction.godsGraceNum != 0) {
                    break;
                }
            }
            player.godsGraceNum = ButtonAction.godsGraceNum;
            ButtonAction.godsGraceNum = 0;
            switch (player.godsGraceNum) {
                case 1 -> {
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
                }
                case 2 -> {
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
                }
            }
        }
    }

    public static void godsGrace(Player p1, Player p2) {
        godsGracePlay(p1);
        godsGracePlay(p2);
    }

    public static void isLose(Player p1, Player p2) {
        if (p2.hp <= 0) {
            System.out.println("游戏结束，" + p1.name + "战胜了" + p2.name);
            System.exit(0);
        }
        if (p1.hp <= 0) {
            System.out.println("游戏结束，" + p2.name + "战胜了" + p1.name);
            System.exit(0);
        }
    }
}
