package service.email.utils.encode;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/2/2015
 * Time: 1:45 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
public class UTF8CharacterEncoding implements Filter {
    private String charSet = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(charSet);
        servletResponse.setCharacterEncoding(charSet);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

}
