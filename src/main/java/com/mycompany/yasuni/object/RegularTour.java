package com.mycompany.yasuni.object;

public class RegularTour extends Tour {

    public RegularTour(String code, String name, Trail[] trails, int trailCount, double difficultyFactor) {
        super(code, name, trails, trailCount, difficultyFactor);
    }

    @Override
    public int calculateTotalDuration() {

        return calculateAdjustedWalkingTime();
    }

    @Override
    public String toString() {
        return "RegularTour[" + getCode() + "] " + getName()
                + " | distancia=" + calculateTotalDistance() + "km"
                + " | duracion=" + calculateTotalDuration() + "min"
                + " | factor=" + getDifficultyFactor();
    }
}
