package com.jsf.chapter2;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by spirited on 26.03.2017.
 */

@Named
@SessionScoped
//@ConversationScoped
public class QuizBean implements Serializable {
   // private @Inject Conversation conversation;

    private ArrayList<ProblemBean> problems = new ArrayList<>();
    private int currentIndex;
    private int score;

    public QuizBean() {
        problems.add(
                new ProblemBean(new int[] {3, 1, 4, 1, 5}, 9));
        problems.add(
                new ProblemBean(new int[] {1, 1, 2, 3, 5}, 8));
        problems.add(
                new ProblemBean(new int[] {1, 4, 9, 16, 25}, 36));
        problems.add(
                new ProblemBean(new int[] {2, 3, 5, 7, 11}, 13));
        problems.add(
                new ProblemBean(new int[] {1, 2, 4, 8, 16}, 32));
    }

    public void setProblems(ArrayList<ProblemBean> newValue) {
        problems = newValue;
        currentIndex = 0;
        score = 0;
    }

    public int getScore() { return score; }

    public ProblemBean getCurrent() { return problems.get(currentIndex); }

    public String getAnswer() { return ""; }

    public void setAnswer(String newValue) {
        try {
            //if ( currentIndex == 0 ) conversation.begin();
            int answer = Integer.parseInt(newValue.trim());

            if (getCurrent().getSolution() == answer) score++;
            currentIndex = (currentIndex + 1) % problems.size();
            //if ( currentIndex == 0 ) conversation.end();
        } catch(NumberFormatException ex) {}
    }
}
