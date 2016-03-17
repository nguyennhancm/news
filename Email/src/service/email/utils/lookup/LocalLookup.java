package service.email.utils.lookup;

import service.email.controller.IEmailController;
import service.email.manager.IEmailManager;
import service.email.utils.valueItem.manager.ISequenceValue;

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
    private static String prefix = "java:global/Email/";

    public static Object getBean(String jndiName) {
        try {
            return new InitialContext().lookup(prefix + jndiName);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }



    public static ISequenceValue getSequenceValue() {
        return (ISequenceValue) getBean("Email/SequenceValue");
    }

    public static IEmailManager getEmailManager(){
        return (IEmailManager) getBean("Email/EmailManager");
    }

    public static IEmailController getEmailController(){
        return (IEmailController) getBean("Email/EmailController");
    }

}
