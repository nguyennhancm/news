package tv.servlet;

import tv.news.model.NewsData;
import tv.news.model.StoreData;
import tv.bean.NewsBean;
import tv.news.entities.ProdCatalog;
import tv.news.entities.ProductCategory;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 9/18/2015
 * Time: 6:43 AM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(value = "/sitemap.xml")
@ApplicationScoped
@ManagedBean(name = "SiteMap")
public class SiteMapServlet extends HttpServlet{
    StoreData storeData;

    @ManagedProperty(value = "#{NewsTravelBean}")
    NewsBean newsBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String serverName = request.getServerName();
        serverName = request.getScheme()+"://"+serverName.replace("www.", "");
        int port = request.getServerPort();
        if(80!=port&&433!=port){
            serverName+=":"+port;
        }
        String content = generateSiteMap(serverName, getStoreData());
        PrintWriter out = response.getWriter();
        response.setContentType("text/xml; charset=utf-8");
//        response.setHeader("Content-Encoding","gzip");
        out.print(content);
    }

    public String generateSiteMap(String domain,StoreData storeData){
        String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        xml+="<urlset\n" +
                "      xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\"\n" +
                "      xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "      xsi:schemaLocation=\"http://www.sitemaps.org/schemas/sitemap/0.9\n" +
                "            http://www.sitemaps.org/schemas/sitemap/0.9/sitemap.xsd\">";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateGenerate = simpleDateFormat.format(new Date());
        // home link
        xml+=generateSiteMapLink(domain+"/",dateGenerate,"daily","1");
        if(null!=storeData){
            // add catalog link
            String catalogLink = "";
            String categoryLink = "";
            String newsLink = "";

            for(ProdCatalog catalog: storeData.getProdCatalogList()){
                catalogLink = newsBean.buildCatalogURL(catalog);
                xml+=generateSiteMapLink(domain + catalogLink,dateGenerate,"daily","0.85");
            }
            // add category link
            for(ProductCategory category: storeData.getProductCategoryList()){
                categoryLink = newsBean.buildCategoryURL(storeData.getCategoryFromMap(category.getProductCategoryId()).getCatalog(), category);
                xml+=generateSiteMapLink(domain + categoryLink,dateGenerate,"daily","0.75");
            }
            // add product link
            for(NewsData news: storeData.getAllNewInStore()){
                newsLink = newsBean.buildNewsURL(storeData.getCategoryFromMap(news.getNews().getPrimaryProductCategoryId()).getCatalog(), storeData.getCategoryFromMap(news.getNews().getPrimaryProductCategoryId()).getCategory(), news.getNews());
                xml+=generateSiteMapLink(domain + newsLink, dateGenerate, "daily", "0.5");
            }
        }
        xml+="</urlset>";
        return xml;
    }

    public String generateSiteMapLink(String link,String date, String freq, String priority){
        String data = "<url>";
        data+="<loc>"+link+"</loc>";
        data+="<lastmod>"+date+"</lastmod>";
        data+="<changefreq>"+freq+"</changefreq>";
        data+="<priority>"+priority+"</priority>";
        data+="</url>";
        return data;
    }

    public StoreData getStoreData() {
        if (null == storeData) storeData = getNewsBean().getStoreData();
        return storeData;
    }

    public void setStoreData(StoreData storeData) {
        this.storeData = storeData;
    }

    public NewsBean getNewsBean() {
        if (null == newsBean) newsBean = new NewsBean();
        return newsBean;
    }

    public void setNewsBean(NewsBean newsBean) {
        this.newsBean = newsBean;
    }
}
