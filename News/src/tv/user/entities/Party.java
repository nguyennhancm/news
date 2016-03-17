package tv.user.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 5/31/2015
 * Time: 10:28 PM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
@Entity
@javax.persistence.Table(name = "party")
public class Party {
    private String partyId;

    @Id
    @javax.persistence.Column(name = "PARTY_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    private String partyTypeId;

    @Basic
    @javax.persistence.Column(name = "PARTY_TYPE_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getPartyTypeId() {
        return partyTypeId;
    }

    public void setPartyTypeId(String partyTypeId) {
        this.partyTypeId = partyTypeId;
    }

    private String externalId;

    @Basic
    @javax.persistence.Column(name = "EXTERNAL_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    private String preferredCurrencyUomId;

    @Basic
    @javax.persistence.Column(name = "PREFERRED_CURRENCY_UOM_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getPreferredCurrencyUomId() {
        return preferredCurrencyUomId;
    }

    public void setPreferredCurrencyUomId(String preferredCurrencyUomId) {
        this.preferredCurrencyUomId = preferredCurrencyUomId;
    }

    private String description;

    @Basic
    @javax.persistence.Column(name = "DESCRIPTION", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String statusId;

    @Basic
    @javax.persistence.Column(name = "STATUS_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    private Timestamp createdDate;

    @Basic
    @javax.persistence.Column(name = "CREATED_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    private String createdByUserLogin;

    @Basic
    @javax.persistence.Column(name = "CREATED_BY_USER_LOGIN", nullable = true, insertable = true, updatable = true, length = 250)
    public String getCreatedByUserLogin() {
        return createdByUserLogin;
    }

    public void setCreatedByUserLogin(String createdByUserLogin) {
        this.createdByUserLogin = createdByUserLogin;
    }

    private Timestamp lastModifiedDate;

    @Basic
    @javax.persistence.Column(name = "LAST_MODIFIED_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    private String lastModifiedByUserLogin;

    @Basic
    @javax.persistence.Column(name = "LAST_MODIFIED_BY_USER_LOGIN", nullable = true, insertable = true, updatable = true, length = 250)
    public String getLastModifiedByUserLogin() {
        return lastModifiedByUserLogin;
    }

    public void setLastModifiedByUserLogin(String lastModifiedByUserLogin) {
        this.lastModifiedByUserLogin = lastModifiedByUserLogin;
    }

    private String dataSourceId;

    @Basic
    @javax.persistence.Column(name = "DATA_SOURCE_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getDataSourceId() {
        return dataSourceId;
    }

    public void setDataSourceId(String dataSourceId) {
        this.dataSourceId = dataSourceId;
    }

    private String isUnread;

    @Basic
    @javax.persistence.Column(name = "IS_UNREAD", nullable = true, insertable = true, updatable = true, length = 1)
    public String getIsUnread() {
        return isUnread;
    }

    public void setIsUnread(String isUnread) {
        this.isUnread = isUnread;
    }

    private Timestamp lastUpdatedStamp;

    @Basic
    @javax.persistence.Column(name = "LAST_UPDATED_STAMP", nullable = true, insertable = true, updatable = true)
    public Timestamp getLastUpdatedStamp() {
        return lastUpdatedStamp;
    }

    public void setLastUpdatedStamp(Timestamp lastUpdatedStamp) {
        this.lastUpdatedStamp = lastUpdatedStamp;
    }

    private Timestamp lastUpdatedTxStamp;

    @Basic
    @javax.persistence.Column(name = "LAST_UPDATED_TX_STAMP", nullable = true, insertable = true, updatable = true)
    public Timestamp getLastUpdatedTxStamp() {
        return lastUpdatedTxStamp;
    }

    public void setLastUpdatedTxStamp(Timestamp lastUpdatedTxStamp) {
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
    }

    private Timestamp createdStamp;

    @Basic
    @javax.persistence.Column(name = "CREATED_STAMP", nullable = true, insertable = true, updatable = true)
    public Timestamp getCreatedStamp() {
        return createdStamp;
    }

    public void setCreatedStamp(Timestamp createdStamp) {
        this.createdStamp = createdStamp;
    }

    private Timestamp createdTxStamp;

    @Basic
    @javax.persistence.Column(name = "CREATED_TX_STAMP", nullable = true, insertable = true, updatable = true)
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

        Party party = (Party) o;

        if (createdByUserLogin != null ? !createdByUserLogin.equals(party.createdByUserLogin) : party.createdByUserLogin != null)
            return false;
        if (createdDate != null ? !createdDate.equals(party.createdDate) : party.createdDate != null) return false;
        if (createdStamp != null ? !createdStamp.equals(party.createdStamp) : party.createdStamp != null) return false;
        if (createdTxStamp != null ? !createdTxStamp.equals(party.createdTxStamp) : party.createdTxStamp != null)
            return false;
        if (dataSourceId != null ? !dataSourceId.equals(party.dataSourceId) : party.dataSourceId != null) return false;
        if (description != null ? !description.equals(party.description) : party.description != null) return false;
        if (externalId != null ? !externalId.equals(party.externalId) : party.externalId != null) return false;
        if (isUnread != null ? !isUnread.equals(party.isUnread) : party.isUnread != null) return false;
        if (lastModifiedByUserLogin != null ? !lastModifiedByUserLogin.equals(party.lastModifiedByUserLogin) : party.lastModifiedByUserLogin != null)
            return false;
        if (lastModifiedDate != null ? !lastModifiedDate.equals(party.lastModifiedDate) : party.lastModifiedDate != null)
            return false;
        if (lastUpdatedStamp != null ? !lastUpdatedStamp.equals(party.lastUpdatedStamp) : party.lastUpdatedStamp != null)
            return false;
        if (lastUpdatedTxStamp != null ? !lastUpdatedTxStamp.equals(party.lastUpdatedTxStamp) : party.lastUpdatedTxStamp != null)
            return false;
        if (partyId != null ? !partyId.equals(party.partyId) : party.partyId != null) return false;
        if (partyTypeId != null ? !partyTypeId.equals(party.partyTypeId) : party.partyTypeId != null) return false;
        if (preferredCurrencyUomId != null ? !preferredCurrencyUomId.equals(party.preferredCurrencyUomId) : party.preferredCurrencyUomId != null)
            return false;
        if (statusId != null ? !statusId.equals(party.statusId) : party.statusId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = partyId != null ? partyId.hashCode() : 0;
        result = 31 * result + (partyTypeId != null ? partyTypeId.hashCode() : 0);
        result = 31 * result + (externalId != null ? externalId.hashCode() : 0);
        result = 31 * result + (preferredCurrencyUomId != null ? preferredCurrencyUomId.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (createdByUserLogin != null ? createdByUserLogin.hashCode() : 0);
        result = 31 * result + (lastModifiedDate != null ? lastModifiedDate.hashCode() : 0);
        result = 31 * result + (lastModifiedByUserLogin != null ? lastModifiedByUserLogin.hashCode() : 0);
        result = 31 * result + (dataSourceId != null ? dataSourceId.hashCode() : 0);
        result = 31 * result + (isUnread != null ? isUnread.hashCode() : 0);
        result = 31 * result + (lastUpdatedStamp != null ? lastUpdatedStamp.hashCode() : 0);
        result = 31 * result + (lastUpdatedTxStamp != null ? lastUpdatedTxStamp.hashCode() : 0);
        result = 31 * result + (createdStamp != null ? createdStamp.hashCode() : 0);
        result = 31 * result + (createdTxStamp != null ? createdTxStamp.hashCode() : 0);
        return result;
    }
}
