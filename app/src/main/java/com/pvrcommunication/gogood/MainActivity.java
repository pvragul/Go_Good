package com.pvrcommunication.gogood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.btn_login);
        EditText inpuserDetails = findViewById(R.id.et_inputUserdetail);
        EditText inppassword = findViewById(R.id.et_inputPassword);

        ProgressBar progressbarofloginscreen = findViewById(R.id.progressbarOfLagin);

        handler = new Handler();

        button.setOnClickListener(view -> {


            String userDetails = inpuserDetails.getText().toString();
            String password = inppassword.getText().toString();

            if(userDetails.isEmpty()){
                Toast.makeText(getApplicationContext(), "Enter User Details",Toast.LENGTH_SHORT).show();
            }
            else if(password.isEmpty()){
                Toast.makeText(getApplicationContext(), "Enter Password",Toast.LENGTH_SHORT).show();
            }
            else {

                progressbarofloginscreen.setVisibility(View.VISIBLE);

                handler.postDelayed(() -> {

                    //Toast.makeText(getApplicationContext(), "Welcome to Home", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, HomeScreen.class);
                    startActivity(intent);
                    finish();
                }, 5000);
            }
        });

    }
}