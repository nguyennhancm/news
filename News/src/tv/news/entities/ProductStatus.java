package tv.news.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 5/31/2015
 * Time: 10:53 PM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
@Entity
@javax.persistence.Table(name = "product_status")
@javax.persistence.IdClass(tv.news.entities.ProductStatusPK.class)
public class ProductStatus {
    private String productId;

    @Id
    @javax.persistence.Column(name = "PRODUCT_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    private String partyId;

    @Id
    @javax.persistence.Column(name = "PARTY_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    private String statusTypeId;

    @Id
    @javax.persistence.Column(name = "STATUS_TYPE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getStatusTypeId() {
        return statusTypeId;
    }

    public void setStatusTypeId(String statusTypeId) {
        this.statusTypeId = statusTypeId;
    }

    private String statusCode;

    @Id
    @javax.persistence.Column(name = "STATUS_CODE", nullable = false, insertable = true, updatable = true, length = 20)
    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    private String lastStatusCode;

    @Id
    @javax.persistence.Column(name = "LAST_STATUS_CODE", nullable = false, insertable = true, updatable = true, length = 20)
    public String getLastStatusCode() {
        return lastStatusCode;
    }

    public void setLastStatusCode(String lastStatusCode) {
        this.lastStatusCode = lastStatusCode;
    }

    private String description;

    @Id
    @javax.persistence.Column(name = "DESCRIPTION", nullable = false, insertable = true, updatable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String updateParty;

    @Id
    @javax.persistence.Column(name = "UPDATE_PARTY", nullable = false, insertable = true, updatable = true, length = 20)
    public String getUpdateParty() {
        return updateParty;
    }

    public void setUpdateParty(String updateParty) {
        this.updateParty = updateParty;
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

        ProductStatus that = (ProductStatus) o;

        if (createdStamp != null ? !createdStamp.equals(that.createdStamp) : that.createdStamp != null) return false;
        if (createdTxStamp != null ? !createdTxStamp.equals(that.createdTxStamp) : that.createdTxStamp != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (lastStatusCode != null ? !lastStatusCode.equals(that.lastStatusCode) : that.lastStatusCode != null)
            return false;
        if (lastUpdatedStamp != null ? !lastUpdatedStamp.equals(that.lastUpdatedStamp) : that.lastUpdatedStamp != null)
            return false;
        if (lastUpdatedTxStamp != null ? !lastUpdatedTxStamp.equals(that.lastUpdatedTxStamp) : that.lastUpdatedTxStamp != null)
            return false;
        if (partyId != null ? !partyId.equals(that.partyId) : that.partyId != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (statusCode != null ? !statusCode.equals(that.statusCode) : that.statusCode != null) return false;
        if (statusTypeId != null ? !statusTypeId.equals(that.statusTypeId) : that.statusTypeId != null) return false;
        if (updateParty != null ? !updateParty.equals(that.updateParty) : that.updateParty != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (partyId != null ? partyId.hashCode() : 0);
        result = 31 * result + (statusTypeId != null ? statusTypeId.hashCode() : 0);
        result = 31 * result + (statusCode != null ? statusCode.hashCode() : 0);
        result = 31 * result + (lastStatusCode != null ? lastStatusCode.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (updateParty != null ? updateParty.hashCode() : 0);
        result = 31 * result + (lastUpdatedStamp != null ? lastUpdatedStamp.hashCode() : 0);
        result = 31 * result + (lastUpdatedTxStamp != null ? lastUpdatedTxStamp.hashCode() : 0);
        result = 31 * result + (createdStamp != null ? createdStamp.hashCode() : 0);
        result = 31 * result + (createdTxStamp != null ? createdTxStamp.hashCode() : 0);
        return result;
    }
}
