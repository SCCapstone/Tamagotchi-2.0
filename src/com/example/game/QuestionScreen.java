package com.example.game;

import android.widget.Toast;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
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
ProgressDialog progressDialog;
QuestionLoader questionLoader;

private RadioGroup radioGAns;
private RadioButton radioAns;
private Button btnSubmit;
private String question;
private String[] answers;
private int correctAnswer;
private int tries =0;
private TextView t;

private RadioButton answer1;
private RadioButton answer2;
private RadioButton answer3;
private RadioButton answer4;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_question_screen);
progressDialog = ProgressDialog.show(QuestionScreen.this, "",
		"Loading...");
questionLoader = new QuestionLoader(getApplicationContext(), mHandler);
this.setText();
}

private void setText(){
	questionLoader.run();
	t=new TextView(this);
	t=(TextView)findViewById(R.id.textView1);

	addListenerOnButton();
	question = questionLoader.getQuestion();
	t.setText(question);
	

	answer1 = (RadioButton) findViewById(R.id.radioA);
	answer2 = (RadioButton) findViewById(R.id.radioB);
	answer3 = (RadioButton) findViewById(R.id.radioC);
	answer4 = (RadioButton) findViewById(R.id.radioD);
	answers = questionLoader.getAnswers();

	//String answer1String = answers.toString();
	answer1.setText(answers[0]);
	answer2.setText(answers[1]);
	answer3.setText(answers[2]);
	answer4.setText(answers[3]);
	correctAnswer = questionLoader.getCorrectAnswer();
}

//Hanlder list to do when load json finish
	Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			progressDialog.dismiss();
		  //  questionLoader.run();
//			Toast.makeText(
//					getApplicationContext(),
//					"Result JSON: Question: " + questionLoader.getQuestion()
//							+ " Answer: " + questionLoader.getAnswers()
//							+ " Correct: " + questionLoader.getCorrectAnswer(),
//					Toast.LENGTH_SHORT).show();
		};
	};
	
private int correctRadio(){
	if(correctAnswer==0){
		return R.id.radioA;
	}else if (correctAnswer==1){
		return R.id.radioB;
	}else if (correctAnswer==2){
		return R.id.radioC;
	}else{
		return R.id.radioD;
	}
}

private void addListenerOnButton() {	
// TODO Auto-generated method stub
radioGAns= (RadioGroup) findViewById(R.id.radioAns);;
btnSubmit= (Button) findViewById(R.id.btnSubmit);
btnSubmit.setOnClickListener(new OnClickListener(){

public void onClick(View v){
	int sID=radioGAns.getCheckedRadioButtonId();
	if(sID==correctRadio()){
	showOneButtonDialog();
	}
	else 
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
    tries=0;
    setText();
	}


private void showOneButtonDialog2(){
	AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
	if(tries==0){
		dialogBuilder.setTitle("Answer");
		dialogBuilder.setMessage("Sorry, Try Again");
		tries++;
	}else{
		questionLoader.wrongAnswer();
		dialogBuilder.setTitle("Answer");
		dialogBuilder.setMessage("Max number of tries!, Next Question");
		tries=0;
		setText();
	}
	AlertDialog alertDialog = dialogBuilder.create();
	alertDialog.show();
}
 
@Override
public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
	//getMenuInflater().inflate(R.menu.question_screen, menu);
return true;
}

}