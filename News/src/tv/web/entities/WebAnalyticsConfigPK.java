package tv.web.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/1/2015
 * Time: 8:20 AM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
public class WebAnalyticsConfigPK implements Serializable {
    private String productStoreId;
    private String webAnalyticsTypeId;

    @Column(name = "PRODUCT_STORE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getProductStoreId() {
        return productStoreId;
    }

    public void setProductStoreId(String productStoreId) {
        this.productStoreId = productStoreId;
    }

    @Column(name = "WEB_ANALYTICS_TYPE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getWebAnalyticsTypeId() {
        return webAnalyticsTypeId;
    }

    public void setWebAnalyticsTypeId(String webAnalyticsTypeId) {
        this.webAnalyticsTypeId = webAnalyticsTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebAnalyticsConfigPK that = (WebAnalyticsConfigPK) o;

        if (productStoreId != null ? !productStoreId.equals(that.productStoreId) : that.productStoreId != null)
            return false;
        if (webAnalyticsTypeId != null ? !webAnalyticsTypeId.equals(that.webAnalyticsTypeId) : that.webAnalyticsTypeId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productStoreId != null ? productStoreId.hashCode() : 0;
        result = 31 * result + (webAnalyticsTypeId != null ? webAnalyticsTypeId.hashCode() : 0);
        return result;
    }
}
