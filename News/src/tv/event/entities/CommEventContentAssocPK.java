package tv.event.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 5/31/2015
 * Time: 10:18 PM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
public class CommEventContentAssocPK implements Serializable {
    private String contentId;
    private String communicationEventId;
    private Timestamp fromDate;

    @Column(name = "CONTENT_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    @Column(name = "COMMUNICATION_EVENT_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getCommunicationEventId() {
        return communicationEventId;
    }

    public void setCommunicationEventId(String communicationEventId) {
        this.communicationEventId = communicationEventId;
    }

    @Column(name = "FROM_DATE", nullable = false, insertable = true, updatable = true)
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

        CommEventContentAssocPK that = (CommEventContentAssocPK) o;

        if (communicationEventId != null ? !communicationEventId.equals(that.communicationEventId) : that.communicationEventId != null)
            return false;
        if (contentId != null ? !contentId.equals(that.contentId) : that.contentId != null) return false;
        if (fromDate != null ? !fromDate.equals(that.fromDate) : that.fromDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contentId != null ? contentId.hashCode() : 0;
        result = 31 * result + (communicationEventId != null ? communicationEventId.hashCode() : 0);
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        return result;
    }
}
