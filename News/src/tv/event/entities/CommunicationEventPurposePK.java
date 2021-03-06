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
public class CommunicationEventPurposePK implements Serializable {
    private String communicationEventPrpTypId;
    private String communicationEventId;

    @Column(name = "COMMUNICATION_EVENT_PRP_TYP_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getCommunicationEventPrpTypId() {
        return communicationEventPrpTypId;
    }

    public void setCommunicationEventPrpTypId(String communicationEventPrpTypId) {
        this.communicationEventPrpTypId = communicationEventPrpTypId;
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

        CommunicationEventPurposePK that = (CommunicationEventPurposePK) o;

        if (communicationEventId != null ? !communicationEventId.equals(that.communicationEventId) : that.communicationEventId != null)
            return false;
        if (communicationEventPrpTypId != null ? !communicationEventPrpTypId.equals(that.communicationEventPrpTypId) : that.communicationEventPrpTypId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = communicationEventPrpTypId != null ? communicationEventPrpTypId.hashCode() : 0;
        result = 31 * result + (communicationEventId != null ? communicationEventId.hashCode() : 0);
        return result;
    }
}
