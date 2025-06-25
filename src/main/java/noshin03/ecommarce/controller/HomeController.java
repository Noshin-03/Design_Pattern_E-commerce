package noshin03.ecommarce.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import noshin03.ecommarce.Application;
import noshin03.ecommarce.HelloApplication;

import java.io.IOException;

public class HomeController {
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    protected void onGotoLoginPageButtonClick() throws IOException {
        AuthController authController = new AuthController();
        authController.setStage(this.stage);

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("login-view.fxml"));
        fxmlLoader.setController(authController);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onGoToControlPanelClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("control-panel-view.fxml"));
        Parent root = fxmlLoader.load();
        ControlPanelController controller = fxmlLoader.getController();
        controller.setStage(stage);

        // Set stage title and show new scene
        stage.setTitle("Control Panel");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
}
