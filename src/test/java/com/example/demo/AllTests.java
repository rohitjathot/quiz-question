package com.example.demo;

import com.example.demo.controller.QuestionManager;
import com.example.demo.controller.QuizManager;
import com.example.demo.controller.QuizSubmissionManager;
import com.example.demo.model.Question;
import com.example.demo.model.Quiz;
import com.example.demo.model.QuizSubmission;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AllTests {

    @Test
    public void addQuizTest(){

        QuizManager quizManager = QuizManager.getInstance();
        Quiz quiz = new Quiz();
        quiz.setID("1");

        quizManager.addQuiz(quiz);

        HashMap<String, Quiz> allQuiz = quizManager.getAllQuiz();

        String id = "";
        for(Quiz quiz1: allQuiz.values()){
            id = quiz1.getID();
        }

        Assertions.assertEquals("1",id);
    }

    @Test
    public void addQuestionTest(){

        QuestionManager questionManager = QuestionManager.getInstance();
        QuizManager quizManager = QuizManager.getInstance();
        ArrayList<String> quizId = new ArrayList<>();
        quizId.add("1");

        Question question = new Question("Q1", new String[]{"1", "2", "3", "4"},quizId,1);
        questionManager.addQuestion(quizManager ,question);
        HashMap<String, Question> allQuestions = questionManager.getAllQuestions();

        String questionName = "";
        for(Question question1: allQuestions.values()){
            questionName = question1.getQuestion();
            System.out.println(questionName);
            System.out.println(Arrays.toString(question1.getOptions()));
        }

        Assertions.assertEquals("Q1", questionName);
    }

    @Test
    public void calculateScoreTest(){
        QuizManager quizManager = QuizManager.getInstance();
        Quiz quiz = new Quiz();
        quiz.setID("1");
        quizManager.addQuiz(quiz);

        QuestionManager questionManager = QuestionManager.getInstance();
        ArrayList<String> quizId = new ArrayList<>();
        quizId.add("1");

        Question question = new Question("Q1", new String[]{"1", "2", "3", "4"},quizId,1);
        questionManager.addQuestion(quizManager ,question);

        question = new Question("Q2", new String[]{"1", "2", "3", "4"},quizId,2);
        questionManager.addQuestion(quizManager ,question);

        question = new Question("Q3", new String[]{"1", "2", "3", "4"},quizId,3);
        questionManager.addQuestion(quizManager ,question);

        question = new Question("Q4", new String[]{"1", "2", "3", "4"},quizId,4);
        questionManager.addQuestion(quizManager ,question);

        question = new Question("Q5", new String[]{"1", "2", "3", "4"},quizId,1);
        questionManager.addQuestion(quizManager ,question);

        QuizSubmissionManager quizSubmissionManager = QuizSubmissionManager.getInstance();
        QuizSubmission quizSubmission = new QuizSubmission();
        quizSubmission.setName("Rohit");
        quizSubmission.setQuizId("1");
        quizSubmission.setQuestionID(new ArrayList(Arrays.asList("Q1","Q2","Q3","Q4","Q5")));
        quizSubmission.setOption(new ArrayList(Arrays.asList(1,3,3,4,1)));
        quizSubmissionManager.addSubmission(quizSubmission);

        Integer score = quizSubmissionManager.calculateScore("Rohit_1", questionManager);

        Assertions.assertEquals(4,score);
    }

}
