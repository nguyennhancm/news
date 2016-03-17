package tv.news.controller.impl;

import tv.news.controller.INewsController;
import tv.news.entities.Product;
import tv.news.entities.ProductAttribute;
import tv.news.entities.ProductCategoryMember;
import tv.news.entities.ProductReview;
import tv.utils.controller.BaseController;

import javax.ejb.Stateless;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/2/2015
 * Time: 1:45 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class NewsController extends BaseController implements INewsController {

    @Override
    public Product createNews(Product news, String storeId, String type, List<ProductAttribute> imagesList) {
        //add new product
        if(null == news.getProductId()) news.setProductId(getSequenceValue().getSequenceValueItem(Product.class));
        news.setProductTypeId(type);
        news.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        getNewsManager().createNews(news);
        // add new productCategoryMember
        ProductCategoryMember productCategoryMember = new ProductCategoryMember();
        productCategoryMember.setProductId(news.getProductId());
        productCategoryMember.setProductCategoryId(news.getPrimaryProductCategoryId());
        productCategoryMember.setFromDate(new Timestamp(System.currentTimeMillis()));
        getNewsManager().addNewsCategoryMember(productCategoryMember);
        // add new productReview
        ProductReview productReview = new ProductReview();
        productReview.setProductReviewId(getSequenceValue().getSequenceValueItem(ProductReview.class));
        productReview.setProductId(news.getProductId());
        productReview.setProductStoreId(storeId);
        getNewsManager().addProductReview(productReview);
        // save images list
        if (imagesList.size()>0){
            for (ProductAttribute image: imagesList){
                getNewsManager().createProductAttribute(image);
            }
        }
        return news;
    }

    @Override
    public boolean updateNews(Product news, List<ProductAttribute> imagesList) {
        String categoryOld = getNewsManager().getNews(news.getProductId()).getPrimaryProductCategoryId();
        //check update product category member
        if (!news.getPrimaryProductCategoryId().equals(categoryOld)) {
            // update product category member
            getNewsManager().updateNewsCategoryMember(news.getPrimaryProductCategoryId(), news.getProductId(), categoryOld);
            news.setPrimaryProductCategoryId(categoryOld);
        }
        getNewsManager().updateNews(news);
        // save images list
        if (imagesList.size()>0){
            for (ProductAttribute image: imagesList){
                getNewsManager().createProductAttribute(image);
            }
        }
        return false;
    }

    @Override
    public boolean removeNews(Product news) {
        return getNewsManager().removeNews(news);
    }

    @Override
    public List<Product> getNewsByCategory(String categoryId) {
        return getNewsManager().getNewsByCategory(categoryId);
    }

    @Override
    public List<ProductAttribute> getProductAttributeForProduct(String productId) {
        return getNewsManager().getProductAttributeForProduct(productId);
    }

    public List<Product> getNewsPublicByCategory(String categoryId) {
        return getNewsManager().getNewsPublicByCategory(categoryId);
    }

    @Override
    public List<Product> getNewsByCatalog(String catalog) {
        return null;
    }

    @Override
    public List<Product> getNewsByStore(String storeId) {
        return getNewsManager().getNewsByStore(storeId);
    }

    @Override
    public Product getNews(String NewsId, String storeId) {
        return null;
    }

    @Override
    public void createProductAttribute(ProductAttribute productAttribute) {
        getNewsManager().createProductAttribute(productAttribute);
    }

    @Override
    public List<ProductAttribute> getProductAttByProductIdAndName(String productId, String attrName) {
        return getNewsManager().getProductAttByProductIdAndName(productId, attrName);
    }

    @Override
    public ProductCategoryMember getNewsCategoryMemberByProdIdAndCategory(String newsId, String category) {
        return getNewsManager().getNewsCategoryMemberByProdIdAndCategory(newsId, category);
    }

    @Override
    public boolean updateProductCategoryMemberLocation(String productCategoryId, String productId, int sequenceNum) {
        return getNewsManager().updateProductCategoryMemberLocation(productCategoryId, productId, sequenceNum);
    }

    @Override
    public void removeProductAttr(ProductAttribute productAttribute) {
        getNewsManager().removeProductAttr(productAttribute);
    }
}
