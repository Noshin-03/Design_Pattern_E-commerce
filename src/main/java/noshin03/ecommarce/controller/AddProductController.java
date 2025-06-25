package noshin03.ecommarce.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import noshin03.ecommarce.db.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddProductController {

    @FXML
    private TextField productNameField;

    @FXML
    private TextField productPriceField;

    @FXML
    private TextArea productDescriptionField;

    @FXML
    protected void onSaveProductClick() {
        String name = productNameField.getText();
        String priceText = productPriceField.getText();
        String description = productDescriptionField.getText();

        if (name.isEmpty() || priceText.isEmpty()) {
            System.out.println("Name and price required.");
            return;
        }

        try {
            double price = Double.parseDouble(priceText);

            Connection conn = DBConnect.getConnection();
            String sql = "INSERT INTO products (name, price, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setDouble(2, price);
            stmt.setString(3, description);
            stmt.executeUpdate();

            System.out.println("Product saved successfully.");
            productNameField.clear();
            productPriceField.clear();
            productDescriptionField.clear();

        } catch (NumberFormatException e) {
            System.out.println("Invalid price value.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
