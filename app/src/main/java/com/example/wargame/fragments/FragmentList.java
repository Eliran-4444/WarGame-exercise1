package com.example.wargame.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.wargame.R;
import com.example.wargame.callbacks.CallBack_List;
import com.example.wargame.objects.TopTen;


public class FragmentList extends Fragment {
    private ListView listView;
    private CallBack_List callBackList;
    private TopTen topTen;

    public FragmentList(TopTen topTen) {
        this.topTen = topTen;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        listView = view.findViewById(R.id.fragment_List_list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, topTen.getStrPlayers());
        listView.setAdapter(arrayAdapter);
        return view;
    }
}
