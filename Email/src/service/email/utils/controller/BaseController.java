package service.email.utils.controller;


import service.email.manager.IEmailManager;
import service.email.utils.lookup.LocalLookup;
import service.email.utils.valueItem.manager.ISequenceValue;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/4/2015
 * Time: 9:37 AM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseController {
    ISequenceValue sequenceValue;

    IEmailManager emailManager;

    public ISequenceValue getSequenceValue() {
        if (null == sequenceValue) sequenceValue = LocalLookup.getSequenceValue();
        return sequenceValue;
    }

    public void setSequenceValue(ISequenceValue sequenceValue) {
        this.sequenceValue = sequenceValue;
    }

    public IEmailManager getEmailManager() {
        if (null == emailManager) emailManager = LocalLookup.getEmailManager();
        return emailManager;
    }

    public void setEmailManager(IEmailManager emailManager) {
        if (null == emailManager) emailManager = LocalLookup.getEmailManager();
        this.emailManager = emailManager;
    }
}
