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
@Table(name = "product_type")
public class ProductType {
    private String productTypeId;
    private String isPhysical;
    private String isDigital;
    private String hasTable;
    private String description;
    private Timestamp lastUpdatedStamp;
    private Timestamp lastUpdatedTxStamp;
    private Timestamp createdStamp;
    private Timestamp createdTxStamp;
    private ProductType productTypeByParentTypeId;

    @Id
    @Column(name = "PRODUCT_TYPE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }

    @Basic
    @Column(name = "IS_PHYSICAL", nullable = true, insertable = true, updatable = true, length = 1)
    public String getIsPhysical() {
        return isPhysical;
    }

    public void setIsPhysical(String isPhysical) {
        this.isPhysical = isPhysical;
    }

    @Basic
    @Column(name = "IS_DIGITAL", nullable = true, insertable = true, updatable = true, length = 1)
    public String getIsDigital() {
        return isDigital;
    }

    public void setIsDigital(String isDigital) {
        this.isDigital = isDigital;
    }

    @Basic
    @Column(name = "HAS_TABLE", nullable = true, insertable = true, updatable = true, length = 1)
    public String getHasTable() {
        return hasTable;
    }

    public void setHasTable(String hasTable) {
        this.hasTable = hasTable;
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

        ProductType that = (ProductType) o;

        if (createdStamp != null ? !createdStamp.equals(that.createdStamp) : that.createdStamp != null) return false;
        if (createdTxStamp != null ? !createdTxStamp.equals(that.createdTxStamp) : that.createdTxStamp != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (hasTable != null ? !hasTable.equals(that.hasTable) : that.hasTable != null) return false;
        if (isDigital != null ? !isDigital.equals(that.isDigital) : that.isDigital != null) return false;
        if (isPhysical != null ? !isPhysical.equals(that.isPhysical) : that.isPhysical != null) return false;
        if (lastUpdatedStamp != null ? !lastUpdatedStamp.equals(that.lastUpdatedStamp) : that.lastUpdatedStamp != null)
            return false;
        if (lastUpdatedTxStamp != null ? !lastUpdatedTxStamp.equals(that.lastUpdatedTxStamp) : that.lastUpdatedTxStamp != null)
            return false;
        if (productTypeId != null ? !productTypeId.equals(that.productTypeId) : that.productTypeId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productTypeId != null ? productTypeId.hashCode() : 0;
        result = 31 * result + (isPhysical != null ? isPhysical.hashCode() : 0);
        result = 31 * result + (isDigital != null ? isDigital.hashCode() : 0);
        result = 31 * result + (hasTable != null ? hasTable.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (lastUpdatedStamp != null ? lastUpdatedStamp.hashCode() : 0);
        result = 31 * result + (lastUpdatedTxStamp != null ? lastUpdatedTxStamp.hashCode() : 0);
        result = 31 * result + (createdStamp != null ? createdStamp.hashCode() : 0);
        result = 31 * result + (createdTxStamp != null ? createdTxStamp.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PARENT_TYPE_ID", referencedColumnName = "PRODUCT_TYPE_ID")
    public ProductType getProductTypeByParentTypeId() {
        return productTypeByParentTypeId;
    }

    public void setProductTypeByParentTypeId(ProductType productTypeByParentTypeId) {
        this.productTypeByParentTypeId = productTypeByParentTypeId;
    }
}
