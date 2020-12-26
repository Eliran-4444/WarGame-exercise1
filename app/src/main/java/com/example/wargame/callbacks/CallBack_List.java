package com.example.wargame.callbacks;

import com.example.wargame.objects.Player;

import java.util.ArrayList;

public interface CallBack_List {
    void updateList(ArrayList<Player> players,ArrayList<String> strPlayers);
    void addMarkerToMap(double lat, double lon);
}
