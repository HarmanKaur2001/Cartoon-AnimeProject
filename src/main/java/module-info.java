module com.example.cartoonanimeproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.cartoonanimeproject to javafx.fxml;
    exports com.example.cartoonanimeproject;
}