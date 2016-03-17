package service.email.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 10/8/2015
 * Time: 9:36 AM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "send_email")
public class SendEmail implements Serializable{
    private String sendEmailId;
    private String cc;
    private String bcc;
    private String subject;
    private String content;
    private String description;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String emailTo;
    private String statusId;
    private String templateId;
    private String emailFrom;
    private String fileId;

    @Id
    @Column(name = "send_email_id", nullable = false, insertable = true, updatable = true, length = 20)
    public String getSendEmailId() {
        return sendEmailId;
    }

    public void setSendEmailId(String sendEmailId) {
        this.sendEmailId = sendEmailId;
    }

    @Basic
    @Column(name = "cc", nullable = true, insertable = true, updatable = true, length = 255)
    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    @Basic
    @Column(name = "bcc", nullable = true, insertable = true, updatable = true, length = 255)
    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    @Basic
    @Column(name = "subject", nullable = true, insertable = true, updatable = true, length = 1000)
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Basic
    @Column(name = "content", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
    @Column(name = "email_to", nullable = true, insertable = true, updatable = true, length = 255)
    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
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
    @Column(name = "template_id", nullable = true, insertable = true, updatable = true, length = 20)
    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    @Basic
    @Column(name = "email_from", nullable = true, insertable = true, updatable = true, length = 255)
    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    @Basic
    @Column(name = "file_id", nullable = false, insertable = true, updatable = true, length = 20)
    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SendEmail sendEmail = (SendEmail) o;

        if (bcc != null ? !bcc.equals(sendEmail.bcc) : sendEmail.bcc != null) return false;
        if (cc != null ? !cc.equals(sendEmail.cc) : sendEmail.cc != null) return false;
        if (content != null ? !content.equals(sendEmail.content) : sendEmail.content != null) return false;
        if (createTime != null ? !createTime.equals(sendEmail.createTime) : sendEmail.createTime != null) return false;
        if (description != null ? !description.equals(sendEmail.description) : sendEmail.description != null)
            return false;
        if (emailFrom != null ? !emailFrom.equals(sendEmail.emailFrom) : sendEmail.emailFrom != null) return false;
        if (emailTo != null ? !emailTo.equals(sendEmail.emailTo) : sendEmail.emailTo != null) return false;
        if (fileId != null ? !fileId.equals(sendEmail.fileId) : sendEmail.fileId != null) return false;
        if (sendEmailId != null ? !sendEmailId.equals(sendEmail.sendEmailId) : sendEmail.sendEmailId != null)
            return false;
        if (statusId != null ? !statusId.equals(sendEmail.statusId) : sendEmail.statusId != null) return false;
        if (subject != null ? !subject.equals(sendEmail.subject) : sendEmail.subject != null) return false;
        if (templateId != null ? !templateId.equals(sendEmail.templateId) : sendEmail.templateId != null) return false;
        if (updateTime != null ? !updateTime.equals(sendEmail.updateTime) : sendEmail.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sendEmailId != null ? sendEmailId.hashCode() : 0;
        result = 31 * result + (cc != null ? cc.hashCode() : 0);
        result = 31 * result + (bcc != null ? bcc.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (emailTo != null ? emailTo.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (templateId != null ? templateId.hashCode() : 0);
        result = 31 * result + (emailFrom != null ? emailFrom.hashCode() : 0);
        result = 31 * result + (fileId != null ? fileId.hashCode() : 0);
        return result;
    }
}
