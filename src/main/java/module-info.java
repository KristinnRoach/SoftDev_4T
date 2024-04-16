module org.example.softdev_4t {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.softdev_4t to javafx.fxml;
    exports org.example.softdev_4t;
    exports org.example.softdev_4t.controllers.Fligth;
    opens org.example.softdev_4t.controllers.Fligth to javafx.fxml;
    exports org.example.softdev_4t.controllers.Hotel;
    opens org.example.softdev_4t.controllers.Hotel to javafx.fxml;
    exports org.example.softdev_4t.controllers.Trip;
    opens org.example.softdev_4t.controllers.Trip to javafx.fxml;

    exports throunhu.is.hi;
    opens throunhu.is.hi to javafx.fxml;
}