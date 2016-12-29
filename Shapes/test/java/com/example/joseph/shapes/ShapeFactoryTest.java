package com.example.joseph.shapes;

import android.content.Context;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Joseph on 8/3/2016.
 */

public class ShapeFactoryTest {
    Context context;

    //Testing the getShape methods
    @Test
    public void TestCircleGetShapes(){
        System.out.println("-----");
        System.out.println("Testing ShapeFactory getShape method.");
        System.out.println("-----");

        try{
            ShapeFactory shapes = new ShapeFactory();

            Shape testCircle = ShapeFactory.getCircle(context);
            //if CIRCLE is retrieved from testCircle's method, assume ShapeFactory is correct
            assertEquals("ShapeFactory transported circle to shape successfully" ,testCircle.getShapeType(), "CIRCLE");
            System.out.println("ShapeFactory transported circle to shape successfully");

        }
        catch(Exception e) {
            System.out.println("Transfer from ShapeFactory to Shapes failed");
        }
    }


    @Test
    public void TestRectangleGetShapes(){
        System.out.println("-----");
        System.out.println("Testing ShapeFactory getShape method.");
        System.out.println("-----");

        try{
            Shape testRectangle = ShapeFactory.getRectangle(context);
            //If "RECTANGLE" is acheived from getShapeType method, assume that method is correct
            assertEquals(testRectangle.getShapeType(), "RECTANGLE");
            System.out.println("ShapeFactory transported rectangle to shape successfully");
        }
        catch(Exception e) {
            System.out.println("Transfer from ShapeFactory to Shapes failed");
        }
    }
}