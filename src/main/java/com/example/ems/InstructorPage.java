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

import static com.example.ems.Main.isAdmin;

public class InstructorPage implements Initializable {
    public InstructorPage(){

    }
    Main m = new Main();
    @FXML
    private Button button_addNewExam;
    @FXML
    private Button button_changePass;
    @FXML
    private Button button_changeUsername;
    @FXML
    private Button button_getEvaluationReport;
    @FXML
    private Button button_getHistogram;
    @FXML
    private Button button_logout;
    @FXML
    private Button button_printData;
    @FXML
    private Label label_firstName;


    public void addNewExam(ActionEvent event) throws IOException {
        m.changeScene("Instructor_AddNewExam_1.fxml");
    }


    public void changePassword(ActionEvent event) throws IOException {
        m.changeScene("changePassword.fxml");
    }


    public void changeUsername(ActionEvent event) throws IOException {
        m.changeScene("changeUsername2.fxml");
    }


    public void getEvReport(ActionEvent event) throws IOException {
        m.changeScene("Instructor_EvaluationExamReport_1.fxml");
    }


    public void getHistogram(ActionEvent event) throws IOException {
        m.changeScene("Instructor_getHistogram_1.fxml");
    }


    public void instructorLogout(ActionEvent event) throws IOException {
        isAdmin = false;
        isInstructor = false;
        isLoggedIn = false;
        m.changeScene("Title.fxml");
    }


    public void showData(ActionEvent event) throws IOException {
        m.changeScene("printData.fxml");
    }

    public void showName(){
        label_firstName.setText(instructorList.get(isLoggedInIndex).getName());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showName();
    }
}
