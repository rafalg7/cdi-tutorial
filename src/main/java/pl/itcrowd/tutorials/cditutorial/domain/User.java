package pl.itcrowd.tutorials.cditutorial.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * User: Rafal Gielczowski
 * Date: 2/18/13 Time: 12:16 PM
 */
@Entity
@Table(name = "APPUSER")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ROLE")
    private UserRoleEnum userRole;

    public User()
    {
    }

    public User(String name, String email)
    {
        this.name = name;
        this.email = email;
        this.userRole = UserRoleEnum.CLIENT;
    }

    public User(String name, String email, UserRoleEnum role){
        this.name = name;
        this.email = email;
        this.userRole = role;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public UserRoleEnum getUserRole()
    {
        return userRole;
    }

    public void setUserRole(UserRoleEnum userRole)
    {
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (email != null ? !email.equals(user.email) : user.email != null) {
            return false;
        }
        if (id != null ? !id.equals(user.id) : user.id != null) {
            return false;
        }
        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        if (userRole != user.userRole) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (userRole != null ? userRole.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", userRole=" + userRole +
            '}';
    }
}
