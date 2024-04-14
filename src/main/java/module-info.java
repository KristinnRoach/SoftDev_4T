module org.example.softdev_4t {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.softdev_4t to javafx.fxml;
    exports org.example.softdev_4t;
}