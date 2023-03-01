package com.example.ems;

/**
 *
 * @author Kareem
 */
public class Question {
    private final String questionText;
    private final String[] choices;
    private final int correctChoice;
    private final int grade;
    private int answeredRightIndex = 0;
    private int answeredWrongIndex = 0;
    public String[] getChoices() {
        return choices;
    }
    public int getCorrectChoice(){ return correctChoice;}
    public int answer(Object choice) {
        if(correctChoice == Integer.parseInt(choice.toString())) {
            answeredRightIndex++;
            return grade;
        } else {
            answeredWrongIndex++;
            return 0;
        }
    }
    public double getEvaluationRank() {
        if(answeredRightIndex+answeredWrongIndex == 0) return 0;
        return (double) (answeredRightIndex - answeredWrongIndex) / (answeredRightIndex + answeredWrongIndex);
    }
    public double getGrade() {
        return grade;
    }
    public String getQuestionText() {
        return questionText;
    }
    public Question(String questionText, String[] choices, int correctChoice, int grade) {
        this.questionText = questionText;
        this.choices = choices;
        this.correctChoice = correctChoice;
        this.grade = grade;
    }
    public String prettyPrintQuestionString(String bracketStr, int id) {
        String str = "";
        str = str.concat("Q#" + (id) + ": " + questionText + "  g: " + grade + "\n");
        for (int i = 0; i < 4; i++) {
            str = str.concat("[");
            switch (bracketStr) {
                case " ":
                case "X":
                    if (correctChoice - 1 == i) str = str.concat(bracketStr); else str = str.concat(" ");
                    break;
                
                default:
                    str = str.concat(String.valueOf((char)('a' + i)));
                    break;
            }
            str = str.concat("]");
            str = str.concat(" ");
            str = str.concat(choices[i] + " ");
            str = str.concat("\n");
        }
        return str;
    }
    public void prettyPrintQuestion(String bracketStr, int id) {
        System.out.println(prettyPrintQuestionString(bracketStr, id));
    }
    /*public static void main(String[] args) {
        String[] choices_1 = {"2", "4", "6", "8"};
        String[] choices_2 = {"2", "4", "6", "8"};
        Question myQuestion1 = new Question("1+1=...", choices_1, 1, 1);
        Question myQuestion2 = new Question("2*3=...", choices_2, 3, 1);
        
        myQuestion1.prettyPrintQuestion("X", 1);
        myQuestion2.prettyPrintQuestion("X", 2);
    }*/
}
