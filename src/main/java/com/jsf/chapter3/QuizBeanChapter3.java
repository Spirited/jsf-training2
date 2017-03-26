package com.jsf.chapter3;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by spirited on 26.03.2017.
 */
@Named
@SessionScoped
public class QuizBean implements Serializable{
    private int currentProblem;
    private int tries;
    private int score;
    private String response = "";
    private String correctAnswer;

    private ArrayList<Problem> problems = new ArrayList<>(Arrays.asList(
            new Problem(
                    "What trademarked, slogan describes Java development? Write once, ...",
                    "run anywhere"),
            new Problem(
                    "What are the first 4 bytes of every class file (in hexidecimal)?",
                    "CAFEBASE"),
            new Problem(
                    "What does this statment print? System.out.println(1+\"2\");",
                    "12"),
            new Problem(
                    "What Java keyword is used to to define a subclass?",
                    "extends"),
            new Problem(
                    "What was the original name of the java programming language?",
                    "Oak"),
            new Problem(
                    "Which java.util class describe a point in time?",
                    "Date")
    ));

    public String getQuestion() {return problems.get(currentProblem).getQuestion(); }
    public String getAnswer() { return correctAnswer; }
    public int getScore() { return score; }

    public String getResponse() { return response; }
    public void setResponse(String response) { this.response = response; }

    public String answerAction() {
        tries++;

        if ( problems.get(currentProblem).isCorrect(response) ) {
            score++;
            nextProblem();
            if ( currentProblem == problems.size() ) return "done";
            else return "success";
        }
        else if ( tries == 1 ) return "again";
        else {
            nextProblem();
            if ( currentProblem == problems.size() ) return "done";
            else return "failure";
        }

    }

    public String startOverAction() {
        Collections.shuffle(problems);
        currentProblem = 0;
        score = 0;
        tries = 0;
        response = "";

        return "startOver";
    }

    private void nextProblem() {
        correctAnswer = problems.get(currentProblem).getAnswer();
        currentProblem++;
        tries = 0;
        response = "";
    }
}
