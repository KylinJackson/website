package manager.serviceImpl;

import manager.dao.IInformationDao;
import manager.daoImpl.InformationDaoImpl;
import manager.model.Publish;
import manager.service.IInformationService;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//业务层专门处理业务
public class IInformationServiceImpl implements IInformationService {
    //服务层调用Dao层
    IInformationDao iInformationDao = new InformationDaoImpl();

    @Override
    public List<Publish> getInformation() {
        System.out.println("---do informationserviceImpl---");
        ResultSet rs = iInformationDao.getInformation();
        //取结果集中的直
        List<Publish> publishList = new ArrayList<Publish>();
        try {
            while (rs.next()) {
                int publishcolumnsid = rs.getInt("publishcolumnsId");
                String publishtitle = rs.getString("publishTitle");
                int publishid = rs.getInt("publishId");
                String publishcontent = rs.getString("publishContent");
                String publishtime = rs.getString("publishTime");
                //将每一行直放入javaBean中
                Publish publish = new Publish();
                publish.setPublishId(publishid);
                publish.setPublishcolumnsId(publishcolumnsid);
                publish.setPublishTitle(publishtitle);
                publish.setPublishContent(publishcontent);
                publish.setPublishTime(publishtime);
                //将获取的javaBean对象放入集合中
                publishList.add(publish);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return publishList;
    }

    @Override
    public List<Publish> searchInformationByFlag(int flag) {
        ResultSet rs = iInformationDao.searchInformationByFlag(flag);
        List<Publish> publishList = new ArrayList<Publish>();
        try {
            while (rs.next()) {
                int publishcolumnsid = rs.getInt("publishcolumnsId");
                String publishtitle = rs.getString("publishTitle");
                String publishcontent = rs.getString("publishContent");
                int publishid = rs.getInt("publishId");
                String publishtime = rs.getString("publishTime");
                //将每一行直放入javaBean中
                Publish publish = new Publish();
                publish.setPublishId(publishid);
                publish.setPublishcolumnsId(publishcolumnsid);
                publish.setPublishTitle(publishtitle);
                publish.setPublishContent(publishcontent);
                publish.setPublishTime(publishtime);
                //将获取的javaBean对象放入集合中
                publishList.add(publish);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return publishList;
    }
    @Override
    public List<Publish> searchInformationByNum(int flag) {
        ResultSet rs = iInformationDao.searchInformationByNum(flag);
        List<Publish> publishList = new ArrayList<Publish>();
        try {
            while (rs.next()) {
                int publishid = rs.getInt("publishId");
                int publishcolumnsid = rs.getInt("publishcolumnsId");
                String publishtitle = rs.getString("publishTitle");
                String publishcontent = rs.getString("publishContent");
                String publishtime = rs.getString("publishTime");
                //将每一行直放入javaBean中
                Publish publish = new Publish();
                publish.setPublishId(publishid);
                publish.setPublishcolumnsId(publishcolumnsid);
                publish.setPublishTitle(publishtitle);
                publish.setPublishContent(publishcontent);
                publish.setPublishTime(publishtime);
                //将获取的javaBean对象放入集合中
                publishList.add(publish);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return publishList;
    }
}
