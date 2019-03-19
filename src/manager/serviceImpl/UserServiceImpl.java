package manager.serviceImpl;

import manager.dao.IUserDao;
import manager.daoImpl.UserDaoImpl;
import manager.model.User;
import manager.service.IUserService;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements IUserService {
    IUserDao iUserDao=new UserDaoImpl();

    @Override
    public List<User> getUsers() {
        ResultSet rs=iUserDao.getUsers();
        List<User> userList = new ArrayList<User>();

        try {
            while (rs.next()){
                String id=rs.getString("userId");
                String name=rs.getString("userName");
                String password=rs.getString("userPassword");
                String sex=rs.getString("userSex");
                String telephone=rs.getString("userTel");
                String email=rs.getString("userEmail");
                String freeze = rs.getString("userFreeze");

                User user=new User();
                user.setUserId(id);
                user.setUserName(name) ;
                user.setUserPassword(password);
                user.setUserSex(sex);
                user.setUserTel(telephone);
                user.setUserEmail(email);
                user.setUserFreeze(freeze);

                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public boolean alterUser(User user) {
        if(iUserDao.alterUser(user))
            return true;
        else
            return false;
    }

    @Override
    public boolean freezeUserById(String userId) {
       return iUserDao.freezeUserById(userId);
    }
    @Override
    public boolean cancelFreezeById(String userId) {
        return iUserDao.cancelFreezeById(userId);
    }
    @Override
    public List<User> searchUserByType(String typeId) {
      ResultSet rs = iUserDao.searchUserByType(typeId);
      List<User> userList = new ArrayList<User>();
      try {
          while(rs.next()) {
              String userid = rs.getString("userId");
              String username = rs.getString("userName");
              String userpassword = rs.getString("userPassword");
              String usersex = rs.getString("userSex");
              String usertelephone = rs.getString("userTel");
              String useremail = rs.getString("userEmail");
              String userfreeze = rs.getString("userFreeze");
              User user = new User();
              user.setUserId(userid);
              user.setUserName(username);
              user.setUserPassword(userpassword);
              user.setUserSex(usersex);
              user.setUserTel(usertelephone);
              user.setUserEmail(useremail);
              user.setUserFreeze(userfreeze);
              userList.add(user);
          }
      } catch (Exception e) {
          e.printStackTrace();
      }
      return userList;
    }
}

