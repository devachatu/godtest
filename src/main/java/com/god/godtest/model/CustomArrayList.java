package com.god.godtest.model;

import java.util.ArrayList;

/**
 * Represents a Custom implementation of Array List to exclude null values.
 * 
 * @author Deva Chaitanya
 * @version 1.0
 */
public class CustomArrayList extends ArrayList<String> {
    @Override
    public boolean add(String e) {
        if (e == null)
            return false;
        else
            return super.add(e);
    }

}
