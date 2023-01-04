package com.example.week4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Pricing extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pricing);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Toast.makeText(this,"Selected Item: "+item.getTitle(),Toast.LENGTH_LONG).show();
        switch (item.getItemId())
        {
            //If this option is selected, you will be taken directly to the MenuActivity page
            case R.id.Home_item:
                Intent intent_MM = new Intent(Pricing.this, MenuActivity.class);
                startActivity(intent_MM);
                finish();
                return true;

            case R.id.AboutUs_item:
                Intent intent_1 = new Intent(Pricing.this, About_Us.class);
                startActivity(intent_1);
                finish();
                return true;


            case R.id.Activity_item:
                Intent intent_2 = new Intent(Pricing.this, Activity1.class);
                startActivity(intent_2);
                finish();
                return true;

            case R.id.BookActivity_item:
                Intent intent_3 = new Intent(Pricing.this, Book_Activity.class);
                startActivity(intent_3);
                finish();
                return true;

            case R.id.CancelBookActivity_item:
                Intent intent_4 = new Intent(Pricing.this, CancelActivity.class);
                startActivity(intent_4);
                finish();
                return true;

            case R.id.Pricing_item:
                Intent intent_5 = new Intent(Pricing.this, Pricing.class);
                startActivity(intent_5);
                finish();
                return true;

            case R.id.ContactUs_item:
                Intent intent_6 = new Intent(Pricing.this, ConactUs.class);
                startActivity(intent_6);
                finish();
                return true;

            case R.id.Close:
                finish();
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}