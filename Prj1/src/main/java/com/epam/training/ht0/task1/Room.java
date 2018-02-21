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
        if ((this.getOccupiedArea()[1] + furniture.getMaxAreaOccupied()) / area <= 0.7) {
            this.furnitureList.add(furniture);
        } else {
            throw new SpaceUsageTooMuchException("Occupied area of the room '" + this.name +
                    "' will exceed 70% of room's area when adding " + furniture.getName() + "");
        }
    }

    public double[] getOccupiedArea() {
        double[] area = new double[2];
        for (Furniture furniture : this.furnitureList) {
            area[0] += furniture.getMinAreaOccupied();
            area[1] += furniture.getMaxAreaOccupied();
        }
        return area;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append("\n");
        sb.append("Illumination = ").append(this.getIllumination());
        sb.append(" (").append(this.windows.size()).append(" windows ").append(Window.DEFAULT_LUMINOSITY).append(" lux");
        if (this.bulbs.size() == 0) {
            sb.append(")\n");
        } else {
            sb.append(", bulbs ");
            for (int i = 0; i < this.bulbs.size(); i++) {
                if (i == this.bulbs.size()) {
                    sb.append(this.bulbs.get(i).getLuminosity()).append(" lux)");
                }
                sb.append(this.bulbs.get(i).getLuminosity()).append(" lux and ");
            }
        }
        sb.append("Area = ").append(this.area).append(" m^2 (");

        if (this.furnitureList.size() == 0) {
            sb.append("100% free)\n");
        } else {
            if (this.getOccupiedArea()[0] == this.getOccupiedArea()[1]) {
                sb.append(this.getOccupiedArea()[1]).append(" m^2, guaranteed free ").append(this.area - this.getOccupiedArea()[0])
                        .append(" m^2 or ").append(Math.round((1 - this.getOccupiedArea()[1] / this.area) * 100)).append(" % of area)");
            } else {
                sb.append(this.getOccupiedArea()[0]).append("-").append(this.getOccupiedArea()[1]);
            }
            sb.append(" m^2, guaranteed free ").append(this.area - this.getOccupiedArea()[0]).append(" m^2 or ")
                    .append(Math.round((1 - this.getOccupiedArea()[1] / this.area) * 100)).append(" % of area)\n");
        }

        if (this.furnitureList.size() == 0) {
            sb.append("No furniture");
        } else {
            sb.append("Furniture:\n");
            for (Furniture furniture : this.furnitureList) {
                sb.append(furniture).append("\n");
            }
        }
        return sb.toString();
    }
}
