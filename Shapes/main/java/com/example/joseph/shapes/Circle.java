///////------------Kendrick Kwok ------------------------//////////
///////------------CSC 413 ------------------------//////////
///////------------912351666 ------------------------//////////
///////------------7/12/16 ------------------------//////////
///////------------Circle.java ------------------------//////////

package com.example.joseph.shapes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.joseph.shapes.Shape;

import java.util.Random;

/**
 * Created by Joseph on 6/29/2016.
 */
public class Circle extends Shape {

    Random random = new Random();
    float settingAlpha;
    Paint paint;
    Paint painting;

    public Circle(Context context) {
        super(context);
    }

    public Circle(Context context, Paint p, Paint p1) {
        super(context);
        //Two object paintings. One is to paint the FILL, one is to paint the BORDER.
        paint = p;
        painting = p1;
    }

    @Override
    public void onDraw(Canvas canvas){

        int w = getWidth();
        int h = getHeight();

        //randomizing numbers of the weight and the height
        int x1 = random.nextInt(w);
        int y1 = random.nextInt(h);

        //if one side to the radius of the circle is smallest, take that side and draw circle using that side.
        //---This is to force the circle to be in the parameters of the canvas
        int d1 = y1;
        int d2 = h - y1;
        int d3 = x1;
        int d4 = w - x1;

        //finding most minimum side and drawing the parameters
        int dmin = Math.min( Math.min(d1, d2), Math.min(d3, d4));
        int radius = random.nextInt(dmin);

        canvas.drawCircle(x1, y1, radius, paint);
        canvas.drawCircle(x1, y1, radius, painting);

    }

    public String getShapeType(){
        return ("CIRCLE");
    }
}
