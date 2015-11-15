package com.example.cissy.dicerollingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import java.util.Random;
import android.content.Intent;

public class secondactivity extends AppCompatActivity {


    private Button btnRoll, butQuit;
    private TextView tvWelcome, tvGameRandom, tvResult;
    private Random random;
    private int winCount, loseCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        btnRoll = (Button)findViewById(R.id.btnRoll);
        butQuit = (Button)findViewById(R.id.btnQuit);
        tvWelcome = (TextView)findViewById(R.id.tvWelcome);
        tvGameRandom = (TextView)findViewById(R.id.tvGamerandom);
        tvResult = (TextView)findViewById(R.id.tvResult);
        random = new Random();
        Bundle extra = getIntent().getExtras();
        String name = extra.getString("playerName")+ "! ";
        tvWelcome.setText(name + tvWelcome.getText());


    }


    public void onQuitClicked(View view){
        Intent returnIntent =  getIntent();
        String result = "You have won " + winCount + " times, and lost " + loseCount + " times.";
        returnIntent.putExtra("result", result);
        setResult(AppCompatActivity.RESULT_OK, returnIntent);
        this.finish();
    }

    public void onRollClicked(View view) {
        int gameRand = random.nextInt(10) + 2 ; //range 2 -12;
        tvGameRandom.setText("Game random number: " + gameRand);
        int playerRand = random.nextInt(10) + 2 ; //range 2 -12;
        if( playerRand>gameRand ){
            tvResult.setText("Your number is " + playerRand + ". You win!");
            winCount++;
        }else {
            tvResult.setText("Your number is " + playerRand + ". You lose!");
            loseCount++;
        }
    }



}
