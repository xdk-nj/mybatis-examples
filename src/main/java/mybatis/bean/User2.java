package mybatis.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.IntrospectionException;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User2 {

    private Integer id;
    private String username;
    private String password;
    private List<Role> roles;
}
