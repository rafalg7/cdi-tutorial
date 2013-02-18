package pl.itcrowd.tutorials.cditutorial.util;

import pl.itcrowd.tutorials.cditutorial.dao.UserRepository;
import pl.itcrowd.tutorials.cditutorial.domain.User;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * User: Rafal Gielczowski
 * Date: 2/18/13 Time: 12:50 PM
 */
@Startup
@Singleton
public class Starter {

    private static final Logger LOGGER = Logger.getLogger(Starter.class.getCanonicalName());

    @Inject
    private UserRepository userRepository;

    @PostConstruct
    private void onCreate()
    {
        //add example users
        userRepository.saveUser(new User("John", "john@example.com"));
        userRepository.saveUser(new User("Mark", "mark@example.com"));
        userRepository.saveUser(new User("Joanna", "joanna@example.com"));
        userRepository.saveUser(new User("Markus", "markus@example.com"));
    }
}
