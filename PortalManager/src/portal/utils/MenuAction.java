package portal.utils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 11/3/2015
 * Time: 7:02 AM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@SessionScoped
@ManagedBean(name = "MenuAction")
public class MenuAction {

    public String styleActiveCatalog(String keyword) {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String content = req.getRequestURL().toString().split("/")[3];
        if (content.equals(keyword)) {
            return "active";
        }
        return "";
    }

//    public String styleActiveCategory(String keyword) {
//        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        String content = req.getRequestURL().toString().split("/")[5];
//        if (content.contains(keyword)) {
//            return "active";
//        }
//        return "";
//    }
}
