package com.bogdan.lifray.serviceapp.api;


public class RaceRunGenerator {

    private RaceRunGenerator() {
    }

    public static int raceRun() {
        int raceTime;
        if (Constants.RACE_LENGTH != 0) {
            raceTime = Constants.RACE_LENGTH / Horse.getModelSpeed() * Constants.WEATHER;
        } else {
            System.out.println("Error");
        }
        return raceTime;
    }
}
