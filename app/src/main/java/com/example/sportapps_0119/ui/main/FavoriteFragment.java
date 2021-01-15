package com.example.sportapps_0119.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportapps_0119.ApiClient;
import com.example.sportapps_0119.ApiService;
import com.example.sportapps_0119.DatabaseHelper;
import com.example.sportapps_0119.LastMatchAdapter;
import com.example.sportapps_0119.Match;
import com.example.sportapps_0119.MatchResponse;
import com.example.sportapps_0119.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavoriteFragment extends Fragment {
    private ArrayList<Match> listMatch;
    private RecyclerView rvMatch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        rvMatch = view.findViewById(R.id.rv_favmatch);
        rvMatch.setHasFixedSize(true);
        rvMatch.setLayoutManager(new LinearLayoutManager(getContext()));

        DatabaseHelper db = new DatabaseHelper(getContext());

        listMatch = db.getAllfavorite();
        if(listMatch.size() !=0){
            LastMatchAdapter adapter = new LastMatchAdapter(listMatch);
            rvMatch.setAdapter(adapter);
        }

        return view;
    }
}