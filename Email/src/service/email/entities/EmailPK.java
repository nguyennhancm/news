package service.email.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 9/25/2015
 * Time: 7:33 AM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
public class EmailPK implements Serializable {
    private String emailAddress;
    private String fileId;

    @Column(name = "email_address", nullable = false, insertable = true, updatable = true, length = 255)
    @Id
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Column(name = "file_id", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
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

        EmailPK emailPK = (EmailPK) o;

        if (emailAddress != null ? !emailAddress.equals(emailPK.emailAddress) : emailPK.emailAddress != null)
            return false;
        if (fileId != null ? !fileId.equals(emailPK.fileId) : emailPK.fileId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = emailAddress != null ? emailAddress.hashCode() : 0;
        result = 31 * result + (fileId != null ? fileId.hashCode() : 0);
        return result;
    }
}
