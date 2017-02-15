/*Copyright ©  2017 Lyons. All rights reserved. */
package lyons.common.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

/**
 * @Description: 数字工具
 * @ClassName: MathUtils
 * @author: lyons<zhanglei>
 * @date: 2017年1月19日 下午7:32:02
 * @version: [1.0]
 */
public class MathUtil
{
    /**
     * 
     * @Title: getMd5
     * @Description: 加密封装字符串
     * @param str
     * @return: String(32bit)
     */
    public static String getMd5(String str)
    {
       return StringUtils.isBlank(str) ? null : DigestUtils.md5Hex(str.trim()+"2@&%/*Wd"); 
    }
    
    /**
     * 
     * @Title: getCharMd5
     * @Description: 加密封装字符串
     * @param str
     * @return: char[]
     */
    public static char[] getCharMd5(String str)
    {
        return StringUtils.isBlank(str) ? null : DigestUtils.md5Hex(str.trim()+"2@&%/*Wd").toCharArray(); 
    }
   
}
