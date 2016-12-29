//-----Kendrick Kwok -----//
//-----CSC 413 -----//
//-----6/23/16 -----//
//-----Assignment #2 -----//
//-----912351666 -----//
//-----kendrick.j.kwok@gmail.com -----//

package com.example.joseph.test2;

import android.content.Intent;
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

import org.json.JSONException;
import org.json.JSONObject;

public class Question3 extends AppCompatActivity {
    //declared variables
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
        setContentView(R.layout.activity_question3);

        //declare design buttons and functionality to be used in the application
        final RequestQueue queue = Volley.newRequestQueue(this);
        final TextView q = (TextView) findViewById(R.id.textView50);
        final TextView a = (Button) findViewById(R.id.button51);
        final TextView b = (Button) findViewById(R.id.button52);
        final TextView c = (Button) findViewById(R.id.button53);
        final TextView d = (Button) findViewById(R.id.button54);
        final TextView e = (Button) findViewById(R.id.button55);
        final TextView f = (Button) findViewById(R.id.radioButton56);

        final RadioButton a1 = (RadioButton) findViewById(R.id.button51);
        final RadioButton b1 = (RadioButton) findViewById(R.id.button52);
        final RadioButton c1 = (RadioButton) findViewById(R.id.button53);
        final RadioButton d1 = (RadioButton) findViewById(R.id.button54);
        final RadioButton e1 = (RadioButton) findViewById(R.id.button55);
        final RadioButton f1 = (RadioButton) findViewById(R.id.radioButton56);

        //Declare URL to get token
        String url = "http://sfsuswe.com/413/get_token/?username=kkwok&password=912351666";

        //Declare JsonObject Requests using GET as param
        JsonObjectRequest getRequest = new JsonObjectRequest
                (Request.Method.GET, url, null,
                        new Response.Listener<JSONObject>() {

                            public void onResponse(JSONObject response) {

                                Log.d("Responding", response.toString());

                                try {
                                    JSONObject tokenName = new JSONObject(response.toString());
                                    token = tokenName.getString("token");
                                    Log.d("This is the token: ", token);

                                    String myURL = "http://sfsuswe.com/413/get_question/?token=" + token;

                                    JsonObjectRequest getQuestions = new JsonObjectRequest
                                            (Request.Method.GET, myURL, null,
                                                    new Response.Listener<JSONObject>() {

                                                        public void onResponse(JSONObject response1) {
                                                            Log.d("Responding1", response1.toString());

                                                            try {
                                                                //Declare an instance of JSONObjects
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

                                                                question = question1.getString("question");
                                                                answer_a = answer_a1.getString("answer_a");
                                                                answer_b = answer_b1.getString("answer_b");
                                                                answer_c = answer_c1.getString("answer_c");
                                                                answer_d = answer_d1.getString("answer_d");
                                                                answer_e = answer_e1.getString("answer_e");
                                                                answer_f = answer_f1.getString("answer_f");
                                                                correct = correct1.getString("correct");

                                                                Toast.makeText(Question3.this, "Tokens given and Questions Received", Toast.LENGTH_SHORT).show();

                                                                q.setText("Question 3: " + question);
                                                                a.setText("A. "+answer_a);
                                                                b.setText("B. "+answer_b);
                                                                c.setText("C. "+answer_c);
                                                                d.setText("D. "+answer_d);
                                                                e.setText("E. "+answer_e);
                                                                f.setText("F. "+answer_f);

                                                                //catch error if cannot find token
                                                            } catch (JSONException exception) {
                                                                Toast.makeText(Question3.this, "ERROR", Toast.LENGTH_SHORT).show();
                                                            }
                                                        }
                                                    },
                                                    new Response.ErrorListener() {
                                                        @Override
                                                        public void onErrorResponse(VolleyError error) {
                                                            Log.d("Error.Response1", error.getMessage());
                                                        }
                                                    });
                                    queue.add(getQuestions);

                                    myToken = token;
                                    //catch the error if cannot find token
                                } catch (JSONException exception) {
                                    Toast.makeText(Question3.this, "ERROR", Toast.LENGTH_SHORT).show();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d("Error.Response", error.getMessage());
                            }
                        });
        queue.add(getRequest);

        //Declare button called submitting
        Button submitting = (Button) findViewById(R.id.button57);
        submitting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle b = getIntent().getExtras();
                int score = b.getInt("score");

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
                Intent intent = new Intent(Question3.this, Question4.class);
                intent.putExtra("score", score);
                startActivity(intent);

            }

        });
    }
}


