package tv.system.manager;

import tv.web.entities.WebSite;
import tv.web.entities.WebSiteRole;

import javax.ejb.Local;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 4/4/2016
 * Time: 4:36 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface IWebSiteManager {
    public WebSite getWebsite(String webSiteId);

    public List<WebSite> getWebSiteByStoreId(String productStoreId);

    public List<WebSite> getWebSiteByUserId(String userId);

    public WebSite save(WebSite webSite);

    public WebSiteRole save(WebSiteRole webSiteRole);
}
