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
@Table(name = "web_page")
public class WebPage implements Serializable {
    private String webPageId;
    private String pageName;
    private Timestamp lastUpdatedStamp;
    private Timestamp lastUpdatedTxStamp;
    private Timestamp createdStamp;
    private Timestamp createdTxStamp;

    @Id
    @Column(name = "WEB_PAGE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getWebPageId() {
        return webPageId;
    }

    public void setWebPageId(String webPageId) {
        this.webPageId = webPageId;
    }

    @Basic
    @Column(name = "PAGE_NAME", nullable = true, insertable = true, updatable = true, length = 100)
    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
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

        WebPage webPage = (WebPage) o;

        if (createdStamp != null ? !createdStamp.equals(webPage.createdStamp) : webPage.createdStamp != null)
            return false;
        if (createdTxStamp != null ? !createdTxStamp.equals(webPage.createdTxStamp) : webPage.createdTxStamp != null)
            return false;
        if (lastUpdatedStamp != null ? !lastUpdatedStamp.equals(webPage.lastUpdatedStamp) : webPage.lastUpdatedStamp != null)
            return false;
        if (lastUpdatedTxStamp != null ? !lastUpdatedTxStamp.equals(webPage.lastUpdatedTxStamp) : webPage.lastUpdatedTxStamp != null)
            return false;
        if (pageName != null ? !pageName.equals(webPage.pageName) : webPage.pageName != null) return false;
        if (webPageId != null ? !webPageId.equals(webPage.webPageId) : webPage.webPageId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = webPageId != null ? webPageId.hashCode() : 0;
        result = 31 * result + (pageName != null ? pageName.hashCode() : 0);
        result = 31 * result + (lastUpdatedStamp != null ? lastUpdatedStamp.hashCode() : 0);
        result = 31 * result + (lastUpdatedTxStamp != null ? lastUpdatedTxStamp.hashCode() : 0);
        result = 31 * result + (createdStamp != null ? createdStamp.hashCode() : 0);
        result = 31 * result + (createdTxStamp != null ? createdTxStamp.hashCode() : 0);
        return result;
    }
}
