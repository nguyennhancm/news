package tv.news.manager;

import tv.news.entities.Product;
import tv.news.entities.ProductAttribute;
import tv.news.entities.ProductCategoryMember;
import tv.news.entities.ProductReview;

import javax.ejb.Local;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/1/2015
 * Time: 7:23 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface INewsManager {
    public Product createNews(Product news);

    public Product updateNews(Product news);

    public boolean removeNews(Product news);

    public List<ProductCategoryMember> getNewsCategoryMemberByProdId(String productId);

    public ProductCategoryMember addNewsCategoryMember(ProductCategoryMember newsCategoryMember);

    public boolean updateNewsCategoryMember(String categoryId, String productId, String categoryOld);

    public ProductReview addProductReview(ProductReview productReview);

    public boolean removeNewsCategoryMember(ProductCategoryMember newsCategoryMember);

    public List<Product> getNewsByCategory(String categoryId);

    public List<ProductAttribute> getProductAttributeForProduct(String productId);

    public List<Product> getNewsPublicByCategory(String categoryId);

    public List<Product> getNewsByCatalog(String catalog);

    public List<Product> getNewsByStore(String storeId);

    public Product getNews(String newsId, String storeId);

    public Product getNews(String newsId);

    public void createProductAttribute(ProductAttribute productAttribute);

    public List<ProductAttribute> getProductAttByProductIdAndName(String productId, String attrName);

    public ProductCategoryMember getNewsCategoryMemberByProdIdAndCategory(String newsId, String category);

    public boolean updateProductCategoryMemberLocation(String productCategoryId, String productId, int sequenceNum);

    public void removeProductAttr(ProductAttribute productAttribute);
}
