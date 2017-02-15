/*Copyright ©  2017 Lyons. All rights reserved. */
package lyons.common.exception.user;

/**
 * @Description: 已存在的数据
 * @ClassName: repeatException
 * @author: lyons<zhanglei>
 * @date: 2017年2月11日 下午7:13:44
 * @version: [1.0]
 */
public class RepeatException extends UserException
{

    private static final long serialVersionUID = 1L;

    public RepeatException(int state, String message)
    {
        super(state, message);
    }
    
    public RepeatException(String message)
    {
        super(message);
    }

    
}
