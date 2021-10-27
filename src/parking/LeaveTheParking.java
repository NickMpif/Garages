package parking;

import menu.Menu;
import models.GarageServices;
import models.GreateGarage;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

import static models.GarageServices.*;

public class LeaveTheParking {

    public void LeaveTheParkingSpot() {
        Scanner scanner = new Scanner(System.in);
        if (vehicles.size()==0){
            System.out.println("Parking is empty");
            Menu menu = new Menu();
            menu.menu();
        }
        System.out.println("Mention the vehicle plate number:");
        String plateNumber = scanner.nextLine();
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getPlateNumber().equals(plateNumber)) {
                LocalDateTime myDateObj = LocalDateTime.now();
                long millisecond = Duration.between(vehicles.get(i).getLocalDateTime(), myDateObj).toMillis();
                GarageServices garageServices = new GarageServices();
                long minutes = garageServices.timeInside(millisecond);
                garageServices.checkPrice(vehicles.get(i), minutes);
                GreateGarage.space[vehicles.get(i).getX() - 1][vehicles.get(i).getY() - 1] = "- ";
                GreateGarage.p--;
                vehicles.remove(i);
            }
            Menu menu = new Menu();
            menu.menu();
        }
    }
}
