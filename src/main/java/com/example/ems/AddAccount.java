package com.example.ems;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import static com.example.ems.Main.*;


import java.io.IOException;

public class AddAccount {
    public AddAccount(){

    }
    Main m = new Main();
    @FXML
    private Button button_register;
    @FXML
    private Button button_goBack;
    @FXML
    private TextField tf_username, tf_firstName, tf_lastName, tf_email, tf_mobileNumber;
    @FXML
    private PasswordField pf_password;
    @FXML
    private Label label_registerMessage;
    @FXML
    private ComboBox accountType;

    @FXML
    public void initialize() {
        accountType.getItems().removeAll(accountType.getItems());
        accountType.getItems().addAll("Instructor", "Student", "Admin");
        accountType.getSelectionModel().select("Instructor");
    }

    public void keyPressed(KeyEvent ke) {
        String value = tf_mobileNumber.getText();
        try{
            Integer.parseInt(ke.getText());
            tf_mobileNumber.setEditable(true);
        }catch(Exception e){
            tf_mobileNumber.setEditable(false);
        }
        if(!ke.getText().isEmpty()){
            try {
                Integer.parseInt(ke.getText());
            } catch (Exception e) {
                if (!value.isEmpty()) {
                    tf_mobileNumber.setEditable(false);
                }
            }
        }else{
            tf_mobileNumber.setEditable(true);
        }

    }


    public void RegisterAccount() throws IOException {
        if(!(tf_username.getText().isEmpty() || tf_email.getText().isEmpty() || tf_mobileNumber.getText().isEmpty() || tf_firstName.getText().isEmpty() || tf_lastName.getText().isEmpty() || pf_password.getText().isEmpty())){
            String sel = accountType.getSelectionModel().getSelectedItem().toString();
            if(sel.equals("Instructor")){
                Instructor newInstructor = new Instructor(tf_username.getText().toString(), pf_password.getText().toString(), tf_firstName.getText().toString() + " " + tf_lastName.getText().toString(), tf_mobileNumber.getText().toString(), tf_email.getText().toString(), 20, listOfCourses);
                instructorList.add(newInstructor);
                label_registerMessage.setTextFill(Color.GREEN);
                label_registerMessage.setText("Instructor successfully added!");
            }else if(sel.equals("Admin")){
                Administrator newAdmin = new Administrator(tf_username.getText().toString(), pf_password.getText().toString(), tf_firstName.getText().toString() + " " + tf_lastName.getText().toString(), tf_mobileNumber.getText().toString(), tf_email.getText().toString());
                administratorList.add(newAdmin);
                label_registerMessage.setTextFill(Color.GREEN);
                label_registerMessage.setText("Admin successfully added!");
            }else{
                Student newStudent = new Student(tf_username.getText().toString(), pf_password.getText().toString(), tf_firstName.getText().toString() + " " + tf_lastName.getText().toString(), tf_mobileNumber.getText().toString(), tf_email.getText().toString());
                studentList.add(newStudent);
                label_registerMessage.setTextFill(Color.GREEN);
                label_registerMessage.setText("Student successfully added!");
            }
        }else{
            label_registerMessage.setTextFill(Color.RED);
            label_registerMessage.setText("Please fill the missing blanks");
        }
    }
    public void goBack() throws IOException{
        m.changeScene("Admin_Loggedin_Title.fxml");
    }
}
