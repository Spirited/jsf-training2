package com.jsf.chapter2;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by spirited on 26.03.2017.
 */
public class ProblemBean implements Serializable {
    private ArrayList<Integer> sequence;
    private int solution;

    public ProblemBean() {}

    public ProblemBean(int[] values, int solution) {
        sequence = new ArrayList<>();
        for ( int i = 0; i < values.length; i++ )
            sequence.add(i);
        this.solution = solution;
    }

    public ArrayList<Integer> getSequence() { return sequence; }
    public void setSequence(ArrayList<Integer> sequence) { this.sequence = sequence; }

    public int getSolution() { return solution; }
    public void setSolution(int solution) { this.solution = solution; }
}
