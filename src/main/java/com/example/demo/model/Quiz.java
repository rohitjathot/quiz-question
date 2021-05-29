package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.HashSet;

@Entity
public class Quiz {

    @Id
    String ID;
    HashSet<String> allQuestions;
    int pageNumber;

    public Quiz(){
        allQuestions = new HashSet<>();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public HashSet<String> getAllQuestions() {
        return allQuestions;
    }

    public void setAllQuestions(HashSet<String> allQuestions) {
        this.allQuestions = allQuestions;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
