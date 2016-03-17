package tv.news.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 5/31/2015
 * Time: 10:38 PM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
public class ProductCategoryRollupPK implements Serializable {
    private String productCategoryId;
    private String parentProductCategoryId;
    private Timestamp fromDate;

    @Column(name = "PRODUCT_CATEGORY_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(String productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    @Column(name = "PARENT_PRODUCT_CATEGORY_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getParentProductCategoryId() {
        return parentProductCategoryId;
    }

    public void setParentProductCategoryId(String parentProductCategoryId) {
        this.parentProductCategoryId = parentProductCategoryId;
    }

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

        ProductCategoryRollupPK that = (ProductCategoryRollupPK) o;

        if (fromDate != null ? !fromDate.equals(that.fromDate) : that.fromDate != null) return false;
        if (parentProductCategoryId != null ? !parentProductCategoryId.equals(that.parentProductCategoryId) : that.parentProductCategoryId != null)
            return false;
        if (productCategoryId != null ? !productCategoryId.equals(that.productCategoryId) : that.productCategoryId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productCategoryId != null ? productCategoryId.hashCode() : 0;
        result = 31 * result + (parentProductCategoryId != null ? parentProductCategoryId.hashCode() : 0);
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        return result;
    }
}
