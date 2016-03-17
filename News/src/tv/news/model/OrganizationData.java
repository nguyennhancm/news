package tv.news.model;

import tv.user.entities.Party;
import tv.user.entities.PartyAttribute;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 10/19/2015
 * Time: 10:34 AM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
public class OrganizationData {
    private Party party;
    private List<PartyAttribute> imagesList;

    public Party getParty() {
        if (null == party) party = new Party();
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public List<PartyAttribute> getImagesList() {
        if(null == imagesList) imagesList = new ArrayList<PartyAttribute>();
        return imagesList;
    }

    public void setImagesList(List<PartyAttribute> imagesList) {
        this.imagesList = imagesList;
    }
}
