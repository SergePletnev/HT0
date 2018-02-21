package com.epam.training.ht0.task1;

public class Furniture {
    private String name;
    private double minAreaOccupied;
    private double maxAreaOccupied;

    public Furniture(String name, double maxAreaOccupied) {
        validateParameters(name, maxAreaOccupied);
        this.name = name;
        this.maxAreaOccupied = maxAreaOccupied;
        this.minAreaOccupied = maxAreaOccupied;
    }

    public Furniture(String name, double minAreaOccupied, double maxAreaOccupied) {
        this(name, maxAreaOccupied);
        if (minAreaOccupied <= 0) {
            throw new IllegalArgumentException("Minimal area occupied by the furniture '" + name + "' can not be negative or zero");
        }
        if (minAreaOccupied > maxAreaOccupied) {
            throw new IllegalArgumentException("Minimal area occupied by the furniture '" + name + "' can not be more than maximal");
        }
        this.minAreaOccupied = minAreaOccupied;
    }

    private void validateParameters(String name, double maxAreaOccupied) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("The furniture can not be without name");
        }
        if (maxAreaOccupied <= 0) {
            throw new IllegalArgumentException("Maximal area occupied by the furniture '" + name + "' can not be negative or zero");
        }
    }

    public String getName() {
        return name;
    }

    public double getMinAreaOccupied() {
        return minAreaOccupied;
    }

    public double getMaxAreaOccupied() {
        return maxAreaOccupied;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.minAreaOccupied == this.maxAreaOccupied) {
            sb.append(this.getName()).append("(area ").append(this.maxAreaOccupied).append(" m^2)");
        } else {
            sb.append(this.getName()).append("(area from ").append(this.minAreaOccupied).append(") m^2 to ")
                    .append(this.maxAreaOccupied).append(" m^2)");
        }

        return super.toString();
    }
}
