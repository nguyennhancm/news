package portal.news.bean;

import tv.news.model.NewsData;
import tv.news.model.StoreData;
import portal.users.bean.LoginBean;
import portal.users.model.UserData;
import portal.utils.BasePortalBean;
import portal.utils.CachesStore;
import tv.news.entities.ProdCatalog;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/5/2015
 * Time: 4:27 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@SessionScoped
@ManagedBean(name = "NewsManager")
public class NewsManagerBean extends BasePortalBean {
    private List<ProdCatalog> catalogList;
    private List<NewsData> newsDataList;
    private NewsData news;
    private UserData userData;
    private StoreData storeData;
    @ManagedProperty(value = "#{Login}")
    private LoginBean loginBean;
    @ManagedProperty(value = "#{CachesStore}")
    private CachesStore cachesStore;
    String categoryFilter = "";

    public List<NewsData> loadAllNewsData(){
        newsDataList = new ArrayList<NewsData>(getStoreData().getAllNewInStore());
        if (!categoryFilter.equals("")) newsDataList = new ArrayList<NewsData>(getStoreData().getCategoryFromMap(categoryFilter).getNewsList());
        return newsDataList;
    }

    public String deleteNews(){
        getNewsController().removeNews(news.getNews());
        reloadStore();
        loadAllNewsData();
        return "";
    }

    public void categoryOnChange(){
//        newsDataList = new ArrayList<NewsData>(getStoreData().getCategoryFromMap(categoryFilter).getNewsList());
        if (categoryFilter.equals(""))
            newsDataList = new ArrayList<NewsData>(getStoreData().getAllNewInStore());
        else newsDataList = new ArrayList<NewsData>(getStoreData().getCategoryFromMap(categoryFilter).getNewsList());
    }

    public void reloadStore(){
        setStoreData(cachesStore.reloadStore(userData.getCurrentStore()));
    }

    public List<ProdCatalog> getCatalogList() {
        if(null == catalogList) catalogList = new ArrayList<ProdCatalog>();
        return catalogList;
    }

    public void setCatalogList(List<ProdCatalog> catalogList) {
        this.catalogList = catalogList;
    }

    public List<NewsData> getNewsDataList() {
        if(null == newsDataList)loadAllNewsData();
        return newsDataList;
    }

    public void setNewsDataList(List<NewsData> newsDataList) {
        this.newsDataList = newsDataList;
    }

    public NewsData getNews() {
        return news;
    }

    public void setNews(NewsData news) {
        this.news = news;
    }

    public UserData getUserData() {
        if (null == userData) userData = loginBean.getUserData();
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public CachesStore getCachesStore() {
        return cachesStore;
    }

    public void setCachesStore(CachesStore cachesStore) {
        this.cachesStore = cachesStore;
    }

    public StoreData getStoreData() {
        if (null == storeData) storeData = cachesStore.getStoreById(getUserData().getCurrentStore());
        return storeData;
    }

    public void setStoreData(StoreData storeData) {
        this.storeData = storeData;
    }

    public String getCategoryFilter() {
        return categoryFilter;
    }

    public void setCategoryFilter(String categoryFilter) {
        this.categoryFilter = categoryFilter;
    }

    @Override
    public String getClassName() {
        return getClass().getName();
    }
}
