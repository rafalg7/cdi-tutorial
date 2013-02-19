package pl.itcrowd.tutorials.cditutorial.basics;

import pl.itcrowd.tutorials.cditutorial.basics.annotations.Enhanced;
import pl.itcrowd.tutorials.cditutorial.basics.services.BusinessGreeter;
import pl.itcrowd.tutorials.cditutorial.basics.services.MyService;
import pl.itcrowd.tutorials.cditutorial.basics.services.SimpleBean;

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

    @PostConstruct
    private void onCreate(){
//        LOGGER.info("Injected bean name: "+simpleBean.toString()+", name returned directly from bean:"+simpleBean.getName());
    }

}
