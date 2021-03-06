package tv.user.controller;

import tv.user.entities.Party;
import tv.user.entities.PartyAttribute;
import tv.user.entities.Person;
import tv.user.entities.UserLogin;
import tv.user.model.UserProfile;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/11/2015
 * Time: 11:41 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
public interface IUserController {
    public UserLogin login(String username, String password);

    public Person getPersonById(String partyId);

    public List<String> getAllStoreByUser(String partyId);

    public Party save(Party party);

    public PartyAttribute save(PartyAttribute partyAttribute);

    public Party getParty(String partyId);

    public List<PartyAttribute> getImagesList(String partyId, String attrName);

    public UserProfile createUser(UserProfile userProfile);

    @Deprecated
    public String getPartyIdByStore(String productStoreId);
}
