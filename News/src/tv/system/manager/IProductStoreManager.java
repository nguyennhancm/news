package tv.system.manager;

import tv.news.entities.ProductStore;
import tv.news.entities.ProductStoreRole;

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
public interface IProductStoreManager {
    public ProductStore getProductStore(String productStoreId);

    public List<ProductStore> getAllWebSite();

    public ProductStore save(ProductStore productStore);

    public ProductStoreRole save(ProductStoreRole productStoreRole);
}
