//-----Kendrick Kwok -----//
//-----CSC 413-----//
//-----6/23/16 -----//
//-----Assignment #2 -----//
//-----912351666 -----//
//-----kendrick.j.kwok@gmail.com -----//

package com.example.joseph.test2;

//imports used in the program
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import static com.android.volley.Request.*;

public class MainActivity extends AppCompatActivity {
    //Declare edit texts and one button in our program

    private static Button login_button;
    private static EditText user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginButton();
    }

    //LoginButton, click button to gain access to the application
    public void LoginButton() {
        //casting variables
        login_button = (Button)findViewById(R.id.button);

        //interactive button allows user to go to next activity and can trigger tokens to be released
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Successful login", Toast.LENGTH_SHORT).show();
                Intent myIntent= new Intent(v.getContext(),Question1.class);

                startActivity(myIntent);
            }
        });
    }
}




