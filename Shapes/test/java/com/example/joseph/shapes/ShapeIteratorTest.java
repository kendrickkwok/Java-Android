package com.example.joseph.shapes;

import android.content.Context;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Joseph on 8/4/2016.
 */
public class ShapeIteratorTest {


    public boolean check(Shape shape) {
        if ("RECTANGLE" == shape.getShapeType()) {
            return true;
        }
        if ("CIRCLE" == shape.getShapeType()) {
            return true;
        }
        return false;
    }

    //Declaration needed for unit test
    MainActivity mv = new MainActivity();
    Context context;
    Circle circle = new Circle(context);
    Rectangle rect = new Rectangle(context);

    //Testing shape iterator
    @Test
    public void TestShapeIterator(){

        System.out.println("-----");
        System.out.println("Testing iterator");
        System.out.println("-----");

        mv.shapeVector.add(circle);

        //Adding objects into the vector
        System.out.println("Adding circle");
        mv.shapeVector.add(rect);
        System.out.println("Adding rectangle");
        mv.shapeVector.add(rect);
        System.out.println("Adding rectangle");

        try {
            for (Iterator iter = mv.shapeVector.iterator(); iter.hasNext();){
                Shape shape = (Shape)iter.next();
                //If shape corresponds to "RECTANGLE" or "CIRCLE", assert that the method is true
                assertTrue(check(shape));
                System.out.println(shape.getShapeType() + " found!") ;
            }

            System.out.println("Iterator can successfuly traverse!");
        }

        catch(Exception e){
            System.out.println("Iterator failed");
        }

    }

}
