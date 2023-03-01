package com.example.ems;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.ems.Main.*;

public class ShowInfo implements Initializable {
    Main m = new Main();
    public ShowInfo(){

    }
    @FXML
    private Label label_Username;
    @FXML
    private Label label_Name;
    @FXML
    private Label label_phoneNumber;
    @FXML
    private Label label_email;
    @FXML
    private Button button_back;

    public void printData(){
        if(isAdmin){
            label_Username.setText(administratorList.get(isLoggedInIndex).getUsername());
            label_Name.setText(administratorList.get(isLoggedInIndex).getName());
            label_phoneNumber.setText(administratorList.get(isLoggedInIndex).getMobileNumber());
            label_email.setText(administratorList.get(isLoggedInIndex).getEmailAddress());
        }else if(isInstructor){
            label_Username.setText(instructorList.get(isLoggedInIndex).getUsername());
            label_Name.setText(instructorList.get(isLoggedInIndex).getName());
            label_phoneNumber.setText(instructorList.get(isLoggedInIndex).getMobileNumber());
            label_email.setText(instructorList.get(isLoggedInIndex).getEmailAddress());
        }else{
            label_Username.setText(studentList.get(isLoggedInIndex).getUsername());
            label_Name.setText(studentList.get(isLoggedInIndex).getName());
            label_phoneNumber.setText(studentList.get(isLoggedInIndex).getMobileNumber());
            label_email.setText(studentList.get(isLoggedInIndex).getEmailAddress());
        }
    }

    public void goBack() throws IOException{
        if(isAdmin){
            m.changeScene("Admin_Loggedin_Title.fxml");
        }else if(isInstructor){
            m.changeScene("Instructor_Loggedin_Title.fxml");
        }else{
            m.changeScene("User_Loggedin_Title.fxml");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        printData();
    }
}
