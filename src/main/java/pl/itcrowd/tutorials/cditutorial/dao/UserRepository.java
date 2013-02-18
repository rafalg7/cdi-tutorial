package pl.itcrowd.tutorials.cditutorial.dao;

import pl.itcrowd.tutorials.cditutorial.domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * User: Rafal Gielczowski
 * Date: 2/18/13 Time: 12:19 PM
 */
@Stateless
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers()
    {
        return em.createQuery("SELECT u FROM User u").getResultList();
    }

    public User getUserById(Long id)
    {
        return em.find(User.class, id);
    }

    public User getUserByName(String name)
    {
        return (User) em.createQuery("SELECT u FROM User u WHERE u.name LIKE :name").setParameter("name", name).getResultList().get(0);
    }

    public User getUserByEmail(String email)
    {
        return (User) em.createQuery("SELECT u FROM User u WHERE u.email LIKE :email").setParameter("email", email).getResultList().get(0);
    }

    public void removeUser(User user)
    {
        User found = em.find(User.class, user.getId());
        em.remove(found);
    }

    public void saveUser(User user)
    {
        if (null != user) {
            if (null != user.getId()) {
                em.merge(user);
            } else {
                em.persist(user);
            }
        }
    }
}
