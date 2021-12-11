package com.engeto.urm;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PlantStorage plantStorage = new PlantStorage();
        try {
        plantStorage.loadFile("kvetiny.txt");

        System.out.println("\n\t" + "Watering information: " + "\n");
        for (Plant temp : plantStorage.plant) {
            System.out.println(temp.getWateringInfo());
        }
            System.out.println("\n\t" + "Printing added plants: ");
            plantStorage.addPlant(new Plant("Monstera", "Krasna, pekna", LocalDate.now(), LocalDate.now().plusDays(1), 3));
            plantStorage.addPlant(new Plant("Orchidej", "Pekna, krasna", LocalDate.now().minusDays(10), LocalDate.now().plusDays(5), 7));
            plantStorage.removePlant(1);
            System.out.println();
            System.out.println(plantStorage.toFile());
            plantStorage.uploadFile();
            plantStorage.loadFile("vystup.txt");

            System.out.println();

            boolean temporaryBool = true;
            boolean tempIf = true;
            while (temporaryBool) {
                // vnořený další try catch v loopu pro možnost zkontrolování jak špatného data, tak špatné frekvence
                try {
                    if (tempIf) {
                        tempIf = false;
                        System.out.println("Testing wrong date:");
                        PlantStorage plantStorage2 = new PlantStorage();
                        plantStorage2.loadFile("kvetiny-spatne-datum.txt");
                        System.out.println(plantStorage2.toFile());
                    }

                    temporaryBool = false;
                    System.out.println("Testing wrong frequency:");
                    PlantStorage plantStorage3 = new PlantStorage();
                    plantStorage3.loadFile("kvetiny-spatna-frekvence.txt");
                    System.out.println(plantStorage3.toFile());

                } catch (DateTimeParseException e) {
                    System.out.println("Some date type in the file was written wrong!");
                    System.out.println();
                } catch (NumberFormatException e) {
                    System.out.println("Frequency of planting was set wrong!");
                }
            }
        } catch (DateTimeParseException e) {
            System.err.println("Some date type in the file was written wrong!");
        } catch (NumberFormatException e) {
            System.err.println("Frequency of planting was set wrong!");
        }
    }
}
