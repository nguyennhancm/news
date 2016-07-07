package tv.news.controller.impl;

import tv.news.controller.ICategoryController;
import tv.news.entities.ProdCatalog;
import tv.news.entities.ProductCategory;
import tv.news.entities.ProductCategoryMember;
import tv.news.entities.ProductCategoryRole;
import tv.utils.controller.BaseController;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/2/2015
 * Time: 4:54 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class CategoryController extends BaseController implements ICategoryController {

    @Override
    public ProductCategory getCategory(String categoryid) {
        return getCategoryManager().getCategory(categoryid);
    }

    @Override
    public ProdCatalog getCatalogByName(String storeId, String categoryName) {
        return getCategoryManager().getCatalogByName(storeId, categoryName);
    }


    @Override
    public List<ProdCatalog> getCatalogByStore(String storeId) {
        return getCategoryManager().getCatalogByStore(storeId);
    }

    @Override
    public List<ProductCategory> getCategoryByCatalog(String catalogId) {
        return getCategoryManager().getCategoryByCatalog(catalogId);
    }

    @Override
    public ProductCategory createCategory(ProductCategory category) {
        return getCategoryManager().save(category);
    }

    @Override
    public ProductCategoryRole createProductCategoryRole(ProductCategoryRole productCategoryRole) {
        return getCategoryManager().save(productCategoryRole);
    }

    @Override
    public ProductCategoryMember createProductCategoryMember(ProductCategoryMember productCategoryMember) {
        return getCategoryManager().save(productCategoryMember);
    }

    @Override
    public List<ProductCategory> getAllCategoryByStoreAndType(String storeId, String categoryType) {
        return getCategoryManager().getAllCategoryByStoreAndType(storeId, categoryType);
    }

    @Override
    public void removeAllTags(String newsId) {
        getCategoryManager().removeAllTags(newsId);
    }

    @Override
    public void deleteProductCategoryMember(String productId, String categoryId) {
        getCategoryManager().deleteProductCategoryMember(productId, categoryId);
    }

    @Override
    public boolean checkTagsExist(String productId, String tagsId) {
        return getCategoryManager().checkTagsExist(productId, tagsId);
    }

    @Override
    public List<ProductCategory> getAllTagByNews(String newsId) {
        return getCategoryManager().getAllTagByNews(newsId);
    }

    @Override
    public List<ProductCategory> getCategoryByParent(String categoryParentId) {
        return getCategoryManager().getCategoryByParent(categoryParentId);
    }

    @Override
    public String addNewCategory(String storeId, String catalogId, String categoryName, boolean createCatalog) {
        return getCategoryManager().addNewCategory(storeId, catalogId, categoryName, createCatalog);
    }

    @Override
    public String addNewCategoryPosition(String storeId, String catalogId, String categoryName, boolean createCatalog, String categoryType) {
        return getCategoryManager().addNewCategoryPosition(storeId, catalogId, categoryName, createCatalog, categoryType);
    }
}
