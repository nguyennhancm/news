package tv.bean;

import tv.news.entities.Product;
import tv.news.model.NewsData;
import tv.utils.UnicodeUtils;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * User: NTD
 * Date: 5/31/2015
 * Time: 11:49 AM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name = "ReWriteURLBean")
@ApplicationScoped
public class ReWriteURLBean extends BaseNewsBean implements Serializable {
    private String urlReWrite;
    private String hostName;
    private ConcurrentHashMap<Integer, String> mapURLReWrite = new ConcurrentHashMap<Integer, String>();
    private Product news;

    @ManagedProperty(value = "#{NewsTravelBean}")
    NewsBean newsBean;

    public void setNewsBean(NewsBean newsBean) {
        this.newsBean = newsBean;
    }

    public String getNewsById(int id) {
        return mapURLReWrite.get(id);
    }

    MessageFormat urlFormat = new MessageFormat("/{0}/{1}-{2}");

    public String buildURL(int id) {
        urlReWrite = mapURLReWrite.get(id);
        if (null == urlReWrite) {
            NewsData newsData = newsBean.getStoreData().getNewsFromMap(String.valueOf(id));
            news = newsData.getNews();
            String noSignUrl = UnicodeUtils.unicode2NoSign(news.getProductName().toLowerCase().trim().replaceAll("[\\W]+", "-").replaceAll("-+$", ""));
            urlReWrite = urlFormat.format(new Object[]{"news", noSignUrl, news.getProductId().toString() + ".html"});
            mapURLReWrite.put(id, urlReWrite);
        }
        return urlReWrite;
    }

    public String getHostName() {
        if (null == hostName) {
            hostName = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getHeader("host");
        }
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
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
