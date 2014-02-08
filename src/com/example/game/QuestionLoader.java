package com.example.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.ArrayList;

import org.json.JSONObject;
import org.json.JSONArray;

import android.app.Activity;
import android.os.Handler;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

/*Class that loads the questions from json file and provides question and answers
 * for question screen.
 */

public class QuestionLoader extends Activity {
	
	private static final String TAG_QUESTION = "Question";
	private static final String TAG_CORRECTANSWER = "CorrectAnswer";
	private static final String TAG_ANSWERS = "Answer";
	private static final String TAG_QUESTIONS = "Questions";

	//Questions and Answer jsonArray
	private JSONArray questions;
	private ArrayList<String> questionList = new ArrayList<String>();	
	
	BufferedReader bReader = null;
	private static JSONArray quesList = null;
	
	public void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_screen);
        
        Thread thread = new Thread() {
        	public void run() {
		        try {
		        	Thread.sleep(3*1000);
			        finish();
			        loadQuestions();
	        	} catch (Exception e) {
	        	} 
        	}
        };
        thread.start();

     }    
	
	//Class function that loads the json file as a json object
    private void loadQuestions() throws Exception {
    	try {
		InputStream questions = this.getBaseContext().getResources()
				.openRawResource(R.raw.question);
		bReader = new BufferedReader(new InputStreamReader(questions));
		StringBuilder quesString = new StringBuilder();
		String aJsonLine = null;
		while ((aJsonLine = bReader.readLine()) != null) {
			quesString.append(aJsonLine);
		}
		Log.d(this.getClass().toString(), quesString.toString());
		JSONObject quesObj = new JSONObject(quesString.toString());
		quesList = quesObj.getJSONArray("TAG_QUESTIONS");
		Log.d(this.getClass().getName(),
				"Num Questions " + quesList.length());
    	} catch (Exception e){
    		
    	} finally {
			try {
				bReader.close();
			} catch (Exception e) {
				Log.e("", e.getMessage().toString(), e.getCause());
			}
			}
    	

    }
    
    
    //Returns Question String
    public void getQuestion(){
    	
    }
    
    //Method to return Answer String 1
    public void getAnswer1(){
    	
    }
    
    //Method to return Answer String 2
    public void getAnswer2(){
    	
    }
    
    //Method to return Answer String 3
	public void getAnswer3(){
	
	}
	
    //Method to return Answer String 4
	public void getAnswer4(){
	
	}
	
	//Method that returns integer of correct answer.
    public int getCorrectAnswer(){
    return 0;	
    }
    
    private static JSONArray getQuesList() {
    	return quesList;
    }
	
	

}
