package com.epam.training.ht0.task1;

import com.epam.training.ht0.task1.exceptions.IlluminanceTooMuchException;
import com.epam.training.ht0.task1.exceptions.SpaceUsageTooMuchException;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private static final int MIN_ILLUMINATION = 300;
    private static final int MAX_ILLUMINATION = 4000;

    private double area;
    private String name;
    private List<Window> windows;
    private List<Bulb> bulbs;
    private List<Furniture> furnitureList;

    public Room(String name, int area, int windowsNum) {
        validateParameters(name, area, windowsNum);
        this.name = name;
        this.area = area;
        this.windows = new ArrayList<Window>();
        for (int i = 0; i < windowsNum; i++) {
            this.windows.add(new Window());
        }
        this.bulbs = new ArrayList<Bulb>();
        this.furnitureList = new ArrayList<Furniture>();
    }

    //check the initial parameters of room
    private void validateParameters(String name, int area, int windowsNum) {
        if (area <= 0) {
            throw new IllegalArgumentException("Area of the room '" + name + "' can not be negative or zero");
        }
        int illumination = windowsNum * Window.DEFAULT_LUMINOSITY;
        if (illumination < MIN_ILLUMINATION || illumination > MAX_ILLUMINATION) {
            throw new IllegalArgumentException("Number of windows in room '" + name + "' should be in range from 1 to 5 " +
                    "to provide illumination from 300 to 4000 lux");
        }
    }

    public double getArea() {
        return area;
    }

    public String getName() {
        return name;
    }

    public void addBulb(Bulb bulb) throws IlluminanceTooMuchException {
        if (this.getIllumination() + bulb.getLuminosity() <= 4000) {
            this.bulbs.add(bulb);
        } else {
            throw new IlluminanceTooMuchException("Illumination of the room '" + this.name + "' will exceed max value for room " +
                    "when adding bulb with luminosity=" + bulb.getLuminosity());
        }
    }

    public int getIllumination() {
        int illumination = 0;
        for (Window window : this.windows) {
            illumination += window.getLuminosity();
        }
        for (Bulb bulb : this.bulbs) {
            illumination += bulb.getLuminosity();
        }
        return illumination;
    }

    public void addFurniture(Furniture furniture) throws SpaceUsageTooMuchException {
        if ((this.getOccupiedArea() + furniture.getMaxAreaOccupied()) / area <= 0.7) {
            this.furnitureList.add(furniture);
        } else {
            throw new SpaceUsageTooMuchException("Occupied area of the room '" + this.name +
                    "' will exceed 70% of room's area when adding " + furniture.getName() + "");
        }
    }

    public double getOccupiedArea() {
        double area = 0;
        for (Furniture furniture : this.furnitureList) {
            area += furniture.getMaxAreaOccupied();
        }
        return area;
    }

    //TODO
    @Override
    public String toString() {
 /*       Здание 1
        Комната 1
        Освещённость = 2500 (3 окна по 700 лк, лампочки 150 лк и 250 лк)
        Площадь = 100 м^2 (занято 4-5 м^2, гарантированно свободно 95 м^2 или 95% площади)
        Мебель:
        Стол письменный (площадь 3 м^2)
        Кресло мягкое и пушистое (площадь от 1 м^2 до 2 м^2)
        Комната 2
        Освещённость = 1400 (2 окна по 700 лк)
        Площадь = 5 м^2 (свободно 100%)
        Мебели нет
                */

        return super.toString();
    }
}
