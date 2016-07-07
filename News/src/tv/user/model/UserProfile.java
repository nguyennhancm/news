package tv.user.model;

import tv.user.entities.Person;
import tv.user.entities.UserLogin;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 4/10/2016
 * Time: 5:09 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
public class UserProfile {
    private UserLogin userLogin;
    private Person person;

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
