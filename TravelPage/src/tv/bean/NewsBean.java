package tv.bean;

import tv.news.model.CatalogData;
import tv.news.model.NewsData;
import tv.news.entities.ProdCatalog;
import tv.news.entities.ProductCategory;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/4/2015
 * Time: 4:06 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@ApplicationScoped
@ManagedBean(name = "NewsTravelBean")
public class NewsBean  extends BaseNewsBean{
    String tinTucCategoryId = "2160826";
    String khamPhaDDCatalogId = "2150807";
    String amThucCatalogId = "2150808";
    String duLichCatalogId = "2150809";

    List<ProdCatalog> catalogList;
    List<NewsData> newsDataList;
    NewsData news;
    NewsData firstNewsAmThuc;
    NewsData firstNewsKhachSan;
    NewsData firstNewsHot;
    List<NewsData> newsSlideList;
    List<NewsData> top10NewsLatest;
    List<NewsData> top3BigBlock;
    List<NewsData> top5SmallBlock;
    List<NewsData> top10DiemDen;
    List<NewsData> top8AmThuc;
    List<NewsData> top8KhachSan;
    List<NewsData> top8Hot;


    public String reloadCache(){
        storeData = buildData(storeId);
        loadAllNewsData();
        top3BigBlock = getNewsDataList().subList(0, 3);
        top5SmallBlock = getNewsDataList().subList(3,10);
        newsSlideList = null;
        top10NewsLatest=null;
        top10DiemDen=null;
        top8AmThuc=null;
        top8KhachSan=null;
        top8Hot = null;
        addMessagesInfo("","Reload cache success!");
        return "";
    }

    public List<NewsData> loadAllNewsData(){
        newsDataList = new ArrayList<NewsData>(getStoreData().getAllNewInStore());
        Collections.sort(newsDataList, new Comparator<NewsData>() {
            @Override
            public int compare(NewsData newsData, NewsData newsData1) {

                return newsData.getNews().getProductId().compareTo(newsData1.getNews().getProductId());
            }
        });
        Collections.reverse(newsDataList);
        return newsDataList;
    }

    public List<ProductCategory> getCategoryByCatalog(String catalogId){
        CatalogData catalogData = getStoreData().getCatalogFromMap(catalogId);
        return catalogData.getCategoryMenuList();
    }

