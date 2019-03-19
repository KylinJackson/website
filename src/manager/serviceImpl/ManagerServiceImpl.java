package manager.serviceImpl;

import manager.dao.IManagerDao;
import manager.daoImpl.ManagerDaoImpl;
import manager.model.Manager;
import manager.service.IManagerService;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ManagerServiceImpl implements IManagerService {
    IManagerDao iManagerDao = new ManagerDaoImpl();
    @Override
    public List<Manager> searchManagerByType(String typeId) {
        ResultSet rs;
        rs = iManagerDao.searchManagerByType(typeId);
        List<Manager> managerList = new ArrayList<Manager>();
        try {
            while (rs.next()){
                String manageid = rs.getString("manageId");
                String managename = rs.getString("manageName");
                String managepassword = rs.getString("managePassword");
                String managesex = rs.getString("manageSex");
                String managetel = rs.getString("manageTel");
                String manageemail = rs.getString("manageEmail");
                Manager manager = new Manager();
                manager.setManageId(manageid);
                manager.setManageName(managename);
                manager.setManagePassword(managepassword);
                manager.setManageSex(managesex);
                manager.setManageTel(managetel);
                manager.setManageEmail(manageemail);
                managerList.add(manager);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return managerList;
    }

    @Override
    public List<Manager> getManagers() {
        ResultSet rs=iManagerDao.getManagers();
        List<Manager> manageList = new ArrayList<Manager>();

        try {
            while (rs.next()){
                String manageid = rs.getString("manageId");
                String managename = rs.getString("manageName");
                String managepassword = rs.getString("managePassword");
                String managesex = rs.getString("manageSex");
                String managetel = rs.getString("manageTel");
                String manageemail = rs.getString("manageEmail");
                Manager manager = new Manager();
                manager.setManageId(manageid);
                manager.setManageName(managename);
                manager.setManagePassword(managepassword);
                manager.setManageSex(managesex);
                manager.setManageTel(managetel);
                manager.setManageEmail(manageemail);
                manageList.add(manager);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return manageList;
    }

    @Override
    public boolean alterManager(Manager manager) {
        return iManagerDao.alterManager(manager);
    }

    @Override
    public boolean verifyPassword(String managerId, String password) {
        return iManagerDao.verifyPassword(managerId, password);
    }

    @Override
    public boolean changePassword(String managerId, String password) {
        return iManagerDao.changePassword(managerId, password);
    }
}
