/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ems;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kareem
 */
public class Exam {
    static private int examID = 0;
    private final int currentExamID;
    private String instructorName;
    private final String courseCode;
    private final int duration;
    private final String startTime, endTime, releaseDate;
    private int mark=0;
    private Question[] Questions;
    private boolean validationStatus;
    private final StatisticalGraph statisticalGraph;
    private EvaluationExamReport evaluationExamReport;
    public Exam(String instructorName, String courseCode, int duration, String startTime, String endTime, String releaseDate, Question[] questions, boolean validationStatus) {
        examID++;
        currentExamID = examID;
        this.instructorName = instructorName;
        this.courseCode = courseCode;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
        this.releaseDate = releaseDate;
        this.Questions = questions;
        this.validationStatus = validationStatus;
        for (Question question : questions) {
            mark += question.getGrade();
        }
        evaluationExamReport = new EvaluationExamReport(this);
        statisticalGraph = new StatisticalGraph(this);
    }
    
    public EvaluationExamReport getEvaluationExamReport() {
        return evaluationExamReport;
    }
    public int getExamID() {
        return currentExamID;
    }
    public String getInstructorName() {
        return instructorName;
    }
    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public int getDuration() {
        return duration;
    }
    public String getStartTime() {
        return startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public int getMark() {
        return mark;
    }

    /*public String getReleaseDate() {
        return releaseDate.getDayOfMonth() + "/" + releaseDate.getMonth() + "/" + releaseDate.getYear();
    }*/
    public String getReleaseDate(){
        return releaseDate;
    }
    public Question[] getQuestions() {
        return Questions;
    }
    public void setQuestions(Question[] listOfQuestions) {
        this.Questions = listOfQuestions;
    }

    public boolean isValidationStatus() {
        return validationStatus;
    }
    public void setValidationStatus(boolean validationStatus) {
        this.validationStatus = validationStatus;
    }
    public StatisticalGraph getStatisticalGraph() {
        return statisticalGraph;
    }
}
