package tv.system.manager.impl;

import tv.system.manager.IWebSiteManager;
import tv.utils.manager.BaseManager;
import tv.web.entities.WebSite;
import tv.web.entities.WebSiteRole;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 4/4/2016
 * Time: 4:46 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class WebSiteManager extends BaseManager implements IWebSiteManager {

    @Override
    public WebSite getWebsite(String webSiteId) {
        return getEntityManager().find(WebSite.class, webSiteId);
    }

    @Override
    public List<WebSite> getWebSiteByStoreId(String productStoreId) {
        Query query = getEntityManager().createQuery("select w from WebSite w where w.productStoreId=:productStoreId");
        query.setParameter("productStoreId", productStoreId);
        return query.getResultList();
    }

    @Override
    public List<WebSite> getWebSiteByUserId(String userId) {
        return null;
    }

    @Override
    public WebSite save(WebSite webSite) {
        getEntityManager().merge(webSite);
        return webSite;
    }

    @Override
    public WebSiteRole save(WebSiteRole webSiteRole) {
        getEntityManager().merge(webSiteRole);
        return webSiteRole;
    }
}
