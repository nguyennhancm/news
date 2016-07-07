package portal.system.bean;

import portal.utils.BasePortalBean;
import tv.news.entities.ProductStore;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 4/4/2016
 * Time: 1:35 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@SessionScoped
@ManagedBean(name = "ManageWebSite")
public class ManageWebSiteBean extends BasePortalBean{
   List<ProductStore> allSite;


    public List<ProductStore> getAllSite() {
        if (null == allSite){
            allSite = new ArrayList<ProductStore>();
            allSite = getProductStoreManager().getAllWebSite();
        }
        return allSite;
    }

    public void setAllSite(List<ProductStore> allSite) {
        this.allSite = allSite;
    }

    @Override
    public String getClassName() {
        return getClass().getName();
    }
}
