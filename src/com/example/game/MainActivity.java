package com.example.game;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void newGame(View v_choosePet){
    	Intent i = new Intent(getApplicationContext(), ChoosePet.class);
    	startActivity(i);
    }
}