package portal.utils;

import tv.news.model.StoreData;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/19/2015
 * Time: 11:18 AM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@ApplicationScoped
@ManagedBean(name = "CachesStore")
public class CachesStore extends BasePortalBean {
    private HashMap<String, StoreData> storeMap = new HashMap<String, StoreData>();
    public StoreData getStoreById(String storeId){
        StoreData storeData1 = storeMap.get(storeId);
        if (null == storeData1){
            storeData1 = buildData(storeId);
            storeMap.put(storeId, storeData1);
        }
        return storeData1;

    }
    public StoreData reloadStore(String storeId){
        StoreData storeData1 = buildData(storeId);
        storeMap.put(storeId, storeData1);
        return storeData1;
    }

    @Override
    public String getClassName() {
        return getClass().getName();
    }
}
