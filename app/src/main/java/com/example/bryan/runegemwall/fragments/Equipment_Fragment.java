package com.example.bryan.runegemwall.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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

    Integer numCopperPieces, numSilverPieces, numElectrumPieces, numGoldPieces, numPlatinumPieces;
    EditText numCopperPiecesET, numSilverPiecesET, numElectrumPiecesET, numGoldPiecesET, numPlatinumPiecesET;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_equipment_, container, false);

        numCopperPiecesET = view.findViewById(R.id.numCopperPieces);
        numSilverPiecesET = view.findViewById(R.id.numSilverPieces);
        numElectrumPiecesET = view.findViewById(R.id.numElectrumPieces);
        numGoldPiecesET = view.findViewById(R.id.numGoldPieces);
        numPlatinumPiecesET = view.findViewById(R.id.numPlatinumPieces);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("RuneGemwallSaveData", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        //Loading the currency
        numCopperPieces = sharedPreferences.getInt("NumCopperPieces", 0);
        numSilverPieces = sharedPreferences.getInt("NumSilverPieces", 0);
        numElectrumPieces = sharedPreferences.getInt("NumElectrumPieces", 0);
        numGoldPieces = sharedPreferences.getInt("NumGoldPieces", 0);
        numPlatinumPieces = sharedPreferences.getInt("NumPlatinumPieces", 0);

        numCopperPiecesET.setText(String.valueOf(numCopperPieces));
        numSilverPiecesET.setText(String.valueOf(numSilverPieces));
        numElectrumPiecesET.setText(String.valueOf(numElectrumPieces));
        numGoldPiecesET.setText(String.valueOf(numGoldPieces));
        numPlatinumPiecesET.setText(String.valueOf(numPlatinumPieces));

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

        numCopperPiecesET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {
                    numCopperPieces = Integer.parseInt(numCopperPiecesET.getText().toString());
                } catch (NumberFormatException nfe) {
                }
                editor.putInt("NumCopperPieces", numCopperPieces);
                editor.apply();
            }
        });

        numSilverPiecesET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {
                    numSilverPieces = Integer.parseInt(numSilverPiecesET.getText().toString());
                } catch (NumberFormatException nfe) {
                }
                editor.putInt("NumSilverPieces", numSilverPieces);
                editor.apply();
            }
        });

        numElectrumPiecesET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {
                    numElectrumPieces = Integer.parseInt(numElectrumPiecesET.getText().toString());
                } catch (NumberFormatException nfe) {
                }
                editor.putInt("NumElectrumPieces", numElectrumPieces);
                editor.apply();
            }
        });

        numGoldPiecesET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {
                    numGoldPieces = Integer.parseInt(numGoldPiecesET.getText().toString());
                } catch (NumberFormatException nfe) {
                }
                editor.putInt("NumGoldPieces", numGoldPieces);
                editor.apply();
            }
        });

        numPlatinumPiecesET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {
                    numPlatinumPieces = Integer.parseInt(numPlatinumPiecesET.getText().toString());
                } catch (NumberFormatException nfe) {
                }
                editor.putInt("NumPlatinumPieces", numPlatinumPieces);
                editor.apply();
            }
        });

        return view;
    }
}

