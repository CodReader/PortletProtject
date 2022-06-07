package com.bogdan.lifray.serviceapp.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HorseGenerator {
    private static final Random random = new Random();

    private HorseGenerator() {
    }

   public static List<Horse> generateHorses(int horseSize) {
        List<Horse> horses = new ArrayList<>(horseSize);
        for (int i = 0; i < horseSize; i++) {
            horses.add(generateHorse());
        }
        return horses;
    }

    private static Horse generateHorse() {
        return new Horse(randomSpeed());
    }

    private static int randomAge() {
        return random.nextInt(Constants.MAX_AGE - Constants.MIN_AGE) + Constants.MIN_AGE;
    }

    public static int randomSpeed() {
        return random.nextInt(Constants.MAX_SPEED - Constants.MIN_SPEED) + Constants.MIN_SPEED % randomAge();
    }
}

