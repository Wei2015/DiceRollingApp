package com.example.cissy.dicerollingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private Button btnPlay;
    private TextView tvDisplay;
    private EditText etPlayerName;
    static final int REQUEST_CODE_ONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPlay = (Button)findViewById(R.id.btnPlay);
        tvDisplay = (TextView) findViewById(R.id.tvDisplay);
        etPlayerName = (EditText)findViewById(R.id.etPlayerName);



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_ONE){
            if (resultCode == AppCompatActivity.RESULT_OK){
                String resultStr = data.getStringExtra("result");
                tvDisplay.setText(resultStr + " Thank you for playing the game.");
            }
        }
    }

    public void onPlayClicked (View view) {
        Intent gameIntent = new Intent (this, secondactivity.class);
        String playerName = etPlayerName.getText().toString();
        gameIntent.putExtra("playerName", playerName); //pass data to intent
        startActivityForResult(gameIntent, REQUEST_CODE_ONE);

    }


}
