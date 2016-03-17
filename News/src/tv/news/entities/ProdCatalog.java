package tv.news.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
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
@Entity
@javax.persistence.Table(name = "prod_catalog")
public class ProdCatalog implements Serializable{
    private String prodCatalogId;

    @Id
    @javax.persistence.Column(name = "PROD_CATALOG_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getProdCatalogId() {
        return prodCatalogId;
    }

    public void setProdCatalogId(String prodCatalogId) {
        this.prodCatalogId = prodCatalogId;
    }

    private String catalogName;

    @Basic
    @javax.persistence.Column(name = "CATALOG_NAME", nullable = true, insertable = true, updatable = true, length = 100)
    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    private String useQuickAdd;

    @Basic
    @javax.persistence.Column(name = "USE_QUICK_ADD", nullable = true, insertable = true, updatable = true, length = 1)
    public String getUseQuickAdd() {
        return useQuickAdd;
    }

    public void setUseQuickAdd(String useQuickAdd) {
        this.useQuickAdd = useQuickAdd;
    }

    private String styleSheet;

    @Basic
    @javax.persistence.Column(name = "STYLE_SHEET", nullable = true, insertable = true, updatable = true, length = 255)
    public String getStyleSheet() {
        return styleSheet;
    }

    public void setStyleSheet(String styleSheet) {
        this.styleSheet = styleSheet;
    }

    private String headerLogo;

    @Basic
    @javax.persistence.Column(name = "HEADER_LOGO", nullable = true, insertable = true, updatable = true, length = 255)
    public String getHeaderLogo() {
        return headerLogo;
    }

    public void setHeaderLogo(String headerLogo) {
        this.headerLogo = headerLogo;
    }

    private String contentPathPrefix;

    @Basic
    @javax.persistence.Column(name = "CONTENT_PATH_PREFIX", nullable = true, insertable = true, updatable = true, length = 255)
    public String getContentPathPrefix() {
        return contentPathPrefix;
    }

    public void setContentPathPrefix(String contentPathPrefix) {
        this.contentPathPrefix = contentPathPrefix;
    }

    private String templatePathPrefix;

    @Basic
    @javax.persistence.Column(name = "TEMPLATE_PATH_PREFIX", nullable = true, insertable = true, updatable = true, length = 255)
    public String getTemplatePathPrefix() {
        return templatePathPrefix;
    }

    public void setTemplatePathPrefix(String templatePathPrefix) {
        this.templatePathPrefix = templatePathPrefix;
    }

    private String viewAllowPermReqd;

    @Basic
    @javax.persistence.Column(name = "VIEW_ALLOW_PERM_REQD", nullable = true, insertable = true, updatable = true, length = 1)
    public String getViewAllowPermReqd() {
        return viewAllowPermReqd;
    }

    public void setViewAllowPermReqd(String viewAllowPermReqd) {
        this.viewAllowPermReqd = viewAllowPermReqd;
    }

    private String purchaseAllowPermReqd;

    @Basic
    @javax.persistence.Column(name = "PURCHASE_ALLOW_PERM_REQD", nullable = true, insertable = true, updatable = true, length = 1)
    public String getPurchaseAllowPermReqd() {
        return purchaseAllowPermReqd;
    }

    public void setPurchaseAllowPermReqd(String purchaseAllowPermReqd) {
        this.purchaseAllowPermReqd = purchaseAllowPermReqd;
    }

    private Timestamp lastUpdatedStamp;

    @Basic
    @javax.persistence.Column(name = "LAST_UPDATED_STAMP", nullable = true, insertable = true, updatable = true)
    public Timestamp getLastUpdatedStamp() {
        return lastUpdatedStamp;
    }

    public void setLastUpdatedStamp(Timestamp lastUpdatedStamp) {
        this.lastUpdatedStamp = lastUpdatedStamp;
    }

    private Timestamp lastUpdatedTxStamp;

