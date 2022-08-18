module com.unah.calculadora {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.unah.calculadora to javafx.fxml;
    exports com.unah.calculadora;
}
