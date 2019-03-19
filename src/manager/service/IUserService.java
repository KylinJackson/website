package manager.service;

import manager.model.User;

import java.util.List;

public interface IUserService {
    public List<User> getUsers();
    public boolean alterUser(User user);
    public boolean freezeUserById(String userId);
    public boolean cancelFreezeById(String userId);
    public List<User> searchUserByType(String typeId);
}