package noshin03.ecommarce;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import noshin03.ecommarce.controller.HomeController;

public class HelloApplication extends Application {
    @Override
//    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/noshin03/ecommarce/hello-view.fxml"));

        if (loader.getLocation() == null) {
            throw new RuntimeException("FXML file 'hello-view.fxml' not found!");
        }

        Parent root = loader.load();

        HomeController controller = loader.getController();
        controller.setStage(stage);

        stage.setTitle("Home Page");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
