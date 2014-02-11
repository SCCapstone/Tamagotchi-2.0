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
private String question;
private String[] answers;
private int correctAnswer;
private TextView t;

private RadioButton answer1 = null;
private RadioButton answer2 = null;
private RadioButton answer3 = null;
private RadioButton answer4 = null;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_question_screen);
t=new TextView(this);
t=(TextView)findViewById(R.id.textView1);

addListenerOnButton();
QuestionLoader questions = new QuestionLoader();
question = questions.getQuestion();
t.setText("test");

answer1 = (RadioButton) findViewById(R.id.radioA);
answer2 = (RadioButton) findViewById(R.id.radioB);
answer3 = (RadioButton) findViewById(R.id.radioC);
answer4 = (RadioButton) findViewById(R.id.radioD);
answers = questions.getAnswers();

/*
answer1.setText(answers[0]);
answer2.setText(answers[1]);
answer3.setText(answers[2]);
answer4.setText(answers[3]);
correctAnswer = questions.getCorrectAnswer();
*/
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
    editor.putString("player_money", "$10");
    editor.commit();
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