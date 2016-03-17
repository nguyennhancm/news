package portal.slide.bean;

import tv.news.model.NewsData;
import org.primefaces.context.RequestContext;
import portal.news.bean.NewsManagerBean;
import portal.utils.BasePortalBean;
import tv.news.entities.ProductCategoryMember;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 11/12/2015
 * Time: 2:14 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@SessionScoped
@ManagedBean(name = "ManageSlide")
public class ManageSlideBean extends BasePortalBean{
    List<NewsData> newsDataList;
    List<NewsData> newsSlideData;
    String categoryFilter = "";
    NewsData news;

    @ManagedProperty(value = "#{NewsManager}")
    private NewsManagerBean newsManagerBean;

    public String addNewsToSlide(){
        String categoryId = newsManagerBean.getStoreData().getMainSlide().getCategory().getProductCategoryId();
            if (null != getNewsController().getNewsCategoryMemberByProdIdAndCategory(news.getNews().getProductId(), categoryId)){
                addValidateError(null, "Bài viết: \" " + news.getNews().getProductName() + "\" đã có trong Slide!");
                return "";
            }
        ProductCategoryMember pcm = new ProductCategoryMember();
        pcm.setProductId(news.getNews().getProductId());
        pcm.setProductCategoryId(categoryId);
        int maxLocation = getMaxlocation(newsManagerBean.getStoreData().getMainSlide().getNewsList());
        pcm.setSequenceNum(maxLocation);
        pcm.setFromDate(new Timestamp(new Date().getTime()));
        getCategoryController().createProductCategoryMember(pcm);
        news.setLocation(maxLocation);
        newsManagerBean.getStoreData().getMainSlide().getNewsList().add(news);
        RequestContext.getCurrentInstance().execute("PF('addNewsToSlide').hide();");
        addMessagesInfo(null, "Đã thêm bài viết: \" " + news.getNews().getProductName() + "\" vào Slide!");
        return "";
    }

    public void removeNewsFromSlide(){
        getCategoryController().deleteProductCategoryMember(news.getNews().getProductId(), newsManagerBean.getStoreData().getMainSlide().getCategory().getProductCategoryId());
        newsManagerBean.getStoreData().getMainSlide().getNewsList().remove(news);
        addMessagesInfo(null, "Đã xóa bài viết: \" " + news.getNews().getProductName() + "\" khỏi Slide!");
    }

    public void categoryOnChange(){
        if (categoryFilter.equals(""))
            newsDataList = new ArrayList<NewsData>(newsManagerBean.getStoreData().getAllNewInStore());
        else newsDataList = new ArrayList<NewsData>(newsManagerBean.getStoreData().getCategoryFromMap(categoryFilter).getNewsList());
    }

    public List<NewsData> getNewsDataList() {
        newsDataList = new ArrayList<NewsData>(newsManagerBean.getStoreData().getAllNewInStore());
        if (!categoryFilter.equals("")) newsDataList = new ArrayList<NewsData>(newsManagerBean.getStoreData().getCategoryFromMap(categoryFilter).getNewsList());
        return newsDataList;
    }

    public void editLocation(){
        String categoryId = newsManagerBean.getStoreData().getMainSlide().getCategory().getProductCategoryId();
        getNewsController().updateProductCategoryMemberLocation(categoryId, news.getNews().getProductId(), news.getLocation());
        for (NewsData newsData: newsManagerBean.getStoreData().getMainSlide().getNewsList()){
            if (newsData.getNews().getProductId().equals(news.getNews().getProductId())){
               newsData.setLocation(news.getLocation());
                break;
            }
        }
        addMessagesInfo(null, "Đã sửa vị trí bài viết: " + news.getNews().getProductName());
        RequestContext.getCurrentInstance().execute("PF('EditLocation').hide();");
    }

    public void setNewsDataList(List<NewsData> newsDataList) {
        this.newsDataList = newsDataList;
    }

    public String getCategoryFilter() {
        return categoryFilter;
    }

    public void setCategoryFilter(String categoryFilter) {
        this.categoryFilter = categoryFilter;
    }

    public NewsManagerBean getNewsManagerBean() {
        return newsManagerBean;
    }

    public void setNewsManagerBean(NewsManagerBean newsManagerBean) {
        this.newsManagerBean = newsManagerBean;
    }

    public NewsData getNews() {
        return news;
    }

    public void setNews(NewsData news) {
        this.news = news;
    }

    public List<NewsData> getNewsSlideData() {
        newsSlideData = newsManagerBean.getStoreData().getMainSlide().getNewsList();
        return newsSlideData;
    }

    public void setNewsSlideData(List<NewsData> newsSlideData) {
        this.newsSlideData = newsSlideData;
    }

    @Override
    public String getClassName() {
        return getClass().getName();
    }
}
