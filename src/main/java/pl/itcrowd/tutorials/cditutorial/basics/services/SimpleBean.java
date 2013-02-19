package pl.itcrowd.tutorials.cditutorial.basics.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 * User: Rafal Gielczowski
 * Date: 2/19/13 Time: 11:22 AM
 */
@SessionScoped  //change scope and check injected object in debugger
public class SimpleBean implements Serializable {

    public String getName()
    {
        return this.toString();
    }
}
