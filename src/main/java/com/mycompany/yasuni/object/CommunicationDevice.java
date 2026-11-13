package com.mycompany.yasuni.object;

public class CommunicationDevice {

    private String code;
    private String description;
    private boolean available;

    public CommunicationDevice(String code, String description) {
        this.code = code;
        this.description = description;
        this.available = true;
    }

    public CommunicationDevice(String code, String description, boolean available) {
        this.code = code;
        this.description = description;
        this.available = available;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "CommunicationDevice{code='" + code + "', description='" + description
                + "', available=" + available + "}";
    }
}
