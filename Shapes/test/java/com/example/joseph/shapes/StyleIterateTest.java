package com.example.joseph.shapes;

import android.content.Context;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Joseph on 8/7/2016.
 */
public class StyleIterateTest {

    @Test
    public void iterateTest(){
        try {
            System.out.println("-----");
            System.out.println("Testing style iterator!");
            System.out.println("-----");
            //Assert that style can be passed and looped using the style iterator
            StyleIterate sI = new StyleIterate();
            assertEquals(1, sI.iterate(0));
            System.out.println("Asserting returns 1");
            assertEquals(1, sI.iterate(3));
            //If assertions pass, then assume the iterator for style is correct
            System.out.println("Testing loops");
            System.out.println("Style iterate works.");

        } catch (Exception e){
            System.out.println("Error! Iterate test did not work!");
        }
    }
}
