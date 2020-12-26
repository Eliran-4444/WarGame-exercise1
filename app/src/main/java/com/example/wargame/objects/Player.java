package com.example.wargame.objects;

import java.io.Serializable;
import java.util.Stack;

public class Player implements Serializable {

    private int score;
    private int imgPlayer;
    private String name;
    private Stack<Card> deck = new Stack<Card>();

    public Player(int imgPlayer) {
        this.imgPlayer = imgPlayer;
        this.name = "";
    }

    public Player() {
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if (score > 0 && this.score < score)
            this.score = score;
    }

    public boolean setName(String name) {
        if (name.equals(""))
            return false;
        else {
            this.name = name;
            return true;
        }
    }

    public String getName() {
        return name;
    }

    /**
     * increase by one the player score
     */
    public void addToScore() {
        setScore(this.score + 1);
    }

    /**
     * returns the player image by int
     *
     * @return
     */
    public int getImgPlayer() {
        return imgPlayer;
    }

    /**
     * push card to player deck
     *
     * @param card
     */
    void push(Card card) {
        this.deck.push(card);
    }

    /**
     * checks if deck is empty
     *
     * @return
     */
    boolean isDeckEmpty() {
        return this.deck.isEmpty();
    }

    /**
     * pop card from player deck
     *
     * @return
     */
    Card pop() {
        return deck.pop();
    }

    /**
     * returns true if playr's score is bigger than other player.
     * if equals returns false.
     *
     * @param otherPlayer
     * @return
     */
    public boolean compare(Player otherPlayer) {
        if (this.score > otherPlayer.getScore()) {
            return true;
        }
        return false;
    }

    String toStrint() {
        return "Name: " + this.name + ", Score: " + this.score;
    }
}
