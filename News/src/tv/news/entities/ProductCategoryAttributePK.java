package tv.news.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 5/31/2015
 * Time: 10:37 PM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
public class ProductCategoryAttributePK implements Serializable {
    private String productCategoryId;
    private String attrName;

    @Column(name = "PRODUCT_CATEGORY_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(String productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    @Column(name = "ATTR_NAME", nullable = false, insertable = true, updatable = true, length = 60)
    @Id
    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductCategoryAttributePK that = (ProductCategoryAttributePK) o;

        if (attrName != null ? !attrName.equals(that.attrName) : that.attrName != null) return false;
        if (productCategoryId != null ? !productCategoryId.equals(that.productCategoryId) : that.productCategoryId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productCategoryId != null ? productCategoryId.hashCode() : 0;
        result = 31 * result + (attrName != null ? attrName.hashCode() : 0);
        return result;
    }
}
