package portal.video.bean;

import portal.users.bean.LoginBean;
import portal.users.model.UserData;
import portal.utils.BasePortalBean;
import portal.utils.CachesStore;
import tv.news.entities.ProdCatalog;
import tv.news.model.NewsData;
import tv.news.model.StoreData;

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
@ManagedBean(name = "VideoManager")
public class VideoManagerBean extends BasePortalBean {
    private List<ProdCatalog> catalogList;
    private List<NewsData> videoDataList;
    private NewsData news;
    private UserData userData;
    private StoreData storeData;
    @ManagedProperty(value = "#{Login}")
    private LoginBean loginBean;
    @ManagedProperty(value = "#{CachesStore}")
    private CachesStore cachesStore;
    String categoryFilter = "";

    public List<NewsData> loadAllVideoData(){
        if (!categoryFilter.equals("")) videoDataList = new ArrayList<NewsData>(getStoreData().getCategoryFromMap(categoryFilter).getNewsList());
        else videoDataList = new ArrayList<NewsData>(getStoreData().getAllVideoInStore());
        return videoDataList;
    }

    public String deleteVideo(){
        getNewsController().removeNews(news.getNews());
        reloadStore();
        loadAllVideoData();
        return "";
    }

    public void categoryOnChange(){
        loadAllVideoData();
    }

    public void reloadStore(){
        setStoreData(cachesStore.reloadStore(getUserData().getCurrentStore()));
    }

    public List<ProdCatalog> getCatalogList() {
        if(null == catalogList) catalogList = new ArrayList<ProdCatalog>();
        return catalogList;
    }

    public void setCatalogList(List<ProdCatalog> catalogList) {
        this.catalogList = catalogList;
    }

    public List<NewsData> getVideoDataList() {
        if(null == videoDataList)loadAllVideoData();
        return videoDataList;
    }

    public void setVideoDataList(List<NewsData> videoDataList) {
        this.videoDataList = videoDataList;
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
