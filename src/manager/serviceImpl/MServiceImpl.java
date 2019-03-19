package manager.serviceImpl;

import manager.dao.IMDao;
import manager.daoImpl.MDaoImpl;
import manager.model.Publish;
import manager.service.IMService;
import user.model.Complain;
import user.model.Reply;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/7/10.
 */
public class MServiceImpl implements IMService {
    IMDao imDao=new MDaoImpl();
    @Override
    public boolean addPublishs(Publish publish) {
        System.out.println("--do MServiceImpl--");
        if(imDao.addpublishs(publish))
            return true;
        else
            return false;
    }

    @Override
    public List<Reply> getReplys() {
        ResultSet rs=imDao.getReplys();
        List<Reply> replyList=new ArrayList<Reply>();
        try {
            while (rs.next()){
                int replyId=rs.getInt("replyId");
                int replycomplainId=rs.getInt("replycomplainId");
                String replyuserId=rs.getString("replyuserId");
                String replyTitle=rs.getString("replyTitle");
                String replyContent=rs.getString("replyContent");
                Reply reply=new Reply();
                reply.setReplyId(replyId);
                reply.setReplycomplainId(replycomplainId);
                reply.setReplyuserId(replyuserId);
                reply.setReplyTitle(replyTitle);
                reply.setReplyContent(replyContent);
                replyList.add(reply);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return replyList;
    }

    @Override
    public List<Complain> getComplains() {
        ResultSet rs=imDao.getComplains();
        List<Complain> complainList = new ArrayList<Complain>();
        try {
            while (rs.next()) {
                int complainId = rs.getInt("complainId");
                String complainuserId = rs.getString("complainuserId");
                String complainTitle = rs.getString("complainTitle");
                String complainContent = rs.getString("complainContent");
                Complain complain = new Complain();
                complain.setComplainId(complainId);
                complain.setComplainuserId(complainuserId);
                complain.setComplainTitle(complainTitle);
                complain.setComplainContent(complainContent);
                complainList.add(complain);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return complainList;
    }

    @Override
    public Reply searchReplyByRId(int ReplyId) {
        ResultSet rs=imDao.searchReplyByRId(ReplyId);
        //List<Reply> replyList=new ArrayList<Reply>();
        Reply reply=new Reply();
        try {
            //while (rs.next()){
            rs.first();
            int replyId=rs.getInt("replyId");
            int replycomplainId=rs.getInt("replycomplainId");
            String replyuserId=rs.getString("replyuserId");
            String replyTitle=rs.getString("replyTitle");
            String replyContent=rs.getString("replyContent");
            reply.setReplyId(replyId);
            reply.setReplycomplainId(replycomplainId);
            reply.setReplyuserId(replyuserId);
            reply.setReplyTitle(replyTitle);
            reply.setReplyContent(replyContent);
            //replyList.add(reply);
            // }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return replyList;
        return reply;
    }

    @Override
    public Complain searchSentByCId(int ComplainId) {
        ResultSet rs=imDao.searchSentByCId(ComplainId);
        // List<Complain> complainList = new ArrayList<Complain>();
        Complain complain = new Complain();
        try {
            rs.first();
            int complainId = rs.getInt("complainId");
            String complainuserId = rs.getString("complainuserId");
            String complainTitle = rs.getString("complainTitle");
            String complainContent = rs.getString("complainContent");
            complain.setComplainId(complainId);
            complain.setComplainuserId(complainuserId);
            complain.setComplainTitle(complainTitle);
            complain.setComplainContent(complainContent);
            //complainList.add(complain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return complain;
    }

    @Override
    public boolean addReplys(Reply reply) {
        if(imDao.addReplys(reply))
            return true;
        else
            return false;
    }
}
