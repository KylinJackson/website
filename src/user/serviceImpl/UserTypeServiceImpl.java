package user.serviceImpl;

import user.dao.IUserTypeDao;
import user.daoImpl.UserTypeDaoImpl;
import user.model.Publish;
import user.service.IUserTypeService;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kylin on 17-7-11.
 */
public class UserTypeServiceImpl implements IUserTypeService {
    IUserTypeDao iUserTypeDao = new UserTypeDaoImpl();

    @Override
    public List<Publish> showArticlesByType(int type) {
        ResultSet resultSet = iUserTypeDao.showArticlesByType(type);
        List<Publish> publishList = new ArrayList<Publish>();
        try {
            while(resultSet.next()) {
                Publish publish = new Publish();
                publish.setPublishId(resultSet.getInt(1));
                publish.setPublishcolumnsId(resultSet.getInt(2));
                publish.setPublishTitle(resultSet.getString(3));
                publish.setPublishContent(resultSet.getString(4));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                publish.setPublishTime(simpleDateFormat.parse(resultSet.getString(5)));
                publishList.add(publish);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return publishList;
    }

    @Override
    public Publish showArticlesById(int publishId) {
        ResultSet resultSet = iUserTypeDao.showArticlesById(publishId);
        Publish publish = new Publish();
        try {
            resultSet.first();
            publish.setPublishId(resultSet.getInt(1));
            publish.setPublishcolumnsId(resultSet.getInt(2));
            publish.setPublishTitle(resultSet.getString(3));
            publish.setPublishContent(resultSet.getString(4));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            publish.setPublishTime(simpleDateFormat.parse(resultSet.getString(5)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return publish;
    }
}
