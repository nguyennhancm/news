package tv.news.controller;

import tv.news.entities.Product;
import tv.news.entities.ProductAttribute;
import tv.news.entities.ProductCategoryMember;

import javax.ejb.Local;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/2/2015
 * Time: 1:45 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface INewsController {

    public Product createNews(Product news, String storeId, String type, List<ProductAttribute> imagesList);

    public boolean updateNews(Product news, List<ProductAttribute> imagesList);

    public boolean removeNews(Product news);

    public List<Product> getNewsByCategory(String categoryId);

    public List<ProductAttribute> getProductAttributeForProduct(String productId);

    public List<Product> getNewsPublicByCategory(String categoryId);

    public List<Product> getNewsByCatalog(String catalog);

    public List<Product> getNewsByStore(String storeId);

    public Product getNews(String newsId, String storeId);

    public void createProductAttribute(ProductAttribute productAttribute);

    public List<ProductAttribute> getProductAttByProductIdAndName(String productId, String attrName);

    public ProductCategoryMember getNewsCategoryMemberByProdIdAndCategory(String newsId, String category);

    public boolean updateProductCategoryMemberLocation(String productCategoryId, String productId, int sequenceNum);

    public void removeProductAttr(ProductAttribute productAttribute);

}
