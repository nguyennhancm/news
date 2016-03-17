package tv.utils.controller;

import tv.news.manager.ICategoryManager;
import tv.news.manager.INewsManager;
import tv.user.manager.IUserManager;
import tv.utils.lookup.LocalLookup;
import tv.utils.valueItem.manager.ISequenceValue;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/4/2015
 * Time: 9:37 AM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseController {
    ICategoryManager categoryManager;
    INewsManager newsManager;
    ISequenceValue sequenceValue;
    IUserManager userManager;

    public ICategoryManager getCategoryManager() {
        if (null == categoryManager) categoryManager = LocalLookup.getCategoryManager();
        return categoryManager;
    }

    public void setCategoryManager(ICategoryManager categoryManager) {
        this.categoryManager = categoryManager;
    }

    public INewsManager getNewsManager() {
        if (null == newsManager) newsManager = LocalLookup.getNewsManager();
        return newsManager;
    }

    public void setNewsManager(INewsManager newsManager) {
        this.newsManager = newsManager;
    }

    public ISequenceValue getSequenceValue() {
        if (null == sequenceValue) sequenceValue = LocalLookup.getSequenceValue();
        return sequenceValue;
    }

    public void setSequenceValue(ISequenceValue sequenceValue) {
        this.sequenceValue = sequenceValue;
    }

    public IUserManager getUserManager() {
        if (null == userManager) userManager = LocalLookup.getUserManager();
        return userManager;
    }

    public void setUserManager(IUserManager userManager) {
        this.userManager = userManager;
    }
}
