package com.engeto.urm;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlantStorage {
    List<Plant> plant = new ArrayList<>();

    public void addPlant(Plant plant){
        this.plant.add(plant);
    }

    public void getPlant(int queue){
        this.plant.get(queue);
    }

    public void removePlant(Plant plant){
        this.plant.remove(plant);
    }

    public void loadFile(){
        try (Scanner file = new Scanner(new File(("src/kvetiny.txt")))){

            while (file.hasNextLine()){
                String[] tempPlantHolder = file.nextLine().split("\\t");
                plant.add(new Plant(tempPlantHolder[0], tempPlantHolder[1], LocalDate.parse(tempPlantHolder[2]), LocalDate.parse(tempPlantHolder[3]), Integer.parseInt(tempPlantHolder[4])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PlantStorage p = new PlantStorage();
        p.loadFile();
    }
}
