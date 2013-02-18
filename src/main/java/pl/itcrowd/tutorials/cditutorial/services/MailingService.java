package pl.itcrowd.tutorials.cditutorial.services;

import pl.itcrowd.tutorials.cditutorial.domain.User;
import pl.itcrowd.tutorials.cditutorial.managers.UserManager;

import javax.annotation.PostConstruct;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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

    private UserManager userManager;

    @PostConstruct
    private void onCreate()
    {
        try {
            userManager = (UserManager) new InitialContext().lookup("java:global/cdi-tutorial/UserManager");
        } catch (NamingException e) {
            LOGGER.info("Error lookup UserManager:" + e.getLocalizedMessage());
            throw new RuntimeException(e);
        }
    }

    @Asynchronous
    public void sendMailingToUsers(String title, String content)
    {
        List<User> userList = userManager.getAllUsers();

        for (User u : userList) {
            mailer.sendMailToUser(u, "Hello " + u.getName() + ", " + title, content);
        }
    }
}
