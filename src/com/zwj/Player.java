package com.zwj;

import java.util.Arrays;
import java.util.Scanner;

public class Player {
    public String name;
    public int hp = 15;
    public int magic = 0;
    public Dice[] dice = new Dice[6];
    //�Ծֵ��׶ι��̱���
    public int[] diceSelected = new int[6];//����-1Ϊδѡ����������Ϊѡ���Ҵ���ѡ����һ�������Ϣ
    public int[] randomSide = new int[6];//����ÿһ�������õ��������
    public int[] selected = new int[6];//����һ����غ��Ѿ���ѡ����������
    public int godsGraceFlag = -1;//-1Ϊ��ʹ���������
    public int godsGraceNum = 0;//ѡ����һ��������ݣ�0Ϊ����ŭϮ��1Ϊ��ķ���֮��
    public int godsGraceLevel = 0;//������ݵȼ�
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
        //����-1Ϊδѡ����������Ϊѡ���Ҵ���ѡ����һ�������Ϣ
        Arrays.fill(arr, 0);
    }

    public static void playerSelect(Player player) {
        Scanner myScanner = new Scanner(System.in);
//        System.out.println("====�����׶�====");
//        System.out.println("������" + player.name + "����ѡ��");
        MainFrame.mainFrame.textArea.setText("====�����׶�====" + "\n" + "������" + player.name + "����ѡ��\n");
        for (int i = 0; i < 6; i++) {
            if (player.diceSelected[i] == 0) {//���������ӻ�û�б�ѡ��
                player.randomSide[i] = getRandom.getRandomSide();
//                System.out.println("����" + i + "Ϊ" + DiceSide.sideName[player.randomSide[i]]);
                MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() + "����" + i + "Ϊ" + DiceSide.sideName[player.randomSide[i]] + "\n");
            }
        }
//        System.out.println("ѡ�����ӱ���������֮��ȷ��(��ʽ��0 1 0 1 1 0)");//����ѡ��ĸ�ʽ�ǹ̶��ģ������������������֣������ڸĽ�
        MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() + "ѡ�����ӱ���������֮��ȷ��");

        while (true) {
            if (ButtonAction.okFlag == 1) {
                break;
            }
        }
        ButtonAction.okFlag = 0;

        MainFrame.mainFrame.textArea.setText("");
        for (int i = 0; i < 6; i++) {
            if (player.selected[i] == 0 && player.diceSelected[i] != 0) {//����ո�ѡ�������(��һ��û�б�ѡ��)
//                System.out.println("ѡ�������Ϊ" + i + "�����ӣ���Ϊ" + DiceSide.sideName[player.diceSelected[i]] + "��");
                player.selected[i] = 1;
                MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() + "ѡ�������Ϊ" + i + "�����ӣ���Ϊ" + DiceSide.sideName[player.diceSelected[i]] + "��\n");
            }
        }

        MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() + "���ȷ���Լ���");
        while (true) {
            if (ButtonAction.okFlag == 1) {
                break;
            }
        }
        ButtonAction.okFlag = 0;
//        System.out.println("��ͣ");
//        int num = myScanner.nextInt();
    }

    public static void playerLastSelect(Player player) {
        Scanner myScanner = new Scanner(System.in);//�ǵ�ɾ��
//        System.out.println("====�����׶�====");
//        System.out.println("������" + player.name + "����ѡ��");
        MainFrame.mainFrame.textArea.setText("====�����׶�====\n" + "������" + player.name + "����ѡ��\n");
        for (int i = 0; i < 6; i++) {
            if (player.selected[i] == 0) {//���������ӻ�û�б�ѡ��
                player.randomSide[i] = getRandom.getRandomSide();
//                System.out.println("����" + i + "Ϊ" + DiceSide.sideName[player.randomSide[i]]);
                MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() + "����" + i + "Ϊ" + DiceSide.sideName[player.randomSide[i]] + "\n");
            }
        }
