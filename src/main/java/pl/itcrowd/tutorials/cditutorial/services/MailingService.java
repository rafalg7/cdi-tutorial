package pl.itcrowd.tutorials.cditutorial.services;

import pl.itcrowd.tutorials.cditutorial.domain.User;
import pl.itcrowd.tutorials.cditutorial.managers.UserManager;

import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;

/**
 * User: Rafal Gielczowski
 * Date: 2/18/13 Time: 2:04 PM
 */
@Stateless
public class MailingService {

    private static final Logger LOGGER = Logger.getLogger(MailingService.class.getCanonicalName());

    @EJB
    private Mailer mailer;

    @Inject
    private UserManager userManager;

    @Asynchronous
    public void sendMailingToUsers(String title, String content)
    {
        List<User> userList = userManager.getAllUsers();

        for (User u : userList) {
            mailer.sendMailToUser(u, "Hello " + u.getName() + ", " + title, content);
        }
    }
}
