package com.example.game;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
//import android.preference.PreferenceManager;
import android.util.Log;
//import android.os.Handler;
//import android.content.Intent;
//import android.content.res.Resources;

/**
 * QuestionLoader.java
 * 
 * Loads current question from json file and provides methods to return strings
 * of questions, answers, and location of the correct answer.
 * 
 * Note: Current version only loads one question from JSON file as code has yet
 * to be tested on display.
 * 
 */

public class QuestionLoader implements Runnable {
	private static final String TAG_QUESTIONS = "Questions";
	private static final String TAG_QUESTION = "Question";
	private static final String TAG_CORRECTANSWER = "CorrectAnswer";
	private static final String TAG_ANSWERS = "Answers";
	private static final String TAG_ANSWER = "Answer";

	// Questions and Answer jsonArray
	private JSONObject aQuestion;
	private static JSONArray questionList = null;
	private JSONArray answerList;
	private List<Integer> wrongAnswers = new ArrayList<Integer>();
	
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
	}

	/**
	 * Getter method that returns the current set question.
	 * 
	 * @return Current question to be displayed
	 */
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
	 * Getter method
	 * 
	 * @return An array of answer strings
	 */
	public String[] getAnswers() {
		
		return answers;
	}
	
	public void wrongAnswer(){
		wrongAnswers.add(currentQuestion);
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
		//mHandler.sendEmptyMessage(0);
		Message msg = new Message();
		mHandler.sendEmptyMessageDelayed(0, 600000);
	}

}

