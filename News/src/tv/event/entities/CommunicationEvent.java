package tv.event.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 5/31/2015
 * Time: 10:18 PM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
@Entity
@javax.persistence.Table(name = "communication_event")
public class CommunicationEvent {
    private String communicationEventId;

    @Id
    @javax.persistence.Column(name = "COMMUNICATION_EVENT_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getCommunicationEventId() {
        return communicationEventId;
    }

    public void setCommunicationEventId(String communicationEventId) {
        this.communicationEventId = communicationEventId;
    }

    private String communicationEventTypeId;

    @Basic
    @javax.persistence.Column(name = "COMMUNICATION_EVENT_TYPE_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getCommunicationEventTypeId() {
        return communicationEventTypeId;
    }

    public void setCommunicationEventTypeId(String communicationEventTypeId) {
        this.communicationEventTypeId = communicationEventTypeId;
    }

    private String origCommEventId;

    @Basic
    @javax.persistence.Column(name = "ORIG_COMM_EVENT_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getOrigCommEventId() {
        return origCommEventId;
    }

    public void setOrigCommEventId(String origCommEventId) {
        this.origCommEventId = origCommEventId;
    }

    private String parentCommEventId;

    @Basic
    @javax.persistence.Column(name = "PARENT_COMM_EVENT_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getParentCommEventId() {
        return parentCommEventId;
    }

    public void setParentCommEventId(String parentCommEventId) {
        this.parentCommEventId = parentCommEventId;
    }

    private String statusId;

