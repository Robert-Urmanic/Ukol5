package com.engeto.urm;

import java.util.ArrayList;
import java.util.List;

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


}
