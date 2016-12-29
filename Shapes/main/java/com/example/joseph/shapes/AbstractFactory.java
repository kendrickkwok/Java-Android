///////------------Kendrick Kwok ------------------------//////////
///////------------CSC 413 ------------------------//////////
///////------------912351666 ------------------------//////////
///////------------7/12/16 ------------------------//////////
///////------------AbstractFactory.java ------------------------//////////

package com.example.joseph.shapes;

/**
 * Created by Joseph on 7/8/2016.
 */

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;

public abstract class AbstractFactory {
    //Two object paintings. One is to paint the FILL, one is to paint the BORDER.
    static Paint paint = new Paint();
    static Paint paint1 = new Paint();

    //getting shape factory
    public static ShapeFactory getShapeFactory(int style) {
        switch (style) {
            case 1:
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.MAGENTA);
                // border
                paint1.setStyle(Paint.Style.STROKE);
                paint1.setStrokeWidth(10);
                paint1.setColor(Color.BLACK);
                return new ShapeFactory();
            case 2:
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.RED);
                // border
                paint1.setStyle(Paint.Style.STROKE);
                paint1.setStrokeWidth(10);
                paint1.setColor(Color.BLUE);
                return new ShapeFactory();
            case 3:
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.BLACK);
                // border
                paint1.setStyle(Paint.Style.STROKE);
                paint1.setStrokeWidth(10);
                paint1.setColor(Color.YELLOW);
                return new ShapeFactory();

        }
        return null;
    }
}