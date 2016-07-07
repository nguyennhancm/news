package portal.utils;


import tv.news.enums.CategoryType;
import tv.news.manager.ICategoryManager;
import tv.news.model.*;
import org.apache.commons.validator.GenericValidator;
import tv.news.controller.ICategoryController;
import tv.news.controller.INewsController;
import tv.news.entities.ProdCatalog;
import tv.news.entities.Product;
import tv.news.entities.ProductCategory;
import tv.news.entities.ProductCategoryMember;
import tv.system.manager.IProductStoreManager;
import tv.system.manager.IWebSiteManager;
import tv.user.controller.IUserController;
import tv.utils.lookup.LocalLookup;
import tv.utils.valueItem.manager.ISequenceValue;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/5/2015
 * Time: 4:25 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
public abstract class BasePortalBean {
    //    private String storeId;
    protected static String IMAGE_DEFAULT = "/upload/images/default_image.jpg";
    private Logger logger = null;

    protected ICategoryController categoryController;
    protected INewsController newsController;
    protected IUserController userController;
    protected ISequenceValue sequenceValue;
    protected IProductStoreManager productStoreManager;
    protected IWebSiteManager webSiteManager;
    protected ICategoryManager categoryManager;
    protected HashMap<String, StoreData> storeDataHashMap = new HashMap<String, StoreData>();

    public ICategoryManager getCategoryManager() {
        if (null == categoryManager) categoryManager = LocalLookup.getCategoryManager();
        return categoryManager;
    }

    public IWebSiteManager getWebSiteManager() {
        if (null == webSiteManager) webSiteManager = LocalLookup.getWebSiteManager();
        return webSiteManager;
    }

    public IProductStoreManager getProductStoreManager() {
        if (null == productStoreManager) productStoreManager = LocalLookup.getProductStoreManager();
        return productStoreManager;
    }

    public IUserController getUserController() {
        if (null == userController) userController = LocalLookup.getUserController();
        return userController;
    }

    public ICategoryController getCategoryController() {
        if (null == categoryController) categoryController = LocalLookup.getCategoryController();
        return categoryController;
    }

    public ISequenceValue getSequenceValue() {
        if (null == sequenceValue) sequenceValue = LocalLookup.getSequenceValue();
        return sequenceValue;
    }

    public INewsController getNewsController() {
        if (null == newsController) newsController = LocalLookup.getNewsController();
        return newsController;
    }

    public void setNewsController(INewsController newsController) {
        this.newsController = newsController;
    }

