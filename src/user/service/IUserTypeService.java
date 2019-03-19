package user.service;

import user.model.Publish;

import java.util.List;

/**
 * Created by kylin on 17-7-11.
 */
public interface IUserTypeService {
    public List<Publish> showArticlesByType(int type);
    public Publish showArticlesById(int publishId);
}
