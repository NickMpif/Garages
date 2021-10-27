package models;

import menu.Menu;
import parking.BuyParkingSpot;

public class GreateGarage {
    public static String[][] space;
    public static int p = 0;
    private int columns;
    private int lines;
    public static int x = 0;
    public static int y = 0;

    public void setColumns(int columns) {
        this.columns = columns;
        x = this.columns;
    }

    public void setLines(int lines) {
        this.lines = lines;
        y = this.lines;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        p = p;
    }


    public void getGarage() {
        System.out.println("Garage total parking spots: " + x * y);
        space = new String[x][y];
        fillGarage();
    }

    // fill garage with ----
    private String[][] fillGarage() {
        int column = space.length;
        int line = space[0].length;
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < line; j++) {
                space[i][j] = "- ";
            }
        }
        checkGarage();
        return space;

    }

    // check if the garage is full or no
    public void checkGarage() {
        if (p == x * y) {
            System.out.println("Sorry the garage is full, you can't buy a parking spot right now." +
                    " The choice 1 is not available for now!");
            Menu menu = new Menu();
            menu.menu();
        } else {
            viewGarage();
        }
    }

    // show the garage
    public void viewGarage() {
        StringBuilder builder = new StringBuilder();
        builder.append(" ");
        for (int i = 0; i < space[0].length; i++) {
            builder.append(" ").append(++i);
            --i;
        }
        builder.append("\n");
        for (int i = 0; i < space.length; i++) {
            builder.append(++i).append(" ");
            --i;
            for (int j = 0; j < space[0].length; j++) {
                builder.append(space[i][j]);
            }
            builder.append("\n");
        }
        System.out.println("Parking availability: " + ((x * y) - p));
        System.out.print(builder);
        Menu menu = new Menu();
        menu.menu();
    }

    public void wrongInputs(int x, int y) {
        BuyParkingSpot buyParkingSpot = new BuyParkingSpot();
        int rows = space.length;
        int column = space[0].length;
        if (x > rows || y > column) {
            System.out.println("Wrong input!");
            buyParkingSpot.buyParkingSpot();
        }
        if (space[x - 1][y - 1].equals("X ")) {
            System.out.println("This parking spot is already taken!");
            buyParkingSpot.buyParkingSpot();
        } else {
            p++;
            space[x - 1][y - 1] = "X ";
        }
    }
}
