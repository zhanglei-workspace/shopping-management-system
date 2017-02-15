package lyons.common.mapper.user;

import org.apache.ibatis.annotations.Param;

import lyons.common.model.user.UUser;

public interface UUserMapper {

    UUser loginByNamePswd(@Param("uName") String uName,@Param("pswd") String pswd);

    String findUsernameByUsername(@Param("uName") String username);
    
    int register(UUser uuser);
    
    int updateByPrimaryKeySelective(UUser user);


   
}