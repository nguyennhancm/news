package tv.news.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 5/31/2015
 * Time: 10:34 PM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
public class ProdCatalogCategoryPK implements Serializable {
    private String prodCatalogId;

    @Column(name = "PROD_CATALOG_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getProdCatalogId() {
        return prodCatalogId;
    }

    public void setProdCatalogId(String prodCatalogId) {
        this.prodCatalogId = prodCatalogId;
    }

    private String productCategoryId;

    @Column(name = "PRODUCT_CATEGORY_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(String productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    private String prodCatalogCategoryTypeId;

    @Column(name = "PROD_CATALOG_CATEGORY_TYPE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getProdCatalogCategoryTypeId() {
        return prodCatalogCategoryTypeId;
    }

    public void setProdCatalogCategoryTypeId(String prodCatalogCategoryTypeId) {
        this.prodCatalogCategoryTypeId = prodCatalogCategoryTypeId;
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

        ProdCatalogCategoryPK that = (ProdCatalogCategoryPK) o;

        if (fromDate != null ? !fromDate.equals(that.fromDate) : that.fromDate != null) return false;
        if (prodCatalogCategoryTypeId != null ? !prodCatalogCategoryTypeId.equals(that.prodCatalogCategoryTypeId) : that.prodCatalogCategoryTypeId != null)
            return false;
        if (prodCatalogId != null ? !prodCatalogId.equals(that.prodCatalogId) : that.prodCatalogId != null)
            return false;
        if (productCategoryId != null ? !productCategoryId.equals(that.productCategoryId) : that.productCategoryId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = prodCatalogId != null ? prodCatalogId.hashCode() : 0;
        result = 31 * result + (productCategoryId != null ? productCategoryId.hashCode() : 0);
        result = 31 * result + (prodCatalogCategoryTypeId != null ? prodCatalogCategoryTypeId.hashCode() : 0);
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        return result;
    }
}
