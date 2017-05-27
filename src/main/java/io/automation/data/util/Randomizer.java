package io.automation.data.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Bonso on 5/20/2017.
 */
public class Randomizer {
    public static int random(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static int random(int max){
        return random(0,max);
    }


}
