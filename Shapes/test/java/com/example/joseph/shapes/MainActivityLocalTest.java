package com.example.joseph.shapes;

import android.content.Context;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Created by Joseph on 8/3/2016.
 */
public class MainActivityLocalTest {

    //declarations for this test
    Context context;
    boolean flag;
    MainActivity mv = new MainActivity();
    Rectangle rect = new Rectangle(context);
    Circle circ = new Circle(context);

    //method used in updateCount() method. Check if the shapes are rectangle or circle
    public boolean check(int i) {
        if ("RECTANGLE" == mv.shapeVector.elementAt(i).getShapeType()) {
            return true;
        }
        if ("CIRCLE" == mv.shapeVector.elementAt(i).getShapeType()) {
            return true;
        }
        return false;
    }

    //Tests if the program can alter the Alpha in the shapes
    @Test
    public void TestAdjustShapeAlpha() {

        try {
            System.out.println("-----");
            System.out.println("Adjusting shapes in Alpha");
            System.out.println("-----");
            //add Rectangle into vector
            mv.shapeVector.add(rect);
            System.out.println("Adding test shape into vector");
            //call alpha to adjust shapes
            mv.adjustShapesAlpha();
            //shape given alpha of 1, if this is set, assume i is correct
            assertEquals(1, mv.shapeVector.elementAt(0).getShapeAlpha(), 1);
            System.out.println("Method called. Shape intially set to Alpha of 1");
            System.out.println("Adjust Shape Alpha successful!");
        }
            catch(Exception e){
                System.out.println("Error! Unable to set alpha of the shapes!");
        }

    }

    @Test

    public void TestUpdateShapeCount() {
        try {
            System.out.println("-----");
            System.out.println("Testing UpdateShapeCount Method...");
            System.out.println("-----");
            //add rectangles in vector
            mv.shapeVector.add(rect);
            mv.shapeVector.add(rect);
            System.out.println("Adding two test rectangles into vector..");
            //adding circle in test
            mv.shapeVector.add(circ);
            System.out.println("Adding test circle into vector..");

            //Loop through vector, if circle or rectangle is found, boolean is true and
            //--marked as detected.
            for (int index = 0; index < mv.shapeVector.size(); index++) {
                assertTrue(check(index));
                System.out.println(mv.shapeVector.elementAt(index).getShapeType() + " detected.");
            }
            //If successfully looped, print out update shape count message
            System.out.println("Update Shape count successful!");
            System.out.println();
        } catch (Exception e){
            System.out.println("Failed to update shape count!");
        }
    }

    }

