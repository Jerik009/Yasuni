package com.mycompany.yasuni.object;


public class Trail {

    private String name;
    private double lengthKm;
    private int estimatedMinutes;
    private boolean enabled;

    public Trail(String name, double lengthKm, int estimatedMinutes) {
        this.name = name;
        this.lengthKm = lengthKm;
        this.estimatedMinutes = estimatedMinutes;
        this.enabled = true;
    }

    public Trail(String name, double lengthKm, int estimatedMinutes, boolean enabled) {
        this.name = name;
        this.lengthKm = lengthKm;
        this.estimatedMinutes = estimatedMinutes;
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLengthKm() {
        return lengthKm;
    }

    public void setLengthKm(double lengthKm) {
        this.lengthKm = lengthKm;
    }

    public int getEstimatedMinutes() {
        return estimatedMinutes;
    }

    public void setEstimatedMinutes(int estimatedMinutes) {
        this.estimatedMinutes = estimatedMinutes;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Trail{name='" + name + "', lengthKm=" + lengthKm
                + ", estimatedMinutes=" + estimatedMinutes + ", enabled=" + enabled + "}";
    }
}
