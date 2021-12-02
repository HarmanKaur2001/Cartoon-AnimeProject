module com.example.cartoonanimeproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires com.google.gson;
    requires java.net.http;


    opens com.example.cartoonanimeproject to javafx.fxml;
    exports com.example.cartoonanimeproject;
    exports com.example.cartoonanimeproject.Controllers;
    opens com.example.cartoonanimeproject.Controllers to com.google.gson, javafx.fxml;
}

