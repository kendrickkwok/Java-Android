///////------------Kendrick Kwok ------------------------//////////
///////------------CSC 413 ------------------------//////////
///////------------912351666 ------------------------//////////
///////------------7/6/16 ------------------------//////////
///////------------Shape.java ------------------------//////////


package com.example.joseph.shapes;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by Joseph on 6/29/2016.
 */
public abstract class Shape extends View {
    //float setting alpha and context
    public Context context;
    float settingAlpha;

        public Shape (Context context) {
            super(context);
            //put context equal to the context
            this.context=context;
            //makes shapes draw repetitive times on the canvas
            this.setWillNotDraw(false);
        }

    //abstract classes to be inherited by circle and rectangle classes
    public abstract void onDraw(Canvas canvas);
    abstract String getShapeType();

    //get and setShape alpha that lets user retrieve and set transparencies in class
    public void setShapeAlpha(float alpha){
        settingAlpha = alpha;
    }
    public float getShapeAlpha(){
        return settingAlpha;
    }
}