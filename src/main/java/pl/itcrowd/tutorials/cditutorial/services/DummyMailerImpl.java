package pl.itcrowd.tutorials.cditutorial.services;

import pl.itcrowd.tutorials.cditutorial.domain.User;

import javax.ejb.Stateless;
import java.util.logging.Logger;

/**
 * User: Rafal Gielczowski
 * Date: 2/18/13 Time: 3:05 PM
 */
@Stateless
public class DummyMailerImpl implements Mailer{

    private final static Logger LOGGER = Logger.getLogger(DummyMailerImpl.class.getCanonicalName());

    @Override
    public void sendMailToUser(User u, String title, String content)
    {
        LOGGER.info("Invoked dummy mailer!");
    }
}
