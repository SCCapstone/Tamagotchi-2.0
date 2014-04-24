package com.example.game;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.KeyEvent;
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
import android.content.Intent;
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
		
	
		
		try{
			String strTemp = settings.getString("Beach", null);
			if(strTemp.equalsIgnoreCase("Beach"))
			{
				//cButton.setEnabled(false);
				cButton.setText("Beach Background - Purchased");
			}
		}
		catch(NullPointerException e){
			
		}
		try{
			String strTemp1 = settings.getString("Meadow", null);
			if(strTemp1.equalsIgnoreCase("Meadow"))
			{
				//cButton2.setEnabled(false);
				cButton2.setText("Meadow Background - Purchased");
			}
		}
		catch(NullPointerException e){
			
		}
		try{
			String strTemp2 = settings.getString("Forest", null);
			if(strTemp2.equalsIgnoreCase("Forest"))
			{
				//cButton3.setEnabled(false);
				cButton3.setText("Forest Background - Purchased");
			}
		}
		catch(NullPointerException e){
			
		}
		try{
			String strTemp3 = settings.getString("BeachTrees", null);
			if(strTemp3.equalsIgnoreCase("BeachTrees"))
			{
				//cButton4.setEnabled(false);
				cButton4.setText("Beach with Trees - Purchased");
			}
		}
		catch(NullPointerException e){
			
		}
		try{
			
			String strTemp4 = settings.getString("MeadowTrees", null);
			if(strTemp4.equalsIgnoreCase("MeadowTrees"))
			{
				//cButton5.setEnabled(false);
				cButton5.setText("Meadow with Trees - Purchased");
			}
		}
		catch(NullPointerException e){
			
		}
		try{
			String strTemp5 = settings.getString("ForestTrees", null);
			if(strTemp5.equalsIgnoreCase("ForestTrees"))
			{
				//cButton6.setEnabled(false);
				cButton6.setText("Forest with Trees - Purchased");
			}
		}
		catch(NullPointerException e){
			
		}
		try{
			String strTemp6 = settings.getString("BeachMystery", null);
			if(strTemp6.equalsIgnoreCase("BeachMystery"))
			{
				//cButton7.setEnabled(false);
				cButton7.setText("Beach Mystery Item - Purchased");
			}
		}
		catch(NullPointerException e){
			
		}
		try{
			String strTemp7 = settings.getString("MeadowMystery", null);
			if(strTemp7.equalsIgnoreCase("MeadowMystery"))
			{
				//cButton8.setEnabled(false);
				cButton8.setText("Meadow Mystery Item - Purchased");
			}
		}
		catch(NullPointerException e){
			
		}
		try{
			String strTemp8 = settings.getString("ForestMystery", null);
			if(strTemp8.equalsIgnoreCase("ForestMystery"))
			{
				//cButton9.setEnabled(false);
				cButton9.setText("Forest Mystery Item - Purchased");
			}
		}
		catch(NullPointerException e){
			
		}
		
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
			SharedPreferences settings = getSharedPreferences("prefs_tamagotchi", Activity.MODE_PRIVATE);
		    SharedPreferences.Editor editor = settings.edit();
		    String tempState = settings.getString("game_state", null);
		    editor.putString("game_state",tempState);
	    	editor.commit();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	

	@Override
	public void onClick(View view) {
		SharedPreferences settings = getSharedPreferences("prefs_tamagotchi", Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		SharedPreferences settingsMoney = getSharedPreferences("prefs_money", Activity.MODE_PRIVATE);
		int intMoney = settingsMoney.getInt("player_money", 0);
		switch(view.getId()){
			case R.id.button1:
				try{
					String strTemp = settings.getString("Beach", null);
					if(strTemp.equalsIgnoreCase("Beach"))
					{
						showOneButtonDialog("Background Changed to Beach", "Background Removed", 0);
						editor.putString("game_state","Beach");
				    	editor.commit();
					}
					else
					{
						showOneButtonDialog("Background Changed to Beach", "Background Removed", 10);
					}
				}
				catch(NullPointerException e){
					showOneButtonDialog("Background Changed to Beach", "Background Removed", 10);
				}
				
				
				if(intMoney >= 10){
		    		editor.putString("game_state","Beach");
			    	editor.commit();
		    		cButton.setText("Beach Background - Purchased");
		    		editor.putString("Beach", "Beach");
		    		editor.commit();
		    		cButton.setEnabled(false);
		    	}
				break;
			case R.id.button2:
				try{
					String strTemp1 = settings.getString("Meadow", null);
					if(strTemp1.equalsIgnoreCase("Meadow"))
					{
						showOneButtonDialog("Background Changed to Meadow", "Background Removed", 0);
						editor.putString("game_state","Meadow");
				    	editor.commit();
					}
					else{
						showOneButtonDialog("Background Changed to Meadow", "Background Removed", 30);
						
					}
				}
				catch(NullPointerException e){
					showOneButtonDialog("Background Changed to Meadow", "Background Removed", 30);
				}
				
		    	if(intMoney >= 30){
		    		editor.putString("game_state","Meadow");
			    	editor.commit();
		    		cButton2.setText("Meadow Background - Purchased");
		    		editor.putString("Meadow", "Meadow");
		    		editor.commit();
		    		cButton2.setEnabled(false);
		    	}
				break;
			case R.id.button3:
				try{
					String strTemp2 = settings.getString("Forest", null);
					if(strTemp2.equalsIgnoreCase("Forest"))
					{
						showOneButtonDialog("Background Changed to Forest", "Background Removed", 0);
						editor.putString("game_state","Forest");
				    	editor.commit();
					}
					else{
						showOneButtonDialog("Background Changed to Forest", "Background Removed", 50);
					}
				}
				catch(NullPointerException e){
					showOneButtonDialog("Background Changed to Forest", "Background Removed", 50);
				}
				
		    	if(intMoney >= 50){
		    		editor.putString("game_state","Forest");
			    	editor.commit();
		    		cButton3.setText("Forest Background - Purchased");
		    		editor.putString("Forest", "Forest");
		    		editor.commit();
		    		cButton3.setEnabled(false);
		    	}
				break;
			case R.id.button4:
				try{
					String strTemp3 = settings.getString("BeachTrees", null);
					if(strTemp3.equalsIgnoreCase("BeachTrees"))
					{
						showOneButtonDialog("Added Trees to Beach", "Background Removed", 0);
						editor.putString("game_state","BeachTrees");
				    	editor.commit();
					}
					else{
						showOneButtonDialog("Added Trees to Beach", "Background Removed", 20);
					}
				}
				catch(NullPointerException e){
					showOneButtonDialog("Added Trees to Beach", "Background Removed", 20);
				}
				
				
		    	if(intMoney >= 20){
		    		editor.putString("game_state","BeachTrees");
			    	editor.commit();
		    		cButton4.setText("Beach with Trees - Purchased");
		    		editor.putString("BeachTrees", "BeachTrees");
		    		editor.commit();
		    		cButton4.setEnabled(false);
		    	}
				break;
			case R.id.button5:
				try{
					
					String strTemp4 = settings.getString("MeadowTrees", null);
					if(strTemp4.equalsIgnoreCase("MeadowTrees"))
					{
						showOneButtonDialog("Added Trees to Meadow", "Background Removed", 0);
						editor.putString("game_state","MeadowTrees");
						editor.commit();
					}
					else{
						showOneButtonDialog("Added Trees to Meadow", "Background Removed", 50);
					}
				}
				catch(NullPointerException e){
					showOneButtonDialog("Added Trees to Meadow", "Background Removed", 50);
				}
				
				
				if(intMoney >= 50){
					editor.putString("game_state","MeadowTrees");
					editor.commit();
					cButton5.setText("Meadow with Trees - Purchased");
					editor.putString("MeadowTrees", "MeadowTrees");
					editor.commit();
					cButton5.setEnabled(false);
				}
				break;
			case R.id.button6:
				try{
					String strTemp5 = settings.getString("ForestTrees", null);
					if(strTemp5.equalsIgnoreCase("ForestTrees"))
					{
						showOneButtonDialog("Added Trees to Forest", "Background Removed", 0);
						editor.putString("game_state","ForestTrees");
				    	editor.commit();
					}
					else{
						showOneButtonDialog("Added Trees to Forest", "Background Removed", 80);
					}
				}
				catch(NullPointerException e){
					showOneButtonDialog("Added Trees to Forest", "Background Removed", 80);
				}
				
				
		    	if(intMoney >= 80){
		    		editor.putString("game_state","ForestTrees");
			    	editor.commit();
		    		cButton6.setText("Forest with Trees - Purchased");
		    		editor.putString("ForestTrees", "ForestTrees");
		    		editor.commit();
		    		cButton6.setEnabled(false);
		    	}
				break;
			case R.id.button7:
				try{
					String strTemp6 = settings.getString("BeachMystery", null);
					if(strTemp6.equalsIgnoreCase("BeachMystery"))
					{
						showOneButtonDialog("Added Mystery to Beach", "Background Removed", 0);
						editor.putString("game_state","BeachMystery");
				    	editor.commit();
					}
					else{
						showOneButtonDialog("Added Mystery to Beach", "Background Removed", 50);
					}
				}
				catch(NullPointerException e){
					showOneButtonDialog("Added Mystery to Beach", "Background Removed", 50);
				}
				
				
		    	if(intMoney >= 50){
		    		editor.putString("game_state","BeachMystery");
			    	editor.commit();
		    		cButton7.setText("Beach Mystery Item - Purchased");
		    		editor.putString("BeachMystery", "BeachMystery");
		    		editor.commit();
		    		cButton7.setEnabled(false);
		    	}
				break;
			case R.id.button8:
				try{
					String strTemp7 = settings.getString("MeadowMystery", null);
					if(strTemp7.equalsIgnoreCase("MeadowMystery"))
					{
						showOneButtonDialog("Added Mystery to Meadow", "Background Removed", 0);
						editor.putString("game_state","MeadowMystery");
				    	editor.commit();
					}
					else{
						showOneButtonDialog("Added Mystery to Meadow", "Background Removed", 100);
					}
				}
				catch(NullPointerException e){
					showOneButtonDialog("Added Mystery to Meadow", "Background Removed", 100);
				}
				
				
		    	if(intMoney >= 100){
		    		editor.putString("game_state","MeadowMystery");
			    	editor.commit();
		    		cButton8.setText("Meadow Mystery Item - Purchased");
		    		editor.putString("MeadowMystery", "MeadowMystery");
		    		editor.commit();
		    		cButton8.setEnabled(false);
		    	}
				break;
			case R.id.button9:
				try{
					String strTemp8 = settings.getString("ForestMystery", null);
					if(strTemp8.equalsIgnoreCase("ForestMystery"))
					{
						showOneButtonDialog("Added Mystery to Forest", "Background Removed", 0);
						editor.putString("game_state","ForestMystery");
				    	editor.commit();
					}
					else{
						showOneButtonDialog("Added Mystery to Forest", "Background Removed", 150);
					}
				}
				catch(NullPointerException e){
					showOneButtonDialog("Added Mystery to Forest", "Background Removed", 150);
				}
				
				
		    	if(intMoney >= 150){
		    		editor.putString("game_state","ForestMystery");
			    	editor.commit();
			    	cButton9.setText("Forest Mystery Item - Purchased");
		    		editor.putString("ForestMystery", "ForestMystery");
		    		editor.commit();
		    		cButton9.setEnabled(false);
		    	}
				break;
		}	
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intent = new Intent(this,GameScreen.class);
		    startActivity(intent);
		    SharedPreferences settings = getSharedPreferences("prefs_tamagotchi", Activity.MODE_PRIVATE);
		    SharedPreferences.Editor editor = settings.edit();
		    editor.putString("game_state","loadState");
	    	editor.commit();
	    }
	    return super.onKeyDown(keyCode, event);
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
				TextView money = (TextView) findViewById(R.id.textView2);
				Toast.makeText(getApplicationContext(), yesM, Toast.LENGTH_SHORT).show();
				SharedPreferences settings = getSharedPreferences("prefs_tamagotchi", Activity.MODE_PRIVATE);
			    SharedPreferences settingsMoney = getSharedPreferences("prefs_money", Activity.MODE_PRIVATE);
				SharedPreferences.Editor editor = settings.edit();
				SharedPreferences.Editor editorMoney = settingsMoney.edit();
				int intMoney = settingsMoney.getInt("player_money", 0);
				intMoney -= price;
				editorMoney.putInt("player_money", intMoney);
			    editorMoney.commit();
			    String strMoney = String.valueOf(intMoney);
			    money.setText(strMoney);
			    /*
			    editor.putString("game_state", "backgroundPurchased");
			    editor.commit();
			    editor.putString("background", "R.drawable.bg1");
			    editor.commit();
			    */
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
