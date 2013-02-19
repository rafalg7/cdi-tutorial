package pl.itcrowd.tutorials.cditutorial.basics.example;

import javax.enterprise.event.Observes;
import java.io.Serializable;
import java.util.logging.Logger;

/**
 * User: Rafal Gielczowski
 * Date: 2/19/13 Time: 12:53 PM
 */
public class ClassA implements ExampleInterface, Serializable {

    private static final Logger LOGGER = Logger.getLogger(ClassA.class.getCanonicalName());

    public void observerMethod(@Observes String text)
    {
        LOGGER.info("Event caught in ClassA: " + text);
    }
}
