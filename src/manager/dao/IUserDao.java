package manager.dao;

import manager.model.User;

import java.sql.ResultSet;

public interface IUserDao {
    public ResultSet getUsers();
    public boolean alterUser(User user);
    public boolean freezeUserById(String userId);
    public boolean cancelFreezeById(String userId);
    public ResultSet searchUserByType(String typeId);
}