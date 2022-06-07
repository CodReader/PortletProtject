package com.bogdan.lifray.serviceapp.api;

import java.util.UUID;

public class Horse {


    private UUID id = UUID.randomUUID();

    private static int modelSpeed = HorseGenerator.randomSpeed();

    public void setId(UUID id) {
        this.id = id;
    }

    public static void setModelSpeed(int modelSpeed) {
        Horse.modelSpeed = HorseGenerator.randomSpeed();
    }

     public Horse(int modelSpeed) {
         this.modelSpeed = modelSpeed;
     }

    public UUID getId() {
        return id;
    }

    public static int getModelSpeed() {
        return modelSpeed;
    }


    @Override
    public String toString() {
        return "Horse{" +
                "id=" + id +
                '}';
    }
}
