package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class SmartphoneComparisonSystem implements Serializable {
    private List<Smartphone> smartphones;

    public SmartphoneComparisonSystem() {
        this.smartphones = new ArrayList<>();
    }

    public void addSmartphone(Smartphone smartphone) {
        smartphones.add(smartphone);
    }

    public void displaySmartphones() {
        for (Smartphone smartphone : smartphones) {
            System.out.println(smartphone);
        }
    }

    public void saveToFile(String fileName) {
        if (!fileName.endsWith(".txt")) {
            fileName += ".txt";
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Smartphone smartphone : smartphones) {
                writer.println(smartphone.getBrand() + "," + smartphone.getModel() + "," + smartphone.getPrice());
            }
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String fileName) {
        if (!fileName.endsWith(".txt")) {
            fileName += ".txt";
        }

        smartphones.clear(); // Clear existing data
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String brand = parts[0];
                    String model = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    smartphones.add(new Smartphone(brand, model, price));
                }
            }
            System.out.println("Data loaded from " + fileName);
            System.out.println(smartphones);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Smartphone> getSmartphones() {
        return smartphones;
    }
}
