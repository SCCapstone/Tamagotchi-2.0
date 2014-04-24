
package com.example.game;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;
import android.app.AlertDialog;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.os.Build;

public class MainActivity extends Activity {

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences settings = getSharedPreferences("prefs_tamagotchi", Activity.MODE_PRIVATE);
	    SharedPreferences.Editor editor = settings.edit();

        //{
        	//Toast.makeText(getApplicationContext(), gameState, Toast.LENGTH_SHORT).show();
        	//editor.putString("gameState", "firstRun");
        	//editor.commit();
        //}

    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    
    public void newGame(View v_choosePet){
    	Intent i = new Intent(getApplicationContext(), ChoosePet.class);
    	SharedPreferences settings = getSharedPreferences("prefs_tamagotchi", Activity.MODE_PRIVATE);
	    SharedPreferences.Editor editor = settings.edit();
	    SharedPreferences settingsMoney = getSharedPreferences("prefs_money", Activity.MODE_PRIVATE);
	    SharedPreferences.Editor editorMoney = settingsMoney.edit();
	    editor.putString("game_state", "startState");
	    editor.commit();
	    editorMoney.putInt("player_money", 5);
	    editorMoney.commit();
	    editor.putString("game_started" , "true");
	    editor.commit();
	    startActivity(i);
	    
    }
    
    public void continueGame(View v_gameScreen){
    	//set all variables to start state
    	SharedPreferences settings = getSharedPreferences("prefs_tamagotchi", Activity.MODE_PRIVATE);
	    SharedPreferences.Editor editor = settings.edit();
	    String gameStarted = settings.getString("game_started", null);
	    if(gameStarted.equalsIgnoreCase("true"))
	    {
	    	Intent i = new Intent(getApplicationContext(), GameScreen.class);
    		//Set continue state flag
	    	String tempState = settings.getString("game_state", null);
		    editor.putString("game_state",tempState);
	    	editor.commit();
	    	startActivity(i);
	    }
	    /*
	    else
	    {
	    	Toast.makeText(getApplicationContext(), "Select New Game", Toast.LENGTH_SHORT).show();
	    }
	    */
	    /*
    	//if variables are saved allow continue game
    	if((gameState != "loadState") || (gameState != "startState") || (gameState != "answerCorrect") || (gameState != "backgroundPurchased"))
    	{
    		//Toast.makeText(getApplicationContext(), "Select New Game to start a game", Toast.LENGTH_SHORT).show();
    		Toast.makeText(getApplicationContext(), gameState, Toast.LENGTH_SHORT).show();
    	}
    	else
    	{
    	*/
    		
    	//}
    }
    
    public void exitGame(View v_choosePet){
    	Intent intent = new Intent(Intent.ACTION_MAIN);
    	intent.addCategory(Intent.CATEGORY_HOME);
    	intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    	startActivity(intent);
    }
    
}