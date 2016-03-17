package tv.news.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 5/31/2015
 * Time: 10:39 PM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
public class ProductContentPK implements Serializable {
    private String productId;

    @Column(name = "PRODUCT_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    private String contentId;

    @Column(name = "CONTENT_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    private String productContentTypeId;

    @Column(name = "PRODUCT_CONTENT_TYPE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getProductContentTypeId() {
        return productContentTypeId;
    }

    public void setProductContentTypeId(String productContentTypeId) {
        this.productContentTypeId = productContentTypeId;
    }

    private Timestamp fromDate;

    @Column(name = "FROM_DATE", nullable = false, insertable = true, updatable = true)
    @Id
    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductContentPK that = (ProductContentPK) o;

        if (contentId != null ? !contentId.equals(that.contentId) : that.contentId != null) return false;
        if (fromDate != null ? !fromDate.equals(that.fromDate) : that.fromDate != null) return false;
        if (productContentTypeId != null ? !productContentTypeId.equals(that.productContentTypeId) : that.productContentTypeId != null)
            return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (contentId != null ? contentId.hashCode() : 0);
        result = 31 * result + (productContentTypeId != null ? productContentTypeId.hashCode() : 0);
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        return result;
    }
}
