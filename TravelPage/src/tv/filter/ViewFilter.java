package tv.filter;

import org.apache.log4j.Logger;
import tv.bean.BaseNewsBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: NTD
 * Date: 5/31/2015
 * Time: 12:30 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@ViewScoped
@ManagedBean(name = "View")
public class ViewFilter extends BaseNewsBean implements Filter {
    private Logger logger = Logger.getLogger(getClass().getName());
    private String charSet = "UTF-8";
    private String newsViewPage = "news.xhtml";
    private String newsListViewPage = "news_list.xhtml";
    private String newsListLoading = "news_list_loading.xhtml";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//        servletRequest.setCharacterEncoding(charSet);
//        servletResponse.setCharacterEncoding(charSet);
//        String path = httpServletRequest.getRequestURI();
//        int slashCount = path.split("/").length;
//        if (path.contains("/bai-viet/")){
//            httpServletRequest.setAttribute("viewId", path);
//            RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/" + newsViewPage);
//            requestDispatcher.forward(httpServletRequest, servletResponse);
//            return;
//        }else if (path.contains("/news_list_loading/")){
//            String viewType = httpServletRequest.getParameterMap().get("viewType")[0];
//            String viewId = httpServletRequest.getParameterMap().get("viewId")[0];
//            String page = httpServletRequest.getParameterMap().get("page")[0];
//            httpServletRequest.setAttribute("viewType", viewType);
//            httpServletRequest.setAttribute("viewId", viewId);
//            httpServletRequest.setAttribute("page", "123456");
//            RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/" + newsListLoading);
//            requestDispatcher.forward(httpServletRequest, servletResponse);
//            return;
//        }else if (path.contains("/chuyen-muc/")){
//            httpServletRequest.setAttribute("viewType", "category");
//            httpServletRequest.setAttribute("viewId", path);
//            RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/" + newsListViewPage);
//            requestDispatcher.forward(httpServletRequest, servletResponse);
//            return;
//        }else if (path.contains("/danh-muc/")){
//            httpServletRequest.setAttribute("viewType", "catalog");
//            httpServletRequest.setAttribute("viewId", path);
//            RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/" + newsListViewPage);
//            requestDispatcher.forward(httpServletRequest, servletResponse);
//            return;
//        }
//        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

    @Override
    public String getClassName() {
        return getClass().getName();
    }

    @Override
    public String getBundleName() {
        return null;
    }
}
