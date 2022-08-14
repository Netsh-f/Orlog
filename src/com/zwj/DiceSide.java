package com.zwj;

public class DiceSide {
    public static int axe = 0;
    public static int axe1 = 1;
    public static int arrow = 2;
    public static int arrowMagic = 3;
    public static int helmet = 4;
    public static int helmetMagic = 5;
    public static int shield = 6;
    public static int shieldMagic = 7;
    public static int steal = 8;
    public static int stealMagic = 9;
    public static int axe2 = 10;
    public static int axe3 = 11;//进游戏统计发现斧子没有带魔力的，而且斧子的总数目是其他的两倍
    public static String[] sideName = {"axe", "axe1", "arrow", "arrowMagic", "helmet", "helmetMagic", "shield", "shieldMagic", "steal", "stealMagic", "axe2", "axe3"};

    public static boolean isMagic(int n) {
        return n == 3 || n == 5 || n == 7 || n == 9;
    }
}
