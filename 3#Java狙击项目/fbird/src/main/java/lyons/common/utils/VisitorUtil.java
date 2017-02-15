/*Copyright ©  2017 Lyons. All rights reserved. */
package lyons.common.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;

import lyons.common.exception.user.NullValueException;
import lyons.common.exception.user.RepeatException;
import lyons.common.exception.user.UserException;
import lyons.common.model.user.UUser;
import lyons.common.utils.enums.AccountStaEnum;

/**
 * @Description: 获取ip地址
 * @ClassName: GetAccessIp
 * @author: lyons<zhanglei>
 * @date: 2017年1月17日 下午3:53:29
 * @version: [1.0]
 */
public class VisitorUtil
{
    
    public static String getIp4()
    {
//        Inet4Address ip4 = Inet4Address.
        return "";
    }
    
    /**
     * 
     * @Title: getSaveURL
     * @Description: 获取登录之前的URL,如果没有返回 /index 
     * @param request
     * @return: String(URL)
     */
    public static String getSaveURL(HttpServletRequest request)
    {
        SavedRequest  savedRequest = WebUtils.getSavedRequest(request);
        
        return savedRequest == null ? "/index" : savedRequest.getRequestUrl();
        
    }
    
    /**
     * @param uuser 
     * @Title: isSecurity
     * @Description: 是否安全
     * @return: boolean
     */
    public static boolean isSecurity(UUser uuser) throws UserException
    {
        String security = securityCheck(uuser);
        if (security != null)
        {
            throw new NullValueException(security);
        }
        return true;
    } 
    
    /**
     * @Title: securityCheck
     * @Description: 常规安全检查
     * @param uuser
     * @return: String
     */
    public static String securityCheck(UUser uuser) throws RepeatException
    {
        if (StringUtils.isBlank(uuser.getuName()))
        {
            return AccountStaEnum.nameNull.getInfo();
        }
        if (StringUtils.isBlank(uuser.getuPassword()))
        {
            return AccountStaEnum.pswdNull.getInfo();
        }

        /*
         * 重复登录检查
         *  1.从 realm 获取 当前用户身份
         *  2.强制类型转换后获取属性值
         */
        if (isLogin())
        {
            throw new RepeatException(((UUser)SecurityUtils.getSubject().getPrincipal()).getuName()
                +AccountStaEnum.repeat.getInfo());
        }
        
        return null;
    }
    

    /**
     * 
     * @Title: isLogin
     * @Description: 是否已登录
     * @return: boolean
     */
    public static boolean isLogin()
    {
       return  SecurityUtils.getSubject().isAuthenticated();
    }
    
    
    /* 
     * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址, 
     * 参考文章： http://developer.51cto.com/art/201111/305181.htm 
     *  
     * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？ 
     * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。 
     *  
     * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130, 
     * 192.168.1.100 
     *  
     * 用户真实IP为： 192.168.1.110 
     *  
     * @param request 
     * @return 
     */  
    public static String getIpAddress(HttpServletRequest request) {  
        
        String ip = request.getHeader("x-forwarded-for"); 
        
        if (StringUtils.isBlank(ip) && "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
            ip = request.getHeader("WL-Proxy-Client-IP");  
            ip = request.getHeader("HTTP_CLIENT_IP");  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
            ip = request.getRemoteAddr();  
        }  
        
        return ip;  
    }
    
}
