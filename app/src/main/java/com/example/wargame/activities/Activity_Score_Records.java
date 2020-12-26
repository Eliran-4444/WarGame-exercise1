package com.example.wargame.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wargame.R;
import com.example.wargame.fragments.FragmentList;
import com.example.wargame.fragments.FragmentMap;
import com.example.wargame.objects.TopTen;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.gson.Gson;

public class Activity_Score_Records extends AppCompatActivity {
    private TopTen topTen;
    private FusedLocationProviderClient fusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity__score__records);
        getTopTenFromSps();
        FragmentList fragmentList = new FragmentList(topTen);
        getSupportFragmentManager().beginTransaction().add(R.id.records_LIST, fragmentList).commit();
        FragmentMap fragmentMap = new FragmentMap();
        getSupportFragmentManager().beginTransaction().add(R.id.records_MAP, fragmentMap).commit();
        //fragmentMap.getLocation();
        //String lat = fragmentMap.getLatitude();
        //String lon = fragmentMap.getLongitude();

    }

    /**
     * returns object Topten from memory.
     */
    void getTopTenFromSps() {
        Gson gson = new Gson();
        SharedPreferences prefs = getSharedPreferences("mySps", MODE_PRIVATE);
        String strTopten = prefs.getString("Topten", "empty");
        if (strTopten.equals("empty")) {
            topTen = new TopTen();
        } else {
            topTen = gson.fromJson(strTopten, TopTen.class);
        }
    }
}