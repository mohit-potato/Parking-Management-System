package parking.management;

import java.util.*;

public class OldMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int menu,price=0;
        String vType ="", model="",colour="",regPlate="";

        do {
            System.out.println("\n\n** WELCOME TO PARKING MANAGEMENT SYSTEM ** ");
            System.out.println("1) To Park Vehicle");
            System.out.println("2) To Departure");
            System.out.println("3) Parking Rates");
            System.out.println("4) Generate Bill");
            System.out.println("0) Exit");

            System.out.print("Enter your choice (no.) : ");

            menu = input.nextInt();
            System.out.println();

            switch (menu) {
                case 1 -> {
                    System.out.println("Please choose your vehicle type: ");
                    System.out.println("1) Two wheelers");
                    System.out.println("2) Car");
                    System.out.println("3) Other three/four wheelers");
                    System.out.print("Enter your choice (no.) : ");
                    vType = input.next();
                    switch (vType) {
                        case "1", "2", "3" -> {
                            System.out.println("\nEnter the following vehicle details --> ");
                            System.out.println("Model- ");
                            model = input.next();
                            System.out.println("Colour- ");
                            colour = input.next();
                            System.out.println("Number Plate- ");

                            regPlate = input.next();
                            System.out.println("Vehicle has been successfully registered.");
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Enter the number of hours parked- ");
                    int n = input.nextInt();
                    switch (vType) {
                        case "1" -> price = 20 * n;
                        case "2" -> price = 50 * n;
                        case "3" -> price = 70 * n;
                    }
                    System.out.println("You can generate your bill now.");
                }
                case 3 -> {
                    System.out.println("** PARKING RATES **");
                    System.out.println("VEHICLE TYPE \tRS (per hr)");
                    System.out.println("Two wheelers  \t₹20");
                    System.out.println("Car     \t    ₹50");
                    System.out.println("3/4 wheelers\t₹70");

                }
                case 4 -> {
                    System.out.println("** BILL **  ");
                    System.out.println("Model: "+ model);
                    System.out.println("Colour: " + colour);
                    System.out.println("Registration Plate: " +regPlate);
                    System.out.println("Total Parking Price: ₹" +price);
                }
                case 0 -> System.out.println("\nThank you!\n");
                default -> System.out.println("Invalid option!\nPlease enter a valid option and try again.");
            }
        } while (menu != 0);

    }
}