package noshin03.ecommarce.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import noshin03.ecommarce.util.DatabaseSeeder;

public class AdminToolsController {

    @FXML
    private Button seedDatabaseButton;

    @FXML
    protected void onSeedDatabaseClick() {
        try {
            DatabaseSeeder.seed();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Database Seeding");
            alert.setHeaderText(null);
            alert.setContentText("Database seeded successfully!");
            alert.showAndWait();

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Seeding Failed");
            alert.setHeaderText(null);
            alert.setContentText("Something went wrong while seeding the database.");
            alert.showAndWait();

            e.printStackTrace();
        }
    }
}
