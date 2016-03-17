package tv.view.entities;

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
@Table(name = "view_history")
public class ViewHistory implements Serializable{
    private String viewHistoryId;
    private String uri;
    private String userLoginId;
    private String applicationName;
    private String webAppName;
    private String contextInfo;
    private Timestamp expireAt;
    private String digest;
    private Timestamp lastUpdatedStamp;
    private Timestamp lastUpdatedTxStamp;
    private Timestamp createdStamp;
    private Timestamp createdTxStamp;

    @Id
    @Column(name = "VIEW_HISTORY_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getViewHistoryId() {
        return viewHistoryId;
    }

    public void setViewHistoryId(String viewHistoryId) {
        this.viewHistoryId = viewHistoryId;
    }

    @Basic
    @Column(name = "URI", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Basic
    @Column(name = "USER_LOGIN_ID", nullable = true, insertable = true, updatable = true, length = 255)
    public String getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    @Basic
    @Column(name = "APPLICATION_NAME", nullable = true, insertable = true, updatable = true, length = 100)
    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    @Basic
    @Column(name = "WEB_APP_NAME", nullable = true, insertable = true, updatable = true, length = 100)
    public String getWebAppName() {
        return webAppName;
    }

    public void setWebAppName(String webAppName) {
        this.webAppName = webAppName;
    }

    @Basic
    @Column(name = "CONTEXT_INFO", nullable = true, insertable = true, updatable = true, length = 255)
    public String getContextInfo() {
        return contextInfo;
    }

    public void setContextInfo(String contextInfo) {
        this.contextInfo = contextInfo;
    }

    @Basic
    @Column(name = "EXPIRE_AT", nullable = true, insertable = true, updatable = true)
    public Timestamp getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(Timestamp expireAt) {
        this.expireAt = expireAt;
    }

    @Basic
    @Column(name = "DIGEST", nullable = true, insertable = true, updatable = true, length = 255)
    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
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

        ViewHistory that = (ViewHistory) o;

        if (applicationName != null ? !applicationName.equals(that.applicationName) : that.applicationName != null)
            return false;
        if (contextInfo != null ? !contextInfo.equals(that.contextInfo) : that.contextInfo != null) return false;
        if (createdStamp != null ? !createdStamp.equals(that.createdStamp) : that.createdStamp != null) return false;
        if (createdTxStamp != null ? !createdTxStamp.equals(that.createdTxStamp) : that.createdTxStamp != null)
            return false;
        if (digest != null ? !digest.equals(that.digest) : that.digest != null) return false;
        if (expireAt != null ? !expireAt.equals(that.expireAt) : that.expireAt != null) return false;
        if (lastUpdatedStamp != null ? !lastUpdatedStamp.equals(that.lastUpdatedStamp) : that.lastUpdatedStamp != null)
            return false;
        if (lastUpdatedTxStamp != null ? !lastUpdatedTxStamp.equals(that.lastUpdatedTxStamp) : that.lastUpdatedTxStamp != null)
            return false;
        if (uri != null ? !uri.equals(that.uri) : that.uri != null) return false;
        if (userLoginId != null ? !userLoginId.equals(that.userLoginId) : that.userLoginId != null) return false;
        if (viewHistoryId != null ? !viewHistoryId.equals(that.viewHistoryId) : that.viewHistoryId != null)
            return false;
        if (webAppName != null ? !webAppName.equals(that.webAppName) : that.webAppName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = viewHistoryId != null ? viewHistoryId.hashCode() : 0;
        result = 31 * result + (uri != null ? uri.hashCode() : 0);
        result = 31 * result + (userLoginId != null ? userLoginId.hashCode() : 0);
        result = 31 * result + (applicationName != null ? applicationName.hashCode() : 0);
        result = 31 * result + (webAppName != null ? webAppName.hashCode() : 0);
        result = 31 * result + (contextInfo != null ? contextInfo.hashCode() : 0);
        result = 31 * result + (expireAt != null ? expireAt.hashCode() : 0);
        result = 31 * result + (digest != null ? digest.hashCode() : 0);
        result = 31 * result + (lastUpdatedStamp != null ? lastUpdatedStamp.hashCode() : 0);
        result = 31 * result + (lastUpdatedTxStamp != null ? lastUpdatedTxStamp.hashCode() : 0);
        result = 31 * result + (createdStamp != null ? createdStamp.hashCode() : 0);
        result = 31 * result + (createdTxStamp != null ? createdTxStamp.hashCode() : 0);
        return result;
    }
}
