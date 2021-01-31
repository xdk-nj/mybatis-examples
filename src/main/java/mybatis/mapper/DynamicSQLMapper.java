package mybatis.mapper;

import mybatis.bean.User;
import org.apache.ibatis.annotations.Param;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface DynamicSQLMapper {

    List<User> getUserByPage(@Param("start") Integer start, @Param("count") Integer count);
    List<User> getUserByUsernameAndId(@Param("username") String username, @Param("id") Integer id);
    List<User> getUserByIds(@Param("ids") Integer[] ids);
    void updateUser(User user);
}
