package tv.event.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 5/31/2015
 * Time: 10:19 PM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
public class CommunicationEventWorkEffPK implements Serializable {
    private String workEffortId;
    private String communicationEventId;

    @Column(name = "WORK_EFFORT_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getWorkEffortId() {
        return workEffortId;
    }

    public void setWorkEffortId(String workEffortId) {
        this.workEffortId = workEffortId;
    }

    @Column(name = "COMMUNICATION_EVENT_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getCommunicationEventId() {
        return communicationEventId;
    }

    public void setCommunicationEventId(String communicationEventId) {
        this.communicationEventId = communicationEventId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommunicationEventWorkEffPK that = (CommunicationEventWorkEffPK) o;

        if (communicationEventId != null ? !communicationEventId.equals(that.communicationEventId) : that.communicationEventId != null)
            return false;
        if (workEffortId != null ? !workEffortId.equals(that.workEffortId) : that.workEffortId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = workEffortId != null ? workEffortId.hashCode() : 0;
        result = 31 * result + (communicationEventId != null ? communicationEventId.hashCode() : 0);
        return result;
    }
}
