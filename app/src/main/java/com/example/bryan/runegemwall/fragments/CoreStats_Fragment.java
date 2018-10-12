package com.example.bryan.runegemwall.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bryan.runegemwall.R;

public class CoreStats_Fragment extends Fragment {

    EditText strengthValueET, dexterityValueET, constitutionValueET, intelligenceValueET, wisdomValueET, charismaValueET;
    EditText levelET, experienceET, maxHPET, tempHPET, maxKiValueET, proficiencyET;
    TextView strengthModTV, dexterityModTV, constitutionModTV, intelligenceModTV, wisdomModTV, charismaModTV;
    TextView initiativeTV, passivePerceptionTV;
    Integer strengthValue, dexterityValue, constitutionValue, intelligenceValue, wisdomValue, charismaValue;
    Integer strengthMod, dexterityMod, constitutionMod, intelligenceMod, wisdomMod, charismaMod;
    Integer levelValue, experienceValue, maxHPValue, tempHPValue, maxKiValue, proficiencyValue, passivePerceptionValue;

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
        strengthValue = sharedPreferences.getInt("StrengthValue", 0);
        dexterityValue = sharedPreferences.getInt("DexterityValue", 0);
        constitutionValue = sharedPreferences.getInt("ConstitutionValue", 0);
        intelligenceValue = sharedPreferences.getInt("IntelligenceValue", 0);
        wisdomValue = sharedPreferences.getInt("WisdomValue", 0);
        charismaValue = sharedPreferences.getInt("CharismaValue", 0);
        levelValue = sharedPreferences.getInt("CharacterLevel", 0);
        experienceValue = sharedPreferences.getInt("CharacterExperience", 0);
        maxHPValue = sharedPreferences.getInt("CharacterMaxHP", 0);
        tempHPValue = sharedPreferences.getInt("CharacterTempHP", 0);
        maxKiValue = sharedPreferences.getInt("CharacterMaxKi", 0);

        proficiencyValue = sharedPreferences.getInt("CharacterProficiency", 0);

        //Attaching the widgets
        strengthModTV = view.findViewById(R.id.strengthModifier);
        dexterityModTV = view.findViewById(R.id.dexterityModifier);
        constitutionModTV = view.findViewById(R.id.constitutionModifier);
        intelligenceModTV = view.findViewById(R.id.intelligenceModifier);
        wisdomModTV = view.findViewById(R.id.wisdomModifier);
        charismaModTV = view.findViewById(R.id.charismaModifier);

        strengthValueET = view.findViewById(R.id.baseStrength);
        dexterityValueET = view.findViewById(R.id.baseDexterity);
        constitutionValueET = view.findViewById(R.id.baseConstitution);
        intelligenceValueET = view.findViewById(R.id.baseIntelligence);
        wisdomValueET = view.findViewById(R.id.baseWisdom);
        charismaValueET = view.findViewById(R.id.baseCharisma);

        levelET = view.findViewById(R.id.currentCharacterLevel);
        experienceET = view.findViewById(R.id.currentCharacterExperience);
        initiativeTV = view.findViewById(R.id.initiativeValue);
        passivePerceptionTV = view.findViewById(R.id.passivePerceptionValue);
        maxHPET = view.findViewById(R.id.maxHPValue);
        tempHPET = view.findViewById(R.id.tempHPValue);
        maxKiValueET = view.findViewById(R.id.maxKiValue);
        proficiencyET = view.findViewById(R.id.proficiencyValue);

        //Fill in the stats
        strengthValueET.setText(String.valueOf(strengthValue));
        dexterityValueET.setText(String.valueOf(dexterityValue));
        constitutionValueET.setText(String.valueOf(constitutionValue));
        intelligenceValueET.setText(String.valueOf(intelligenceValue));
        wisdomValueET.setText(String.valueOf(wisdomValue));
        charismaValueET.setText(String.valueOf(charismaValue));
        levelET.setText(String.valueOf(levelValue));
        experienceET.setText(String.valueOf(experienceValue));
        maxHPET.setText(String.valueOf(maxHPValue));
        tempHPET.setText(String.valueOf(tempHPValue));
        maxKiValueET.setText(String.valueOf(maxKiValue));
        proficiencyET.setText(String.valueOf(proficiencyValue));


        //Calculation and displaying the mod values are handled here:
        calculateModifier("str");
        calculateModifier("dex");
        calculateModifier("con");
        calculateModifier("int");
        calculateModifier("wis");
        calculateModifier("cha");
        displayModifiers();

