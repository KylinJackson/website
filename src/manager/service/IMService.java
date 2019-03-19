package manager.service;

import manager.model.Publish;
import user.model.Complain;
import user.model.Reply;

import java.util.List;

/**
 * Created by lenovo on 2017/7/10.
 */
public interface IMService {
    public boolean addPublishs(Publish publish);
    public List<Reply> getReplys();
    public List<Complain> getComplains();
    public Reply searchReplyByRId(int ReplyId);
    public Complain searchSentByCId(int ComplainId);
    public boolean addReplys(Reply reply);
}
