package com.zwj;

public class DiceSide {
    public static int axe = 0;
    public static int axeMagic = 1;
    public static int arrow = 2;
    public static int arrowMagic = 3;
    public static int helmet = 4;
    public static int helmetMagic = 5;
    public static int shield = 6;
    public static int shieldMagic = 7;
    public static int steal = 8;
    public static int stealMagic = 9;
    public static String[] sideName = {"axe", "axeMagic", "arrow", "arrowMagic", "helmet", "helmetMagic", "shield", "shieldMagic", "steal", "stealMagic"};

    public static boolean isMagic(int n) {
        return n == 1 || n == 3 || n == 5 || n == 7 || n == 9;
    }
}
