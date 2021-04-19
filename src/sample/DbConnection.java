package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {
    public Connection Connect(){
        try {
            String url = "arn:aws:dynamodb:us-east-2:705266085610:table/weddingUP\n";
            String username = "khanx";
            String password = "test123";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        }
        catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;

    }
}
