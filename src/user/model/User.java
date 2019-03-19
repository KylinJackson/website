package user.model;

/**
 * Created by lenovo on 2017/7/8.
 */
public class User {
    public String userId;
    public String userName;
    public String userPassword;
    public String userSex;
    public String userTel;
    public String userEmail;
    public String userFreeze;
    public User(){

    }
    public User(String userId, String userName, String userPassword, String userSex, String userTel, String userEmail, String userFreeze){
        super();
        this.userId=userId;
        this.userName=userName;
        this.userPassword=userPassword;
        this.userSex=userSex;
        this.userTel=userTel;
        this.userEmail=userEmail;
        this.userFreeze=userFreeze;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserFreeze() {
        return userFreeze;
    }

    public void setUserFreeze(String userFreeze) {
        this.userFreeze = userFreeze;
    }
}
