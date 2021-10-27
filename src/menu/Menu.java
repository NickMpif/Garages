package menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import models.GarageServices;
import models.GreateGarage;
import parking.*;

public class Menu {

    void printMenu() {
        System.out.println("0. Close the program\n" +
                "1. Buy a parking spot\n" +
                "2. Check garage\n" +
                "3. Leave the parking spot\n" +
                "4. Cash desk\n" +
                "5. Parking details");
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        GarageServices garageServices = new GarageServices();
        try {
            int action = scanner.nextInt();
            switch (action) {
                case 0:
                    System.out.println("Thank you bye!");
                    break;
                case 1:
                    BuyParkingSpot buyParkingSpot = new BuyParkingSpot();
                    buyParkingSpot.buyParkingSpot();
                    break;
                case 2:
                    GreateGarage greateGarage=new GreateGarage();
                    greateGarage.viewGarage();
                    break;
                case 3:
                    LeaveTheParking leaveTheParking = new LeaveTheParking();
                    leaveTheParking.LeaveTheParkingSpot();
                    break;
                case 4:
                    garageServices.fund();
                    break;
                case 5:
                    garageServices.details();
                    break;
                default:
                    System.out.print("The available choices are 0 to 5");
                    menu();
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.print("The available choices are 0 to 5");
            menu();
        }
    }
}
