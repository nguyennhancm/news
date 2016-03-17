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
public class WebslingerServerBasePK implements Serializable {
    private String webslingerServerId;
    private String baseName;

    @Column(name = "WEBSLINGER_SERVER_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getWebslingerServerId() {
        return webslingerServerId;
    }

    public void setWebslingerServerId(String webslingerServerId) {
        this.webslingerServerId = webslingerServerId;
    }

    @Column(name = "BASE_NAME", nullable = false, insertable = true, updatable = true, length = 100)
    @Id
    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebslingerServerBasePK that = (WebslingerServerBasePK) o;

        if (baseName != null ? !baseName.equals(that.baseName) : that.baseName != null) return false;
        if (webslingerServerId != null ? !webslingerServerId.equals(that.webslingerServerId) : that.webslingerServerId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = webslingerServerId != null ? webslingerServerId.hashCode() : 0;
        result = 31 * result + (baseName != null ? baseName.hashCode() : 0);
        return result;
    }
}
