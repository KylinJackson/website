package manager.serviceImpl;

import manager.dao.ILoginDao;
import manager.daoImpl.LoginDaoImpl;
import manager.service.ILoginService;

public class LoginServiceImpl implements ILoginService {
    @Override
    public boolean isLogin(String managerid, String pwd) {
        //服务层调用dao层
        ILoginDao iLoginDao=new LoginDaoImpl();
        boolean islogin=iLoginDao.isLogin(managerid,pwd);
        return islogin;
    }
}