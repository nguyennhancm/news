package portal.news.bean;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import portal.utils.BasePortalBean;
import tv.news.entities.ProdCatalog;
import tv.news.entities.ProductCategory;
import tv.news.enums.CategoryType;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/8/2015
 * Time: 5:52 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@SessionScoped
@ManagedBean(name = "Category")
public class CategoryBean extends BasePortalBean {

    private List<SelectItem> categoryItems = new ArrayList<SelectItem>();
    private List<SelectItem> catalogItems = new ArrayList<SelectItem>();
    private List<ProductCategory> categoryTree = new ArrayList<ProductCategory>();
    private TreeNode categoryNode;
    private MessageFormat messageFormat = new MessageFormat("{0}   {1}");
    public List<ProductCategory> categories;
    private List<ProdCatalog> catalogs;
    private String tags;
    private List<ProductCategory> videoCategory;


    @ManagedProperty(value = "#{NewsManager}")
    private NewsManagerBean newsManagerBean;

    public String getReplateString(char value, int number) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < number; i++) {
            buffer.append(value);

        }
        return buffer.toString();
    }

    public List<SelectItem> getAllCatalog() {
        if (null == catalogItems || catalogItems.size() == 0) {
            buildCatalog();
        }
        return catalogItems;
    }

    public List<SelectItem> getAllCategory() {
        if (null == categoryItems || categoryItems.size() == 0) {
            buildCategory();
        }
        return categoryItems;
    }

    public List<ProductCategory> getCategoryTree() {
        if (null == categoryTree || categoryTree.size() == 0) {
            buildCategory();
        }
        return categoryTree;
    }

    public void buildCategory() {
        categoryItems = new ArrayList<SelectItem>();
        categoryTree = new ArrayList<ProductCategory>();
        categoryNode = new DefaultTreeNode("root", null);
        for (ProdCatalog catalog : newsManagerBean.getStoreData().getProdCatalogList()) {
            if (null == catalog) continue;
            SelectItem item = new SelectItem(catalog.getProdCatalogId(), catalog.getCatalogName());
            item.setDisabled(true);
            categoryItems.add(item);
            TreeNode catalogNode = null;
            if (newsManagerBean.getStoreData().getCatalogFromMap(catalog.getProdCatalogId()).getCategoryMenuList().size() > 0) {
                catalogNode = new DefaultTreeNode(catalog);
                catalogNode.setExpanded(true);
            }
            for (ProductCategory mainCategory : newsManagerBean.getStoreData().getCatalogFromMap(catalog.getProdCatalogId()).getCategoryMenuList()) {
                SelectItem mainCategoryItem = new SelectItem(mainCategory.getProductCategoryId(),
                        messageFormat.format(new Object[]{getReplateString('-', 4), mainCategory.getCategoryName()}));
                mainCategoryItem.setDisabled(false);
                categoryItems.add(mainCategoryItem);
                TreeNode mainCategoryNode = new DefaultTreeNode(mainCategory);
                mainCategoryNode.setExpanded(true);

            }
        }
    }

    public void buildCatalog() {
        catalogItems = new ArrayList<SelectItem>();
        for (ProdCatalog c : newsManagerBean.getStoreData().getProdCatalogList()) {
            if (null == c) continue;
            SelectItem item = new SelectItem(c.getProdCatalogId(), c.getCatalogName());
            catalogItems.add(item);
        }
    }

    public ProductCategory getCategory(String id) {
        return getCategoryController().getCategory(id);
    }

    public void resetAllCategory() {
        categoryItems = new ArrayList<SelectItem>();
        categoryNode = null;
        categoryTree = null;
        categories = null;
        catalogs = null;
        catalogItems = new ArrayList<SelectItem>();
    }

    public List<ProductCategory> getCategories() {
        if (null == categories) {
            categories = newsManagerBean.getStoreData().getProductCategoryList();
        }
        return categories;
    }

    public List<ProdCatalog> getCatalogs() {
        if (null == catalogs) {
            catalogs = newsManagerBean.getStoreData().getProdCatalogList();
        }
        return catalogs;
    }

    public TreeNode getCategoryNode() {
        if (null == categoryNode) buildCategory();
        return categoryNode;
    }

    public NewsManagerBean getNewsManagerBean() {
        return newsManagerBean;
    }

    public void setNewsManagerBean(NewsManagerBean newsManagerBean) {
        this.newsManagerBean = newsManagerBean;
    }

    public String getTags() {
        tags = "'Du lịch cần thơ', 'java', 'php', 'coldfusion', 'javascript', 'asp', 'ruby', 'python', 'c', 'scala', 'groovy', 'haskell', 'perl', 'erlang', 'apl', 'cobol', 'go', 'lua',";
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public List<ProductCategory> getVideoCategory() {
        if (null == videoCategory) {
            videoCategory = new ArrayList<ProductCategory>();
            List<ProductCategory> productCategoryList = getCategoryManager().getAllCategoryByStoreAndType(
                    getNewsManagerBean().getUserData().getCurrentStore(), CategoryType.VIDEO_CATEGORY.name());
            if (null != productCategoryList){
                for (ProductCategory productCategory: productCategoryList) {
                    videoCategory.addAll(getCategoryManager().getCategoryByParent(productCategory.getProductCategoryId()));
                }
            }
        }
        return videoCategory;
    }

    public void setVideoCategory(List<ProductCategory> videoCategory) {
        this.videoCategory = videoCategory;
    }

    @Override
    public String getClassName() {
        return getClass().getName();
    }
}
