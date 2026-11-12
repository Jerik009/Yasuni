package espoch.edu.ec.practicetwo.object;

public class Trail {

    private String label;
    private float extent;
    private float duration;
    private boolean enabledTrail;

    public Trail(String label, float extent, float duration, boolean enabledTrail) {
        this.label = label;
        this.extent = extent;
        this.duration = duration;
        this.enabledTrail = true;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public float getExtent() {
        return extent;
    }

    public void setExtent(float extent) {
        this.extent = extent;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public boolean isEnabledTrail() {
        return enabledTrail;
    }

    public void setEnabledTrail(boolean enabledTrail) {
        this.enabledTrail = enabledTrail;
    }
    
    
}
