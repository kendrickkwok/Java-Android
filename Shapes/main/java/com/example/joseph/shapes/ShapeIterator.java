package com.example.joseph.shapes;

import java.util.Iterator;

/**
 * Created by Joseph on 8/7/2016.
 */

//Design taken from http://www.tutorialspoint.com/design_pattern/iterator_pattern.htm
public class ShapeIterator implements Iterator{

    int index;
    MainActivity mt = new MainActivity();

    public boolean hasNext() {
        if (index < mt.shapeVector.size()) {
            return true;
        }
        return false;
    }

    public Object next() {
        if (this.hasNext()) {
            return mt.shapeVector.elementAt(index++);
        }
        return null;
    }
}
