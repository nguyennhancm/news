package tv.web.entities;

import javax.persistence.*;
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
@Entity
@Table(name = "web_site_role")
@IdClass(WebSiteRolePK.class)
public class WebSiteRole implements Serializable{
    private String partyId;
    private String roleTypeId;
    private String webSiteId;
    private Timestamp fromDate;
    private Timestamp thruDate;
    private Integer sequenceNum;
    private Timestamp lastUpdatedStamp;
    private Timestamp lastUpdatedTxStamp;
    private Timestamp createdStamp;
    private Timestamp createdTxStamp;
    private WebSite webSiteByWebSiteId;

    @Id
    @Column(name = "PARTY_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    @Id
    @Column(name = "ROLE_TYPE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getRoleTypeId() {
        return roleTypeId;
    }

    public void setRoleTypeId(String roleTypeId) {
        this.roleTypeId = roleTypeId;
    }

    @Id
    @Column(name = "WEB_SITE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getWebSiteId() {
        return webSiteId;
    }

    public void setWebSiteId(String webSiteId) {
        this.webSiteId = webSiteId;
    }

    @Id
    @Column(name = "FROM_DATE", nullable = false, insertable = true, updatable = true)
    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    @Basic
    @Column(name = "THRU_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getThruDate() {
        return thruDate;
    }

    public void setThruDate(Timestamp thruDate) {
        this.thruDate = thruDate;
    }

    @Basic
    @Column(name = "SEQUENCE_NUM", nullable = true, insertable = true, updatable = true, precision = 0)
    public Integer getSequenceNum() {
        return sequenceNum;
    }

    public void setSequenceNum(Integer sequenceNum) {
        this.sequenceNum = sequenceNum;
    }

    @Basic
    @Column(name = "LAST_UPDATED_STAMP", nullable = true, insertable = true, updatable = true)
    public Timestamp getLastUpdatedStamp() {
        return lastUpdatedStamp;
    }

    public void setLastUpdatedStamp(Timestamp lastUpdatedStamp) {
        this.lastUpdatedStamp = lastUpdatedStamp;
    }

    @Basic
    @Column(name = "LAST_UPDATED_TX_STAMP", nullable = true, insertable = true, updatable = true)
    public Timestamp getLastUpdatedTxStamp() {
        return lastUpdatedTxStamp;
    }

    public void setLastUpdatedTxStamp(Timestamp lastUpdatedTxStamp) {
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
    }

    @Basic
    @Column(name = "CREATED_STAMP", nullable = true, insertable = true, updatable = true)
    public Timestamp getCreatedStamp() {
        return createdStamp;
    }

    public void setCreatedStamp(Timestamp createdStamp) {
        this.createdStamp = createdStamp;
    }

    @Basic
    @Column(name = "CREATED_TX_STAMP", nullable = true, insertable = true, updatable = true)
    public Timestamp getCreatedTxStamp() {
        return createdTxStamp;
    }

    public void setCreatedTxStamp(Timestamp createdTxStamp) {
        this.createdTxStamp = createdTxStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebSiteRole that = (WebSiteRole) o;

        if (createdStamp != null ? !createdStamp.equals(that.createdStamp) : that.createdStamp != null) return false;
        if (createdTxStamp != null ? !createdTxStamp.equals(that.createdTxStamp) : that.createdTxStamp != null)
            return false;
        if (fromDate != null ? !fromDate.equals(that.fromDate) : that.fromDate != null) return false;
        if (lastUpdatedStamp != null ? !lastUpdatedStamp.equals(that.lastUpdatedStamp) : that.lastUpdatedStamp != null)
            return false;
        if (lastUpdatedTxStamp != null ? !lastUpdatedTxStamp.equals(that.lastUpdatedTxStamp) : that.lastUpdatedTxStamp != null)
            return false;
        if (partyId != null ? !partyId.equals(that.partyId) : that.partyId != null) return false;
        if (roleTypeId != null ? !roleTypeId.equals(that.roleTypeId) : that.roleTypeId != null) return false;
        if (sequenceNum != null ? !sequenceNum.equals(that.sequenceNum) : that.sequenceNum != null) return false;
        if (thruDate != null ? !thruDate.equals(that.thruDate) : that.thruDate != null) return false;
        if (webSiteId != null ? !webSiteId.equals(that.webSiteId) : that.webSiteId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = partyId != null ? partyId.hashCode() : 0;
        result = 31 * result + (roleTypeId != null ? roleTypeId.hashCode() : 0);
        result = 31 * result + (webSiteId != null ? webSiteId.hashCode() : 0);
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        result = 31 * result + (thruDate != null ? thruDate.hashCode() : 0);
        result = 31 * result + (sequenceNum != null ? sequenceNum.hashCode() : 0);
        result = 31 * result + (lastUpdatedStamp != null ? lastUpdatedStamp.hashCode() : 0);
        result = 31 * result + (lastUpdatedTxStamp != null ? lastUpdatedTxStamp.hashCode() : 0);
        result = 31 * result + (createdStamp != null ? createdStamp.hashCode() : 0);
        result = 31 * result + (createdTxStamp != null ? createdTxStamp.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "WEB_SITE_ID", referencedColumnName = "WEB_SITE_ID", nullable = false)
//    public WebSite getWebSiteByWebSiteId() {
//        return webSiteByWebSiteId;
//    }
//
//    public void setWebSiteByWebSiteId(WebSite webSiteByWebSiteId) {
//        this.webSiteByWebSiteId = webSiteByWebSiteId;
//    }
}
