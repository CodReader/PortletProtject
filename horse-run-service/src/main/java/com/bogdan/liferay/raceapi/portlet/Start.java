package com.bogdan.liferay.raceapi.portlet;

import com.bogdan.lifray.daoapp.api.Horse;
import com.bogdan.lifray.daoapp.api.RaceResult;
import com.bogdan.lifray.serviceapp.api.Constants;
import com.bogdan.lifray.serviceapp.api.HorseGenerator;
import com.bogdan.lifray.serviceapp.api.Race;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Start {


    private static final Logger logger = Logger.getLogger(Start.class.getName());

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Constants.HORSE_COUNT);
        List<Horse> horses = HorseGenerator.generateHorses(Constants.HORS_SIZE);
        List<Race> races = horses.stream().map(Race::new).collect(Collectors.toList());

        try {
            List<Future<RaceResult>> results = executorService.invokeAll(races);
            printResults(results);
        } catch (InterruptedException e) {
            logger.log(Level.WARNING, "No horse on start line wtf..", e);
        } finally {
            executorService.shutdown();
        }
    }

    private static List<Future<RaceResult>> printResults(List<Future<RaceResult>> results) {
        for (int i = 0; i < Constants.HORS_SIZE; i++) {
            Future<RaceResult> future = results.get(i);
            try {
                RaceResult result = future.get();
                logger.log(Level.INFO, "Horse end run with result: {0}", result);
            } catch (InterruptedException | ExecutionException e) {
                logger.log(Level.WARNING, "Horse cant end run because GOD stop racing", e);
                Thread.currentThread().interrupt();
            }
        }
        return results;
    }

}
