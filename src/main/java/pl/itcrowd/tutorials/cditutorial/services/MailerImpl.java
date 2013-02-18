package pl.itcrowd.tutorials.cditutorial.services;

import pl.itcrowd.tutorials.cditutorial.domain.User;

import javax.ejb.Stateless;
import java.util.logging.Logger;

/**
 * User: Rafal Gielczowski
 * Date: 2/18/13 Time: 1:58 PM
 */
@Stateless
public class MailerImpl implements Mailer {

    private static final Logger LOGGER = Logger.getLogger(MailerImpl.class.getCanonicalName());

    @Override
    public void sendMailToUser(User u, String title, String content)
    {
        LOGGER.info("Sending mail to user:" + u.getName() + ", Title:" + title + ", Content=" + content);

        //valid implementation...
    }
}
