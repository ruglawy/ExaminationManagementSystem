
package com.example.ems;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kareem
 */
public class Student extends Person {
    private List<List<Integer>> listOfTakenExams = new ArrayList<>();
    private List<Integer> takenExams = new ArrayList<>();
    
    public Student(String username, String password, String name, String mobileNumber, String emailAddress) {
        super(username, password, name, mobileNumber, emailAddress, "Student");
    }
    public void addTakenExam(int examIndex){
        takenExams.add(examIndex);
    }
    public List<Integer> getTakenExam(){
        return takenExams;
    }

    /*public void getListOfTakenExams() {
        System.out.println("Student took " + listOfTakenExams.size() + " exams");
        for(List<Integer> entry : listOfTakenExams) {
            System.out.println("Exam#" + entry.get(0) + " grade: " + entry.get(1));
        }
    }*/
    public int takeExam(LocalDateTime startDate , LocalDateTime endDate , Object[] answers, Exam exam) {
        Question[] questions = exam.getQuestions();
        int totalGrade = 0;
        int grade = 0;
        for(int i=0; i<questions.length; i++) {
            grade = questions[i].answer(answers[i]);
            totalGrade += grade;
            System.out.println("Question #" + (i+1) + " grade: " + grade);
        };
        
        List<Integer> takenExam = new ArrayList<>();
        takenExam.add(exam.getExamID());
        takenExam.add(totalGrade);
        listOfTakenExams.add(takenExam);
        exam.getStatisticalGraph().addData(totalGrade);
        return totalGrade;
    }
}