package mybatis.mapper;

import mybatis.bean.Author;

public interface AuthorMapper {
    Author getAuthorById(Integer id);
}
