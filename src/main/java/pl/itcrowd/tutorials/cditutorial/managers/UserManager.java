package pl.itcrowd.tutorials.cditutorial.managers;

import pl.itcrowd.tutorials.cditutorial.dao.UserRepository;
import pl.itcrowd.tutorials.cditutorial.domain.User;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;
import java.util.logging.Logger;

/**
 * User: Rafal Gielczowski
 * Date: 2/18/13 Time: 12:37 PM
 */
@Stateless
public class UserManager {

    private static final Logger LOGGER = Logger.getLogger(UserManager.class.getCanonicalName());

    private UserRepository userRepository;

    public List<User> getAllUsers()
    {
        return userRepository.getAllUsers();
    }

    public User getUserById(Long id)
    {
        return userRepository.getUserById(id);
    }

    public User getUserByName(String name)
    {
        return userRepository.getUserByName(name);
    }

    public void removeUser(User user)
    {
        userRepository.removeUser(user);
    }

    public void saveUser(User user)
    {
        userRepository.saveUser(user);
    }

    @PostConstruct
    private void onCreate()
    {
        try {
            userRepository = (UserRepository) new InitialContext().lookup("java:global/cdi-tutorial/UserRepository");
        } catch (NamingException e) {
            LOGGER.info("Error lookup UserRepository:" + e.getLocalizedMessage());
            throw new RuntimeException(e);
        }
    }
}
