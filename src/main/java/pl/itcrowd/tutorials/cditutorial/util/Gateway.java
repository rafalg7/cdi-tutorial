package pl.itcrowd.tutorials.cditutorial.util;

import pl.itcrowd.tutorials.cditutorial.managers.UserManager;
import pl.itcrowd.tutorials.cditutorial.services.MailingService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.logging.Logger;

/**
 * User: Rafal Gielczowski
 * Date: 2/18/13 Time: 12:44 PM
 */
@ManagedBean
@SessionScoped
public class Gateway {

    private static final Logger LOGGER = Logger.getLogger(Gateway.class.getCanonicalName());

    /**
     * Search UserManager trough JNDI
     *
     * @return
     */
    public UserManager getUserManager()
    {
        try {
            return (UserManager) new InitialContext().lookup("java:global/cdi-tutorial/UserManager");
        } catch (NamingException e) {
            LOGGER.info("Error lookup UserManager:" + e.getLocalizedMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Search MailingService trough JNDI
     *
     * @return
     */
    public MailingService getMailingService()
    {
        try {
            return (MailingService) new InitialContext().lookup("java:global/cdi-tutorial/MailingService");
        } catch (NamingException e) {
            LOGGER.info("Error lookup MailingService:" + e.getLocalizedMessage());
            throw new RuntimeException(e);
        }
    }
}
