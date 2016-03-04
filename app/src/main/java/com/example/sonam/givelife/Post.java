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
import android.widget.TextView;
import android.widget.Toast;

public class Post extends AppCompatActivity {


    DatabaseHelper db2 = new DatabaseHelper(this);
    EditText etproblem, etOrgan, etDeadline, etHosname, etMobile;
    String problem, organ, deadline, hospital;
    Button bEme;
    int mobno1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        etproblem = (EditText)findViewById((R.id.etproblem));
        etMobile = (EditText)findViewById((R.id.etMobile));
        etOrgan = (EditText)findViewById((R.id.etOrgan));
        etDeadline = (EditText)findViewById((R.id.etDeadline));
        etHosname = (EditText)findViewById((R.id.etHosname));

        bEme = (Button)findViewById(R.id.bEme);

        SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        final String username = sharedPreferences.getString("username", "N/A");
        final String passuser2 = sharedPreferences.getString("name", "N/A");

        //name1.setText("Your name is: " + passuser2);



        bEme.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                problem = etproblem.getText().toString();
                mobno1 = Integer.parseInt(etMobile.getText().toString());
                organ = etOrgan.getText().toString();
                deadline = etDeadline.getText().toString();
                hospital = etHosname.getText().toString();

                //insert details in database
                Emergency c = new Emergency();
                c.setHproblem(problem);
                c.setOrgan(organ);
                c.setTime(deadline);
                c.setVenue(hospital);
                c.setName(passuser2);
                c.setMobile(mobno1);
                c.setUsername(username);

                boolean isInserted = db2.insertEmergency(c);
                if(isInserted = true)
                {
                    Toast.makeText(Post.this, " Campaign Launched ", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(Post.this, Post.class));
                    finish();
                }
                else
                    Toast.makeText(Post.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_post, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will

        switch(item.getItemId())
        {

            case R.id.delete:
                SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
                final String username = sharedPreferences.getString("username", "N/A");

                Cursor resde2 = db2.deleteEmeAccount(username);
                if (resde2.getCount() == 0)
                {
                    Toast.makeText(Post.this, " User Post Deleted ", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(Post.this, " No Post To Delete ", Toast.LENGTH_SHORT).show();

        }

        return super.onOptionsItemSelected(item);
    }
}
