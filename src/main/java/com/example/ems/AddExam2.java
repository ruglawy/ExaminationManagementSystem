package com.example.ems;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import static com.example.ems.Main.*;

import java.io.IOException;

public class AddExam2 {
    protected static int noOfQuestions;
    protected static String courseCode;
    protected static String releaseDate;
    protected static String startTime;
    protected static String endTime;

    public AddExam2(){

    }

    Main m = new Main();
    @FXML
    private Button button_Next;
    @FXML
    private Button button_back;
    @FXML
    private Label label_errorMessage;
    @FXML
    private Label label_examID;
    @FXML
    private Label label_qNumber;
    @FXML
    private TextField tf_Grade;
    @FXML
    private TextField tf_choices1;
    @FXML
    private TextField tf_choices2;
    @FXML
    private TextField tf_choices3;
    @FXML
    private TextField tf_choices4;
    @FXML
    private TextField tf_correctChoice;
    @FXML
    private TextField tf_questionText;

    private int questionIndex = 0;
    private Question[] qArray = new Question[noOfQuestions];

    public void goNext() throws IOException {
        if(!(tf_questionText.getText().isEmpty() || tf_choices1.getText().isEmpty() || tf_choices2.getText().isEmpty() || tf_choices3.getText().isEmpty() || tf_choices4.getText().isEmpty() || tf_correctChoice.getText().isEmpty() || tf_Grade.getText().isEmpty())) {

            if (questionIndex <= noOfQuestions - 1) {
                String[] choices = new String[4];
                choices[0] = tf_choices1.getText().toString();
                choices[1] = tf_choices2.getText().toString();
                choices[2] = tf_choices3.getText().toString();
                choices[3] = tf_choices4.getText().toString();
                int correctChoice = Integer.parseInt(tf_correctChoice.getText());
                if(correctChoice >= 1 && correctChoice <= 4) {
                    qArray[questionIndex] = new Question(tf_questionText.getText().toString(), choices, correctChoice, Integer.parseInt(tf_Grade.getText()));


                    tf_questionText.clear();
                    tf_choices1.clear();
                    tf_choices2.clear();
                    tf_choices3.clear();
                    tf_choices4.clear();
                    tf_correctChoice.clear();
                    tf_Grade.clear();

                    label_errorMessage.setTextFill(Color.GREEN);
                    label_errorMessage.setText("Question " + (questionIndex + 1) + " added!");
                    questionIndex++;
                    label_qNumber.setText(Integer.toString(questionIndex + 1));
                }else{
                    label_errorMessage.setTextFill(Color.RED);
                    label_errorMessage.setText("Index is between 1 & 4");
                }



            } //else {
                //examList.add(new Exam(instructorList.get(isLoggedInIndex).getName(), courseCode, duration, startTime, endTime, "N/A", qArray, true));
                //label_errorMessage.setTextFill(Color.GREEN);
                //label_errorMessage.setText("Exam successfully added!");
                //button_Next.setDisable(true);
               // questionList.add(qArray);
            //}
            if(questionIndex == noOfQuestions){
                Exam newExam = new Exam(instructorList.get(isLoggedInIndex).getName(), courseCode, 0, startTime, endTime, releaseDate.toString(), qArray, true);
                examList.add(newExam);
                label_qNumber.setText("DONE!");
                tf_Grade.setDisable(true);
                tf_correctChoice.setDisable(true);
                tf_choices1.setDisable(true);
                tf_choices2.setDisable(true);
                tf_choices3.setDisable(true);
                tf_choices4.setDisable(true);
                tf_questionText.setDisable(true);
                label_errorMessage.setTextFill(Color.GREEN);
                label_errorMessage.setText("Exam successfully added!");
                button_Next.setDisable(true);
                questionList.add(qArray);
                newExam.setQuestions(qArray);
            }
        }else{
            label_errorMessage.setTextFill(Color.RED);
            label_errorMessage.setText("Please fill the blanks");
        }
    }

    @FXML
    public void initialize(){
        label_qNumber.setText("1");
        label_examID.setText(Integer.toString(examList.size()));
    }

    public void keyPressedC(KeyEvent ke){
        String value = tf_correctChoice.getText();
        try{
            Integer.parseInt(ke.getText());
            tf_correctChoice.setEditable(true);
        }catch(Exception e){
            tf_correctChoice.setEditable(false);
        }
        if(!ke.getText().isEmpty()){
            try {
                Integer.parseInt(ke.getText());
            } catch (Exception e) {
                if (!value.isEmpty()) {
                    tf_correctChoice.setEditable(false);
                }
            }
        }else{
            tf_correctChoice.setEditable(true);
        }

    }
    public void keyPressedG(KeyEvent ke){
        String value = tf_Grade.getText();
        try{
            Integer.parseInt(ke.getText());
            tf_Grade.setEditable(true);
        }catch(Exception e){
            tf_Grade.setEditable(false);
        }
        if(!ke.getText().isEmpty()){
            try {
                Integer.parseInt(ke.getText());
            } catch (Exception e) {
                if (!value.isEmpty()) {
                    tf_Grade.setEditable(false);
                }
            }
        }else{
            tf_Grade.setEditable(true);
        }

    }

    public void goBack() throws IOException {
        m.changeScene("Instructor_Loggedin_Title.fxml");
    }


}
