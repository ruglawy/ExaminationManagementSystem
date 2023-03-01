package com.example.ems;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import static com.example.ems.Main.*;

import java.io.IOException;

public class AdminPage {
    public AdminPage(){

    }
    Main m = new Main();
    @FXML
    private Button button_createAccount;
    @FXML
    private Button button_deleteAccount;

    public void createAccount(ActionEvent event) throws IOException {
        m.changeScene("Registration.fxml");
    }
    public void Logout(ActionEvent event) throws IOException{
        isAdmin = false;
        isLoggedIn = false;
        isInstructor = false;
        m.changeScene("Title.fxml");
    }

}
