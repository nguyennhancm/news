package service.email.bean;

import service.email.entities.EmailAccount;
import service.ultils.BaseEmailBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 10/2/2015
 * Time: 5:02 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@SessionScoped
@ManagedBean(name = "EmailAccount")
public class EmailAccountBean extends BaseEmailBean{
    private List<EmailAccount> emailAccountList;

    public List<EmailAccount> getEmailAccountList() {
        if (null == emailAccountList) emailAccountList = getEmailController().getEmailAccountByUser(defaultUserId);
        return emailAccountList;
    }

    public boolean checkSsl(String ssl){
        if (ssl.equals("N")) return false;
        return true;
    }

    public void setEmailAccountList(List<EmailAccount> emailAccountList) {
        this.emailAccountList = emailAccountList;
    }

    @Override
    public String getClassName() {
        return getClass().getName();
    }
}
