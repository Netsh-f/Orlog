package com.zwj;

public class DiceSide {
    public static int none = 0;
    public static int axe = 1;
    public static int axe1 = 2;
    public static int arrow = 3;
    public static int arrowMagic = 4;
    public static int helmet = 5;
    public static int helmetMagic = 6;
    public static int shield = 7;
    public static int shieldMagic = 8;
    public static int steal = 9;
    public static int stealMagic = 10;
    public static int axe2 = 11;
    public static int axe3 = 12;//进游戏统计发现斧子没有带魔力的，而且斧子的总数目是其他的两倍
    public static String[] sideName = {"none", "axe", "axe", "arrow", "arrowMagic", "helmet", "helmetMagic", "shield", "shieldMagic", "steal", "stealMagic", "axe", "axe"};

    public static boolean isMagic(int n) {
        return n == 4 || n == 6 || n == 8 || n == 10;
    }
}
