package pl.itcrowd.tutorials.cditutorial.basics.services;

import pl.itcrowd.tutorials.cditutorial.basics.annotations.Enhanced;

import java.util.Date;

/**
 * User: Rafal Gielczowski
 * Date: 2/19/13 Time: 10:50 AM
 */
@Enhanced
public class BusinessGreeterEnhancedImpl implements BusinessGreeter {

    @Override
    public String greeter()
    {
        return "Hello! Now is: "+new Date();
    }
}
