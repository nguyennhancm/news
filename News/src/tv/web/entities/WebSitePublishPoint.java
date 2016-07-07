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
@Table(name = "web_site_publish_point")
public class WebSitePublishPoint implements Serializable {
    private String contentId;
    private String templateTitle;
    private String styleSheetFile;
    private String logo;
    private String medallionLogo;
    private String lineLogo;
    private String leftBarId;
    private String rightBarId;
    private String contentDept;
    private String aboutContentId;
    private Timestamp lastUpdatedStamp;
    private Timestamp lastUpdatedTxStamp;
    private Timestamp createdStamp;
    private Timestamp createdTxStamp;

    @Id
    @Column(name = "CONTENT_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    @Basic
    @Column(name = "TEMPLATE_TITLE", nullable = true, insertable = true, updatable = true, length = 255)
    public String getTemplateTitle() {
        return templateTitle;
    }

    public void setTemplateTitle(String templateTitle) {
        this.templateTitle = templateTitle;
    }

    @Basic
    @Column(name = "STYLE_SHEET_FILE", nullable = true, insertable = true, updatable = true, length = 255)
    public String getStyleSheetFile() {
        return styleSheetFile;
    }

    public void setStyleSheetFile(String styleSheetFile) {
        this.styleSheetFile = styleSheetFile;
    }

    @Basic
    @Column(name = "LOGO", nullable = true, insertable = true, updatable = true, length = 255)
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Basic
    @Column(name = "MEDALLION_LOGO", nullable = true, insertable = true, updatable = true, length = 255)
    public String getMedallionLogo() {
        return medallionLogo;
    }

    public void setMedallionLogo(String medallionLogo) {
        this.medallionLogo = medallionLogo;
    }

    @Basic
    @Column(name = "LINE_LOGO", nullable = true, insertable = true, updatable = true, length = 255)
    public String getLineLogo() {
        return lineLogo;
    }

    public void setLineLogo(String lineLogo) {
        this.lineLogo = lineLogo;
    }

    @Basic
    @Column(name = "LEFT_BAR_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getLeftBarId() {
        return leftBarId;
    }

    public void setLeftBarId(String leftBarId) {
        this.leftBarId = leftBarId;
    }

    @Basic
    @Column(name = "RIGHT_BAR_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getRightBarId() {
        return rightBarId;
    }

    public void setRightBarId(String rightBarId) {
        this.rightBarId = rightBarId;
    }

    @Basic
    @Column(name = "CONTENT_DEPT", nullable = true, insertable = true, updatable = true, length = 20)
    public String getContentDept() {
        return contentDept;
    }

    public void setContentDept(String contentDept) {
        this.contentDept = contentDept;
    }

    @Basic
    @Column(name = "ABOUT_CONTENT_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getAboutContentId() {
        return aboutContentId;
    }

    public void setAboutContentId(String aboutContentId) {
        this.aboutContentId = aboutContentId;
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

        WebSitePublishPoint that = (WebSitePublishPoint) o;

        if (aboutContentId != null ? !aboutContentId.equals(that.aboutContentId) : that.aboutContentId != null)
            return false;
        if (contentDept != null ? !contentDept.equals(that.contentDept) : that.contentDept != null) return false;
        if (contentId != null ? !contentId.equals(that.contentId) : that.contentId != null) return false;
        if (createdStamp != null ? !createdStamp.equals(that.createdStamp) : that.createdStamp != null) return false;
        if (createdTxStamp != null ? !createdTxStamp.equals(that.createdTxStamp) : that.createdTxStamp != null)
            return false;
        if (lastUpdatedStamp != null ? !lastUpdatedStamp.equals(that.lastUpdatedStamp) : that.lastUpdatedStamp != null)
            return false;
        if (lastUpdatedTxStamp != null ? !lastUpdatedTxStamp.equals(that.lastUpdatedTxStamp) : that.lastUpdatedTxStamp != null)
            return false;
        if (leftBarId != null ? !leftBarId.equals(that.leftBarId) : that.leftBarId != null) return false;
        if (lineLogo != null ? !lineLogo.equals(that.lineLogo) : that.lineLogo != null) return false;
        if (logo != null ? !logo.equals(that.logo) : that.logo != null) return false;
        if (medallionLogo != null ? !medallionLogo.equals(that.medallionLogo) : that.medallionLogo != null)
            return false;
        if (rightBarId != null ? !rightBarId.equals(that.rightBarId) : that.rightBarId != null) return false;
        if (styleSheetFile != null ? !styleSheetFile.equals(that.styleSheetFile) : that.styleSheetFile != null)
            return false;
        if (templateTitle != null ? !templateTitle.equals(that.templateTitle) : that.templateTitle != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contentId != null ? contentId.hashCode() : 0;
        result = 31 * result + (templateTitle != null ? templateTitle.hashCode() : 0);
        result = 31 * result + (styleSheetFile != null ? styleSheetFile.hashCode() : 0);
        result = 31 * result + (logo != null ? logo.hashCode() : 0);
        result = 31 * result + (medallionLogo != null ? medallionLogo.hashCode() : 0);
        result = 31 * result + (lineLogo != null ? lineLogo.hashCode() : 0);
        result = 31 * result + (leftBarId != null ? leftBarId.hashCode() : 0);
        result = 31 * result + (rightBarId != null ? rightBarId.hashCode() : 0);
        result = 31 * result + (contentDept != null ? contentDept.hashCode() : 0);
        result = 31 * result + (aboutContentId != null ? aboutContentId.hashCode() : 0);
        result = 31 * result + (lastUpdatedStamp != null ? lastUpdatedStamp.hashCode() : 0);
        result = 31 * result + (lastUpdatedTxStamp != null ? lastUpdatedTxStamp.hashCode() : 0);
        result = 31 * result + (createdStamp != null ? createdStamp.hashCode() : 0);
        result = 31 * result + (createdTxStamp != null ? createdTxStamp.hashCode() : 0);
        return result;
    }
}
