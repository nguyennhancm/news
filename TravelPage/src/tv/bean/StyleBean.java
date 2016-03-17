package tv.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/23/2015
 * Time: 2:08 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@SessionScoped
@ManagedBean (name = "StyleBean")
public class StyleBean {
    String pathOnclick = "";

    public String styleUrl(String name) {
        if (getPathOnclick().equals(name)) return "active";
        return "";
    }

    public String getPathOnclick() {
        return pathOnclick;
    }

    public void setPathOnclick(String pathOnclick) {
        this.pathOnclick = pathOnclick;
    }
}
