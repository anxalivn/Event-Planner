package sample;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class login implements Initializable {
    @FXML
    public static ObservableList<EventC> eve = FXCollections.observableArrayList();
    @FXML public AnchorPane root;
    public TextField tfUsername;
    public PasswordField tfPassword;
    @FXML
    public static Connection conn;
    public DbConnection dc;
    public ResultSet rs;

    public void initialize(URL url, ResourceBundle rb){
        if (!Main.isSplashLoaded){
            loadSplashScreen();}
    }

    public void btnLogin() {
        if (tfUsername.getText().equals("khanx") && tfPassword.getText().equals("test123")) {
            Alert msg = new Alert(Alert.AlertType.INFORMATION);
            msg.setTitle("Message");
            msg.setHeaderText("Successful Login");
            msg.showAndWait();
            dc = new DbConnection();
            conn = dc.Connect();
            try {
                rs = conn.createStatement().executeQuery("SELECT * FROM weddingUP");
                if (!rs.next()){
                    try {
                        AnchorPane parentContent = FXMLLoader.load(getClass().getResource(("NewEvent.fxml")));
                        root.getChildren().setAll(parentContent);
                    }
                    catch (Exception e) {
                        System.out.println("Idk What went wrong");
                    }
                }
                else{
                        eve.add(new EventC(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
                    try {
                        TabPane parentContent = FXMLLoader.load(getClass().getResource(("Tabs.fxml")));
                        root.getChildren().setAll(parentContent);
                    }
                    catch (Exception e) {
                        System.out.println("Idk What went wrong");
                    }
                    }
            } catch (SQLException e) {
                System.err.println("Error" + e);
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid UserName or Password");
            alert.showAndWait();
            tfUsername.clear();
            tfPassword.clear();
            tfUsername.requestFocus();
        }
    }

    public void loadSplashScreen(){
        try {
            Main.isSplashLoaded = true;
            AnchorPane rootPane = FXMLLoader.load(getClass().getResource(("Splash.fxml")));
            root.getChildren().setAll(rootPane);

            FadeTransition fadeIn = new FadeTransition(Duration.seconds(3),rootPane);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);

            FadeTransition fadeOut = new FadeTransition(Duration.seconds(3),rootPane);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setCycleCount(1);

            fadeIn.play();

            fadeIn.setOnFinished((e)->{
                fadeOut.play();

            });
            fadeOut.setOnFinished((e) -> {
                try {
                    AnchorPane parentContent = FXMLLoader.load(getClass().getResource(("login.fxml")));
                    root.getChildren().setAll(parentContent);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
