package com.example.week4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Book_Activity extends AppCompatActivity {
    DatabaseHelper mDb;
    EditText FName_83,Phone_83, Email_83, AType_83, Hour_83,  price_83;
    Button Btn11, Btn22, Btn44, Btn55, bb6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        //Link the DataBaseHelper class to this page(class) using below code
        mDb = new DatabaseHelper(this);

        // Get the identifiers of the Edittext used in the design of the page.
        FName_83= (EditText) findViewById(R.id.edit11_1);
        Phone_83 = (EditText) findViewById(R.id.edit22_2);
        Email_83 = (EditText) findViewById(R.id.edit33_3);
        AType_83 = (EditText) findViewById(R.id.edit44_4);
        Hour_83 = (EditText) findViewById(R.id.edit_hour);
        price_83= (EditText) findViewById(R.id.edit55_5);

        //get the ids of button  used in this page.
        Btn11 = (Button) findViewById(R.id.btn1_add83);
        Btn44 = (Button) findViewById(R.id.btn4_view83);
        Btn22 = (Button) findViewById(R.id.btn2_updte83);
        Btn55 = (Button) findViewById(R.id.btn5_clear83);
        bb6= (Button) findViewById(R.id.b6);


        // Define all methods used, such as adding, updating, and others
        addDetail_83();
        updateDetail_83();
        viewDetail_83();
        clearDetail_83();
        calDetail_83();
    }


    //add method to add all the inputs that the user enters and saves in the data base
    public void addDetail_83()
    {
        Btn11.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                boolean insert=mDb.insertD_83(FName_83.getText().toString(),Phone_83.getText().toString(), Email_83.getText().toString(),AType_83.getText().toString(), Hour_83.getText().toString(), price_83.getText().toString());
                if(insert==true)
                    Toast.makeText(Book_Activity.this, "Tickets are booked",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Book_Activity.this,"Ticket booking failed",Toast.LENGTH_LONG).show();
            }
        });
    }

    //update method To modify the customer's data by entering the phone number to identify the customer whose data you want to modify
    public void updateDetail_83()
    {
        Btn22.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                boolean update=mDb.updateD_83(FName_83.getText().toString(),Phone_83.getText().toString(), Email_83.getText().toString(),AType_83.getText().toString(), Hour_83.getText().toString(), price_83.getText().toString());
                if(update==true)
                    //Use toast to show the ticket reservation message if the data is entered correctly
                    Toast.makeText(Book_Activity.this,"Customer details updated",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Book_Activity.this, "Customer details are not updated",Toast.LENGTH_LONG).show();
            }
        });
    }


    //view method to show all the data that has been added to the data base
    public void viewDetail_83()
    {
        Btn44.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Cursor Miaad83=mDb.getAllData();
                if(Miaad83.getCount()==0)
                {
                    showMessage("Error", "The data could not be obtained");
                    return;
                }
                StringBuffer View_83=new StringBuffer();
                while(Miaad83.moveToNext())
                {
                    // The names of the columns in the table in the SQLit database
                    View_83.append("First Name:"+Miaad83.getString(0)+"\n");
                    View_83.append("Phone Number:"+Miaad83.getString(1)+"\n");
                    View_83.append("Email:"+Miaad83.getString(2)+"\n");
                    View_83.append("Activity Type:"+Miaad83.getString(3)+"\n");
                    View_83.append("Hour :"+Miaad83.getString(4)+"\n");
                    View_83.append("Price:"+Miaad83.getString(5)+"\n");
                }
                showMessage("Customer Details",View_83.toString());
            }
        });
    }


    //clear method to clear all entries that the user has written to edit text
    public void clearDetail_83()
    {
        Btn55.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FName_83.setText("");
                Phone_83.setText("");
                Email_83.setText("");
                AType_83.setText("");
                Hour_83.setText("");
                price_83.setText("");
            }
        });
    }

    //calculate method A calculation has been made to calculate the final ticket price
    public void calDetail_83()
    {
        bb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(FName_83.getText().toString().isEmpty()||Phone_83.getText().toString().isEmpty()|| Email_83.getText().toString().isEmpty()||AType_83.getText().toString().isEmpty()|| Hour_83.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Please enter the required data",Toast.LENGTH_LONG).show();
                }
                else
                {
                    double Activity_price=6.0;
                    double hour1= Double.parseDouble(Hour_83.getText().toString());
                    double avg_83=(Activity_price * hour1);
                    price_83.setText(Double.toString(avg_83));
                }

            }
        });
    }


    public void showMessage(String title,String mes)
    {
        AlertDialog.Builder A=new AlertDialog.Builder(this);
        A.setCancelable(true);
        A.setTitle(title);
        A.setMessage(mes);
        A.show();
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
                Intent intent_MM = new Intent(Book_Activity.this, MenuActivity.class);
                startActivity(intent_MM);
                finish();
                return true;

            case R.id.AboutUs_item:
                Intent intent_1 = new Intent(Book_Activity.this, About_Us.class);
                startActivity(intent_1);
                finish();
                return true;


            case R.id.Activity_item:
                Intent intent_2 = new Intent(Book_Activity.this, Activity1.class);
                startActivity(intent_2);
                finish();
                return true;

            case R.id.BookActivity_item:
                Intent intent_3 = new Intent(Book_Activity.this, Book_Activity.class);
                startActivity(intent_3);
                finish();
                return true;

            case R.id.CancelBookActivity_item:
                Intent intent_4 = new Intent(Book_Activity.this, CancelActivity.class);
                startActivity(intent_4);
                finish();
                return true;

            case R.id.Pricing_item:
                Intent intent_5 = new Intent(Book_Activity.this, Pricing.class);
                startActivity(intent_5);
                finish();
                return true;

            case R.id.ContactUs_item:
                Intent intent_6 = new Intent(Book_Activity.this, ConactUs.class);
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

