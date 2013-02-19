package pl.itcrowd.tutorials.cditutorial.basics.view;

import pl.itcrowd.tutorials.cditutorial.basics.annotations.Enhanced;
import pl.itcrowd.tutorials.cditutorial.basics.services.BusinessGreeter;
import pl.itcrowd.tutorials.cditutorial.basics.services.MyService;
import pl.itcrowd.tutorials.cditutorial.basics.services.SimpleBean;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * User: Rafal Gielczowski
 * Date: 2/19/13 Time: 11:45 AM
 */
@Named
@SessionScoped
public class SimpleView implements Serializable {

    @Inject
    private SimpleBean simpleBean;

    @Inject
    @Enhanced
    private BusinessGreeter businessGreeter;

    @Inject
    private MyService myService;

    @Inject
    Event<String> stringEvent;
    private String userInput;

    public String getInfo(){
        return "Injected bean name: "+simpleBean+", name returned directly from bean:"+simpleBean.getName()+", "+new Date();
    }

    @Produces
    @Named
    public List<String> getGreetings(){
        List<String> greetings = new ArrayList<String>();
        greetings.add(businessGreeter.greeter());
        greetings.add(myService.greeter());
        return greetings;
    }

    public void buttonAction(){
        stringEvent.fire(userInput);
    }

    public String getUserInput()
    {
        return userInput;
    }

    public void setUserInput(String userInput)
    {
        this.userInput = userInput;
    }
}
