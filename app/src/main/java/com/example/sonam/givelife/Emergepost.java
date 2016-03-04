package com.example.sonam.givelife;

import android.app.ActionBar;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class Emergepost extends AppCompatActivity {

    DatabaseHelper myDb1 = new DatabaseHelper(this);
    Button showbutton1;

    private android.support.v7.app.ActionBar ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergepost);
        func2();

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

                startActivity(new Intent(Emergepost.this, MainActivity.class));

            }
        });

        buttoniconMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Emergepost.this, MapsActivity.class));

            }
        });

        buttoniconSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Emergepost.this, Search.class));

            }
        });

        buttoniconReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Emergepost.this, Organregistration.class));

            }
        });

        buttoniconAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Emergepost.this, Accountsec.class));

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


    public void func2()
    {
        Cursor restwo = myDb1.getAllDataTwo();
        if (restwo.getCount() == 0) {


        }

        Emergency info = new Emergency();

        StringBuffer buffer = new StringBuffer();
        while (restwo.moveToNext()) {

            buffer.append("Name : " + restwo.getString(2) + "\n");
            buffer.append("Health Problem : " + restwo.getString(4) + "\n");
            buffer.append("Organ Needed : " + restwo.getString(3) + "\n");
            buffer.append("Deadline : " + restwo.getString(6) + "\n");
            buffer.append("Venue : " + restwo.getString(5) + "\n");
            buffer.append("Mobile : " + restwo.getString(1) + "\n\n");

            info.setName(restwo.getString(2));
            info.setVenue(restwo.getString(5));
            info.setHproblem(restwo.getString(4));
            info.setTime(restwo.getString(6));
            info.setMobile(Integer.parseInt(restwo.getString(1)));
            info.setOrgan(restwo.getString(3));

            showMessage("Data", info);

        }

    }


    public void showMessage(String title, Emergency info)
    {

        LinearLayout lr = (LinearLayout)findViewById(R.id.s1);

        TextView text = new TextView(this);
        TextView text1 = new TextView(this);
        TextView text2 = new TextView(this);
        TextView text3 = new TextView(this);
        TextView text4 = new TextView(this);
        TextView text5 = new TextView(this);
        TextView text6 = new TextView(this);

        text.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        text.setTextColor(Color.RED);
        text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17);
        text.setTypeface(null, Typeface.BOLD);
        text.setText(info.getName());
        text.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.acc2, 0, 0, 0);
        text.setCompoundDrawablePadding(10);
        text.setPadding(10, 15, 0, 5);

        text4.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        text4.setText(info.getVenue());
        text4.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.loc1, 0, 0, 0);
        text4.setCompoundDrawablePadding(5);
        text4.setPadding(27, 0, 0, 0);

        text5.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        text5.setText("" + info.getMobile());
        text5.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.hosna, 0, 0, 0);
        text4.setCompoundDrawablePadding(5);
        text5.setPadding(32, 3, 0, 0);

        text1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        text1.setText(info.getHproblem());
        text1.setPadding(32, 5, 0, 0);

        text2.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        text2.setText(info.getOrgan());
        text2.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.org, 0, 0, 0);
        text2.setCompoundDrawablePadding(5);
        text2.setPadding(27, 5, 0, 0);

        text3.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        text3.setText(info.getTime());
        text3.setTextColor(Color.RED);
        text3.setPadding(32, 1, 0, 15);

        text6.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        text6.setBackgroundColor(getResources().getColor(android.R.color.white));
        text6.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 20));
        text6.setPadding(0, 0, 0, 15);

        View v = new View(this);
        v.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                2
        ));

        v.setBackgroundColor(Color.parseColor("#B3B3B3"));

        lr.addView(text);
        lr.addView(text4);
        lr.addView(text5);
        //lr.addView(text1);
        lr.addView(text2);
        lr.addView(text3);
        lr.addView(text6);
        //lr.addView(v);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_emergepost, menu);
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
