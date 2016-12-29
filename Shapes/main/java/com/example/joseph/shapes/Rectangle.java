///////------------Kendrick Kwok ------------------------//////////
///////------------CSC 413 ------------------------//////////
///////------------912351666 ------------------------//////////
///////------------7/12/16 ------------------------//////////
///////------------Rectangle.java ------------------------//////////

package com.example.joseph.shapes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.joseph.shapes.Shape;

import java.util.Random;

/**
 * Created by Joseph on 6/29/2016.
 */
public class Rectangle extends Shape {

    public Rectangle(Context context) {
        super(context);
       // this.setWillNotDraw(false);
    }
    public Rectangle(Context context, Paint p, Paint p1) {
        super(context);
        //Two object paintings. One is to paint the FILL, one is to paint the BORDER.
        paint = p;
        painting = p1;
    }

    Random random = new Random();
    float settingAlpha;
    Paint paint;
    Paint painting;

    @Override
    public void onDraw(Canvas canvas){


        //get dimentions of the rectangle
        int w = getWidth();
        int h = getHeight();

        //randomize the numbers for the coordinates of rectangle
        int x1 = random.nextInt(w);
        int y1 = random.nextInt(h);
        int wrange = random.nextInt(w-x1);
        int yrange = random.nextInt(h-y1);

        //setting the parameters of the rectangle being drawn
        canvas.drawRect(x1, y1, x1+wrange, y1+yrange, paint);
        canvas.drawRect(x1, y1, x1+wrange, y1+yrange, painting);
    }

    public String getShapeType(){
        return ("RECTANGLE");
    }
}
