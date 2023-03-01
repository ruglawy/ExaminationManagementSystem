package com.example.ems;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class DeleteAccount {
    public DeleteAccount(){

    }
    Main m = new Main();
    @FXML
    private Button button_back;
    @FXML
    private Button button_delete;
    @FXML
    private TextField tf_usernameDelete;
    @FXML
    private Label label_messageDelete;

    public void Deleteacc(ActionEvent event) throws IOException {

    }
    public void goBack(ActionEvent event) throws IOException{
        m.changeScene("Admin_Loggedin_Title.fxml");
    }
}