    @Basic
    @javax.persistence.Column(name = "LAST_UPDATED_TX_STAMP", nullable = true, insertable = true, updatable = true)
    public Timestamp getLastUpdatedTxStamp() {
        return lastUpdatedTxStamp;
    }

    public void setLastUpdatedTxStamp(Timestamp lastUpdatedTxStamp) {
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
    }

    private Timestamp createdStamp;

    @Basic
    @javax.persistence.Column(name = "CREATED_STAMP", nullable = true, insertable = true, updatable = true)
    public Timestamp getCreatedStamp() {
        return createdStamp;
    }

    public void setCreatedStamp(Timestamp createdStamp) {
        this.createdStamp = createdStamp;
    }

    private Timestamp createdTxStamp;

    @Basic
    @javax.persistence.Column(name = "CREATED_TX_STAMP", nullable = true, insertable = true, updatable = true)
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

        ProdCatalog that = (ProdCatalog) o;

        if (catalogName != null ? !catalogName.equals(that.catalogName) : that.catalogName != null) return false;
        if (contentPathPrefix != null ? !contentPathPrefix.equals(that.contentPathPrefix) : that.contentPathPrefix != null)
            return false;
        if (createdStamp != null ? !createdStamp.equals(that.createdStamp) : that.createdStamp != null) return false;
        if (createdTxStamp != null ? !createdTxStamp.equals(that.createdTxStamp) : that.createdTxStamp != null)
            return false;
        if (headerLogo != null ? !headerLogo.equals(that.headerLogo) : that.headerLogo != null) return false;
        if (lastUpdatedStamp != null ? !lastUpdatedStamp.equals(that.lastUpdatedStamp) : that.lastUpdatedStamp != null)
            return false;
        if (lastUpdatedTxStamp != null ? !lastUpdatedTxStamp.equals(that.lastUpdatedTxStamp) : that.lastUpdatedTxStamp != null)
            return false;
        if (prodCatalogId != null ? !prodCatalogId.equals(that.prodCatalogId) : that.prodCatalogId != null)
            return false;
        if (purchaseAllowPermReqd != null ? !purchaseAllowPermReqd.equals(that.purchaseAllowPermReqd) : that.purchaseAllowPermReqd != null)
            return false;
        if (styleSheet != null ? !styleSheet.equals(that.styleSheet) : that.styleSheet != null) return false;
        if (templatePathPrefix != null ? !templatePathPrefix.equals(that.templatePathPrefix) : that.templatePathPrefix != null)
            return false;
        if (useQuickAdd != null ? !useQuickAdd.equals(that.useQuickAdd) : that.useQuickAdd != null) return false;
        if (viewAllowPermReqd != null ? !viewAllowPermReqd.equals(that.viewAllowPermReqd) : that.viewAllowPermReqd != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = prodCatalogId != null ? prodCatalogId.hashCode() : 0;
        result = 31 * result + (catalogName != null ? catalogName.hashCode() : 0);
        result = 31 * result + (useQuickAdd != null ? useQuickAdd.hashCode() : 0);
        result = 31 * result + (styleSheet != null ? styleSheet.hashCode() : 0);
        result = 31 * result + (headerLogo != null ? headerLogo.hashCode() : 0);
        result = 31 * result + (contentPathPrefix != null ? contentPathPrefix.hashCode() : 0);
        result = 31 * result + (templatePathPrefix != null ? templatePathPrefix.hashCode() : 0);
        result = 31 * result + (viewAllowPermReqd != null ? viewAllowPermReqd.hashCode() : 0);
        result = 31 * result + (purchaseAllowPermReqd != null ? purchaseAllowPermReqd.hashCode() : 0);
        result = 31 * result + (lastUpdatedStamp != null ? lastUpdatedStamp.hashCode() : 0);
        result = 31 * result + (lastUpdatedTxStamp != null ? lastUpdatedTxStamp.hashCode() : 0);
        result = 31 * result + (createdStamp != null ? createdStamp.hashCode() : 0);
        result = 31 * result + (createdTxStamp != null ? createdTxStamp.hashCode() : 0);
        return result;
    }
}
