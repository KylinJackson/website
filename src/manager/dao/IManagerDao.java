package manager.dao;

import manager.model.Manager;

import java.sql.ResultSet;

public interface IManagerDao {
    public ResultSet getManagers();
    public boolean alterManager(Manager manager);
    public ResultSet searchManagerByType(String typeId);
    public boolean verifyPassword(String managerId, String password);
    public boolean changePassword(String managerId, String password);
}