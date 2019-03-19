package user.model;

import java.util.Date;

/*
 * Created by kylin on 17-7-9.
 */
public class Publish {
    private int publishId;
    private int publishcolumnsId;
    private String publishTitle;
    private String publishContent;
    private Date publishTime;

    public int getPublishId() {
        return publishId;
    }

    public void setPublishId(int publishId) {
        this.publishId = publishId;
    }

    public int getPublishcolumnsId() {
        return publishcolumnsId;
    }

    public void setPublishcolumnsId(int publishcolumnsId) {
        this.publishcolumnsId = publishcolumnsId;
    }

    public String getPublishTitle() {
        return publishTitle;
    }

    public void setPublishTitle(String publishTitle) {
        this.publishTitle = publishTitle;
    }

    public String getPublishContent() {
        return publishContent;
    }

    public void setPublishContent(String publishContent) {
        this.publishContent = publishContent;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
}
