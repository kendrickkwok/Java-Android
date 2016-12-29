package com.example.joseph.shapes;
import android.content.Context;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Joseph on 8/3/2016.
 */
public class ShapeTest {

    private static final float testAlpha = 1;
    Context context;

    @Test
    public void TestSetGetShapeAlpha(){
        try {
            System.out.println("-----");
            System.out.println("Testing set and get Alpha in Shapes");
            System.out.println("-----");

            Shape shape = new Circle(context);
            Shape shape1 = new Rectangle(context);

            //Setting alpha to 1
            shape.setShapeAlpha(testAlpha);
            System.out.println("Circle is being set to Alpha. Testing Alpha...");
            shape1.setShapeAlpha(testAlpha);
            System.out.println("Rectangle is being set to Alpha. Testing Alpha...");
            //Sets alpha to 1
            assertEquals(shape.getShapeAlpha(), testAlpha, 1);
            System.out.println("Alpha works on Circle");
            //Tests ability to retrieval alpha being 1
            assertEquals(shape1.getShapeAlpha(), testAlpha, 1);
            System.out.println("Alpha works on Rectangle");
        } catch (Exception e){
            System.out.println("Alpha does not work correctly!");
        }
    }
}


/*
public class PersonTest {
    private static final String TEST_FIRST_NAME = "some name";

    Person target;

    // ...
    @Test
    public void testSetFirstName() {
        target.setFirstName(TEST_FIRST_NAME);
        Assert.assertEquals(target.getFirstName(), TEST_FIRST_NAME);
    }
}



    //get and setShape alpha that lets user retrieve and set transparencies in class
    public void setShapeAlpha(float alpha){
        settingAlpha = alpha;
    }
    public float getShapeAlpha(){
        return settingAlpha;
    }
 */