package parking;

import menu.Menu;
import models.GarageServices;
import models.GreateGarage;
import models.Vehicle;

import static models.GarageServices.*;
import static models.GreateGarage.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BuyParkingSpot {

    public void buyParkingSpot() {
        Scanner scanner = new Scanner(System.in);
        GreateGarage greateGarage= new GreateGarage();
        if (p ==(greateGarage.x*greateGarage.y)) {
            greateGarage.checkGarage();
        }
        System.out.println("Mention the name of driver:");
        String nameDriver = scanner.nextLine();
        char[] chars = nameDriver.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                System.out.println("Name cannot have digits!");
                buyParkingSpot();
            }
        }
        System.out.println("Mention driver's ID number:");
        String id = scanner.nextLine();
        System.out.println("Mention driver's phone number:");
        String phone = scanner.nextLine();
        System.out.println("Mention the vehicle typeVehicle: Available choices only car and motor:");
        String typeVehicle = scanner.nextLine();
        GarageServices garageServices = new GarageServices();
        garageServices.type(typeVehicle);
        System.out.println("Mention the vehicle plate number:");
        String plateNumber = scanner.nextLine();
        if (plateNumber.isEmpty()) {
            System.out.println("The plate number cannot be empty!");
            buyParkingSpot();
        }
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlateNumber().equals(plateNumber)) {
                System.out.println("This plate number is already exist!");
                buyParkingSpot();
            }
        }
        System.out.println("Mention vehicle's brand:");
        String brand = scanner.nextLine();
        System.out.println("Mention your vehicle's row and column number:");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        System.out.println("Time insert to garage " + formattedDate);
        Vehicle newvehicle = new Vehicle(nameDriver, id, phone, typeVehicle, plateNumber, brand, myDateObj, false, x, y);
        for (Vehicle oldVehicle : vehicles) {
            if (oldVehicle.getIdDriver().equals(id)) {
                garageServices.garageTicketForTwoVehicles(oldVehicle);
                newvehicle.setHasCredit(true);
            }
        }
        greateGarage.wrongInputs(x, y);
        vehicles.add(newvehicle);
        Menu menu = new Menu();
        menu.menu();
    }
}
