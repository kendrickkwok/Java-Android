package com.example.joseph.shapes;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Joseph on 8/3/2016.
 */
public class AbstractFactoryTest{

    //Method tests getShapeFactory method
    @Test
    public void TestGetShapeFactory(){

        try {
            //declare abstract factory
            AbstractFactory af = new ShapeFactory();

            System.out.println("-----");
            System.out.println("Testing AbstractFactory Class..");
            System.out.println("-----");
            //ShapeFactory receives a certain style, test if the style is returned
            ShapeFactory testStyleOne = af.getShapeFactory(1);
            ShapeFactory testStyleTwo = af.getShapeFactory(2);
            ShapeFactory testStyleThree = af.getShapeFactory(3);

            //If the style returned is not null, assert that there is something and that style is
            //----successffuly transfered
            assertTrue(testStyleOne != null);
            System.out.println("Style one shape successful transer");
            assertTrue(testStyleTwo != null);
            System.out.println("Style two shape successful transer");
            assertTrue(testStyleThree != null);
            System.out.println("Style three shape successful transer");
        }

        catch (Exception e){
            System.out.println("Error in creating styles for Shape Factory");
        }
    }
/*
        @Override
        protected void tearDown() throws Exception {
            super.tearDown();
        }
        */
}
