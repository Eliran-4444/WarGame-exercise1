package com.example.wargame.objects;

import java.io.Serializable;

public class Card implements Serializable {

    private int cardValue;
    private CardType cardType;

    public enum CardType {
        CLUBS("clubs"),
        DIAMONDS("diamonds"),
        HEARTS("hearts"),
        SPADES("spades");

        private String cardTypeStr;

        CardType(String cardTypeStr) {
            this.cardTypeStr = cardTypeStr;
        }

        private String getCardTypeStr() {
            return cardTypeStr;
        }
    }

    public Card() {
    }

    public Card(int cardValue, CardType cardType) {
        this.cardValue = cardValue;
        this.cardType = cardType;
    }

    /**
     * returns the card image resource
     *
     * @return
     */
    public String getCardImageResource() {
        return "@drawable/img_card_" + this.cardType.getCardTypeStr() + "_" + cardValue;
    }

    /**
     * return the int value of a card
     *
     * @return
     */
    public int getCardValue() {
        return cardValue;
    }

    /**
     * returns true if the value is bigger than the other card, false if not.
     *
     * @param otherCard
     * @return
     */
    public boolean isBigger(Card otherCard) {
        if (this.cardValue > otherCard.getCardValue())
            return true;
        return false;
    }

}
