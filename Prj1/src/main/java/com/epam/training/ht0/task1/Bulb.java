package com.epam.training.ht0.task1;


public class Bulb {
    private int luminosity;

    public Bulb(int luminosity){
        if (luminosity <= 0) {
            throw new IllegalArgumentException("Luminosity of the bulb can not be negative or zero");
        }
        this.luminosity = luminosity;
    }

    public int getLuminosity() {
        return luminosity;
    }
}
