package pl.itcrowd.tutorials.cditutorial.managers;

import pl.itcrowd.tutorials.cditutorial.dao.UserRepository;
import pl.itcrowd.tutorials.cditutorial.domain.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;

/**
 * User: Rafal Gielczowski
 * Date: 2/18/13 Time: 12:37 PM
 */
@Stateless
public class UserManager {

    private static final Logger LOGGER = Logger.getLogger(UserManager.class.getCanonicalName());

    @Inject
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
}
