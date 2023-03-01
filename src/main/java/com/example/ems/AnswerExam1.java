package com.example.ems;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import static com.example.ems.Main.*;

import java.io.IOException;
import java.util.List;

public class AnswerExam1 {
    public AnswerExam1(){

    }
    Main m = new Main();
    @FXML
    private Button button_back;
    @FXML
    private Button button_takeExam;
    @FXML
    private Label label_infoWrong;
    @FXML
    private TextField tf_examID;
    protected static int currentExamIndex;

    public void keyPressed(KeyEvent ke){
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

    public void goNext(ActionEvent event) throws IOException{
        String examID = tf_examID.getText();
        List<Integer> takenExams = studentList.get(isLoggedInIndex).getTakenExam();
        boolean tookExam = false;
        if(!(examID.isEmpty())) {
            if(!(takenExams.size() == 0)){
                for(int i = 0; i < takenExams.size() ; i++){
                    if(Integer.parseInt(examID) == takenExams.get(i)){
                        tookExam = true;
                    }
                }
            }
            if(!tookExam) {
                if (Integer.parseInt(examID) < examList.size()) {
                    currentExamIndex = Integer.parseInt(examID);
                    m.changeScene("Student_answerExam_2.fxml");
                } else {
                    label_infoWrong.setTextFill(Color.RED);
                    label_infoWrong.setText("Exam not found, please enter a valid ID");
                }
            }else{
                label_infoWrong.setTextFill(Color.RED);
                label_infoWrong.setText("You have already taken this exam");
            }
        }else{
            label_infoWrong.setTextFill(Color.RED);
            label_infoWrong.setText("Please enter an ID");
        }
    }

    public void goBack(ActionEvent event) throws IOException{
        m.changeScene("User_Loggedin_Title.fxml");
    }
}
