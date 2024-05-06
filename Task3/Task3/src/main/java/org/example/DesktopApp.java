package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.persistence.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DesktopApp extends Application {
    private final DatabaseOperations<User> userDatabase = new DatabaseOperations<>(User.class);
    private final DatabaseOperations<Smartphone> smartphoneDatabase = new DatabaseOperations<>(Smartphone.class);
    private final Logger logger = Logger.getLogger(DesktopApp.class.getName());



    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Database Operations");

        VBox vbox = new VBox(10);
        Scene scene = new Scene(vbox, 400, 300);

        Button addUserButton = new Button("Add User");
        addUserButton.setOnAction(e -> showAddUserDialog());

        Button addSmartphoneButton = new Button("Add Smartphone");
        addSmartphoneButton.setOnAction(e -> showAddSmartphoneDialog());

        Button displayUsersButton = new Button("Display Users");
        displayUsersButton.setOnAction(e -> displayEntities(userDatabase.getAllEntities()));

        Button displaySmartphonesButton = new Button("Display Smartphones");
        displaySmartphonesButton.setOnAction(e -> displayEntities(smartphoneDatabase.getAllEntities()));

        vbox.getChildren().addAll(addUserButton, addSmartphoneButton, displayUsersButton, displaySmartphonesButton);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAddUserDialog() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add User");
        dialog.setHeaderText(null);
        dialog.setContentText("Enter Username:");

        // Traditional way to get the response value.
        dialog.showAndWait().ifPresent(username -> {
            String password = showPasswordInputDialog();
            userDatabase.addEntity(new User(username, password));
        });
    }

    private String showPasswordInputDialog() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add User");
        dialog.setHeaderText(null);
        dialog.setContentText("Enter Password:");

        return dialog.showAndWait().orElse("");
    }

    private void showAddSmartphoneDialog() {
        TextInputDialog brandDialog = new TextInputDialog();
        brandDialog.setTitle("Add Smartphone");
        brandDialog.setHeaderText(null);
        brandDialog.setContentText("Enter Brand:");

        TextInputDialog modelDialog = new TextInputDialog();
        modelDialog.setTitle("Add Smartphone");
        modelDialog.setHeaderText(null);
        modelDialog.setContentText("Enter Model:");

        TextInputDialog priceDialog = new TextInputDialog();
        priceDialog.setTitle("Add Smartphone");
        priceDialog.setHeaderText(null);
        priceDialog.setContentText("Enter Price:");

        String brand = brandDialog.showAndWait().orElse("");
        String model = modelDialog.showAndWait().orElse("");
        String priceString = priceDialog.showAndWait().orElse("0");

        try {
            double price = Double.parseDouble(priceString);
            smartphoneDatabase.addEntity(new Smartphone(brand, model, price));
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Price must be a valid number.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void displayEntities(List<?> entities) {
        StringBuilder result = new StringBuilder();
        entities.forEach(entity -> result.append(entity).append("\n"));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Entities");
        alert.setHeaderText(null);
        alert.setContentText(result.toString());
        alert.showAndWait();
    }

    @Override
    public void stop() {
        userDatabase.closeEntityManager();
        smartphoneDatabase.closeEntityManager();
        logger.log(Level.INFO, "Exiting program. Goodbye!");
    }

    public static void main(String[] args) {
        launch(args);
    }
}