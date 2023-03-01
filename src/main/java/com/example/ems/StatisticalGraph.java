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
public class StatisticalGraph {
    private final int[][] frequencies;
    private int numberOfStudents = 0;
    
    public StatisticalGraph(Exam exam) {
        frequencies = new int[exam.getMark()+1][2];
        for(int i=0; i < frequencies.length; i++) {
            frequencies[i][0] = i;
        }
        for (int[] entry : frequencies) {
            numberOfStudents += entry[1];
        }
    }
    public void incrementNumberOfStudents(){
        numberOfStudents++;
    }
    public void addData(int mark) {
        boolean hasAddedFreq = false;
        for(int[] entry : frequencies) {
            if(entry[0] == mark) {
                entry[1] += 1;
                hasAddedFreq = true;
            }
        }
        if(!hasAddedFreq) {
            frequencies[mark] = new int[]{mark, 1};
        }
    }
    public int getNumberOfStudents() {
        return numberOfStudents;
    }
    public void getHistogram() {
        if(frequencies.length == 0) {
            System.out.println("No entries");
            return;
        }
        for (int[] entry : frequencies) {
            if(entry[1] == 0) continue;
            System.out.print(entry[0] + ": ");
            for (int j = 0; j < entry[1]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public String getHistogramString() {
        String outputStr = "";
        //if(frequencies.length == 0) {
           // outputStr.concat("No Entries");
            //return outputStr;
        //}
        for (int[] entry : frequencies) {
            if(entry[1] == 0) continue;
            outputStr = outputStr.concat(entry[0] + ": ");
            for (int j = 0; j < entry[1]; j++) {
                outputStr = outputStr.concat("*");
            }
            outputStr = outputStr.concat("\n");
        }
        if(outputStr.isEmpty()){
            return "No entries for this exam yet, thus no histogram was made";
        }
        return outputStr;
    }
    public int[][] getFrequencies() {
        return frequencies;
    }
}


/*
*   Data:
*       {
*           {0, 1},
*           {1, 10},
*           {2, 5}
*       };
*
*
*
*
* */