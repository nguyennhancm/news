package tv.event.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 5/31/2015
 * Time: 10:18 PM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
public class CommunicationEventOrderPK implements Serializable {
    private String orderId;
    private String communicationEventId;

    @Column(name = "ORDER_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

        CommunicationEventOrderPK that = (CommunicationEventOrderPK) o;

        if (communicationEventId != null ? !communicationEventId.equals(that.communicationEventId) : that.communicationEventId != null)
            return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (communicationEventId != null ? communicationEventId.hashCode() : 0);
        return result;
    }
}
