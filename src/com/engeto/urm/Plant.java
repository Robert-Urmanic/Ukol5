package com.engeto.urm;

import java.time.LocalDate;
import java.util.Locale;

public class Plant {
    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate lastWatering;
    private int wateringFrequency;

    public Plant(String name, String notes, LocalDate planted, LocalDate lastWatering, int wateringFrequency) {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        try {
            setLastWatering(lastWatering);
        } catch (DateException e) {
            System.out.println("The date of last watering cannot be before the date of planting.");
        }
        try {
            setWateringFrequency(wateringFrequency);
        } catch (PlantException e) {
            System.out.println("The frequency of watering cannot be equal to or lower than 0");
        }

    }

    public Plant(){
        notes = "";
        try {
            setLastWatering(LocalDate.now());
        } catch (DateException e) {
            System.out.println("The date of last watering cannot be before the date of planting.");
        }
    }

    public Plant(String name){
        this();
        this.name = name;
        try {
            setWateringFrequency(7);
        } catch (PlantException e) {
            System.out.println("The frequency of watering cannot be equal to or lower than 0");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getLastWatering() {
        return lastWatering;
    }

    public void setLastWatering(LocalDate lastWatering) throws DateException{
        if(planted instanceof LocalDate) {
            if (lastWatering.compareTo(planted) < 0) {
                throw new DateException();
            }
        }
        this.lastWatering = lastWatering;
    }

    public int getWateringFrequency() {
        return wateringFrequency;
    }

    public void setWateringFrequency(int wateringFrequency) throws PlantException {
        if (wateringFrequency < 0){
            throw new PlantException();
        }
        this.wateringFrequency = wateringFrequency;
    }


    public String getWateringInfo(){
        return "Plant " + name + " was watered last time on this date: " + lastWatering + ".\nNext date of watering is: " + lastWatering.plusDays(wateringFrequency);
    }

}
