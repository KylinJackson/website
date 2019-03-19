package manager.model;

public class Manager {
    String manageId;
    String manageName;
    String managePassword;
    String manageSex;
    String manageTel;
    String manageEmail;
    public Manager() {

    }

    public Manager(String manageId,String manageName,String managePassword,String manageSex,String manageTel,String manageEmail) {
        super();
        this.manageId = manageId;
        this.manageName = manageName;
        this.managePassword = managePassword;
        this.manageSex = manageSex;
        this.manageTel = manageTel;
        this.manageEmail = manageEmail;
    }

    public String getManageId() {
        return manageId;
    }

    public void setManageId(String manageId) {
        this.manageId = manageId;
    }

    public String getManageName() {
        return manageName;
    }

    public void setManageName(String manageName) {
        this.manageName = manageName;
    }

    public String getManagePassword() {
        return managePassword;
    }

    public void setManagePassword(String managePassword) {
        this.managePassword = managePassword;
    }

    public String getManageSex() {
        return manageSex;
    }

    public void setManageSex(String manageSex) {
        this.manageSex = manageSex;
    }

    public String getManageTel() {
        return manageTel;
    }

    public void setManageTel(String manageTel) {
        this.manageTel = manageTel;
    }

    public String getManageEmail() {
        return manageEmail;
    }

    public void setManageEmail(String manageEmail) {
        this.manageEmail = manageEmail;
    }



}
