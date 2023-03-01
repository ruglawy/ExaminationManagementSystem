/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ems;

/**
 *
 * @author Kareem
 */
public class Course {
    private final String courseID;
    private String name;
    private String courseCode;
    private String instructor;
    private Exam[] addedExams;

    public Course(String courseID, String name, String courseCode, String instructor) {
        this.courseID = courseID;
        this.name = name;
        this.courseCode = courseCode;
        this.instructor = instructor;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getInstructor() {
        return instructor;
    }
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public Exam[] getAddedExams() {
        return addedExams;
    }
    public void setAddedExams(Exam[] addedExams) {
        this.addedExams = addedExams;
    }
    
    
}
