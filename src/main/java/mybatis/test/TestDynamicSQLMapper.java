package mybatis.test;

import mybatis.bean.Hobby;
import mybatis.bean.User;
import mybatis.mapper.DynamicSQLMapper;
import mybatis.mapper.HobbyMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class TestDynamicSQLMapper {
    @Test
    public void test1() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<User> users = dynamicSQLMapper.getUserByPage(2, 2);
        System.out.println(users);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        //List<User> users = dynamicSQLMapper.getUserByUsernameAndId("彩", 2);
        List<User> users = dynamicSQLMapper.getUserByUsernameAndId(null, null);
        System.out.println(users);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test3() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);

        List<User> users = dynamicSQLMapper.getUserByIds(new Integer[]{1, 5, 6});
        System.out.println(users);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test4() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);

        User user = new User();
        user.setId(9);
        user.setUsername("我打你吗");
        user.setAddress("上海");
        dynamicSQLMapper.updateUser(user);
        sqlSession.commit();
        sqlSession.close();
    }


}
