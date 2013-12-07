package com.example.game;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.widget.ImageView;

public class GameScreen extends Activity {

    public MediaPlayer player;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_screen);
		// Show the Up button in the action bar.
		setupActionBar();
		
		//Code to change the background of the Game Screen
	    View view = this.getWindow().getDecorView();
	    view.setBackgroundResource(R.drawable.bg1);
	    
	    TextView textView = (TextView) findViewById(R.id.textView1);
	    TextView money = (TextView) findViewById(R.id.textView2);
	    //textView.setText(message);
	    
	    
	    
	    SharedPreferences settings = getSharedPreferences("prefs_tamagotchi", Activity.MODE_PRIVATE);
	    //String playerName = settings.getString("player_name", null);
	    //textView.setText(playerName);
	    //String intMoney = settings.getString("player_money", null);
	    //money.setText(intMoney);
	    
	    
	    String playerPet = settings.getString("player_pet", null);
	    
	    //inserting pet's based off a choice made on the previous screen
	    if(playerPet == "cat")
	    {
	    	//insert cat
	    	//image = catImageFileName
	    }
	    if(playerPet == "dog")
	    {
	    	//insert dog
	    	//image = dogImageFileName
	    }
	    if(playerPet == "dragon")
	    {
	    	//insert dragon
	    	//image = dragonImageFileName
	    }
	    
	    //Getting the game state and deciding what to do with all the variables
	    String gameState = settings.getString("game_state", null);
	    
	    
	    if(gameState == "startState")
	    {
	    	//set all variables to start state
		    SharedPreferences.Editor editor = settings.edit();
		    String playerName = settings.getString("player_name", null);
		    editor.putString("player_money", "$5");
		    editor.commit();
		    textView.setText(playerName);
		    String intMoney = settings.getString("player_money", null);
		    money.setText(intMoney);
		    
	    }
	    
	    
	    if(gameState == "loadState")
	    {
	    	//get all variables
	    	SharedPreferences.Editor editor = settings.edit();
	    	editor.putString("player_money", "$5");
	    	editor.commit();
	    	String intMoney = settings.getString("player_money", null);
	    	String stringName = settings.getString("player_name", null);
	    	money.setText(intMoney);
	    	textView.setText(stringName);
	    }
	    
	    if(gameState == "answerCorrect")
	    {
	    	//get all variables
	    	String intMoney = settings.getString("player_money", null);
	    	String stringName = settings.getString("player_name", null);
	    	money.setText(intMoney);
	    	textView.setText(stringName);
	    	
	    }
	    
	    if(gameState == "backgroundPurchased")
	    {
	    	//get all variables
	    	String intMoney = settings.getString("player_money", null);
	    	String stringName = settings.getString("player_name", null);
	    	//String background = settings.getString("background", null);
	    	money.setText(intMoney);
	    	textView.setText(stringName);
	    	View v = this.getWindow().getDecorView();
	    	v.setBackgroundResource(R.drawable.bg2);
	    	
	    }
	   
	    //Code to play the initial animation
	    ImageView myAnimation = (ImageView)findViewById(R.id.myanimation);
	    final AnimationDrawable myAnimationDrawable
	    = (AnimationDrawable)myAnimation.getDrawable();

	    myAnimation.post(
	    new Runnable(){

	      @Override
	      public void run() {
	       myAnimationDrawable.start();
	      }
	    });
	    

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
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
    public void feedButton(View v_feedButton){
    	ImageView myAnimation = (ImageView)findViewById(R.id.myanimation);
    	myAnimation.setImageResource(R.anim.anim2);
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
    
    public void petButton(View v_petButton){
    	ImageView myAnimation = (ImageView)findViewById(R.id.myanimation);
    	myAnimation.setImageResource(R.anim.anim3);
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
