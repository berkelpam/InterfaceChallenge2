package com.company;

import java.util.ArrayList;

/**
 * Created by pauljava on 10/08/2017.
 */
public class Monster implements IStorageMedium {


    private ArrayList<String> events = new ArrayList<String>();

    @Override
    public ArrayList<String> saveToList(String values) {
        events.add(values);
        return events;
    }

    @Override
    public void populateObject(ArrayList<String> events) {
        for (int i = 0; i < events.size(); i++) {
            this.events.add(events.get(i));
        }
    }
}
