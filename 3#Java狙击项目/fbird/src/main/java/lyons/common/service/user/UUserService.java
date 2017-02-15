/*Copyright ©  2017 Lyons. All rights reserved. */
package lyons.common.service.user;

import lyons.common.model.user.UUser;

/**
 * @Description: 用户服务类
 * @ClassName: UserSevice
 * @author: lyons<zhanglei>
 * @date: 2017年1月17日 下午5:56:55
 * @version: [1.0]
 */
public interface UUserService
{
    /** login by username and userPassword　*/
    UUser login(String username, String pswd);
    
    /** checking for the existence of username */
    boolean isRegister(String username);
    
    /** register by username and userPassword　*/
    int register(UUser uuser);
    
    /** update userInfo*/
    int updateByPrimaryKeySelective(UUser user);

}