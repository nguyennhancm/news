package service.email.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 10/4/2015
 * Time: 5:08 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "email_account")
@IdClass(EmailAccountPK.class)
public class EmailAccount {
    private String emailAccount;
    private String userId;
    private Timestamp fromDate;
    private String password;
    private String emailSmtp;
    private String description;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String statusId;
    private Integer port;
    private String ssl;

    @Id
    @Column(name = "email_account", nullable = false, insertable = true, updatable = true, length = 255)
    public String getEmailAccount() {
        return emailAccount;
    }

    public void setEmailAccount(String emailAccount) {
        this.emailAccount = emailAccount;
    }

    @Id
    @Column(name = "user_id", nullable = false, insertable = true, updatable = true, length = 255)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "from_date", nullable = false, insertable = true, updatable = true)
    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    @Basic
    @Column(name = "password", nullable = true, insertable = true, updatable = true, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email_smtp", nullable = true, insertable = true, updatable = true, length = 255)
    public String getEmailSmtp() {
        return emailSmtp;
    }

    public void setEmailSmtp(String emailSmtp) {
        this.emailSmtp = emailSmtp;
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
    @Column(name = "status_id", nullable = true, insertable = true, updatable = true, length = 20)
    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "port", nullable = true, insertable = true, updatable = true)
    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Basic
    @Column(name = "ssl", nullable = true, insertable = true, updatable = true, length = 1)
    public String getSsl() {
        return ssl;
    }

    public void setSsl(String ssl) {
        this.ssl = ssl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmailAccount that = (EmailAccount) o;

        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (emailAccount != null ? !emailAccount.equals(that.emailAccount) : that.emailAccount != null) return false;
        if (emailSmtp != null ? !emailSmtp.equals(that.emailSmtp) : that.emailSmtp != null) return false;
        if (fromDate != null ? !fromDate.equals(that.fromDate) : that.fromDate != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (port != null ? !port.equals(that.port) : that.port != null) return false;
        if (ssl != null ? !ssl.equals(that.ssl) : that.ssl != null) return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = emailAccount != null ? emailAccount.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (emailSmtp != null ? emailSmtp.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (port != null ? port.hashCode() : 0);
        result = 31 * result + (ssl != null ? ssl.hashCode() : 0);
        return result;
    }
}
