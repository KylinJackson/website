package manager.daoImpl;

import manager.dao.IInformationDao;
import manager.util.DBUtil;

import java.sql.ResultSet;

import static manager.util.DBUtil.queryData;

//专门处理数据库
public class InformationDaoImpl implements IInformationDao {
    ResultSet rs;
    DBUtil db = new DBUtil();

    @Override
    public ResultSet getInformation() {
        System.out.println("---do InformationDaoImpl");
        String sql = "SELECT * FROM publish ORDER BY publishTime DESC";
        try {
            rs = queryData(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    @Override
    public ResultSet searchInformationByFlag(int flag) {
        String sql = "select * from publish where publishcolumnsId = '" + flag + "' order by publishTime desc";
        ResultSet rs = null;
        try {
            rs = db.queryData(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    @Override
    public ResultSet searchInformationByNum(int flag) {
        String sql = "select * from publish where publishId = '" + flag + "'";
        ResultSet rs = null;
        try {
            rs = db.queryData(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}
