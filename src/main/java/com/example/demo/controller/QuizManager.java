package com.example.demo.controller;

import com.example.demo.model.Question;
import com.example.demo.model.Quiz;

import java.util.ArrayList;
import java.util.HashMap;

public class QuizManager {

    private int pageNumber;
    private int totalNumberOfQuiz;
    private HashMap<String, Quiz> allQuiz;

    private static QuizManager instance;

    public static QuizManager getInstance(){
        return instance==null? instance = new QuizManager(): instance;
    }

    private QuizManager(){
        allQuiz = new HashMap<String, Quiz>();
        pageNumber = 0;
        totalNumberOfQuiz = 0;
    }

    public HashMap<String, Quiz> getAllQuiz() {
        return allQuiz;
    }

    public ArrayList<Quiz> getAllQuiz(int pageNumber) {
        ArrayList<Quiz> quizToReturn = new ArrayList<>();
        for(Quiz quiz: allQuiz.values()){
            if(quiz.getPageNumber()==pageNumber){
                quizToReturn.add(quiz);
            }
        }
        return quizToReturn;
    }

    public void setAllQuiz(HashMap<String, Quiz> allQuiz) {
        this.allQuiz = allQuiz;
    }

    public boolean addQuiz(Quiz quiz){
        if(allQuiz.containsKey(quiz.getID())){
            return false;
        }
        allQuiz.put(quiz.getID(), quiz);
        quiz.setPageNumber(pageNumber);
        if(++totalNumberOfQuiz%10==0){
            pageNumber++;
        }
        return true;
    }
}
