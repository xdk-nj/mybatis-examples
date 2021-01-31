package mybatis.mapper;

import mybatis.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User getUserById(Integer id);
    void addUser(User user);
    void addUserWithUUID(User user);
    void deleteUserById(Integer id);
    void updateUser(User user);
    List<User> getAllUsers();
    void updateUsernameById(@Param("username") String username, @Param("id") Integer id);

    User getUserByIdWithResultMap(Integer id);
}
