package com.example.ems;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import static com.example.ems.Main.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class StudentPage implements Initializable {
    public StudentPage(){

    }
    Main m = new Main();
    private Label lab = new Label(studentList.get(isLoggedInIndex).getName());
    @FXML
    private Button button_answerExam;
    @FXML
    private Label label_firstName = lab;
    @FXML
    private Button button_logout;
    @FXML
    private Button button_printData;
    @FXML
    private Button button_changePass;
    @FXML
    private Button button_changeUsername;



    public void answerExam(ActionEvent event) throws IOException {
        m.changeScene("Student_answerExam_1.fxml");
    }
    public void changeUsername(ActionEvent event) throws IOException{
        m.changeScene("changeUsername2.fxml");
    }
    public void changePass(ActionEvent event) throws IOException{
        m.changeScene("changePassword.fxml");
    }
    public void printData(ActionEvent event) throws IOException{
        m.changeScene("printData.fxml");
    }
    public void userLogout(ActionEvent event) throws IOException{
        isLoggedIn = false;
        isAdmin = false;
        isInstructor = false;
        m.changeScene("Title.fxml");
    }
    public void showName(){
        label_firstName.setText(studentList.get(isLoggedInIndex).getName());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showName();
    }
}
