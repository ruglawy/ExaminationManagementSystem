package com.example.ems;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import static com.example.ems.AnswerExam1.*;
import static com.example.ems.Main.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnswerExam2 {
    public AnswerExam2(){

    }
    Main m = new Main();
    @FXML
    private Button button_nextQ;

    @FXML
    private Label label_examID;

    @FXML
    private Label label_courseCode;

    @FXML
    private Label label_question;
    @FXML
    private Label label_answer1;
    @FXML
    private Label label_answer2;
    @FXML
    private Label label_answer3;
    @FXML
    private Label label_answer4;
    @FXML
    private TextField tf_choice;
    @FXML
    private Label tf_invalid;
    @FXML
    private Label label_gradeQ;
    @FXML
    private Button button_exit;
    private int totalGrade = 0;
    private int examFullMark = examList.get(currentExamIndex).getMark();
    private int index = 0;

    private List<Question> questionsToAnswer = new ArrayList<>();

    @FXML
    public void initialize(){
        questionsToAnswer = Arrays.stream(questionList.get(currentExamIndex)).toList();
        label_question.setText((index + 1)+ ") " + questionsToAnswer.get(0).getQuestionText());
        
        String[] choices = questionsToAnswer.get(0).getChoices();
        label_answer1.setText(choices[0]);
        label_answer2.setText(choices[1]);
        label_answer3.setText(choices[2]);
        label_answer4.setText(choices[3]);
        label_gradeQ.setText(Double.toString(questionsToAnswer.get(0).getGrade()));
        button_exit.setDisable(true);
        label_courseCode.setText(examList.get(currentExamIndex).getCourseCode());
        label_examID.setText(Integer.toString(currentExamIndex));
    }

    public void keyPressed(KeyEvent ke){
        String value = tf_choice.getText();
        try{
            Integer.parseInt(ke.getText());
            tf_choice.setEditable(true);
        }catch(Exception e){
            tf_choice.setEditable(false);
        }
        if(!ke.getText().isEmpty()){
            try {
                Integer.parseInt(ke.getText());
            } catch (Exception e) {
                if (!value.isEmpty()) {
                    tf_choice.setEditable(false);
                }
            }
        }else{
            tf_choice.setEditable(true);
        }
    }

    public void goNext(ActionEvent event) throws IOException {
        String[] choices;
        String sel = tf_choice.getText();
        boolean checkIfInValid = false;
        if(!(sel.isEmpty())) {
            int choice = Integer.parseInt(tf_choice.getText().toString());

            if (choice >= 1 && choice <= 4) {
                if (choice == questionsToAnswer.get(index).getCorrectChoice()) {
                    totalGrade += questionsToAnswer.get(index).getGrade();
                }
                questionsToAnswer.get(index).answer(choice);
            } else {
                tf_invalid.setText("Invalid choice, choose between 1 & 4");
                checkIfInValid = true;
            }
            //index++;
            tf_choice.clear();
            if(!checkIfInValid) {
                index++;
                if (index == questionsToAnswer.size()) {
                    tf_choice.setDisable(true);
                    button_nextQ.setDisable(true);
                    tf_invalid.setTextFill(Color.GREEN);
                    tf_invalid.setText("Exam completed, you got " + totalGrade + "/" + examFullMark);
                    button_exit.setDisable(false);
                    new EvaluationExamReport(examList.get(currentExamIndex));
                    examList.get(currentExamIndex).getStatisticalGraph().incrementNumberOfStudents();
                    examList.get(currentExamIndex).getStatisticalGraph().addData(totalGrade);
                    studentList.get(isLoggedInIndex).addTakenExam(currentExamIndex);
                } else {
                    label_question.setText((index + 1) + ") " + questionsToAnswer.get(index).getQuestionText());
                    choices = questionsToAnswer.get(index).getChoices();
                    label_answer1.setText(choices[0]);
                    label_answer2.setText(choices[1]);
                    label_answer3.setText(choices[2]);
                    label_answer4.setText(choices[3]);
                    label_gradeQ.setText(Double.toString(questionsToAnswer.get(index).getGrade()));
                }
            }
        }else{
            tf_invalid.setTextFill(Color.RED);
            tf_invalid.setText("Please choose an answer index");
        }
    }
    public void goExit(ActionEvent event) throws IOException{
        m.changeScene("User_Loggedin_Title.fxml");
    }
}
