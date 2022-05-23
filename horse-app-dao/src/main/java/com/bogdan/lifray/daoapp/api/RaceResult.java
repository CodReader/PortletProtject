package com.bogdan.lifray.daoapp.api;

public class RaceResult {


    private int raceTime;

    private Horse horse;

    public RaceResult(Horse horse, int raceTime) {
        this.raceTime = raceTime;
        this.horse = horse;
    }

    public int getRaceTime() {
        return raceTime;
    }

    public void setRaceTime(int raceTime) {
        this.raceTime = raceTime;
    }

    public Horse getHorse() {
        return horse;
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    @Override
    public String toString() {
        return "RaceResult{" +
                "raceTime=" + raceTime +
                ", horse=" + horse +
                '}';
    }


}
