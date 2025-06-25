package noshin03.ecommarce.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import noshin03.ecommarce.db.DBConnect;

import java.sql.*;

public class OrderListController {

    @FXML private TableView<OrderRow> orderTable;
    @FXML private TableColumn<OrderRow, Integer> idCol;
    @FXML private TableColumn<OrderRow, String> customerCol;
    @FXML private TableColumn<OrderRow, String> statusCol;
    @FXML private TableColumn<OrderRow, String> dateCol;

    @FXML
    public void initialize() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        customerCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        ObservableList<OrderRow> orders = FXCollections.observableArrayList();

        try (Connection conn = DBConnect.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("""
                     SELECT o.id, c.name, o.status, o.date
                     FROM orders o
                     JOIN customers c ON o.customer_id = c.id
                 """)) {

            while (rs.next()) {
                orders.add(new OrderRow(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("status"),
                        rs.getString("date")
                ));
            }

            orderTable.setItems(orders);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static class OrderRow {
        private final int id;
        private final String customerName, status, date;

        public OrderRow(int id, String customerName, String status, String date) {
            this.id = id;
            this.customerName = customerName;
            this.status = status;
            this.date = date;
        }

        public int getId() { return id; }
        public String getCustomerName() { return customerName; }
        public String getStatus() { return status; }
        public String getDate() { return date; }
    }
}
