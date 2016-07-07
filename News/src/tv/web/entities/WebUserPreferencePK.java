package tv.web.entities;

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
public class WebUserPreferencePK implements Serializable {
    private String userLoginId;

    @Column(name = "USER_LOGIN_ID", nullable = false, insertable = true, updatable = true, length = 250)
    @Id
    public String getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    private String partyId;

    @Column(name = "PARTY_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    private String visitId;

    @Column(name = "VISIT_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    private String webPreferenceTypeId;

    @Column(name = "WEB_PREFERENCE_TYPE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getWebPreferenceTypeId() {
        return webPreferenceTypeId;
    }

    public void setWebPreferenceTypeId(String webPreferenceTypeId) {
        this.webPreferenceTypeId = webPreferenceTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebUserPreferencePK that = (WebUserPreferencePK) o;

        if (partyId != null ? !partyId.equals(that.partyId) : that.partyId != null) return false;
        if (userLoginId != null ? !userLoginId.equals(that.userLoginId) : that.userLoginId != null) return false;
        if (visitId != null ? !visitId.equals(that.visitId) : that.visitId != null) return false;
        if (webPreferenceTypeId != null ? !webPreferenceTypeId.equals(that.webPreferenceTypeId) : that.webPreferenceTypeId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userLoginId != null ? userLoginId.hashCode() : 0;
        result = 31 * result + (partyId != null ? partyId.hashCode() : 0);
        result = 31 * result + (visitId != null ? visitId.hashCode() : 0);
        result = 31 * result + (webPreferenceTypeId != null ? webPreferenceTypeId.hashCode() : 0);
        return result;
    }
}
