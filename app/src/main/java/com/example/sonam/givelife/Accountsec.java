package com.example.sonam.givelife;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class Accountsec extends AppCompatActivity {

    DatabaseHelper myDb1 = new DatabaseHelper(this);
    TextView txtStatus, textDel, texteli, textpos, textinfo, txtUser, textUp;
    Button bLogout;

    public static final String DEFAULT="N/A";
    private android.support.v7.app.ActionBar ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountsec);

        ab=getSupportActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(0xffd04949));

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

                startActivity(new Intent(Accountsec.this, MainActivity.class));

            }
        });

        buttoniconMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Accountsec.this, MapsActivity.class));

            }
        });

        buttoniconSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Accountsec.this, Search.class));
                
            }
        });

        buttoniconReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Accountsec.this, Organregistration.class));

            }
        });

        buttoniconEmergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Accountsec.this, Emergepost.class));

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

        txtStatus = (TextView)findViewById(R.id.txtStatus);
        texteli = (TextView)findViewById(R.id.texteli);
        textpos = (TextView)findViewById(R.id.textpos);
        textinfo = (TextView)findViewById(R.id.textinfo);
        txtUser = (TextView)findViewById(R.id.txtUser);
        textDel = (TextView)findViewById(R.id.textDel);
        bLogout = (Button)findViewById(R.id.blogout);
        textUp = (TextView)findViewById(R.id.textUp);

        SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        final String username = sharedPreferences.getString("username", DEFAULT);
        final String passuser1 = sharedPreferences.getString("name", DEFAULT);

        txtUser.setText("" + username);
        txtStatus.setText("" + passuser1);


        texteli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Accountsec.this, Eligibility.class));

            }
        });

        textpos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Accountsec.this, Post.class));
            }
        });


        textDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor resdel = myDb1.deleteAccount(username);
                if (resdel.getCount() == 0)
                {
                    Toast.makeText(Accountsec.this, " User Deleted ", Toast.LENGTH_SHORT).show();

                    SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.clear();
                    editor.commit();

                    startActivity(new Intent(Accountsec.this, login.class));
                    finish();
                }

            }
        });


        textinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Accountsec.this, Information.class));

            }
        });


        textUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Accountsec.this, UpdateInfo.class));

            }
        });


        bLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                startActivity(new Intent(Accountsec.this, login.class));
                finish();

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_accountsec, menu);
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
