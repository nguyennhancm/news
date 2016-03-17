package portal.video;

import tv.news.enums.CategoryType;
import tv.news.model.NewsData;
import org.apache.commons.validator.GenericValidator;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import portal.news.bean.NewsManagerBean;
import portal.utils.BasePortalBean;
import portal.utils.UnicodeUtils;
import tv.news.entities.Product;
import tv.news.entities.ProductAttribute;
import tv.news.entities.ProductCategory;
import tv.news.entities.ProductCategoryMember;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/10/2015
 * Time: 2:05 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@SessionScoped
@ManagedBean(name = "CreateVideo")
public class CreateVideoBean extends BasePortalBean {
    private NewsData newsData;
    private List<ProductAttribute> imagesList;
    private String[] tagsList;
    private int sequenceImage = 0;
    private String allTags;
    private String tags="";

    @ManagedProperty(value = "#{NewsManager}")
    private NewsManagerBean newsManagerBean;

    public String createVideo() {
        if (validateNews(newsData.getNews().getPrimaryProductCategoryId(), newsData.getNews().getProductName(),
                newsData.getNews().getDescription(), newsData.getNews().getLongDescription(), "NEWS")) {
            Product product = newsData.getNews();
            if (newsData.isActive()) product.setIsActive("Y");
            else product.setIsActive("N");
            String imageDefault = getImageDefault(product.getLongDescription());
            if (imageDefault.length() > 4) product.setMediumImageUrl(imageDefault);
            try {
                newsManagerBean.getNewsController().createNews(product, newsManagerBean.getUserData().getCurrentStore(), "NEWS", getImagesList());
                //add tags
                if(null != getTagsList()){

                    for (String tags: tagsList){
                        String tagsId = newsManagerBean.getStoreData().getTagsFromMap(tags);
                        if (null != tagsId){
                            // save news tags
                            ProductCategoryMember productTags = new ProductCategoryMember();
                            productTags.setProductId(product.getProductId());
                            productTags.setProductCategoryId(tagsId);
                            productTags.setFromDate(new Timestamp(new Date().getTime()));
                            productTags.setCreatedStamp(new Timestamp(new Date().getTime()));
                            getCategoryController().createProductCategoryMember(productTags);
                        }else {
                            // create tags
                            ProductCategory productCategory= new ProductCategory();
                            productCategory.setProductCategoryId(getSequenceValue().getSequenceValueItem(ProductCategory.class));
                            productCategory.setCategoryName(tags);
                            productCategory.setProductCategoryTypeId(CategoryType.TAGS_CATEGORY.getValue());
                            productCategory.setDescription(newsManagerBean.getUserData().getCurrentStore());
                            productCategory.setCreatedStamp(new Timestamp(new Date().getTime()));
                            getCategoryController().createCategory(productCategory);
                            //save news tags
                            ProductCategoryMember productTags = new ProductCategoryMember();
                            productTags.setProductId(product.getProductId());
                            productTags.setProductCategoryId(productCategory.getProductCategoryId());
                            productTags.setFromDate(new Timestamp(new Date().getTime()));
                            productTags.setCreatedStamp(new Timestamp(new Date().getTime()));
                            getCategoryController().createProductCategoryMember(productTags);
                        }
                    }
                    tags="";
                }
                newsData = new NewsData();
                imagesList = new ArrayList<ProductAttribute>();
                sequenceImage = 0;
                newsManagerBean.reloadStore();
                newsManagerBean.loadAllNewsData();
                allTags = buildAllTags();
            } catch (Exception e){
                addValidateError(null, "có lỗi khi tạo bài viết, vui lòng liên hệ system admin!");
                getLogger().log(Level.WARNING,"error create news: " + e.getMessage());
                return "";
            }

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

    public String genNewsId() {
        String newsId = getSequenceValue().getSequenceValueItem(Product.class);
        getNewsData().getNews().setProductId(newsId);
        return newsId;
    }

    public String removeImage(ProductAttribute image){
        for (ProductAttribute ima: imagesList){
            if (ima.getAttrName().equals(image.getAttrName())){
                imagesList.remove(ima);
                return "";
            }
        }
        return "";
    }

    public boolean validateImage(UploadedFile file) {
        if (file == null || file.getContentType().indexOf("image") < 0) {
            addMessagesInfo(null, "Cập nhật hình ảnh: tập tin" + file.getFileName() + " không hợp lệ");
            return false;
        }
        return true;
    }

    public synchronized void handleFileUpload(FileUploadEvent event) {
        handleFileUpload(event, false);

    }

    public void handleFileUpload(FileUploadEvent event, boolean uploadToPublicServer) {

        UploadedFile file = event.getFile();
        String fileName = "";
        String prefix = "";
        try {
            byte[] readData = new byte[1024];
            InputStream inputStream = null;
            inputStream = file.getInputstream();
            if (file.getFileName() != null) {
                fileName = file.getFileName().trim();
                if (fileName.indexOf("\\") >= 0) {
                    String[] fileNames = fileName.split("\\\\");
                    fileName = fileNames[fileNames.length - 1];
                }

                String name = "";
                if (fileName.indexOf(".") > 0) {
                    String temp[] = fileName.split("\\.");
                    prefix = temp[temp.length - 1];
                    for (int i = 0; i < temp.length - 1; i++) {
                        name += temp[i];
                    }
                }
                fileName = UnicodeUtils.unicode2Nosign(name);
                fileName = UnicodeUtils.removeSpecialCharacter(fileName);

            }
            do {
                fileName = fileName.replaceAll(" ", "");
            } while (fileName.contains(" "));
            String newsId = getNewsData().getNews().getProductId();
            if (null == newsId) newsId = genNewsId();
            java.io.File outFile = new java.io.File(getImageRootPath() + "/" + newsId + "/" + fileName + "." + prefix);
            if (outFile.exists()) {
                fileName = fileName + "_" + new Timestamp(new Date().getTime()).toString().replace(":", "-").replace(" ", "_");
                outFile = new java.io.File(getImageRootPath() + "/" + newsId + "/" + fileName + "." + prefix);
            }
            outFile.getParentFile().mkdirs();
            OutputStream outputStream = new FileOutputStream(outFile);
            int i = inputStream.read(readData);
            while (i != -1) {
                outputStream.write(readData, 0, i);
                i = inputStream.read(readData);
            }
            inputStream.close();
            outputStream.close();
            ///////////////////////
            ProductAttribute imageAttribute = new ProductAttribute();
            imageAttribute.setProductId(getNewsData().getNews().getProductId());
            imageAttribute.setAttrName(String.valueOf(++sequenceImage) + "_NEWS_IMAGE");
            imageAttribute.setAttrValue(fileName + "." + prefix);
            getImagesList().add(imageAttribute);

        } catch (Exception e) {
            getLogger().warning(e.getMessage());
        }
    }

    public void ajax(){
        System.out.println("test");
    }

    public String getImageRootPath() {
        return System.getProperty("news.upload.images.original");
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

    public List<ProductAttribute> getImagesList() {
        if (null == imagesList) imagesList = new ArrayList<ProductAttribute>();
        return imagesList;
    }

    public String[] getTagsList() {
        if (!GenericValidator.isBlankOrNull(tags)){
            tagsList = tags.split(",");
        }
        return tagsList;
    }

    public void setTagsList(String[] tagsList) {
        this.tagsList = tagsList;
    }

    public String buildAllTags(){
        List<String> tagsList = new ArrayList<String>(newsManagerBean.getStoreData().getAllTags());
        String tagsNames = "";
        if (null != tagsList) {
            for (String tags : tagsList) {
                tagsNames+="'"+tags+"',";
            }

        }
        return tagsNames;
    }

    public String getAllTags() {
        if (null == allTags)allTags = buildAllTags();
        return allTags;
    }

    public void setAllTags(String allTags) {
        this.allTags = allTags;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }



    public void setImagesList(List<ProductAttribute> imagesList) {
        this.imagesList = imagesList;
    }

    @Override
    public String getClassName() {
        return getClass().getName();
    }
}
