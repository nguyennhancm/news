package portal.system.bean;

import portal.utils.BasePortalBean;
import tv.news.entities.ProductStore;
import tv.news.model.StoreData;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 4/9/2016
 * Time: 3:06 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name = "DetailWebSite")
@SessionScoped
public class DetailWebSiteBean extends BasePortalBean{

    private StoreData webStoreDetail;

    private String storeId;

    public String loadStoreDetail(){
        setWebStoreDetail(buildData(storeId));
        // load product store
        ProductStore productStore = getProductStoreManager().getProductStore(storeId);
        webStoreDetail.setProductStore(productStore);
        // load all user
        webStoreDetail.setWebSiteList(getWebSiteManager().getWebSiteByStoreId(productStore.getProductStoreId()));
        return "detail_site";
    }


    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public StoreData getWebStoreDetail() {
        return webStoreDetail;
    }

    public void setWebStoreDetail(StoreData webStoreDetail) {
        this.webStoreDetail = webStoreDetail;
    }

    @Override
    public String getClassName() {
        return getClass().getName();
    }
}
