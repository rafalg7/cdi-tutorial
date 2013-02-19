package pl.itcrowd.tutorials.cditutorial.basics.view;

import pl.itcrowd.tutorials.cditutorial.basics.services.SimpleBean;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Logger;

/**
 * User: Rafal Gielczowski
 * Date: 2/19/13 Time: 11:45 AM
 */

@Named
@RequestScoped
public class SimpleView implements Serializable {

    @Inject
    private SimpleBean simpleBean;

    public String getInfo(){
        return "Injected bean name: "+simpleBean+", name returned directly from bean:"+simpleBean.getName();
    }

}
