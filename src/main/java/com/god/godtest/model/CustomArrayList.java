package com.god.godtest.model;

import java.util.ArrayList;

public class CustomArrayList extends ArrayList<String> {
    @Override
    public boolean add(String e) {
        if (e == null)
            return false;
        else
            return super.add(e);
    }

}
