package com.sample.myloginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyPingCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the Kinvey client
        Client myKinveyClient = new Client.Builder(this).build();

        //Test connection to the Kinvey BaaS backend
        final String TAG = "MyLoginApp:";
        myKinveyClient.ping(new KinveyPingCallback() {
            @Override
            public void onSuccess(Boolean aBoolean) {
                Log.i(TAG, "Successfully connected to Kinvey");
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.i(TAG, "Connection to Kinvey failed");
            }
        });


        final EditText email = (EditText)findViewById(R.id.editText);
        final EditText password = (EditText)findViewById(R.id.editText2);
        Button loginButton = (Button)findViewById(R.id.button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Navigate to logout view
                Intent myIntent = new Intent(MainActivity.this, LogoutActivity.class);
                myIntent.putExtra("Email", email.getText().toString());
                MainActivity.this.startActivity(myIntent);
            }
        });
    }
}
