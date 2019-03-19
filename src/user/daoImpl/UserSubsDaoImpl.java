package user.daoImpl;

import user.dao.IUserSubsDao;
import user.util.DBUtil;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kylin on 17-7-9.
 */
public class UserSubsDaoImpl implements IUserSubsDao {
    DBUtil db=new DBUtil();
    ResultSet resultSet;
    @Override
    public boolean sub(String userId, int type) {
        String sql = "insert into subscribe values (0,'"+userId+"',"+type+")";
        try {
            return db.Update(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Date logoutTime(String userId) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sql = "select max(logoutTime) from logout where logoutuserId='" + userId + "'";
        try {
            resultSet = db.queryData(sql);
            resultSet.first();
            return simpleDateFormat.parse(resultSet.getString(1));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean cancel(String userId, int type) {
        String sql = "delete from subscribe where subsuserId='" + userId + "' and subscolumnsId="+type;
        try {
            return db.Update(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
