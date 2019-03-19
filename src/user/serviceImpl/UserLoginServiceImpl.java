package user.serviceImpl;

import user.dao.IUserLoginDao;
import user.daoImpl.UserLoginDaoImpl;
import user.model.Complain;
import user.model.Reply;
import user.model.User;
import user.model.Publish;
import user.service.IUserLoginService;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
/**
 * Created by lenovo on 2017/7/8.
 */
public class UserLoginServiceImpl implements IUserLoginService{
    private IUserLoginDao iUserDao=new UserLoginDaoImpl();
    @Override
    public ResultSet isLogin(String userId, String userPassword) {

        ResultSet islogin=iUserDao.isLogin(userId,userPassword);
        return islogin;
    }

    @Override
    public boolean addUsers(User user) {
        return iUserDao.addUsers(user);
    }

    @Override
    public ResultSet searchUserByuserId(String userId) {
        ResultSet rs=iUserDao.searchUserById(userId);
        return rs;
    }

    @Override
    public List<Publish> showAllPubs() {
        ResultSet resultSet = iUserDao.showAllPubs();
        List<Publish> pubList =new ArrayList<Publish>();
        try {
            while(resultSet.next()) {
                Publish pub = new Publish();
                pub.setPublishId(resultSet.getInt(1));
                pub.setPublishcolumnsId(resultSet.getInt(2));
                pub.setPublishTitle(resultSet.getString(3));
                pub.setPublishContent(resultSet.getString(4));

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = simpleDateFormat.parse(resultSet.getString(5));

                pub.setPublishTime(date);
                pubList.add(pub);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pubList;
    }

    @Override
    public boolean alterUsers(String userId,String userName, String userSex, String userTel, String userEmail) {
        if(iUserDao.alterUser(userId, userName, userSex, userTel, userEmail))
            return true;
        else
            return false;
    }

    @Override
    public boolean alterPassword(String userId, String userPassword) {
        if(iUserDao.alterPassword(userId,userPassword))
            return true;
        else
            return false;
    }

    @Override
    public boolean addComplains(Complain complain) {
        if(iUserDao.addComplains(complain))
            return true;
        else
            return false;
    }

    @Override
    public List<Integer> isSubs(String userId) {
        ResultSet resultSet = iUserDao.isSubs(userId);
        List<Integer> integerList = new ArrayList<Integer>();
        try {
            while(resultSet.next()) {
                integerList.add(resultSet.getInt(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return integerList;
    }

    @Override
    public List<Reply> searchReplyByUId(String userId) {
        ResultSet rs=iUserDao.searchReplyByUId(userId);
        List<Reply> replyList=new ArrayList<Reply>();
        try {
            while (rs.next()){
                int replyId=rs.getInt("replyId");
                int replycomplainId=rs.getInt("replycomplainId");
                String replyuserId=rs.getString("replyuserId");
                String replyTitle=rs.getString("replyTitle");
                String replyContent=rs.getString("replyContent");
                Reply reply=new Reply();
                reply.setReplyId(replyId);
                reply.setReplycomplainId(replycomplainId);
                reply.setReplyuserId(replyuserId);
                reply.setReplyTitle(replyTitle);
                reply.setReplyContent(replyContent);
                replyList.add(reply);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return replyList;
    }

    @Override
    public List<Complain> searchSentByUId(String userId) {
        ResultSet rs = iUserDao.searchSentByUId(userId);
        List<Complain> complainList = new ArrayList<Complain>();
        try {
            while (rs.next()) {
                int complainId = rs.getInt("complainId");
                String complainuserId = rs.getString("complainuserId");
                String complainTitle = rs.getString("complainTitle");
                String complainContent = rs.getString("complainContent");
                Complain complain = new Complain();
                complain.setComplainId(complainId);
                complain.setComplainuserId(complainuserId);
                complain.setComplainTitle(complainTitle);
                complain.setComplainContent(complainContent);
                complainList.add(complain);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return complainList;
    }

    @Override
    public Reply searchReplyByRId(int ReplyId) {
        ResultSet rs=iUserDao.searchReplyByRId(ReplyId);
        //List<Reply> replyList=new ArrayList<Reply>();
        Reply reply=new Reply();
        try {
            //while (rs.next()){
            rs.first();
            int replyId=rs.getInt("replyId");
            int replycomplainId=rs.getInt("replycomplainId");
            String replyuserId=rs.getString("replyuserId");
            String replyTitle=rs.getString("replyTitle");
            String replyContent=rs.getString("replyContent");
            reply.setReplyId(replyId);
            reply.setReplycomplainId(replycomplainId);
            reply.setReplyuserId(replyuserId);
            reply.setReplyTitle(replyTitle);
            reply.setReplyContent(replyContent);
            //replyList.add(reply);
            // }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return replyList;
        return reply;
    }

    @Override
    public Complain searchSentByCId(int ComplainId) {
        ResultSet rs=iUserDao.searchSentByCId(ComplainId);
        // List<Complain> complainList = new ArrayList<Complain>();
        Complain complain = new Complain();
        try {
            rs.first();
            int complainId = rs.getInt("complainId");
            String complainuserId = rs.getString("complainuserId");
            String complainTitle = rs.getString("complainTitle");
            String complainContent = rs.getString("complainContent");
            complain.setComplainId(complainId);
            complain.setComplainuserId(complainuserId);
            complain.setComplainTitle(complainTitle);
            complain.setComplainContent(complainContent);
            //complainList.add(complain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return complain;
    }

    @Override
    public boolean searchlogoutByUId(String userId) {
        System.out.println(iUserDao.searchLogoutByUId(userId));
            return iUserDao.searchLogoutByUId(userId);
    }
}
