package mybatis.mapper;

import mybatis.bean.Book;

public interface BookMapper {

    Book getBookById(Integer id);
    Book getBookById2(Integer id);
}
