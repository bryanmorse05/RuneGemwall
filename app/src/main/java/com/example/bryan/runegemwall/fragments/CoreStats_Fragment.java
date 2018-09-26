package com.example.bryan.runegemwall.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bryan.runegemwall.R;
import com.example.bryan.runegemwall.activities.HomePage_Activity;

public class CoreStats_Fragment extends Fragment {

    EditText strengthValueET, dexterityValueET, constituationValueET, intelligenceValueET, wisdomValueET, charismaValueET;
    EditText maxHPET;
    TextView strengthModTV, dexterityModTV, constituationModTV, intelligenceModTV, wisdomModTV, charismaModTV;
    TextView initiativeValue, passivePerceptionValue;
    Integer strengthValue, dexterityValue, constitutionValue, intelligenceValue, wisdomValue, charismaValue;
    Integer strengthMod, dexterityMod, constitutionMod, intelligenceMod, wisdomMod, charismaMod;
    Integer maxHPValue;

    public CoreStats_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_core_stats_, container, false);

        //Load the preference file
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("RuneGemwallSaveData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit(); //access the file
        strengthValue = sharedPreferences.getInt("StrengthValue", 0);
        dexterityValue = sharedPreferences.getInt("DexterityValue", 0);
        constitutionValue = sharedPreferences.getInt("ConstitutionValue", 0);
        intelligenceValue = sharedPreferences.getInt("IntelligenceValue", 0);
        wisdomValue = sharedPreferences.getInt("WisdomValue", 0);
        charismaValue = sharedPreferences.getInt("CharismaValue", 0);
        maxHPValue = sharedPreferences.getInt("CharacterMaxHP", 0);

        //Attaching the widgets
        strengthModTV = view.findViewById(R.id.strengthModifier);
        dexterityModTV = view.findViewById(R.id.dexterityModifier);
        constituationModTV = view.findViewById(R.id.constitutionModifier);
        intelligenceModTV = view.findViewById(R.id.intelligenceModifier);
        wisdomModTV = view.findViewById(R.id.wisdomModifier);
        charismaModTV = view.findViewById(R.id.charismaModifier);

        strengthValueET = view.findViewById(R.id.baseStrength);
        dexterityValueET = view.findViewById(R.id.baseDexterity);
        constituationValueET = view.findViewById(R.id.baseConstitution);
        intelligenceValueET = view.findViewById(R.id.baseIntelligence);
        wisdomValueET = view.findViewById(R.id.baseWisdom);
        charismaValueET = view.findViewById(R.id.baseCharisma);

        initiativeValue = view.findViewById(R.id.initiativeValue);
        passivePerceptionValue = view.findViewById(R.id.passivePerceptionValue);
        maxHPET = view.findViewById(R.id.maxHPValue);

        //Fill in the stats
        strengthValueET.setText(String.valueOf(strengthValue));
        dexterityValueET.setText(String.valueOf(dexterityValue));
        constituationValueET.setText(String.valueOf(constitutionValue));
        intelligenceValueET.setText(String.valueOf(intelligenceValue));
        wisdomValueET.setText(String.valueOf(wisdomValue));
        charismaValueET.setText(String.valueOf(charismaValue));



        //Calculation and displaying the mod values are handled here:
        CalculateAndDisplayModifiers();


        strengthValueET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                CalculateAndDisplayModifiers();
//                SaveData();
                Log.d("Strength:", "afterTextChanged called");
            }
        });

        dexterityValueET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                CalculateAndDisplayModifiers();
                SaveData();
            }
        });

        constituationValueET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                CalculateAndDisplayModifiers();
                SaveData();
            }
        });

        intelligenceValueET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                CalculateAndDisplayModifiers();
                SaveData();
            }
        });

        wisdomValueET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                CalculateAndDisplayModifiers();
                SaveData();
            }
        });

        charismaValueET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                CalculateAndDisplayModifiers();
                SaveData();
            }
        });

        maxHPET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                CalculateAndDisplayModifiers();
                SaveData();
            }
        });

        return view;
    }




    public void CalculateAndDisplayModifiers() {

        //First we'll take whatever data the user has in the EditText fields...
        //Then calculate the modifier
        try {
            strengthValue = Integer.parseInt(strengthValueET.getText().toString());
        } catch (NumberFormatException nfe) {}
        strengthMod = (strengthValue - 10) / 2;

        try {
            dexterityValue = Integer.parseInt(dexterityValueET.getText().toString());
        } catch (NumberFormatException nfe) {}
        dexterityMod = (dexterityValue - 10) / 2;

        try {
            constitutionValue = Integer.parseInt(constituationValueET.getText().toString());
        } catch (NumberFormatException nfe) {}
        constitutionMod = (constitutionValue - 10) / 2;

        try {
            intelligenceValue = Integer.parseInt(intelligenceValueET.getText().toString());
        } catch (NumberFormatException nfe) {}
        intelligenceMod = (intelligenceValue - 10) / 2;

        try {
            wisdomValue = Integer.parseInt(wisdomValueET.getText().toString());
        } catch (NumberFormatException nfe) {}
        wisdomMod = (wisdomValue - 10) / 2;

        try {
            charismaValue = Integer.parseInt(charismaValueET.getText().toString());
        } catch (NumberFormatException nfe) {}
        charismaMod = (charismaValue - 10) / 2;

        //Now we'll display the modifier, along with whether it's positive or negative
        if (strengthMod < 0) {
            strengthModTV.setText("-" + String.valueOf(strengthMod));
        }
        else {
            strengthModTV.setText("+" + String.valueOf(strengthMod));
        }

        if (dexterityMod < 0) {
            dexterityModTV.setText("-" + String.valueOf(dexterityMod));
        }
        else {
            dexterityModTV.setText("+" + String.valueOf(dexterityMod));
        }

        if (constitutionMod < 0) {
            constituationModTV.setText("-" + String.valueOf(constitutionMod));
        }
        else {
            constituationModTV.setText("+" + String.valueOf(constitutionMod));
        }

        if (intelligenceMod < 0) {
            intelligenceModTV.setText("-" + String.valueOf(intelligenceMod));
        }
        else {
            intelligenceModTV.setText("+" + String.valueOf(intelligenceMod));
        }

        if (wisdomMod < 0) {
            wisdomModTV.setText("-" + String.valueOf(wisdomMod));
        }
        else {
            wisdomModTV.setText("+" + String.valueOf(wisdomMod));
        }

        if (charismaMod < 0) {
            charismaModTV.setText("-" + String.valueOf(charismaMod));
        }
        else {
            charismaModTV.setText("+" + String.valueOf(charismaMod));
        }

        //Setting and displayed MaxHP, Initiative, and Passive Perception;

        //Display MaxHP
        maxHPET.setText(String.valueOf(maxHPValue));

        //Initiative values, which is dex mod
        if (dexterityMod < 0) {
            initiativeValue.setText("-" + String.valueOf(dexterityMod));
        }
        else {
            initiativeValue.setText("+" + String.valueOf(dexterityMod));
        }

        //Passive Perception, which is 10 + wisdom mod (no need for if statement, can't be negative)
        passivePerceptionValue.setText(String.valueOf(wisdomMod) + 10);


    }

    private void SaveData() {
     /*   SharedPreferences sharedPreferences = getContext().getSharedPreferences("RuneGemwallSaveData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit(); //access the file
        editor.putInt("StrengthValue", strengthValue);
        editor.putInt("DexterityValue", dexterityValue);
        editor.putInt("ConstitutionValue", constitutionValue);
        editor.putInt("IntelligenceValue", intelligenceValue);
        editor.putInt("WisdomValue", wisdomValue);
        editor.putInt("CharismaValue", charismaValue);
        editor.putInt("CharacterMaxHP", maxHPValue);
       editor.apply();
    */}

}
