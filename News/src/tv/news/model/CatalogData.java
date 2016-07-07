package tv.news.model;

import tv.news.entities.ProdCatalog;
import tv.news.entities.ProductCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/4/2015
 * Time: 2:12 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
public class CatalogData {
    private ProdCatalog prodCatalog;
    private List<ProductCategory> categoryMenuList;
    private HashMap<String,CategoryData> categoryDataMap = new HashMap<String, CategoryData>();
    private List<NewsData> newsList;


    public CategoryData getCategoryDataById(String categoryId){
        return categoryDataMap.get(categoryId);
    }

    public void addCategoryDataToMap(CategoryData categoryData){
        categoryDataMap.put(categoryData.getCategory().getProductCategoryId(), categoryData);
    }

    public ProdCatalog getProdCatalog() {
        return prodCatalog;
    }

    public void setProdCatalog(ProdCatalog prodCatalog) {
        this.prodCatalog = prodCatalog;
    }

    public List<ProductCategory> getCategoryMenuList() {
        if(null == categoryMenuList) categoryMenuList = new ArrayList<ProductCategory>();
        return categoryMenuList;
    }

    public void setCategoryMenuList(List<ProductCategory> categoryMenuList) {
        this.categoryMenuList = categoryMenuList;
    }

   public void addCategoryToMap(CategoryData category){
       categoryDataMap.put(category.getCategory().getProductCategoryId(), category);
   }

    public List<NewsData> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<NewsData> newsList) {
        this.newsList = newsList;
    }
}
