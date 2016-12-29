//-----Kendrick Kwok -----//
//-----CSC 413 -----//
//-----6/23/16 -----//
//-----Assignment #2 -----//
//-----912351666 -----//
//-----kendrick.j.kwok@gmail.com -----//

package com.example.joseph.test2;

//imports to be used in the program
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class Question1 extends AppCompatActivity {

    //variables declared in the program
    String token;
    String question;
    String answer_a;
    String answer_b;
    String answer_c;
    String answer_d;
    String answer_e;
    String answer_f;
    String correct;
    String myToken = "undefined";
    String[] stringArray = new String[5];
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        //declare text apps for
        final RequestQueue queue = Volley.newRequestQueue(this);
        final TextView q = (TextView) findViewById(R.id.textView3);
        final TextView a = (Button) findViewById(R.id.button2);
        final TextView b = (Button) findViewById(R.id.button3);
        final TextView c = (Button) findViewById(R.id.button5);
        final TextView d = (Button) findViewById(R.id.button4);
        final TextView e = (Button) findViewById(R.id.radioButton);
        final TextView f = (Button) findViewById(R.id.radioButton19);

        //declare radio buttons to see if it is clickable
        final RadioButton a1 = (RadioButton) findViewById(R.id.button2);
        final RadioButton b1 = (RadioButton) findViewById(R.id.button3);
        final RadioButton c1 = (RadioButton) findViewById(R.id.button5);
        final RadioButton d1 = (RadioButton) findViewById(R.id.button4);
        final RadioButton e1 = (RadioButton) findViewById(R.id.radioButton);
        final RadioButton f1 = (RadioButton) findViewById(R.id.radioButton19);


        //URL requested -- kwok as username and password 912351666
        String url = "http://sfsuswe.com/413/get_token/?username=kkwok&password=912351666";

        //Request JsonObjectRequest, ask for four parameters
        JsonObjectRequest getRequest = new JsonObjectRequest
                (Request.Method.GET, url, null,
                        new Response.Listener<JSONObject>() {

                            //Try to get response
                            public void onResponse(JSONObject response) {

                                Log.d("Responding", response.toString());

                                try {
                                    //parse the token to find token number
                                    JSONObject tokenName = new JSONObject(response.toString());
                                    token = tokenName.getString("token");
                                    Log.d("This is the token: ", token);

                                    //use the token to input into URL, get questions
                                    String myURL = "http://sfsuswe.com/413/get_question/?token=" + token;

                                    //GET params to get the url.
                                    JsonObjectRequest getQuestions = new JsonObjectRequest
                                            (Request.Method.GET, myURL, null,
                                                    new Response.Listener<JSONObject>() {
                                                        public void onResponse(JSONObject response1) {
                                                            Log.d("Responding1", response1.toString());
                                                            Toast.makeText(Question1.this, "Found token and Questions", Toast.LENGTH_SHORT).show();

                                                            try {
                                                                //parse and locate certain keywords::
                                                                // ---------questions and answers
                                                                JSONObject question1 = new JSONObject(response1.toString());
                                                                JSONObject answer_a1 = new JSONObject(response1.toString());
                                                                JSONObject answer_b1 = new JSONObject(response1.toString());
                                                                JSONObject answer_c1 = new JSONObject(response1.toString());
                                                                JSONObject answer_d1 = new JSONObject(response1.toString());
                                                                JSONObject answer_e1 = new JSONObject(response1.toString());
                                                                JSONObject answer_f1 = new JSONObject(response1.toString());
                                                                JSONObject correct1 = new JSONObject(response1.toString());

                                                                //assign the variable names
                                                                question = question1.getString("question");
                                                                answer_a = answer_a1.getString("answer_a");
                                                                answer_b = answer_b1.getString("answer_b");
                                                                answer_c = answer_c1.getString("answer_c");
                                                                answer_d = answer_d1.getString("answer_d");
                                                                answer_e = answer_e1.getString("answer_e");
                                                                answer_f = answer_f1.getString("answer_f");
                                                                correct = correct1.getString("correct");

                                                                //sett text to the new variable
                                                                q.setText("Question 1: " + question);
                                                                a.setText("A. " + answer_a);
                                                                b.setText("B. " + answer_b);
                                                                c.setText("C. " + answer_c);
                                                                d.setText("D. " + answer_d);
                                                                e.setText("E. " + answer_e);
                                                                f.setText("F. " + answer_f);


                                                                //throw exception if there is problem
                                                            } catch (JSONException exception) {
                                                                Toast.makeText(Question1.this, "ERROR", Toast.LENGTH_SHORT).show();
                                                            }
                                                        }
                                                    },
                                                    //Error Listener, get error message
                                                    new Response.ErrorListener() {
                                                        @Override
                                                        public void onErrorResponse(VolleyError error) {
                                                            Log.d("Error.Response1", error.getMessage());
                                                        }
                                                    });
                                    queue.add(getQuestions);

                                    myToken = token;
                                    //catch the error
                                } catch (JSONException exception) {
                                    Toast.makeText(Question1.this, "ERROR", Toast.LENGTH_SHORT).show();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d("Error.Response", error.getMessage());
                            }
                        });
        //add getRequest to the Queue
        queue.add(getRequest);

        //Declare button called submitting
        Button submitting = (Button) findViewById(R.id.button12);
        submitting.setOnClickListener(new View.OnClickListener() {
            @Override
            //If correct answer is A and the button A is checked then increment score by one..
            //----and the so on.
            public void onClick(View v) {

                stringArray[0] = question;
                if (correct.contains("a") && a1.isChecked()) {
                    score++;
                }
                if (correct.contains("b") && b1.isChecked()) {
                    score++;
                }
                if (correct.contains("c") && c1.isChecked()) {
                    score++;
                }
                if (correct.contains("d") && d1.isChecked()) {
                    score++;
                }
                if (correct.contains("e") && e1.isChecked()) {
                    score++;
                }
                if (correct.contains("f") && f1.isChecked()) {
                    score++;
                }

                //Send over the scores to the next activity
                Intent intent = new Intent(Question1.this, Question2.class);
                intent.putExtra("score", score);
                startActivity(intent);

            }

        });
    }
}


