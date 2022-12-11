module com.example.paimonplzjustspareme {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.paimonplzjustspareme to javafx.fxml;
    exports com.example.paimonplzjustspareme;
}