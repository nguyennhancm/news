package portal.news.bean;

import org.primefaces.event.TreeDragDropEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import tv.news.entities.ProdCatalog;
import tv.news.entities.ProductCategory;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 4/4/2016
 * Time: 1:35 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@SessionScoped
@ManagedBean(name = "ManageCategory")
public class ManageCategoryBean {
    private TreeNode root1;

    private TreeNode selectedNode1 = null;
    @ManagedProperty(value = "#{NewsManager}")
    private NewsManagerBean newsManagerBean;

    @PostConstruct
    public void init() {
        root1 = new DefaultTreeNode("Root", null);
        for (ProdCatalog catalog : newsManagerBean.getStoreData().getProdCatalogList()) {
//            if (null == catalog) continue;
//            SelectItem item = new SelectItem(catalog.getProdCatalogId(), catalog.getCatalogName());
//            item.setDisabled(true);
//            categoryItems.add(item);
            TreeNode catalogNode = null;
//            if (newsManagerBean.getStoreData().getCatalogFromMap(catalog.getProdCatalogId()).getCategoryMenuList().size() > 0) {
            SelectItem item = new SelectItem(catalog.getProdCatalogId(), catalog.getCatalogName(), "catalog");
            catalogNode = new DefaultTreeNode(item, root1);
                catalogNode.setExpanded(true);
//            }
            for (ProductCategory mainCategory : newsManagerBean.getStoreData().getCatalogFromMap(catalog.getProdCatalogId()).getCategoryMenuList()) {
//                SelectItem mainCategoryItem = new SelectItem(mainCategory.getProductCategoryId(),
//                        messageFormat.format(new Object[]{getReplateString('-', 4), mainCategory.getCategoryName()}));
//                mainCategoryItem.setDisabled(false);
//                categoryItems.add(mainCategoryItem);
                SelectItem itemCategory = new SelectItem(mainCategory.getProductCategoryId(), mainCategory.getCategoryName(), "category");
                TreeNode mainCategoryNode = new DefaultTreeNode(itemCategory, catalogNode);
                mainCategoryNode.setExpanded(true);

            }
        }
//        TreeNode node0 = new DefaultTreeNode("Node 0", root1);
//        TreeNode node1 = new DefaultTreeNode("Node 1", root1);
//        TreeNode node2 = new DefaultTreeNode("Node 2", root1);
//
//        TreeNode node00 = new DefaultTreeNode("Node 0.0", node0);
//        TreeNode node01 = new DefaultTreeNode("Node 0.1", node0);
//
//        TreeNode node10 = new DefaultTreeNode("Node 1.0", node1);
//        TreeNode node11 = new DefaultTreeNode("Node 1.1", node1);
//
//        TreeNode node000 = new DefaultTreeNode("Node 0.0.0", node00);
//        TreeNode node001 = new DefaultTreeNode("Node 0.0.1", node00);
//        TreeNode node010 = new DefaultTreeNode("Node 0.1.0", node01);
//
//        TreeNode node100 = new DefaultTreeNode("Node 1.0.0", node10);

    }

    public TreeNode getRoot1() {
        return root1;
    }

    public TreeNode getSelectedNode1() {
        return selectedNode1;
    }

    public void setSelectedNode1(TreeNode selectedNode1) {
        this.selectedNode1 = selectedNode1;
    }

    public NewsManagerBean getNewsManagerBean() {
        return newsManagerBean;
    }

    public void setNewsManagerBean(NewsManagerBean newsManagerBean) {
        this.newsManagerBean = newsManagerBean;
    }

    public void onNodeSelect(){

    }

    public void onNodeUnselect(){

    }

    public void onDragDrop(TreeDragDropEvent event) {
        TreeNode dragNode = event.getDragNode();
        TreeNode dropNode = event.getDropNode();
        int dropIndex = event.getDropIndex();

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dragged " + dragNode.getData(), "Dropped on " + dropNode.getData() + " at " + dropIndex);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
