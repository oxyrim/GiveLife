package com.example.sonam.givelife;

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

public class Search extends AppCompatActivity {

    DatabaseHelper myDb = new DatabaseHelper(this);
    EditText etLocation, etSearch;
    String loc, btype;
    Button bSearch;

    private android.support.v7.app.ActionBar ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


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

                startActivity(new Intent(Search.this, MainActivity.class));

            }
        });

        buttoniconMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Search.this, MapsActivity.class));

            }
        });

        buttoniconReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Search.this, Organregistration.class));

            }
        });

        buttoniconEmergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Search.this, Emergepost.class));

            }
        });

        buttoniconAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Search.this, Accountsec.class));

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



        bSearch = (Button)findViewById(R.id.bSearch);

        viewAllOne();
    }


    public void viewAllOne ()
    {

        bSearch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        etLocation = (EditText)findViewById(R.id.etLocation);
                        etSearch = (EditText)findViewById(R.id.etSearch);

                        loc = etLocation.getText().toString().toUpperCase();
                        btype = etSearch.getText().toString().toUpperCase();

                        Cursor resone = myDb.getAllDataOne();
                        if (resone.getCount() == 0) {
                            //    showMessage("Error", "Nothing Found");

                        }

                        Contacts infone = new Contacts();

                        StringBuffer buffer = new StringBuffer();
                        while (resone.moveToNext())
                        {
                            buffer.append("name : " + resone.getString(5) + "\n");
                            buffer.append("Bgroup : " + resone.getString(6) + "\n");
                            buffer.append("location : " + resone.getString(7) + "\n");
                            buffer.append("Mobile Number : " + resone.getString(2) + "\n\n");

                            infone.setName(resone.getString(5));
                            infone.setBgroup(resone.getString(6));
                            infone.setLocation(resone.getString(7));
                            infone.setMobileNo(Integer.parseInt(resone.getString(2)));

                            if(resone.getString(6).equals(btype)&&resone.getString(7).equals(loc))
                            {
                                showMessage("Data", infone);

                            }
                            else
                            {

                            }
                        }


                    }


                });


    }


    public void showMessage(String title, Contacts info)
    {
        LinearLayout v1 = (LinearLayout)findViewById(R.id.v1);
        v1.setVisibility(View.GONE);

        LinearLayout lr1 = (LinearLayout)findViewById(R.id.v);
        lr1.setVisibility(View.VISIBLE);
        TextView text = new TextView(this);
        TextView text2 = new TextView(this);
        TextView text3 = new TextView(this);
        TextView text6 = new TextView(this);

        text.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        text.setTextColor(Color.RED);
        text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        text.setText(info.getName());
        text.setTypeface(null, Typeface.BOLD);
        text.setCompoundDrawablePadding(10);
        text.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.acc2, 0, 0, 0);
        text.setPadding(10, 10, 0, 0);

        text2.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        text2.setText("" + info.getMobileNo());
        text2.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.mobile1, 0, 0, 0);
        text2.setCompoundDrawablePadding(5);
        text2.setPadding(32, 10, 0, 0);

        text3.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        text3.setText(info.getLocation());
        text3.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.loc1, 0, 0, 0);
        text3.setCompoundDrawablePadding(5);
        text3.setPadding(32, 7, 0, 7);

        text6.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        text6.setBackgroundColor(getResources().getColor(android.R.color.white));
        text6.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 20));
        text6.setPadding(0, 0, 0, 10);

        View v = new View(this);
        v.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                2
        ));

        v.setBackgroundColor(Color.parseColor("#B3B3B3"));

        lr1.addView(text);
        lr1.addView(text2);
        lr1.addView(text3);
        lr1.addView(text6);

    }

}
