package mybatis.test;

import mybatis.bean.User;
import mybatis.bean.User2;
import mybatis.mapper.User2Mapper;
import mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestUser {
    String resource = "mybatis-config.xml";

    @Test
    public void test1() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User u1 = userMapper.getUserById(1);
        System.out.println(u1);
        sqlSession.close();

        /** 二级缓存测试 */
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        User u2 = userMapper2.getUserById(1);
        System.out.println(u2);
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User u1 = new User();
        u1.setAddress("南邮");
        u1.setUsername("你爹");
        userMapper.addUser(u1);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test3() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User u1 = new User();
        u1.setAddress("南邮");
        userMapper.addUserWithUUID(u1);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test4() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUserById(7);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test5() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(8);
        user.setUsername("薛之谦");
        user.setAddress("上海");
        userMapper.updateUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test6() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUsers = userMapper.getAllUsers();
        System.out.println(allUsers);
        sqlSession.close();
    }

    @Test
    public void test7() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updateUsernameById("你有病吧", 1);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test8() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByIdWithResultMap(1);
        System.out.println(user);
        sqlSession.close();
    }


    @Test
    public void test9() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User2Mapper user2Mapper = sqlSession.getMapper(User2Mapper.class);
        User2 user2 = user2Mapper.getUser2ById(1);
        System.out.println(user2);
        sqlSession.close();
    }
}
