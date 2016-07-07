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
@Table(name = "web_site_path_alias")
@IdClass(WebSitePathAliasPK.class)
public class WebSitePathAlias implements Serializable {
    private String webSiteId;
    private String pathAlias;
    private String aliasTo;
    private String mapKey;
    private Timestamp lastUpdatedStamp;
    private Timestamp lastUpdatedTxStamp;
    private Timestamp createdStamp;
    private Timestamp createdTxStamp;
    private WebSite webSiteByWebSiteId;

    @Id
    @Column(name = "WEB_SITE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getWebSiteId() {
        return webSiteId;
    }

    public void setWebSiteId(String webSiteId) {
        this.webSiteId = webSiteId;
    }

    @Id
    @Column(name = "PATH_ALIAS", nullable = false, insertable = true, updatable = true, length = 250)
    public String getPathAlias() {
        return pathAlias;
    }

    public void setPathAlias(String pathAlias) {
        this.pathAlias = pathAlias;
    }

    @Basic
    @Column(name = "ALIAS_TO", nullable = true, insertable = true, updatable = true, length = 255)
    public String getAliasTo() {
        return aliasTo;
    }

    public void setAliasTo(String aliasTo) {
        this.aliasTo = aliasTo;
    }

    @Basic
    @Column(name = "MAP_KEY", nullable = true, insertable = true, updatable = true, length = 100)
    public String getMapKey() {
        return mapKey;
    }

    public void setMapKey(String mapKey) {
        this.mapKey = mapKey;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebSitePathAlias that = (WebSitePathAlias) o;

        if (aliasTo != null ? !aliasTo.equals(that.aliasTo) : that.aliasTo != null) return false;
        if (createdStamp != null ? !createdStamp.equals(that.createdStamp) : that.createdStamp != null) return false;
        if (createdTxStamp != null ? !createdTxStamp.equals(that.createdTxStamp) : that.createdTxStamp != null)
            return false;
        if (lastUpdatedStamp != null ? !lastUpdatedStamp.equals(that.lastUpdatedStamp) : that.lastUpdatedStamp != null)
            return false;
        if (lastUpdatedTxStamp != null ? !lastUpdatedTxStamp.equals(that.lastUpdatedTxStamp) : that.lastUpdatedTxStamp != null)
            return false;
        if (mapKey != null ? !mapKey.equals(that.mapKey) : that.mapKey != null) return false;
        if (pathAlias != null ? !pathAlias.equals(that.pathAlias) : that.pathAlias != null) return false;
        if (webSiteId != null ? !webSiteId.equals(that.webSiteId) : that.webSiteId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = webSiteId != null ? webSiteId.hashCode() : 0;
        result = 31 * result + (pathAlias != null ? pathAlias.hashCode() : 0);
        result = 31 * result + (aliasTo != null ? aliasTo.hashCode() : 0);
        result = 31 * result + (mapKey != null ? mapKey.hashCode() : 0);
        result = 31 * result + (lastUpdatedStamp != null ? lastUpdatedStamp.hashCode() : 0);
        result = 31 * result + (lastUpdatedTxStamp != null ? lastUpdatedTxStamp.hashCode() : 0);
        result = 31 * result + (createdStamp != null ? createdStamp.hashCode() : 0);
        result = 31 * result + (createdTxStamp != null ? createdTxStamp.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "WEB_SITE_ID", referencedColumnName = "WEB_SITE_ID", nullable = false)
//    public WebSite getWebSiteByWebSiteId() {
//        return webSiteByWebSiteId;
//    }
//
//    public void setWebSiteByWebSiteId(WebSite webSiteByWebSiteId) {
//        this.webSiteByWebSiteId = webSiteByWebSiteId;
//    }
}
