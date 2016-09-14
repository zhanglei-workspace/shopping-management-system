package lyons.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import lyons.db.DbAccess;
import lyons.user.entity.User;

/**
 * vip用户维护类
 * 
 * orderForm.sql
 */
public class UserDaoImp implements UserDao
{
    
    SqlSession sqlSession;
    DbAccess dbAccess = new DbAccess();
    
    /**
     * 
     * 根据用户名查询用户信息
     * @param map
     * @return
     */
    @Override
    public List<User> queryByuserNamepassWord(Map<String, Object> map)
    {
        try
        {
            sqlSession = dbAccess.getSqlSession();
            return sqlSession.getMapper(UserDao.class).queryByuserNamepassWord(map);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            sqlSesionClose();
        }
        
       return new ArrayList<User>();
    }
    
    
    /*
     * 关闭数据库连接会话
     */
    private void sqlSesionClose()
    {
        if (sqlSession != null)
        {
            sqlSession.close();
        }
    }
    
}
