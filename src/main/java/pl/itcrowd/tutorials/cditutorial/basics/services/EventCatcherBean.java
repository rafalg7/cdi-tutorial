package pl.itcrowd.tutorials.cditutorial.basics.services;

import javax.enterprise.event.Observes;
import java.util.logging.Logger;

/**
 * User: Rafal Gielczowski
 * Date: 2/19/13 Time: 12:45 PM
 */
public class EventCatcherBean {

    private static final Logger LOGGER = Logger.getLogger(EventCatcherBean.class.getCanonicalName());

    public void onStringEvent(@Observes String text)
    {
        LOGGER.info("Caught EVENT: "+text);
    }
}
