package user.model;

/**
 * Created by lenovo on 2017/7/9.
 */
public class Complain {
    public int complainId;
    public String complainuserId;
    public String complainTitle;
    public String complainContent;
    public Complain(){

    }
    public Complain(int complainId,String complainuserId,String complainTitle,String complainContent){
        super();
        this.complainId=complainId;
        this.complainuserId=complainuserId;
        this.complainTitle=complainTitle;
        this.complainContent=complainContent;
    }

    public int getComplainId() {
        return complainId;
    }

    public void setComplainId(int complainId) {
        this.complainId = complainId;
    }

    public String getComplainuserId() {
        return complainuserId;
    }

    public void setComplainuserId(String complainuserId) {
        this.complainuserId = complainuserId;
    }

    public String getComplainTitle() {
        return complainTitle;
    }

    public void setComplainTitle(String complainTitle) {
        this.complainTitle = complainTitle;
    }

    public String getComplainContent() {
        return complainContent;
    }

    public void setComplainContent(String complainContent) {
        this.complainContent = complainContent;
    }
}
