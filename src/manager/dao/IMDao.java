package manager.dao;

import manager.model.Publish;
import user.model.Reply;

import java.sql.ResultSet;

/**
 * Created by lenovo on 2017/7/10.
 */
public interface IMDao {
    public boolean addpublishs(Publish publish);
    public ResultSet getReplys();
    public ResultSet getComplains();
    public ResultSet searchReplyByRId(int replyId);
    public ResultSet searchSentByCId(int complainId);
    public boolean addReplys(Reply reply);
}
