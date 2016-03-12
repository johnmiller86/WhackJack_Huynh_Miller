package com.twh5257_jdm5908_bw.ist402.whackjack_huynh_miller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

//import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public final static String EXTRA_MESSAGE = "com.example.tisa.whack";
    private String difficultySelected;
    private Button statBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                intent.putExtra("EXTRA_MESSAGE", difficultySelected);
                startActivity(intent);
            }
        });

        statBtn = (Button) findViewById(R.id.scoreStatButton);
        statBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                SharedPreferences sharedPref = getSharedPreferences("RecordScores",
//                        Context.MODE_PRIVATE);
//                String stat = sharedPref.getString("JackKills", null);
//                Toast.makeText(MainActivity.this, stat,
//                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, HighScoresActivity.class);
                startActivity(intent);
            }
        });


        //region Spinner stuff
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        List<String> categories = new ArrayList<>();
        categories.add("Easy");
        categories.add("Medium");
        categories.add("Hard");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                Object item = arg0.getItemAtPosition(arg2);
                if (item != null) {
                    difficultySelected = item.toString();
                    Toast.makeText(MainActivity.this, item.toString()
                            + " selected", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
    }
}
