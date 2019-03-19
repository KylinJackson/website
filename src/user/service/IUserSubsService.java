package user.service;
import java.util.Date;
/**
 * Created by kylin on 17-7-9.
 */
public interface IUserSubsService {
    public boolean sub(String userId, int type);
    public Date logoutTime(String userId);
    public boolean cancel(String userId, int type);
}
