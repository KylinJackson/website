package user.model;

/**
 * Created by lenovo on 2017/7/9.
 */
public class Reply {
    public int replyId;
    public int replycomplainId;
    public String replyuserId;
    public String replyTitle;
    public String replyContent;
    public Reply(){

    }
    public Reply(int replyId, int replycomplainId, String replyuserId, String replyTitle, String replyContent){
        super();
        this.replyId=replyId;
        this.replycomplainId=replycomplainId;
        this.replyuserId=replyuserId;
        this.replyTitle=replyTitle;
        this.replyContent=replyContent;
    }

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public int getReplycomplainId() {
        return replycomplainId;
    }

    public void setReplycomplainId(int replycomplainId) {
        this.replycomplainId = replycomplainId;
    }

    public String getReplyuserId() {
        return replyuserId;
    }

    public void setReplyuserId(String replyuserId) {
        this.replyuserId = replyuserId;
    }

    public String getReplyTitle() {
        return replyTitle;
    }

    public void setReplyTitle(String replyTitle) {
        this.replyTitle = replyTitle;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }
}
