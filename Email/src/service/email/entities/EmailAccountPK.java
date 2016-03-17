package service.email.entities;

import javax.persistence.Column;
import javax.persistence.Id;
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
public class EmailAccountPK implements Serializable {
    private String emailAccount;
    private String userId;
    private Timestamp fromDate;

    @Column(name = "email_account", nullable = false, insertable = true, updatable = true, length = 255)
    @Id
    public String getEmailAccount() {
        return emailAccount;
    }

    public void setEmailAccount(String emailAccount) {
        this.emailAccount = emailAccount;
    }

    @Column(name = "user_id", nullable = false, insertable = true, updatable = true, length = 255)
    @Id
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "from_date", nullable = false, insertable = true, updatable = true)
    @Id
    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmailAccountPK that = (EmailAccountPK) o;

        if (emailAccount != null ? !emailAccount.equals(that.emailAccount) : that.emailAccount != null) return false;
        if (fromDate != null ? !fromDate.equals(that.fromDate) : that.fromDate != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = emailAccount != null ? emailAccount.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        return result;
    }
}
