package com.example.ems;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import static com.example.ems.Main.*;


public class LoginPage {
    public LoginPage() {

    }
    @FXML
    private Label label_infoWrong;
    @FXML
    private TextField tf_username;
    @FXML
    private PasswordField tf_password;
    @FXML
    private Button button_login;
    @FXML
    private Button button_toRegister;
    @FXML
    private Button button_exit;

    public void userLogin(ActionEvent event) throws IOException{
        checkLogin();
    }
    public void userExit(ActionEvent event) throws IOException {
        System.exit(0);
    }
    public void userRegister(ActionEvent event) throws IOException{

    }

    public void checkLogin() throws IOException{
        Main m = new Main();

        if(!isLoggedIn) {
            for (int i = 0; i < studentList.size(); i++) {
                studentList.get(i).login(tf_username.getText(), tf_password.getText());
                if (studentList.get(i).isLoggedIn()) {
                    isLoggedIn = true;
                    isLoggedInIndex = i;
                    break;
                }
            }
            if (!isLoggedIn) {
                for (int i = 0; i < instructorList.size(); i++) {
                    instructorList.get(i).login(tf_username.getText(), tf_password.getText());
                    if (instructorList.get(i).isLoggedIn()) {
                        isLoggedIn = true;
                        isLoggedInIndex = i;
                        isInstructor = true;
                        break;

                    }
                }
                if (!isLoggedIn) {
                    for (int i = 0; i < administratorList.size(); i++) {
                        administratorList.get(i).login(tf_username.getText(), tf_password.getText());
                        if (administratorList.get(i).isLoggedIn()) {
                            isLoggedIn = true;
                            isLoggedInIndex = i;
                            isAdmin = true;
                            break;
                        }
                    }
                }
            }
            if (isLoggedIn) {
                //System.out.println("Successfully logged in");
                if(isInstructor){
                    m.changeScene("Instructor_Loggedin_Title.fxml");
                }else if(isAdmin){
                    m.changeScene("Admin_Loggedin_Title.fxml");
                }else{
                    m.changeScene("User_Loggedin_Title.fxml");
                }

            } else {
                if(tf_username.getText().isEmpty() || tf_password.getText().isEmpty()){
                    label_infoWrong.setText("Please input data in the fields");
                }else {
                    label_infoWrong.setText("Incorrect username or password");
                }
            }
        }
    }



}
