package com.zwj;

public class Gods {
    public static void thor(Player p1, Player p2, int option) {
        switch (option) {
            case 1:
                if (p1.magic >= 4) {
                    p1.magic -= 4;
                    p2.hp -= 2;
                    MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                            p1.name + "消耗了4点魔力使用索尔怒袭对" + p2.name + "造成了2点伤害\n");
                } else {
                    MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                            p1.name + "魔力不足以发动索尔怒袭\n");
                }
                break;
            case 2:
                if (p1.magic >= 8) {
                    p1.magic -= 8;
                    p2.hp -= 5;
                    MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                            p1.name + "消耗了8点魔力使用索尔怒袭对" + p2.name + "造成了5点伤害\n");
                } else {
                    MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                            p1.name + "魔力不足以发动索尔怒袭\n");
                }
                break;
            case 3:
                if (p1.magic >= 12) {
                    p1.magic -= 12;
                    p2.hp -= 8;
                    MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                            p1.name + "消耗了12点魔力使用索尔怒袭对" + p2.name + "造成了8点伤害\n");
                } else {
                    MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                            p1.name + "魔力不足以发动索尔怒袭\n");
                }
                break;
            default:
                MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                        p1.name + "没有选择对应level，没有发动索尔怒袭\n");
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
                            p1.name + "抵挡了" + p1.blockCnt + "次伤害，消耗了4点魔力使用海姆达尔之眼恢复了" + p1.blockCnt * 1 + "点生命值\n");
                } else {
                    MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                            p1.name + "魔力不足以发动海姆达尔之眼\n");
                }
                break;
            case 2:
                if (p1.magic >= 7) {
                    p1.magic -= 7;
                    p1.hp += p1.blockCnt * 2;
                    MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                            p1.name + "抵挡了" + p1.blockCnt + "次伤害，消耗了7点魔力使用海姆达尔之眼恢复了" + p1.blockCnt * 2 + "点生命值\n");
                } else {
                    MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                            p1.name + "魔力不足以发动海姆达尔之眼\n");
                }
                break;
            case 3:
                if (p1.magic >= 10) {
                    p1.magic -= 10;
                    p1.hp += p1.blockCnt * 3;
                    MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                            p1.name + "抵挡了" + p1.blockCnt + "次伤害，消耗了10点魔力使用海姆达尔之眼恢复了" + p1.blockCnt * 3 + "点生命值\n");
                } else {
                    MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                            p1.name + "魔力不足以发动海姆达尔之眼\n");
                }
                break;
            default:
                MainFrame.mainFrame.textArea.setText(MainFrame.mainFrame.textArea.getText() +
                        p1.name + "没有选择对应level，没有发动海尔达姆之眼\n");
                break;
        }
        p1.godsGraceFlag = -1;
        p1.godsGraceNum = 0;
        p1.godsGraceLevel = 0;
    }
}
