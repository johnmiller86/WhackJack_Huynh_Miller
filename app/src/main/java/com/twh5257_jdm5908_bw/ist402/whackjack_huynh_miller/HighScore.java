package com.twh5257_jdm5908_bw.ist402.whackjack_huynh_miller;

/**
 * Class to model a high score.
 *
 * @author John D. Miller
 * @version 1.0.1
 * @since 03/11/2016
 */
public class HighScore implements Comparable<HighScore>{

    // Instance Variable
    private  String name;
    private int score;

    // Arguments constructor
    public HighScore(String name, int score){
        this.name = name;
        this.score = score;
    }

    /**
     * Gets the name for the high score.
     * @return the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name for the high score.
     * @param name the name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value of the high score.
     * @return the score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the value of the high score.
     * @param score the score.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * compareTo override for this class.
     * @param highScore the high score to be compared.
     * @return the result.
     */
    @Override
    public int compareTo(HighScore highScore){
        int score = (highScore.getScore());
        return score - this.score;
    }

    /**
     * toString override for this class.
     * @return a String representation of this object.
     */
    @Override
    public String toString(){
        return String.format("%-3s%12s", name, score + " points");
    }
}
