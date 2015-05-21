package com.example.zekun.my2ndattemptmapapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class InfoActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_screen);

        final Button button1 = (Button) findViewById(R.id.backButton);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
               closeScreen(v);
            }
        });

        final Button button2 = (Button) findViewById(R.id.postButton);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                postInfo(v);
            }
        });
    }

    public void closeScreen(View view){
        finish();
    }

    public void postInfo(View view){
        Intent getUser= new Intent(this, postMap.class);
        EditText userName= (EditText) findViewById(R.id.username);
        String  user=userName.getText().toString();
        getUser.putExtra("theUsername", user);
        EditText additional= (EditText) findViewById(R.id.additionalInfo);
        String  myAdditionalInfo=additional.getText().toString();
        getUser.putExtra("theInfo", myAdditionalInfo);
        startActivity(getUser);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_info, menu);
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
