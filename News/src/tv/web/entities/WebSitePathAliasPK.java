package tv.web.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/1/2015
 * Time: 8:20 AM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
public class WebSitePathAliasPK implements Serializable {
    private String webSiteId;
    private String pathAlias;

    @Column(name = "WEB_SITE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getWebSiteId() {
        return webSiteId;
    }

    public void setWebSiteId(String webSiteId) {
        this.webSiteId = webSiteId;
    }

    @Column(name = "PATH_ALIAS", nullable = false, insertable = true, updatable = true, length = 250)
    @Id
    public String getPathAlias() {
        return pathAlias;
    }

    public void setPathAlias(String pathAlias) {
        this.pathAlias = pathAlias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebSitePathAliasPK that = (WebSitePathAliasPK) o;

        if (pathAlias != null ? !pathAlias.equals(that.pathAlias) : that.pathAlias != null) return false;
        if (webSiteId != null ? !webSiteId.equals(that.webSiteId) : that.webSiteId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = webSiteId != null ? webSiteId.hashCode() : 0;
        result = 31 * result + (pathAlias != null ? pathAlias.hashCode() : 0);
        return result;
    }
}
