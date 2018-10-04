package com.example.bryan.runegemwall.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.bryan.runegemwall.R;

public class SavingThrows_Fragment extends Fragment {

    public SavingThrows_Fragment() {
        // Required empty public constructor
    }

    Integer strengthMod, dexterityMod, constitutionMod, intelligenceMod, wisdomMod, charismaMod, proficiencyBonus;
    Boolean strengthChecked, dexterityChecked, constitutionChecked, intelligenceChecked, wisdomChecked, charismaChecked;
    Boolean SSBox1, SSBox2, SSBox3, SFBox1, SFBox2, SFBox3;
    TextView strengthSaveTV, dexteritySaveTV, constitutionSaveTV, intelligenceSaveTV, wisdomSaveTV, charismaSaveTV;
    CheckBox strengthSaveCheckBox, dexteritySaveCheckBox, constitutionSaveCheckBox, intelligenceSaveCheckBox, wisdomSaveCheckBox, charismaSaveCheckBox;
    CheckBox saveSuccessBox1, saveSuccessBox2, saveSuccessBox3, saveFailureBox1, saveFailureBox2, saveFailureBox3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_saving_throws_, container, false);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("RuneGemwallSaveData", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        //Loading the save data
        strengthMod = sharedPreferences.getInt("StrengthMod", 0);
        dexterityMod = sharedPreferences.getInt("DexterityMod", 0);
        constitutionMod = sharedPreferences.getInt("ConstitutionMod", 0);
        intelligenceMod = sharedPreferences.getInt("IntelligenceMod", 0);
        wisdomMod = sharedPreferences.getInt("WisdomMod", 0);
        charismaMod = sharedPreferences.getInt("CharismaMod", 0);
        proficiencyBonus = sharedPreferences.getInt("CharacterProficiency", 0);
        
        strengthChecked = sharedPreferences.getBoolean("StrengthSaveChecked", false);
        dexterityChecked = sharedPreferences.getBoolean("DexteritySaveChecked", false);
        constitutionChecked = sharedPreferences.getBoolean("ConstitutionSaveChecked", false);
        intelligenceChecked = sharedPreferences.getBoolean("IntelligenceSaveChecked", false);
        wisdomChecked = sharedPreferences.getBoolean("WisdomSaveChecked", false);
        charismaChecked = sharedPreferences.getBoolean("CharismaSaveChecked", false);

        SSBox1 = sharedPreferences.getBoolean("SSBox1", false);
        SSBox2 = sharedPreferences.getBoolean("SSBox2", false);
        SSBox3 = sharedPreferences.getBoolean("SSBox3", false);
        SFBox1 = sharedPreferences.getBoolean("SFBox1", false);
        SFBox2 = sharedPreferences.getBoolean("SFBox2", false);
        SFBox3 = sharedPreferences.getBoolean("SFBox3", false);

        //Attaching the values to the textViews
        strengthSaveTV = view.findViewById(R.id.strengthSavingThrowValue);
        dexteritySaveTV = view.findViewById(R.id.dexteritySavingThrowValue);
        constitutionSaveTV = view.findViewById(R.id.constitutionSavingThrowValue);
        intelligenceSaveTV = view.findViewById(R.id.intelligenceSavingThrowValue);
        wisdomSaveTV = view.findViewById(R.id.wisdomSavingThrowValue);
        charismaSaveTV = view.findViewById(R.id.charismaSavingThrowValue);

        //Attaching the checkboxes
        strengthSaveCheckBox = view.findViewById(R.id.strengthSavingThrowCheckBox);
        dexteritySaveCheckBox = view.findViewById(R.id.dexteritySavingThrowCheckBox);
        constitutionSaveCheckBox = view.findViewById(R.id.constitutionSavingThrowCheckBox);
        intelligenceSaveCheckBox = view.findViewById(R.id.intelligenceSavingThrowCheckBox);
        wisdomSaveCheckBox = view.findViewById(R.id.wisdomSavingThrowCheckBox);
        charismaSaveCheckBox = view.findViewById(R.id.charismaSavingThrowCheckBox);

        saveSuccessBox1 = view.findViewById(R.id.deathSavesSuccessBox1);
        saveSuccessBox2 = view.findViewById(R.id.deathSavesSuccessBox2);
        saveSuccessBox3 = view.findViewById(R.id.deathSavesSuccessBox3);
        saveFailureBox1 = view.findViewById(R.id.deathSavesFailureBox1);
        saveFailureBox2 = view.findViewById(R.id.deathSavesFailureBox2);
        saveFailureBox3 = view.findViewById(R.id.deathSavesFailureBox3);

        //Load the current state of the checkboxes
        loadSavingThrowValues();

        //Setting listeners so if the user clicks, the value is changed and the state saved
        strengthSaveCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (strengthSaveCheckBox.isChecked()) {
                    strengthSaveTV.setText(String.valueOf(strengthMod + proficiencyBonus));
                    editor.putBoolean("StrengthSaveChecked", true);
                }
                else {
                    strengthSaveTV.setText(String.valueOf(strengthMod));
                    editor.putBoolean("StrengthSaveChecked", false);
                }
                editor.apply();
            }
        });

        dexteritySaveCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dexteritySaveCheckBox.isChecked()) {
                    dexteritySaveTV.setText(String.valueOf(dexterityMod + proficiencyBonus));
                    editor.putBoolean("DexteritySaveChecked", true);
                }
                else {
                    dexteritySaveTV.setText(String.valueOf(dexterityMod));
                    editor.putBoolean("DexteritySaveChecked", false);
                }
                editor.apply();
            }
        });

        constitutionSaveCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (constitutionSaveCheckBox.isChecked()) {
                    constitutionSaveTV.setText(String.valueOf(constitutionMod + proficiencyBonus));
                    editor.putBoolean("ConstitutionSaveChecked", true);
                }
                else {
                    constitutionSaveTV.setText(String.valueOf(constitutionMod));
                    editor.putBoolean("ConstitutionSaveChecked", false);
                }
                editor.apply();
            }
        });

        intelligenceSaveCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (intelligenceSaveCheckBox.isChecked()) {
                    intelligenceSaveTV.setText(String.valueOf(intelligenceMod + proficiencyBonus));
                    editor.putBoolean("IntelligenceSaveChecked", true);
                }
                else {
                    intelligenceSaveTV.setText(String.valueOf(intelligenceMod));
                    editor.putBoolean("IntelligenceSaveChecked", false);
                }
                editor.apply();
            }
        });

        wisdomSaveCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (wisdomSaveCheckBox.isChecked()) {
                    wisdomSaveTV.setText(String.valueOf(wisdomMod + proficiencyBonus));
                    editor.putBoolean("WisdomSaveChecked", true);
                }
                else {
                    wisdomSaveTV.setText(String.valueOf(wisdomMod));
                    editor.putBoolean("WisdomSaveChecked", false);
                }
                editor.apply();
            }
        });

        charismaSaveCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (charismaSaveCheckBox.isChecked()) {
                    charismaSaveTV.setText(String.valueOf(charismaMod + proficiencyBonus));
                    editor.putBoolean("CharismaSaveChecked", true);
                }
                else {
                    charismaSaveTV.setText(String.valueOf(charismaMod));
                    editor.putBoolean("CharismaSaveChecked", false);
                }
                editor.apply();
            }
        });

        //DEATH SAVES on click
        saveSuccessBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (saveSuccessBox1.isChecked()) {
                    editor.putBoolean("SSBox1", true);
                }
                else {
                    editor.putBoolean("SSBox1", false);
                }
                editor.apply();
            }
        });

        saveSuccessBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (saveSuccessBox2.isChecked()) {
                    editor.putBoolean("SSBox2", true);
                }
                else {
                    editor.putBoolean("SSBox2", false);
                }
                editor.apply();
            }
        });

        saveSuccessBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (saveSuccessBox3.isChecked()) {
                    editor.putBoolean("SSBox3", true);
                }
                else {
                    editor.putBoolean("SSBox3", false);
                }
                editor.apply();
            }
        });

        saveFailureBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (saveFailureBox1.isChecked()) {
                    editor.putBoolean("SFBox1", true);
                }
                else {
                    editor.putBoolean("SFBox1", false);
                }
                editor.apply();
            }
        });

        saveFailureBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (saveFailureBox2.isChecked()) {
                    editor.putBoolean("SFBox2", true);
                }
                else {
                    editor.putBoolean("SFBox2", false);
                }
                editor.apply();
            }
        });

        saveFailureBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (saveFailureBox3.isChecked()) {
                    editor.putBoolean("SFBox3", true);
                }
                else {
                    editor.putBoolean("SFBox3", false);
                }
                editor.apply();
            }
        });

        return view;
    }




    private void loadSavingThrowValues() {

        if (strengthChecked) {
            strengthSaveTV.setText(String.valueOf(strengthMod + proficiencyBonus));
            strengthSaveCheckBox.setChecked(true);
        } else {
            strengthSaveTV.setText(String.valueOf(strengthMod));
        }

        if (dexterityChecked) {
            dexteritySaveTV.setText(String.valueOf(dexterityMod + proficiencyBonus));
            dexteritySaveCheckBox.setChecked(true);
        } else {
            dexteritySaveTV.setText(String.valueOf(dexterityMod));
        }

        if (constitutionChecked) {
            constitutionSaveTV.setText(String.valueOf(constitutionMod + proficiencyBonus));
            constitutionSaveCheckBox.setChecked(true);
        } else {
            constitutionSaveTV.setText(String.valueOf(constitutionMod));
        }

        if (intelligenceChecked) {
            intelligenceSaveTV.setText(String.valueOf(intelligenceMod + proficiencyBonus));
            intelligenceSaveCheckBox.setChecked(true);
        } else {
            intelligenceSaveTV.setText(String.valueOf(intelligenceMod));
        }

        if (wisdomChecked) {
            wisdomSaveTV.setText(String.valueOf(wisdomMod + proficiencyBonus));
            wisdomSaveCheckBox.setChecked(true);
        } else {
            wisdomSaveTV.setText(String.valueOf(wisdomMod));
        }

        if (charismaChecked) {
            charismaSaveTV.setText(String.valueOf(charismaMod + proficiencyBonus));
            charismaSaveCheckBox.setChecked(true);
        } else {
            charismaSaveTV.setText(String.valueOf(charismaMod));
        }

        if (SSBox1) {
            saveSuccessBox1.setChecked(true);
        }

        if (SSBox2) {
            saveSuccessBox2.setChecked(true);
        }

        if (SSBox3) {
            saveSuccessBox3.setChecked(true);
        }

        if (SFBox1) {
            saveFailureBox1.setChecked(true);
        }

        if (SFBox2) {
            saveFailureBox2.setChecked(true);
        }

        if (SFBox3) {
            saveFailureBox3.setChecked(true);
        }
    }

}
