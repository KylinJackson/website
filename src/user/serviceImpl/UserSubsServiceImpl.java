package user.serviceImpl;

import user.dao.IUserSubsDao;
import user.daoImpl.UserSubsDaoImpl;
import user.service.IUserSubsService;

import java.util.Date;

/**
 * Created by kylin on 17-7-9.
 */
public class UserSubsServiceImpl implements IUserSubsService {

    private IUserSubsDao iUserSubsDao = new UserSubsDaoImpl();
    @Override
    public boolean sub(String userId, int type) {
        return iUserSubsDao.sub(userId, type);
    }

    @Override
    public Date logoutTime(String userId) {
        return iUserSubsDao.logoutTime(userId);
    }

    @Override
    public boolean cancel(String userId, int type) {
        return iUserSubsDao.cancel(userId, type);
    }
}
