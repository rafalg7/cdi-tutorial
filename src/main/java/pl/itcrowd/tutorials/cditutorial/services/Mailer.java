package pl.itcrowd.tutorials.cditutorial.services;

import pl.itcrowd.tutorials.cditutorial.domain.User;

/**
 * User: Rafal Gielczowski
 * Date: 2/18/13 Time: 1:57 PM
 */
public interface Mailer {

    void sendMailToUser(User u, String title, String content);
}
