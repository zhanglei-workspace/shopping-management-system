/*Copyright ©  2017 Lyons. All rights reserved. */
package lyons.common.exception.user;

/**
 * @Description: 违反唯一约束条件
 * @ClassName: NonuniquenessException
 * @author: lyons<zhanglei>
 * @date: 2017年2月12日 上午9:53:25
 * @version: [1.0]
 */
public class NonuniquenessException extends UserException
{
    private static final long serialVersionUID = 1L;
    
    public NonuniquenessException(int state, String message)
    {
        super(state, message);
    }

    public NonuniquenessException(String message)
    {
        super(message);
    }

    
}
