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
@Table(name = "view_preference")
@IdClass(ViewPreferencePK.class)
public class ViewPreference implements Serializable {
    private String viewPrefTypeId;
    private String userLoginId;
    private String viewPrefString;
    private Timestamp lastUpdatedStamp;
    private Timestamp lastUpdatedTxStamp;
    private Timestamp createdStamp;
    private Timestamp createdTxStamp;
    private ViewPrefType viewPrefTypeByViewPrefTypeId;
    private ViewPrefValueType viewPrefValueTypeByViewPrefValueTypeId;

    @Id
    @Column(name = "VIEW_PREF_TYPE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getViewPrefTypeId() {
        return viewPrefTypeId;
    }

    public void setViewPrefTypeId(String viewPrefTypeId) {
        this.viewPrefTypeId = viewPrefTypeId;
    }

    @Id
    @Column(name = "USER_LOGIN_ID", nullable = false, insertable = true, updatable = true, length = 250)
    public String getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    @Basic
    @Column(name = "VIEW_PREF_STRING", nullable = true, insertable = true, updatable = true, length = 255)
    public String getViewPrefString() {
        return viewPrefString;
    }

    public void setViewPrefString(String viewPrefString) {
        this.viewPrefString = viewPrefString;
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

        ViewPreference that = (ViewPreference) o;

        if (createdStamp != null ? !createdStamp.equals(that.createdStamp) : that.createdStamp != null) return false;
        if (createdTxStamp != null ? !createdTxStamp.equals(that.createdTxStamp) : that.createdTxStamp != null)
            return false;
        if (lastUpdatedStamp != null ? !lastUpdatedStamp.equals(that.lastUpdatedStamp) : that.lastUpdatedStamp != null)
            return false;
        if (lastUpdatedTxStamp != null ? !lastUpdatedTxStamp.equals(that.lastUpdatedTxStamp) : that.lastUpdatedTxStamp != null)
            return false;
        if (userLoginId != null ? !userLoginId.equals(that.userLoginId) : that.userLoginId != null) return false;
        if (viewPrefString != null ? !viewPrefString.equals(that.viewPrefString) : that.viewPrefString != null)
            return false;
        if (viewPrefTypeId != null ? !viewPrefTypeId.equals(that.viewPrefTypeId) : that.viewPrefTypeId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = viewPrefTypeId != null ? viewPrefTypeId.hashCode() : 0;
        result = 31 * result + (userLoginId != null ? userLoginId.hashCode() : 0);
        result = 31 * result + (viewPrefString != null ? viewPrefString.hashCode() : 0);
        result = 31 * result + (lastUpdatedStamp != null ? lastUpdatedStamp.hashCode() : 0);
        result = 31 * result + (lastUpdatedTxStamp != null ? lastUpdatedTxStamp.hashCode() : 0);
        result = 31 * result + (createdStamp != null ? createdStamp.hashCode() : 0);
        result = 31 * result + (createdTxStamp != null ? createdTxStamp.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "VIEW_PREF_TYPE_ID", referencedColumnName = "VIEW_PREF_TYPE_ID", nullable = false)
    public ViewPrefType getViewPrefTypeByViewPrefTypeId() {
        return viewPrefTypeByViewPrefTypeId;
    }

    public void setViewPrefTypeByViewPrefTypeId(ViewPrefType viewPrefTypeByViewPrefTypeId) {
        this.viewPrefTypeByViewPrefTypeId = viewPrefTypeByViewPrefTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "VIEW_PREF_VALUE_TYPE_ID", referencedColumnName = "VIEW_PREF_VALUE_TYPE_ID")
    public ViewPrefValueType getViewPrefValueTypeByViewPrefValueTypeId() {
        return viewPrefValueTypeByViewPrefValueTypeId;
    }

    public void setViewPrefValueTypeByViewPrefValueTypeId(ViewPrefValueType viewPrefValueTypeByViewPrefValueTypeId) {
        this.viewPrefValueTypeByViewPrefValueTypeId = viewPrefValueTypeByViewPrefValueTypeId;
    }
}
