package manager.model;

/**
 * Created by lenovo on 2017/7/10.
 */
public class Publish {
    public int publishId;
    public int publishcolumnsId;
    public String publishTitle;
    public String publishContent;
    public String publishTime;
    public Publish(){

    }

    public Publish(int publishId, int publishcolumnsId, String publishTitle, String publishContent, String publishTime){
        super();
        this.publishId=publishId;
        this.publishcolumnsId=publishcolumnsId;
        this.publishTitle=publishTitle;
        this.publishContent=publishContent;
        this.publishTime=publishTime;
    }

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

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }
}
