package com.example.ems;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;

import static com.example.ems.Main.studentList;
import static com.example.ems.Main.*;

public class ChangeUsername extends LoginPage {
    public ChangeUsername(){

    }
    Main m = new Main();
    @FXML
    private Label label_usernameChanged;
    @FXML
    private TextField tf_usernameChanged;
    @FXML
    private Button button_updateUsername;
    @FXML
    private Button button_back;

    public void updateUsername() throws IOException{
        if(!tf_usernameChanged.getText().isEmpty()) {
            if(isAdmin){
                administratorList.get(isLoggedInIndex).setUsername(tf_usernameChanged.getText().toString());
                label_usernameChanged.setTextFill(Color.GREEN);
                label_usernameChanged.setText("Username changed successfully!");
            }else if(isInstructor){
                instructorList.get(isLoggedInIndex).setUsername(tf_usernameChanged.getText().toString());
                label_usernameChanged.setTextFill(Color.GREEN);
                label_usernameChanged.setText("Username changed successfully!");
            }else{
                studentList.get(isLoggedInIndex).setUsername(tf_usernameChanged.getText().toString());
                label_usernameChanged.setTextFill(Color.GREEN);
                label_usernameChanged.setText("Username changed successfully!");
            }
        }else{
            label_usernameChanged.setTextFill(Color.RED);
            label_usernameChanged.setText("Please fill the blanks");
        }
    }
    public void returnPage() throws IOException{
        if(isAdmin){
            m.changeScene("Admin_Loggedin_Title.fxml");
        }else if(isInstructor){
            m.changeScene("Instructor_Loggedin_Title.fxml");
        }else{
            m.changeScene("User_Loggedin_Title.fxml");
        }
    }

}
