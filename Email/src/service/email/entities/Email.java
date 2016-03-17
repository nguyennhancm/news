package service.email.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 9/25/2015
 * Time: 7:33 AM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "email")
@IdClass(EmailPK.class)
public class Email implements Serializable{
    private String emailAddress;
    private String fileId;
    private String emailName;
    private String postalAddress;
    private String phoneNumber;
    private String description;
    private String statusId;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "email_address", nullable = false, insertable = true, updatable = true, length = 255)
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Id
    @Column(name = "file_id", nullable = false, insertable = true, updatable = true, length = 20)
    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    @Basic
    @Column(name = "email_name", nullable = true, insertable = true, updatable = true, length = 255)
    public String getEmailName() {
        return emailName;
    }

    public void setEmailName(String emailName) {
        this.emailName = emailName;
    }

    @Basic
    @Column(name = "postal_address", nullable = true, insertable = true, updatable = true, length = 255)
    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    @Basic
    @Column(name = "phone_number", nullable = true, insertable = true, updatable = true, length = 255)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
    @Column(name = "status_id", nullable = false, insertable = true, updatable = true, length = 20)
    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Email email = (Email) o;

        if (createTime != null ? !createTime.equals(email.createTime) : email.createTime != null) return false;
        if (description != null ? !description.equals(email.description) : email.description != null) return false;
        if (emailAddress != null ? !emailAddress.equals(email.emailAddress) : email.emailAddress != null) return false;
        if (emailName != null ? !emailName.equals(email.emailName) : email.emailName != null) return false;
        if (fileId != null ? !fileId.equals(email.fileId) : email.fileId != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(email.phoneNumber) : email.phoneNumber != null) return false;
        if (postalAddress != null ? !postalAddress.equals(email.postalAddress) : email.postalAddress != null)
            return false;
        if (statusId != null ? !statusId.equals(email.statusId) : email.statusId != null) return false;
        if (updateTime != null ? !updateTime.equals(email.updateTime) : email.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = emailAddress != null ? emailAddress.hashCode() : 0;
        result = 31 * result + (fileId != null ? fileId.hashCode() : 0);
        result = 31 * result + (emailName != null ? emailName.hashCode() : 0);
        result = 31 * result + (postalAddress != null ? postalAddress.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
