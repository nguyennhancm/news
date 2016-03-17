package tv.news.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/1/2015
 * Time: 8:17 AM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
public class ProductTypeAttrPK implements Serializable {
    private String productTypeId;
    private String attrName;

    @Column(name = "PRODUCT_TYPE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
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

        ProductTypeAttrPK that = (ProductTypeAttrPK) o;

        if (attrName != null ? !attrName.equals(that.attrName) : that.attrName != null) return false;
        if (productTypeId != null ? !productTypeId.equals(that.productTypeId) : that.productTypeId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productTypeId != null ? productTypeId.hashCode() : 0;
        result = 31 * result + (attrName != null ? attrName.hashCode() : 0);
        return result;
    }
}
