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
@Table(name = "web_analytics_config")
@IdClass(WebAnalyticsConfigPK.class)
public class WebAnalyticsConfig implements Serializable {
    private String productStoreId;
    private String webAnalyticsTypeId;
    private String webAnalyticsCode;
    private String isEnabled;
    private String description;
    private String contentId;
    private Timestamp lastUpdatedStamp;
    private Timestamp lastUpdatedTxStamp;
    private Timestamp createdStamp;
    private Timestamp createdTxStamp;

    @Id
    @Column(name = "PRODUCT_STORE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getProductStoreId() {
        return productStoreId;
    }

    public void setProductStoreId(String productStoreId) {
        this.productStoreId = productStoreId;
    }

    @Id
    @Column(name = "WEB_ANALYTICS_TYPE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getWebAnalyticsTypeId() {
        return webAnalyticsTypeId;
    }

    public void setWebAnalyticsTypeId(String webAnalyticsTypeId) {
        this.webAnalyticsTypeId = webAnalyticsTypeId;
    }

    @Basic
    @Column(name = "WEB_ANALYTICS_CODE", nullable = true, insertable = true, updatable = true, length = 255)
    public String getWebAnalyticsCode() {
        return webAnalyticsCode;
    }

    public void setWebAnalyticsCode(String webAnalyticsCode) {
        this.webAnalyticsCode = webAnalyticsCode;
    }

    @Basic
    @Column(name = "IS_ENABLED", nullable = true, insertable = true, updatable = true, length = 1)
    public String getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(String isEnabled) {
        this.isEnabled = isEnabled;
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
    @Column(name = "CONTENT_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
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

        WebAnalyticsConfig that = (WebAnalyticsConfig) o;

        if (contentId != null ? !contentId.equals(that.contentId) : that.contentId != null) return false;
        if (createdStamp != null ? !createdStamp.equals(that.createdStamp) : that.createdStamp != null) return false;
        if (createdTxStamp != null ? !createdTxStamp.equals(that.createdTxStamp) : that.createdTxStamp != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (isEnabled != null ? !isEnabled.equals(that.isEnabled) : that.isEnabled != null) return false;
        if (lastUpdatedStamp != null ? !lastUpdatedStamp.equals(that.lastUpdatedStamp) : that.lastUpdatedStamp != null)
            return false;
        if (lastUpdatedTxStamp != null ? !lastUpdatedTxStamp.equals(that.lastUpdatedTxStamp) : that.lastUpdatedTxStamp != null)
            return false;
        if (productStoreId != null ? !productStoreId.equals(that.productStoreId) : that.productStoreId != null)
            return false;
        if (webAnalyticsCode != null ? !webAnalyticsCode.equals(that.webAnalyticsCode) : that.webAnalyticsCode != null)
            return false;
        if (webAnalyticsTypeId != null ? !webAnalyticsTypeId.equals(that.webAnalyticsTypeId) : that.webAnalyticsTypeId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productStoreId != null ? productStoreId.hashCode() : 0;
        result = 31 * result + (webAnalyticsTypeId != null ? webAnalyticsTypeId.hashCode() : 0);
        result = 31 * result + (webAnalyticsCode != null ? webAnalyticsCode.hashCode() : 0);
        result = 31 * result + (isEnabled != null ? isEnabled.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (contentId != null ? contentId.hashCode() : 0);
        result = 31 * result + (lastUpdatedStamp != null ? lastUpdatedStamp.hashCode() : 0);
        result = 31 * result + (lastUpdatedTxStamp != null ? lastUpdatedTxStamp.hashCode() : 0);
        result = 31 * result + (createdStamp != null ? createdStamp.hashCode() : 0);
        result = 31 * result + (createdTxStamp != null ? createdTxStamp.hashCode() : 0);
        return result;
    }
}
