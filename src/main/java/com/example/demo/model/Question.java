package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.HashMap;

@Entity
public class Question {

    @Id
    String question;
    String []options;
    ArrayList<String> quizName;
    int rightAnsIndex;

    public Question(String question, String[] options, ArrayList<String> quizName, int rightAnsIndex) {
        this.question = question;
        this.options = options;
        this.quizName = quizName;
        this.rightAnsIndex = rightAnsIndex;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getQuizName() {
        return quizName;
    }

    public void setQuizName(ArrayList<String> quizName) {
        this.quizName = quizName;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int getRightAnsIndex() {
        return rightAnsIndex;
    }

    public void setRightAnsIndex(int rightAnsIndex) {
        this.rightAnsIndex = rightAnsIndex;
    }

}
