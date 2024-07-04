package business.feature;

import business.entity.Category;
import business.entity.User;

public interface IUserFeature {

    void saveOrUpdate(User user);

    void deleteById(int idDelete);

    int findIndexById(int idFind);
}
