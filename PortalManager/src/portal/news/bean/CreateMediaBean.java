package portal.news.bean;

import tv.news.enums.ProductAttributeEnum;
import tv.news.model.NewsData;
import portal.utils.BasePortalBean;
import tv.news.entities.Product;
import tv.news.entities.ProductAttribute;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/10/2015
 * Time: 2:05 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@SessionScoped
@ManagedBean(name = "CreateMediaBean")
public class CreateMediaBean extends BasePortalBean {
    private NewsData newsData;
    @ManagedProperty(value = "#{NewsManager}")
    private NewsManagerBean newsManagerBean;
    private Integer totalEpisodes;
    private String nameENG;
    private String quality;
    private String tags;
    private String titleSEO;
    private String productionYear;
    private String country;
    private String airtime;
    private String broadcaster;
    private String movieActor;
    private String lengthEpisodes;


    public String createMedia() {
        if (validateNews(newsData.getNews().getPrimaryProductCategoryId(), newsData.getNews().getProductName(),
                newsData.getNews().getDescription(), newsData.getNews().getLongDescription(), "MEDIA")) {
            Product product = newsData.getNews();
            if (newsData.isActive()) product.setIsActive("Y");
            else product.setIsActive("N");
            String imageDefault = getImageDefault(product.getLongDescription());
            if (imageDefault.length() > 5) product.setMediumImageUrl(imageDefault);
//            newsManagerBean.getNewsController().createNews(product, newsManagerBean.getUserData().getCurrentStore(), "MEDIA");
            if (null != getTotalEpisodes()) {
                //1
                ProductAttribute productAttribute = new ProductAttribute();
                productAttribute.setProductId(product.getProductId());
                productAttribute.setAttrName(ProductAttributeEnum.TOTAL_EPISODES.toString());
                productAttribute.setAttrValue(String.valueOf(getTotalEpisodes()));
                newsManagerBean.getNewsController().createProductAttribute(productAttribute);
            }
            if (null != getAirtime()) {
                //2
                ProductAttribute productAttribute = new ProductAttribute();
                productAttribute.setProductId(product.getProductId());
                productAttribute.setAttrName(ProductAttributeEnum.AIR_TIME.toString());
                productAttribute.setAttrValue(String.valueOf(getAirtime()));
                newsManagerBean.getNewsController().createProductAttribute(productAttribute);
            }
            if (null != getQuality()) {
                //3
                ProductAttribute productAttribute = new ProductAttribute();
                productAttribute.setProductId(product.getProductId());
                productAttribute.setAttrName(ProductAttributeEnum.QUALITY.toString());
                productAttribute.setAttrValue(String.valueOf(getQuality()));
                newsManagerBean.getNewsController().createProductAttribute(productAttribute);
            }
            if (null != getBroadcaster()) {
                //4
                ProductAttribute productAttribute = new ProductAttribute();
                productAttribute.setProductId(product.getProductId());
                productAttribute.setAttrName(ProductAttributeEnum.BROADCASTER.toString());
                productAttribute.setAttrValue(String.valueOf(getBroadcaster()));
                newsManagerBean.getNewsController().createProductAttribute(productAttribute);
            }
            if (null != getCountry()) {
                //5
                ProductAttribute productAttribute = new ProductAttribute();
                productAttribute.setProductId(product.getProductId());
                productAttribute.setAttrName(ProductAttributeEnum.COUNTRY.toString());
                productAttribute.setAttrValue(String.valueOf(getCountry()));
                newsManagerBean.getNewsController().createProductAttribute(productAttribute);
            }
            if (null != getNameENG()) {
                //7
                ProductAttribute productAttribute = new ProductAttribute();
                productAttribute.setProductId(product.getProductId());
                productAttribute.setAttrName(ProductAttributeEnum.NAME_ENG.toString());
                productAttribute.setAttrValue(String.valueOf(getNameENG()));
                newsManagerBean.getNewsController().createProductAttribute(productAttribute);
            }
            if (null != getMovieActor()) {
                //8
                ProductAttribute productAttribute = new ProductAttribute();
                productAttribute.setProductId(product.getProductId());
                productAttribute.setAttrName(ProductAttributeEnum.MOVIE_ACTOR.toString());
                productAttribute.setAttrValue(String.valueOf(getMovieActor()));
                newsManagerBean.getNewsController().createProductAttribute(productAttribute);
            }
            if (null != getProductionYear()) {
                //9
                ProductAttribute productAttribute = new ProductAttribute();
                productAttribute.setProductId(product.getProductId());
                productAttribute.setAttrName(ProductAttributeEnum.PRODUCTION_YEAR.toString());
                productAttribute.setAttrValue(String.valueOf(getProductionYear()));
                newsManagerBean.getNewsController().createProductAttribute(productAttribute);
            }
            if (null != getTags()) {
                //10
                ProductAttribute productAttribute = new ProductAttribute();
                productAttribute.setProductId(product.getProductId());
                productAttribute.setAttrName(ProductAttributeEnum.TAGS.toString());
                productAttribute.setAttrValue(String.valueOf(getTags()));
                newsManagerBean.getNewsController().createProductAttribute(productAttribute);
            }
            if (null != getTitleSEO()) {
                //11
                ProductAttribute productAttribute = new ProductAttribute();
                productAttribute.setProductId(product.getProductId());
                productAttribute.setAttrName(ProductAttributeEnum.TITLE_SEO.toString());
                productAttribute.setAttrValue(String.valueOf(getTitleSEO()));
                newsManagerBean.getNewsController().createProductAttribute(productAttribute);
            }
            if (null != getLengthEpisodes()) {
                //11
                ProductAttribute productAttribute = new ProductAttribute();
                productAttribute.setProductId(product.getProductId());
                productAttribute.setAttrName(ProductAttributeEnum.LENGTH_EPISODE.toString());
                productAttribute.setAttrValue(String.valueOf(getLengthEpisodes()));
                newsManagerBean.getNewsController().createProductAttribute(productAttribute);
            }
            newsData = new NewsData();
            newsManagerBean.reloadStore();
            return "manage_news";
        }
        return "";
    }

