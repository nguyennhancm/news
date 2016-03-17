package portal.users.bean;

import tv.news.model.OrganizationData;
import portal.users.model.UserData;
import portal.utils.BasePortalBean;
import portal.utils.SHA1Encoding;
import tv.user.entities.UserLogin;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/5/2015
 * Time: 4:06 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@SessionScoped
@ManagedBean(name = "Login")
public class LoginBean extends BasePortalBean {
    String username;
    String password;
    SHA1Encoding encoding;
    UserData userData;
    boolean login;
    String message;

    public String login(){
        if(validateLoginformInfo(username,password)){
            setMessage("");
            UserLogin userLogin = getUserController().login(username, getEncoding().SHA1(password));
            if (null != userLogin){
                // set all store
                List<String> storeList = getUserController().getAllStoreByUser(userLogin.getPartyId());
                if (null == storeList || storeList.size() < 1){
                    setMessage("* Bạn không có quyền truy cập!");
                    return "";
                }
                getUserData().setStoreList(storeList);
                // set current store
                getUserData().setCurrentStore(storeList.get(0));
                //set org info tạm lấy ID party có sequence 1 để lưu info org
                // sau này tách ra thành org và chuyển userlogin sang party relationship
                //get org info
                OrganizationData organizationData = new OrganizationData();
                String partiId = getUserController().getPartyIdByStore(userData.getCurrentStore());
                organizationData.setParty(getUserController().getParty(partiId));
                organizationData.setImagesList(getUserController().getImagesList(partiId, "_PARTY_IMAGE"));
                getUserData().setOrganizationData(organizationData);

                getUserData().setUserLogin(userLogin);
                // set person
                getUserData().setPerson(getUserController().getPersonById(userLogin.getPartyId()));
                getSession().setAttribute("user_login", username);
                FacesContext context = FacesContext.getCurrentInstance();
                try {
                    context.getExternalContext().redirect("/");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else setMessage("* Đăng nhập không thành công!");
        }
        return "";
    }

    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            context.getExternalContext().redirect("/login.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/login.xhtml?faces-redirect=true";
    }

    public HttpSession getSession(){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        return request.getSession();
    }

    public boolean  validateLoginformInfo(String username, String password){
        boolean validate = true;
        if (username.isEmpty() || username.equals("") || password.isEmpty() || password.equals("")){
            setMessage("* Vui lòng nhập thông tin đăng nhập!");
            validate = false;
        }
        else if (username.length() > 100 || password.length() > 100){
            setMessage("* Thông tin đăng nhập không đúng!");
            validate = false;
        }
        return validate;
    }

    public void getDefaultUserData(){
        UserLogin userLogin = getUserController().login("dulichcantho", "{SHA}7c4a8d09ca3762af61e59520943dc26494f8941b");
        // set all store
        List<String> storeList = getUserController().getAllStoreByUser(userLogin.getPartyId());
        getUserData().setStoreList(storeList);
        // set current store
        getUserData().setCurrentStore(storeList.get(0));
        getUserData().setUserLogin(userLogin);
        // set person
        getUserData().setPerson(getUserController().getPersonById(userLogin.getPartyId()));
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserData getUserData() {
        if (null == userData){
            userData = new UserData();
            if (System.getProperty("portal.development.mode").equals("true")) {
                getDefaultUserData();
            }
        }
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public boolean isLogin() {
        if (null != getSession().getAttribute("user_login")) login = true;
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public SHA1Encoding getEncoding() {
        if (null == encoding)  encoding = new SHA1Encoding();
        return encoding;
    }

    public void setEncoding(SHA1Encoding encoding) {
        this.encoding = encoding;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getClassName() {
        return getClass().getName();
    }
}
