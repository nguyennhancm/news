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
@Table(name = "webslinger_server_base")
@IdClass(WebslingerServerBasePK.class)
public class WebslingerServerBase implements Serializable {
    private String webslingerServerId;
    private String baseName;
    private Integer seqNum;
    private Timestamp lastUpdatedStamp;
    private Timestamp lastUpdatedTxStamp;
    private Timestamp createdStamp;
    private Timestamp createdTxStamp;
    private WebslingerServer webslingerServerByWebslingerServerId;

    @Id
    @Column(name = "WEBSLINGER_SERVER_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getWebslingerServerId() {
        return webslingerServerId;
    }

    public void setWebslingerServerId(String webslingerServerId) {
        this.webslingerServerId = webslingerServerId;
    }

    @Id
    @Column(name = "BASE_NAME", nullable = false, insertable = true, updatable = true, length = 100)
    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    @Basic
    @Column(name = "SEQ_NUM", nullable = true, insertable = true, updatable = true, precision = 0)
    public Integer getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(Integer seqNum) {
        this.seqNum = seqNum;
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

        WebslingerServerBase that = (WebslingerServerBase) o;

        if (baseName != null ? !baseName.equals(that.baseName) : that.baseName != null) return false;
        if (createdStamp != null ? !createdStamp.equals(that.createdStamp) : that.createdStamp != null) return false;
        if (createdTxStamp != null ? !createdTxStamp.equals(that.createdTxStamp) : that.createdTxStamp != null)
            return false;
        if (lastUpdatedStamp != null ? !lastUpdatedStamp.equals(that.lastUpdatedStamp) : that.lastUpdatedStamp != null)
            return false;
        if (lastUpdatedTxStamp != null ? !lastUpdatedTxStamp.equals(that.lastUpdatedTxStamp) : that.lastUpdatedTxStamp != null)
            return false;
        if (seqNum != null ? !seqNum.equals(that.seqNum) : that.seqNum != null) return false;
        if (webslingerServerId != null ? !webslingerServerId.equals(that.webslingerServerId) : that.webslingerServerId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = webslingerServerId != null ? webslingerServerId.hashCode() : 0;
        result = 31 * result + (baseName != null ? baseName.hashCode() : 0);
        result = 31 * result + (seqNum != null ? seqNum.hashCode() : 0);
        result = 31 * result + (lastUpdatedStamp != null ? lastUpdatedStamp.hashCode() : 0);
        result = 31 * result + (lastUpdatedTxStamp != null ? lastUpdatedTxStamp.hashCode() : 0);
        result = 31 * result + (createdStamp != null ? createdStamp.hashCode() : 0);
        result = 31 * result + (createdTxStamp != null ? createdTxStamp.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "WEBSLINGER_SERVER_ID", referencedColumnName = "WEBSLINGER_SERVER_ID", nullable = false)
//    public WebslingerServer getWebslingerServerByWebslingerServerId() {
//        return webslingerServerByWebslingerServerId;
//    }
//
//    public void setWebslingerServerByWebslingerServerId(WebslingerServer webslingerServerByWebslingerServerId) {
//        this.webslingerServerByWebslingerServerId = webslingerServerByWebslingerServerId;
//    }
}
