package com.company;

import java.util.ArrayList;

/**
 * Created by pauljava on 10/08/2017.
 */
public interface IStorageMedium {

     ArrayList<String> saveToList(String values);
    void populateObject(ArrayList<String> events);
    void saveItems(ArrayList<String> items);
}
