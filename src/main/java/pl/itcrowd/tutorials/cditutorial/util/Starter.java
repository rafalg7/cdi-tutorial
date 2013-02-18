package pl.itcrowd.tutorials.cditutorial.util;

import pl.itcrowd.tutorials.cditutorial.dao.UserRepository;
import pl.itcrowd.tutorials.cditutorial.domain.User;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.logging.Logger;

/**
 * User: Rafal Gielczowski
 * Date: 2/18/13 Time: 12:50 PM
 */
@Startup
@Singleton
public class Starter {

    private static final Logger LOGGER = Logger.getLogger(Starter.class.getCanonicalName());

    private UserRepository userRepository;

    @PostConstruct
    private void onCreate()
    {

        try {
            userRepository = (UserRepository) new InitialContext().lookup("java:global/cdi-tutorial/UserRepository");
        } catch (NamingException e) {
            LOGGER.info("Error lookup UserRepository:" + e.getLocalizedMessage());
            throw new RuntimeException(e);
        }

        //add example users
        userRepository.saveUser(new User("John", "john@example.com"));
        userRepository.saveUser(new User("Mark", "mark@example.com"));
        userRepository.saveUser(new User("Joanna", "joanna@example.com"));
        userRepository.saveUser(new User("Markus", "markus@example.com"));
    }
}
