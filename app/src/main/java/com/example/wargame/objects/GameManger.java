package com.example.wargame.objects;

import com.example.wargame.R;

import java.util.ArrayList;

public class GameManger {

    private Card card_playerOne;
    private Card card_playerTwo;
    private ArrayList<Card> mainDeck[] = new ArrayList[4];
    private Player playerOne;
    private Player playerTwo;
    private String shardPrefName;

    public GameManger() {
        shardPrefName = "mySps";
        createPlayers();
        createDeck();
        dealCards();
    }

    /**
     * creates the deck
     */
    private void createDeck() {
        initMainDeck();
        createCardSeries(Card.CardType.CLUBS, 0);
        createCardSeries(Card.CardType.DIAMONDS, 1);
        createCardSeries(Card.CardType.HEARTS, 2);
        createCardSeries(Card.CardType.SPADES, 3);
    }

    /**
     * creates cards, adds them an image and adds them to the main deck
     *
     * @param cardType
     * @param placeInDeck
     */
    private void createCardSeries(Card.CardType cardType, int placeInDeck) {
        for (int i = 1; i <= 13; i++) {
            Card card = new Card(i, cardType);
            mainDeck[placeInDeck].add(card);
        }
    }

    /**
     * starts the mainDeck ArrayList
     */
    private void initMainDeck() {
        for (int i = 0; i < 4; i++) {
            mainDeck[i] = new ArrayList<Card>();
        }
    }

    /**
     * creates players
     * attach to each player their image (int)
     * adds the image of each player to the imageView located in activty_game.xml
     */
    private void createPlayers() {
        playerOne = new Player(R.drawable.img_batman);
        playerTwo = new Player(R.drawable.img_joker);
    }

    public Boolean setPlayerName(boolean isPlayerOne,String name){
        if(isPlayerOne){
             return playerOne.setName(name);
        }else
        {
            return playerTwo.setName(name);
        }
    }


    /**
     * randomly chooses card from the deck and adds them to the players deck.
     */
    private void dealCards() {
        for (int j = 0; j < 2; j++)
            for (int i = 0; i < 26; i++) {
                int cardSeriesNum = (int) (Math.random() * 4);
                if (!mainDeck[cardSeriesNum].isEmpty()) {
                    int cardPlace = (int) (Math.random() * mainDeck[cardSeriesNum].size());
                    if (j == 0)
                        playerOne.push(mainDeck[cardSeriesNum].get(cardPlace));
                    else
                        playerTwo.push(mainDeck[cardSeriesNum].get(cardPlace));
                    mainDeck[cardSeriesNum].remove(cardPlace);
                } else i--;

            }
    }

    /**
     * play process
     */
    public boolean play() {
        if (!playerOne.isDeckEmpty()) {
            card_playerOne = playerOne.pop();
            card_playerTwo = playerTwo.pop();
            return true;
        } else {
            return false;

        }
    }


    /**
     * checks which card value is bigger than increase score of player by one.
     */
    public void showDown() {
        if (card_playerOne.isBigger(card_playerTwo)) {
            playerOne.addToScore();
        }
        if (card_playerTwo.isBigger(card_playerOne)) {
            playerTwo.addToScore();
        }
    }

    /**
     * returns the player with the highest score, if it's a draw - return an empty player
     *
     * @return
     */
    public Player getWinner() {
        if (playerOne.getScore() > playerTwo.getScore())
            return playerOne;
        if (playerOne.getScore() < playerTwo.getScore())
            return playerTwo;
        return new Player();
    }

    public Card getCard_playerOne() {
        return card_playerOne;
    }

    public Card getCard_playerTwo() {
        return card_playerTwo;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public String getShardPrefName() {
        return shardPrefName;
    }
}