    public List<ProdCatalog> getCatalogList() {
        if(null == catalogList) catalogList = new ArrayList<ProdCatalog>(getStoreData().getProdCatalogList());
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

    public List<NewsData> getTop10NewsLatest() {
        if (null == top10NewsLatest) top10NewsLatest = getNewsDataList().subList(0, 10);
        return top10NewsLatest;
    }

    public void setTop10NewsLatest(List<NewsData> top10NewsLatest) {
        this.top10NewsLatest = top10NewsLatest;
    }

    public List<NewsData> getNewsSlideList() {
       if(null == newsSlideList){
           newsSlideList = getStoreData().getMainSlide().getNewsList();
           Collections.sort(newsSlideList, new Comparator<NewsData>() {
               @Override
               public int compare(NewsData newsData, NewsData newsData1) {

                   return Integer.compare(newsData.getLocation(), newsData1.getLocation());
               }
           });
       }
        return newsSlideList;
    }

    public void setNewsSlideList(List<NewsData> newsSlideList) {
        this.newsSlideList = newsSlideList;
    }

    public List<NewsData> getTop3BigBlock() {
        if (null == top3BigBlock) top3BigBlock = getNewsDataList().subList(0, 3);
        return top3BigBlock;
    }

    public void setTop3BigBlock(List<NewsData> top3BigBlock) {
        this.top3BigBlock = top3BigBlock;
    }

    public List<NewsData> getTop5SmallBlock() {
        if (null == top5SmallBlock) top5SmallBlock = getNewsDataList().subList(3,10);
        return top5SmallBlock;
    }

    public void setTop5SmallBlock(List<NewsData> top5SmallBlock) {
        this.top5SmallBlock = top5SmallBlock;
    }

    public List<NewsData> getTop10DiemDen() {
        if (null == top10DiemDen){
            List<NewsData> tmpNewsDataList = getStoreData().getCatalogFromMap(khamPhaDDCatalogId).getNewsList();
            Collections.sort(tmpNewsDataList, new Comparator<NewsData>() {
                @Override
                public int compare(NewsData newsData, NewsData newsData1) {

                    return newsData.getNews().getProductId().compareTo(newsData1.getNews().getProductId());
                }
            });
            Collections.reverse(tmpNewsDataList);
            top10DiemDen = tmpNewsDataList.subList(1,9);
        }
        return top10DiemDen;
    }

    public void setTop10DiemDen(List<NewsData> top10DiemDen) {
        this.top10DiemDen = top10DiemDen;
    }

    public NewsData getFirstNewsAmThuc() {
        if (null == firstNewsAmThuc) {
            List<NewsData> tmpNewsDataList = getStoreData().getCatalogFromMap(amThucCatalogId).getNewsList();
            Collections.sort(tmpNewsDataList, new Comparator<NewsData>() {
                @Override
                public int compare(NewsData newsData, NewsData newsData1) {

                    return newsData.getNews().getProductId().compareTo(newsData1.getNews().getProductId());
                }
            });
            Collections.reverse(tmpNewsDataList);
            firstNewsAmThuc = tmpNewsDataList.get(3);
        }
        return firstNewsAmThuc;
    }

    public void setFirstNewsAmThuc(NewsData firstNewsAmThuc) {
        this.firstNewsAmThuc = firstNewsAmThuc;
    }

    public List<NewsData> getTop8AmThuc() {
        if(null == top8AmThuc) {
            List<NewsData> tmpNewsDataList = getStoreData().getCatalogFromMap(amThucCatalogId).getNewsList();
            Collections.sort(tmpNewsDataList, new Comparator<NewsData>() {
                @Override
                public int compare(NewsData newsData, NewsData newsData1) {

                    return newsData.getNews().getProductId().compareTo(newsData1.getNews().getProductId());
                }
            });
            Collections.reverse(tmpNewsDataList);
            top8AmThuc = tmpNewsDataList.subList(4,12);
        }
        return top8AmThuc;
    }

    public void setTop8AmThuc(List<NewsData> top8AmThuc) {
        this.top8AmThuc = top8AmThuc;
    }

    public NewsData getFirstNewsKhachSan() {
        //chua co tin khach san nen lay category tin tuc thay the
        if (null == firstNewsKhachSan) {
            List<NewsData> tmpNewsDataList = getStoreData().getCatalogFromMap(duLichCatalogId).getNewsList();
            Collections.sort(tmpNewsDataList, new Comparator<NewsData>() {
                @Override
                public int compare(NewsData newsData, NewsData newsData1) {

                    return newsData.getNews().getProductId().compareTo(newsData1.getNews().getProductId());
                }
            });
            Collections.reverse(tmpNewsDataList);
            firstNewsKhachSan = tmpNewsDataList.get(0);
        }
        return firstNewsKhachSan;
    }

    public void setFirstNewsKhachSan(NewsData firstNewsKhachSan) {
        this.firstNewsKhachSan = firstNewsKhachSan;
    }

    public List<NewsData> getTop8KhachSan() {
        if (null == top8KhachSan) {
            List<NewsData> tmpNewsDataList = getStoreData().getCatalogFromMap(duLichCatalogId).getNewsList();
            Collections.sort(tmpNewsDataList, new Comparator<NewsData>() {
                @Override
                public int compare(NewsData newsData, NewsData newsData1) {

                    return newsData.getNews().getProductId().compareTo(newsData1.getNews().getProductId());
                }
            });
            Collections.reverse(tmpNewsDataList);
            top8KhachSan = tmpNewsDataList.subList(1,5);
        }
        return top8KhachSan;
    }

    public void setTop8KhachSan(List<NewsData> top8KhachSan) {
        this.top8KhachSan = top8KhachSan;
    }

    public NewsData getFirstNewsHot() {
        //chua co tin hot nen lay category tin tuc thay the
        if (null == firstNewsHot) {
            List<NewsData> tmpNewsDataList = getStoreData().getCategoryFromMap(tinTucCategoryId).getNewsList();
            Collections.sort(tmpNewsDataList, new Comparator<NewsData>() {
                @Override
                public int compare(NewsData newsData, NewsData newsData1) {

                    return newsData.getNews().getProductId().compareTo(newsData1.getNews().getProductId());
                }
            });
            Collections.reverse(tmpNewsDataList);
            firstNewsHot = tmpNewsDataList.get(3);
        }
        return firstNewsHot;
    }

    public void setFirstNewsHot(NewsData firstNewsHot) {
        this.firstNewsHot = firstNewsHot;
    }

    public List<NewsData> getTop8Hot() {
        if (null == top8Hot) {
            List<NewsData> tmpNewsDataList = getStoreData().getCategoryFromMap(tinTucCategoryId).getNewsList();
            Collections.sort(tmpNewsDataList, new Comparator<NewsData>() {
                @Override
                public int compare(NewsData newsData, NewsData newsData1) {

                    return newsData.getNews().getProductId().compareTo(newsData1.getNews().getProductId());
                }
            });
            Collections.reverse(tmpNewsDataList);
            top8Hot = tmpNewsDataList.subList(4, 15);
        }
        return top8Hot;
    }

    public void setTop8Hot(List<NewsData> top8Hot) {
        this.top8Hot = top8Hot;
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
