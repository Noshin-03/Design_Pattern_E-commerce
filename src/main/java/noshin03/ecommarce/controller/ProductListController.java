package noshin03.ecommarce.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import noshin03.ecommarce.db.DBConnect;
import noshin03.ecommarce.model.Product;

import java.sql.*;

public class ProductListController {

    @FXML private TableView<Product> productTable;
    @FXML private TableColumn<Product, Integer> idCol;
    @FXML private TableColumn<Product, String> nameCol;
    @FXML private TableColumn<Product, Double> priceCol;
    @FXML private TableColumn<Product, String> descCol;

    @FXML
    public void initialize() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        descCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        loadProductsFromDatabase();
    }

    private void loadProductsFromDatabase() {
        ObservableList<Product> products = FXCollections.observableArrayList();

        try (Connection conn = DBConnect.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM products")) {

            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("description"),
                        rs.getString("imagePath") // optional
                ));
            }

            productTable.setItems(products);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
