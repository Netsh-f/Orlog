package com.zwj;

public class Gods {
    public static void thor(Player p1, Player p2, int option) {
        switch (option) {
            case 1:
                if (p1.magic >= 4) {
                    p1.magic -= 4;
                    p2.hp -= 2;
                    MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                            p1.name + "������4��ħ��ʹ������ŭϮ��" + p2.name + "�����2���˺�\n");
                } else {
                    MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                            p1.name + "ħ�������Է�������ŭϮ\n");
                }
                break;
            case 2:
                if (p1.magic >= 8) {
                    p1.magic -= 8;
                    p2.hp -= 5;
                    MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                            p1.name + "������8��ħ��ʹ������ŭϮ��" + p2.name + "�����5���˺�\n");
                } else {
                    MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                            p1.name + "ħ�������Է�������ŭϮ\n");
                }
                break;
            case 3:
                if (p1.magic >= 12) {
                    p1.magic -= 12;
                    p2.hp -= 8;
                    MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                            p1.name + "������12��ħ��ʹ������ŭϮ��" + p2.name + "�����8���˺�\n");
                } else {
                    MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                            p1.name + "ħ�������Է�������ŭϮ\n");
                }
                break;
            default:
                MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                        p1.name + "û��ѡ���Ӧlevel��û�з�������ŭϮ\n");
                break;
        }
        p1.godsGraceFlag = -1;
        p1.godsGraceNum = 0;
        p1.godsGraceLevel = 0;
    }

    public static void heimdallr(Player p1, Player p2, int option) {
        switch (option) {
            case 1:
                if (p1.magic >= 4) {
                    p1.magic -= 4;
                    p1.hp += p1.blockCnt * 1;
                    MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                            p1.name + "�ֵ���" + p1.blockCnt + "���˺���������4��ħ��ʹ�ú�ķ���֮�ۻָ���" + p1.blockCnt * 1 + "������ֵ\n");
                } else {
                    MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                            p1.name + "ħ�������Է�����ķ���֮��\n");
                }
                break;
            case 2:
                if (p1.magic >= 7) {
                    p1.magic -= 7;
                    p1.hp += p1.blockCnt * 2;
                    MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                            p1.name + "�ֵ���" + p1.blockCnt + "���˺���������7��ħ��ʹ�ú�ķ���֮�ۻָ���" + p1.blockCnt * 2 + "������ֵ\n");
                } else {
                    MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                            p1.name + "ħ�������Է�����ķ���֮��\n");
                }
                break;
            case 3:
                if (p1.magic >= 10) {
                    p1.magic -= 10;
                    p1.hp += p1.blockCnt * 3;
                    MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                            p1.name + "�ֵ���" + p1.blockCnt + "���˺���������10��ħ��ʹ�ú�ķ���֮�ۻָ���" + p1.blockCnt * 3 + "������ֵ\n");
                } else {
                    MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                            p1.name + "ħ�������Է�����ķ���֮��\n");
                }
                break;
            default:
                MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                        p1.name + "û��ѡ���Ӧlevel��û�з���������ķ֮��\n");
                break;
        }
        p1.godsGraceFlag = -1;
        p1.godsGraceNum = 0;
        p1.godsGraceLevel = 0;
    }
}
