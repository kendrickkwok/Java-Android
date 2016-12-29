package com.example.joseph.shapes;
import android.widget.TextView;

import static java.lang.System.out;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Joseph on 8/3/2016.
 */


public class StyleIterate {

    //iterator class that iterates the style button
    public int iterate(int style) {

        style++;

        //if the style reaches beyond the scope of the vector, loop back to one
        if (style == 4) {
            style = 1;
        }

        //return style
        return style;
    }
}

