package mybatis.test;

import mybatis.bean.Hobby;
import mybatis.mapper.HobbyMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class TestHobby {

    @Test
    public void test1() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        HobbyMapper hobbyMapper = sqlSession.getMapper(HobbyMapper.class);
        Hobby hobby = new Hobby();
        hobby.setId(2);
        hobby.setFavs(Arrays.asList("篮球", "足球", "电竞"));
        hobbyMapper.addHobby(hobby);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        HobbyMapper hobbyMapper = sqlSession.getMapper(HobbyMapper.class);
        Hobby hobby = hobbyMapper.getHobbyById(2);
        System.out.println(hobby);
        sqlSession.close();
    }

}
