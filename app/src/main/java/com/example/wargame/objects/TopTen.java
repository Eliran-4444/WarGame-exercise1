package com.example.wargame.objects;

import java.util.ArrayList;

public class TopTen {

    private ArrayList<Player> players;
    private ArrayList<String> strPlayers;

    public TopTen() {
        players = new ArrayList<>(10);
        strPlayers = new ArrayList<>(10);
        initStrArry();
    }

    private void initStrArry() {
        for (int i = 0; i < 10; i++) {
            strPlayers.add("Empty");
        }
    }

    public TopTen(ArrayList<Player> records) {
        this.players = records;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<String> getStrPlayers() {
        return strPlayers;
    }

    public TopTen setPlayers(ArrayList<Player> players) {
        this.players = players;
        return this;
    }

    /**
     * adds player by score
     *
     * @param player
     */
    public void addPlayer(Player player) {
        if (this.players.isEmpty()) {
            this.players.add(player);
            this.strPlayers.add(0, player.toStrint());
        } else {
            for (int i = 0; i < 10; i++) {
                if (i > players.size() - 1) {
                    players.add(player);
                    strPlayers.add(i, player.toStrint());
                    i = 10;
                } else if (player.compare(players.get(i))) {
                    players.add(i, player);
                    strPlayers.add(i, player.toStrint());
                    i = 10;
                }
            }
        }
        removeLasts();
    }

    /**
     * if there are more than 10 players, remove the rest.
     */
    private void removeLasts() {
        if (players.size() > 10) {
            for (int i = 9; i < players.size(); i++) {
                players.remove(i);
            }
        }
        if (strPlayers.size() > 10) {
            for (int i = 9; i < strPlayers.size(); i++) {
                strPlayers.remove(i);
            }
        }
    }
}
