package com.shubham.QuizApp1.Model;

import lombok.RequiredArgsConstructor;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;


public class Response {
    private Integer id;
    private String response;

    // Constructor
    public Response(Integer id, String response) {
        this.id = id;
        this.response = response;
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
