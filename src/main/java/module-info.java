module ru.ke46138.untitledcalc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.compiler;


    opens ru.ke46138.untitledcalc to javafx.fxml;
    exports ru.ke46138.untitledcalc;
}