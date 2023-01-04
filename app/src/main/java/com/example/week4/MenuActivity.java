package com.example.week4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        //There are several items in the menu. Once you select an item from the options, the code written inside it will be run
        Toast.makeText(this,"Selected Item: "+item.getTitle(),Toast.LENGTH_LONG).show();
        switch (item.getItemId())
        {
            //If this option is selected, you will be taken directly to the MenuActivity page
            case R.id.Home_item:
                Intent intent_MM = new Intent(MenuActivity.this, MenuActivity.class);
                startActivity(intent_MM);
                finish();
                return true;

            //If this option is selected, you will be taken directly to the About Us page
            case R.id.AboutUs_item:
                Intent intent_1M = new Intent(MenuActivity.this, About_Us.class);
                startActivity(intent_1M);
                finish();
                return true;

             //If this option is selected, you will be taken directly to the Activity page
            case R.id.Activity_item:
                Intent intent_2M = new Intent(MenuActivity.this, Activity1.class);
                startActivity(intent_2M);
                finish();
                return true;
            //If this option is selected, you will be taken directly to the Book Activity page
            case R.id.BookActivity_item:
                Intent intent_3M = new Intent(MenuActivity.this, Book_Activity.class);
                startActivity(intent_3M);
                finish();
                return true;
               //If this option is selected, you will be taken directly to the Cancel Activity page
            case R.id.CancelBookActivity_item:
                Intent intent_4M = new Intent(MenuActivity.this, CancelActivity.class);
                startActivity(intent_4M);
                finish();
                return true;
            //If this option is selected, you will be taken directly to the pricing page
            case R.id.Pricing_item:
                Intent intent_5M = new Intent(MenuActivity.this, Pricing.class);
                startActivity(intent_5M);
                finish();
                return true;
            //If this option is selected, you will be taken directly to the contact us page
            case R.id.ContactUs_item:
                Intent intent_6M = new Intent(MenuActivity.this, ConactUs.class);
                startActivity(intent_6M);
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