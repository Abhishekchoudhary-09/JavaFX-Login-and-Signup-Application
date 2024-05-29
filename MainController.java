package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController extends Main{
	@FXML
	protected Label warning;
	
	@FXML
	protected TextField txtlastname;

    @FXML
	protected TextField txtname;
    
    @FXML
    protected PasswordField txtpassword;
    
    @FXML
    protected TextField txtaddress;
    
    @FXML
    protected TextField txtphone;

    PreparedStatement ps;
    
	
    @FXML
	public void Login(ActionEvent event) throws Exception {
    	try {
            Connection c = GetConnection.getConnection();
            ps = c.prepareStatement("SELECT * FROM facebook WHERE name=? AND password=?");
            ps.setString(1, txtname.getText()); // Use getText() instead of toString()
            ps.setString(2, txtpassword.getText()); // Use getText() instead of toString()
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Move the cursor to the first row (if it exists)
                int id = rs.getInt("id");
                System.out.println("ID: " + id);

                // Check if the entered values match those in the result set
                if (txtname.getText().equals(rs.getString("name")) && txtpassword.getText().equals(rs.getString("password"))) {
                    warning.setText("Login Successfully");
                    Stage primaryStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("/Home.fxml"));
                    Scene scene = new Scene(root, 400, 400);
                    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                    primaryStage.setScene(scene);
                    primaryStage.show();
                } else {
                    warning.setText("Login Failed");
                }
            } else {
                // Handle the case where the result set is empty
                warning.setText("Login Failed");
            }
			
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		
	}
    @FXML
	public void SignUp(ActionEvent event) throws Exception {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/SignUp.fxml"));
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

}