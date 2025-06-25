package noshin03.ecommarce.controller;

import noshin03.ecommarce.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
//...
public class AuthController {
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    protected void login() throws IOException {
        System.out.println("login");
    }

    @FXML
    protected void onGotoHomePageButtonClick() throws IOException {
        HomeController homeController = new HomeController();
        homeController.setStage(this.stage);

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("hello-view.fxml"));
        fxmlLoader.setController(homeController);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}