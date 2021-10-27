import models.GreateGarage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Grate one garage with your dimensions, give how many columns, and how many lines you want");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        GreateGarage greateGarage =new GreateGarage();
        greateGarage.setColumns(x);
        greateGarage.setLines(y);
        greateGarage.getGarage();
    }
}
