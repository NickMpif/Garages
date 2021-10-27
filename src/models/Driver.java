package models;

public class Driver {
    private String nameDriver;
    private String idDriver;
    private String phoneNumber;

    public Driver(String nameDriver, String idDriver, String phoneNumber) {
        this.nameDriver = nameDriver;
        this.idDriver = idDriver;
        this.phoneNumber = phoneNumber;
    }

    public String getNameDriver() {
        return nameDriver;
    }

    public String getIdDriver() {
        return idDriver;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
