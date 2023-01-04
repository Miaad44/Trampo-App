package com.example.week4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
    // Here the name of the data base used to store data on it, the name of the created table and the columns it contains are defined.
    public static final String DATABASE_NAME="Miaad.db";
    //The name of the table created in the database.
    public static final String TABLE_NAME="Trampo";
    //The names of the columns in the data base table
    public static final String COL_1="FName_83";
    public static final String COL_2="Phone_83";
    public static final String COL_3="Email_83";
    public static final String COL_4="AType_83";
    public static final String COL_5="Hour_83";
    public static final String COL_6="price";


    public DatabaseHelper(Context context)
    {
        super(context,DATABASE_NAME,null,1);
    }
    public void onCreate(SQLiteDatabase DB22) //This code is to create a table in the database
    {
        //This code to add these columns in the table
        DB22.execSQL("create table " +TABLE_NAME+ "(FName_83 TEXT,Phone_83 INTEGER,Email_83 TEXT, AType_83 TEXT,  Hour_83 INTEGER,price INTEGER)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase DB22, int oldVersion, int newVersion)
    {
        DB22.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(DB22);
    }
    //This method is to add this data that the user will enter into the data base table
    public boolean insertD_83(String FName_83, String Phone_83, String Email_83 , String AType_83, String Hour_83,String price)
    {
        SQLiteDatabase DB22=this.getReadableDatabase();
        ContentValues CV_83=new ContentValues();
        CV_83.put(COL_1,FName_83); //The name of the first column in the table
        CV_83.put(COL_2,Phone_83);
        CV_83.put(COL_3,Email_83);
        CV_83.put(COL_4,AType_83);
        CV_83.put(COL_5,Hour_83);
        CV_83.put(COL_6,price);
        long result=DB22.insert(TABLE_NAME,null,CV_83);
        if(result==-1)
            return false;
        else
            return true;
    }
    //This method is to modify the data in the data base table by entering the phone number to identify the user whose data must be modified
    public boolean updateD_83(String FName_83, String Phone_83, String Email_83 , String AType_83, String Hour_83,String price)
    {
        SQLiteDatabase DB22=this.getWritableDatabase();
        ContentValues CV_83=new ContentValues();
        CV_83.put(COL_1,FName_83);
        CV_83.put(COL_2,Phone_83);
        CV_83.put(COL_3,Email_83);
        CV_83.put(COL_4,AType_83);
        CV_83.put(COL_5,Hour_83);
        CV_83.put(COL_6,price);
        DB22.update(TABLE_NAME,CV_83,"Phone_83=?",new String[]{Phone_83});
        return true;
    }
    //This method is to delete the user's data in the data base table by entering the phone number to identify the user whose data must be deleted
    public Integer deleteD_83(String phone720)
    {
        SQLiteDatabase DB22=this.getWritableDatabase();
        return DB22.delete(TABLE_NAME,"Phone_83=?",new String[]{phone720});
    }

    public Cursor getAllData()
    {
        SQLiteDatabase DB22=this.getWritableDatabase(); //This method is used to get all the data in the data base table
        Cursor cursor=DB22.rawQuery("select * from " +TABLE_NAME,null);
        return cursor;
    }

}





