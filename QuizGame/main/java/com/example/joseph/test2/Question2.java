//-----Kendrick Kwok -----//
//-----CSC 413 -----//
//-----6/23/16 -----//
//-----Assignment #2 -----//
//-----912351666 -----//
//-----kendrick.j.kwok@gmail.com -----//

package com.example.joseph.test2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
import com.example.joseph.test2.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Question2 extends AppCompatActivity {
    //Declared variables
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        //declaring button ID to be used in the program
        final RequestQueue queue = Volley.newRequestQueue(this);

        final RadioButton a1 = (RadioButton) findViewById(R.id.button6);
        final RadioButton b1 = (RadioButton) findViewById(R.id.button7);
        final RadioButton c1 = (RadioButton) findViewById(R.id.button8);
        final RadioButton d1= (RadioButton) findViewById(R.id.button9);
        final RadioButton e1 = (RadioButton) findViewById(R.id.button10);
        final RadioButton f1 = (RadioButton) findViewById(R.id.radioButton20);

        final TextView q = (TextView) findViewById(R.id.textView6);
        final TextView a = (Button) findViewById(R.id.button6);
        final TextView b = (Button) findViewById(R.id.button7);
        final TextView c = (Button) findViewById(R.id.button8);
        final TextView d = (Button) findViewById(R.id.button9);
        final TextView e = (Button) findViewById(R.id.button10);
        final TextView f = (Button) findViewById(R.id.radioButton20);

        //URL requested -- kwok as username and password 912351666
        String url = "http://sfsuswe.com/413/get_token/?username=kkwok&password=912351666";

        //Request JsonObject Requestt, ask for four parameters
        JsonObjectRequest getRequest2 = new JsonObjectRequest
                (Request.Method.GET, url, null,
                        new Response.Listener<JSONObject>() {
                            //looking for responses
                            public void onResponse(JSONObject response) {

                                Log.d("Responding", response.toString());

                                try {
                                    //parse the token to find token numbers
                                    JSONObject tokenName = new JSONObject(response.toString());
                                    token = tokenName.getString("token");
                                    Log.d("This is the token: ", token);

                                    //use the tokens to input into URL, get questions
                                    String myURL = "http://sfsuswe.com/413/get_question/?token=" + token;
                                    //GET params to get the url.
                                    JsonObjectRequest getQuestions2 = new JsonObjectRequest
                                            (Request.Method.GET, myURL, null,
                                                    new Response.Listener<JSONObject>() {

                                                        public void onResponse(JSONObject response1) {
                                                            Log.d("Responding1", response1.toString());

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
                                                                Toast.makeText(Question2.this, "Token given and Questions received", Toast.LENGTH_SHORT).show();

                                                                //assign the variable names
                                                                question = question1.getString("question");
                                                                answer_a = answer_a1.getString("answer_a");
                                                                answer_b = answer_b1.getString("answer_b");
                                                                answer_c = answer_c1.getString("answer_c");
                                                                answer_d = answer_d1.getString("answer_d");
                                                                answer_e = answer_e1.getString("answer_e");
                                                                answer_f = answer_f1.getString("answer_f");
                                                                correct = correct1.getString("correct");
                                                                Log.d("answer_a =", answer_a);
                                                                Log.d("the correct string =", correct);

                                                                //set text to the new varaible names
                                                                q.setText("Question 2: " + question);
                                                                a.setText("A. " + answer_a);
                                                                b.setText("B. " + answer_b);
                                                                c.setText("C. " + answer_c);
                                                                d.setText("D. " + answer_d);
                                                                e.setText("E. " + answer_e);
                                                                f.setText("F. " + answer_f);

                                                                //throw exception if there is problem
                                                            } catch (JSONException exception) {
                                                                Toast.makeText(Question2.this, "ERROR", Toast.LENGTH_SHORT).show();
                                                            }
                                                        }
                                                    },
                                                    new Response.ErrorListener() {
                                                        @Override
                                                        public void onErrorResponse(VolleyError error) {
                                                            //Error Listener, get error message
                                                            Log.d("Error.Response1", error.getMessage());
                                                        }
                                                    });
                                    queue.add(getQuestions2);

                                    myToken = token;
                                    //catch the error
                                } catch (JSONException exception) {
                                    Toast.makeText(Question2.this, "ERROR", Toast.LENGTH_SHORT).show();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d("Error.Response", error.getMessage());
                            }
                        });
        queue.add(getRequest2);

        //Declare button called submitting
        Button submitting = (Button) findViewById(R.id.button13);
        submitting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle b = getIntent().getExtras();
                int score = b.getInt("score");

                Log.d("correct value @ 1 = ", correct);

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

                //Send over the scores to the next activity using Intent
                Intent intent = new Intent(Question2.this, Question3.class);
                intent.putExtra("score", score);
                startActivity(intent);

            }

        });
    }
}