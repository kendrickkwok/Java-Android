package com.example.joseph.shapes;
import android.content.Context;
import android.graphics.Canvas;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Created by Joseph on 8/8/2016.
 */
public class CircleClass {

    Context context;
    Canvas canvas;

    //Test if circle can be constructed
    @Test
    public void testCircle(){
        try {
            System.out.println("-----");
            System.out.println("Testing Circle Class...");
            System.out.println("-----");
            //ShapeFactory sf = new ShapeFactory();

            // /get shape from shapefactory and return circle object
            //Shape circle = sf.getCircle(context);
            Circle circle = new Circle(context);
            assertEquals("CIRCLE", circle.getShapeType());
            System.out.println("Circle constructed successfuly");
        }
        catch(Exception e){
            System.out.println("Error! Circle cannot be constructed!");

        }
    }
}
