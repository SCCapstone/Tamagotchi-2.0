package com.example.game;

import java.io.BufferedReader;
<<<<<<< HEAD

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
=======
import java.io.InputStream;
import java.io.InputStreamReader;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
//import android.os.Handler;
//import android.content.Intent;
//import android.content.res.Resources;
>>>>>>> origin/huntleja

/**
 * QuestionLoader.java
 * 
<<<<<<< HEAD
 *Loads current question from json file and provides
 *methods to return strings of questions, answers, and location
 *of the correct answer.
 *
 *Note: Current version only loads one question from JSON file
 *		as code has yet to be tested on display.
 *
 */

public class QuestionLoader extends Activity {
=======
 * Loads current question from json file and provides methods to return strings
 * of questions, answers, and location of the correct answer.
 * 
 * Note: Current version only loads one question from JSON file as code has yet
 * to be tested on display.
 * 
 */

public class QuestionLoader implements Runnable {
>>>>>>> origin/huntleja
	private static final String TAG_QUESTIONS = "Questions";
	private static final String TAG_QUESTION = "Question";
	private static final String TAG_CORRECTANSWER = "CorrectAnswer";
	private static final String TAG_ANSWERS = "Answers";
	private static final String TAG_ANSWER = "Answer";
<<<<<<< HEAD
	
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
=======

	// Questions and Answer jsonArray
	private JSONObject aQuestion;
	private static JSONArray questionList = null;
	private JSONArray answerList;

	private String question;
	
	private String[] answers = new String[4];
	private int currentQuestion;
	private int correctAnswer;
	BufferedReader bufferedReader = null;
	Intent menu = null;

	Context mContext;
	Handler mHandler;
	
	SharedPreferences questionSettings;
	SharedPreferences.Editor editorQuestion;

	public QuestionLoader(Context context, Handler handler) {
		// TODO Auto-generated constructor stub
		this.mContext = context;
		this.mHandler = handler;
		questionSettings = mContext.getSharedPreferences("prefs_questions", Activity.MODE_PRIVATE);
		editorQuestion = questionSettings.edit();
		currentQuestion = questionSettings.getInt("currentQuestion", 0);
		try {
			loadQuestions();
			//qaSetter();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Class function that reads the json file and loads as a json object Also,
	 * calls method to set question, answers array, and correct answer integer.
	 * 
	 * @throws Exception
	 */
	private void loadQuestions() throws Exception {
		try {
			InputStream questionStream = mContext.getResources()
					.openRawResource(R.raw.question);
			bufferedReader = new BufferedReader(new InputStreamReader(
					questionStream));
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
		} catch (Exception e) {

		} finally {
			try {
				bufferedReader.close();
			} catch (Exception e) {
				Log.e("buffered reader", e.getMessage().toString(),
						e.getCause());
			}
		}
	}

	/**
	 * Setter method that sets the current question and answer strings.
	 * 
	 * @throws JSONException
	 */
	private void qaSetter() throws JSONException {
		editorQuestion.putInt("currentQuestion", currentQuestion);
		editorQuestion.commit();
		//Resets if reached end
		if(currentQuestion>=questionList.length())
		{
			currentQuestion = 0;
		}
		
		// Question setter from json object
		aQuestion = questionList.getJSONObject(currentQuestion);
		question = aQuestion.getString(TAG_QUESTION);
		
		answerList = aQuestion.getJSONArray(TAG_ANSWERS);
		// fills array of answers from corresponding question json object
		for (int i = 0; i <= 3; i++) {
			answers[i] = answerList.getJSONObject(i).getString(TAG_ANSWER);
		}

		// sets int number from current question
		correctAnswer = aQuestion.getInt(TAG_CORRECTANSWER);
		currentQuestion++;
>>>>>>> origin/huntleja
	}

	/**
	 * Getter method that returns the current set question.
	 * 
	 * @return Current question to be displayed
	 */
<<<<<<< HEAD
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
=======
	public String getQuestion() {
		// question = ""+questionList.length();
		return question;
	}

	/**
	 * Gets location for the correct answer in the answer array.
	 * 
	 * @return current location of correct answer
	 */
	public int getCorrectAnswer() {
		return correctAnswer;
	}

	/**
>>>>>>> origin/huntleja
	 * Getter method
	 * 
	 * @return An array of answer strings
	 */
<<<<<<< HEAD
    public String[] getAnswers(){
    	return answers;
    }
	

}
=======
	public String[] getAnswers() {
		
		return answers;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			qaSetter();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mHandler.sendEmptyMessage(0);
	}

}

>>>>>>> origin/huntleja
