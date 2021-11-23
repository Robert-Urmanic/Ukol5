package com.engeto.urm;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Plant emilie = new Plant();
        System.out.println(emilie.getWateringInfo());
        System.out.println(emilie.getWateringFrequency());
    }
}
