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
@Table(name = "visual_theme_resource")
@IdClass(VisualThemeResourcePK.class)
public class VisualThemeResource implements Serializable {
    private String visualThemeId;
    private String resourceTypeEnumId;
    private String sequenceId;
    private String resourceValue;
    private Timestamp lastUpdatedStamp;
    private Timestamp lastUpdatedTxStamp;
    private Timestamp createdStamp;
    private Timestamp createdTxStamp;

    @Id
    @Column(name = "VISUAL_THEME_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getVisualThemeId() {
        return visualThemeId;
    }

    public void setVisualThemeId(String visualThemeId) {
        this.visualThemeId = visualThemeId;
    }

    @Id
    @Column(name = "RESOURCE_TYPE_ENUM_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getResourceTypeEnumId() {
        return resourceTypeEnumId;
    }

    public void setResourceTypeEnumId(String resourceTypeEnumId) {
        this.resourceTypeEnumId = resourceTypeEnumId;
    }

    @Id
    @Column(name = "SEQUENCE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
    }

    @Basic
    @Column(name = "RESOURCE_VALUE", nullable = true, insertable = true, updatable = true, length = 255)
    public String getResourceValue() {
        return resourceValue;
    }

    public void setResourceValue(String resourceValue) {
        this.resourceValue = resourceValue;
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

        VisualThemeResource that = (VisualThemeResource) o;

        if (createdStamp != null ? !createdStamp.equals(that.createdStamp) : that.createdStamp != null) return false;
        if (createdTxStamp != null ? !createdTxStamp.equals(that.createdTxStamp) : that.createdTxStamp != null)
            return false;
        if (lastUpdatedStamp != null ? !lastUpdatedStamp.equals(that.lastUpdatedStamp) : that.lastUpdatedStamp != null)
            return false;
        if (lastUpdatedTxStamp != null ? !lastUpdatedTxStamp.equals(that.lastUpdatedTxStamp) : that.lastUpdatedTxStamp != null)
            return false;
        if (resourceTypeEnumId != null ? !resourceTypeEnumId.equals(that.resourceTypeEnumId) : that.resourceTypeEnumId != null)
            return false;
        if (resourceValue != null ? !resourceValue.equals(that.resourceValue) : that.resourceValue != null)
            return false;
        if (sequenceId != null ? !sequenceId.equals(that.sequenceId) : that.sequenceId != null) return false;
        if (visualThemeId != null ? !visualThemeId.equals(that.visualThemeId) : that.visualThemeId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = visualThemeId != null ? visualThemeId.hashCode() : 0;
        result = 31 * result + (resourceTypeEnumId != null ? resourceTypeEnumId.hashCode() : 0);
        result = 31 * result + (sequenceId != null ? sequenceId.hashCode() : 0);
        result = 31 * result + (resourceValue != null ? resourceValue.hashCode() : 0);
        result = 31 * result + (lastUpdatedStamp != null ? lastUpdatedStamp.hashCode() : 0);
        result = 31 * result + (lastUpdatedTxStamp != null ? lastUpdatedTxStamp.hashCode() : 0);
        result = 31 * result + (createdStamp != null ? createdStamp.hashCode() : 0);
        result = 31 * result + (createdTxStamp != null ? createdTxStamp.hashCode() : 0);
        return result;
    }

}
