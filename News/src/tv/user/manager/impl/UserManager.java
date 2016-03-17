package tv.user.manager.impl;

import tv.user.entities.Party;
import tv.user.entities.PartyAttribute;
import tv.user.entities.Person;
import tv.user.entities.UserLogin;
import tv.user.manager.IUserManager;
import tv.utils.manager.BaseManager;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/11/2015
 * Time: 11:39 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class UserManager extends BaseManager implements IUserManager {
    @Override
    public UserLogin login(String username, String password) {
        Query query = getEntityManager().createQuery("select u from UserLogin u where u.id=:username and u.currentPassword=:password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        try {
            return (UserLogin) query.getSingleResult();
        }catch (Exception e){
            logger.info(username + " login false;");
            return null;
        }
    }

    @Override
    public Person getPersonById(String partyId) {
        Query query = getEntityManager().createQuery("select p from Person p where p.partyId=:partyId");
        query.setParameter("partyId", partyId);
        try {
            return (Person) query.getSingleResult();
        }catch (Exception e){
            logger.info("person not exist " + partyId);
            return null;
        }
    }

    @Override
    public List<String> getAllStoreByUser(String partyId) {
        Query query = getEntityManager().createQuery("select s.productStoreId from ProductStoreRole s where s.partyId=:partyId and s.roleTypeId=:roleTypeId");
        query.setParameter("partyId", partyId);
        query.setParameter("roleTypeId", "ADMIN_NEWS");
        return query.getResultList();
    }

    @Override
    public Party save(Party party) {
        return getEntityManager().merge(party);
    }

    @Override
    public PartyAttribute save(PartyAttribute partyAttribute) {
        return getEntityManager().merge(partyAttribute);
    }

    @Override
    public Party getParty(String partyId) {
        return getEntityManager().find(Party.class, partyId);
    }

    @Override
    public List<PartyAttribute> getImagesList(String partyId, String attrName) {
        Query query = getEntityManager().createQuery("select pa from PartyAttribute pa where pa.partyId =:partyId and lower(pa.attrName) like :attrName");
        query.setParameter("partyId", partyId);
        query.setParameter("attrName", "%" + attrName.toLowerCase() + "%");
        return query.getResultList();
    }

    @Override
    public String getPartyIdByStore(String productStoreId) {
        Query query = getEntityManager().createQuery("select s.partyId from ProductStoreRole s where" +
                " s.productStoreId=:productStoreId and s.roleTypeId=:roleTypeId and s.sequenceNum=:sequenceNum");
        query.setParameter("productStoreId", productStoreId);
        query.setParameter("roleTypeId", "ADMIN_NEWS");
        query.setParameter("sequenceNum", 1);
        return (String) query.getResultList().get(0);
    }
}
