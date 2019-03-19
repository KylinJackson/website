package user.dao;

import java.sql.ResultSet;

/**
 * Created by kylin on 17-7-11.
 */
public interface IUserTypeDao {
    public ResultSet showArticlesByType(int type);
    public ResultSet showArticlesById(int publishId);
}
