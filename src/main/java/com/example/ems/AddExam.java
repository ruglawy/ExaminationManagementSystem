package com.example.ems;

import static com.example.ems.Main.*;
import static com.example.ems.AddExam2.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import java.lang.Integer.*;

import java.io.IOException;

public class AddExam {

    public AddExam(){

    }
    Main m = new Main();

    @FXML
    private Button button_Next;
    @FXML
    private Label label_error;
    @FXML
    private Button button_back;
    @FXML
    private TextField tf_courseCode;
    @FXML
    private DatePicker tf_releaseDate;
    @FXML
    private ComboBox comboBoxStart;
    @FXML
    private ComboBox comboBoxEnd;
    @FXML
    private TextField tf_numberOfQuestions;


    public void keyPressed(KeyEvent ke) {
        String value = tf_numberOfQuestions.getText();
        try{
            Integer.parseInt(ke.getText());
            tf_numberOfQuestions.setEditable(true);
        }catch(Exception e){
            tf_numberOfQuestions.setEditable(false);
        }
        if(!ke.getText().isEmpty()){
            try {
                Integer.parseInt(ke.getText());
            } catch (Exception e) {
                if (!value.isEmpty()) {
                    tf_numberOfQuestions.setEditable(false);
                }
            }
        }else{
            tf_numberOfQuestions.setEditable(true);
        }


    }


     @FXML
     public void initialize(){
         comboBoxStart.getItems().removeAll(comboBoxStart.getItems());
         comboBoxStart.getItems().addAll("00:00","01:00","02:00","03:00","04:00","05:00",
                 "06:00","07:00","08:00","09:00","10:00","11:00","12:00",
                 "13:00","14:00","15:00","16:00","17:00","18:00","19:00",
                 "20:00","21:00","22:00","23:00");
         comboBoxEnd.getItems().removeAll(comboBoxEnd.getItems());
         comboBoxEnd.getItems().addAll("00:00","01:00","02:00","03:00","04:00","05:00",
                 "06:00","07:00","08:00","09:00","10:00","11:00","12:00",
                 "13:00","14:00","15:00","16:00","17:00","18:00","19:00",
                 "20:00","21:00","22:00","23:00");
         tf_releaseDate.setEditable(false);
     }



    public void goBack(ActionEvent event) throws IOException {
        m.changeScene("Instructor_Loggedin_Title.fxml");
    }

    @FXML
    public void goNext(ActionEvent event) throws IOException {
        if(!(tf_numberOfQuestions.getText().isEmpty() || tf_courseCode.getText().isEmpty() || tf_releaseDate.getValue() == null || comboBoxStart.getSelectionModel().isEmpty() || comboBoxEnd.getSelectionModel().isEmpty()))
        {
            if(Integer.parseInt(tf_numberOfQuestions.getText()) > 0) {
                noOfQuestions = Integer.parseInt(tf_numberOfQuestions.getText());
                courseCode = tf_courseCode.getText();
                releaseDate = tf_releaseDate.getValue().toString();
                startTime = comboBoxStart.getSelectionModel().getSelectedItem().toString();
                endTime = comboBoxEnd.getSelectionModel().getSelectedItem().toString();
                m.changeScene("Instructor_AddNewExam_2.fxml");
            }else{
                label_error.setText("Input a number greater than zero");
            }
        }else{
            label_error.setText("Please fill the blanks");
        }
    }
}
