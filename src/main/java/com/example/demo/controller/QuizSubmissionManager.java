package com.example.demo.controller;

import com.example.demo.model.QuizSubmission;

import java.util.ArrayList;
import java.util.HashMap;

public class QuizSubmissionManager {

    HashMap<String, QuizSubmission> allSubmissions;

    public static QuizSubmissionManager instance;
    public static QuizSubmissionManager getInstance(){
        return instance==null? instance = new QuizSubmissionManager():instance;
    }

    private QuizSubmissionManager(){
        allSubmissions = new HashMap<>();
    }

    public boolean addSubmission(QuizSubmission quizSubmission){
        allSubmissions.put(quizSubmission.getName()+"_"+quizSubmission.getQuizId(), quizSubmission);
        return true;
    }

    public Integer calculateScore(String name_quizID, QuestionManager questionManager){
        if(allSubmissions.containsKey(name_quizID)){

            int score = 0;

            QuizSubmission quizSubmission = allSubmissions.get(name_quizID);
            String quizID = quizSubmission.getQuizId();
            ArrayList<String> allQuestionsID = quizSubmission.getQuestionID();
            ArrayList<Integer> selectedOptions = quizSubmission.getOption();

            int index = 0;
            for(String questionID: allQuestionsID){
                if(questionManager.getQuestion(questionID).getRightAnsIndex()==selectedOptions.get(index)){
                    score++;
                }
                index++;
            }
            return score;
        }
        return null;
    }

}
