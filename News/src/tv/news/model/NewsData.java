package tv.news.model;

import tv.news.entities.Product;
import tv.news.entities.ProductAttribute;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/4/2015
 * Time: 2:12 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
public class NewsData {
    private Product news;
    private String PrimaryCategoryName;
    private boolean active;
    private String longDescription;
    private String url;
    private List<ProductAttribute> productAttributes;
    private List<Tags> tagsList;
    private int location;

    public Product getNews() {
        if (null == news) news = new Product();
        return news;
    }

    public void setNews(Product news) {
        this.news = news;
    }

    public String getPrimaryCategoryName() {
        return PrimaryCategoryName;
    }

    public void setPrimaryCategoryName(String primaryCategoryName) {
        PrimaryCategoryName = primaryCategoryName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<ProductAttribute> getProductAttributes() {
        return productAttributes;
    }

    public void setProductAttributes(List<ProductAttribute> productAttributes) {
        this.productAttributes = productAttributes;
    }

    public List<Tags> getTagsList() {
        if(null == tagsList) tagsList = new ArrayList<Tags>();
        return tagsList;
    }

    public void setTagsList(List<Tags> tagsList) {
        this.tagsList = tagsList;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }
}
