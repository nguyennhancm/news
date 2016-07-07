package tv.web.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/1/2015
 * Time: 8:20 AM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
public class WebSiteRolePK implements Serializable {
    private String partyId;

    @Column(name = "PARTY_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    private String roleTypeId;

    @Column(name = "ROLE_TYPE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getRoleTypeId() {
        return roleTypeId;
    }

    public void setRoleTypeId(String roleTypeId) {
        this.roleTypeId = roleTypeId;
    }

    private String webSiteId;

    @Column(name = "WEB_SITE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getWebSiteId() {
        return webSiteId;
    }

    public void setWebSiteId(String webSiteId) {
        this.webSiteId = webSiteId;
    }

    private Timestamp fromDate;

    @Column(name = "FROM_DATE", nullable = false, insertable = true, updatable = true)
    @Id
    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebSiteRolePK that = (WebSiteRolePK) o;

        if (fromDate != null ? !fromDate.equals(that.fromDate) : that.fromDate != null) return false;
        if (partyId != null ? !partyId.equals(that.partyId) : that.partyId != null) return false;
        if (roleTypeId != null ? !roleTypeId.equals(that.roleTypeId) : that.roleTypeId != null) return false;
        if (webSiteId != null ? !webSiteId.equals(that.webSiteId) : that.webSiteId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = partyId != null ? partyId.hashCode() : 0;
        result = 31 * result + (roleTypeId != null ? roleTypeId.hashCode() : 0);
        result = 31 * result + (webSiteId != null ? webSiteId.hashCode() : 0);
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        return result;
    }
}
