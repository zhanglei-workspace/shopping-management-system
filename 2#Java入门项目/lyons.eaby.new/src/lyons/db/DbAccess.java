package lyons.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 
 *访问数据库类
 *
 */
public class DbAccess
{
    /*
     * 连接数据库
     */
    public SqlSession getSqlSession() throws IOException
    {
        //读取Mybatis连接数据库信息-配置文件
        Reader reader = Resources.getResourceAsReader("resources/MybatisConfiguration.xml");//此路径从src根路径算起
        
        //构建sqlSessionFactory
        SqlSessionFactory sqlSF = new SqlSessionFactoryBuilder().build(reader);
        
        //打开一个数据库会话
        SqlSession sqlSession = sqlSF.openSession();
        
        return sqlSession;
    }
    
}
