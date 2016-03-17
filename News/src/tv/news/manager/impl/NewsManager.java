package tv.news.manager.impl;

import tv.news.entities.Product;
import tv.news.entities.ProductAttribute;
import tv.news.entities.ProductCategoryMember;
import tv.news.entities.ProductReview;
import tv.news.manager.INewsManager;
import tv.utils.manager.BaseManager;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/2/2015
 * Time: 1:44 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class NewsManager extends BaseManager implements INewsManager {
    @PersistenceContext(unitName = "Travel")
    EntityManager em;

    public NewsManager() {
    }

    @Override
    public Product createNews(Product news) {
        return getEntityManager().merge(news);
    }

    @Override
    public Product updateNews(Product news) {
        return getEntityManager().merge(news);
    }

    @Override
    public boolean removeNews(Product news) {
        Query query = getEntityManager().createQuery("update Product p set p.isActive = NULL where p.productId=:productId");
        query.setParameter("productId", news.getProductId());
        if (query.executeUpdate() > 0) {
            return true;
        }
        return false;
    }



    @Override
    public List<ProductCategoryMember> getNewsCategoryMemberByProdId(String productId) {
        return null;
    }

    @Override
    public ProductCategoryMember addNewsCategoryMember(ProductCategoryMember newsCategoryMember) {
        return getEntityManager().merge(newsCategoryMember);
    }

    @Override
    public boolean updateNewsCategoryMember(String categoryId, String productId, String categoryOld) {
        Query query = em.createQuery("update ProductCategoryMember pcm set pcm.productCategoryId=:productCategoryId " +
                "where pcm.productId=:productId and pcm.productCategoryId=:productCategoryIdOld");
        query.setParameter("productCategoryId", categoryId);
        query.setParameter("productId", productId);
        query.setParameter("productCategoryIdOld", categoryOld);
        if (query.executeUpdate() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public ProductReview addProductReview(ProductReview productReview) {
        return getEntityManager().merge(productReview);
    }

    @Override
    public boolean removeNewsCategoryMember(ProductCategoryMember newsCategoryMember) {
        getEntityManager().remove(newsCategoryMember);
        return true;
    }

    @Override
    public List<Product> getNewsByCategory(String categoryId) {
        Query query = em.createQuery("select p from Product p where p.productId " +
                "in (select pr.productId from ProductCategoryMember pr where pr.productCategoryId=:categoryId) and p.isActive IS NOT NULL order by p.createdDate DESC");
        query.setParameter("categoryId", categoryId);
        return query.getResultList();
    }

    @Override
    public List<ProductAttribute> getProductAttributeForProduct(String productId) {
        Query query = em.createQuery("select pa from ProductAttribute pa where pa.productId =:productId");
        query.setParameter("productId", productId);
        List<ProductAttribute> productAttributes = query.getResultList();
        return productAttributes;
    }

    @Override
    public List<Product> getNewsPublicByCategory(String categoryId) {
        Query query = em.createQuery("select p from Product p where p.productId " +
                "in (select pr.productId from ProductCategoryMember pr where pr.productCategoryId=:categoryId) and p.isActive='Y' order by p.createdDate DESC");
        query.setParameter("categoryId", categoryId);
        return query.getResultList();
    }

    @Override
    public List<Product> getNewsByCatalog(String catalog) {
        return null;
    }

    @Override
    public List<Product> getNewsByStore(String storeId) {
        Query query = em.createQuery("select p from Product p where p.productId " +
                "in (select pr.productId from ProductReview pr where pr.productStoreId=:storeId) and p.isActive IS NOT NULL order by p.createdDate DESC");
        query.setParameter("storeId", storeId);
        return query.getResultList();
    }

    @Override
    public Product getNews(String newsId, String storeId) {
        return null;
    }

    @Override
    public Product getNews(String newsId) {
        return getEntityManager().find(Product.class, newsId);
    }

    @Override
    public void createProductAttribute(ProductAttribute productAttribute) {
        getEntityManager().merge(productAttribute);
    }

    @Override
    public List<ProductAttribute> getProductAttByProductIdAndName(String productId, String attrName) {
        Query query = em.createQuery("select pa from ProductAttribute pa where pa.productId =:productId and lower(pa.attrName) like :attrName");
        query.setParameter("productId", productId);
        query.setParameter("attrName", "%" + attrName.toLowerCase() + "%");
        return query.getResultList();
    }

    @Override
    public ProductCategoryMember getNewsCategoryMemberByProdIdAndCategory(String newsId, String category) {
        Query query = getEntityManager().createQuery("select pcm from ProductCategoryMember pcm where " +
                "pcm.productCategoryId=:productCategoryId and pcm.productId=:productId");
        query.setParameter("productCategoryId", category);
        query.setParameter("productId", newsId);
        List<ProductCategoryMember> productCategoryMembers = query.getResultList();
        if (productCategoryMembers.size() > 0 ) return productCategoryMembers.get(0);
        return null;
    }

    @Override
    public boolean updateProductCategoryMemberLocation(String productCategoryId, String productId, int sequenceNum) {
        Query query = em.createQuery("update ProductCategoryMember pcm set pcm.sequenceNum=:sequenceNum " +
                "where pcm.productId=:productId and pcm.productCategoryId=:productCategoryId");
        query.setParameter("sequenceNum", sequenceNum);
        query.setParameter("productId", productId);
        query.setParameter("productCategoryId", productCategoryId);
        if (query.executeUpdate() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void removeProductAttr(ProductAttribute productAttribute) {
        Query query = getEntityManager().createQuery("delete ProductAttribute pa where pa.productId=:productId and pa.attrName=:attrName");
        query.setParameter("productId", productAttribute.getProductId());
        query.setParameter("attrName", productAttribute.getAttrName());
        query.executeUpdate();
    }

}
