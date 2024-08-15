module org.myapp.automobile {
    requires javafx.controls;
    requires javafx.fxml;




    exports org.myapp.automobile.igu;
    opens org.myapp.automobile.igu to javafx.fxml;
    exports org.myapp.automobile.igu.controller;
    opens org.myapp.automobile.igu.controller to javafx.fxml;
}