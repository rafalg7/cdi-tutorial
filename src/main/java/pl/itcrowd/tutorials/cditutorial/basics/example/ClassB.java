package pl.itcrowd.tutorials.cditutorial.basics.example;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Alternative;
import java.io.Serializable;
import java.util.logging.Logger;

/**
 * User: Rafal Gielczowski
 * Date: 2/19/13 Time: 12:53 PM
 */
@Alternative
public class ClassB extends ClassA implements ExampleInterface, Serializable {

    private static final Logger LOGGER = Logger.getLogger(ClassB.class.getCanonicalName());

    @Override
    public void observerMethod(@Observes String text)
    {
        LOGGER.info("Event caught in ClassB: " + text);
    }
}
