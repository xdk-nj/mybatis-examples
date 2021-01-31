package mybatis.mapper;

import mybatis.bean.Hobby;

public interface HobbyMapper {
    void addHobby(Hobby hobby);
    Hobby getHobbyById(Integer id);
}
