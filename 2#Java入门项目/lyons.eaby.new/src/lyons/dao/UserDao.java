package lyons.dao;

import java.util.List;
import java.util.Map;

import lyons.user.entity.User;


/**
 * 
 * user.xml 对应的接口
 * 
 * @author lyons(zhanglei)
 * 
 */
public interface UserDao
{
    /**根据用户名查询信息**/
    public List<User> queryByuserNamepassWord(Map<String, Object> map);

    /**注册新用户**/
    public void insertUser(Map<String, String> registerMap);

    /**验证用户是否存在**/
    public List<User> queryByuserName(String username);
}
