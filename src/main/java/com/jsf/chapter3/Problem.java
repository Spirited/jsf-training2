package com.jsf.chapter3;

import java.io.Serializable;

/**
 * Created by spirited on 26.03.2017.
 */
public class Problem implements Serializable {
    private String question;
    private String answer;

    public Problem(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() { return question; }
    public String getAnswer() { return answer; }

    public boolean isCorrect(String response) {
        return response.trim().equalsIgnoreCase(answer);
    }
}
