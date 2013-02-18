package pl.itcrowd.tutorials.cditutorial.view;

import pl.itcrowd.tutorials.cditutorial.domain.User;
import pl.itcrowd.tutorials.cditutorial.managers.UserManager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 * User: Rafal Gielczowski
 * Date: 2/18/13 Time: 1:33 PM
 */
@ManagedBean
@ViewScoped
public class UserDetailView {

    private User selectedUser;

    @Inject
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

    // -------------- getters & setters ------------------

    public User getSelectedUser()
    {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser)
    {
        this.selectedUser = selectedUser;
    }
}
