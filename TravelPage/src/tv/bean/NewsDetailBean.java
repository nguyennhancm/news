package tv.bean;

import tv.news.model.CategoryData;
import tv.news.model.NewsData;
import tv.news.model.Tags;
import tv.news.entities.Product;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NTD
 * Date: 5/30/2015
 * Time: 2:17 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name = "NewsDetailBean")
@ViewScoped
public class NewsDetailBean extends BaseNewsBean implements Serializable {
    private String id;
    private Product product;
    private CategoryData categoryData;
    private List<NewsData> productRelated;
    private String categoryUrl;
    private String catalogUrl;
    private String breadcrumb;
    private List<Tags> tagsList;

    @ManagedProperty(value = "#{NewsTravelBean}")
    NewsBean newsBean;

    public void setNewsBean(NewsBean newsBean) {
        this.newsBean = newsBean;
    }

    public String getId() {
        return super.getViewId();
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        String newsId = newsBean.getStoreData().getNewsUrlFromMap(getId());
        if (null != newsId){
            NewsData newsData = newsBean.getStoreData().getNewsFromMap(newsId);
            product = newsData.getNews();
            return product;
        }
        return null;
    }

    public void setProduct(Product product) {
        this.product = product;
    }



    public CategoryData getCategoryData() {
        if (null == categoryData) categoryData = newsBean.getStoreData().getCategoryFromMap(getProduct().getPrimaryProductCategoryId());
        return categoryData;
    }

    public void setCategoryData(CategoryData categoryData) {
        this.categoryData = categoryData;
    }

    public List<NewsData> getProductRelated() {
        if(null == productRelated){
            if (getCategoryData().getNewsList().size() > 10)
            productRelated = getCategoryData().getNewsList().subList(0,10);
            else productRelated = getCategoryData().getNewsList();
        }
        return productRelated;
    }

    public void setProductRelated(List<NewsData> productRelated) {
        this.productRelated = productRelated;
    }

    public String getBreadcrumb() {
        return breadcrumb;
    }

    public void setBreadcrumb(String breadcrumb) {
        this.breadcrumb = breadcrumb;
    }

    public String getCategoryUrl() {
        categoryUrl = buildCategoryURL(getCategoryData().getCatalog(), getCategoryData().getCategory());
        return categoryUrl;
    }

    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl;
    }

    public String getCatalogUrl() {
        catalogUrl = buildCatalogURL(getCategoryData().getCatalog());
        return catalogUrl;
    }

    public void setCatalogUrl(String catalogUrl) {
        this.catalogUrl = catalogUrl;
    }

    public List<Tags> getTagsList() {
        if (null == tagsList) {
            tagsList = new ArrayList<Tags>();
            String newsId = newsBean.getStoreData().getNewsUrlFromMap(getId());
            NewsData newsData = newsBean.getStoreData().getNewsFromMap(newsId);
            tagsList = newsData.getTagsList();
        }
        return tagsList;
    }

    public void setTagsList(List<Tags> tagsList) {
        this.tagsList = tagsList;
    }

    @Override
    public String getClassName() {
        return getClass().getName();
    }

    @Override
    public String getBundleName() {
        return null;
    }
}
