package com.example.game;

import android.widget.Toast;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuestionScreen extends Activity {
private RadioGroup radioGAns;
private RadioButton radioAns;
private Button btnSubmit;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_question_screen);
addListenerOnButton();
}

private void addListenerOnButton() {
// TODO Auto-generated method stub
radioGAns= (RadioGroup) findViewById(R.id.radioAns);
btnSubmit= (Button) findViewById(R.id.btnSubmit);
btnSubmit.setOnClickListener(new OnClickListener(){
 

public void onClick(View v){
// Toast.makeText(QuestionScreen.this, "Correct!!!!!!!!", Toast.LENGTH_SHORT).show();
int sID=radioGAns.getCheckedRadioButtonId();
if(sID==R.id.radioA){
//Toast.makeText(QuestionScreen.this, "Correct!!!!!!!!", Toast.LENGTH_SHORT).show();
showOneButtonDialog();
}
else 
//Toast.makeText(QuestionScreen.this, "Wrong!!!!!!!!", Toast.LENGTH_SHORT).show();
showOneButtonDialog2();
}
 
});
}

private void showOneButtonDialog(){
	AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
	dialogBuilder.setTitle("Answer");
	dialogBuilder.setMessage("You Are Correct!");
	AlertDialog alertDialog = dialogBuilder.create();
	alertDialog.show();
	SharedPreferences settings = getSharedPreferences("prefs_tamagotchi", Activity.MODE_PRIVATE);
    SharedPreferences.Editor editor = settings.edit();
    SharedPreferences settingsMoney = getSharedPreferences("prefs_money", Activity.MODE_PRIVATE);
    SharedPreferences.Editor editorMoney = settingsMoney.edit();
    editorMoney.putInt("player_money", 10);
    editorMoney.commit();
    editor.putString("game_state", "answerCorrect");
    editor.commit();
		
	}


private void showOneButtonDialog2(){
	AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
	dialogBuilder.setTitle("Answer");
	dialogBuilder.setMessage("Sorry, Try Again");
	AlertDialog alertDialog = dialogBuilder.create();
	alertDialog.show();
	
}
 
@Override
public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
 
return true;
}

}