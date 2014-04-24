package com.example.game;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.widget.ImageView;



public class GameScreen extends Activity {

    public MediaPlayer player;
    private boolean leaveCalled = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_screen);
		// Show the Up button in the action bar.
		setupActionBar();
		
		//Code to change the background of the Game Screen
	    View view = this.getWindow().getDecorView();
	    view.setBackgroundResource(R.drawable.bg1);
	    
	    TextView name = (TextView) findViewById(R.id.textView1);
    	TextView money = (TextView) findViewById(R.id.textView2);
	    //textView.setText(message);
	    
	    
	    
	    SharedPreferences settings = getSharedPreferences("prefs_tamagotchi", Activity.MODE_PRIVATE);
	    SharedPreferences settingsMoney = getSharedPreferences("prefs_money", Activity.MODE_PRIVATE);
	    SharedPreferences.Editor editor = settings.edit();
	    
	    //String playerName = settings.getString("player_name", null);
	    //textView.setText(playerName);
	    //String intMoney = settings.getString("player_money", null);
	    //money.setText(intMoney);
	    
	    
	    //Getting the game state and deciding what to do with all the variables
	    String gameState = settings.getString("game_state", null);
	    
	    
	    
	    String playerPet = settings.getString("player_pet", null);
	    
	    //inserting pet's based off a choice made on the previous screen
	    if(playerPet.equalsIgnoreCase("cat"))
	    {
		    //Code to play the initial animation
	    	ImageView myAnimation = (ImageView)findViewById(R.id.myanimation);
		    myAnimation.setImageResource(R.anim.catidle);
		    final AnimationDrawable myAnimationDrawable
		    = (AnimationDrawable)myAnimation.getDrawable();

		    myAnimation.post(
		    new Runnable(){

		      @Override
		      public void run() {
		       myAnimationDrawable.start();
		      }
		    });
	    }
	    if(playerPet.equalsIgnoreCase("dog"))
	    {
		    //Code to play the initial animation
		    ImageView myAnimation = (ImageView)findViewById(R.id.myanimation);
		    myAnimation.setImageResource(R.anim.dogidle);
		    final AnimationDrawable myAnimationDrawable
		    = (AnimationDrawable)myAnimation.getDrawable();

		    myAnimation.post(
		    new Runnable(){

		      @Override
		      public void run() {
		       myAnimationDrawable.start();
		      }
		    });
	    	
	    }
	    if(playerPet.equalsIgnoreCase("dragon"))
	    {
		    //Code to play the initial animation
		    ImageView myAnimation = (ImageView)findViewById(R.id.myanimation);
		    myAnimation.setImageResource(R.anim.dragonidle);
		    final AnimationDrawable myAnimationDrawable
		    = (AnimationDrawable)myAnimation.getDrawable();

		    myAnimation.post(
		    new Runnable(){

		      @Override
		      public void run() {
		       myAnimationDrawable.start();
		      }
		    });
	    }
	    
	    
	    
	    if(gameState.equalsIgnoreCase("startState"))
	    {
	    	
	    	String playerName = settings.getString("player_name", null);
		    //editor.putInt("player_money", 5);
		    //editor.commit();
		   	name.setText(playerName);
		    int intMoney = settingsMoney.getInt("player_money", 0);
		    String strMoney = String.valueOf(intMoney);
		    money.setText(strMoney);	
	    	//set all variables to start state
		    //SharedPreferences.Editor editor = settings.edit();
	    	//SharedPreferences.Editor editorMoney = settingsMoney.edit();
	    }
	   
	   
	    if(gameState.equalsIgnoreCase("loadState"))
	    {
	    	
	    	//get all variables
	    	//SharedPreferences.Editor editor = settings.edit();
	    	//editor.putInt("player_money", 5);
	    	//editor.commit();
	    	int intMoney = settingsMoney.getInt("player_money", 0);
	    	String stringName = settings.getString("player_name", null);
	    	String strMoney = String.valueOf(intMoney);
		    money.setText(strMoney);
	    	name.setText(stringName);
	    	
	    }
	    
	    if(gameState.equalsIgnoreCase("answerCorrect"))
	    {
	    	
	    	//get all variables
	    	int intMoney = settingsMoney.getInt("player_money", 0);
	    	String stringName = settings.getString("player_name", null);
	    	String strMoney = String.valueOf(intMoney);
		    money.setText(strMoney);
	    	name.setText(stringName);
	    	
	    }
	    /*
	    if(gameState.equalsIgnoreCase("backgroundPurchased"))
	    {
	    	editor.putString("game_state","safeState");
	    	editor.commit();
	    	//get all variables
	    	int intMoney = settingsMoney.getInt("player_money", 0);
	    	String stringName = settings.getString("player_name", null);
	    	//String background = settings.getString("background", null);
	    	String strMoney = String.valueOf(intMoney);
		    money.setText(strMoney);
	    	name.setText(stringName);
	    	View v = this.getWindow().getDecorView();
	    	v.setBackgroundResource(R.drawable.bg2);
	    	
	    }
	    */
	    if(gameState.equalsIgnoreCase("Beach"))
	    {
	   
	    	//get all variables
	    	int intMoney = settingsMoney.getInt("player_money", 0);
	    	String stringName = settings.getString("player_name", null);
	    	//String background = settings.getString("background", null);
	    	String strMoney = String.valueOf(intMoney);
		    money.setText(strMoney);
	    	name.setText(stringName);
	    	View v = this.getWindow().getDecorView();
	    	v.setBackgroundResource(R.drawable.beach);
	    	
	    }
	    if(gameState.equalsIgnoreCase("BeachTrees"))
	    {
	    	
	    	//get all variables
	    	int intMoney = settingsMoney.getInt("player_money", 0);
	    	String stringName = settings.getString("player_name", null);
	    	//String background = settings.getString("background", null);
	    	String strMoney = String.valueOf(intMoney);
		    money.setText(strMoney);
	    	name.setText(stringName);
	    	View v = this.getWindow().getDecorView();
	    	v.setBackgroundResource(R.drawable.beachtrees);
	    	
	    }
	    if(gameState.equalsIgnoreCase("BeachMystery"))
	    {
	    	
	    	//get all variables
	    	int intMoney = settingsMoney.getInt("player_money", 0);
	    	String stringName = settings.getString("player_name", null);
	    	//String background = settings.getString("background", null);
	    	String strMoney = String.valueOf(intMoney);
		    money.setText(strMoney);
	    	name.setText(stringName);
	    	View v = this.getWindow().getDecorView();
	    	v.setBackgroundResource(R.drawable.beachmystery1);
	    	
	    }
	    if(gameState.equalsIgnoreCase("Meadow"))
	    {
	    	
	    	//get all variables
	    	int intMoney = settingsMoney.getInt("player_money", 0);
	    	String stringName = settings.getString("player_name", null);
	    	//String background = settings.getString("background", null);
	    	String strMoney = String.valueOf(intMoney);
		    money.setText(strMoney);
	    	name.setText(stringName);
	    	View v = this.getWindow().getDecorView();
	    	v.setBackgroundResource(R.drawable.meadow);
	    	
	    }
	    if(gameState.equalsIgnoreCase("MeadowTrees"))
	    {
	    	
	    	//get all variables
	    	int intMoney = settingsMoney.getInt("player_money", 0);
	    	String stringName = settings.getString("player_name", null);
	    	//String background = settings.getString("background", null);
	    	String strMoney = String.valueOf(intMoney);
		    money.setText(strMoney);
	    	name.setText(stringName);
	    	View v = this.getWindow().getDecorView();
	    	v.setBackgroundResource(R.drawable.meadowtrees);
	    	
	    }
	    if(gameState.equalsIgnoreCase("MeadowMystery"))
	    {
	    	
	    	//get all variables
	    	int intMoney = settingsMoney.getInt("player_money", 0);
	    	String stringName = settings.getString("player_name", null);
	    	//String background = settings.getString("background", null);
	    	String strMoney = String.valueOf(intMoney);
		    money.setText(strMoney);
	    	name.setText(stringName);
	    	View v = this.getWindow().getDecorView();
	    	v.setBackgroundResource(R.drawable.meadowmystery);
	    	
	    }
	    if(gameState.equalsIgnoreCase("Forest"))
	    {
	    	
	    	//get all variables
	    	int intMoney = settingsMoney.getInt("player_money", 0);
	    	String stringName = settings.getString("player_name", null);
	    	//String background = settings.getString("background", null);
	    	String strMoney = String.valueOf(intMoney);
		    money.setText(strMoney);
	    	name.setText(stringName);
	    	View v = this.getWindow().getDecorView();
	    	v.setBackgroundResource(R.drawable.bg2);
	    	
	    }
	    if(gameState.equalsIgnoreCase("ForestTrees"))
	    {
	    	
	    	//get all variables
	    	int intMoney = settingsMoney.getInt("player_money", 0);
	    	String stringName = settings.getString("player_name", null);
	    	//String background = settings.getString("background", null);
	    	String strMoney = String.valueOf(intMoney);
		    money.setText(strMoney);
	    	name.setText(stringName);
	    	View v = this.getWindow().getDecorView();
	    	v.setBackgroundResource(R.drawable.bg2);
	    	
	    }
	    if(gameState.equalsIgnoreCase("ForestMystery"))
	    {
	    	
	    	//get all variables
	    	int intMoney = settingsMoney.getInt("player_money", 0);
	    	String stringName = settings.getString("player_name", null);
	    	//String background = settings.getString("background", null);
	    	String strMoney = String.valueOf(intMoney);
		    money.setText(strMoney);
	    	name.setText(stringName);
	    	View v = this.getWindow().getDecorView();
	    	v.setBackgroundResource(R.drawable.bg2);
	    	
	    }
	    

	 
	    
	    

	    player = MediaPlayer.create(GameScreen.this, R.raw.music);
	    player.setLooping(true); // Set looping 
	    player.setVolume(100,100);
	    player.start(); 
	    
	    
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
		getMenuInflater().inflate(R.menu.game_screen, menu);
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
			//NavUtils.navigateUpFromSameTask(this);
			Intent i = new Intent(getApplicationContext(), MainActivity.class);
	    	startActivity(i);
		    player.stop();
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
		    player.stop();
			//moveTaskToBack(true);
	        //return true;
	    }
		if (keyCode == KeyEvent.KEYCODE_HOME)
        {
			player.stop();
                    }
        
	    return super.onKeyDown(keyCode, event);
	}
	
	
	@Override
	public void onBackPressed()
	{
		Intent intent = new Intent(this,MainActivity.class);
	    startActivity(intent);
	    player.stop();
	}
	
	@Override
	protected void onStop() {   
	    super.onStop();
	    // Home button pressed
	    if(!leaveCalled) {
	        player.stop();
	    }

	    leaveCalled = false;
	}
	
	
	    
	
    public void feedButton(View v_feedButton){
    	TextView money = (TextView) findViewById(R.id.textView2);
    	int price = 2;
    	ImageView myAnimation = (ImageView)findViewById(R.id.myanimation);
    	myAnimation.destroyDrawingCache();
    	    	
    	SharedPreferences settings = getSharedPreferences("prefs_tamagotchi", Activity.MODE_PRIVATE);
	    SharedPreferences settingsMoney = getSharedPreferences("prefs_money", Activity.MODE_PRIVATE);
		SharedPreferences.Editor editorMoney = settingsMoney.edit();
		
	  	String playerPet = settings.getString("player_pet", null);
	  	//Toast.makeText(getApplicationContext(),  playerPet , Toast.LENGTH_SHORT).show();

		    //inserting pet's based off a choice made on the previous screen
		    if(playerPet.equalsIgnoreCase("cat"))
		    {
		    	myAnimation.setImageResource(R.anim.catfeed);
		    }
		    if(playerPet.equalsIgnoreCase("dog"))
		    {
		    	myAnimation.setImageResource(R.anim.dogfeed);
		    }
		    if(playerPet.equalsIgnoreCase("dragon"))
		    {
		    	myAnimation.setImageResource(R.anim.dragonfeed);
		    }
		
		int intMoney = settingsMoney.getInt("player_money", 0);
		if(intMoney >= price){
			intMoney -= price;
			editorMoney.putInt("player_money", intMoney);
			editorMoney.commit();
			String strMoney = String.valueOf(intMoney);
		    money.setText(strMoney);
		    final AnimationDrawable myAnimationDrawable
		    = (AnimationDrawable)myAnimation.getDrawable();

		    myAnimation.post(
		    new Runnable(){

		      @Override
		      public void run() {
		       myAnimationDrawable.stop();
		       myAnimationDrawable.start();
		      }
		    });
		} else{
			Toast.makeText(getApplicationContext(),  "need more money" , Toast.LENGTH_SHORT).show();
		}
	    
    }
    //
    public void petButton(View v_petButton){
    	TextView money = (TextView) findViewById(R.id.textView2);
    	int price = 1;
    	ImageView myAnimation = (ImageView)findViewById(R.id.myanimation);
    	myAnimation.destroyDrawingCache();

    	SharedPreferences settings = getSharedPreferences("prefs_tamagotchi", Activity.MODE_PRIVATE);
	    SharedPreferences settingsMoney = getSharedPreferences("prefs_money", Activity.MODE_PRIVATE);
		SharedPreferences.Editor editorMoney = settingsMoney.edit();
		
	  	String playerPet = settings.getString("player_pet", null);

	    //inserting pet's based off a choice made on the previous screen
	    if(playerPet.equalsIgnoreCase("cat"))
	    {
	    	myAnimation.setImageResource(R.anim.catpet);
	    }
	    if(playerPet.equalsIgnoreCase("dog"))
	    {
	    	myAnimation.setImageResource(R.anim.dogpet);
	    }
	    if(playerPet.equalsIgnoreCase("dragon"))
	    {
	    	myAnimation.setImageResource(R.anim.dragonpet);
	    }
	
		
		int intMoney = settingsMoney.getInt("player_money", 0);
		if(intMoney >= price){
			intMoney -= price;
			editorMoney.putInt("player_money", intMoney);
			editorMoney.commit();
			String strMoney = String.valueOf(intMoney);
			money.setText(strMoney);
			 final AnimationDrawable myAnimationDrawable
			    = (AnimationDrawable)myAnimation.getDrawable();
			    myAnimation.post(
			    new Runnable(){

			      @Override
			      public void run() {
			       myAnimationDrawable.stop();
			       myAnimationDrawable.start();
			       //myAnimationDrawable.setOneShot(true);
			     
			      }
			    });
		} else{
			Toast.makeText(getApplicationContext(), "Need more money", Toast.LENGTH_SHORT).show();
		}
	    
    }

    public void questionScreen(View v_questionScreen){
    	Intent i = new Intent(getApplicationContext(), QuestionScreen.class);
    	startActivity(i);
	    player.stop();
    }
    
    public void storeScreen(View v_storeScreen){
    	Intent i = new Intent(getApplicationContext(), StoreScreen.class);
    	startActivity(i);
	    player.stop();
    }
   
    public void exitGame(View v_choosePet){
    	Intent i = new Intent(getApplicationContext(), MainActivity.class);
    	startActivity(i);
	    player.stop();
    }
}
