package pl.itcrowd.tutorials.cditutorial.basics.services;

import java.io.Serializable;

/**
 * User: Rafal Gielczowski
 * Date: 2/19/13 Time: 10:32 AM
 */
public class MyService implements Serializable {

    public String greeter(){
        return "Hello!";
    }

}
