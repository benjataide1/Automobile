module org.myapp.automobile {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires org.hibernate.orm.core;


    exports org.myapp.automobile.igu;
    opens org.myapp.automobile.igu to javafx.fxml;
    exports org.myapp.automobile.igu.controllers;
    opens org.myapp.automobile.igu.controllers to javafx.fxml;
}