//        System.out.println("���һ��ѡ�����ڱ���ȫѡ��û��ѡ������1�Լ���");//����ѡ��ĸ�ʽ�ǹ̶��ģ������������������֣������ڸĽ�
//        int[] selected = new int[6];
//        for (int i = 0; i < 6; i++) {
//            selected[i] = myScanner.nextInt();
//        }
//        int num = myScanner.nextInt();
        MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() + "���һ��ѡ�񣬰�ȷ���Լ���");
        while (true) {
            if (ButtonAction.okFlag == 1) {
                break;
            }
        }
        ButtonAction.okFlag = 0;
        MainFrame.mainFrame.textArea.setText("");
        for (int i = 0; i < 6; i++) {
            if (player.selected[i] == 0) {//���֮ǰû�б�ѡ��
                player.selected[i] = 1;
                player.diceSelected[i] = player.randomSide[i];
//                System.out.println("ѡ�������Ϊ" + i + "�����ӣ���Ϊ" + DiceSide.sideName[player.randomSide[i]] + "��");
                MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() + "ѡ�������Ϊ" + i + "�����ӣ���Ϊ" + DiceSide.sideName[player.randomSide[i]] + "��\n");
            }
        }
        MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() + "���ȷ���Լ���");
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
        Player.initDiceSelected(p2.selected);//��ʼ��Ϊ-1
        Player.playerSelect(p1);
        Player.playerSelect(p2);
        Player.playerSelect(p1);
        Player.playerSelect(p2);
        Player.playerLastSelect(p1);
        Player.playerLastSelect(p2);
    }

    public static void settle(Player p1, Player p2) {
        MainFrame.mainFrame.textArea.setText("====����׶�====\n");
        int magic1 = 0, axe1 = 0, helmat1 = 0, arrow1 = 0, shield1 = 0, steal1 = 0;
        int magic2 = 0, axe2 = 0, helmat2 = 0, arrow2 = 0, shield2 = 0, steal2 = 0;
        p1.blockCnt = 0;
        p2.blockCnt = 0;
        for (int i = 0; i < 6; i++) {//����ħ��magicֵ
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
                p1.name + "��magic +" + magic1 + "\n");
        MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                p2.name + "��magic +" + magic2 + "\n");

        if (axe1 - helmat2 > 0) {//���ӿ�Ѫ
            p2.hp = p2.hp - (axe1 - helmat2);
            MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                    p2.name + "�������˺�" + (axe1 - helmat2) + "��Ѫ��\n");
        } else {
            MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                    p2.name + "û�б������˺�\n");
        }
        p2.blockCnt += Math.min(axe1, helmat2);
        isLose(p1, p2);

        if (arrow1 - shield2 > 0) {
            p2.hp = p2.hp - arrow1 - shield2;
            MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                    p2.name + "�������˺�" + (arrow1 - shield2) + "��Ѫ��\n");
        } else {
            MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                    p2.name + "û�б������˺�\n");
        }
        p2.blockCnt += Math.min(arrow1, shield2);
        isLose(p1, p2);

        if (axe2 - helmat1 > 0) {//���ӿ�Ѫ
            p1.hp = p1.hp - (axe2 - helmat1);
            MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                    p1.name + "�������˺�" + (axe2 - helmat1) + "��Ѫ��\n");
        } else {
            MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                    p1.name + "û�б������˺�\n");
        }
        p1.blockCnt += Math.min(axe2, helmat1);
        isLose(p2, p1);

        if (arrow2 - shield1 > 0) {
            p1.hp = p1.hp - arrow2 - shield1;
            MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                    p1.name + "�������˺�" + (arrow2 - shield1) + "��Ѫ��\n");
        } else {
            MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                    p1.name + "û�б������˺�\n");
        }
        p1.blockCnt += Math.min(arrow2, shield1);
        isLose(p2, p1);

        if (steal1 > 0 && p2.magic > 0) {
            int t = Math.min(steal1, p2.magic);
            p2.magic -= t;
            MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                    p2.name + "��͵��" + t + "��ħ��\n");
        } else {
            MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                    p2.name + "û�б�͵��ħ��\n");
        }

        if (steal2 > 0 && p1.magic > 0) {
            int t = Math.min(steal2, p1.magic);
            p1.magic -= t;
            MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                    p1.name + "��͵��" + t + "��ħ��\n");
        } else {
            MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                    p1.name + "û�б�͵��ħ��\n");
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
//        System.out.println("====" + player.name + "��״̬====");
//        System.out.println(player.name + "��Ѫ��:" + player.hp);
//        System.out.println(player.name + "��ħ��:" + player.magic);
//    }

    public static void godsGracePlay(Player player) {
        MainFrame.mainFrame.textArea.setText("====������ݽ׶�====\n" + "��" + player.name + "ѡ���Ƿ�Ҫʹ���������(��/��)");
        ButtonAction.godsFlag = -1;
        while (true) {
            if (ButtonAction.godsFlag != -1) {
                break;
            }
        }
        if (ButtonAction.godsFlag == 1) {
            ButtonAction.godsFlag = -1;
            MainFrame.mainFrame.textArea.setText("��" + player.name + "ѡ������λ�����׼�\n" + "-����ŭϮ--1\n" + "-��ķ���֮��--2\n");
            while (true) {
                if (ButtonAction.godsGraceNum != 0) {
                    break;
                }
            }
            player.godsGraceNum = ButtonAction.godsGraceNum;
            ButtonAction.godsGraceNum = 0;
            switch (player.godsGraceNum) {
                case 1 -> {
                    MainFrame.mainFrame.textArea.setText("��ѡ�����ĵ�ħ��ֵ(����ŭϮ)\n"
                            + "level1-����4��ħ�����2���˺�-\n"
                            + "level2-����8��ħ�����5���˺�-\n"
                            + "level3-����12��ħ�����8���˺�-");
                    while (true) {
                        if (ButtonAction.godsLevelNum != 0) {
                            break;
                        }
                    }
                    player.godsGraceLevel = ButtonAction.godsLevelNum;
                    ButtonAction.godsLevelNum = 0;
                }
                case 2 -> {
                    MainFrame.mainFrame.textArea.setText("��ѡ�����ĵ�ħ��ֵ(��ķ���֮��)\n"
                            + "level1-����4��ħ��ÿ��һ�ι���+1������ֵ-\n"
                            + "level2-����7��ħ��ÿ��һ�ι���+2������ֵ-\n"
                            + "level3-����10��ħ��ÿ��һ�ι���+3������ֵ-");
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
            System.out.println("��Ϸ������" + p1.name + "սʤ��" + p2.name);
            System.exit(0);
        }
        if (p1.hp <= 0) {
            System.out.println("��Ϸ������" + p2.name + "սʤ��" + p1.name);
            System.exit(0);
        }
    }
}
