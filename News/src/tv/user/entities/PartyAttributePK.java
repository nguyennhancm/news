package tv.user.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 5/31/2015
 * Time: 10:28 PM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
public class PartyAttributePK implements Serializable {
    private String partyId;
    private String attrName;

    @Column(name = "PARTY_ID", nullable = false, insertable = true, updatable = true, length = 20)
    @Id
    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    @Column(name = "ATTR_NAME", nullable = false, insertable = true, updatable = true, length = 60)
    @Id
    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PartyAttributePK that = (PartyAttributePK) o;

        if (attrName != null ? !attrName.equals(that.attrName) : that.attrName != null) return false;
        if (partyId != null ? !partyId.equals(that.partyId) : that.partyId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = partyId != null ? partyId.hashCode() : 0;
        result = 31 * result + (attrName != null ? attrName.hashCode() : 0);
        return result;
    }
}
