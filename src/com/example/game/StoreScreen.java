package com.example.game;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;

public class StoreScreen extends Activity implements OnClickListener{
	//creating button
	private Button cButton;
	
	//CODE CHANGED HERE 
	Activity activity;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_store_screen);
		// Show the Up button in the action bar.
		setupActionBar();
		//Setting up the confirmation button for when an item is purchase
		cButton = (Button) findViewById(R.id.button1);
		
		cButton.setOnClickListener(this);
		
		activity = this;
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
		Drawable background = null;
		switch(view.getId()){
			case R.id.button1: 
				showOneButtonDialog();
				break;
		}
		
		
	}
	
	//code needed for the first button to get the background working
	private void showOneButtonDialog(){
		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
		dialogBuilder.setTitle("Buy Confirmation");
		dialogBuilder.setMessage("Buy?");
		dialogBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener()
		{
			public void onClick(DialogInterface dialog, int which){
				Toast.makeText(getApplicationContext(), "Clicked YES", Toast.LENGTH_SHORT).show();
				//code to change the background image				
				cButton.setBackgroundResource( R.drawable.background1 );
				
				//this works as well to change the background
				//findViewById(R.id.button1).setBackgroundResource(R.drawable.background1);
				
				//not working.
				//cButton.setBackground(this.getResources().getDrawable(R.drawable.background1));
				
				
				//activity.findViewById(android.R.id.content).setBackgroundResource(R.drawable.background1);
			}
		});
		dialogBuilder.setNegativeButton("NO",new DialogInterface.OnClickListener() 
		{
			public void onClick(DialogInterface dialog, int which){
				Toast.makeText(getApplicationContext(), "Clicked NO", Toast.LENGTH_SHORT).show();
			}
			
		});
		AlertDialog alertDialog = dialogBuilder.create();
		alertDialog.show();
	}

}
