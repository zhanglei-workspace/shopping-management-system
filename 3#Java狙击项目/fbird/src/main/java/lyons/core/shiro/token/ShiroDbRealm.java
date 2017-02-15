/*Copyright ©  2017 Lyons. All rights reserved. */
package lyons.core.shiro.token;

import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import lyons.common.exception.user.NonuniquenessException;
import lyons.common.exception.user.RepeatException;
import lyons.common.exception.user.UserException;
import lyons.common.model.user.UUser;
import lyons.common.service.user.UUserService;
import lyons.common.utils.MathUtil;
import lyons.common.utils.enums.AccountStaEnum;

/**
 * @Description: 登录认证+授权
 * @ClassName: ShiroDbRealm
 * @author: lyons<zhanglei>
 * @date: 2017年1月17日 上午10:31:29
 * @version: [1.0]
 */
public class ShiroDbRealm extends AuthorizingRealm
{
    
    @Autowired
    private UUserService userService;
    
   /**
    * 用户登录认证
    */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
        throws AuthenticationException
    {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        UUser user = userService.login(token.getUsername(),new String(token.getPassword()));

        if (user == null)
        {
            throw new IncorrectCredentialsException();
        }else if (AccountStaEnum.disabled.getState() != user.getuState()) {
            throw new DisabledAccountException();
        }else {
            //update last login time
            user.setulastLoginTime(new Date());
            userService.updateByPrimaryKeySelective(user);
        }
        return new SimpleAuthenticationInfo(user,user.getuPassword(),getName());
    }
    
    /**
     * @Title: regist
     * @Description: 用户注册
     * @return: void
     * @throws UserException 
     */
    public void registering(UUser uuser) throws UserException
    {   
        /*
         * 检查是否已注册
         */
        if (userService.isRegister(uuser.getuName()))
        {
            throw new RepeatException(AccountStaEnum.registerRepeat.getInfo());
        }
        
        uuser.setuPassword(MathUtil.getMd5(uuser.getuPassword()));
        if (userService.register(uuser) != 1)
        {
            /*
             * TODO
             * 该异常不是很准确
             */
            throw new NonuniquenessException(AccountStaEnum.registerExistence.getInfo());
        }
    }
    
    /* (non Javadoc)
     * @Title: doGetAuthorizationInfo
     * @Description: TODO
     * @param arg0
     * @return
     * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    /**
     * 清空当前用户权限信息
     */
    public  void clearCachedAuthorizationInfo() {
        PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
        SimplePrincipalCollection principals = new SimplePrincipalCollection(
                principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }
    /**
     * 指定principalCollection 清除
     */
    public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(
                principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }
}
