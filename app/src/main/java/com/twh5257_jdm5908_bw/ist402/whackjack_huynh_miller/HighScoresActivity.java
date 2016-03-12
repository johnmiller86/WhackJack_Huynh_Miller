package com.twh5257_jdm5908_bw.ist402.whackjack_huynh_miller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Activity for viewing high scores.
 *
 * @author John D. Miller
 * @version 1.0.1
 * @since 03/11/2016
 */
public class HighScoresActivity extends AppCompatActivity {

    private ArrayList<String> highScores;
    private ArrayAdapter<String> adapter;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);

        // Configuring ListView and Adapter
        lv = (ListView) findViewById(R.id.listView);
        highScores = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, R.layout.high_score_item, R.id.score_item, highScores);
        lv.setAdapter(adapter);

        // Displaying
        displayHighScores("HighScoresEasy.txt");
    }

    public void displayEasy(View view){
        displayHighScores("HighScoresEasy.txt");
    }

    public void displayMed(View view){
        displayHighScores("HighScoresMedium.txt");

    }

    public void displayHard(View view){
        displayHighScores("HighScoresHard.txt");
    }
    /**
     * Reads the high score file.
     */
    private void displayHighScores(String filename) {
        highScores.clear();
        String line;
        StringBuffer sb = new StringBuffer();
        try {
            // Reading Journal
            BufferedReader reader = new BufferedReader(new InputStreamReader(openFileInput(filename)));

            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            highScores.add(sb.toString());
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        if (highScores.isEmpty()){
            highScores.add("This difficulty not yet attempted");
        }
        adapter.notifyDataSetChanged();
    }
}