package manager.daoImpl;

import manager.dao.IUserDao;
import manager.model.User;
import manager.util.DBUtil;

import java.sql.ResultSet;

public class UserDaoImpl implements IUserDao {
    ResultSet rs;
    DBUtil db=new DBUtil();

    @Override
    public ResultSet getUsers() {
        String sql="select * from user";
        try {
            rs=db.queryData(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean freezeUserById(String userId) {
        String sql = "update user set userFreeze = 'yes' where userId = '"+userId+"'";
        try {
            if(db.Update(sql)){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean cancelFreezeById(String userId) {
        String sql = "update user set userFreeze = 'no' where userId = '"+userId+"'";
        try {
            if(db.Update(sql)){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean alterUser(User user) {
        String sql = "update user set userName = '"+user.getUserName()+"',userPassword = '"+user.getUserPassword()+"',userSex = '"+user.getUserSex()+"',userTel = '"+user.getUserTel()+"',userEmail = '"+user.getUserEmail()+"' where userId = '"+user.getUserId()+"'";
        try {
            if(db.Update(sql)){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public ResultSet searchUserByType(String typeId) {
        String sql = "select * from user where userId = '"+typeId+"'";
        ResultSet rs = null;
        try {
            rs = db.queryData(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}

