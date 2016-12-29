///////------------Kendrick Kwok ------------------------//////////
///////------------CSC 413 ------------------------//////////
///////------------912351666 ------------------------//////////
///////------------7/12/16 ------------------------//////////
///////------------MainActivity.java ------------------------//////////



package com.example.joseph.shapes;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    //Declaration of style
    int style = 0;

    //Iterator instance declaration
    StyleIterate iterate = new StyleIterate();

    //Declaration of the vector
    Vector<Shape> shapeVector = new Vector<Shape>();


    //Count how many circles and rectangles to set view for text
    int circleCount;
    int rectangleCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //first set the content View to main
        setContentView(R.layout.activity_main);

        //Hide the action Bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();


        //Declaring relative View
        final RelativeLayout shapeLayout = (RelativeLayout) findViewById(R.id.view1);

        // widget declarations
        Button circleButton = (Button) findViewById(R.id.button);
        Button rectangleButton = (Button) findViewById(R.id.button2);
        Button clearButton = (Button) findViewById(R.id.button3);
        Button styleButton = (Button) findViewById(R.id.button4);

        //declaration of text views
        final TextView circleTv = (TextView) findViewById(R.id.textView);
        final TextView rectangleTv = (TextView) findViewById(R.id.textView2);
        final TextView styleTv = (TextView) findViewById(R.id.textView3);

        //Clicks on style button, returns a numbered shape
        styleButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                int style1 = iterate.iterate(style);
                style = style1;

                if (style1 == 1){
                    styleTv.setText("Magenta and Black");
                }
                if (style1 == 2 ) {
                    styleTv.setText("Red and Blue");
                }
                if (style1 == 3){
                    styleTv.setText("Black and Yellow");
                }
            }
        });

        //Clicks on circle button, returns shape and sets the view to be the customizable
        circleButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //adjust transparency of object
                adjustShapesAlpha();
                ShapeFactory sf = AbstractFactory.getShapeFactory(style);
                //get shape from shapefactory and return circle object
                Shape circle = sf.getCircle(MainActivity.this);
                //add the circle to the vector
                shapeVector.add(circle);
                //add the view of the circle and display in canvas
                shapeLayout.addView(circle);
                //update text view with shape count
                updateShapeCount();
            }
        });

        //display attributes when clicking rectangle button
        rectangleButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //adjust transparency of object
                adjustShapesAlpha();
                //get shape from shapefactory and return rectangle object
                ShapeFactory sf = AbstractFactory.getShapeFactory(style);
                //get shape from shape factory and return rectangle object
                Shape rectangle = sf.getRectangle(MainActivity.this);
                //add rectangle to shape vector
                shapeVector.add(rectangle);
                //add view to shape layout
                shapeLayout.addView(rectangle);
                //update text view with shape count
                updateShapeCount();

            }
        });

        //declare attributes to clicking on clear button
        clearButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                shapeLayout.removeAllViews();
                shapeVector.clear();
                rectangleTv.setText(shapeVector.size() + " Rectangles");
                circleTv.setText(shapeVector.size() + " Circles");

            }
        });
    }

    public void updateShapeCount() {

        //declaration of text views
        TextView circleTv = (TextView) findViewById(R.id.textView);
        TextView rectangleTv = (TextView) findViewById(R.id.textView2);

        circleCount = 0;
        rectangleCount = 0;

        //looping through the vector to see which one has circles and which one has rectangles
        //if getShapeType brings back circle, increment circle count by one
        //if getShapeType brings back rectangle, increment rectangle count by one
        for (int index = 0; index < shapeVector.size(); index++)

            //if shape count is e
            if (shapeVector.elementAt(index).getShapeType() == "CIRCLE") {
                circleCount++;
            }
        for (int index = 0; index < shapeVector.size(); index++)

            if (shapeVector.elementAt(index).getShapeType() == "RECTANGLE") {
                rectangleCount++;
            }

        rectangleTv.setText(rectangleCount + " Rectangles");
        circleTv.setText(circleCount + " Circles");
    }

    //if float is  100% non-transparent, reduce the transitions by fifty percent until its gone
    public void adjustShapesAlpha() {

        for (int index = 0; index < shapeVector.size(); index++) {
            if (shapeVector.elementAt(index).getAlpha() == (float)1) {
                shapeVector.elementAt(index).setAlpha((float) .6);
            }

                else if (shapeVector.elementAt(index).getAlpha() == (float) .6) {
                    shapeVector.elementAt(index).setAlpha((float) .3);
                }
                    else if (shapeVector.elementAt(index).getAlpha() == (float) .3) {
                        shapeVector.elementAt(index).setAlpha((float) 0);
                        shapeVector.removeElementAt(index);
                        index=index-1;
                    }
            }
        }
}
