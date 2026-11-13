package com.mycompany.yasuni.object;

public class Guide {

    private String nationalId;
    private String name;
    private boolean available;

    public Guide(String nationalId, String name) {
        this.nationalId = nationalId;
        this.name = name;
        this.available = true;
    }

    public Guide(String nationalId, String name, boolean available) {
        this.nationalId = nationalId;
        this.name = name;
        this.available = available;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Guide{nationalId='" + nationalId + "', name='" + name
                + "', available=" + available + "}";
    }
}
