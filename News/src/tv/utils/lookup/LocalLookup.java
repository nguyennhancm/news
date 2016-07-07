package tv.utils.lookup;

import tv.news.controller.ICategoryController;
import tv.news.controller.INewsController;
import tv.news.manager.ICategoryManager;
import tv.news.manager.INewsManager;
import tv.system.manager.IProductStoreManager;
import tv.system.manager.IWebSiteManager;
import tv.user.controller.IUserController;
import tv.user.manager.IUserManager;
import tv.utils.valueItem.manager.ISequenceValue;

import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/4/2015
 * Time: 8:46 AM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
public class LocalLookup {
    private static String prefix = "java:global/NewsCore/";

    public static Object getBean(String jndiName) {
        try {
            return new InitialContext().lookup(prefix + jndiName);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }


    public static ICategoryManager getCategoryManager() {
        return (ICategoryManager) getBean("News/CategoryManager");
    }

    public static INewsManager getNewsManager() {
        return (INewsManager) getBean("News/NewsManager");
    }

    public static ICategoryController getCategoryController() {
        return (ICategoryController) getBean("News/CategoryController");
    }

    public static INewsController getNewsController() {
        return (INewsController) getBean("News/NewsController");
    }

    public static ISequenceValue getSequenceValue() {
        return (ISequenceValue) getBean("News/SequenceValue");
    }

    public static IUserManager getUserManager() {
        return (IUserManager) getBean("News/UserManager");
    }

    public static IUserController getUserController() {
        return (IUserController) getBean("News/UserController");
    }

    public static IProductStoreManager getProductStoreManager(){
        return (IProductStoreManager) getBean("News/ProductStoreManager");
    }

    public static IWebSiteManager getWebSiteManager(){
        return (IWebSiteManager) getBean("News/WebSiteManager");
    }
}
