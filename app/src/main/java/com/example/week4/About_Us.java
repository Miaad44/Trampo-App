package com.example.week4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;

public class About_Us extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        //Define a TextView that will be used to display the text.
        TextView textView = (TextView) findViewById(R.id.textView2);

      //This code binds the text file containing center information to the TextView
        InputStream in = null;

        try {
            in = getAssets().open("Test.txt");

            int size = in.available();
            byte[] addtxt = new byte[size];
            in.read(addtxt);
            in.close();

            String txt = new String(addtxt);
            textView.setText(txt);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Toast.makeText(this,"The selected element is: "+item.getTitle(),Toast.LENGTH_LONG).show();
        switch (item.getItemId())
        {
            case R.id.AboutUs_item:
                Intent intent_1M = new Intent(About_Us.this, About_Us.class);
                startActivity(intent_1M);
                finish();
                return true;


            case R.id.Activity_item:
                Intent intent_2M = new Intent(About_Us.this, Activity1.class);
                startActivity(intent_2M);
                finish();
                return true;

            case R.id.BookActivity_item:
                Intent intent_3M = new Intent(About_Us.this, Book_Activity.class);
                startActivity(intent_3M);
                finish();
                return true;

            case R.id.CancelBookActivity_item:
                Intent intent_4M = new Intent(About_Us.this, CancelActivity.class);
                startActivity(intent_4M);
                finish();
                return true;

            case R.id.Pricing_item:
                Intent intent_5M = new Intent(About_Us.this, Pricing.class);
                startActivity(intent_5M);
                finish();
                return true;

            case R.id.ContactUs_item:
                Intent intent_6M = new Intent(About_Us.this, ConactUs.class);
                startActivity(intent_6M);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}