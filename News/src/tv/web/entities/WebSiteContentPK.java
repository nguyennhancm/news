package tv.web.entities;

import javax.persistence.Column;
import javax.persistence.Id;
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
public class WebSiteContentPK implements Serializable {
    private String webSiteId;

    @Column(name = "WEB_SITE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getWebSiteId() {
        return webSiteId;
    }

    public void setWebSiteId(String webSiteId) {
        this.webSiteId = webSiteId;
    }

    private String contentId;

    @Column(name = "CONTENT_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    private String webSiteContentTypeId;

    @Column(name = "WEB_SITE_CONTENT_TYPE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getWebSiteContentTypeId() {
        return webSiteContentTypeId;
    }

    public void setWebSiteContentTypeId(String webSiteContentTypeId) {
        this.webSiteContentTypeId = webSiteContentTypeId;
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

        WebSiteContentPK that = (WebSiteContentPK) o;

        if (contentId != null ? !contentId.equals(that.contentId) : that.contentId != null) return false;
        if (fromDate != null ? !fromDate.equals(that.fromDate) : that.fromDate != null) return false;
        if (webSiteContentTypeId != null ? !webSiteContentTypeId.equals(that.webSiteContentTypeId) : that.webSiteContentTypeId != null)
            return false;
        if (webSiteId != null ? !webSiteId.equals(that.webSiteId) : that.webSiteId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = webSiteId != null ? webSiteId.hashCode() : 0;
        result = 31 * result + (contentId != null ? contentId.hashCode() : 0);
        result = 31 * result + (webSiteContentTypeId != null ? webSiteContentTypeId.hashCode() : 0);
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        return result;
    }
}
