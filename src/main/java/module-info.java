module org.myapp.automobile {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;
    requires java.desktop;


    exports org.myapp.automobile.igu;
    opens org.myapp.automobile.igu to javafx.fxml;
    exports org.myapp.automobile.igu.controllers;
    exports org.myapp.automobile.logic;
    opens org.myapp.automobile.logic to org.hibernate.orm.core;
    opens org.myapp.automobile.igu.controllers to javafx.fxml;
}