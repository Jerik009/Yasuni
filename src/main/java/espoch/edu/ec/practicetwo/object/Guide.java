package espoch.edu.ec.practicetwo.object;

public class Guide {

    private String identification;
    private String fullName;
    private boolean availableGuide;

    public Guide(String identification, String fullName, boolean availableGuide) {
        this.identification = identification;
        this.fullName = fullName;
        this.availableGuide = true;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isAvailableGuide() {
        return availableGuide;
    }

    public void setAvailableGuide(boolean availableGuide) {
        this.availableGuide = availableGuide;
    }
    
    
}
