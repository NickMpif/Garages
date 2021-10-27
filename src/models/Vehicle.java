package models;

public class Vehicle extends Driver {
    private String vehicle;
    private String plateNumber;
    private String brandVehicle;
    private java.time.LocalDateTime LocalDateTime;
    public Boolean hasCredit;
    private int x;
    private int y;

    public Vehicle(String nameDriver, String idDriver, String phoneNumber, String vehicle, String plateNumber,
                   String brandVehicle, java.time.LocalDateTime localDateTime, Boolean hasCredit, int x, int y) {
        super(nameDriver, idDriver, phoneNumber);
        this.vehicle = vehicle;
        this.plateNumber = plateNumber;
        this.brandVehicle = brandVehicle;
        this.LocalDateTime = localDateTime;
        this.hasCredit = hasCredit;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setHasCredit(Boolean hasCredit) {

        this.hasCredit = hasCredit;
    }

    public java.time.LocalDateTime getLocalDateTime() {
        return LocalDateTime;
    }

    public String getVehicle() {

        return vehicle;
    }

    public String getPlateNumber() {

        return plateNumber;
    }

    public String getBrandVehicle() {
        return brandVehicle;
    }
}
