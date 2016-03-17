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
@Table(name = "webslinger_server")
public class WebslingerServer implements Serializable {
    private String webslingerServerId;
    private String delegatorName;
    private String dispatcherName;
    private String serverName;
    private String target;
    private String loadAtStart;
    private Timestamp lastUpdatedStamp;
    private Timestamp lastUpdatedTxStamp;
    private Timestamp createdStamp;
    private Timestamp createdTxStamp;
    private WebSite webSiteByWebSiteId;

    @Id
    @Column(name = "WEBSLINGER_SERVER_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getWebslingerServerId() {
        return webslingerServerId;
    }

    public void setWebslingerServerId(String webslingerServerId) {
        this.webslingerServerId = webslingerServerId;
    }

    @Basic
    @Column(name = "DELEGATOR_NAME", nullable = true, insertable = true, updatable = true, length = 100)
    public String getDelegatorName() {
        return delegatorName;
    }

    public void setDelegatorName(String delegatorName) {
        this.delegatorName = delegatorName;
    }

    @Basic
    @Column(name = "DISPATCHER_NAME", nullable = true, insertable = true, updatable = true, length = 100)
    public String getDispatcherName() {
        return dispatcherName;
    }

    public void setDispatcherName(String dispatcherName) {
        this.dispatcherName = dispatcherName;
    }

    @Basic
    @Column(name = "SERVER_NAME", nullable = true, insertable = true, updatable = true, length = 100)
    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    @Basic
    @Column(name = "TARGET", nullable = true, insertable = true, updatable = true, length = 100)
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Basic
    @Column(name = "LOAD_AT_START", nullable = true, insertable = true, updatable = true, length = 1)
    public String getLoadAtStart() {
        return loadAtStart;
    }

    public void setLoadAtStart(String loadAtStart) {
        this.loadAtStart = loadAtStart;
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

        WebslingerServer that = (WebslingerServer) o;

        if (createdStamp != null ? !createdStamp.equals(that.createdStamp) : that.createdStamp != null) return false;
        if (createdTxStamp != null ? !createdTxStamp.equals(that.createdTxStamp) : that.createdTxStamp != null)
            return false;
        if (delegatorName != null ? !delegatorName.equals(that.delegatorName) : that.delegatorName != null)
            return false;
        if (dispatcherName != null ? !dispatcherName.equals(that.dispatcherName) : that.dispatcherName != null)
            return false;
        if (lastUpdatedStamp != null ? !lastUpdatedStamp.equals(that.lastUpdatedStamp) : that.lastUpdatedStamp != null)
            return false;
        if (lastUpdatedTxStamp != null ? !lastUpdatedTxStamp.equals(that.lastUpdatedTxStamp) : that.lastUpdatedTxStamp != null)
            return false;
        if (loadAtStart != null ? !loadAtStart.equals(that.loadAtStart) : that.loadAtStart != null) return false;
        if (serverName != null ? !serverName.equals(that.serverName) : that.serverName != null) return false;
        if (target != null ? !target.equals(that.target) : that.target != null) return false;
        if (webslingerServerId != null ? !webslingerServerId.equals(that.webslingerServerId) : that.webslingerServerId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = webslingerServerId != null ? webslingerServerId.hashCode() : 0;
        result = 31 * result + (delegatorName != null ? delegatorName.hashCode() : 0);
        result = 31 * result + (dispatcherName != null ? dispatcherName.hashCode() : 0);
        result = 31 * result + (serverName != null ? serverName.hashCode() : 0);
        result = 31 * result + (target != null ? target.hashCode() : 0);
        result = 31 * result + (loadAtStart != null ? loadAtStart.hashCode() : 0);
        result = 31 * result + (lastUpdatedStamp != null ? lastUpdatedStamp.hashCode() : 0);
        result = 31 * result + (lastUpdatedTxStamp != null ? lastUpdatedTxStamp.hashCode() : 0);
        result = 31 * result + (createdStamp != null ? createdStamp.hashCode() : 0);
        result = 31 * result + (createdTxStamp != null ? createdTxStamp.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "WEB_SITE_ID", referencedColumnName = "WEB_SITE_ID")
    public WebSite getWebSiteByWebSiteId() {
        return webSiteByWebSiteId;
    }

    public void setWebSiteByWebSiteId(WebSite webSiteByWebSiteId) {
        this.webSiteByWebSiteId = webSiteByWebSiteId;
    }
}
