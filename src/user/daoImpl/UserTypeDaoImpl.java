package user.daoImpl;

import user.dao.IUserTypeDao;
import user.util.DBUtil;

import java.sql.ResultSet;

/**
 * Created by kylin on 17-7-11.
 */
public class UserTypeDaoImpl implements IUserTypeDao {

    DBUtil db = new DBUtil();
    @Override
    public ResultSet showArticlesByType(int type) {
        String sql = "select * from publish where publishcolumnsId=" + type + " order by publishTime desc";
        System.out.println(sql);
        try {
            return db.queryData(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet showArticlesById(int publishId) {
        String sql = "select * from publish where publishId=" + publishId;
        try {
            return db.queryData(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
