package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Tabs implements Initializable {


    @FXML
    public TabPane tbPane;
    @FXML
    public Tab t1, t2;

    public void initialize(URL url, ResourceBundle rb) {

           try {
            t1.setContent(FXMLLoader.load(getClass().getResource("Event.fxml")));
        } catch (Exception e) {
            System.out.println("Idk What went wrong");
        }
        /*
        try {
            t2.setContent(FXMLLoader.load(getClass().getResource("Chart.fxml")));
        } catch (Exception c) {
            System.out.println("Idk What went wrong");
        }

    }*/
    }
}
