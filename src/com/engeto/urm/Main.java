package com.engeto.urm;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        PlantStorage plantStorage = new PlantStorage();
        plantStorage.loadFile("kvetiny.txt");
        for (Plant temp : plantStorage.plant) {
            System.out.println(temp.getWateringInfo());
        }
        plantStorage.addPlant(new Plant("Monstera", "Krasna, pekna", LocalDate.now(), LocalDate.now().plusDays(1), 3));
        plantStorage.addPlant(new Plant("Orchidej", "Pekna, krasna", LocalDate.now().minusDays(10), LocalDate.now().plusDays(5), 7));
        plantStorage.removePlant(1);
        System.out.println();
        //System.out.println(plantStorage.toFile());
        plantStorage.uploadFile();
        plantStorage.loadFile("vystup.txt");

        PlantStorage plantStorage2 = new PlantStorage();
        plantStorage2.loadFile("kvetiny-spatne-datum.txt");
        System.out.println(plantStorage2.toFile());

        System.out.println();

        PlantStorage plantStorage3 = new PlantStorage();
        plantStorage3.loadFile("kvetiny-spatna-frekvence.txt");
        System.out.println(plantStorage3.toFile());
    }
}
