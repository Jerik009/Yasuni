package espoch.edu.ec.practicetwo.object;

public class Assignment {

    private boolean firstTimeVisitor;
    private boolean limitedTime;
    private Device[] devices;
    private Guide[] guides;
    private Tour[] tours;

    private Tour selectedTour;
    private Guide selectedGuide;
    private Device selectedDevice;

    public Assignment(boolean firstTimeVisitor, boolean limitedTime, Device[] devices, Guide[] guides, Tour[] tours) {
        this.firstTimeVisitor = firstTimeVisitor;
        this.limitedTime = limitedTime;
        this.devices = devices;
        this.guides = guides;
        this.tours = tours;
    }

    public Assignment() {
    }

    public boolean isFirstTimeVisitor() {
        return firstTimeVisitor;
    }

    public void setFirstTimeVisitor(boolean firstTimeVisitor) {
        this.firstTimeVisitor = firstTimeVisitor;
    }

    public boolean isLimitedTime() {
        return limitedTime;
    }

    public void setLimitedTime(boolean limitedTime) {
        this.limitedTime = limitedTime;
    }

    public Device[] getDevices() {
        return devices;
    }

    public void setDevices(Device[] devices) {
        this.devices = devices;
    }

    public Guide[] getGuides() {
        return guides;
    }

    public void setGuides(Guide[] guides) {
        this.guides = guides;
    }

    public Tour[] getTours() {
        return tours;
    }

    public void setTours(Tour[] tours) {
        this.tours = tours;
    }

    public Tour getSelectedTour() {
        return selectedTour;
    }

    public void setSelectedTour(Tour selectedTour) {
        this.selectedTour = selectedTour;
    }

    public Guide getSelectedGuide() {
        return selectedGuide;
    }

    public void setSelectedGuide(Guide selectedGuide) {
        this.selectedGuide = selectedGuide;
    }

    public Device getSelectedDevice() {
        return selectedDevice;
    }

    public void setSelectedDevice(Device selectedDevice) {
        this.selectedDevice = selectedDevice;
    }

}
