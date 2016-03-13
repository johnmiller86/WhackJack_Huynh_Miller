package com.twh5257_jdm5908_bw.ist402.whackjack_huynh_miller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NameActivity extends AppCompatActivity {

    private EditText initialsET;
    private Button okButton;
    private String initials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        initialsET = (EditText) findViewById(R.id.initialsEditText);
        okButton = (Button) findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initials = initialsET.getText().toString();
                if(initials == null || initials.equals("")){
                    Toast.makeText(NameActivity.this, "You must input your initials!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent();
                    intent.putExtra("initials", initials.toUpperCase());
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}
