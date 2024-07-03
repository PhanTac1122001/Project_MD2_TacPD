package business.feature;

import business.entity.Category;

import java.util.List;

public interface ICategoryFeature {



    void saveOrUpdate(Category category);

    void deleteById(int idDelete);

    int findIndexById(int idFind);
}
