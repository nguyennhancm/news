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
public class WebslingerHostMappingPK implements Serializable {
    private String hostName;
    private String contextPath;

    @Column(name = "HOST_NAME", nullable = false, insertable = true, updatable = true, length = 100)
    @Id
    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    @Column(name = "CONTEXT_PATH", nullable = false, insertable = true, updatable = true, length = 255)
    @Id
    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebslingerHostMappingPK that = (WebslingerHostMappingPK) o;

        if (contextPath != null ? !contextPath.equals(that.contextPath) : that.contextPath != null) return false;
        if (hostName != null ? !hostName.equals(that.hostName) : that.hostName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hostName != null ? hostName.hashCode() : 0;
        result = 31 * result + (contextPath != null ? contextPath.hashCode() : 0);
        return result;
    }
}
