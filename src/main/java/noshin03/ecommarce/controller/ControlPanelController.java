package noshin03.ecommarce.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import noshin03.ecommarce.Application;

import java.io.IOException;

public class ControlPanelController {
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private void switchScene(String fxml, Object controller) throws IOException {
        FXMLLoader loader = new FXMLLoader(Application.class.getResource(fxml));
        loader.setController(controller);
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void goToProductList() throws IOException {
        ProductListController ctrl = new ProductListController();
        switchScene("product-list-view.fxml", ctrl);
    }

    @FXML
    protected void goToOrderList() throws IOException {
        OrderListController ctrl = new OrderListController();
        switchScene("order-list-view.fxml", ctrl);
    }

    @FXML
    protected void goToCustomerList() throws IOException {
        CustomerListController ctrl = new CustomerListController();
        switchScene("customer-list-view.fxml", ctrl);
    }

    @FXML
    protected void goToAdminTools() throws IOException {
        AdminToolsController ctrl = new AdminToolsController();
        switchScene("admin-tools-view.fxml", ctrl);
    }

    @FXML
    protected void goBackHome() throws IOException {
        HomeController ctrl = new HomeController();
        ctrl.setStage(stage);
        switchScene("home-view.fxml", ctrl);
    }

}