    public StoreData getStoreDataInCache(String storeId){
        StoreData storeData = storeDataHashMap.get(storeId);
        if (null == storeData) storeData = buildData(storeId);
        return storeData;
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
                        productList = getNewsController().getNewsByCategory(productCategory.getProductCategoryId());
                        List<NewsData> newsDataList = new ArrayList<NewsData>();
                        if (productList.size() > 0) {
                            NewsData newsData;    // News info
                            for (Product product : productList) {
                                newsData = new NewsData();
                                newsData.setNews(product);
                                newsData.setProductAttributes(getNewsController().getProductAttByProductIdAndName(product.getProductId(), "_NEWS_IMAGE"));
                                if (product.getIsActive().equals("Y")) newsData.setActive(true);
                                newsData.setPrimaryCategoryName(getCategoryController().getCategory(product.getPrimaryProductCategoryId()).getCategoryName());
                                //set tags
                                List<ProductCategory> tagsIds = getCategoryController().getAllTagByNews(product.getProductId());
                                if (tagsIds != null) {
                                    List<Tags> tagsList = new ArrayList<Tags>();
                                    for (ProductCategory productCatTags : tagsIds) {
                                        Tags tags = new Tags();
                                        tags.setTagsName(productCatTags.getCategoryName());
                                        tagsList.add(tags);
                                    }
                                    newsData.setTagsList(tagsList);

                                }
                                newsDataList.add(newsData);
                                catalogNewsDataList.add(newsData);
                                storeData.addNewsToMap(newsData);
                            }
                            categoryData.setNewsList(newsDataList);
                        }
                        categoryData.setCategory(productCategory);
                        catalogData.addCategoryDataToMap(categoryData);
                        storeData.addCategoryToMap(categoryData);
                    }
                    catalogData.setNewsList(catalogNewsDataList);
                }
                catalogData.setCategoryMenuList(categoryList);
                categoryStoreList.addAll(categoryList);
                catalogData.setProdCatalog(prodCatalog);
                storeData.addCatalogToMap(catalogData);
            }
            storeData.setProdCatalogList(prodCatalogList);
            storeData.setProductCategoryList(categoryStoreList);
            //getAllTags
            List<ProductCategory> productTagsList = getCategoryController().getAllCategoryByStoreAndType(storeId, CategoryType.TAGS_CATEGORY.getValue());
            if (null != productTagsList) {
                for (ProductCategory productCategory : productTagsList) {
                    storeData.addTagsToMap(productCategory.getCategoryName(), productCategory.getProductCategoryId());
                }
            }
            //Load Slide
            List<ProductCategory> productSlideList = getCategoryController().getAllCategoryByStoreAndType(storeId, CategoryType.SLIDE_CATEGORY.getValue());
            if (null != prodCatalogList) {
                CategoryData categorySlideData = new CategoryData();
                ProductCategory productCategory = productSlideList.get(0);
                List<Product> productList = getNewsController().getNewsByCategory(productCategory.getProductCategoryId());
                List<NewsData> newsDataList = new ArrayList<NewsData>();
                if (productList.size() > 0) {
                    NewsData newsData;    // News info
                    for (Product product : productList) {
                        newsData = new NewsData();
                        ProductCategoryMember pcm = getNewsController().getNewsCategoryMemberByProdIdAndCategory(product.getProductId(), productCategory.getProductCategoryId());
                        int location = 0;
                        if (null != pcm) location = pcm.getSequenceNum();
                        newsData.setLocation(location);
                        newsData.setNews(product);
                        newsData.setProductAttributes(getNewsController().getProductAttByProductIdAndName(product.getProductId(), "_NEWS_IMAGE"));
                        if (product.getIsActive().equals("Y")) newsData.setActive(true);
                        newsData.setPrimaryCategoryName(getCategoryController().getCategory(product.getPrimaryProductCategoryId()).getCategoryName());
                        //                    newsData.setTagsList(getCategoryController().getAllTagByNews(product.getProductId()));
                        newsDataList.add(newsData);
                    }
                    categorySlideData.setNewsList(newsDataList);
                }
                categorySlideData.setCategory(productCategory);
                storeData.setMainSlide(categorySlideData);

            }
            //Load Video
            //get category video
            List<ProductCategory> videoCategoryList = new ArrayList<ProductCategory>();
            List<ProductCategory> productCategoryList = getCategoryManager().getAllCategoryByStoreAndType(
                    storeId, CategoryType.VIDEO_CATEGORY.name());
            if (null != productCategoryList){
                for (ProductCategory productCategory: productCategoryList) {
                    videoCategoryList.addAll(getCategoryManager().getCategoryByParent(productCategory.getProductCategoryId()));
                }
            }
            CategoryData categoryVideoData; //Category info, isparent, childList, News List
            List<Product> productList = new ArrayList<Product>();
            if (null != videoCategoryList && videoCategoryList.size() > 0) {
                for (ProductCategory productCategory : videoCategoryList) {
                    categoryVideoData = new CategoryData();
                    productList.clear();
                    //get all child category
                    // get all product
                    productList = getNewsController().getNewsByCategory(productCategory.getProductCategoryId());
                    List<NewsData> newsDataList = new ArrayList<NewsData>();
                    if (productList.size() > 0) {
                        NewsData newsData;    // News info
                        for (Product product : productList) {
                            newsData = new NewsData();
                            newsData.setNews(product);
                            newsData.setProductAttributes(getNewsController().getProductAttByProductIdAndName(product.getProductId(), "_NEWS_IMAGE"));
                            if (product.getIsActive().equals("Y")) newsData.setActive(true);
                            newsData.setPrimaryCategoryName(getCategoryController().getCategory(product.getPrimaryProductCategoryId()).getCategoryName());
                            //set tags
                            List<ProductCategory> tagsIds = getCategoryController().getAllTagByNews(product.getProductId());
                            if (tagsIds != null) {
                                List<Tags> tagsList = new ArrayList<Tags>();
                                for (ProductCategory productCatTags : tagsIds) {
                                    Tags tags = new Tags();
                                    tags.setTagsName(productCatTags.getCategoryName());
                                    tagsList.add(tags);
                                }
                                newsData.setTagsList(tagsList);

                            }
                            newsDataList.add(newsData);
                            storeData.addVideoToMap(newsData);
                        }
                        categoryVideoData.setNewsList(newsDataList);
                    }
                    categoryVideoData.setCategory(productCategory);
                    storeData.addCategoryToMap(categoryVideoData);
                }

            // Load Album
            storeDataHashMap.put(storeId, storeData);}
