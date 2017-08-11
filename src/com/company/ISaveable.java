package com.company;

import java.util.List;

/**
 * Created by pauljava on 11/08/2017.
 *
 * Tim's solution for the isave class
 */
public interface ISaveable {

    List<String> write();
    void read(List<String>savedValues);
}
