package manager.service;

import manager.model.Manager;

import java.util.List;

public interface IManagerService {
    public List<Manager> getManagers();
    public boolean alterManager(Manager manager);
    public List<Manager> searchManagerByType(String typeId);
    public boolean verifyPassword(String managerId, String password);
    public boolean changePassword(String managerId, String password);
}
