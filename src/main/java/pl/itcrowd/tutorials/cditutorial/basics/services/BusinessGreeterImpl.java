package pl.itcrowd.tutorials.cditutorial.basics.services;

/**
 * User: Rafal Gielczowski
 * Date: 2/19/13 Time: 10:39 AM
 */
public class BusinessGreeterImpl implements BusinessGreeter {

    @Override
    public String greeter()
    {
        return "Hello from Business Greeter implementation!";
    }
}
