package manager.service;

import manager.model.Publish;

import java.util.List;

public interface IInformationService {
    public List<Publish> getInformation();
    public List<Publish> searchInformationByFlag(int flag);
    public List<Publish> searchInformationByNum(int flag);
}
