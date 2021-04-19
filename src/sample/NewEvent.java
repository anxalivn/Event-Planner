package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class NewEvent  implements Initializable {
    @FXML
    public TextField eventN;
    @FXML
    public DatePicker datePicked;
    @FXML
    public Button btnEvent;
    public LocalDate today;
    public static long diff;
    public AnchorPane roots;


    public void initialize(URL url, ResourceBundle rb) {
        btnEvent.setDisable(true);
        datePicked.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                 today = LocalDate.now();

                setDisable(empty || date.compareTo(today) <= 0 );
            }
        });

    }
    public void create(){
        String dates = datePicked.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String sql = "INSERT INTO ganbaatakh_Event(eventName,eventDate) VALUES(?,?)";
        try (
                PreparedStatement pstmt = login.conn.prepareStatement(sql)) {
            pstmt.setString(1, eventN.getText());
            pstmt.setString(2, dates);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        java.util.Date date = java.sql.Date.valueOf(datePicked.getValue());
        Date today = new Date();
        diff = date.getTime() - today.getTime();
        diff = diff / (1000L*60L*60L*24L);
        System.out.println(diff);
        try {
            TabPane parentContent = FXMLLoader.load(getClass().getResource(("Tabs.fxml")));
            roots.getChildren().setAll(parentContent);
        }
        catch (Exception e) {
            System.out.println("Idk What went wrong");
        }

    }
    @FXML
    private void keyReleased(){
        String cat = eventN.getText();
        boolean isDisabled = ((cat.isEmpty() || cat.trim().isEmpty()) || datePicked.hasProperties());
        btnEvent.setDisable(isDisabled);
    }

}
