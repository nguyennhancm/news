package tv.bean;

import tv.news.enums.CategoryType;
import tv.news.model.*;
import tv.news.controller.ICategoryController;
import tv.news.controller.INewsController;
import tv.news.entities.ProdCatalog;
import tv.news.entities.Product;
import tv.news.entities.ProductCategory;
import tv.news.entities.ProductCategoryMember;
import tv.utils.UnicodeUtils;
import tv.utils.lookup.LocalLookup;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.text.MessageFormat;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/4/2015
 * Time: 2:27 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseNewsBean extends AbstractManagedBean {
    private ICategoryController categoryController;
    protected StoreData storeData;
    String storeId = "0001";
    String prefixTags = "/tags";

    private INewsController newsController;

    public ICategoryController getCategoryController() {
        if (null == categoryController) categoryController = LocalLookup.getCategoryController();
        return categoryController;
    }

    public void setCategoryController(ICategoryController categoryController) {
        this.categoryController = categoryController;
    }

    public INewsController getNewsController() {
        if (null == newsController) newsController = LocalLookup.getNewsController();
        return newsController;
    }

    public void setNewsController(INewsController newsController) {
        this.newsController = newsController;
    }

    public StoreData getStoreData() {
        if (null == storeData) buildData(storeId);
        return storeData;
    }

    public void setStoreData(StoreData storeData) {
        this.storeData = storeData;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getViewId() {
        String viewId = (String) getRequest().getAttribute("viewId");
        while (viewId.endsWith("/")){
            viewId = viewId.substring(0, viewId.length()-1);
        }
        return viewId;
    }

    public String getParameter(String param){
        return (String) getRequest().getParameter("page");
    }

    public String getViewType() {
        return (String) getRequest().getAttribute("viewType");
    }

    public synchronized StoreData buildData(String storeId) {
        StoreData storeData = new StoreData();  // map News by catalog, map News by category, List catalogData
        List<ProductCategory> categoryStoreList = new ArrayList<ProductCategory>();
        List<ProductCategory> categoryList = new ArrayList<ProductCategory>();
        List<ProdCatalog> prodCatalogList = new ArrayList<ProdCatalog>(getCategoryController().getCatalogByStore(storeId));
        CatalogData catalogData;  // catalog info, CategoryData by catalog, News List
        List<NewsData> storeNewsDataList = new ArrayList<NewsData>();
        for (ProdCatalog prodCatalog : prodCatalogList) {
            catalogData = new CatalogData();
            //get category by catalog
            categoryList = getCategoryController().getCategoryByCatalog(prodCatalog.getProdCatalogId());
            CategoryData categoryData; //Category info, isparent, childList, News List
            List<NewsData> catalogNewsDataList = new ArrayList<NewsData>();
            List<Product> productList = new ArrayList<Product>();
            if (categoryList.size() > 0) {
                for (ProductCategory productCategory : categoryList) {
                    categoryData = new CategoryData();
                    productList.clear();
                    //get all child category
                    // get all product
                    productList = getNewsController().getNewsPublicByCategory(productCategory.getProductCategoryId());
                    List<NewsData> newsDataList = new ArrayList<NewsData>();
                    if (productList.size() > 0) {
                        NewsData newsData;    // News info
                        for (Product product : productList) {
                            newsData = new NewsData();
                            newsData.setNews(product);
                            newsData.setPrimaryCategoryName(getCategoryController().getCategory(product.getPrimaryProductCategoryId()).getCategoryName());
                            String url = buildNewsURL(prodCatalog, productCategory, product);
                            newsData.setUrl(url);
                            //set tags
                            List<ProductCategory> tagsIds = getCategoryController().getAllTagByNews(product.getProductId());
                            if(tagsIds != null){
                                List<Tags> tagsList = new ArrayList<Tags>();
                                for (ProductCategory productCatTags: tagsIds){
                                    Tags tags = new Tags();
                                    tags.setTagsId(productCatTags.getProductCategoryId());
                                    tags.setTagsName(productCatTags.getCategoryName());
                                    tags.setTagsLink(prefixTags + buildTagsURL(productCatTags));
                                    tagsList.add(tags);
                                }
                                newsData.setTagsList(tagsList);

                            }
                            newsDataList.add(newsData);
                            catalogNewsDataList.add(newsData);
                            storeData.addNewsToMap(newsData);
                            storeData.addNewsUrlToMap(url, product.getProductId());
                        }
                        categoryData.setNewsList(newsDataList);
                    }
                    categoryData.setCategory(productCategory);
                    categoryData.setCatalog(prodCatalog);
                    catalogData.addCategoryDataToMap(categoryData);
                    storeData.addCategoryToMap(categoryData);
                    storeData.addCatUrlToMap(buildCategoryURL(prodCatalog, productCategory), productCategory.getProductCategoryId());
                }
                catalogData.setNewsList(catalogNewsDataList);
                storeData.addCatUrlToMap(buildCatalogURL(prodCatalog), prodCatalog.getProdCatalogId());
            }
            catalogData.setCategoryMenuList(categoryList);
            categoryStoreList.addAll(categoryList);
            catalogData.setProdCatalog(prodCatalog);
            storeData.addCatalogToMap(catalogData);
        }
        storeData.setProdCatalogList(prodCatalogList);
        storeData.setProductCategoryList(categoryStoreList);
        setStoreData(storeData);
        //build Slide
        List<ProductCategory> productSlideList = getCategoryController().getAllCategoryByStoreAndType(storeId, CategoryType.SLIDE_CATEGORY.getValue());
        if (null != prodCatalogList) {
            CategoryData categorySlideData = new CategoryData();
            ProductCategory productCategory = productSlideList.get(0);
            List<Product> productList = getNewsController().getNewsPublicByCategory(productCategory.getProductCategoryId());
            List<NewsData> newsDataList = new ArrayList<NewsData>();
            if (productList.size() > 0) {
                NewsData newsData;    // News info
                for (Product product : productList) {
                    newsData = new NewsData();
                    ProductCategoryMember pcm = getNewsController().getNewsCategoryMemberByProdIdAndCategory(product.getProductId(), productCategory.getProductCategoryId());
                    int location = 0;
                    if (null != pcm) location = pcm.getSequenceNum();
                    newsData.setLocation(location);
                    CategoryData categoryData = storeData.getCategoryFromMap(product.getPrimaryProductCategoryId());
                    String url = buildNewsURL(categoryData.getCatalog(), categoryData.getCategory(), product);
                    newsData.setUrl(url);
                    newsData.setNews(product);
                    newsData.setProductAttributes(getNewsController().getProductAttByProductIdAndName(product.getProductId(), "_NEWS_IMAGE"));
                    newsData.setPrimaryCategoryName(getCategoryController().getCategory(product.getPrimaryProductCategoryId()).getCategoryName());
                    newsDataList.add(newsData);
                }
                categorySlideData.setNewsList(newsDataList);
            }
            categorySlideData.setCategory(productSlideList.get(0));
            storeData.setMainSlide(categorySlideData);

        }
        //build tags
        List<ProductCategory> productTagsList = getCategoryController().getAllCategoryByStoreAndType(storeId, CategoryType.TAGS_CATEGORY.getValue());
        if (null != productTagsList) {
            List<Product> productList = new ArrayList<Product>();
            for (ProductCategory productCategory : productTagsList) {
                CategoryData categoryData = new CategoryData();
                List<NewsData> newsDataList = new ArrayList<NewsData>();
                productList.clear();
                productList = getNewsController().getNewsPublicByCategory(productCategory.getProductCategoryId());
                if (productList.size() > 0) {
                    NewsData newsData;// News info
                    for (Product product : productList) {
                        newsData = storeData.getNewsFromMap(product.getProductId());
                        newsDataList.add(newsData);
                    }
                    categoryData.setNewsList(newsDataList);
                }
                String tagsUrl = prefixTags + buildTagsURL(productCategory);
                storeData.addCatUrlToMap(tagsUrl, productCategory.getProductCategoryId());
                categoryData.setCategory(productCategory);
                storeData.addCategoryToMap(categoryData);
            }
        }

        return storeData;
    }


//    public synchronized StoreData buildDataFromCache(String storeId) {
//        StoreData storeDataNew = CacheDataController.getInstance().getStoreData(storeId);
//        return storeDataNew;
//    }


    MessageFormat urlFormat = new MessageFormat("/{0}");
    MessageFormat urlCatFormat = new MessageFormat("/{0}/{1}");
    MessageFormat urlNewFormat = new MessageFormat("/{0}/{1}/{2}-{3}");


    public String buildCatalogURL(ProdCatalog catalog) {
        String noSignUrl = UnicodeUtils.unicode2NoSign(convertUnicode(catalog.getCatalogName()).toLowerCase().trim()).replaceAll("[\\W]+", "-").replaceAll("-+$", "");
        return urlFormat.format(new Object[]{noSignUrl});
    }

    public String buildCategoryURL(ProdCatalog catalog, ProductCategory category) {
        String cataUrl = UnicodeUtils.unicode2NoSign(convertUnicode(catalog.getCatalogName().toLowerCase().trim())).replaceAll("[\\W]+", "-").replaceAll("-+$", "");
        String cateUrl = UnicodeUtils.unicode2NoSign(convertUnicode(category.getCategoryName().toLowerCase().trim())).replaceAll("[\\W]+", "-").replaceAll("-+$", "");
        return urlCatFormat.format(new Object[]{cataUrl, cateUrl});
    }

    public String buildNewsURL(ProdCatalog catalog, ProductCategory category, Product news) {
        String cataUrl = UnicodeUtils.unicode2NoSign(convertUnicode(catalog.getCatalogName().toLowerCase().trim())).replaceAll("[\\W]+", "-").replaceAll("-+$", "");
        String cateUrl = UnicodeUtils.unicode2NoSign(convertUnicode(category.getCategoryName().toLowerCase().trim())).replaceAll("[\\W]+", "-").replaceAll("-+$", "");
        String newsUrl = UnicodeUtils.unicode2NoSign(convertUnicode(news.getProductName()).toLowerCase().trim()).replaceAll("[\\W]+", "-").replaceAll("-+$", "");
        return urlNewFormat.format(new Object[]{ cataUrl, cateUrl, newsUrl, news.getProductId() + ".html"});
    }

    public String buildTagsURL(ProductCategory category) {
        String noSignUrl = UnicodeUtils.unicode2NoSign(convertUnicode(category.getCategoryName()).toLowerCase().trim()).replaceAll("[\\W]+", "-").replaceAll("-+$", "");
        return urlFormat.format(new Object[]{noSignUrl});
    }

    public String convertUnicode(String original) {
        String tmp = Normalizer.normalize(original, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(tmp).replaceAll("");
    }
    public void addMessagesInfo(String componentId, String messages) {
        FacesContext.getCurrentInstance().addMessage(componentId, new FacesMessage(FacesMessage.SEVERITY_INFO, messages, null));
    }
}
