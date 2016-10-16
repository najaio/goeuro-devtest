package com.goeuro.devtest;

import java.io.File;
import java.util.Scanner;
import java.util.Set;
import static java.util.logging.Level.INFO;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;
import static java.util.stream.Collectors.toSet;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger LOGGER = Logger.getLogger(Application.class.getName());

    @Autowired
    private BusRouteService service;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        readFile(new File(args[0]));
    }

    private void readFile(File file) {

        try (Scanner scanner = new Scanner(file)) {

            int routes = scanner.nextInt();

            scanner.nextLine();

            long start = System.nanoTime();

            for (int i = 0; i < routes; i++) {
                String line = scanner.nextLine();
                Set<Integer> extractedRoutes = extractRoutes(line);
                service.addRoutes(extractedRoutes);
            }

            long end = System.nanoTime() - start;
            LOGGER.log(INFO, "file processing time (ns): {0}", end);
            
        } catch (Exception ex) {
            LOGGER.log(SEVERE, null, ex);
        }
    }

    private Set<Integer> extractRoutes(String line) {

        //remove route id
        String stationIds = line.substring(line.indexOf(" ") + 1);

        Set<Integer> stations = Stream.of(stationIds.split(" "))
                .map(stationId -> Integer.valueOf(stationId))
                .collect(toSet());

        return stations;

    }
}
