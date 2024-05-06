package org.example;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SmartphoneComparisonSystem system = new SmartphoneComparisonSystem();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Smartphone");
            System.out.println("2. Display Smartphones");
            System.out.println("3. Save to File");
            System.out.println("4. Load from File");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Brand: ");
                    String brand = scanner.next();
                    System.out.print("Enter Model: ");
                    String model = scanner.next();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    system.addSmartphone(new Smartphone(brand, model, price));
                    break;
                case 2:
                    system.displaySmartphones();
                    break;
                case 3:
                    System.out.print("Enter file name to save: ");
                    String saveFileName = scanner.next();
                    system.saveToFile(saveFileName);
                    break;
                case 4:
                    System.out.print("Enter file name to load: ");
                    String loadFileName = scanner.next();
                    system.loadFromFile(loadFileName);
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}