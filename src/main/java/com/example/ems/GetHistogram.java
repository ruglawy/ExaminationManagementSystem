package com.example.ems;
import static com.example.ems.Main.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.io.IOException;

public class GetHistogram {
    public GetHistogram(){

    }
    Main m = new Main();
    @FXML
    private Button button_back;
    @FXML
    private Button button_getHistogram;
    @FXML
    private Label label_infoWrong;
    @FXML
    private TextField tf_examID;
    protected static int currentExamIndex;

    public void goBack(ActionEvent event) throws IOException {
        m.changeScene("Instructor_Loggedin_Title.fxml");
    }

    public void goNext(ActionEvent event) throws IOException {
        String examID = tf_examID.getText();
        if(!(examID.isEmpty())) {
            if (Integer.parseInt(examID) < examList.size()) {
                currentExamIndex = Integer.parseInt(examID);
                m.changeScene("Instructor_getHistogram_2.fxml");
            } else {
                label_infoWrong.setTextFill(Color.RED);
                label_infoWrong.setText("Exam not found, please enter a valid ID");
            }
        }else{
            label_infoWrong.setTextFill(Color.RED);
            label_infoWrong.setText("Please enter an ID");
        }
    }

    public void keyPressed(KeyEvent ke) {
        String value = tf_examID.getText();
        try{
            Integer.parseInt(ke.getText());
            tf_examID.setEditable(true);
        }catch(Exception e){
            tf_examID.setEditable(false);
        }
        if(!ke.getText().isEmpty()){
            try {
                Integer.parseInt(ke.getText());
            } catch (Exception e) {
                if (!value.isEmpty()) {
                    tf_examID.setEditable(false);
                }
            }
        }else{
            tf_examID.setEditable(true);
        }
    }
}