//        CacheDataController cacheDataController = CacheDataController.getInstance();
//        cacheDataController.updateCacheStore(storeId, storeData);
        return storeData;
    }

    public int getMaxlocation(List<NewsData> newsDatas) {
        int max = 0;
        for (NewsData n : newsDatas) {
            if (max <= n.getLocation()) max = n.getLocation() + 1;
        }
        return max;
    }

    public String getImageDefault(String description) {
        String imageDefault = "";
        if (description.contains("<img class=\"img-responsive\" src=\"")) {
            imageDefault = description.split("<img class=\"img-responsive\" src=\"", 2)[1].split("\" />", 2)[0];
        } else if (description.contains("<img src=\"")) {
            imageDefault = description.split("<img src=\"", 2)[1].split("\" />", 2)[0];
        } else {
            //add images default  /images/default_image.jpg
            imageDefault = IMAGE_DEFAULT;
        }
        return imageDefault;
    }

    public void addMessagesInfo(String componentId, String messages) {
        FacesContext.getCurrentInstance().addMessage(componentId, new FacesMessage(FacesMessage.SEVERITY_INFO, messages, null));
    }

    public void addValidateError(String componentId, String validatorMessage) {
        FacesContext.getCurrentInstance().addMessage(componentId, new FacesMessage(FacesMessage.SEVERITY_ERROR, validatorMessage, null));
    }

    public boolean validateNews(String category, String title, String description, String content, String type) {
        boolean validate = true;
        // category
        if (type.equals("NEWS")) {
            if (GenericValidator.isBlankOrNull(category)) {
                validate = false;
                addValidateError("", "Vui lòng chọn Chuyên mục!");
            }
            // title
            if (GenericValidator.isBlankOrNull(title)) {
                validate = false;
                addValidateError("", "Vui lòng nhâp tiêu đề!");
            } else if (title.length() > 200) {
                validate = false;
                addValidateError("", "Tiêu đề không quá 200 ký tự!");
            }
            // description
            if (GenericValidator.isBlankOrNull(description)) {
                validate = false;
                addValidateError("", "Vui lòng nhâp mô tả ngắn!");
            } else if (description.length() > 700) {
                validate = false;
                addValidateError("", "Mô tả ngắn không quá 700 ký tự!");
            }
            // content
//            if (GenericValidator.isBlankOrNull(content)) {
//                validate = false;
//                addValidateError("", "Vui lòng nhâp nội dung!");
//            } else if (content.length() > 500000) {
//                validate = false;
//                addValidateError("", "Nội dung không quá 50000 ký tự!");
//            }
        } else if (type.equals("MEDIA")) {
            if (category.isEmpty() || category.equals("")) {
                validate = false;
                addValidateError("", "Vui lòng chọn Chuyên mục!");
            }
            // title
            if (GenericValidator.isBlankOrNull(title)) {
                validate = false;
                addValidateError("", "Vui lòng nhâp Tên Phim!");
            } else if (title.length() > 200) {
                validate = false;
                addValidateError("", "Tên Phim không quá 200 ký tự!");
            }
        }
        return validate;
    }

    public boolean validateVideo(String category, String title, String description, String content) {
        boolean validate = true;
        // category

        if (GenericValidator.isBlankOrNull(category)) {
            validate = false;
            addValidateError("", "Vui lòng chọn Chuyên mục!");
        }
        // title
        if (GenericValidator.isBlankOrNull(title)) {
            validate = false;
            addValidateError("", "Vui lòng nhâp tiêu đề!");
        } else if (title.length() > 200) {
            validate = false;
            addValidateError("", "Tiêu đề không quá 200 ký tự!");
        }
        // description
        if (description.length() > 700) {
            validate = false;
            addValidateError("", "Mô tả ngắn không quá 700 ký tự!");
        }
        // content
        if (GenericValidator.isBlankOrNull(content)) {
            validate = false;
            addValidateError("", "Vui lòng nhâp nội dung!");
        } else if (content.length() > 500000) {
            validate = false;
            addValidateError("", "Nội dung không quá 50000 ký tự!");
        }
        return validate;
    }

    public abstract String getClassName();

    public Logger getLogger() {
        if (null == logger) {
            logger = Logger.getLogger(getClassName());
        }
        return logger;
    }

//    public String getStoreId() {
//        return storeId;
//    }
//
//    public void setStoreId(String storeId) {
//        this.storeId = storeId;
//    }
}
