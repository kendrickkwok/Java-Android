package com.example.joseph.shapes;

import android.content.Context;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Joseph on 8/8/2016.
 */
public class RectangleTest {

    Context context;

    //Testing rectangle to see if rectangle can be constructed
    @Test
    public void testRectangle(){

        try {
            System.out.println("-----");
            System.out.println("Testing Rectangle Class...");
            System.out.println("-----");

            Rectangle rect = new Rectangle(context);
            assertEquals("RECTANGLE", rect.getShapeType());
            //If able to evoke getShapeType() method in rect1, print out message
            System.out.println("Rectangle constructed successfuly");
        }
        catch(Exception e){
            System.out.println("Error! Rectangle cannot be constructed!");

        }
    }
}
