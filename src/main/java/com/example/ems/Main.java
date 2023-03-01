package com.example.ems;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main extends Application {
    private static Stage stg;
    protected static List<Student> studentList = new ArrayList<>();
    protected static List<Instructor> instructorList = new ArrayList<>();
    protected static List<Administrator> administratorList = new ArrayList<>();
    protected static List<Question[]> questionList = new ArrayList<>();
    protected static List<Exam> examList = new ArrayList<>();
    protected static Course[] listOfCourses = {new Course("111", "Arch", "123", "Mohamed")};
    protected static boolean isLoggedIn = false;
    protected static int isLoggedInIndex = -1;
    protected static boolean isAdmin = false;
    protected static boolean isInstructor = false;

    @Override
    public void start(Stage stage) throws IOException {
        stg=stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Title.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 760, 430);
        stage.setTitle("Examination Management System");

        //Image image = new Image("exam.png");
        //stage.getIcons().add(image);

        stage.setScene(scene);
        stage.show();


    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        stg.getScene().setRoot(pane);
    }

    public static boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException err) {
            return false;
        }
    }

    public static boolean isLoggedIn(boolean isLoggedInFlag) {
        if(!isLoggedInFlag) {
            //System.out.println("You have to be logged in to execute this command");
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        /*boolean isLoggedIn = false;
        int isLoggedInIndex = -1;
        boolean isAdmin = false;
        boolean isInstructor = false;

        List<Student> studentList = new ArrayList<>();
        List<Instructor> instructorList = new ArrayList<>();
        List<Administrator> administratorList = new ArrayList<>();
        List<Exam> examList = new ArrayList<>();
        Course[] listOfCourses = {new Course("111", "Arch", "123", "atef")};*/

        Student p1 = new Student("kareemramzi", "1", "Kareem Ramzi", "01004225312", "20P3845@eng.asu.edu.eg");
        Student p2 = new Student("ziadamerr", "a", "Ziad Amer", "01007130602", "20P5016@eng.asu.edu.eg");
        Student p3 = new Student("ahmadsameh", "qwerty", "Ahmad Sameh", "01022737486", "20P2914@eng.asu.edu.eg");
        Student p4 = new Student("ahmedashour", "asdfgh", "Ahmed Ashour", "01063939629", "20P4222@eng.asu.edu.eg");
        Student p5 = new Student("omarhisham", "abcd123", "Omar Hisham", "01063000222", "20P6484@eng.asu.edu.eg");
        Instructor i1 = new Instructor("atef", "a", "Mohamed Atef", "00000000000", "atef@eng.asu.edu.eg", 18, listOfCourses);
        Administrator a1 = new Administrator("mahmoudkhalil", "passx", "Mahmoud Khalil", "01001234567", "mahmoudkhalil@eng.asu.edu.eg");

        Question[] questionsArr = new Question[4];
        String[] choices = new String[4];
        choices[0] = "1";
        choices[1] = "2";
        choices[2] = "3";
        choices[3] = "4";

        questionsArr[0]= new Question("4*1", choices, 4, 4);
        questionsArr[1]= new Question("1+2", choices, 3, 2);
        questionsArr[2]= new Question("1*2", choices, 2, 1);
        questionsArr[3]= new Question("1*1", choices, 1, 2);

        Exam initialExam = new Exam("Mohamed","EDP101", 1, "14:00", "16:00", "15/5/2022", questionsArr, true);
        questionList.add(questionsArr);
        examList.add(initialExam);

        studentList.add(p1);
        studentList.add(p2);
        studentList.add(p3);
        studentList.add(p4);
        studentList.add(p5);
        instructorList.add(i1);
        administratorList.add(a1);

        launch();
    }
}