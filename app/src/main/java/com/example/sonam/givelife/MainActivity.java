package com.example.sonam.givelife;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb = new DatabaseHelper(this);

    private android.support.v7.app.ActionBar ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        func1();

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

        buttoniconMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, MapsActivity.class));

            }
        });

        buttoniconSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, Search.class));

            }
        });

        buttoniconReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, Organregistration.class));

            }
        });


        buttoniconEmergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, Emergepost.class));

            }
        });

        buttoniconAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, Accountsec.class));

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


    public void func1(){
        Cursor res = myDb.getAllData();
        if (res.getCount() == 0) {
            //    showMessage("Error", "Nothing Found");

        }

        Registerdata info = new Registerdata();

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {

            buffer.append("Cam Name : " + res.getString(1) + "\n");
            buffer.append("Venue : " + res.getString(2) + "\n");
            buffer.append("Sponsor : " + res.getString(3) + "\n");
            buffer.append("Date : " + res.getString(4) + "\n\n");

            info.setCamname(res.getString(1));
            info.setVenue(res.getString(2));
            info.setSponsor(res.getString(3));
            info.setData(res.getString(4));
            showMessage("Data", info);

        }

    }


    public void showMessage(String title, Registerdata info)
    {

        LinearLayout lr = (LinearLayout)findViewById(R.id.rl);

        TextView text = new TextView(this);
        TextView text1 = new TextView(this);
        TextView text2 = new TextView(this);
        TextView text3 = new TextView(this);

        text.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        text.setTextColor(Color.RED);
        text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        text.setTypeface(null, Typeface.BOLD);
        text.setText(info.getCamname());
        text.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.enam, 0, 0, 0);
        text.setCompoundDrawablePadding(10);
        text.setPadding(10, 10, 0, 0);

        text1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        text1.setText(info.getVenue());
        text1.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.locc, 0, 0, 0);
        text1.setCompoundDrawablePadding(5);
        text1.setPadding(32, 10, 0, 0);

        text2.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        text2.setText(info.getSponsor());
        text2.setPadding(63, 5, 0, 10);

        text3.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        text3.setText(info.getData());
        text3.setPadding(63, 0, 0, 0);

        View v = new View(this);
        v.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                1
        ));

        v.setBackgroundColor(Color.parseColor("#B3B3B3"));

        lr.addView(text);
        lr.addView(text1);
        lr.addView(text3);
        lr.addView(text2);
        lr.addView(v);

    }

}
