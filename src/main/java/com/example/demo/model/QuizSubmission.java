package com.example.demo.model;

import java.util.ArrayList;

public class QuizSubmission {

    //Question Id
    private String name;
    private String quizId;
    //Question ID
    private ArrayList<String> QuestionID;
    private ArrayList<Integer> option;

    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(ArrayList<String> ID) {
        this.QuestionID = ID;
    }

    public ArrayList<Integer> getOption() {
        return option;
    }

    public void setOption(ArrayList<Integer> option) {
        this.option = option;
    }
}
