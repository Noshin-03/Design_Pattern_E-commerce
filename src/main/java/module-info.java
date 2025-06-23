module noshin03.ecommarce {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires jbcrypt;

    opens noshin03.ecommarce to javafx.fxml;
    exports noshin03.ecommarce;

    opens noshin03.ecommarce.controller to javafx.fxml;
    exports noshin03.ecommarce.controller;
}
