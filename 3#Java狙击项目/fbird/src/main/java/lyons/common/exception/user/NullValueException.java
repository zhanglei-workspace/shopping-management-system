/*Copyright ©  2017 Lyons. All rights reserved. */
package lyons.common.exception.user;

/**
 * @Description: TODO
 * @ClassName: NullValueException
 * @author: lyons<zhanglei>
 * @date: 2017年2月11日 下午8:51:44
 * @version: [1.0]
 */
public class NullValueException extends UserException
{
    private static final long serialVersionUID = 1L;
    
    public NullValueException(int state, String message)
    {
        super(state, message);
    }

    public NullValueException(String message)
    {
        super(message);
    }
    
}
