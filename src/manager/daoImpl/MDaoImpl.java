package manager.daoImpl;

import manager.dao.IMDao;
import manager.model.Publish;
import user.model.Reply;
import user.util.DBUtil;

import java.sql.ResultSet;

/**
 * Created by lenovo on 2017/7/10.
 */
public class MDaoImpl implements IMDao {
    ResultSet rs=null;
    DBUtil db=new DBUtil();
    @Override
    public boolean addpublishs(Publish publish) {
        System.out.println("--do MDaoImpl--");
        String sql="insert into publish(publishId,publishcolumnsId,publishTitle,publishContent,publishTime) values('"+publish.getPublishId()+"','"+publish.getPublishcolumnsId()+"','"+publish.getPublishTitle()+"','"+publish.getPublishContent()+"','"+publish.getPublishTime()+"')";
        try {
            if(db.Update(sql))
            {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ResultSet getReplys() {
        String sql="select * from reply order by replyId desc";
        try {
            rs=db.queryData(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public ResultSet getComplains() {
        String sql="select * from complain order by complainId desc";
        try {
            rs=db.queryData(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet searchReplyByRId(int replyId) {
        String sql="select * from reply where replyId='"+replyId+"'";
        rs=null;
        try {
            rs=db.queryData(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public ResultSet searchSentByCId(int complainId) {
        String sql="select * from complain where complainId='"+complainId+"'";
        rs=null;
        try {
            rs=db.queryData(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean addReplys(Reply reply) {
        String sql="insert into reply(replyId,replycomplainId,replyuserId,replyTitle,replyContent) values('"+reply.replyId+"','"+reply.replycomplainId+"','"+reply.replyuserId+"','"+reply.replyTitle+"','"+reply.replyContent+"')";
        try {
            if(db.Update(sql))
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
