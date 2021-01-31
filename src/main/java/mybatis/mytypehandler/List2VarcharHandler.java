package mybatis.mytypehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(List.class)
public class List2VarcharHandler implements TypeHandler<List<String>> {
    @Override
    public void setParameter(PreparedStatement ps, int i, List<String> strings, JdbcType jdbcType) throws SQLException {
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s).append(",");
        }
        ps.setString(i, sb.toString());
    }

    @Override
    public List<String> getResult(ResultSet resultSet, String s) throws SQLException {
        String favs = resultSet.getString(s);
        if (favs != null) {
            return Arrays.asList(favs.split(","));
        }
        return null;
    }

    @Override
    public List<String> getResult(ResultSet resultSet, int i) throws SQLException {
        String favs = resultSet.getString(i);
        if (favs != null) {
            return Arrays.asList(favs.split(","));
        }
        return null;
    }

    @Override
    public List<String> getResult(CallableStatement callableStatement, int i) throws SQLException {
        String favs = callableStatement.getString(i);
        if (favs != null) {
            return Arrays.asList(favs.split(","));
        }
        return null;
    }
}
