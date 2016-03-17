package tv.news.model;


import tv.news.entities.ProdCatalog;
import tv.news.entities.ProductCategory;

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
public class CategoryData {
    private ProductCategory category;
    private boolean categoryParent;
    private List<CategoryData> categoryChildList;
    private List<NewsData> newsList;
    private ProdCatalog catalog;

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public boolean isCategoryParent() {
        return categoryParent;
    }

    public void setCategoryParent(boolean categoryParent) {
        this.categoryParent = categoryParent;
    }

    public List<CategoryData> getCategoryChildList() {
        return categoryChildList;
    }

    public void setCategoryChildList(List<CategoryData> categoryChildList) {
        this.categoryChildList = categoryChildList;
    }

    public List<NewsData> getNewsList() {
        if (null == newsList) newsList = new ArrayList<NewsData>();
        return newsList;
    }

    public void setNewsList(List<NewsData> newsList) {
        this.newsList = newsList;
    }

    public ProdCatalog getCatalog() {
        return catalog;
    }

    public void setCatalog(ProdCatalog catalog) {
        this.catalog = catalog;
    }
}
