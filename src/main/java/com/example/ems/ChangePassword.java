package com.example.ems;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.paint.Color;

import java.io.IOException;

import static com.example.ems.Main.*;

public class ChangePassword {
    Main m = new Main();
    public ChangePassword(){

    }

    @FXML
    private Button button_back;
    @FXML
    private Button button_updatePass;
    @FXML
    private Label label_passwordChanged;
    @FXML
    private PasswordField pf_password;

    public void updatePass(ActionEvent event) throws IOException{
        if(!pf_password.getText().isEmpty()) {
            if(isAdmin){
                administratorList.get(isLoggedInIndex).setPassword(pf_password.getText().toString());
                label_passwordChanged.setTextFill(Color.GREEN);
                label_passwordChanged.setText("Password changed successfully!");
            }else if(isInstructor){
                instructorList.get(isLoggedInIndex).setPassword(pf_password.getText().toString());
                label_passwordChanged.setTextFill(Color.GREEN);
                label_passwordChanged.setText("Password changed successfully!");
            }else{
                studentList.get(isLoggedInIndex).setPassword(pf_password.getText().toString());
                label_passwordChanged.setTextFill(Color.GREEN);
                label_passwordChanged.setText("Password changed successfully!");
            }
        }else{
            label_passwordChanged.setTextFill(Color.RED);
            label_passwordChanged.setText("Please fill the blanks");
        }
    }
    public void goBack(ActionEvent event) throws IOException{
        if(isAdmin){
            m.changeScene("Admin_Loggedin_Title.fxml");
        }else if(isInstructor){
            m.changeScene("Instructor_Loggedin_Title.fxml");
        }else{
            m.changeScene("User_Loggedin_Title.fxml");
        }
    }



}
