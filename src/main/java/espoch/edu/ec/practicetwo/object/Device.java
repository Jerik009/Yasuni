package espoch.edu.ec.practicetwo.object;

public class Device {

    private String deviceCode;
    private String details;
    private boolean availableDevice;

    public Device(String deviceCode, String details, boolean availableDevice) {
        this.deviceCode = deviceCode;
        this.details = details;
        this.availableDevice = true;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean isAvailableDevice() {
        return availableDevice;
    }

    public void setAvailableDevice(boolean availableDevice) {
        this.availableDevice = availableDevice;
    }

}
