package tv.news.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 5/31/2015
 * Time: 10:38 PM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
@Entity
@javax.persistence.Table(name = "product_content")
@javax.persistence.IdClass(tv.news.entities.ProductContentPK.class)
public class ProductContent {
    private String productId;

    @Id
    @javax.persistence.Column(name = "PRODUCT_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    private String contentId;

    @Id
    @javax.persistence.Column(name = "CONTENT_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    private String productContentTypeId;

    @Id
    @javax.persistence.Column(name = "PRODUCT_CONTENT_TYPE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getProductContentTypeId() {
        return productContentTypeId;
    }

    public void setProductContentTypeId(String productContentTypeId) {
        this.productContentTypeId = productContentTypeId;
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

    private Timestamp purchaseFromDate;

    @Basic
    @javax.persistence.Column(name = "PURCHASE_FROM_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getPurchaseFromDate() {
        return purchaseFromDate;
    }

    public void setPurchaseFromDate(Timestamp purchaseFromDate) {
        this.purchaseFromDate = purchaseFromDate;
    }

    private Timestamp purchaseThruDate;

    @Basic
    @javax.persistence.Column(name = "PURCHASE_THRU_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getPurchaseThruDate() {
        return purchaseThruDate;
    }

    public void setPurchaseThruDate(Timestamp purchaseThruDate) {
        this.purchaseThruDate = purchaseThruDate;
    }

    private Integer useCountLimit;

    @Basic
    @javax.persistence.Column(name = "USE_COUNT_LIMIT", nullable = true, insertable = true, updatable = true, precision = 0)
    public Integer getUseCountLimit() {
        return useCountLimit;
    }

    public void setUseCountLimit(Integer useCountLimit) {
        this.useCountLimit = useCountLimit;
    }

    private Integer useTime;

    @Basic
    @javax.persistence.Column(name = "USE_TIME", nullable = true, insertable = true, updatable = true, precision = 0)
    public Integer getUseTime() {
        return useTime;
    }

    public void setUseTime(Integer useTime) {
        this.useTime = useTime;
    }

    private String useTimeUomId;

    @Basic
    @javax.persistence.Column(name = "USE_TIME_UOM_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getUseTimeUomId() {
        return useTimeUomId;
    }

    public void setUseTimeUomId(String useTimeUomId) {
        this.useTimeUomId = useTimeUomId;
    }

    private String useRoleTypeId;

    @Basic
    @javax.persistence.Column(name = "USE_ROLE_TYPE_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getUseRoleTypeId() {
        return useRoleTypeId;
    }

    public void setUseRoleTypeId(String useRoleTypeId) {
        this.useRoleTypeId = useRoleTypeId;
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

        ProductContent that = (ProductContent) o;

        if (contentId != null ? !contentId.equals(that.contentId) : that.contentId != null) return false;
        if (createdStamp != null ? !createdStamp.equals(that.createdStamp) : that.createdStamp != null) return false;
        if (createdTxStamp != null ? !createdTxStamp.equals(that.createdTxStamp) : that.createdTxStamp != null)
            return false;
        if (fromDate != null ? !fromDate.equals(that.fromDate) : that.fromDate != null) return false;
        if (lastUpdatedStamp != null ? !lastUpdatedStamp.equals(that.lastUpdatedStamp) : that.lastUpdatedStamp != null)
            return false;
        if (lastUpdatedTxStamp != null ? !lastUpdatedTxStamp.equals(that.lastUpdatedTxStamp) : that.lastUpdatedTxStamp != null)
            return false;
        if (productContentTypeId != null ? !productContentTypeId.equals(that.productContentTypeId) : that.productContentTypeId != null)
            return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (purchaseFromDate != null ? !purchaseFromDate.equals(that.purchaseFromDate) : that.purchaseFromDate != null)
            return false;
        if (purchaseThruDate != null ? !purchaseThruDate.equals(that.purchaseThruDate) : that.purchaseThruDate != null)
            return false;
        if (thruDate != null ? !thruDate.equals(that.thruDate) : that.thruDate != null) return false;
        if (useCountLimit != null ? !useCountLimit.equals(that.useCountLimit) : that.useCountLimit != null)
            return false;
        if (useRoleTypeId != null ? !useRoleTypeId.equals(that.useRoleTypeId) : that.useRoleTypeId != null)
            return false;
        if (useTime != null ? !useTime.equals(that.useTime) : that.useTime != null) return false;
        if (useTimeUomId != null ? !useTimeUomId.equals(that.useTimeUomId) : that.useTimeUomId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (contentId != null ? contentId.hashCode() : 0);
        result = 31 * result + (productContentTypeId != null ? productContentTypeId.hashCode() : 0);
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        result = 31 * result + (thruDate != null ? thruDate.hashCode() : 0);
        result = 31 * result + (purchaseFromDate != null ? purchaseFromDate.hashCode() : 0);
        result = 31 * result + (purchaseThruDate != null ? purchaseThruDate.hashCode() : 0);
        result = 31 * result + (useCountLimit != null ? useCountLimit.hashCode() : 0);
        result = 31 * result + (useTime != null ? useTime.hashCode() : 0);
        result = 31 * result + (useTimeUomId != null ? useTimeUomId.hashCode() : 0);
        result = 31 * result + (useRoleTypeId != null ? useRoleTypeId.hashCode() : 0);
        result = 31 * result + (lastUpdatedStamp != null ? lastUpdatedStamp.hashCode() : 0);
        result = 31 * result + (lastUpdatedTxStamp != null ? lastUpdatedTxStamp.hashCode() : 0);
        result = 31 * result + (createdStamp != null ? createdStamp.hashCode() : 0);
        result = 31 * result + (createdTxStamp != null ? createdTxStamp.hashCode() : 0);
        return result;
    }
}