        strengthValueET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calculateModifier("str");
                updateModifiers("str");
                saveData("str");
            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });

        dexterityValueET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calculateModifier("dex");
                updateModifiers("dex");
                saveData("dex");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        constitutionValueET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calculateModifier("con");
                updateModifiers("con");
                saveData("con");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        intelligenceValueET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calculateModifier("int");
                updateModifiers("int");
                saveData("int");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        wisdomValueET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calculateModifier("wis");
                updateModifiers("wis");
                saveData("wis");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        charismaValueET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calculateModifier("cha");
                updateModifiers("cha");
                saveData("cha");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        maxHPET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                saveData("maxHP");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        tempHPET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                saveData("tempHP");
            }
        });

        maxKiValueET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                saveData("maxKi");
            }
        });

        proficiencyET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                saveData("pro");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        levelET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                saveData("lvl");
            }
        });

        experienceET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                saveData("exp");
            }
        });

        return view;
    }


    public void calculateModifier(String stat) {


        //First we'll take whatever data the user has in the EditText fields...
        //Then calculate the modifier
        switch (stat) {
            case "str":
                try {
                    strengthValue = Integer.parseInt(strengthValueET.getText().toString());
                } catch (NumberFormatException nfe) {
                    }
                strengthMod = (strengthValue - 10) / 2;
                break;
            case "dex":
                try {
                    dexterityValue = Integer.parseInt(dexterityValueET.getText().toString());
                } catch (NumberFormatException nfe) {
                    }
                dexterityMod = (dexterityValue - 10) / 2;
                break;

            case "con":
                try {
                    constitutionValue = Integer.parseInt(constitutionValueET.getText().toString());
                 } catch (NumberFormatException nfe) {
                    }
                constitutionMod = (constitutionValue - 10) / 2;
                break;

            case "int":
                try {
                    intelligenceValue = Integer.parseInt(intelligenceValueET.getText().toString());
                } catch (NumberFormatException nfe) {
                    }
                intelligenceMod = (intelligenceValue - 10) / 2;
                break;

            case "wis":
                try {
                    wisdomValue = Integer.parseInt(wisdomValueET.getText().toString());
                } catch (NumberFormatException nfe) {
                    }
                wisdomMod = (wisdomValue - 10) / 2;
                break;

            case "cha":
                try {
                    charismaValue = Integer.parseInt(charismaValueET.getText().toString());
                } catch (NumberFormatException nfe) {
                    }
                charismaMod = (charismaValue - 10) / 2;
                break;
        }
    }

    private void displayModifiers() {

        //On initial load, display the text
        //Now we'll display the modifier, along with whether it's positive or negative

        if (strengthMod > 0) {
            strengthModTV.setText("+" + String.valueOf(strengthMod));
        } else {
            strengthModTV.setText(String.valueOf(strengthMod));
        }

        if (dexterityMod > 0) {
            dexterityModTV.setText("+" + String.valueOf(dexterityMod));
        } else {
            dexterityModTV.setText(String.valueOf(dexterityMod));
        }

        if (constitutionMod > 0) {
            constitutionModTV.setText("+" + String.valueOf(constitutionMod));
        } else {
            constitutionModTV.setText(String.valueOf(constitutionMod));
        }

        if (intelligenceMod > 0) {
            intelligenceModTV.setText("+" + String.valueOf(intelligenceMod));
        } else {
            intelligenceModTV.setText(String.valueOf(intelligenceMod));
        }

        if (wisdomMod > 0) {
            wisdomModTV.setText("+" + String.valueOf(wisdomMod));
        } else {
            wisdomModTV.setText(String.valueOf(wisdomMod));
        }

        if (charismaMod > 0) {
            charismaModTV.setText("+" + String.valueOf(charismaMod));
        } else {
            charismaModTV.setText(String.valueOf(charismaMod));
        }

        //Setting and displayed MaxHP, Initiative, and Passive Perception;

        //Display MaxHP
        maxHPET.setText(String.valueOf(maxHPValue));
        proficiencyET.setText(String.valueOf(proficiencyValue));

        //Initiative values, which is dex mod
        if (dexterityMod > 0) {
            initiativeTV.setText("+" + String.valueOf(dexterityMod));
        } else {
            initiativeTV.setText(String.valueOf(dexterityMod));
        }

        //Passive Perception, which is 10 + wisdom mod (no need for if statement, can't be negative)
        passivePerceptionValue = wisdomMod + 10;
        passivePerceptionTV.setText(String.valueOf(passivePerceptionValue));

    }

    private void updateModifiers(String stat) {
        switch (stat) {
            case "str":
                if (strengthMod > 0) {
                    strengthModTV.setText("+" + String.valueOf(strengthMod));
                } else {
                    strengthModTV.setText(String.valueOf(strengthMod));
                }
                break;
            case "dex":
                if (dexterityMod > 0) {
                    dexterityModTV.setText("+" + String.valueOf(dexterityMod));
                    initiativeTV.setText("+" + String.valueOf(dexterityMod));
                } else {
                    dexterityModTV.setText(String.valueOf(dexterityMod));
                    initiativeTV.setText(String.valueOf(dexterityMod));
                }
                break;
            case "con":
                if (constitutionMod > 0) {
                    constitutionModTV.setText("+" + String.valueOf(constitutionMod));
                } else {
                    constitutionModTV.setText(String.valueOf(constitutionMod));
                }
                break;
            case "int":
                if (intelligenceMod > 0) {
                    intelligenceModTV.setText("+" + String.valueOf(intelligenceMod));
                } else {
                    intelligenceModTV.setText(String.valueOf(intelligenceMod));
                }
                break;
            case "wis":
                if (wisdomMod > 0) {
                    wisdomModTV.setText("+" + String.valueOf(wisdomMod));
                } else {
                    wisdomModTV.setText(String.valueOf(wisdomMod));
                }
                passivePerceptionValue = wisdomMod + 10;
                passivePerceptionTV.setText(String.valueOf(passivePerceptionValue));
                break;
            case "cha":
                if (charismaMod > 0) {
                    charismaModTV.setText("+" + String.valueOf(charismaMod));
                } else {
                    charismaModTV.setText(String.valueOf(charismaMod));
                }
                break;
        }
    }


    private void saveData(String stat) {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("RuneGemwallSaveData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit(); //access the file

        switch (stat) {
            case "str":
                editor.putInt("StrengthValue", strengthValue);
                editor.putInt("StrengthMod", strengthMod);
                break;
            case "dex":
                editor.putInt("DexterityValue", dexterityValue);
                editor.putInt("DexterityMod", dexterityMod);
                break;
            case "con":
                editor.putInt("ConstitutionValue", constitutionValue);
                editor.putInt("ConstitutionMod", constitutionMod);
                break;
            case "int":
                editor.putInt("IntelligenceValue", intelligenceValue);
                editor.putInt("IntelligenceMod", intelligenceMod);
                break;
            case "wis":
                editor.putInt("WisdomValue", wisdomValue);
                editor.putInt("WisdomMod", wisdomMod);
                break;
            case "cha":
                editor.putInt("CharismaValue", charismaValue);
                editor.putInt("CharismaMod", charismaMod);
                break;
            case "maxHP":
                try {
                    maxHPValue = Integer.parseInt(maxHPET.getText().toString());
                } catch (NumberFormatException nfe) {
                }
                editor.putInt("CharacterMaxHP", maxHPValue);
                break;
            case "tempHP":
                try {
                    tempHPValue = Integer.parseInt(tempHPET.getText().toString());
                } catch (NumberFormatException nfe) {
                }
                editor.putInt("CharacterTempHP", tempHPValue);
                break;
            case "maxKi":
                try {
                    maxKiValue = Integer.parseInt(maxKiValueET.getText().toString());
                } catch (NumberFormatException nfe) {
                }
                editor.putInt("CharacterMaxKi", maxKiValue);
                break;
            case "pro":
                try {
                    proficiencyValue = Integer.parseInt(proficiencyET.getText().toString());
                } catch (NumberFormatException nfe) {
                }
                editor.putInt("CharacterProficiency", proficiencyValue);
                break;
            case "lvl":
                try {
                    levelValue = Integer.parseInt(levelET.getText().toString());
                } catch (NumberFormatException nfe) {
                }
                editor.putInt("CharacterLevel", levelValue);
                break;
            case "exp":
                try {
                    experienceValue = Integer.parseInt(experienceET.getText().toString());
                } catch (NumberFormatException nfe) {
                }
                editor.putInt("CharacterExperience", experienceValue);
                break;
        }
        editor.apply();
    }

}
