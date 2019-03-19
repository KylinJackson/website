package user.service;

import user.model.Complain;
import user.model.Publish;
import user.model.Reply;
import user.model.User;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by lenovo on 2017/7/8.
 */
public interface IUserLoginService {
    public ResultSet isLogin(String userId, String userPassword);
    public boolean addUsers(User user);
    public ResultSet searchUserByuserId(String userId);
    public List<Publish> showAllPubs();
    public boolean alterUsers(String userId, String userName, String userSex, String userTel, String userEmail);
    public boolean alterPassword(String userId, String userPassword);
    public boolean addComplains(Complain complain);
    public List<Integer> isSubs(String userId);
    public List<Reply> searchReplyByUId(String userId);
    public List<Complain> searchSentByUId(String userId);
    public Reply searchReplyByRId(int ReplyId);
    public Complain searchSentByCId(int ComplainId);
    public boolean searchlogoutByUId(String userId);
}
