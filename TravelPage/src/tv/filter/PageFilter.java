package tv.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: NTD
 * Date: 5/31/2015
 * Time: 12:25 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
public class PageFilter implements Filter {
    private Logger logger = Logger.getLogger(getClass().getName());
    private String charSet = "UTF-8";
    private String defaultPage = "index.xhtml";
    private String newsViewPage = "news.xhtml";
    private String newsListViewPage = "news_list.xhtml";
    private String newsListLoading = "news_list_loading.xhtml";


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        logger.trace("Forum filter url: " + httpServletRequest.getRequestURL());
        servletRequest.setCharacterEncoding(charSet);
        servletResponse.setCharacterEncoding(charSet);
        String path = httpServletRequest.getRequestURI();
//        if (path.contains(".") || path.contains("imagesUpload") || path.contains("/chatUploadImageServlet")) {
//            filterChain.doFilter(servletRequest, servletResponse);
//            return;
//        } else {
//            httpServletRequest.setAttribute("originUrl", httpServletRequest.getRequestURL().toString());
//            if ("/".equals(path) || "/index".equals(path) || "/index.xhtml".equals(path)) {
//                RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/" + defaultPage);
//                requestDispatcher.forward(httpServletRequest, servletResponse);
//            }
//        }
        /////////////////////////////
        if ("".equals(path) || "/".equals(path) || "/index".equals(path) || "/index.xhtml".equals(path)) {
            RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/" + defaultPage);
            requestDispatcher.forward(httpServletRequest, servletResponse);
            return;
        }
//        while (path.endsWith("/")){
//            path = path.substring(0, path.length()-1);
//        }
        int slashCount = path.split("/").length;
        if (slashCount == 4 && path.endsWith(".html")){
            httpServletRequest.setAttribute("viewId", path);
            RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/" + newsViewPage);
            requestDispatcher.forward(httpServletRequest, servletResponse);
            return;
        }else if (slashCount == 3 && path.contains("tags")){
            httpServletRequest.setAttribute("viewType", "tags");
            httpServletRequest.setAttribute("viewId", path);
            RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/" + newsListViewPage);
            requestDispatcher.forward(httpServletRequest, servletResponse);
            return;
        }
        else if (path.contains("/news_list_loading/")){
            String viewType = httpServletRequest.getParameterMap().get("viewType")[0];
            String viewId = httpServletRequest.getParameterMap().get("viewId")[0];
            String page = httpServletRequest.getParameterMap().get("page")[0];
            httpServletRequest.setAttribute("viewType", viewType);
            httpServletRequest.setAttribute("viewId", viewId);
            httpServletRequest.setAttribute("page", "123456");
            RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/" + newsListLoading);
            requestDispatcher.forward(httpServletRequest, servletResponse);
            return;
        }else if (slashCount == 3 && !path.contains(".")){
            httpServletRequest.setAttribute("viewType", "category");
            httpServletRequest.setAttribute("viewId", path);
            RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/" + newsListViewPage);
            requestDispatcher.forward(httpServletRequest, servletResponse);
            return;
        }else if (slashCount == 2 && !path.contains(".")){
            httpServletRequest.setAttribute("viewType", "catalog");
            httpServletRequest.setAttribute("viewId", path);
            RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/" + newsListViewPage);
            requestDispatcher.forward(httpServletRequest, servletResponse);
            return;
        }
//        else {
//            RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/" + defaultPage);
//            requestDispatcher.forward(httpServletRequest, servletResponse);
//            return;
//        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
