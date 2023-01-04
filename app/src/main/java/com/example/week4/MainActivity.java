package com.example.week4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Handler han_83;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        han_83=new Handler();
        han_83.postDelayed(new Runnable() {
            @Override
            //Once the program is run, this page will appear for a few seconds, and then you will go directly to the menu page
            public void run() {
                Intent int_t83=new Intent(MainActivity.this,MenuActivity.class);
                startActivity(int_t83);
                finish();
            }
        },3000);
    }

}