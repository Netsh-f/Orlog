package com.zwj;

import java.util.Random;

public class getRandom {
    public static int getRandomCoin(){
        Random r = new Random();
        return r.nextInt(2);//0��1 1���� 0����
    }

    public static int getRandomSide(){
        Random r = new Random();
        return r.nextInt(10);
    }
}
