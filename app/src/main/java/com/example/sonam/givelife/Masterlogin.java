package com.example.sonam.givelife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Masterlogin extends AppCompatActivity {

    EditText etAdminU, etAdminP;
    String adu, adp;
    Button bMlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masterlogin);

        etAdminU = (EditText) findViewById(R.id.etAdminU);
        etAdminP = (EditText) findViewById(R.id.etAdminP);

        bMlogin = (Button)findViewById(R.id.bMlogin);

        bMlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                adu = etAdminU.getText().toString();
                adp = etAdminP.getText().toString();

                if (adu.equals("admin123") && adp.equals("adminp123")) {

                    startActivity(new Intent(Masterlogin.this, Launchcamp.class));
                }
                else
                {

                    Toast pass = Toast.makeText(Masterlogin.this, "Password and Username Don't Match", Toast.LENGTH_SHORT);
                    pass.show();

                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_masterlogin, menu);
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
