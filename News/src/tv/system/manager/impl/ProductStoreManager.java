package tv.system.manager.impl;

import tv.news.entities.ProductStore;
import tv.news.entities.ProductStoreRole;
import tv.system.manager.IProductStoreManager;
import tv.utils.manager.BaseManager;

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
public class ProductStoreManager extends BaseManager implements IProductStoreManager {

    @Override
    public ProductStore getProductStore(String productStoreId) {
        return getEntityManager().find(ProductStore.class, productStoreId);
    }

    @Override
    public List<ProductStore> getAllWebSite() {
        Query query = getEntityManager().createQuery("select ps from ProductStore ps");
        return query.getResultList();
    }

    @Override
    public ProductStore save(ProductStore productStore) {
        return null;
    }

    @Override
    public ProductStoreRole save(ProductStoreRole productStoreRole) {
        return null;
    }
}
