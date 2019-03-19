package user.daoImpl;

import user.dao.IUserLoginDao;
import user.model.Complain;
import user.model.User;
import user.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginDaoImpl implements IUserLoginDao{
    private ResultSet rs;
    private DBUtil db=new DBUtil();
    @Override
    public ResultSet isLogin(String userId, String userPassword) {
        String sql="select * from user where userId='"+userId+"'and userPassword='"+userPassword+"'and userFreeze='no'";
        try {
            rs=db.queryData(sql);
            if(rs.next()){
                return rs;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addUsers(User user) {
        String sql="insert into user(userId,userName,userPassword,userSex,userTel,userEmail,userFreeze)values('"+user.getUserId()+"','"+user.getUserName()+"','"+user.getUserPassword()+"','"+user.getUserSex()+"','"+user.getUserTel()+"','"+user.getUserEmail()+"','"+user.getUserFreeze()+"')";
        try {
            if(db.Update(sql))
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ResultSet searchUserById(String Id) {
        String sql="select * from user where userId='"+Id+"'";
        try {
            rs=db.queryData(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public ResultSet showAllPubs() {
        String sql = "SELECT * FROM publish ORDER BY publishTime DESC";
        try {
            rs = db.queryData(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean alterUser(String userId,String userName, String userSex, String userTel, String userEmail) {
        String sql="update user set userName='"+userName+"',userSex='"+userSex+"',userTel='"+userTel+"',userEmail='"+userEmail+"' where userId='"+userId+"'";
        try {
            if(db.Update(sql))
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean alterPassword(String userId, String userPassword) {
        String sql="update user set userPassword='"+userPassword+"' where userId='"+userId+"'";
        try {
            if(db.Update(sql))
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addComplains(Complain complain) {
        String sql="insert into complain(complainId,complainuserId,complainTitle,complainContent) values('"+complain.complainId+"','"+complain.complainuserId+"','"+complain.complainTitle+"','"+complain.complainContent+"')";
        try {
            if(db.Update(sql))
            {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ResultSet isSubs(String userId) {
        String sql = "select * from subscribe where subsuserId = '" + userId + "'";
        try {
            rs = db.queryData(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public ResultSet searchReplyByUId(String userId) {
        String sql="select * from reply where replyuserId='"+userId+"' order by replyId desc";
        rs=null;
        try {
            rs=db.queryData(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public ResultSet searchSentByUId(String userId) {
        String sql="select * from complain where complainuserId='"+userId+"' order by complainId desc";
        rs=null;
        try {
            rs=db.queryData(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public ResultSet searchReplyByRId(int replyId) {
        String sql="select * from reply where replyId='"+replyId+"'";
        rs=null;
        try {
            rs=db.queryData(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public ResultSet searchSentByCId(int complainId) {
        String sql="select * from complain where complainId='"+complainId+"'";
        rs=null;
        try {
            rs=db.queryData(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean searchLogoutByUId(String userId) {
        String sql="select * from logout where logoutuserId='"+userId+"'";
        rs=null;
        try {
            rs=db.queryData(sql);
            if(rs.next())
                return false;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
