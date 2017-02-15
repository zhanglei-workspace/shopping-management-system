/*Copyright ©  2017 Lyons. All rights reserved. */
package lyons.common.exception.user;

/**
 * @Description: 用户异常标准类
 * @ClassName: UserException
 * @author: lyons<zhanglei>
 * @date: 2017年2月11日 下午7:05:32
 * @version: [1.0]
 */
public class UserException extends Exception
{
    private static final long serialVersionUID = 1L;
    
    public UserException(String message)
    {
        super(message);
    }
    
    public UserException(int state,String message)
    {
        super(message);
    }
    
}
