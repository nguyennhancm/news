package tv.view.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/1/2015
 * Time: 8:20 AM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
public class ViewPreferencePK implements Serializable {
    private String viewPrefTypeId;
    private String userLoginId;

    @Column(name = "VIEW_PREF_TYPE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getViewPrefTypeId() {
        return viewPrefTypeId;
    }

    public void setViewPrefTypeId(String viewPrefTypeId) {
        this.viewPrefTypeId = viewPrefTypeId;
    }

    @Column(name = "USER_LOGIN_ID", nullable = false, insertable = true, updatable = true, length = 250)
    @Id
    public String getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViewPreferencePK that = (ViewPreferencePK) o;

        if (userLoginId != null ? !userLoginId.equals(that.userLoginId) : that.userLoginId != null) return false;
        if (viewPrefTypeId != null ? !viewPrefTypeId.equals(that.viewPrefTypeId) : that.viewPrefTypeId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = viewPrefTypeId != null ? viewPrefTypeId.hashCode() : 0;
        result = 31 * result + (userLoginId != null ? userLoginId.hashCode() : 0);
        return result;
    }
}
