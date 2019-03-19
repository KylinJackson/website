package user.serviceImpl;

import user.dao.IUserLogoutDao;
import user.daoImpl.UserLogoutDaoImpl;
import user.service.IUserLogoutService;

/**
 * Created by kylin on 17-7-9.
 */
public class UserLogoutServiceImpl implements IUserLogoutService {

    private IUserLogoutDao iUserLogoutDao = new UserLogoutDaoImpl();
    @Override
    public boolean logout(String userId) {
        return iUserLogoutDao.logout(userId);
    }
}
