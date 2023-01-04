package com.example.week4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CancelActivity extends AppCompatActivity {
    DatabaseHelper mDb;
    EditText FName_83,Phone_83, Email_83;
    Button Btn12,Btn33;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel);

        mDb = new DatabaseHelper(this);
        //get the IDs of Edittext
        //get the IDs of Edittext
        FName_83= (EditText) findViewById(R.id.edit11_1);
        Phone_83 = (EditText) findViewById(R.id.edit22_2);
        Email_83 = (EditText) findViewById(R.id.edit33_3);

        Btn12 = (Button) findViewById(R.id.btn5_Back83);
        Btn33 = (Button) findViewById(R.id.btn3_delete83);


        Btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FName_83.setText("");
                Phone_83.setText("");
                Email_83.setText("");

            }
        });

        deleteDetail_83();
    }

    //delete date
    public void deleteDetail_83()
    {
        Btn33.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Integer del=mDb.deleteD_83(Phone_83.getText().toString());
                if(del>0)
                    Toast.makeText(CancelActivity.this,"The booking has been cancelled",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(CancelActivity.this,"Reservation cancellation failed",Toast.LENGTH_LONG).show();
            }
        });
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
                Intent intent_MM = new Intent(CancelActivity.this, MenuActivity.class);
                startActivity(intent_MM);
                finish();
                return true;

            case R.id.AboutUs_item:
                Intent intent_1 = new Intent(CancelActivity.this, About_Us.class);
                startActivity(intent_1);
                finish();
                return true;


            case R.id.Activity_item:
                Intent intent_2 = new Intent(CancelActivity.this, Activity1.class);
                startActivity(intent_2);
                finish();
                return true;

            case R.id.BookActivity_item:
                Intent intent_3 = new Intent(CancelActivity.this, Book_Activity.class);
                startActivity(intent_3);
                finish();
                return true;

            case R.id.CancelBookActivity_item:
                Intent intent_4 = new Intent(CancelActivity.this, CancelActivity.class);
                startActivity(intent_4);
                finish();
                return true;

            case R.id.Pricing_item:
                Intent intent_5 = new Intent(CancelActivity.this, Pricing.class);
                startActivity(intent_5);
                finish();
                return true;

            case R.id.ContactUs_item:
                Intent intent_6 = new Intent(CancelActivity.this, ConactUs.class);
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