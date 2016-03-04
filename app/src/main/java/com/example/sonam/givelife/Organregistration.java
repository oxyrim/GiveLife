package com.example.sonam.givelife;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class Organregistration extends AppCompatActivity {

    DatabaseHelper db1 = new DatabaseHelper(this);
    EditText etorg;
    Button oregis;

    private android.support.v7.app.ActionBar ab;

    String org, name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organregistration);

        ab=getSupportActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(0xffd04949));


        etorg = (EditText)findViewById(R.id.etorg);
        oregis = (Button)findViewById(R.id.oregis);

        SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        final String username7 = sharedPreferences.getString("username", "N/A");
        final String passuser7 = sharedPreferences.getString("name", "N/A");


        oregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                org = etorg.getText().toString();

                //insert details in database
                Organdon c = new Organdon();
                c.setOrgName(org);
                c.setUsername1(username7);


                boolean isInserted = db1.insertOrganDonation(c);
                if (isInserted = true) {
                    Toast.makeText(Organregistration.this, " Successfully Registered As Organ Donor ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Organregistration.this, Accountsec.class));
                    finish();
                } else
                    Toast.makeText(Organregistration.this, " Try Again ", Toast.LENGTH_SHORT).show();


            }
        });


        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.ic_launcher);

        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setContentView(imageView)
                .build();

        ImageView iconCampaign = new ImageView(this);
        iconCampaign.setImageResource(R.drawable.campaign1);

        ImageView iconMap = new ImageView(this);
        iconMap.setImageResource(R.drawable.map);

        ImageView iconSearch = new ImageView(this);
        iconSearch.setImageResource(R.drawable.homesearch);

        ImageView iconReg = new ImageView(this);
        iconReg.setImageResource(R.drawable.reg);

        ImageView iconEmergency = new ImageView(this);
        iconEmergency.setImageResource(R.drawable.emergency);

        ImageView iconAccount = new ImageView(this);
        iconAccount.setImageResource(R.drawable.account);

        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);

        SubActionButton buttoniconCampaign = itemBuilder.setContentView(iconCampaign).build();
        SubActionButton buttoniconMap = itemBuilder.setContentView(iconMap).build();
        SubActionButton buttoniconSearch = itemBuilder.setContentView(iconSearch).build();
        SubActionButton buttoniconReg = itemBuilder.setContentView(iconReg).build();
        SubActionButton buttoniconEmergency = itemBuilder.setContentView(iconEmergency).build();
        SubActionButton buttoniconAccount = itemBuilder.setContentView(iconAccount).build();


        buttoniconCampaign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Organregistration.this, MainActivity.class));

            }
        });

        buttoniconMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Organregistration.this, MapsActivity.class));

            }
        });

        buttoniconSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Organregistration.this, Search.class));

            }
        });


        buttoniconEmergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Organregistration.this, Emergepost.class));

            }
        });

        buttoniconAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Organregistration.this, Accountsec.class));

            }
        });

        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(buttoniconCampaign)
                .addSubActionView(buttoniconMap)
                .addSubActionView(buttoniconSearch)
                .addSubActionView(buttoniconReg)
                .addSubActionView(buttoniconEmergency)
                .addSubActionView(buttoniconAccount)
                .attachTo(actionButton)
                .build();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_organregistration, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
