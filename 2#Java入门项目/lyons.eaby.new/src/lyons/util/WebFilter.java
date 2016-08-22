package lyons.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

/**
 * 
 * 页面编码格式过滤器
 * 
 */
@SuppressWarnings("serial")
public class WebFilter extends HttpServlet implements Filter
{
    
    private FilterConfig config;  
    
    public void destroy() {}
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException
    {
        //获取Filter中编码设置
        String encoding = config.getInitParameter("encoding");  
        if (encoding != null && !"".equals(encoding)) 
        {  
            request.setCharacterEncoding(encoding);  
        }  
        chain.doFilter(request, response);  
        
    }

    @Override
    public void init(FilterConfig config)
        throws ServletException
    {
        this.config = config;
        
    }
    
}
