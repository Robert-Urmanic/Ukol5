package com.engeto.urm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlantStorage {
    List<Plant> plant = new ArrayList<>();

    public void addPlant(Plant plant) {
        this.plant.add(plant);
    }

    public String getPlant(int queue) {
        return this.plant.get(queue).getName() + "\t" + this.plant.get(queue).getNotes() + "\t" + this.plant.get(queue).getWateringFrequency() + "\t" + this.plant.get(queue).getLastWatering() + "\t" + this.plant.get(queue).getPlanted();
    }

    public void removePlant(int queue) {
        this.plant.remove(queue);
    }

    public void loadFile(String fileName) throws DateTimeParseException, NumberFormatException {
        try (Scanner file = new Scanner(new File(fileName))) {

            while (file.hasNextLine()) {
                String[] tempPlantHolder = file.nextLine().split("\t");
                plant.add(new Plant(tempPlantHolder[0], tempPlantHolder[1], LocalDate.parse(tempPlantHolder[4]), LocalDate.parse(tempPlantHolder[3]), Integer.parseInt(tempPlantHolder[2])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DateTimeParseException e){
            System.err.println("Some date type in the file was written wrong!");
        } catch (NumberFormatException e){
            System.err.println("Frequency of planting was set wrong!");
        }

    }

    public void uploadFile() {
        try (PrintWriter out = new PrintWriter("vystup.txt")) {
            out.println(this.toFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public String toFile() {
        String s = "";
        for (int i = 0; i < plant.size(); i++) {
            s += this.getPlant(i) + nextLine(i, plant.size());
        }
        return s;
    }

    public String nextLine(int i, int plantSize){
        if (i + 1 == plantSize){
            return "";
        }
        else return "\n";
    }
}


