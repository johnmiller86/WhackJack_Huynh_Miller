package com.twh5257_jdm5908_bw.ist402.whackjack_huynh_miller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 * Activity for viewing high scores.
 *
 * @author Tisa Huynh && John D. Miller
 * @version 1.0.1
 * @since 03/11/2016
 */
public class GameActivity extends AppCompatActivity {

    private TextView countdownText, scoreText;
    private Button hole1, hole2, hole3, hole4, hole5, hole6, hole7, hole8, hole9;
    private ImageButton pauseBtn;
    private GameService gs;
    private String difficultyChosen, initials;
    private OfficialTimer OfficTimer;
    private GameSettingTimer PositionTimer;
    private int WhereJohnnyAt, counter, score;
    private long _secondsLeft;
    private boolean isPause;
    private ArrayList<HighScore> highScores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            difficultyChosen = b.getString("EXTRA_MESSAGE");
        }


        gs = new GameService();
        counter=0;
        isPause=false;
        hole1 = (Button)findViewById(R.id.button1);
        hole2 = (Button)findViewById(R.id.button2);
        hole3 = (Button)findViewById(R.id.button3);
        hole4 = (Button)findViewById(R.id.button4);
        hole5 = (Button)findViewById(R.id.button5);
        hole6 = (Button)findViewById(R.id.button6);
        hole7 = (Button)findViewById(R.id.button7);
        hole8 = (Button)findViewById(R.id.button8);
        hole9 = (Button)findViewById(R.id.button9);
        pauseBtn =(ImageButton) findViewById(R.id.imageButton);
        scoreText=(TextView)findViewById(R.id.scoretext);
        countdownText =(TextView)findViewById(R.id.timertext);


        //official timer displayed
        OfficTimer = new OfficialTimer(30000, 1000);
        OfficTimer.start();


        //sets game based on difficulty user chose/new instances of counterdowntimer thing
        switch (difficultyChosen) {
            case "Easy":
                PositionTimer = new GameSettingTimer(30000, 1000);
                PositionTimer.start();
                break;
            case "Medium":
                PositionTimer = new GameSettingTimer(30000, 750);
                PositionTimer.start();
                break;
            case "Hard":
                PositionTimer = new GameSettingTimer(30000, 500);
                PositionTimer.start();
                break;
        }

        //if pause button was hit, pauses all timers and brings up menu to quit
        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPause = !isPause;
                if (isPause) {
                    OfficTimer.cancel();
                    PositionTimer.cancel();
                    DisableHoles();
                } else {
                    EnableHoles ();
                    OfficTimer = new OfficialTimer(_secondsLeft, 1000);
                    OfficTimer.start();
                    switch (difficultyChosen) {
                        case "Easy":
                            PositionTimer = new GameSettingTimer(_secondsLeft, 1000);
                            PositionTimer.start();
                            break;
                        case "Medium":
                            PositionTimer = new GameSettingTimer(_secondsLeft, 750);
                            PositionTimer.start();
                            break;
                        case "Hard":
                            PositionTimer = new GameSettingTimer(_secondsLeft, 500);
                            PositionTimer.start();
                            break;
                    }
                }
            }
        });

        //checks if player hits the correct hole, point up
       HoleListeners();


    }

    public void DisableHoles () {
        hole1.setEnabled(false);
        hole2.setEnabled(false);
        hole3.setEnabled(false);
        hole4.setEnabled(false);
        hole5.setEnabled(false);
        hole6.setEnabled(false);
        hole7.setEnabled(false);
        hole8.setEnabled(false);
        hole9.setEnabled(false);
    }

    public void EnableHoles () {
        hole1.setEnabled(true);
        hole2.setEnabled(true);
        hole3.setEnabled(true);
        hole4.setEnabled(true);
        hole5.setEnabled(true);
        hole6.setEnabled(true);
        hole7.setEnabled(true);
        hole8.setEnabled(true);
        hole9.setEnabled(true);
    }
    public void HoleListeners (){
        hole1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (WhereJohnnyAt == 1) {
                    counter++;
                } else {
                    if (difficultyChosen.equals("Hard")) {
                        counter--;
                    }
                }
                ResetHoles();
                scoreText.setText(String.valueOf(counter));
            }
        });
        hole2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (WhereJohnnyAt == 2) {
                    counter++;
                } else {
                    if (difficultyChosen.equals("Hard")) {
                        counter--;
                    }
                }
                ResetHoles();
                scoreText.setText(String.valueOf(counter));
            }
        });
        hole3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (WhereJohnnyAt == 3) {
                    counter++;
                } else {
                    if (difficultyChosen.equals("Hard")) {
                        counter--;
                    }
                }
                ResetHoles();
                scoreText.setText(String.valueOf(counter));
            }
        });
        hole4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (WhereJohnnyAt == 4) {
                    counter++;
                } else {
                    if (difficultyChosen.equals("Hard")) {
                        counter--;
                    }
                }
                ResetHoles();
                scoreText.setText(String.valueOf(counter));
            }
        });
        hole5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (WhereJohnnyAt == 5) {
                    counter++;
                } else {
                    if (difficultyChosen.equals("Hard")) {
                        counter--;
                    }
                }
                ResetHoles();
                scoreText.setText(String.valueOf(counter));
            }
        });
        hole6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (WhereJohnnyAt == 6) {
                    counter++;
                } else {
                    if (difficultyChosen.equals("Hard")) {
                        counter--;
                    }
                }
                ResetHoles();
                scoreText.setText(String.valueOf(counter));
            }
        });
        hole7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (WhereJohnnyAt == 7) {
                    counter++;
                } else {
                    if (difficultyChosen.equals("Hard")) {
                        counter--;
                    }
                }
                ResetHoles();
                scoreText.setText(String.valueOf(counter));
            }
        });
        hole8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (WhereJohnnyAt == 8) {
                    counter++;
                } else {
                    if (difficultyChosen.equals("Hard")) {
                        counter--;
                    }
                }
                ResetHoles();
                scoreText.setText(String.valueOf(counter));
            }
        });
        hole9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (WhereJohnnyAt == 9) {
                    counter++;
                } else {
                    if (difficultyChosen.equals("Hard")) {
                        counter--;
                    }
                }

                ResetHoles();
                scoreText.setText(String.valueOf(counter));
            }
        });

    }

    public void ResetHoles(){
        hole1.setBackgroundResource(R.drawable.crack_default);
        hole2.setBackgroundResource(R.drawable.crack_default);
        hole3.setBackgroundResource(R.drawable.crack_default);
        hole4.setBackgroundResource(R.drawable.crack_default);
        hole5.setBackgroundResource(R.drawable.crack_default);
        hole6.setBackgroundResource(R.drawable.crack_default);
        hole7.setBackgroundResource(R.drawable.crack_default);
        hole8.setBackgroundResource(R.drawable.crack_default);
        hole9.setBackgroundResource(R.drawable.crack_default);
    }

    public class OfficialTimer extends CountDownTimer
    {
        public OfficialTimer(long startTime, long interval)
        {
            super(startTime, interval);
        }

        @Override
        public void onFinish()
        {
            countdownText.setText("Game Over");
            score = Integer.parseInt(scoreText.getText().toString());
            checkForHighScore();
        }

        @Override
        public void onTick(long millisUntilFinished)
        {
            _secondsLeft = millisUntilFinished;
            Long time = millisUntilFinished/1000;
            countdownText.setText(time.toString());
        }
    }

    public class GameSettingTimer extends CountDownTimer
    {
        public GameSettingTimer(long startTime, long interval)
        {
            super(startTime, interval);
        }

        @Override
        public void onFinish()
        {
            DisableHoles();
        }

        @Override
        public void onTick(long millisUntilFinished)
        {
            ResetHoles();
            int theJackPosition = gs.RandomJack();
            WhereJohnnyAt = theJackPosition;
            switch (theJackPosition) {
                case 1:
                    hole1.setBackgroundResource(R.drawable.crack_johnny_pos);
                    break;
                case 2:
                    hole2.setBackgroundResource(R.drawable.crack_johnny_pos);
                    break;
                case 3:
                    hole3.setBackgroundResource(R.drawable.crack_johnny_pos);
                    break;
                case 4:
                    hole4.setBackgroundResource(R.drawable.crack_johnny_pos);
                    break;
                case 5:
                    hole5.setBackgroundResource(R.drawable.crack_johnny_pos);
                    break;
                case 6:
                    hole6.setBackgroundResource(R.drawable.crack_johnny_pos);
                    break;
                case 7:
                    hole7.setBackgroundResource(R.drawable.crack_johnny_pos);
                    break;
                case 8:
                    hole8.setBackgroundResource(R.drawable.crack_johnny_pos);
                    break;
                case 9:
                    hole9.setBackgroundResource(R.drawable.crack_johnny_pos);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Checks if high score and gets initials.
     */
    private void checkForHighScore(){

        highScores = new ArrayList<>();
        readHighScores();

        if (highScores.size() < 5){
            Intent intent = new Intent(this, InitialsActivity.class);
            startActivityForResult(intent, 1);
        }
        else{
            for (int i = 0; i < highScores.size(); i++) {
                if (score > highScores.get(i).getScore()) {
                    Intent intent = new Intent(this, InitialsActivity.class);
                    startActivityForResult(intent, 1);
                    break;
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == 1){
            if (resultCode == Activity.RESULT_OK){
                initials = data.getStringExtra("initials");
                updateHighScores();
                finish();
            }
        }
    }

    /**
     * Updates high scores files.
     */
    private void updateHighScores(){

        // Add, sort and print
        if (highScores.size() < 5)
        {
            highScores.add(new HighScore(initials, score));
            try {
                File file = new File(getFilesDir(), "HighScores" + difficultyChosen + ".txt");
                PrintWriter output = new PrintWriter(new FileOutputStream(file, false));
                Collections.sort(highScores);
                for (HighScore hs : highScores) {
                    output.println(hs.toString());
                }
                output.flush();
                output.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        // If limit reached, insert and shift
        else {
            // Comparing
            for (int i = 0; i < highScores.size(); i++) {
                if (score > highScores.get(i).getScore()) {
                    HighScore hs = new HighScore(initials, score);
                    for (int j = highScores.size() - 1; j >  i; j--){
                        highScores.set(j, highScores.get(j - 1));
                    }
                    highScores.set(i, hs);
                    break;
                }
            }
            // Printing
            try {
                File file = new File(getFilesDir(), "HighScores" + difficultyChosen + ".txt");
                PrintWriter output = new PrintWriter(new FileOutputStream(file, false));
                for (HighScore hs : highScores){
                    output.println(hs.toString());
                }
                output.flush();
                output.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Reads a high scores file.
     */
    private void readHighScores() {
        String line;
        Scanner lineReader;
        try
        {
            // Opening File
            BufferedReader reader = new BufferedReader(new InputStreamReader(openFileInput("HighScores" + difficultyChosen + ".txt")));

            // Reading into list
            while ((line = reader.readLine()) != null){
                lineReader = new Scanner(line);
                HighScore hs = new HighScore(lineReader.next(), lineReader.nextInt());
                highScores.add(hs);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
