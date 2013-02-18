package pl.itcrowd.tutorials.cditutorial.view;

import pl.itcrowd.tutorials.cditutorial.domain.User;
import pl.itcrowd.tutorials.cditutorial.managers.UserManager;
import pl.itcrowd.tutorials.cditutorial.util.Gateway;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * User: Rafal Gielczowski
 * Date: 2/18/13 Time: 1:33 PM
 */
@ManagedBean
@ViewScoped
public class UserDetailView {

    @ManagedProperty(value = "#{gateway}")
    private Gateway gateway;

    private User selectedUser;

    private UserManager userManager;

    public void deleteAction(User user)
    {
        if (selectedUser != null && selectedUser.equals(user)) {
            selectedUser = new User();
        }
        userManager.removeUser(user);
    }

    public void newAction()
    {
        this.selectedUser = new User();
    }

    public void saveAction()
    {
        userManager.saveUser(selectedUser);
    }

    public void cancelAction()
    {
        this.selectedUser = new User();
    }

    @PostConstruct
    private void onCreate()
    {
        userManager = gateway.getUserManager();
    }

    // -------------- getters & setters ------------------

    public User getSelectedUser()
    {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser)
    {
        this.selectedUser = selectedUser;
    }

    public Gateway getGateway()
    {
        return gateway;
    }

    public void setGateway(Gateway gateway)
    {
        this.gateway = gateway;
    }
}
