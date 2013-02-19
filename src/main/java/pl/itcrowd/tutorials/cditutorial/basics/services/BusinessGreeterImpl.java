package pl.itcrowd.tutorials.cditutorial.basics.services;

import java.io.Serializable;

/**
 * User: Rafal Gielczowski
 * Date: 2/19/13 Time: 10:39 AM
 */
public class BusinessGreeterImpl implements BusinessGreeter, Serializable {

    @Override
    public String greeter()
    {
        return "Hello from Business Greeter implementation!";
    }
}
