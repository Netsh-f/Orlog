package com.zwj;

public class Dice {
    public int[] side = new int[6];
    public static Dice dice0 = new Dice(new int[]{DiceSide.axe,DiceSide.shield,DiceSide.arrowMagic,DiceSide.axe,DiceSide.helmet,DiceSide.stealMagic});
    public static Dice dice1 = new Dice(new int[]{DiceSide.axe,DiceSide.shieldMagic,DiceSide.steal,DiceSide.axe,DiceSide.arrow,DiceSide.helmetMagic});
    public static Dice dice2 = new Dice(new int[]{DiceSide.axe,DiceSide.shield,DiceSide.stealMagic,DiceSide.arrow,DiceSide.helmetMagic,DiceSide.axe});
    public static Dice dice3 = new Dice(new int[]{DiceSide.axe,DiceSide.shieldMagic,DiceSide.steal,DiceSide.axe,DiceSide.helmet,DiceSide.arrowMagic});
    public static Dice dice4 = new Dice(new int[]{DiceSide.axe,DiceSide.shieldMagic,DiceSide.arrow,DiceSide.axe,DiceSide.stealMagic,DiceSide.helmet});
    public static Dice dice5 = new Dice(new int[]{DiceSide.axe,DiceSide.arrowMagic,DiceSide.steal,DiceSide.axe,DiceSide.helmetMagic,DiceSide.shield});

    public Dice(int[] side) {
        this.side = side;
    }
}
