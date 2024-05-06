package org.example;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseOperations<User> userDatabase = new DatabaseOperations<>(User.class);
        DatabaseOperations<Smartphone> smartphoneDatabase = new DatabaseOperations<>(Smartphone.class);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add User");
            System.out.println("2. Add Smartphone");
            System.out.println("3. Display Users");
            System.out.println("4. Display Smartphones");
            System.out.println("5. Update Smartphone");
            System.out.println("6. Delete Smartphone");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Username: ");
                    String username = scanner.next();
                    System.out.print("Enter Password: ");
                    String password = scanner.next();
                    userDatabase.addEntity(new User(username, password));
                    break;
                case 2:
                    System.out.print("Enter Brand: ");
                    String brand = scanner.next();
                    System.out.print("Enter Model: ");
                    String model = scanner.next();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    smartphoneDatabase.addEntity(new Smartphone(brand, model, price));
                    break;
                case 3:
                    userDatabase.getAllEntities().forEach(System.out::println);
                    break;
                case 4:
                    smartphoneDatabase.getAllEntities().forEach(System.out::println);
                    break;
                case 5:
                    System.out.print("Enter Smartphone ID to update: ");
                    Long updateId = scanner.nextLong();
                    Smartphone updateSmartphone = smartphoneDatabase.getEntityById(updateId);

                    if (updateSmartphone != null) {
                        System.out.print("Enter new Brand: ");
                        updateSmartphone.setBrand(scanner.next());
                        System.out.print("Enter new Model: ");
                        updateSmartphone.setModel(scanner.next());
                        System.out.print("Enter new Price: ");
                        updateSmartphone.setPrice(scanner.nextDouble());
                        smartphoneDatabase.updateEntity(updateSmartphone);
                        System.out.println("Smartphone updated successfully.");
                    } else {
                        System.out.println("Smartphone not found.");
                    }
                    break;
                case 6:
                    System.out.print("Enter Smartphone ID to delete: ");
                    Long deleteId = scanner.nextLong();
                    Smartphone deleteSmartphone = smartphoneDatabase.getEntityById(deleteId);

                    if (deleteSmartphone != null) {
                        smartphoneDatabase.deleteEntity(deleteSmartphone);
                        System.out.println("Smartphone deleted successfully.");
                    } else {
                        System.out.println("Smartphone not found.");
                    }
                    break;
                case 7:
                    userDatabase.closeEntityManager();
                    smartphoneDatabase.closeEntityManager();
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}