package com.sample.myloginapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by asengupt on 20-Mar-18.
 */

public class LogoutActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logout);
        final String TAG = "Logout Activity:";

        //Get text view
        TextView text = (TextView)findViewById(R.id.textView3);
        //Set text view value
        text.setText("Welcome "+getIntent().getStringExtra("Email"));

        //On logout
        Button logoutButton = (Button)findViewById(R.id.button2);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Invoked");
            }
        });

    }
}
