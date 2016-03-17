package tv.user.controller.impl;

import tv.user.controller.IUserController;
import tv.user.entities.Party;
import tv.user.entities.PartyAttribute;
import tv.user.entities.Person;
import tv.user.entities.UserLogin;
import tv.utils.controller.BaseController;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/11/2015
 * Time: 11:42 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class UserController extends BaseController implements IUserController {
    @Override
    public UserLogin login(String username, String password) {
        return getUserManager().login(username, password);
    }

    @Override
    public Person getPersonById(String partyId) {
        return getUserManager().getPersonById(partyId);
    }

    @Override
    public List<String> getAllStoreByUser(String partyId) {
        return getUserManager().getAllStoreByUser(partyId);
    }

    @Override
    public Party save(Party party) {
        return getUserManager().save(party);
    }

    @Override
    public PartyAttribute save(PartyAttribute partyAttribute) {
        return getUserManager().save(partyAttribute);
    }

    @Override
    public Party getParty(String partyId) {
        return getUserManager().getParty(partyId);
    }

    @Override
    public List<PartyAttribute> getImagesList(String partyId, String attrName) {
        return getUserManager().getImagesList(partyId, attrName);
    }

    @Override
    public String getPartyIdByStore(String productStoreId) {
        return getUserManager().getPartyIdByStore(productStoreId);
    }
}
