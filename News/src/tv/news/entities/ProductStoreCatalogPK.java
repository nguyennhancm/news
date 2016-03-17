package tv.news.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 5/31/2015
 * Time: 11:11 PM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
public class ProductStoreCatalogPK implements Serializable {
    private String productStoreId;
    private String prodCatalogId;
    private Timestamp fromDate;

    @Column(name = "PRODUCT_STORE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getProductStoreId() {
        return productStoreId;
    }

    public void setProductStoreId(String productStoreId) {
        this.productStoreId = productStoreId;
    }

    @Column(name = "PROD_CATALOG_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getProdCatalogId() {
        return prodCatalogId;
    }

    public void setProdCatalogId(String prodCatalogId) {
        this.prodCatalogId = prodCatalogId;
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

        ProductStoreCatalogPK that = (ProductStoreCatalogPK) o;

        if (fromDate != null ? !fromDate.equals(that.fromDate) : that.fromDate != null) return false;
        if (prodCatalogId != null ? !prodCatalogId.equals(that.prodCatalogId) : that.prodCatalogId != null)
            return false;
        if (productStoreId != null ? !productStoreId.equals(that.productStoreId) : that.productStoreId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productStoreId != null ? productStoreId.hashCode() : 0;
        result = 31 * result + (prodCatalogId != null ? prodCatalogId.hashCode() : 0);
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        return result;
    }
}
