package application;

import java.sql.Connection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SignUp extends MainController{
	
	 @FXML
	    void register(ActionEvent event) {
	
	String name = txtname.getText().toString();
	String lastname = txtlastname.getText().toString();
	String phone = txtphone.getText().toString();
	String address = txtaddress.getText().toString();
    String password = txtpassword.getText().toString();
    
	try {
		Connection c = GetConnection.getConnection();
		ps= c.prepareStatement("insert into Facebook(name,lastname,phone,address,password) values (?,?,?,?,?)");
    		
		ps.setString(1, name);
		ps.setString(2, lastname);
		ps.setString(3, phone);
 		ps.setString(4, address);
		ps.setString(5, password);
		
		ps.executeUpdate();
		
			warning.setText("Login Successfully");
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		
	}catch(Exception e){
		e.printStackTrace();
	}
}

}