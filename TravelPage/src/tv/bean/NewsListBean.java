package tv.bean;


import tv.news.model.NewsData;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/21/2015
 * Time: 8:56 AM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@RequestScoped
@ManagedBean(name = "NewsTravelList")
public class NewsListBean extends BaseNewsBean {
    private String id;
    private String type;
    private List<NewsData> newsDataList;
    private String catName;
    private List<NewsData> leftNewsList;
    private List<NewsData> rightNewsList;
    private int page = 0;
    int param_page = 0;

    @ManagedProperty(value = "#{NewsTravelBean}")
    NewsBean newsBean;


    @PostConstruct
    public void init() {
        if (null != getNewsDataList()){
            if (newsDataList.size() < 2) {
                leftNewsList = newsDataList;
                rightNewsList = new ArrayList<NewsData>();
            } else {
                if (newsDataList.size() < 10) {
                    leftNewsList = newsDataList.subList(0, newsDataList.size() / 2);
                    rightNewsList = newsDataList.subList(newsDataList.size() / 2, newsDataList.size());
                    page = 1;
                } else {
                    page = (newsDataList.size()/10);
                    if (newsDataList.size()%10 > 0){
                        page++;
                    }
                    String pageS = super.getParameter("page");
                    if(null != pageS) param_page = Integer.parseInt(pageS);
                    int current = param_page * 10;
                    if (param_page == page -1){
                        leftNewsList = newsDataList.subList(current, current + ((newsDataList.size() - current) / 2));
                        rightNewsList = newsDataList.subList(current + ((newsDataList.size() - current) / 2), newsDataList.size());
                    }else {
                        leftNewsList = newsDataList.subList(current, current + 5);
                        rightNewsList = newsDataList.subList(current + 5, current + 10);
                    }
                }
            }
        }
    }

    public String getId() {
//        String[] pathSub = super.getViewId().split("\\.");
//        String[] pathEnd = pathSub[0].split("-");
//        id = pathEnd[pathEnd.length - 1];
        id = newsBean.getStoreData().getCatUrlFromMap(super.getViewId());

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        type = super.getViewType();
        return type;
    }

    public String styleUrl(String name) {
        if (null == super.getViewId()) {
            if (name.equals("/")) return "active";
        } else {
            if (super.getViewId().equals(name)) return "active";
        }
        return "";
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<NewsData> getNewsDataList() {
        if (getType().equals("tags")){
            newsDataList = newsBean.getStoreData().getCategoryFromMap(getId()).getNewsList();
        }else {
            if (null == newsBean.getStoreData().getCatalogFromMap(getId())) {
                try {
                    newsDataList = newsBean.getStoreData().getCategoryFromMap(getId()).getNewsList();
                    Collections.sort(newsDataList, new Comparator<NewsData>() {
                        @Override
                        public int compare(NewsData newsData, NewsData newsData1) {

                            return newsData.getNews().getProductId().compareTo(newsData1.getNews().getProductId());
                        }
                    });
                    Collections.reverse(newsDataList);
                } catch (Exception e) {
                    newsDataList = new ArrayList<NewsData>();
                }
                return newsDataList;
            }
            newsDataList = newsBean.getStoreData().getCatalogFromMap(getId()).getNewsList();
            Collections.sort(newsDataList, new Comparator<NewsData>() {
                @Override
                public int compare(NewsData newsData, NewsData newsData1) {

                    return newsData.getNews().getProductId().compareTo(newsData1.getNews().getProductId());
                }
            });
            Collections.reverse(newsDataList);
        }
        return newsDataList;
    }

    public void setNewsDataList(List<NewsData> newsDataList) {
        this.newsDataList = newsDataList;
    }

    public NewsBean getNewsBean() {
        return newsBean;
    }

    public void setNewsBean(NewsBean newsBean) {
        this.newsBean = newsBean;
    }

    public String getCatName() {
        try {
            if (getType().equals("category")) {
                if (null != newsBean.getStoreData().getCategoryFromMap(getId()))
                catName = newsBean.getStoreData().getCategoryFromMap(getId()).getCategory().getCategoryName();
                else return "File not found!";
            }else if (getType().equals("catalog")) {
                if (null != newsBean.getStoreData().getCatalogFromMap(getId()))
                catName = newsBean.getStoreData().getCatalogFromMap(getId()).getProdCatalog().getCatalogName();
                else return "File not found!";
            } else if (getType().equals("tags")){
                if (null != newsBean.getStoreData().getCategoryFromMap(getId())) {
//                    String tagsTitle = "Bài viết về";
                    catName = newsBean.getStoreData().getCategoryFromMap(getId()).getCategory().getCategoryName();
                }else return "File not found!";
            }
        }catch (Exception e){
            logger.info(e.getMessage());
            return "File not found!";
        }

        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public List<NewsData> getLeftNewsList() {
        return leftNewsList;
    }

    public void setLeftNewsList(List<NewsData> leftNewsList) {

        this.leftNewsList = leftNewsList;
    }

    public List<NewsData> getRightNewsList() {
        return rightNewsList;
    }

    public void setRightNewsList(List<NewsData> rightNewsList) {
        this.rightNewsList = rightNewsList;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
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
