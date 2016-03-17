package service.email.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 10/5/2015
 * Time: 3:48 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "template")
public class Template {
    private String templateId;
    private String userId;
    private String statusId;
    private String templateName;
    private String description;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String fileName;
    private String title;

    @Id
    @Column(name = "template_id", nullable = false, insertable = true, updatable = true, length = 20)
    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    @Basic
    @Column(name = "user_id", nullable = false, insertable = true, updatable = true, length = 255)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "status_id", nullable = true, insertable = true, updatable = true, length = 20)
    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "template_name", nullable = true, insertable = true, updatable = true, length = 255)
    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "create_time", nullable = true, insertable = true, updatable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time", nullable = true, insertable = true, updatable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "file_name", nullable = true, insertable = true, updatable = true, length = 255)
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Basic
    @Column(name = "title", nullable = true, insertable = true, updatable = true, length = 4000)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Template template = (Template) o;

        if (createTime != null ? !createTime.equals(template.createTime) : template.createTime != null) return false;
        if (description != null ? !description.equals(template.description) : template.description != null)
            return false;
        if (fileName != null ? !fileName.equals(template.fileName) : template.fileName != null) return false;
        if (statusId != null ? !statusId.equals(template.statusId) : template.statusId != null) return false;
        if (templateId != null ? !templateId.equals(template.templateId) : template.templateId != null) return false;
        if (templateName != null ? !templateName.equals(template.templateName) : template.templateName != null)
            return false;
        if (title != null ? !title.equals(template.title) : template.title != null) return false;
        if (updateTime != null ? !updateTime.equals(template.updateTime) : template.updateTime != null) return false;
        if (userId != null ? !userId.equals(template.userId) : template.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = templateId != null ? templateId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (templateName != null ? templateName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
