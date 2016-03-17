package tv.bean;

import org.apache.log4j.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: NTD
 * Date: 5/29/2015
 * Time: 11:58 AM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractManagedBean implements Serializable {
    Logger logger = null;

    /**
     * Must define child class for property logging.
     *
     * @return
     */
    public abstract String getClassName();

    protected ResourceBundle resourceBundle;

    public Logger getLogger() {
        if (null == logger) {
            logger = Logger.getLogger(getClassName());
        }
        return logger;
    }


    public void addError(String componentId, String messageId, String detail, Exception e) {
        FacesContext.getCurrentInstance().addMessage(componentId, new FacesMessage(FacesMessage.SEVERITY_ERROR, getMessageFromBundle(messageId, detail), null));
        getLogger().warn(detail + e);
    }

    public void addError(String componentId, String messageId, String detailMessage, String logDetail, Exception e) {
        addValidateError(componentId, messageId, detailMessage);
        getLogger().warn(logDetail + e);
    }

    public void addValidateError(String componentId, String messageId, String errorMessage) {
        FacesContext.getCurrentInstance().addMessage(componentId, new FacesMessage(FacesMessage.SEVERITY_ERROR, getMessageFromBundle(messageId, errorMessage), null));
    }

    public String getMessageFromBundle(String messageId, String messageDetail) {
        String message = null;
        if (null != messageId && null != getBundle()) message = getBundle().getString(messageId);
        if (null == message) {
            message = messageDetail;
            getLogger().info("Unable found message bundle,bundleName=" + getBundleName() + ",messageId" + messageId);
        }
        return message;
    }

    public void addMessage(String componentId, String messageId, String errorMessage) {
        FacesContext.getCurrentInstance().addMessage(componentId, new FacesMessage(FacesMessage.SEVERITY_INFO, getMessageFromBundle(messageId, errorMessage), null));
    }


    public ResourceBundle getBundle() {
        {
            if (resourceBundle == null) {
                FacesContext context = FacesContext.getCurrentInstance();
                resourceBundle = context.getApplication().getResourceBundle(context, getBundleName());
            }
            return resourceBundle;
        }
    }

    public abstract String getBundleName();

    public Object getSessionBean(String beanName) {

        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(beanName);
    }


    /**
     * utility method to get an object in the servlet context.
     *
     * @param context
     * @param attribute
     * @param sessionId
     */
    public Object getSessionDataFromContext(ServletContext context, String attribute, String sessionId) {

        Object data = null;
        // read the shareddata
        Hashtable shareddata = (Hashtable) context.getAttribute(attribute);
        if (shareddata != null) {
            // get the right object using the ssosessionid
            data = (String) shareddata.get(sessionId);
        }
        return data;
    }

    /**
     * utility method to store an object in the servlet context.
     *
     * @param context
     * @param attribute
     * @param sessionId
     * @param data
     */
    public void setSessionDataToContext(ServletContext context, String attribute, String sessionId, String data) {
        Hashtable shareddata = (Hashtable) context.getAttribute(attribute);
        // if not yet available, create a new one
        if (shareddata == null) {
            shareddata = new Hashtable();
        }
        // store the userroles of the current session
        shareddata.put(sessionId, data);
        // store the shareddata back into the Context
        context.setAttribute(attribute, shareddata);
    }

    /**
     * @param jndi
     * @param <T>
     * @return EJB controller
     */
    public <T> T getController(String jndi) {
        T t;
        try {
            t = (T) new InitialContext().lookup(jndi);
        } catch (NamingException ne) {
            throw new RuntimeException(ne);
        }

        return t;
    }

    /**
     * @param beanName
     * @param <T>
     * @return CDI Bean
     */
    @SuppressWarnings("unchecked")
    public <T> T findBean(String beanName) {
        FacesContext context = FacesContext.getCurrentInstance();
        return (T) context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", Object.class);
    }

    public ExternalContext getExternalContext() {
        return FacesContext.getCurrentInstance().getExternalContext();
    }

    public void redirect(String destination) throws IOException {
        HttpServletResponse response = (HttpServletResponse) getExternalContext().getResponse();
        response.sendRedirect(destination);
    }

    public Object getRequestAttribute(String name) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(name);
    }

    public HttpServletRequest getRequest() {
        return (HttpServletRequest) getExternalContext().getRequest();
    }

}
