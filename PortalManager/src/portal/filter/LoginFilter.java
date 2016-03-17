package portal.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/11/2015
 * Time: 11:50 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession(true);
        StringBuffer requestURL = httpServletRequest.getRequestURL();
        String defaultHomePage = requestURL.substring(0, requestURL.indexOf(httpServletRequest.getRequestURI()));
        if (null != System.getProperty("portal.development.mode") && !System.getProperty("portal.development.mode").equals("true")) {
            if (httpServletRequest.getRequestURI().contains("login.xhtml")) {
                if (null != session && null != session.getAttribute("user_login")) {
                    ((HttpServletResponse) servletResponse).sendRedirect(defaultHomePage + "/");
                }
            } else if (null != session && null != session.getAttribute("user_login")) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            } else {
                ((HttpServletResponse) servletResponse).sendRedirect(defaultHomePage + "/login.xhtml");
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
