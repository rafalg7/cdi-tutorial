package pl.itcrowd.tutorials.cditutorial.view;

import pl.itcrowd.tutorials.cditutorial.domain.User;
import pl.itcrowd.tutorials.cditutorial.framework.Selected;
import pl.itcrowd.tutorials.cditutorial.managers.UserManager;
import pl.itcrowd.tutorials.cditutorial.services.MailingService;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * User: Rafal Gielczowski
 * Date: 2/18/13 Time: 12:43 PM
 */
@Named
@SessionScoped
public class UserView implements Serializable {

    @ManagedProperty(value = "#{userDetailView}")
    private UserDetailView userDetailView;

    private List<User> users;

    @Inject
    private UserManager userManager;

    @Inject
    private MailingService mailingService;

    @Inject
    @Selected
    private Event<User> event;

    private String mailTitle;

    private String mailContent;

    public void selectAction(User user)
    {
        event.fire(user);
    }

    public void sendMailingAction()
    {
        mailingService.sendMailingToUsers(mailTitle, mailContent);
    }

    // -------------- getters & setters ------------------

    @Produces
    @Named
    public List<User> getUsers()
    {
        users = userManager.getAllUsers();
        return users;
    }

    public UserDetailView getUserDetailView()
    {
        return userDetailView;
    }

    public void setUserDetailView(UserDetailView userDetailView)
    {
        this.userDetailView = userDetailView;
    }

    public String getMailTitle()
    {
        return mailTitle;
    }

    public void setMailTitle(String mailTitle)
    {
        this.mailTitle = mailTitle;
    }

    public String getMailContent()
    {
        return mailContent;
    }

    public void setMailContent(String mailContent)
    {
        this.mailContent = mailContent;
    }
}