    @Basic
    @javax.persistence.Column(name = "STATUS_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    private String contactMechTypeId;

    @Basic
    @javax.persistence.Column(name = "CONTACT_MECH_TYPE_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getContactMechTypeId() {
        return contactMechTypeId;
    }

    public void setContactMechTypeId(String contactMechTypeId) {
        this.contactMechTypeId = contactMechTypeId;
    }

    private String contactMechIdFrom;

    @Basic
    @javax.persistence.Column(name = "CONTACT_MECH_ID_FROM", nullable = true, insertable = true, updatable = true, length = 20)
    public String getContactMechIdFrom() {
        return contactMechIdFrom;
    }

    public void setContactMechIdFrom(String contactMechIdFrom) {
        this.contactMechIdFrom = contactMechIdFrom;
    }

    private String contactMechIdTo;

    @Basic
    @javax.persistence.Column(name = "CONTACT_MECH_ID_TO", nullable = true, insertable = true, updatable = true, length = 20)
    public String getContactMechIdTo() {
        return contactMechIdTo;
    }

    public void setContactMechIdTo(String contactMechIdTo) {
        this.contactMechIdTo = contactMechIdTo;
    }

    private String roleTypeIdFrom;

    @Basic
    @javax.persistence.Column(name = "ROLE_TYPE_ID_FROM", nullable = true, insertable = true, updatable = true, length = 20)
    public String getRoleTypeIdFrom() {
        return roleTypeIdFrom;
    }

    public void setRoleTypeIdFrom(String roleTypeIdFrom) {
        this.roleTypeIdFrom = roleTypeIdFrom;
    }

    private String roleTypeIdTo;

    @Basic
    @javax.persistence.Column(name = "ROLE_TYPE_ID_TO", nullable = true, insertable = true, updatable = true, length = 20)
    public String getRoleTypeIdTo() {
        return roleTypeIdTo;
    }

    public void setRoleTypeIdTo(String roleTypeIdTo) {
        this.roleTypeIdTo = roleTypeIdTo;
    }

    private String partyIdFrom;

    @Basic
    @javax.persistence.Column(name = "PARTY_ID_FROM", nullable = true, insertable = true, updatable = true, length = 20)
    public String getPartyIdFrom() {
        return partyIdFrom;
    }

    public void setPartyIdFrom(String partyIdFrom) {
        this.partyIdFrom = partyIdFrom;
    }

    private String partyIdTo;

    @Basic
    @javax.persistence.Column(name = "PARTY_ID_TO", nullable = true, insertable = true, updatable = true, length = 20)
    public String getPartyIdTo() {
        return partyIdTo;
    }

    public void setPartyIdTo(String partyIdTo) {
        this.partyIdTo = partyIdTo;
    }

    private Timestamp entryDate;

    @Basic
    @javax.persistence.Column(name = "ENTRY_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Timestamp entryDate) {
        this.entryDate = entryDate;
    }

    private Timestamp datetimeStarted;

    @Basic
    @javax.persistence.Column(name = "DATETIME_STARTED", nullable = true, insertable = true, updatable = true)
    public Timestamp getDatetimeStarted() {
        return datetimeStarted;
    }

    public void setDatetimeStarted(Timestamp datetimeStarted) {
        this.datetimeStarted = datetimeStarted;
    }

    private Timestamp datetimeEnded;

    @Basic
    @javax.persistence.Column(name = "DATETIME_ENDED", nullable = true, insertable = true, updatable = true)
    public Timestamp getDatetimeEnded() {
        return datetimeEnded;
    }

    public void setDatetimeEnded(Timestamp datetimeEnded) {
        this.datetimeEnded = datetimeEnded;
    }

    private String subject;

    @Basic
    @javax.persistence.Column(name = "SUBJECT", nullable = true, insertable = true, updatable = true, length = 255)
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    private String contentMimeTypeId;

    @Basic
    @javax.persistence.Column(name = "CONTENT_MIME_TYPE_ID", nullable = true, insertable = true, updatable = true, length = 60)
    public String getContentMimeTypeId() {
        return contentMimeTypeId;
    }

    public void setContentMimeTypeId(String contentMimeTypeId) {
        this.contentMimeTypeId = contentMimeTypeId;
    }

    private String content;

    @Basic
    @javax.persistence.Column(name = "CONTENT", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String note;

    @Basic
    @javax.persistence.Column(name = "NOTE", nullable = true, insertable = true, updatable = true, length = 255)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    private String reasonEnumId;

    @Basic
    @javax.persistence.Column(name = "REASON_ENUM_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getReasonEnumId() {
        return reasonEnumId;
    }

    public void setReasonEnumId(String reasonEnumId) {
        this.reasonEnumId = reasonEnumId;
    }

    private String contactListId;

    @Basic
    @javax.persistence.Column(name = "CONTACT_LIST_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getContactListId() {
        return contactListId;
    }

    public void setContactListId(String contactListId) {
        this.contactListId = contactListId;
    }

    private String headerString;

    @Basic
    @javax.persistence.Column(name = "HEADER_STRING", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getHeaderString() {
        return headerString;
    }

    public void setHeaderString(String headerString) {
        this.headerString = headerString;
    }

    private String fromString;

    @Basic
    @javax.persistence.Column(name = "FROM_STRING", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getFromString() {
        return fromString;
    }

    public void setFromString(String fromString) {
        this.fromString = fromString;
    }

    private String toString;

    @Basic
    @javax.persistence.Column(name = "TO_STRING", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getToString() {
        return toString;
    }

    public void setToString(String toString) {
        this.toString = toString;
    }

    private String ccString;

    @Basic
    @javax.persistence.Column(name = "CC_STRING", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getCcString() {
        return ccString;
    }

    public void setCcString(String ccString) {
        this.ccString = ccString;
    }

    private String bccString;

    @Basic
    @javax.persistence.Column(name = "BCC_STRING", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getBccString() {
        return bccString;
    }

    public void setBccString(String bccString) {
        this.bccString = bccString;
    }

    private String messageId;

    @Basic
    @javax.persistence.Column(name = "MESSAGE_ID", nullable = true, insertable = true, updatable = true, length = 255)
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    private Timestamp lastUpdatedStamp;

    @Basic
    @javax.persistence.Column(name = "LAST_UPDATED_STAMP", nullable = true, insertable = true, updatable = true)
    public Timestamp getLastUpdatedStamp() {
        return lastUpdatedStamp;
    }

    public void setLastUpdatedStamp(Timestamp lastUpdatedStamp) {
        this.lastUpdatedStamp = lastUpdatedStamp;
    }

    private Timestamp lastUpdatedTxStamp;

    @Basic
    @javax.persistence.Column(name = "LAST_UPDATED_TX_STAMP", nullable = true, insertable = true, updatable = true)
    public Timestamp getLastUpdatedTxStamp() {
        return lastUpdatedTxStamp;
    }

    public void setLastUpdatedTxStamp(Timestamp lastUpdatedTxStamp) {
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
    }

    private Timestamp createdStamp;

    @Basic
    @javax.persistence.Column(name = "CREATED_STAMP", nullable = true, insertable = true, updatable = true)
    public Timestamp getCreatedStamp() {
        return createdStamp;
    }

    public void setCreatedStamp(Timestamp createdStamp) {
        this.createdStamp = createdStamp;
    }

    private Timestamp createdTxStamp;

    @Basic
    @javax.persistence.Column(name = "CREATED_TX_STAMP", nullable = true, insertable = true, updatable = true)
    public Timestamp getCreatedTxStamp() {
        return createdTxStamp;
    }

    public void setCreatedTxStamp(Timestamp createdTxStamp) {
        this.createdTxStamp = createdTxStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommunicationEvent that = (CommunicationEvent) o;

        if (bccString != null ? !bccString.equals(that.bccString) : that.bccString != null) return false;
        if (ccString != null ? !ccString.equals(that.ccString) : that.ccString != null) return false;
        if (communicationEventId != null ? !communicationEventId.equals(that.communicationEventId) : that.communicationEventId != null)
            return false;
        if (communicationEventTypeId != null ? !communicationEventTypeId.equals(that.communicationEventTypeId) : that.communicationEventTypeId != null)
            return false;
        if (contactListId != null ? !contactListId.equals(that.contactListId) : that.contactListId != null)
            return false;
        if (contactMechIdFrom != null ? !contactMechIdFrom.equals(that.contactMechIdFrom) : that.contactMechIdFrom != null)
            return false;
        if (contactMechIdTo != null ? !contactMechIdTo.equals(that.contactMechIdTo) : that.contactMechIdTo != null)
            return false;
        if (contactMechTypeId != null ? !contactMechTypeId.equals(that.contactMechTypeId) : that.contactMechTypeId != null)
            return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (contentMimeTypeId != null ? !contentMimeTypeId.equals(that.contentMimeTypeId) : that.contentMimeTypeId != null)
            return false;
        if (createdStamp != null ? !createdStamp.equals(that.createdStamp) : that.createdStamp != null) return false;
        if (createdTxStamp != null ? !createdTxStamp.equals(that.createdTxStamp) : that.createdTxStamp != null)
            return false;
        if (datetimeEnded != null ? !datetimeEnded.equals(that.datetimeEnded) : that.datetimeEnded != null)
            return false;
        if (datetimeStarted != null ? !datetimeStarted.equals(that.datetimeStarted) : that.datetimeStarted != null)
            return false;
        if (entryDate != null ? !entryDate.equals(that.entryDate) : that.entryDate != null) return false;
        if (fromString != null ? !fromString.equals(that.fromString) : that.fromString != null) return false;
        if (headerString != null ? !headerString.equals(that.headerString) : that.headerString != null) return false;
        if (lastUpdatedStamp != null ? !lastUpdatedStamp.equals(that.lastUpdatedStamp) : that.lastUpdatedStamp != null)
            return false;
        if (lastUpdatedTxStamp != null ? !lastUpdatedTxStamp.equals(that.lastUpdatedTxStamp) : that.lastUpdatedTxStamp != null)
            return false;
        if (messageId != null ? !messageId.equals(that.messageId) : that.messageId != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (origCommEventId != null ? !origCommEventId.equals(that.origCommEventId) : that.origCommEventId != null)
            return false;
        if (parentCommEventId != null ? !parentCommEventId.equals(that.parentCommEventId) : that.parentCommEventId != null)
            return false;
        if (partyIdFrom != null ? !partyIdFrom.equals(that.partyIdFrom) : that.partyIdFrom != null) return false;
        if (partyIdTo != null ? !partyIdTo.equals(that.partyIdTo) : that.partyIdTo != null) return false;
        if (reasonEnumId != null ? !reasonEnumId.equals(that.reasonEnumId) : that.reasonEnumId != null) return false;
        if (roleTypeIdFrom != null ? !roleTypeIdFrom.equals(that.roleTypeIdFrom) : that.roleTypeIdFrom != null)
            return false;
        if (roleTypeIdTo != null ? !roleTypeIdTo.equals(that.roleTypeIdTo) : that.roleTypeIdTo != null) return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) return false;
        if (toString != null ? !toString.equals(that.toString) : that.toString != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = communicationEventId != null ? communicationEventId.hashCode() : 0;
        result = 31 * result + (communicationEventTypeId != null ? communicationEventTypeId.hashCode() : 0);
        result = 31 * result + (origCommEventId != null ? origCommEventId.hashCode() : 0);
        result = 31 * result + (parentCommEventId != null ? parentCommEventId.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (contactMechTypeId != null ? contactMechTypeId.hashCode() : 0);
        result = 31 * result + (contactMechIdFrom != null ? contactMechIdFrom.hashCode() : 0);
        result = 31 * result + (contactMechIdTo != null ? contactMechIdTo.hashCode() : 0);
        result = 31 * result + (roleTypeIdFrom != null ? roleTypeIdFrom.hashCode() : 0);
        result = 31 * result + (roleTypeIdTo != null ? roleTypeIdTo.hashCode() : 0);
        result = 31 * result + (partyIdFrom != null ? partyIdFrom.hashCode() : 0);
        result = 31 * result + (partyIdTo != null ? partyIdTo.hashCode() : 0);
        result = 31 * result + (entryDate != null ? entryDate.hashCode() : 0);
        result = 31 * result + (datetimeStarted != null ? datetimeStarted.hashCode() : 0);
        result = 31 * result + (datetimeEnded != null ? datetimeEnded.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (contentMimeTypeId != null ? contentMimeTypeId.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (reasonEnumId != null ? reasonEnumId.hashCode() : 0);
        result = 31 * result + (contactListId != null ? contactListId.hashCode() : 0);
        result = 31 * result + (headerString != null ? headerString.hashCode() : 0);
        result = 31 * result + (fromString != null ? fromString.hashCode() : 0);
        result = 31 * result + (toString != null ? toString.hashCode() : 0);
        result = 31 * result + (ccString != null ? ccString.hashCode() : 0);
        result = 31 * result + (bccString != null ? bccString.hashCode() : 0);
        result = 31 * result + (messageId != null ? messageId.hashCode() : 0);
        result = 31 * result + (lastUpdatedStamp != null ? lastUpdatedStamp.hashCode() : 0);
        result = 31 * result + (lastUpdatedTxStamp != null ? lastUpdatedTxStamp.hashCode() : 0);
        result = 31 * result + (createdStamp != null ? createdStamp.hashCode() : 0);
        result = 31 * result + (createdTxStamp != null ? createdTxStamp.hashCode() : 0);
        return result;
    }
}
