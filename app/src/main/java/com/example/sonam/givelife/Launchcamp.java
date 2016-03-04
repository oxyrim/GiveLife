package com.example.sonam.givelife;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class Launchcamp extends AppCompatActivity {

    DatabaseHelper db1 = new DatabaseHelper(this);
    EditText etVenue, etCamname, etSpon, etDate;
    Button bCam;
    String venue, camname, sponsor;
    String date1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launchcamp);

        etVenue = (EditText)findViewById((R.id.etVenue));
        etCamname = (EditText)findViewById((R.id.etCamname));
        etSpon = (EditText)findViewById((R.id.etSpon));
        etDate = (EditText)findViewById((R.id.etDate));

        bCam = (Button) findViewById(R.id.bCam);
        bCam.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                venue = etVenue.getText().toString();
                camname = etCamname.getText().toString();
                date1 = etDate.getText().toString();
                sponsor = etSpon.getText().toString();

                    //insert details in database
                    Registerdata c = new Registerdata();
                    c.setCamname(camname);
                    c.setVenue(venue);
                    c.setSponsor(sponsor);
                    c.setData(date1);

                    boolean isInserted = db1.insertCampaign(c);
                    if(isInserted = true)
                    {
                        Toast.makeText(Launchcamp.this, " Campaign Launched, Launch New Campaign ", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Launchcamp.this, Launchcamp.class));
                        finish();
                    }
                    else
                        Toast.makeText(Launchcamp.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();


            }
        });



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_launchcamp, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will

        switch(item.getItemId())
        {

            case R.id.delete:

                Cursor resde3 = db1.deleteCam();
                if (resde3.getCount() == 0)
                {
                    Toast.makeText(Launchcamp.this, " Campaign Deleted ", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(Launchcamp.this, " No Data To Delete ", Toast.LENGTH_SHORT).show();

        }

        return super.onOptionsItemSelected(item);
    }
}
