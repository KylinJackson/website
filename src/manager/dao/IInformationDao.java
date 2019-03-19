package manager.dao;

import java.sql.ResultSet;

public interface IInformationDao {
    public ResultSet getInformation();
    public ResultSet searchInformationByFlag(int flag);
    public ResultSet searchInformationByNum(int flag);
}