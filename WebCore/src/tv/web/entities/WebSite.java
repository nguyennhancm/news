package tv.web.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/1/2015
 * Time: 8:20 AM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "web_site")
public class WebSite implements Serializable {
    private String webSiteId;
    private String siteName;
    private String httpHost;
    private String httpPort;
    private String httpsHost;
    private String httpsPort;
    private String enableHttps;
    private String standardContentPrefix;
    private String secureContentPrefix;
    private String cookieDomain;
    private Timestamp lastUpdatedStamp;
    private Timestamp lastUpdatedTxStamp;
    private Timestamp createdStamp;
    private Timestamp createdTxStamp;
    private String allowProductStoreChange;
//    private VisualThemeSet visualThemeSetByVisualThemeSetId;

    @Id
    @Column(name = "WEB_SITE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getWebSiteId() {
        return webSiteId;
    }

    public void setWebSiteId(String webSiteId) {
        this.webSiteId = webSiteId;
    }

    @Basic
    @Column(name = "SITE_NAME", nullable = true, insertable = true, updatable = true, length = 100)
    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    @Basic
    @Column(name = "HTTP_HOST", nullable = true, insertable = true, updatable = true, length = 255)
    public String getHttpHost() {
        return httpHost;
    }

    public void setHttpHost(String httpHost) {
        this.httpHost = httpHost;
    }

    @Basic
    @Column(name = "HTTP_PORT", nullable = true, insertable = true, updatable = true, length = 10)
    public String getHttpPort() {
        return httpPort;
    }

    public void setHttpPort(String httpPort) {
        this.httpPort = httpPort;
    }

    @Basic
    @Column(name = "HTTPS_HOST", nullable = true, insertable = true, updatable = true, length = 255)
    public String getHttpsHost() {
        return httpsHost;
    }

    public void setHttpsHost(String httpsHost) {
        this.httpsHost = httpsHost;
    }

    @Basic
    @Column(name = "HTTPS_PORT", nullable = true, insertable = true, updatable = true, length = 10)
    public String getHttpsPort() {
        return httpsPort;
    }

    public void setHttpsPort(String httpsPort) {
        this.httpsPort = httpsPort;
    }

    @Basic
    @Column(name = "ENABLE_HTTPS", nullable = true, insertable = true, updatable = true, length = 1)
    public String getEnableHttps() {
        return enableHttps;
    }

    public void setEnableHttps(String enableHttps) {
        this.enableHttps = enableHttps;
    }

    @Basic
    @Column(name = "STANDARD_CONTENT_PREFIX", nullable = true, insertable = true, updatable = true, length = 255)
    public String getStandardContentPrefix() {
        return standardContentPrefix;
    }

    public void setStandardContentPrefix(String standardContentPrefix) {
        this.standardContentPrefix = standardContentPrefix;
    }

    @Basic
    @Column(name = "SECURE_CONTENT_PREFIX", nullable = true, insertable = true, updatable = true, length = 255)
    public String getSecureContentPrefix() {
        return secureContentPrefix;
    }

    public void setSecureContentPrefix(String secureContentPrefix) {
        this.secureContentPrefix = secureContentPrefix;
    }

    @Basic
    @Column(name = "COOKIE_DOMAIN", nullable = true, insertable = true, updatable = true, length = 255)
    public String getCookieDomain() {
        return cookieDomain;
    }

    public void setCookieDomain(String cookieDomain) {
        this.cookieDomain = cookieDomain;
    }

    @Basic
    @Column(name = "LAST_UPDATED_STAMP", nullable = true, insertable = true, updatable = true)
    public Timestamp getLastUpdatedStamp() {
        return lastUpdatedStamp;
    }

    public void setLastUpdatedStamp(Timestamp lastUpdatedStamp) {
        this.lastUpdatedStamp = lastUpdatedStamp;
    }

    @Basic
    @Column(name = "LAST_UPDATED_TX_STAMP", nullable = true, insertable = true, updatable = true)
    public Timestamp getLastUpdatedTxStamp() {
        return lastUpdatedTxStamp;
    }

    public void setLastUpdatedTxStamp(Timestamp lastUpdatedTxStamp) {
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
    }

    @Basic
    @Column(name = "CREATED_STAMP", nullable = true, insertable = true, updatable = true)
    public Timestamp getCreatedStamp() {
        return createdStamp;
    }

    public void setCreatedStamp(Timestamp createdStamp) {
        this.createdStamp = createdStamp;
    }

    @Basic
    @Column(name = "CREATED_TX_STAMP", nullable = true, insertable = true, updatable = true)
    public Timestamp getCreatedTxStamp() {
        return createdTxStamp;
    }

