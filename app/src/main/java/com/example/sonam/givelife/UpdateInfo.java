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
import android.widget.EditText;
import android.widget.Toast;

public class UpdateInfo extends AppCompatActivity {

    DatabaseHelper db2 = new DatabaseHelper(this);
    EditText locationUp, ageUp, mobileUp;
    Button update;

    String location;
    int age, mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_info);

        locationUp = (EditText)findViewById(R.id.locationUp);
        ageUp = (EditText)findViewById(R.id.ageUp);
        mobileUp = (EditText)findViewById(R.id.mobileUp);


        SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        final String username = sharedPreferences.getString("username", "N/A");
        final String passuser2 = sharedPreferences.getString("name", "N/A");


        update = (Button)findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                location = locationUp.getText().toString();
                age = Integer.parseInt(ageUp.getText().toString());
                mobile = Integer.parseInt(mobileUp.getText().toString());


                boolean isUpdate = db2.updateData(username, location, age, mobile);

                if(isUpdate == true)
                {
                    Toast.makeText(UpdateInfo.this, " Information Updated ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(UpdateInfo.this, Accountsec.class));
                    finish();
                }

                else
                    Toast.makeText(UpdateInfo.this, " Not Updated ", Toast.LENGTH_SHORT).show();

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_update_info, menu);
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
