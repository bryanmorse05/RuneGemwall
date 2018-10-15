package com.example.bryan.runegemwall.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bryan.runegemwall.R;

import java.util.Random;

public class BrownJohn_Activity extends AppCompatActivity {

    TextView playerOneResult, playerTwoResult, gameResult;
    Button rollButton;
    CheckBox playerOneD20Box, playerOneD12Box, playerOneD8Box, playerTwoD20Box, playerTwoD12Box, playerTwoD8Box;
    Integer playerOneScore, playerTwoScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brown_john_);

        //Back button enabled
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Brown John");

        playerOneResult = findViewById(R.id.playerOneResult);
        playerTwoResult = findViewById(R.id.playerTwoResult);
        gameResult = findViewById(R.id.resultsWinner);

        rollButton = findViewById(R.id.rollButton);

        playerOneD20Box = findViewById(R.id.playerOneD20Box);
        playerOneD12Box = findViewById(R.id.playerOneD12Box);
        playerOneD8Box = findViewById(R.id.playerOneD8Box);
        playerTwoD20Box = findViewById(R.id.playerTwoD20Box);
        playerTwoD12Box = findViewById(R.id.playerTwoD12Box);
        playerTwoD8Box = findViewById(R.id.playerTwoD8Box);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //PLAYER 1
                playerOneScore = diceRoll(playerOneD20Box.isChecked(), playerOneD12Box.isChecked(), playerOneD8Box.isChecked());
                playerOneResult.setText(String.valueOf(playerOneScore));

                //PLAYER 2
                playerTwoScore = diceRoll(playerTwoD20Box.isChecked(), playerTwoD12Box.isChecked(), playerTwoD8Box.isChecked());
                playerTwoResult.setText(String.valueOf(playerTwoScore));

                //WHO WINS???
                determineWinner(playerOneScore, playerTwoScore);
            }
        });
    }

    //Randomize and add the values together of all dice rolled
    private int diceRoll(boolean d20, boolean d12, boolean d8) {
        int score;
        int d20Value, d12Value, d8Value;

        if (d20) {
            d20Value = new Random().nextInt(20) + 1;
        } else {
            d20Value = 0;
        }

        if (d12) {
            d12Value = new Random().nextInt(12) + 1;
        } else {
            d12Value = 0;
        }

        if (d8) {
            d8Value = new Random().nextInt(8) + 1;
        } else {
            d8Value = 0;
        }

        score = d20Value + d12Value + d8Value;

        return score;
    }

    //Logic to determine who is the winner
    private void determineWinner(int p1score, int p2score) {
        if (p1score > p2score && p1score <= 23) {
            gameResult.setText("Player 1 WINS");
        }
        else if (p1score > p2score && p1score > 23 && p2score <= 23) {
            gameResult.setText("Player 2 WINS");
        }
        else if (p2score > p1score && p2score < 24) {
            gameResult.setText("Player 2 WINS");
        }
        else if (p2score > p1score && p2score > 23 && p1score <= 23) {
            gameResult.setText("Player 1 WINS");
        }
        else if (p1score == p2score) {
            gameResult.setText("TIE");
        }
        else if (p1score > 23 && p2score > 23) {
            gameResult.setText("BOTH BUST");
        }
    }
}