    public void setCreatedTxStamp(Timestamp createdTxStamp) {
        this.createdTxStamp = createdTxStamp;
    }

    @Basic
    @Column(name = "ALLOW_PRODUCT_STORE_CHANGE", nullable = true, insertable = true, updatable = true, length = 1)
    public String getAllowProductStoreChange() {
        return allowProductStoreChange;
    }

    public void setAllowProductStoreChange(String allowProductStoreChange) {
        this.allowProductStoreChange = allowProductStoreChange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebSite webSite = (WebSite) o;

        if (allowProductStoreChange != null ? !allowProductStoreChange.equals(webSite.allowProductStoreChange) : webSite.allowProductStoreChange != null)
            return false;
        if (cookieDomain != null ? !cookieDomain.equals(webSite.cookieDomain) : webSite.cookieDomain != null)
            return false;
        if (createdStamp != null ? !createdStamp.equals(webSite.createdStamp) : webSite.createdStamp != null)
            return false;
        if (createdTxStamp != null ? !createdTxStamp.equals(webSite.createdTxStamp) : webSite.createdTxStamp != null)
            return false;
        if (enableHttps != null ? !enableHttps.equals(webSite.enableHttps) : webSite.enableHttps != null) return false;
        if (httpHost != null ? !httpHost.equals(webSite.httpHost) : webSite.httpHost != null) return false;
        if (httpPort != null ? !httpPort.equals(webSite.httpPort) : webSite.httpPort != null) return false;
        if (httpsHost != null ? !httpsHost.equals(webSite.httpsHost) : webSite.httpsHost != null) return false;
        if (httpsPort != null ? !httpsPort.equals(webSite.httpsPort) : webSite.httpsPort != null) return false;
        if (lastUpdatedStamp != null ? !lastUpdatedStamp.equals(webSite.lastUpdatedStamp) : webSite.lastUpdatedStamp != null)
            return false;
        if (lastUpdatedTxStamp != null ? !lastUpdatedTxStamp.equals(webSite.lastUpdatedTxStamp) : webSite.lastUpdatedTxStamp != null)
            return false;
        if (secureContentPrefix != null ? !secureContentPrefix.equals(webSite.secureContentPrefix) : webSite.secureContentPrefix != null)
            return false;
        if (siteName != null ? !siteName.equals(webSite.siteName) : webSite.siteName != null) return false;
        if (standardContentPrefix != null ? !standardContentPrefix.equals(webSite.standardContentPrefix) : webSite.standardContentPrefix != null)
            return false;
        if (webSiteId != null ? !webSiteId.equals(webSite.webSiteId) : webSite.webSiteId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = webSiteId != null ? webSiteId.hashCode() : 0;
        result = 31 * result + (siteName != null ? siteName.hashCode() : 0);
        result = 31 * result + (httpHost != null ? httpHost.hashCode() : 0);
        result = 31 * result + (httpPort != null ? httpPort.hashCode() : 0);
        result = 31 * result + (httpsHost != null ? httpsHost.hashCode() : 0);
        result = 31 * result + (httpsPort != null ? httpsPort.hashCode() : 0);
        result = 31 * result + (enableHttps != null ? enableHttps.hashCode() : 0);
        result = 31 * result + (standardContentPrefix != null ? standardContentPrefix.hashCode() : 0);
        result = 31 * result + (secureContentPrefix != null ? secureContentPrefix.hashCode() : 0);
        result = 31 * result + (cookieDomain != null ? cookieDomain.hashCode() : 0);
        result = 31 * result + (lastUpdatedStamp != null ? lastUpdatedStamp.hashCode() : 0);
        result = 31 * result + (lastUpdatedTxStamp != null ? lastUpdatedTxStamp.hashCode() : 0);
        result = 31 * result + (createdStamp != null ? createdStamp.hashCode() : 0);
        result = 31 * result + (createdTxStamp != null ? createdTxStamp.hashCode() : 0);
        result = 31 * result + (allowProductStoreChange != null ? allowProductStoreChange.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "VISUAL_THEME_SET_ID", referencedColumnName = "VISUAL_THEME_SET_ID")
//    public VisualThemeSet getVisualThemeSetByVisualThemeSetId() {
//        return visualThemeSetByVisualThemeSetId;
//    }
//
//    public void setVisualThemeSetByVisualThemeSetId(VisualThemeSet visualThemeSetByVisualThemeSetId) {
//        this.visualThemeSetByVisualThemeSetId = visualThemeSetByVisualThemeSetId;
//    }
}
