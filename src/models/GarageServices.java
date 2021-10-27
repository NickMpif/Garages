package models;

import menu.Menu;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class GarageServices {
    public static ArrayList<Vehicle> vehicles = new ArrayList<>();
    private static double price = 0;


    public void type(String type) {
        switch (type.toLowerCase()) {
            case "car":
            case "motor":

                break;
            default:
                System.out.println("lathos epilogh");
                Menu menu = new Menu();
                menu.menu();
                break;
        }
    }

    public void garageTicketForTwoVehicles(Vehicle vehicle) {
        vehicle.setHasCredit(true);
        System.out.println("Driver's name: " + vehicle.getNameDriver() + " ID: " + vehicle.getIdDriver()
                + " credit for the first 30 minutes.");

//        int x = greateGarage.getP();
//        greateGarage.setP(x++);
    }

    public void details() {
        if (vehicles.size() > 0) {
            for (Vehicle vehicle : vehicles) {
                System.out.println("Details: " + "the ID: " + vehicle.getIdDriver() + "," + " the name: " +
                        vehicle.getNameDriver() + "," + " the plate number: " +
                        vehicle.getPlateNumber() + "," + " phone number: " + vehicle.getPhoneNumber() +
                        " the vehicle type: " + vehicle.getVehicle() + "," + " the brand:" + vehicle.getBrandVehicle());

            }
        } else {
            System.out.println("Parking is empty");
        }
        Menu menu = new Menu();
        menu.menu();
    }

    public long timeInside(long millisecond) {
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millisecond);
        long minutes = TimeUnit.SECONDS.toMinutes(seconds);
        long hours = TimeUnit.MINUTES.toHours(minutes);
        System.out.println("Stay in the parking spot: " + "hours:" + hours + " minutes:" + minutes + " second:" + seconds);
        return minutes;
    }

    public void checkPrice(Vehicle vehicle, long minutes) {
        double finalPrice = 0;
        if (vehicle.hasCredit) {
            long newMinutes = minutes - 30;
            if (newMinutes <= 0) {
                System.out.println("Driver's name: " + vehicle.getNameDriver() + "," + " ID: " + vehicle.getIdDriver() + "," + " plateNumber: "
                        + vehicle.getPlateNumber() + ", credit for the first 30 minutes. Stay less than 30 minutes! Parking spot is free of charge!");
            } else {
                long hours = minutes / 60;
                if (hours <= 1) {
                    switch (vehicle.getVehicle().toLowerCase()) {
                        case "motor":
                            finalPrice = 1.05;
                            break;
                        case "car":
                            finalPrice = 1.4;
                            break;
                    }
                    System.out.println("Driver's name: " + vehicle.getNameDriver() + "," + " ID: " + vehicle.getIdDriver() + "," + " plateNumber: "
                            + vehicle.getPlateNumber() + ", credit for the first 30 minutes. Stay less than an hour! The price is: "
                            + finalPrice + "Euro");
                } else {
                    switch (vehicle.getVehicle().toLowerCase()) {
                        case "motor":
                            finalPrice = hours * 1.05;
                            break;
                        case "car":
                            finalPrice = hours * 1.4;
                            break;
                    }
                    System.out.println("Driver's name: " + vehicle.getNameDriver() + "," + " ID: " + vehicle.getIdDriver() + "," + " with plateNumber: "
                            + vehicle.getPlateNumber() + ", credit for the first 30 minutes. Stay more than an hour! The price is: "
                            + finalPrice + "Euro");
                }
            }
        } else {
            long hours = minutes / 60;
            if (hours <= 1) {
                switch (vehicle.getVehicle().toLowerCase()) {
                    case "motor":
                        finalPrice = 1.5;
                        break;
                    case "car":
                        finalPrice = 3;
                        break;
                }
                System.out.println("Driver's name: " + vehicle.getNameDriver() + "," + " ID: " + vehicle.getIdDriver() + "," + " with plateNumber: "
                        + vehicle.getPlateNumber() + ", no credit for the first 30 minutes. Stay less than an hour! The price is: "
                        + finalPrice + "Euro");
            } else {
                switch (vehicle.getVehicle().toLowerCase()) {
                    case "motor":
                        finalPrice = hours * 1.5;
                        break;
                    case "car":
                        finalPrice = hours * 3;
                        break;
                }
                System.out.println("Driver's name: " + vehicle.getNameDriver() + "," + " ID: " + vehicle.getIdDriver() + "," + " with plateNumber: "
                        + vehicle.getPlateNumber() + ", no credit for the first 30 minutes. Stay more than an hour! The price is: "
                        + finalPrice + "Euro");
            }
        }
        price += finalPrice;
    }

    public void fund() {
        System.out.println("The total amount of money: " + price + " Euro!");
        Menu menu = new Menu();
        menu.menu();
    }
}
