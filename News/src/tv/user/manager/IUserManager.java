package tv.user.manager;

import tv.user.entities.Party;
import tv.user.entities.PartyAttribute;
import tv.user.entities.Person;
import tv.user.entities.UserLogin;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/11/2015
 * Time: 11:39 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
public interface IUserManager {
    public UserLogin login(String username, String password);

    public Person getPersonById(String partyId);

    public List<String> getAllStoreByUser(String partyId);

    public Party save(Party party);

    public PartyAttribute save(PartyAttribute partyAttribute);

    public Party getParty(String partyId);

    public List<PartyAttribute> getImagesList(String partyId, String attrName);

    @Deprecated
    public String getPartyIdByStore(String storeId);
}
