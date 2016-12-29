package com.example.joseph.shapes;

import android.content.Context;
import android.graphics.Canvas;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;



/**
 * Created by Joseph on 8/3/2016.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public MainActivityTest() {
        super(MainActivity.class);
    }


    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }


    @SmallTest
    //Test the textViews of the program
    public void testText(){
        TextView circleTv = (TextView)getActivity().findViewById(R.id.textView);
        TextView rectangleTv = (TextView)getActivity().findViewById(R.id.textView2);
        TextView styleTv = (TextView)getActivity().findViewById(R.id.textView3);

        //if the text views are not null, assert that text view function works
        assertNotNull(circleTv);
        assertNotNull(rectangleTv);
        assertNotNull(styleTv);
    }

    //Test that buttons functions correctly
    @UiThreadTest
    public void testButton(){

        try {
            Button circleButton = (Button) getActivity().findViewById(R.id.button);
            Button rectangleButton = (Button) getActivity().findViewById(R.id.button2);
            Button clearButton = (Button) getActivity().findViewById(R.id.button3);
            Button styleButton = (Button) getActivity().findViewById(R.id.button4);

            //if the buttons are not null, assert that buttons work
            assertNotNull(circleButton);
            assertNotNull(rectangleButton);
            assertNotNull(clearButton);
            assertNotNull(styleButton);

            //performs click to see if buttons are actually clickable

            circleButton.performClick();
            rectangleButton.performClick();
            clearButton.performClick();
            styleButton.performClick();
        }

        catch (Exception e){
            System.out.println("Buttons failed");
        }
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
