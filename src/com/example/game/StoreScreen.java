package com.example.game;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;

public class StoreScreen extends Activity implements OnClickListener{
	//creating button
	private Button cButton;
	private Button cButton2;
	private Button cButton3;
	private Button cButton4;
	private Button cButton5;
	private Button cButton6;
	private Button cButton7;
	private Button cButton8;
	private Button cButton9;

	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_store_screen);
		// Show the Up button in the action bar.
		setupActionBar();
		//Setting up the confirmation button for when an item is purchase
		 
		
		TextView name = (TextView) findViewById(R.id.textView1);
		TextView money = (TextView) findViewById(R.id.textView2);
		
		SharedPreferences settings = getSharedPreferences("prefs_tamagotchi", Activity.MODE_PRIVATE);
		SharedPreferences settingsMoney = getSharedPreferences("prefs_money", Activity.MODE_PRIVATE);
		
		int intMoney = settingsMoney.getInt("player_money", 0);
		String playerName = settings.getString("player_name", null);
		name.setText(playerName);
		String strMoney = String.valueOf(intMoney);
	    money.setText(strMoney);
		
		
		
		cButton = (Button) findViewById(R.id.button1);
		cButton.setOnClickListener(this);
		cButton2 = (Button) findViewById(R.id.button2);
		cButton2.setOnClickListener(this);
		cButton3 = (Button) findViewById(R.id.button3);
		cButton3.setOnClickListener(this);
		cButton4 = (Button) findViewById(R.id.button4);
		cButton4.setOnClickListener(this);
		cButton5 = (Button) findViewById(R.id.button5);
		cButton5.setOnClickListener(this);
		cButton6 = (Button) findViewById(R.id.button6);
		cButton6.setOnClickListener(this);
		cButton7 = (Button) findViewById(R.id.button7);
		cButton7.setOnClickListener(this);
		cButton8 = (Button) findViewById(R.id.button8);
		cButton8.setOnClickListener(this);
		cButton9 = (Button) findViewById(R.id.button9);
		cButton9.setOnClickListener(this);
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
		getMenuInflater().inflate(R.menu.store_screen, menu);
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
	public void onClick(View view) {
		switch(view.getId()){
			case R.id.button1:
				showOneButtonDialog("Background Changed to Beach", "Background Removed", 10);
				break;
			case R.id.button2:
				showOneButtonDialog("Background Changed to Meadow", "Background Removed", 30);
				break;
			case R.id.button3:
				showOneButtonDialog("Background Changed to Forest", "Background Removed", 50);
				break;
			case R.id.button4:
				showOneButtonDialog("Added Trees to Beach", "Background Removed", 20);
				break;
			case R.id.button5:
				showOneButtonDialog("Added Trees to Meadow", "Background Removed", 50);
				break;
			case R.id.button6:
				showOneButtonDialog("Added Trees to Forest", "Background Removed", 80);
				break;
			case R.id.button7:
				showOneButtonDialog("Added Mystery to Beach", "Background Removed", 50);
				break;
			case R.id.button8:
				showOneButtonDialog("Added Mystery to Meadow", "Background Removed", 100);
				break;
			case R.id.button9:
				showOneButtonDialog("Added Mystery to Forest", "Background Removed", 150);
				break;
		}	
	}
		
	
	private void showOneButtonDialog(final String yesM, final String noM, final int price){
		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
		
		SharedPreferences settingsMoney = getSharedPreferences("prefs_money", Activity.MODE_PRIVATE);
		int intMoney = settingsMoney.getInt("player_money", 0);
		
		if(price > intMoney)
		{
			dialogBuilder.setTitle("Need More Money");
		} 
		else 
		{
		dialogBuilder.setTitle("Buy Confirmation");
		dialogBuilder.setMessage("Buy?");
		dialogBuilder.setNegativeButton("YES", new DialogInterface.OnClickListener()
		{
			public void onClick(DialogInterface dialog, int which){
				Toast.makeText(getApplicationContext(), yesM, Toast.LENGTH_SHORT).show();
				SharedPreferences settings = getSharedPreferences("prefs_tamagotchi", Activity.MODE_PRIVATE);
			    SharedPreferences.Editor editor = settings.edit();
			    editor.putString("player_money", "$0");
			    editor.commit();
			    editor.putString("game_state", "backgroundPurchased");
			    editor.commit();
			    editor.putString("background", "R.drawable.bg1");
			    editor.commit();
			    
			}
		});
		dialogBuilder.setPositiveButton("NO",new DialogInterface.OnClickListener() 
		{
			public void onClick(DialogInterface dialog, int which){
				Toast.makeText(getApplicationContext(), noM, Toast.LENGTH_SHORT).show();
			}
			
		});
		}
		AlertDialog alertDialog = dialogBuilder.create();
		alertDialog.show();
	}
	








}
