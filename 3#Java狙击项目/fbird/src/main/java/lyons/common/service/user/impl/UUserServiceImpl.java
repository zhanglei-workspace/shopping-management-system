/*Copyright ©  2017 Lyons. All rights reserved. */
package lyons.common.service.user.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lyons.common.mapper.user.UUserMapper;
import lyons.common.model.user.UUser;
import lyons.common.service.user.UUserService;

/**
 * @Description: 用户服务实现类
 * @ClassName: UUserServiceImpl
 * @author: lyons<zhanglei>
 * @date: 2017年1月17日 下午6:35:17
 * @version: [1.0]
 */
@Service
public class UUserServiceImpl implements UUserService
{
    private static Logger log = LoggerFactory.getLogger(UUserServiceImpl.class);
    @Autowired
    private UUserMapper userMapper;

    @Override
    public UUser login(String username, String pswd)
    {
        try
        {
            return userMapper.loginByNamePswd(username,pswd);
        } catch (Exception e)
        {
            log.debug("\n\n |======UUserServiceImpl===login===>"+e+"<=============| \n");
        }
        return null;
    }
    
    
    @Override
    public int register(UUser uuser)
    {
        try
        {
            return userMapper.register(uuser);
        } catch (Exception e)
        {
            log.debug("\n\n |======UUserServiceImpl===register===>"+e+"<=============| \n");
        }
        return -1;
    }

    
    @Override
    public int updateByPrimaryKeySelective(UUser user)
    {
        return userMapper.updateByPrimaryKeySelective(user);
    }


    @Override
    public boolean isRegister(String username)
    {
        try
        {
            return username.equals(userMapper.findUsernameByUsername(username));
            
        } catch (Exception e)
        {
            log.debug("\n\n |======UUserServiceImpl===isRegister===>"+e+"<=============| \n");
            return false;
        }
    }

    
}
