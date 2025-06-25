package noshin03.ecommarce.model;

import javafx.beans.property.*;

public class Product {
    private final IntegerProperty id;
    private final StringProperty name;
    private final DoubleProperty price;
    private final StringProperty description;
    private final StringProperty imagePath;

    public Product(int id, String name, double price, String description, String imagePath) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.description = new SimpleStringProperty(description);
        this.imagePath = new SimpleStringProperty(imagePath);
    }

    public int getId() { return id.get(); }
    public String getName() { return name.get(); }
    public double getPrice() { return price.get(); }
    public String getDescription() { return description.get(); }
    public String getImagePath() { return imagePath.get(); }

    public IntegerProperty idProperty() { return id; }
    public StringProperty nameProperty() { return name; }
    public DoubleProperty priceProperty() { return price; }
    public StringProperty descriptionProperty() { return description; }
    public StringProperty imagePathProperty() { return imagePath; }
}
