package tv.news.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 5/31/2015
 * Time: 10:36 PM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
public class ProductAttributePK implements Serializable {
    private String productId;
    private String attrName;

    @Column(name = "PRODUCT_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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

        ProductAttributePK that = (ProductAttributePK) o;

        if (attrName != null ? !attrName.equals(that.attrName) : that.attrName != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (attrName != null ? attrName.hashCode() : 0);
        return result;
    }
}
