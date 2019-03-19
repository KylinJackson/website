package user.daoImpl;

import user.dao.IUserLogoutDao;
import user.util.DBUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserLogoutDaoImpl implements IUserLogoutDao {
    DBUtil db = new DBUtil();
    public boolean logout(String userId) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sql = "insert into logout values (0,'"+userId+"','"+df.format(new Date())+"')";
        try {
            return db.Update(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
