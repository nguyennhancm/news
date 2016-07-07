package portal.system.bean;

import portal.utils.BasePortalBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 4/9/2016
 * Time: 3:07 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name = "AddWebSite")
@SessionScoped
public class AddWebSiteBean extends BasePortalBean{



    public String createSite(){
        // tài khoản quản lý party, userlogin

        // tao site product store
        // map user - site
        // danh mục
        // chuyên mục
        // map danh mục - chuyên mục
        // map danh mục - site
        // tạo danh mục default: video, mp3, image, group slide, ...



        return "";
    }





    @Override
    public String getClassName() {
        return getClass().getName();
    }
}
