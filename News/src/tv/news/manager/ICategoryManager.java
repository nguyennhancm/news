package tv.news.manager;

import tv.news.entities.*;

import javax.ejb.Local;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/2/2015
 * Time: 4:53 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface ICategoryManager {

    public ProductCategory getCategory(String categoryId);

    public ProdCatalog getCatalogByName(String storeId, String categoryName);

    public List<ProdCatalog> getCatalogByStore(String storeId);

    public List<ProductCategory> getCategoryByCatalog(String catalogId);

    public List<ProductCategory> getCategoryByParent(String categoryParentId);

    public ProductCategory save(ProductCategory category);

    public ProductCategoryRole save(ProductCategoryRole productCategoryRole);

    public ProductCategoryMember save(ProductCategoryMember productCategoryMember);

    public List<ProductCategory> getAllCategoryByStoreAndType(String storeId, String categoryType);

    public boolean checkTagsExist(String productId, String tagsId);

    public List<ProductCategory> getAllTagByNews(String newsId);

    public void removeAllTags(String newsId);

    public void deleteProductCategoryMember(String productId, String categoryId);

    public ProdCatalog addNewCatalog(String storeId, String catalogName);

    public String addNewCategory(String storeId, String catalogId, String categoryName, boolean createCatalog);

    public String addNewCategoryPosition(String storeId, String catalogId, String categoryName, boolean createCatalog, String categoryType);

    public ProductStoreCatalog save(ProductStoreCatalog productStoreCatalog);

    public ProdCatalogCategory save(ProdCatalogCategory prodCatalogCategory);

    public ProdCatalog save(ProdCatalog prodCatalog);

    public List<ProductCategory> getProductCategoryByParentId(String productCategoryId);




}
