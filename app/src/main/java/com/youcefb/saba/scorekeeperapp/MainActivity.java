package com.youcefb.saba.scorekeeperapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int teamA_score;
    private int teamB_score;
    private int teamA_fouls;
    private int teamB_fouls;
    private int teamA_yellowCards;
    private int teamB_yellowCards;

    TextView tv_teamA_score;
    TextView tv_teamA_fouls;
    TextView tv_teamA_yellow;
    TextView tv_teamB_score;
    TextView tv_teamB_fouls;
    TextView tv_teamB_yellow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_teamA_score = findViewById(R.id.tv_score_team1);
        tv_teamA_fouls = findViewById(R.id.tv_fouls_team1);
        tv_teamA_yellow = findViewById(R.id.tv_yellow_team1);
        tv_teamB_score = findViewById(R.id.tv_score_team2);
        tv_teamB_fouls = findViewById(R.id.tv_fouls_team2);
        tv_teamB_yellow = findViewById(R.id.tv_yellow_team2);

        resetScoreAndMetrics();
        updateUI();

        Button b_teamA_score = findViewById(R.id.b_add_score_team1);
        Button b_teamA_foul = findViewById(R.id.b_add_foul_teams1);
        Button b_teamA_yellow = findViewById(R.id.b_add_yellow_team1);
        Button b_teamB_score = findViewById(R.id.b_add_score_team2);
        Button b_teamB_foul = findViewById(R.id.b_add_foul_team2);
        Button b_teamB_yellow = findViewById(R.id.b_add_yellow_team2);
        Button b_reset = findViewById(R.id.b_reset);

        /*
        b_teamA_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teamA_score++;
                updateUI();
            }
        });*/

        b_teamA_score.setOnClickListener(this);
        b_teamA_foul.setOnClickListener(this);
        b_teamA_yellow.setOnClickListener(this);
        b_teamB_score.setOnClickListener(this);
        b_teamB_foul.setOnClickListener(this);
        b_teamB_yellow.setOnClickListener(this);
        b_reset.setOnClickListener(this);
    }



    private void resetScoreAndMetrics() {
        teamA_score = 0;
        teamB_score = 0;
        teamA_fouls = 0;
        teamB_fouls = 0;
        teamA_yellowCards = 0;
        teamB_yellowCards = 0;
    }

    private void updateUI() {
        tv_teamA_score.setText(Integer.toString(teamA_score));
        tv_teamA_fouls.setText(Integer.toString(teamA_fouls));
        tv_teamA_yellow.setText(Integer.toString(teamA_yellowCards));
        tv_teamB_score.setText(Integer.toString(teamB_score));
        tv_teamB_fouls.setText(Integer.toString(teamB_fouls));
        tv_teamB_yellow.setText(Integer.toString(teamB_yellowCards));

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id) {
            case R.id.b_add_score_team1:
                teamA_score++;
                break;
            case R.id.b_add_foul_teams1:
                teamA_fouls++;
                break;
            case R.id.b_add_yellow_team1:
                teamA_yellowCards++;
                break;
            case R.id.b_add_score_team2:
                teamB_score++;
                break;
            case R.id.b_add_foul_team2:
                teamB_fouls++;
                break;
            case R.id.b_add_yellow_team2:
                teamB_yellowCards++;
                break;
            case R.id.b_reset:
                resetScoreAndMetrics();
                break;
        }

        updateUI();
    }
}