package manager.daoImpl;

import manager.dao.IManagerDao;
import manager.model.Manager;
import manager.util.DBUtil;

import java.sql.ResultSet;

public class ManagerDaoImpl implements IManagerDao {
    DBUtil db = new DBUtil();

    @Override
    public ResultSet searchManagerByType(String typeId) {
        String sql="select * from manage where manageId='"+typeId+"'";
        ResultSet rs=null;
        try {
            rs=db.queryData(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public ResultSet getManagers() {
        ResultSet rs = null;
        String sql="select * from manage";
        try {
            rs = db.queryData(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    @Override
    public boolean alterManager(Manager manager) {
        String sql = "update manage set manageName = '"+manager.getManageName()+"',manageSex = '"+manager.getManageSex()+"',manageTel = '"+manager.getManageTel()+"',manageEmail = '"+manager.getManageEmail()+"' where manageId = '"+manager.getManageId()+"'";
        System.out.println(sql);
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
    public boolean verifyPassword(String managerId, String password) {
        String sql = "select * from manage where manageId='" + managerId + "' and managePassword='" + password + "'";
        try {
            return db.queryData(sql).next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean changePassword(String managerId, String password) {
        String sql = "update manage set managePassword = '" + password + "' where manageId='" + managerId + "'";
        try {
            return db.Update(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
