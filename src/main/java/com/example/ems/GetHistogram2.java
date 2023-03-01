package com.example.ems;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import static com.example.ems.GetHistogram.*;
import static com.example.ems.Main.*;

import java.io.IOException;

public class GetHistogram2 {
    public GetHistogram2(){

    }
    Main m = new Main();
    @FXML
    private Button button_back;
    @FXML
    private TextArea label_histogram;
    @FXML
    private Label label_info;

    public void goBack(ActionEvent event) throws IOException {
        m.changeScene("Instructor_Loggedin_Title.fxml");
    }

    @FXML
    public void initialize(){
        label_info.setText("Exam ID: " + currentExamIndex);
        String histogram = examList.get(currentExamIndex).getStatisticalGraph().getHistogramString();
        label_histogram.setEditable(false);
        label_histogram.setText(histogram);
    }
}
