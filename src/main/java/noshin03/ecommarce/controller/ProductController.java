package noshin03.ecommarce.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import noshin03.ecommarce.Application;

import java.io.IOException;

public class ProductController {
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    // UI Elements from product-detail.fxml
    @FXML
    private Label productName;

    @FXML
    private Label productPrice;

    @FXML
    private TextArea productDescription;

    @FXML
    private ImageView productImage;

    @FXML
    private Spinner<Integer> quantitySpinner;

    // Product data placeholders (simulate a real model)
    private String name;
    private String price;
    private String description;
    private String imagePath;

    // Call this method from outside to inject product data
    public void setProductDetails(String name, String price, String description, String imagePath) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.imagePath = imagePath;
    }

    @FXML
    public void initialize() {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 99, 1);
        quantitySpinner.setValueFactory(valueFactory);

        if (name == null) {
            name = "Sample T-Shirt";
            price = "$19.99";
            description = "This is a comfortable cotton T-shirt.";
            imagePath = "file:resources/images/sample.png"; // Adjust path
        }

        // Populate fields
        productName.setText(name);
        productPrice.setText(price);
        productDescription.setText(description);
        productImage.setImage(new Image(imagePath));
    }

    @FXML
    protected void handleAddToCart() {
        int quantity = quantitySpinner.getValue();
        System.out.println("Added to cart: " + name + " x" + quantity);

        // TODO: Add to cart logic using a shared Cart class (Singleton pattern recommended)
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
