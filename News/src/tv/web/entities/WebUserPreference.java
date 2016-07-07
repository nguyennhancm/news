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
@Table(name = "web_user_preference")
@IdClass(WebUserPreferencePK.class)
public class WebUserPreference implements Serializable {
    private String userLoginId;
    private String partyId;
    private String visitId;
    private String webPreferenceTypeId;
    private String webPreferenceValue;
    private Timestamp lastUpdatedStamp;
    private Timestamp lastUpdatedTxStamp;
    private Timestamp createdStamp;
    private Timestamp createdTxStamp;
    private WebPreferenceType webPreferenceTypeByWebPreferenceTypeId;

    @Id
    @Column(name = "USER_LOGIN_ID", nullable = false, insertable = true, updatable = true, length = 250)
    public String getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    @Id
    @Column(name = "PARTY_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    @Id
    @Column(name = "VISIT_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    @Id
    @Column(name = "WEB_PREFERENCE_TYPE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getWebPreferenceTypeId() {
        return webPreferenceTypeId;
    }

    public void setWebPreferenceTypeId(String webPreferenceTypeId) {
        this.webPreferenceTypeId = webPreferenceTypeId;
    }

    @Basic
    @Column(name = "WEB_PREFERENCE_VALUE", nullable = true, insertable = true, updatable = true, length = 255)
    public String getWebPreferenceValue() {
        return webPreferenceValue;
    }

    public void setWebPreferenceValue(String webPreferenceValue) {
        this.webPreferenceValue = webPreferenceValue;
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

        WebUserPreference that = (WebUserPreference) o;

        if (createdStamp != null ? !createdStamp.equals(that.createdStamp) : that.createdStamp != null) return false;
        if (createdTxStamp != null ? !createdTxStamp.equals(that.createdTxStamp) : that.createdTxStamp != null)
            return false;
        if (lastUpdatedStamp != null ? !lastUpdatedStamp.equals(that.lastUpdatedStamp) : that.lastUpdatedStamp != null)
            return false;
        if (lastUpdatedTxStamp != null ? !lastUpdatedTxStamp.equals(that.lastUpdatedTxStamp) : that.lastUpdatedTxStamp != null)
            return false;
        if (partyId != null ? !partyId.equals(that.partyId) : that.partyId != null) return false;
        if (userLoginId != null ? !userLoginId.equals(that.userLoginId) : that.userLoginId != null) return false;
        if (visitId != null ? !visitId.equals(that.visitId) : that.visitId != null) return false;
        if (webPreferenceTypeId != null ? !webPreferenceTypeId.equals(that.webPreferenceTypeId) : that.webPreferenceTypeId != null)
            return false;
        if (webPreferenceValue != null ? !webPreferenceValue.equals(that.webPreferenceValue) : that.webPreferenceValue != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userLoginId != null ? userLoginId.hashCode() : 0;
        result = 31 * result + (partyId != null ? partyId.hashCode() : 0);
        result = 31 * result + (visitId != null ? visitId.hashCode() : 0);
        result = 31 * result + (webPreferenceTypeId != null ? webPreferenceTypeId.hashCode() : 0);
        result = 31 * result + (webPreferenceValue != null ? webPreferenceValue.hashCode() : 0);
        result = 31 * result + (lastUpdatedStamp != null ? lastUpdatedStamp.hashCode() : 0);
        result = 31 * result + (lastUpdatedTxStamp != null ? lastUpdatedTxStamp.hashCode() : 0);
        result = 31 * result + (createdStamp != null ? createdStamp.hashCode() : 0);
        result = 31 * result + (createdTxStamp != null ? createdTxStamp.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "WEB_PREFERENCE_TYPE_ID", referencedColumnName = "WEB_PREFERENCE_TYPE_ID", nullable = false)
//    public WebPreferenceType getWebPreferenceTypeByWebPreferenceTypeId() {
//        return webPreferenceTypeByWebPreferenceTypeId;
//    }
//
//    public void setWebPreferenceTypeByWebPreferenceTypeId(WebPreferenceType webPreferenceTypeByWebPreferenceTypeId) {
//        this.webPreferenceTypeByWebPreferenceTypeId = webPreferenceTypeByWebPreferenceTypeId;
//    }
}
