///////------------Kendrick Kwok ------------------------//////////
///////------------CSC 413 ------------------------//////////
///////------------912351666 ------------------------//////////
///////------------7/12/16 ------------------------//////////
///////------------ShapeFactory.java ------------------------//////////

package com.example.joseph.shapes;

import android.content.Context;
import android.graphics.Paint;

import com.example.joseph.shapes.Shape;

/**
 * Created by Joseph on 6/29/2016.
 */


//ShapeFactory that gets the shape
//--if passed in "SHAPE_CIRCLE", return object CIRCLE
//--if passed in "SHAPE_RECTANGLE" return object RECTANGLE

public class ShapeFactory extends AbstractFactory {

    public static Shape getCircle(Context context) {

        return new Circle(context, paint, paint1);
    }

    public static Shape getRectangle(Context context) {

        return new Rectangle(context, paint, paint1);
    }
}
