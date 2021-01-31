package mybatis.test;

import mybatis.bean.User;
import mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheTest {

    @Test
    public void test1() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        /**mybatis一级缓存默认开启，作用域是同一个sqlsession*/
        User u1 = userMapper.getUserById(1);
        System.out.println(u1);
        u1 = userMapper.getUserById(1);
        System.out.println(u1);
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();

        /**二级缓存，基于namespace级别的缓存*/
        /**查处的数据先放在一级缓存中，会话关闭后，才会写入二级缓存*/
        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);

        User user1 = userMapper1.getUserById(1);
        System.out.println(user1);
        sqlSession1.close();

        User user2 = userMapper2.getUserById(1);
        System.out.println(user2);
        sqlSession2.close();
    }

}
