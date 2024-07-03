package business.feature;

import business.entity.Category;
import business.entity.Products;

public interface IProductFeature {
    void saveOrUpdate(Products products);

    void deleteById(int idDelete);

    int findIndexById(int idFind);
}
