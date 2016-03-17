package tv.news.manager.impl;

import tv.news.entities.*;
import tv.news.manager.ICategoryManager;
import tv.utils.manager.BaseManager;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.sql.Timestamp;
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
public class CategoryManager extends BaseManager implements ICategoryManager {

    @Override
    public ProductCategory getCategory(String categoryId) {
        return getEntityManager().find(ProductCategory.class, categoryId);
    }

    @Override
    public ProdCatalog getCatalogByName(String storeId, String categoryName) {
        List<ProdCatalog> prodCatalogs = getCatalogByStore(storeId);
        if (null == prodCatalogs) return null;
        for (ProdCatalog prodCatalog : prodCatalogs) {
            if (prodCatalog.getCatalogName().equalsIgnoreCase(categoryName))
                return prodCatalog;
        }
        return null;
    }


    @Override
    public List<ProdCatalog> getCatalogByStore(String storeId) {
        Query query = getEntityManager().createQuery("select pc from ProdCatalog pc where pc.prodCatalogId in (select psc.prodCatalogId from ProductStoreCatalog psc where psc.productStoreId=:storeId)");
        query.setParameter("storeId", storeId);
        return query.getResultList();
    }

    @Override
    public List<ProductCategory> getCategoryByCatalog(String catalogId) {
        Query query = getEntityManager().createQuery("select pc from ProductCategory pc where pc.productCategoryId in (select pcc.productCategoryId from ProdCatalogCategory pcc where pcc.prodCatalogId=:prodCatalogId)");
        query.setParameter("prodCatalogId", catalogId);
        return query.getResultList();
    }

    @Override
    public List<ProductCategory> getCategoryByParent(String categoryParentId) {
        Query query = getEntityManager().createQuery("select pc from ProductCategory pc where pc.productCategoryId in (select pcr.productCategoryId from ProductCategoryRollup pcr where pcr.parentProductCategoryId=:parentProductCategoryId)");
        query.setParameter("parentProductCategoryId", categoryParentId);
        return query.getResultList();
    }

    @Override
    public ProductCategory createCategory(ProductCategory category) {
        return getEntityManager().merge(category);
    }

    @Override
    public ProductCategoryRole createProductCategoryRole(ProductCategoryRole productCategoryRole) {
        return getEntityManager().merge(productCategoryRole);
    }

    @Override
    public ProductCategoryMember createProductCategoryMember(ProductCategoryMember productCategoryMember) {
        return getEntityManager().merge(productCategoryMember);
    }

    @Override
    public List<ProductCategory> getAllCategoryByStoreAndType(String storeId, String categoryType) {
        Query query = getEntityManager().createQuery("select pc from ProductCategory pc where " +
                "pc.productCategoryTypeId=:categoryType and pc.description=:storeId");
        query.setParameter("categoryType",categoryType);
        query.setParameter("storeId", storeId);
        return query.getResultList();
    }

    @Override
    public boolean checkTagsExist(String productId, String tagsId) {
        Query query = getEntityManager().createQuery("select pcm from ProductCategoryMember pcm where " +
                "pcm.productId=:productId and pcm.productCategoryId=:productCategoryId");
        query.setParameter("productId", productId);
        query.setParameter("productCategoryId", tagsId);
        if (null != query.getResultList()) return true;
        return false;
    }

    @Override
    public List<ProductCategory> getAllTagByNews(String newsId) {
        Query query = getEntityManager().createQuery("select pc from ProductCategory pc where pc.productCategoryTypeId=:productCategoryTypeId and " +
                "pc.productCategoryId in (select pcm.productCategoryId from ProductCategoryMember pcm " +
                "where pcm.productId=:productId)");
        query.setParameter("productCategoryTypeId", "TAGS_CATEGORY");
        query.setParameter("productId", newsId);
        return query.getResultList();
    }

    @Override
    public void removeAllTags(String newsId) {
        Query query = getEntityManager().createQuery("delete ProductCategoryMember pcm " +
                "where pcm.productId=:productId and pcm.productCategoryId in (select pc.productCategoryId from ProductCategory pc " +
                "where pc.productCategoryTypeId=:productCategoryTypeId)");
        query.setParameter("productId", newsId);
        query.setParameter("productCategoryTypeId", "TAGS_CATEGORY");
        query.executeUpdate();
    }

    @Override
    public void deleteProductCategoryMember(String productId, String categoryId) {
        Query query = getEntityManager().createQuery("delete ProductCategoryMember pcm where " +
                "pcm.productId=:productId and pcm.productCategoryId=:productCategoryId");
        query.setParameter("productId", productId);
        query.setParameter("productCategoryId", categoryId);
        query.executeUpdate();
    }

    @Override
    public ProdCatalog addNewCatalog(String storeId, String catalogName) {
        try {
            ProdCatalog prodCatalog = new ProdCatalog();
//            prodCatalog.setProdCatalogId(getSequenceValue().getSequenceValueItem(ProdCatalog.class));
            prodCatalog.setCatalogName(catalogName);
            getEntityManager().persist(prodCatalog);
            return prodCatalog;
        } catch (Exception e) {
            //TODO
            return null;
        }
    }


