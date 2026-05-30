module org.finance.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.finance.demo to javafx.fxml;
    exports org.finance.demo;
}