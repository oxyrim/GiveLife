package com.example.sonam.givelife;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by Sonam on 11/9/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "user.bd";

    SQLiteDatabase db;

    //userinfo table
    private static final String TABLE_NAME = "userinfo";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_CID = "cid";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_BGROUP = "bgroup";
    private static final String COLUMN_LOC = "location";
    private static final String COLUMN_MOBNO = "mobileNo";


    //campaign
    private static final String TABLE_NAME2 = "campaign";
    private static final String COLUMN_CAMID = "id";
    private static final String COLUMN_CAMNAME = "CampaignName";
    private static final String COLUMN_VENUE = "venue";
    private static final String COLUMN_SPONSOR = "sponsor";
    private static final String COLUMN_DATE = "date1";


    //emergency
    private static final String TABLE_NAME3 = "emergency";
    private static final String COLUMN_EMEID = "id";
    private static final String COLUMN_EMENAME = "ename";
    private static final String COLUMN_EMEORG = "organ";
    private static final String COLUMN_EMEHPROB = "hproblem";
    private static final String COLUMN_EMEVENUE = "loc";
    private static final String COLUMN_EMEMOB = "mob";
    private static final String COLUMN_EMEDATE = "time";
    private static final String COLUMN_EMEUSER = "username";


    //organ registration
    private static final String TABLE_NAME4 = "organtable";
    private static final String COLUMN_ORGUSERNAME = "organusername";
    private static final String COLUMN_ORGNAME = "organname";


    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {

        String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME +" (cid integer not null, age integer not null, mobileNo integer not null, " +
                " username varchar primary key not null, password varchar not null, name text not null, bgroup varchar not null, location varchar not null);";

        String TABLE_CREATE2 = "CREATE TABLE " + TABLE_NAME2 +" (id integer not null, " + " CampaignName varchar not null, venue text not null, sponsor text not null, date1 varchar not null);";

        String TABLE_CREATE3 = "CREATE TABLE " + TABLE_NAME3 +" (id integer not null, mob integer not null, " +
                " ename varchar not null, organ varchar not null, hproblem text not null, loc varchar not null, time varchar not null, username varchar not null);";


        String TABLE_CREATE4 = "CREATE TABLE " + TABLE_NAME4 +" (organusername varchar not null, organname varchar not null);";


        db.execSQL(TABLE_CREATE);
        db.execSQL(TABLE_CREATE2);
        db.execSQL(TABLE_CREATE3);
        db.execSQL(TABLE_CREATE4);

    }


    public boolean insertContact(Contacts c)
    {

        db = getWritableDatabase();
        Log.d("c",c.toString());
        ContentValues values  = new ContentValues();
        values.put(COLUMN_USERNAME, c.getUsername());
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_PASSWORD, c.getPassword());
        values.put(COLUMN_CID, c.getCid());
        values.put(COLUMN_AGE, c.getAge());
        values.put(COLUMN_BGROUP, c.getBgroup());
        values.put(COLUMN_MOBNO, c.getMobileNo());
        values.put(COLUMN_LOC, c.getLocation());


        long result = db.insert(TABLE_NAME, null, values);

        db.close();

        if(result == -1)
            return false;
        else
            return true;



    }

    public boolean insertCampaign(Registerdata c)
    {

        db = getWritableDatabase();
        Log.d("c", c.toString());
        ContentValues values2  = new ContentValues();

        String query = "select * from campaign";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values2.put(COLUMN_CAMID, count);
        values2.put(COLUMN_CAMNAME, c.getCamname());
        values2.put(COLUMN_VENUE, c.getVenue());
        values2.put(COLUMN_SPONSOR, c.getSponsor());
        values2.put(COLUMN_DATE, c.getData());

        long result3 = db.insert(TABLE_NAME2, null, values2);

        db.close();

        if(result3 == -1)
            return false;
        else
            return true;



    }


    public boolean insertOrganDonation(Organdon c)
    {

        db = getWritableDatabase();
        Log.d("c", c.toString());
        ContentValues values5  = new ContentValues();
        values5.put( COLUMN_ORGNAME, c.getOrgName());
        values5.put( COLUMN_ORGUSERNAME, c.getUsername7());

        long result5 = db.insert(TABLE_NAME3, null, values5);

        db.close();

        if(result5 == -1)
            return false;
        else
            return true;



    }


    public boolean insertEmergency(Emergency c)
    {

        db = getWritableDatabase();
        Log.d("c", c.toString());
        ContentValues values3  = new ContentValues();

        String query1 = "select * from emergency";
        Cursor cursor = db.rawQuery(query1, null);
        int count1 = cursor.getCount();

        values3.put(COLUMN_EMEID, count1);
        values3.put(COLUMN_EMENAME, c.getName());
        values3.put(COLUMN_EMEORG, c.getOrgan());
        values3.put(COLUMN_EMEHPROB, c.getHproblem());
        values3.put(COLUMN_EMEVENUE, c.getVenue());
        values3.put(COLUMN_EMEMOB, c.getMobile());
        values3.put(COLUMN_EMEDATE, c.getTime());
        values3.put(COLUMN_EMEUSER, c.getUsername());

        long result4 = db.insert(TABLE_NAME3, null, values3);

        db.close();

        if(result4 == -1)
            return false;
        else
            return true;

    }


    public String searchPass(String username)
    {
        db = this.getReadableDatabase();
        String query = "select username, password from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        String a, b;
        b = "Not Found";
        if(cursor.moveToFirst())
        {

            do {

                a = cursor.getString(0);
                if(a.equals(username))
                {
                    b = cursor.getString(1);
                    break;
                }

            }
            while(cursor.moveToNext());

        }

        return b;

    }



    public String searchName(String username)
    {
        db = this.getReadableDatabase();
        String query = "select username, name from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        String c, d;
        d = "Not Found";

        if(cursor.moveToFirst())
        {

            do {

                c = cursor.getString(0);
                if(c.equals(username))
                {
                    d = cursor.getString(1);
                    break;
                }

            }
            while(cursor.moveToNext());

        }

        return d;

    }


    //delete
    public Cursor deleteAccount(String username)
    {
        SQLiteDatabase db = getWritableDatabase();
        Cursor resdel = db.rawQuery("delete from " + TABLE_NAME + " where username ='" + username + "'", null);

        return resdel;

    }

    //delete emergency post
    public Cursor deleteEmeAccount(String username)
    {
        SQLiteDatabase db = getWritableDatabase();
        Cursor resde2 = db.rawQuery("delete from " + TABLE_NAME3 + " where username ='" + username + "'", null);

        return resde2;

    }

    //delete campaign
    public Cursor deleteCam()
    {
        SQLiteDatabase db = getWritableDatabase();
        Cursor resde3 = db.rawQuery("delete from " + TABLE_NAME2, null);

        return resde3;

    }


    public boolean updateData(String username, String location, int age, int mobileNo)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USERNAME, username);
        contentValues.put(COLUMN_LOC, location);
        contentValues.put(COLUMN_AGE, age);
        contentValues.put(COLUMN_MOBNO, mobileNo);

        db.update(TABLE_NAME, contentValues, "username = ?", new String[] {username}  );
        return true;

    }



    //dataRead
    public Cursor getAllData()
    {
        SQLiteDatabase db = getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME2+" order by id desc ", null);
        return res;

    }

    public Cursor getAllDataOne()
    {

        SQLiteDatabase db = getWritableDatabase();
        Cursor resone = db.rawQuery("select * from "+TABLE_NAME, null);

        return resone;

    }

    public Cursor getAllDataTwo()
    {

        SQLiteDatabase db = getWritableDatabase();
        Cursor restwo = db.rawQuery("select * from "+TABLE_NAME3+" order by id desc ", null);


        return restwo;

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        String query2 = "DROP TABLE IF EXISTS "+TABLE_NAME2;
        String query3 = "DROP TABLE IF EXISTS "+TABLE_NAME3;
        String query4 = "DROP TABLE IF EXISTS "+TABLE_NAME4;

        db.execSQL(query);
        db.execSQL(query2);
        db.execSQL(query3);
        db.execSQL(query4);

        onCreate(db);
    }
}