    @Override
    public String addNewCategory(String storeId, String catalogId, String categoryName, boolean createCatalog) {
        if (createCatalog) {
            if (null != getCatalogByName(storeId, categoryName)) {
                return "already exists";
            } else {
                ProdCatalog prodCatalog = addNewCatalog(storeId, categoryName);
                if (null != prodCatalog) {
                    ProductCategory productCategory = new ProductCategory();
//                    productCategory.setProductCategoryId(getSequenceValue().getSequenceValueItem(ProductCategory.class));
                    productCategory.setCategoryName(categoryName);
                    productCategory.setProductCategoryTypeId("CATALOG_CATEGORY");
                    getEntityManager().persist(productCategory);

                    ProductStoreCatalog productStoreCatalog = new ProductStoreCatalog();
                    productStoreCatalog.setProductStoreId(storeId);
                    productStoreCatalog.setProdCatalogId(prodCatalog.getProdCatalogId());
                    productStoreCatalog.setFromDate(new Timestamp(System.currentTimeMillis()));
                    getEntityManager().persist(productStoreCatalog);

                    ProdCatalogCategory prodCatalogCategory = new ProdCatalogCategory();
                    prodCatalogCategory.setFromDate(new Timestamp(System.currentTimeMillis()));
                    prodCatalogCategory.setProdCatalogId(prodCatalog.getProdCatalogId());
                    prodCatalogCategory.setProdCatalogCategoryTypeId("PCCT_BROWSE_ROOT");
                    prodCatalogCategory.setProductCategoryId(productCategory.getProductCategoryId());
                    getEntityManager().persist(prodCatalogCategory);

                    return "Add Success!";
                } else {
                    return "Add Error!!!";
                }
            }
        } else {
            if (null == catalogId) {
                return "Catalog do not exist!";
            } else {
                List<ProdCatalog> prodCatalogs = getCatalogByStore(storeId);
                if (null == prodCatalogs)
                    return "Catalog do not exist!";
                else {
                    boolean check = false;
                    for (ProdCatalog prodCatalog : prodCatalogs) {
                        if (prodCatalog.getProdCatalogId().equalsIgnoreCase(catalogId)) {
                            check = true;
                            break;
                        }
                    }
                    if (!check)
                        return "Catalog do not exist!";
                }
                ProductCategory productCategory = new ProductCategory();
//                productCategory.setProductCategoryId(getSequenceValue().getSequenceValueItem(ProductCategory.class));
                productCategory.setCategoryName(categoryName);
                productCategory.setProductCategoryTypeId("CATALOG_CATEGORY");
                getEntityManager().persist(productCategory);

                ProdCatalogCategory prodCatalogCategory = new ProdCatalogCategory();
                prodCatalogCategory.setFromDate(new Timestamp(System.currentTimeMillis()));
                prodCatalogCategory.setProdCatalogId(catalogId);
                prodCatalogCategory.setProdCatalogCategoryTypeId("PCCT_BROWSE_ROOT");
                prodCatalogCategory.setProductCategoryId(productCategory.getProductCategoryId());
                getEntityManager().persist(prodCatalogCategory);
                return "Add Success!";
            }
        }
    }

    @Override
    public String addNewCategoryPosition(String storeId, String catalogId, String categoryName, boolean createCatalog, String categoryType) {
        if (createCatalog && "CATEGORY_POSITION".equals(categoryType)) {
            if (null != getCatalogByName(storeId, categoryName)) {
                return "already exists";
            } else {
                ProdCatalog prodCatalog = addNewCatalog(storeId, categoryName);
                if (null != prodCatalog) {
                    ProductCategory productCategory = new ProductCategory();
//                    productCategory.setProductCategoryId(getSequenceValue().getSequenceValueItem(ProductCategory.class));
                    productCategory.setCategoryName(categoryName);
                    productCategory.setProductCategoryTypeId("CATEGORY_POSITION");
                    getEntityManager().persist(productCategory);

                    ProductStoreCatalog productStoreCatalog = new ProductStoreCatalog();
                    productStoreCatalog.setProductStoreId(storeId);
                    productStoreCatalog.setProdCatalogId(prodCatalog.getProdCatalogId());
                    productStoreCatalog.setFromDate(new Timestamp(System.currentTimeMillis()));
                    getEntityManager().persist(productStoreCatalog);

                    ProdCatalogCategory prodCatalogCategory = new ProdCatalogCategory();
                    prodCatalogCategory.setFromDate(new Timestamp(System.currentTimeMillis()));
                    prodCatalogCategory.setProdCatalogId(prodCatalog.getProdCatalogId());
                    prodCatalogCategory.setProdCatalogCategoryTypeId("PCCT_BROWSE_ROOT");
                    prodCatalogCategory.setProductCategoryId(productCategory.getProductCategoryId());
                    getEntityManager().persist(prodCatalogCategory);

                    return "Add Success!";
                } else {
                    return "Add Error!!!";
                }
            }
        } else {
            //TODO
        }
        return "Add Error!!!";
    }
}
