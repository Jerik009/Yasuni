package com.mycompany.yasuni.object;


public abstract class Tour {

    private String code;
    private String name;
    private Trail[] trails;
    private int trailCount;
    private CommunicationDevice device;
    private Guide guide;
    private double difficultyFactor;

    public Tour(String code, String name, Trail[] trails, int trailCount, double difficultyFactor) {
        this.code = code;
        this.name = name;
        this.trails = trails;
        this.trailCount = trailCount;
        this.difficultyFactor = difficultyFactor;
        this.device = null;
        this.guide = null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Trail[] getTrails() {
        return trails;
    }

    public void setTrails(Trail[] trails) {
        this.trails = trails;
    }

    public int getTrailCount() {
        return trailCount;
    }

    public void setTrailCount(int trailCount) {
        this.trailCount = trailCount;
    }

    public CommunicationDevice getDevice() {
        return device;
    }

    public void setDevice(CommunicationDevice device) {
        this.device = device;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    public double getDifficultyFactor() {
        return difficultyFactor;
    }

    public void setDifficultyFactor(double difficultyFactor) {
        this.difficultyFactor = difficultyFactor;
    }

    
    public void addTrail(Trail trail) {
        if (trailCount >= trails.length) {
            trails = java.util.Arrays.copyOf(trails, trails.length * 2);
        }
        trails[trailCount++] = trail;
    }

    
    public double calculateTotalDistance() {
        double total = 0;
        for (int i = 0; i < trailCount; i++) {
            if (trails[i].isEnabled()) {
                total += trails[i].getLengthKm();
            }
        }
        return total;
    }

    
    public int calculateBaseWalkingTime() {
        int total = 0;
        for (int i = 0; i < trailCount; i++) {
            if (trails[i].isEnabled()) {
                total += trails[i].getEstimatedMinutes();
            }
        }
        return total;
    }

    
    public int calculateAdjustedWalkingTime() {
        return (int) (calculateBaseWalkingTime() * difficultyFactor);
    }

    
    public abstract int calculateTotalDuration();

    @Override
    public String toString() {
        return "Tour{code='" + code + "', name='" + name + "', difficultyFactor=" + difficultyFactor
                + ", trailCount=" + trailCount + ", device=" + (device != null ? device.getCode() : "null")
                + ", guide=" + (guide != null ? guide.getNationalId() : "null") + "}";
    }
}
