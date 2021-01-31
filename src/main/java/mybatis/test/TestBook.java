package mybatis.test;

import mybatis.bean.Book;
import mybatis.bean.User;
import mybatis.mapper.BookMapper;
import mybatis.mapper.DynamicSQLMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestBook {

    @Test
    public void test1() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book book = bookMapper.getBookById(1);
        System.out.println(book);
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book book = bookMapper.getBookById2(1);
        //开启懒加载时，这里没有调用author属性，所以不会去查询author相关信息
        System.out.println(book.getId());
        System.out.println(book.getAuthor());
        sqlSession.close();
    }

}
