/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareii;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author johnnypeterson
 */
public class MainScreenController extends Application {
    
    //JP database creds
    	private final static String DRIVER = "com.mysql.jdbc.Driver";
	public final static String URL = "jdbc:mysql://52.206.157.109/U03Rt2";
	public final static String USER_NAME = "U03Rt2";
	public final static String PASSWORD = "53688060994";
        private static Connection conn = null;
        boolean res = false;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        launch(args);
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            System.out.println("connection to database...");
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        Statement stmt;
        ResultSet rs = null;
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT country From country");
            while (rs.next()) {
                String country = rs.getString(1);
                System.out.println(country);
                
            }
            
   
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
