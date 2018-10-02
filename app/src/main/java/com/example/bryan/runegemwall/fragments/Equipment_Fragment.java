package com.example.bryan.runegemwall.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bryan.runegemwall.R;
import com.example.bryan.runegemwall.adapters.EquipmentRecyclerAdapter;
import com.example.bryan.runegemwall.models.EquipmentModel;
import com.example.bryan.runegemwall.retrofit.RetrofitEquipmentAPI;
import com.example.bryan.runegemwall.retrofit.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Equipment_Fragment extends Fragment {

    public Equipment_Fragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    EquipmentRecyclerAdapter adapter;

    ArrayList<EquipmentModel> equipmentModelArrayList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_equipment_, container, false);

        //Setting up the array
        equipmentModelArrayList = new ArrayList<>();

        //Setting recycler viewer to any size
        recyclerView = view.findViewById(R.id.equipmentRecyclerView);
        recyclerView.setHasFixedSize(false);

        adapter = new EquipmentRecyclerAdapter(equipmentModelArrayList);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        RetrofitEquipmentAPI retrofitEquipmentAPI = RetrofitInstance.getRetrofitInstance().create(RetrofitEquipmentAPI.class);

        Call<List<EquipmentModel>> call = retrofitEquipmentAPI.getEvents();

        call.enqueue(new Callback<List<EquipmentModel>>() {
            @Override
            public void onResponse(Call<List<EquipmentModel>> call, Response<List<EquipmentModel>> response) {

                List<EquipmentModel> eventsList = response.body();

                for (int i = 0; i < eventsList.size(); i++) {

                    EquipmentModel equipmentModel = new EquipmentModel();

                    equipmentModel.setName(eventsList.get(i).getName());
                    equipmentModel.setDescription(eventsList.get(i).getDescription());
                    equipmentModel.setStats((eventsList.get(i).getStats()));
                    equipmentModel.setCost(eventsList.get(i).getCost());

                    equipmentModelArrayList.add(equipmentModel);

                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<EquipmentModel>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }
}

