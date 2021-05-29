package com.example.demo.controller;

import com.example.demo.model.Question;
import com.example.demo.model.Quiz;

import java.util.ArrayList;
import java.util.HashMap;

public class QuestionManager {

    HashMap<String, Question> allQuestions;

    private static QuestionManager instance;
    public static QuestionManager getInstance(){
        return instance==null? instance = new QuestionManager(): instance;
    }

    private QuestionManager(){
        allQuestions = new HashMap<>();
    }

    public HashMap<String, Question> getAllQuestions() {
        return allQuestions;
    }

    public void setAllQuestions(HashMap<String, Question> allQuestions) {
        this.allQuestions = allQuestions;
    }

    public Question getQuestion(String questionName){
        if(allQuestions.containsKey(questionName)){
            return allQuestions.get(questionName);
        }
        return null;
    }

    public boolean addQuestion(QuizManager quizManager,Question question) {
        ArrayList<String> quiz = question.getQuizName();

        for(String currQuiz: quiz){
            if(quiz.contains(currQuiz)){
                allQuestions.put(question.getQuestion(), question);
            }else{
                //we can update question here
                return false;
            }
        }
        return true;
    }
}
