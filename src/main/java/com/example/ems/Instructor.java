/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ems;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kareem
 */
public class Instructor extends Person {
    private int age;
    private Course[] listOfCourses;
    private Exam[] listOfExams;
    List<Person> userList = new ArrayList<>();
    public Instructor(String username, String password, String name, String mobileNumber, String emailAddress, int age, Course[] listOfCourses){
        super(username, password, name, mobileNumber, emailAddress, "instructor");
        this.age = age;
        this.listOfCourses= listOfCourses;
        
    }
    public String[] viewQuestionsRank(){
        return new String[]{"x"};
    }
    
    public void createExam(List<String> questions, List<List<String>> answers, List<Integer> correctAnswer, List<Integer> grades, String courseCode, String instructorName, int duration, String startTime, String endTime) {
        for (int i=0; i<questions.size(); i++) {
            System.out.println(questions.get(i) + " ------ g: " + grades.get(i));
            for(int j=0; j<4; j++) {
                System.out.print("[");
                if(correctAnswer.get(i) == j) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
                System.out.print("]");
                System.out.print(" ");
                System.out.println(answers.get(i).get(j));
            }
            System.out.println();
        }
    }
    public boolean isInstructor() {
        return true;
    }
}
/*
addExam(
    {
        "1+1=...",
        "6+3=..."
    },
    {
        {
            "2",
            "4",
            "10", 
            "20"
        },
        {
            "9",
            "f",
            "g",
            "h"
        }
    },
    {
        1,
        0
    }
)
Parameters
P1: questions array of size n
p2: answer text, 2d array of size n and each element is of size 4
*/