    public NewsData getNewsData() {
        if (null == newsData) {
            newsData = new NewsData();
            newsData.setActive(true);
        }
        return newsData;
    }

    public void setNewsData(NewsData newsData) {
        this.newsData = newsData;
    }

    public NewsManagerBean getNewsManagerBean() {
        return newsManagerBean;
    }

    public void setNewsManagerBean(NewsManagerBean newsManagerBean) {
        this.newsManagerBean = newsManagerBean;
    }

    public Integer getTotalEpisodes() {
        return totalEpisodes;
    }

    public void setTotalEpisodes(Integer totalEpisodes) {
        this.totalEpisodes = totalEpisodes;
    }

    public String getNameENG() {
        return nameENG;
    }

    public void setNameENG(String nameENG) {
        this.nameENG = nameENG;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTitleSEO() {
        return titleSEO;
    }

    public void setTitleSEO(String titleSEO) {
        this.titleSEO = titleSEO;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(String productionYear) {
        this.productionYear = productionYear;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAirtime() {
        return airtime;
    }

    public void setAirtime(String airtime) {
        this.airtime = airtime;
    }

    public String getBroadcaster() {
        return broadcaster;
    }

    public void setBroadcaster(String broadcaster) {
        this.broadcaster = broadcaster;
    }

    public String getMovieActor() {
        return movieActor;
    }

    public void setMovieActor(String movieActor) {
        this.movieActor = movieActor;
    }

    public String getLengthEpisodes() {
        return lengthEpisodes;
    }

    public void setLengthEpisodes(String lengthEpisodes) {
        this.lengthEpisodes = lengthEpisodes;
    }

    @Override
    public String getClassName() {
        return getClass().getName();
    }
}
