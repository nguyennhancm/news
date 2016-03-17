package tv.news.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 5/31/2015
 * Time: 10:34 PM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
@Entity
@javax.persistence.Table(name = "prod_catalog_category")
@javax.persistence.IdClass(tv.news.entities.ProdCatalogCategoryPK.class)
public class ProdCatalogCategory {
    private String prodCatalogId;

    @Id
    @javax.persistence.Column(name = "PROD_CATALOG_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getProdCatalogId() {
        return prodCatalogId;
    }

    public void setProdCatalogId(String prodCatalogId) {
        this.prodCatalogId = prodCatalogId;
    }

    private String productCategoryId;

    @Id
    @javax.persistence.Column(name = "PRODUCT_CATEGORY_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(String productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    private String prodCatalogCategoryTypeId;

    @Id
    @javax.persistence.Column(name = "PROD_CATALOG_CATEGORY_TYPE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getProdCatalogCategoryTypeId() {
        return prodCatalogCategoryTypeId;
    }

    public void setProdCatalogCategoryTypeId(String prodCatalogCategoryTypeId) {
        this.prodCatalogCategoryTypeId = prodCatalogCategoryTypeId;
    }

    private Timestamp fromDate;

    @Id
    @javax.persistence.Column(name = "FROM_DATE", nullable = false, insertable = true, updatable = true)
    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    private Timestamp thruDate;

    @Basic
    @javax.persistence.Column(name = "THRU_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getThruDate() {
        return thruDate;
    }

    public void setThruDate(Timestamp thruDate) {
        this.thruDate = thruDate;
    }

    private Integer sequenceNum;

    @Basic
    @javax.persistence.Column(name = "SEQUENCE_NUM", nullable = true, insertable = true, updatable = true, precision = 0)
    public Integer getSequenceNum() {
        return sequenceNum;
    }

    public void setSequenceNum(Integer sequenceNum) {
        this.sequenceNum = sequenceNum;
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

        ProdCatalogCategory that = (ProdCatalogCategory) o;

        if (createdStamp != null ? !createdStamp.equals(that.createdStamp) : that.createdStamp != null) return false;
        if (createdTxStamp != null ? !createdTxStamp.equals(that.createdTxStamp) : that.createdTxStamp != null)
            return false;
        if (fromDate != null ? !fromDate.equals(that.fromDate) : that.fromDate != null) return false;
        if (lastUpdatedStamp != null ? !lastUpdatedStamp.equals(that.lastUpdatedStamp) : that.lastUpdatedStamp != null)
            return false;
        if (lastUpdatedTxStamp != null ? !lastUpdatedTxStamp.equals(that.lastUpdatedTxStamp) : that.lastUpdatedTxStamp != null)
            return false;
        if (prodCatalogCategoryTypeId != null ? !prodCatalogCategoryTypeId.equals(that.prodCatalogCategoryTypeId) : that.prodCatalogCategoryTypeId != null)
            return false;
        if (prodCatalogId != null ? !prodCatalogId.equals(that.prodCatalogId) : that.prodCatalogId != null)
            return false;
        if (productCategoryId != null ? !productCategoryId.equals(that.productCategoryId) : that.productCategoryId != null)
            return false;
        if (sequenceNum != null ? !sequenceNum.equals(that.sequenceNum) : that.sequenceNum != null) return false;
        if (thruDate != null ? !thruDate.equals(that.thruDate) : that.thruDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = prodCatalogId != null ? prodCatalogId.hashCode() : 0;
        result = 31 * result + (productCategoryId != null ? productCategoryId.hashCode() : 0);
        result = 31 * result + (prodCatalogCategoryTypeId != null ? prodCatalogCategoryTypeId.hashCode() : 0);
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        result = 31 * result + (thruDate != null ? thruDate.hashCode() : 0);
        result = 31 * result + (sequenceNum != null ? sequenceNum.hashCode() : 0);
        result = 31 * result + (lastUpdatedStamp != null ? lastUpdatedStamp.hashCode() : 0);
        result = 31 * result + (lastUpdatedTxStamp != null ? lastUpdatedTxStamp.hashCode() : 0);
        result = 31 * result + (createdStamp != null ? createdStamp.hashCode() : 0);
        result = 31 * result + (createdTxStamp != null ? createdTxStamp.hashCode() : 0);
        return result;
    }
}
