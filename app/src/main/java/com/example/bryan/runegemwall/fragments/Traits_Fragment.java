package com.example.bryan.runegemwall.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bryan.runegemwall.R;
import com.example.bryan.runegemwall.adapters.TraitsRecyclerAdapter;
import com.example.bryan.runegemwall.models.TraitsModel;
import com.example.bryan.runegemwall.retrofit.RetrofitInstance;
import com.example.bryan.runegemwall.retrofit.RetrofitTraitsAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Traits_Fragment extends Fragment {

    public Traits_Fragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    TraitsRecyclerAdapter adapter;

    ArrayList<TraitsModel> traitsModelArrayList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_traits_, container, false);

        //Setting up the array
        traitsModelArrayList = new ArrayList<>();

        //Setting recycler viewer to any size
        recyclerView = view.findViewById(R.id.traitsRecyclerView);
        recyclerView.setHasFixedSize(false);

        adapter = new TraitsRecyclerAdapter(traitsModelArrayList);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        RetrofitTraitsAPI retrofitTraitsAPI = RetrofitInstance.getRetrofitInstance().create(RetrofitTraitsAPI.class);

        Call<List<TraitsModel>> call = retrofitTraitsAPI.getEvents();

        call.enqueue(new Callback<List<TraitsModel>>() {
            @Override
            public void onResponse(Call<List<TraitsModel>> call, Response<List<TraitsModel>> response) {

                List<TraitsModel> eventsList = response.body();

                for (int i = 0; i < eventsList.size(); i++) {

                    TraitsModel traitsModel = new TraitsModel();

                    traitsModel.setName(eventsList.get(i).getName());
                    traitsModel.setDescription(eventsList.get(i).getDescription());

                    traitsModelArrayList.add(traitsModel);

                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<TraitsModel>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }
}
