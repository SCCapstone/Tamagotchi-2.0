package com.example.game;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.InputStream;


import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;


import android.app.Activity;
import android.content.Intent;
//import android.os.Handler;
//import android.content.Intent;
//import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

/**
 * QuestionLoader.java
 * 
 *Loads current question from json file and provides
 *methods to return strings of questions, answers, and location
 *of the correct answer.
 *
 *Note: Current version only loads one question from JSON file
 *		as code has yet to be tested on display.
 *
 */

public class QuestionLoader extends Activity {
	private static final String TAG_QUESTIONS = "Questions";
	private static final String TAG_QUESTION = "Question";
	private static final String TAG_CORRECTANSWER = "CorrectAnswer";
	private static final String TAG_ANSWERS = "Answers";
	private static final String TAG_ANSWER = "Answer";
	
	//Questions and Answer jsonArray
	private JSONObject aQuestion;
	private static JSONArray questionList = null;
	private JSONArray answerList;
	
	private String question;
	private String answers[];
    private int correctAnswer;
    
	BufferedReader bufferedReader = null;
	
	Intent menu = null;
	
	
	/**
	 * Instantiation method.
	 */
	public void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread thread = new Thread() {
        public void run() {
        try{
        Thread.sleep(3000);
        finish();
		loadQuestions();
		qaSetter();
		Intent intent = new Intent(QuestionLoader.this, QuestionScreen.class);
        QuestionLoader.this.startActivity(intent);
		}catch(Exception e){   	
        }
        }
        };
        thread.start();
	}
                
						//loadQuestions();
					//	Intent intent = new Intent(QuestionLoader.this, QuestionScreen.class);
				       // QuestionLoader.this.startActivity(intent); 					           
	
	/**
	 * Class function that reads the json file and loads as a json object
	 * Also, calls method to set question, answers array, and correct answer
	 * integer.
	 * 
	 * @throws Exception
	 */
    private void loadQuestions() throws Exception {
    	try {
    	//BufferedReader questionStreams = new BufferedReader(new InputStreamReader(getAssets().open("question.json")));	
    		
    		
    		
		InputStream questionStream = this.getBaseContext().getResources()
				.openRawResource(R.raw.question);
		bufferedReader = new BufferedReader(new InputStreamReader(questionStream));
		StringBuilder quesString = new StringBuilder();
		String aJsonLine = null;
		while ((aJsonLine = bufferedReader.readLine()) != null) {
			quesString.append(aJsonLine);
		}
		Log.d(this.getClass().toString(), quesString.toString());
		JSONObject quesObj = new JSONObject(quesString.toString());
		questionList = quesObj.getJSONArray(TAG_QUESTIONS);
				
		
		Log.d(this.getClass().getName(),
				"Num Questions " + questionList.length());
    	} catch (Exception e){
    		
    	} finally {
			try {
				bufferedReader.close();
			} catch (Exception e) {
				Log.e("buffered reader", e.getMessage().toString(), e.getCause());
			}
			}
       }
    
    /**
     * Setter method that sets the current question and answer 
     * strings.
     * @throws JSONException 
     */
    private void qaSetter() throws JSONException {
    	//Question setter from json object
    	aQuestion = questionList.getJSONObject(0); 
    	question = aQuestion.getString(TAG_QUESTION);
    	
    	answerList = aQuestion.getJSONArray(TAG_ANSWERS);
    	//fills array of answers from corresponding question json object
    	for(int i = 0; i<=3; i++){
    		answers[i] = answerList.getJSONObject(i).getString(TAG_ANSWER);
    	}
    	
    	//sets int number from current question
    	correctAnswer = aQuestion.getInt(TAG_CORRECTANSWER);
	}

	/**
	 * Getter method that returns the current set question.
	 * 
	 * @return Current question to be displayed
	 */
    public String getQuestion(){  
    //question = ""+questionList.length();
    
    try {
    	try {
			loadQuestions();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.e("something", e.getMessage().toString(), e.getCause());
			e.printStackTrace();
		}
		qaSetter();
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return question;
    }
    	
	/**
	 * Gets location for the correct answer 
	 * in the answer array.
	 * 
	 * @return current location of correct answer
	 */
    public int getCorrectAnswer(){
    return correctAnswer;	
    }
    
    /**
	 * Getter method
	 * 
	 * @return An array of answer strings
	 */
    public String[] getAnswers(){
    	return answers;
    }
	

}
