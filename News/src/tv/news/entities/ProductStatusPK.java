package tv.news.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 5/31/2015
 * Time: 10:53 PM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
public class ProductStatusPK implements Serializable {
    private String productId;

    @Column(name = "PRODUCT_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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

    private String statusTypeId;

    @Column(name = "STATUS_TYPE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getStatusTypeId() {
        return statusTypeId;
    }

    public void setStatusTypeId(String statusTypeId) {
        this.statusTypeId = statusTypeId;
    }

    private String statusCode;

    @Column(name = "STATUS_CODE", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    private String lastStatusCode;

    @Column(name = "LAST_STATUS_CODE", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getLastStatusCode() {
        return lastStatusCode;
    }

    public void setLastStatusCode(String lastStatusCode) {
        this.lastStatusCode = lastStatusCode;
    }

    private String description;

    @Column(name = "DESCRIPTION", nullable = false, insertable = true, updatable = true, length = 255)
    @Id
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String updateParty;

    @Column(name = "UPDATE_PARTY", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getUpdateParty() {
        return updateParty;
    }

    public void setUpdateParty(String updateParty) {
        this.updateParty = updateParty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductStatusPK that = (ProductStatusPK) o;

        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (lastStatusCode != null ? !lastStatusCode.equals(that.lastStatusCode) : that.lastStatusCode != null)
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
        return result;
    }
}
