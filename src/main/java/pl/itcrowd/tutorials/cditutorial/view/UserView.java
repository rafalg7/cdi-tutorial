package pl.itcrowd.tutorials.cditutorial.view;

import pl.itcrowd.tutorials.cditutorial.domain.User;
import pl.itcrowd.tutorials.cditutorial.managers.UserManager;
import pl.itcrowd.tutorials.cditutorial.services.MailingService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * User: Rafal Gielczowski
 * Date: 2/18/13 Time: 12:43 PM
 */
@ManagedBean
@ViewScoped
public class UserView {

    @ManagedProperty(value = "#{userDetailView}")
    private UserDetailView userDetailView;

    private List<User> users;

    @Inject
    private UserManager userManager;

    @Inject
    private MailingService mailingService;

    private String mailTitle;

    private String mailContent;

    public void selectAction(User user)
    {
        userDetailView.setSelectedUser(user);
    }

    public void sendMailingAction()
    {
        mailingService.sendMailingToUsers(mailTitle, mailContent);
    }

    // -------------- getters & setters ------------------
    public List<User> getUsers()
    {
//        if(users==null)
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
