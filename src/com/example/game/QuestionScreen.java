package com.example.game;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

import android.widget.Toast;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
//import android.app.ProgressDialog;
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
//ProgressDialog progressDialog;
QuestionLoader questionLoader;

private RadioGroup radioGAns;
private RadioButton radioAns;
private Button btnSubmit;
private String question;
private String[] answers;
private int correctAnswer;
private int tries =0;
//private int questionsAnswered = 0;
private TextView t;

private RadioButton answer1;
private RadioButton answer2;
private RadioButton answer3;
private RadioButton answer4;

SharedPreferences questionSettings;
SharedPreferences.Editor editorQuestion;

private static long thirtyMinutes = 1800000;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
questionSettings = this.getSharedPreferences("prefs_questions", Activity.MODE_PRIVATE);
editorQuestion = questionSettings.edit();
long nxtTime = System.currentTimeMillis() - questionSettings.getLong("TIME", 0);
int waitTime = (int)((thirtyMinutes - nxtTime)/(1000*60))%60;
if(nxtTime<=thirtyMinutes){
	openAlert("WAIT","Please wait "+waitTime+" minutes",1);
}
else{
setContentView(R.layout.activity_question_screen);
//progressDialog = ProgressDialog.show(QuestionScreen.this, "",
//		"Loading...");
resetTime();
questionLoader = new QuestionLoader(getApplicationContext(), mHandler);
this.setText();}
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
	openAlert("Answer","You Are Correct!",0);
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
		openAlert("Answer","Sorry, Try Again",0);
		tries++;
	}else{
		questionLoader.wrongAnswer();
		openAlert("Answer","Max Number of tries, next question",0);
		tries=0;
		setText();
	}
	AlertDialog alertDialog = dialogBuilder.create();
	alertDialog.show();
}

private void questionBreak(){
	openAlert("BreakTime!","Time out",1);
	long time = System.currentTimeMillis();
	editorQuestion.putLong("TIME", time);
	editorQuestion.commit();
}
 
@Override
public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
	//getMenuInflater().inflate(R.menu.question_screen, menu);
return true;
}

private void openAlert(String title, String message, int finish) {
	 AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
	 dialogBuilder.setTitle(title);
	 dialogBuilder.setMessage(message);
	 if(finish==0){
	 dialogBuilder.setNeutralButton("OK",new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog,int iD) {
	            dialog.cancel();
			}
		  });} else{
			  dialogBuilder.setNeutralButton("OK",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int iD) {
			            dialog.cancel();
			            finish();
					}
				  });
	 }
	 AlertDialog alertDialog = dialogBuilder.create();
	 alertDialog.show();
}

@SuppressLint("HandlerLeak")
//Handler list to do when load json finish
Handler mHandler = new Handler(new IncomingHandlerCallback());
class IncomingHandlerCallback implements Handler.Callback{
    public boolean handleMessage(Message message) {
    	questionBreak();
        return true;
    }
}
//		public void handleMessage(android.os.Message msg) {
////			progressDialog.dismiss();
//			questionBreak();
//		  //  questionLoader.run();
////			Toast.makeText(
////					getApplicationContext(),
////					"Result JSON: Question: " + questionLoader.getQuestion()
////							+ " Answer: " + questionLoader.getAnswers()
////							+ " Correct: " + questionLoader.getCorrectAnswer(),
////					Toast.LENGTH_SHORT).show();
//		};
//	};

//For Debugging
public void resetTime(){
	editorQuestion.putLong("TIME", 0);
	editorQuestion.commit();
}

public void handleMessage(Message msg) {
	// TODO Auto-generated method stub
	
}
}