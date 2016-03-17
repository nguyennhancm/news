package portal.users.model;

import tv.news.model.OrganizationData;
import tv.user.entities.Person;
import tv.user.entities.UserLogin;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/12/2015
 * Time: 3:26 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
public class UserData {
    private UserLogin userLogin;
    private Person person;
    private List<String> storeList;
    private String currentStore;
    private OrganizationData organizationData;

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

    public List<String> getStoreList() {
        return storeList;
    }

    public void setStoreList(List<String> storeList) {
        this.storeList = storeList;
    }

    public String getCurrentStore() {
        return currentStore;
    }

    public void setCurrentStore(String currentStore) {
        this.currentStore = currentStore;
    }

    public OrganizationData getOrganizationData() {
        if (null == organizationData) organizationData = new OrganizationData();
        return organizationData;
    }

    public void setOrganizationData(OrganizationData organizationData) {
        this.organizationData = organizationData;
    }
}
