package tv.news.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/1/2015
 * Time: 8:17 AM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "product_store_group")
public class ProductStoreGroup {
    private String productStoreGroupId;
    private String productStoreGroupName;
    private String description;
    private Timestamp lastUpdatedStamp;
    private Timestamp lastUpdatedTxStamp;
    private Timestamp createdStamp;
    private Timestamp createdTxStamp;
    private ProductStoreGroup productStoreGroupByPrimaryParentGroupId;

    @Id
    @Column(name = "PRODUCT_STORE_GROUP_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getProductStoreGroupId() {
        return productStoreGroupId;
    }

    public void setProductStoreGroupId(String productStoreGroupId) {
        this.productStoreGroupId = productStoreGroupId;
    }

    @Basic
    @Column(name = "PRODUCT_STORE_GROUP_NAME", nullable = true, insertable = true, updatable = true, length = 100)
    public String getProductStoreGroupName() {
        return productStoreGroupName;
    }

    public void setProductStoreGroupName(String productStoreGroupName) {
        this.productStoreGroupName = productStoreGroupName;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = true, insertable = true, updatable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

        ProductStoreGroup that = (ProductStoreGroup) o;

        if (createdStamp != null ? !createdStamp.equals(that.createdStamp) : that.createdStamp != null) return false;
        if (createdTxStamp != null ? !createdTxStamp.equals(that.createdTxStamp) : that.createdTxStamp != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (lastUpdatedStamp != null ? !lastUpdatedStamp.equals(that.lastUpdatedStamp) : that.lastUpdatedStamp != null)
            return false;
        if (lastUpdatedTxStamp != null ? !lastUpdatedTxStamp.equals(that.lastUpdatedTxStamp) : that.lastUpdatedTxStamp != null)
            return false;
        if (productStoreGroupId != null ? !productStoreGroupId.equals(that.productStoreGroupId) : that.productStoreGroupId != null)
            return false;
        if (productStoreGroupName != null ? !productStoreGroupName.equals(that.productStoreGroupName) : that.productStoreGroupName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productStoreGroupId != null ? productStoreGroupId.hashCode() : 0;
        result = 31 * result + (productStoreGroupName != null ? productStoreGroupName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (lastUpdatedStamp != null ? lastUpdatedStamp.hashCode() : 0);
        result = 31 * result + (lastUpdatedTxStamp != null ? lastUpdatedTxStamp.hashCode() : 0);
        result = 31 * result + (createdStamp != null ? createdStamp.hashCode() : 0);
        result = 31 * result + (createdTxStamp != null ? createdTxStamp.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PRIMARY_PARENT_GROUP_ID", referencedColumnName = "PRODUCT_STORE_GROUP_ID")
    public ProductStoreGroup getProductStoreGroupByPrimaryParentGroupId() {
        return productStoreGroupByPrimaryParentGroupId;
    }

    public void setProductStoreGroupByPrimaryParentGroupId(ProductStoreGroup productStoreGroupByPrimaryParentGroupId) {
        this.productStoreGroupByPrimaryParentGroupId = productStoreGroupByPrimaryParentGroupId;
    }
}
