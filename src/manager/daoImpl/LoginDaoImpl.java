package manager.daoImpl;

import manager.dao.ILoginDao;
import manager.util.DBUtil;

import java.sql.ResultSet;

public class LoginDaoImpl implements ILoginDao{
    @Override
    public boolean isLogin(String manageid,String pwd){
        DBUtil db = new DBUtil();
        String sql = "select * from manage where manageId='" + manageid + "'and managePassword='" + pwd + "'";
        try {
            ResultSet rs = db.queryData(sql);
            if (rs.next()) {
                return true;
            }
            else
                return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}