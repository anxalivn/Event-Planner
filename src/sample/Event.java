package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Event implements Initializable {
    @FXML
    public Label cntDown, eName;
    public void initialize(URL url, ResourceBundle rb) {
        cntDown.setText(String.valueOf(NewEvent.diff));


    }
}
