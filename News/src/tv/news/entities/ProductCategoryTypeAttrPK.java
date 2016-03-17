package tv.news.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 5/31/2015
 * Time: 10:38 PM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
public class ProductCategoryTypeAttrPK implements Serializable {
    private String productCategoryTypeId;
    private String attrName;

    @Column(name = "PRODUCT_CATEGORY_TYPE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getProductCategoryTypeId() {
        return productCategoryTypeId;
    }

    public void setProductCategoryTypeId(String productCategoryTypeId) {
        this.productCategoryTypeId = productCategoryTypeId;
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

        ProductCategoryTypeAttrPK that = (ProductCategoryTypeAttrPK) o;

        if (attrName != null ? !attrName.equals(that.attrName) : that.attrName != null) return false;
        if (productCategoryTypeId != null ? !productCategoryTypeId.equals(that.productCategoryTypeId) : that.productCategoryTypeId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productCategoryTypeId != null ? productCategoryTypeId.hashCode() : 0;
        result = 31 * result + (attrName != null ? attrName.hashCode() : 0);
        return result;
    }
}
