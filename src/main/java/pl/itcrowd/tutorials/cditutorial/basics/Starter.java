package pl.itcrowd.tutorials.cditutorial.basics;

import pl.itcrowd.tutorials.cditutorial.basics.services.MyService;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * User: Rafal Gielczowski
 * Date: 2/19/13 Time: 10:33 AM
 */

@Startup
@Singleton
public class Starter {

    private final static Logger LOGGER = Logger.getLogger(Starter.class.getCanonicalName());

    @Inject
    private MyService myService;

    @PostConstruct
    private void onCreate(){
        LOGGER.info("FROM MY SERVICE: "+myService.greeter());
    }
}
