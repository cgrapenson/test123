package maven.test123;

import java.io.IOException;
import java.sql.*;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLDocumentController {

   
    

    @FXML
    private CheckBox login_showPassword;

    @FXML
    private TextField login_email;

    @FXML
    private Button login_loginBtn;

    @FXML
    private PasswordField login_password;

    @FXML
    private TextField login_passwordText; 
    
    

    private Connection conn;
    private AlertMessage alert = new AlertMessage();
    private boolean isPasswordVisible = false;
    

    @FXML
    public void showPassword(ActionEvent event) {
        if (isPasswordVisible) {
            // Hide the TextField and show the PasswordField
            login_passwordText.setVisible(false);
            login_password.setVisible(true);
            isPasswordVisible = false;
        } else {
            // Show the TextField and hide the PasswordField
            login_passwordText.setText(login_password.getText()); // Copy the password
            login_passwordText.setVisible(true);
            login_password.setVisible(false);
            isPasswordVisible = true;
            
        }
    }
    public void initialize() {
        try {
            DatabaseConnector dbConnector = new DatabaseConnector("jdbc:mysql://localhost/javadb", "root", "hejsan123");
            conn = dbConnector.getConnection(); // Corrected here
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
        boolean loginSuccess = AccountRepository.login(login_email.getText(), login_password.getText(),conn);
        if (loginSuccess) {
            
            
        try {

            Parent root = FXMLLoader.load(getClass().getResource("AdminMainScene.fxml"));
            Stage stage = new Stage();

            stage.setTitle("ENTER TITLE HERE");
            stage.setScene(new Scene(root));
            stage.show();

            login_loginBtn.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    else {
        alert.errorMessage("Login failed. Please try again.");
    }
}
}
