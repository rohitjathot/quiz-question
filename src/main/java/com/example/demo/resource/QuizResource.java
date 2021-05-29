package com.example.demo.resource;

import com.example.demo.controller.QuestionManager;
import com.example.demo.controller.QuizManager;
import com.example.demo.controller.QuizSubmissionManager;
import com.example.demo.model.Question;
import com.example.demo.model.Quiz;
import com.example.demo.model.QuizSubmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class QuizResource {

    @Autowired
    QuizManager quizManager;

    @Autowired
    QuestionManager questionManager;

    @Autowired
    QuizSubmissionManager quizSubmissionManager;

    @PostMapping("/addQuiz")
    public ResponseEntity<String> addQuiz(@RequestBody Quiz quiz){
        boolean status  = quizManager.addQuiz(quiz);
        if(status){
            return new ResponseEntity<>("Created", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Quiz already exist", HttpStatus.CREATED);
        }
    }

    @PostMapping("/addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        boolean status  = questionManager.addQuestion(quizManager ,question);
        if(status){
            return new ResponseEntity<>("Created", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Question already exist in quize", HttpStatus.CREATED);
        }
    }

    @GetMapping("/getAllQuiz/{pageNumber}")
    public ResponseEntity<ArrayList<Quiz>> getAllQuiz(@PathVariable int pageNumber){
        return new ResponseEntity<>(quizManager.getAllQuiz(pageNumber), HttpStatus.OK);
    }

    @PostMapping("/submitQuiz")
    public ResponseEntity<Boolean> submitQuiz(@RequestBody QuizSubmission quizSubmission){
        boolean status  = quizSubmissionManager.addSubmission(quizSubmission);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @GetMapping("/getAllQuestions")
    public ResponseEntity<HashMap<String, Question>> getAllQuestion(){
        return new ResponseEntity<>(questionManager.getAllQuestions(), HttpStatus.OK);
    }

}
