package com.example.sonam.givelife;

import android.app.AlertDialog;
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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class login extends AppCompatActivity implements View.OnClickListener {

    DatabaseHelper helper = new DatabaseHelper(this);

    Button blogin;
    EditText etUsername, etPassword;
    TextView tvRegisterLink, admin;

    private android.support.v7.app.ActionBar ab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ab=getSupportActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(0xffd04949));

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        blogin = (Button) findViewById(R.id.blogin);
        tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);
        admin = (TextView) findViewById(R.id.admin);

        blogin.setOnClickListener(this);

        admin.setOnClickListener(this);
        tvRegisterLink.setOnClickListener(this);



    }

    @Override
    public void onClick(View v)
    {

        switch (v.getId()) {
            case R.id.blogin:

                String pa = etPassword.getText().toString();
                String us = etUsername.getText().toString().toUpperCase();


                String passuser = helper.searchName(us);

                String password = helper.searchPass(us);

                Log.d("pass", password);


                if (pa.equals(password))
                {

                    SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", us);
                    editor.putString("name", passuser);

                    editor.commit();

                    startActivity(new Intent(this, MainActivity.class));
                    finish();

                }
                else
                {
                    Toast pass = Toast.makeText(login.this, "Wrong Password Or Username", Toast.LENGTH_SHORT);
                    pass.show();
                }
                break;

            case R.id.admin:
                startActivity(new Intent(this, Masterlogin.class));
                break;

            case R.id.tvRegisterLink:
                startActivity(new Intent(this, register.class));
                break;


        }


}
}