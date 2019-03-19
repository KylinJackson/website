package user.dao;

import user.model.Complain;
import user.model.User;

import java.security.SecureRandom;
import java.sql.ResultSet;

/*
 * Created by lenovo on 2017/7/8.
 */
public interface IUserLoginDao {
    public ResultSet isLogin(String userId, String userPassword);
    public boolean addUsers(User user);
    public ResultSet searchUserById(String Id);
    public ResultSet showAllPubs();
    public boolean alterUser(String userId, String userName, String userSex, String userTel, String userEmail);
    public boolean alterPassword(String userId, String userPassword);
    public boolean addComplains(Complain complain);
    public ResultSet isSubs(String userId);
    public ResultSet searchReplyByUId(String userId);
    public ResultSet searchSentByUId(String userId);
    public ResultSet searchReplyByRId(int replyId);
    public ResultSet searchSentByCId(int complainId);
    public boolean searchLogoutByUId(String userId);
}
