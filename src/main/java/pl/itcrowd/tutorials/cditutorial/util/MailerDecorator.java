package pl.itcrowd.tutorials.cditutorial.util;

import pl.itcrowd.tutorials.cditutorial.domain.User;
import pl.itcrowd.tutorials.cditutorial.domain.UserRoleEnum;
import pl.itcrowd.tutorials.cditutorial.services.Mailer;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import java.util.Date;

/**
 * User: Rafal Gielczowski
 * Date: 2/19/13 Time: 9:38 AM
 */
@Decorator
public class MailerDecorator implements Mailer{

    @Inject
    @Delegate
    private Mailer mailer;

    @Override
    public void sendMailToUser(User u, String title, String content)
    {
        /**
         * only for admins, title will be diagnostic info with timestamp.
         */
        if(u.getUserRole().equals(UserRoleEnum.ADMIN)){
            String adminTitle = "Mail sent to users, timestamp:"+new Date().toString();
            mailer.sendMailToUser(u, adminTitle, content);
        } else {
            mailer.sendMailToUser(u, title, content);
        }

    }
}
