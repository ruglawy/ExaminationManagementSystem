/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ems;

/**
 *
 * @author Kareem
 */
public class EvaluationExamReport {
    Exam exam;
    Question[] topQuestions;
    public EvaluationExamReport(Exam exam) {
        this.exam = exam;
        updateEvaluationExamReport();
    }
    private void updateEvaluationExamReport() {
        Question[] questions = exam.getQuestions();
        topQuestions = new Question[Math.min(questions.length, 5)];
        for (int i = 0; i<questions.length-1; i++) {
            for (int j = 0; j < questions.length; j++) {
                if (questions[i].getEvaluationRank() < questions[i + 1].getEvaluationRank()) {
                    Question temp = questions[i];
                    questions[i] = questions[i + 1];
                    questions[i + 1] = temp;
                }
            }
        }
        System.arraycopy(questions, 0, topQuestions, 0, Math.min(questions.length, 5));
    }
    
    public void getReport() {
        System.out.println("Now printing the hardest questions");
        printTopToughQuestions();
        System.out.println("Now printing all questions");
        printAllQuestions();
        System.out.println("Exam max grade                         : " + exam.getMark());
        System.out.println("Exam code                              : " + exam.getExamID());
        System.out.println("Exam duration                          : " + exam.getDuration());
        System.out.println("Exam instructor's name                 : " + exam.getInstructorName());
        System.out.println("Number of times the exam was solved    : " + exam.getStatisticalGraph().getNumberOfStudents());
        System.out.println("Exam histogram: ");
        exam.getStatisticalGraph().getHistogram();
    }
    public String getReportString() {
        String str = "";
        str = str.concat("Now printing the hardest questions" + "\n");
        str = str.concat(printTopToughQuestionsString());
        str = str.concat("Now printing all questions" + "\n");
        str = str.concat(printAllQuestionsString());
        str = str.concat("Exam Max Grade                         : " + exam.getMark() + "\n");
        str = str.concat("Exam Course Code                       : " + exam.getCourseCode() + "\n");
        str = str.concat("Exam Release Date                      : " + exam.getReleaseDate() + "\n");
        str = str.concat("Exam Duration                          : " + "from " + exam.getStartTime() + " to " + exam.getEndTime() + "\n");
        str = str.concat("Exam Instructor's Name                 : " + exam.getInstructorName() + "\n");
        str = str.concat("Number of times the exam was solved    : " + exam.getStatisticalGraph().getNumberOfStudents() + "\n");
        //str = str.concat("Exam histogram: ");
        //str = str.concat(exam.getStatisticalGraph().getHistogramString());
        return str;
    }
    
    private void printAllQuestions() {
        System.out.println(printAllQuestionsString());
    }
    private String printAllQuestionsString() {
        String str = "";
        Question[] questions = exam.getQuestions();
        for(int i=0; i<questions.length; i++) {
            str = str.concat(questions[i].prettyPrintQuestionString("X", i+1));
        }
        return str;
    }
    private void printTopToughQuestions() {
        System.out.println(printTopToughQuestionsString());
    }
    private String printTopToughQuestionsString() {
        String str = "";
        for(int i=0; i<topQuestions.length; i++) {
            str = str.concat("Rank: " + topQuestions[i].getEvaluationRank() + ", Q#" + (i+1) + ": " + topQuestions[i].getQuestionText());
        }
        str = str.concat("\n");
        return str;
    }
}
