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
public class VisualThemeResourcePK implements Serializable {
    private String visualThemeId;
    private String resourceTypeEnumId;
    private String sequenceId;

    @Column(name = "VISUAL_THEME_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getVisualThemeId() {
        return visualThemeId;
    }

    public void setVisualThemeId(String visualThemeId) {
        this.visualThemeId = visualThemeId;
    }

    @Column(name = "RESOURCE_TYPE_ENUM_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getResourceTypeEnumId() {
        return resourceTypeEnumId;
    }

    public void setResourceTypeEnumId(String resourceTypeEnumId) {
        this.resourceTypeEnumId = resourceTypeEnumId;
    }

    @Column(name = "SEQUENCE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VisualThemeResourcePK that = (VisualThemeResourcePK) o;

        if (resourceTypeEnumId != null ? !resourceTypeEnumId.equals(that.resourceTypeEnumId) : that.resourceTypeEnumId != null)
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
        return result;
    }
}
