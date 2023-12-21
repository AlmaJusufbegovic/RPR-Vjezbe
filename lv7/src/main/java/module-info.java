module com.example.lv7 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.lv7 to javafx.fxml;
    exports com.example.lv7;
}