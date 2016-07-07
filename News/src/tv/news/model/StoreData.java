package tv.news.model;

import tv.news.entities.ProdCatalog;
import tv.news.entities.ProductCategory;
import tv.news.entities.ProductStore;
import tv.user.model.UserProfile;
import tv.web.entities.WebSite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/4/2015
 * Time: 4:49 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
public class StoreData {
    private ProductStore productStore;
    private HashMap<String, NewsData> newsMap = new HashMap<String, NewsData>();
    private HashMap<String, NewsData> videoMap = new HashMap<String, NewsData>();
    private HashMap<String, CategoryData> categoryMap = new HashMap<String, CategoryData>();
    private HashMap<String, CatalogData> catalogMap = new HashMap<String, CatalogData>();
    private HashMap<String, String> newsUrlMap = new HashMap<String, String>();
    private HashMap<String, String> catUrlMap = new HashMap<String, String>();
    private HashMap<String, String> tagsMap = new HashMap<String, String>();
    private HashMap<String, List<NewsData>> tagsNewsMap = new HashMap<String, List<NewsData>>();
    private HashMap<String, UserProfile> userProfileMap = new HashMap<String, UserProfile>();
    private List<ProdCatalog> prodCatalogList;
    private List<ProductCategory> productCategoryList;
//    private CategoryData videoData;
    private CategoryData mainSlide;
    private List<WebSite> webSiteList = new ArrayList<WebSite>();

    public ProductStore getProductStore() {
        return productStore;
    }

    public void setProductStore(ProductStore productStore) {
        this.productStore = productStore;
    }

    public List<ProdCatalog> getProdCatalogList() {
        return prodCatalogList;
    }

    public void setProdCatalogList(List<ProdCatalog> prodCatalogList) {
        this.prodCatalogList = prodCatalogList;
    }

    public List<ProductCategory> getProductCategoryList() {
        return productCategoryList;
    }

    public void setProductCategoryList(List<ProductCategory> productCategoryList) {
        this.productCategoryList = productCategoryList;
    }

//    public CategoryData getVideoData() {
//        if (null == videoData) videoData = new CategoryData();
//        return videoData;
//    }
//
//    public void setVideoData(CategoryData videoData) {
//        this.videoData = videoData;
//    }

    public CategoryData getMainSlide() {
        if (null == mainSlide) mainSlide = new CategoryData();
        return mainSlide;
    }

    public void setMainSlide(CategoryData mainSlide) {
        this.mainSlide = mainSlide;
    }

    public NewsData getNewsFromMap(String newsId) {
        return newsMap.get(newsId);
    }

    public void addNewsToMap(NewsData newsData) {
        newsMap.put(newsData.getNews().getProductId(), newsData);
    }

    public NewsData getVideoFromMap(String videoId) {
        return videoMap.get(videoId);
    }

    public void addVideoToMap(NewsData videoData) {
        videoMap.put(videoData.getNews().getProductId(), videoData);
    }

    public Collection<NewsData> getAllVideoInStore() {
        return videoMap.values();
    }

    public CategoryData getCategoryFromMap(String categoryId) {
        return categoryMap.get(categoryId);
    }

    public void addCategoryToMap(CategoryData categoryData) {
        categoryMap.put(categoryData.getCategory().getProductCategoryId(), categoryData);
    }

    public CatalogData getCatalogFromMap(String catalogId) {
        return catalogMap.get(catalogId);
    }

    public void addCatalogToMap(CatalogData catalogData) {
        catalogMap.put(catalogData.getProdCatalog().getProdCatalogId(), catalogData);
    }

    public Collection<NewsData> getAllNewInStore() {
        return newsMap.values();
    }

    public void addNewsUrlToMap(String url, String newsId) {
        newsUrlMap.put(url, newsId);
    }

    public String getNewsUrlFromMap(String url) {
        return newsUrlMap.get(url);
    }

    public void addCatUrlToMap(String url, String id) {
        catUrlMap.put(url, id);
    }

    public String getCatUrlFromMap(String url) {
        return catUrlMap.get(url);
    }

    public void addTagsToMap(String name, String id) {
        tagsMap.put(name, id);
    }

    public String getTagsFromMap(String name) {
        return tagsMap.get(name);
    }

    public Collection<String> getAllTags() {
        return tagsMap.keySet();
    }

    public void addTagsNewsToMap(String url, List<NewsData> newsDataList) {
        tagsNewsMap.put(url, newsDataList);
    }

    public List<NewsData> getNewsByTagsUrl(String url) {
        return tagsNewsMap.get(url);
    }

    public void addUserToMap(String partyId, UserProfile userProfile) {
        userProfileMap.put(partyId, userProfile);
    }

    public UserProfile getUserProfileFromMap(String partyId) {
        return userProfileMap.get(partyId);
    }

    public List<WebSite> getWebSiteList() {
        return webSiteList;
    }

    public void setWebSiteList(List<WebSite> webSiteList) {
        this.webSiteList = webSiteList;
    }

    public WebSite getWebsite(){
        if (getWebSiteList().size() > 0)
        return webSiteList.get(0);
        return new WebSite();
    }
}
