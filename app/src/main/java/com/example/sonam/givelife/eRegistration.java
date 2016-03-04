package com.example.sonam.givelife;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class eRegistration extends AppCompatActivity {

    DatabaseHelper db7 = new DatabaseHelper(this);

    TextView t;
    EditText etOrganDon;
    Button donorbutton;
    //CheckBox checkBox;

    String orgName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_registration);

        etOrganDon = (EditText) findViewById(R.id.etOrgan);
        donorbutton = (Button)findViewById(R.id.donorbutton);
        t = (TextView)findViewById(R.id.t);
        //checkBox = (CheckBox) findViewById(R.id.checkBox);

        SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        final String username7 = sharedPreferences.getString("username", "N/A");
        final String passuser7 = sharedPreferences.getString("name", "N/A");


        t.setText("Your name is: " + username7);

        donorbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)

            {

                orgName = etOrganDon.getText().toString();

                //insert details in database
                Organdon c = new Organdon();
                c.setUsername1(username7);
                c.setOrgName(orgName);

                boolean isInserted = db7.insertOrganDonation( c );
                if (isInserted = true) {
                    Toast.makeText(eRegistration.this, " Registered As An Organ Donor ", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(eRegistration.this, Accountsec.class));
                    finish();
                } else
                    Toast.makeText(eRegistration.this, " Not Registered ", Toast.LENGTH_SHORT).show();


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_e_registration, menu);
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
