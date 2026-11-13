package com.mycompany.yasuni.object;


public class InterpretiveTour extends Tour {

    private int educationalMinutes;

    public InterpretiveTour(String code, String name, Trail[] trails, int trailCount,
            double difficultyFactor, int educationalMinutes) {
        super(code, name, trails, trailCount, difficultyFactor);
        this.educationalMinutes = educationalMinutes;
    }

    public int getEducationalMinutes() {
        return educationalMinutes;
    }

    public void setEducationalMinutes(int educationalMinutes) {
        this.educationalMinutes = educationalMinutes;
    }

    @Override
    public int calculateTotalDuration() {
        
        return calculateAdjustedWalkingTime() + educationalMinutes;
    }

    @Override
    public String toString() {
        return "InterpretiveTour[" + getCode() + "] " + getName()
                + " | distancia=" + calculateTotalDistance() + "km"
                + " | duracion=" + calculateTotalDuration() + "min"
                + " | factor=" + getDifficultyFactor()
                + " | educativo=" + educationalMinutes + "min";
    }
}
