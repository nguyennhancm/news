package portal.news.bean;

import portal.utils.BasePortalBean;

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
@ManagedBean(name = "CreateCategoryBean")
public class CreateCategoryBean extends BasePortalBean {
    private String storeId;
    private String catalogId;
    private String categoryName;
    @ManagedProperty(value = "#{NewsManager}")
    private NewsManagerBean newsManagerBean;
    @ManagedProperty(value = "#{Category}")
    private CategoryBean categoryBean;

    public void setCategoryBean(CategoryBean categoryBean) {
        this.categoryBean = categoryBean;
    }

    public void setNewsManagerBean(NewsManagerBean newsManagerBean) {
        this.newsManagerBean = newsManagerBean;
    }

    public void addNewCategory() {
        if (null != getStoreId() && null != getCategoryName()) {
            boolean newCatalog = true;
            if (getCatalogId().trim().length() > 0) {
                newCatalog = false;
            }
            getCategoryController().addNewCategory(getStoreId(), getCatalogId(), getCategoryName(), newCatalog);
            categoryName = null;
            categoryBean.resetAllCategory();
        }
    }

    public void addNewCategoryPosition() {
        if (null != getStoreId() && null != getCategoryName()) {
            getCategoryController().addNewCategoryPosition(getStoreId(), getCatalogId(), getCategoryName(), true, "CATEGORY_POSITION");
            categoryName = null;
            categoryBean.resetAllCategory();
        }
    }


    @Override
    public String getClassName() {
        return getClass().getName();
    }

    public String getStoreId() {
        return newsManagerBean.getUserData().getCurrentStore();
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }
}
