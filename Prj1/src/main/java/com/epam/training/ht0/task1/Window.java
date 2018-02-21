package com.epam.training.ht0.task1;

public class Window {
    static final int DEFAULT_LUMINOSITY = 700;
    private int luminosity;

    public Window() {
        this.luminosity = DEFAULT_LUMINOSITY;
    }

    public Window(int luminosity) {
        if (luminosity <= 0) {
            throw new IllegalArgumentException("Luminosity of the window can not be negative or zero");
        }
        this.luminosity = luminosity;
    }

    public int getLuminosity() {
        return luminosity;
    }
}
