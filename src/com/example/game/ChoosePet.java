package com.example.game;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;

public class ChoosePet extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_pet);
		// Show the Up button in the action bar.
		setupActionBar();
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.choose_pet, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intent = new Intent(this,MainActivity.class);
		    startActivity(intent);
	    }
	    return super.onKeyDown(keyCode, event);
	}
	
	public void catClick(View v_chooseCat){
    	Intent i = new Intent(getApplicationContext(), ChooseName2.class);
    	startActivity(i);
    	SharedPreferences settings = getSharedPreferences("prefs_tamagotchi", Activity.MODE_PRIVATE);
	    SharedPreferences.Editor editor = settings.edit();
	    editor.putString("player_pet", "cat");
	    editor.commit();
    	
    }
	
	public void dogClick(View v_chooseDog){
    	Intent i = new Intent(getApplicationContext(), ChooseName2.class);
    	startActivity(i);
    	SharedPreferences settings = getSharedPreferences("prefs_tamagotchi", Activity.MODE_PRIVATE);
	    SharedPreferences.Editor editor = settings.edit();
	    editor.putString("player_pet", "dog");
	    editor.commit();
    	
    }
	
	public void dragonClick(View v_chooseDragon){
    	Intent i = new Intent(getApplicationContext(), ChooseName2.class);
    	startActivity(i);
    	SharedPreferences settings = getSharedPreferences("prefs_tamagotchi", Activity.MODE_PRIVATE);
	    SharedPreferences.Editor editor = settings.edit();
	    editor.putString("player_pet", "dragon");
	    editor.commit();
    	
    }
	

}
