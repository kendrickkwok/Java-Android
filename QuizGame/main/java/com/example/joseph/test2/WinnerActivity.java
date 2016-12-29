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
        import android.widget.TextView;

public class WinnerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winner);
        //Receive the bundle with the score
        Bundle b = getIntent().getExtras();
        final int score = b.getInt("score");
        getScore(score);
    }

    public void getScore(int score){
        TextView t = (TextView) findViewById(R.id.textView5);

        //Big switch statement. Depending on what you score on the quiz that has been passed
        //--from activity to activity, will be the specific case
        switch (score) {
            case 0:
                t.setText("0/5. Go study stupid");
                break;
            case 1:
                t.setText("1/5. You suck!");
                break;
            case 2:
                t.setText("2/5. Thats okay!");
                break;
            case 3:
                t.setText("3/5. Okay that's good!");
                break;
            case 4:
                t.setText("4/5. What? Oh my!");
                break;
            case 5:
                t.setText("5/5. Congradulations!");
                break;
            }
        }
    }

