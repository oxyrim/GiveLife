package com.example.sonam.givelife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity{

    DatabaseHelper db = new DatabaseHelper(this);
    Button bregister;
    EditText etName, etAge, etCid, etBgroup, etMobnum, etUsername, etPassword, etPassword1, etLocation;
    String name, group, username, password, password1, location;
    int age, cid, mobno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText) findViewById(R.id.etName);
        etLocation = (EditText) findViewById(R.id.etLocation);
        etAge = (EditText) findViewById(R.id.etAge);
        etCid = (EditText) findViewById(R.id.etCid);
        etBgroup = (EditText) findViewById(R.id.etBgroup);
        etMobnum = (EditText) findViewById(R.id.etMobnum);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPassword1 = (EditText) findViewById(R.id.etPassword1);

        bregister = (Button) findViewById(R.id.bregister);
        bregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = etName.getText().toString().toUpperCase();
                location = etLocation.getText().toString().toUpperCase();
                username = etUsername.getText().toString().toUpperCase();
                password = etPassword.getText().toString();
                password1 = etPassword1.getText().toString();
                age = Integer.parseInt(etAge.getText().toString());
                group = etBgroup.getText().toString().toUpperCase();
                cid = Integer.parseInt(etCid.getText().toString());
                mobno = Integer.parseInt(etMobnum.getText().toString());


                if (!password.equals(password1)) {

                    Toast pass = Toast.makeText(register.this, "Password Don't Match", Toast.LENGTH_SHORT);
                    pass.show();

                } else {
                    //insert details in database
                    Contacts c = new Contacts();
                    c.setName(name);
                    c.setLocation(location);
                    c.setPassword(password);
                    c.setUsername(username);
                    c.setAge(age);
                    c.setCid(cid);
                    c.setMobileNo(mobno);
                    c.setBgroup(group);

                    boolean isInserted = db.insertContact(c);
                    if(isInserted = true)
                    {
                        Toast.makeText(register.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(register.this, login.class));
                        finish();
                    }
                    else
                        Toast.makeText(register.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}