package com.zwj;

import java.util.Random;

public class getRandom {
    public static int getRandomCoin(){
        Random r = new Random();
        return r.nextInt(2);//0或1 1正面 0反面
    }

    public static int getRandomSide(){
        Random r = new Random();
        return r.nextInt(10);
    }
}
