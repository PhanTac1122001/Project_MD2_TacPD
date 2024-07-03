package business.feature.impl;

import business.entity.Category;
import business.feature.ICategoryFeature;
import business.utils.IOFileCategory;

import java.util.ArrayList;
import java.util.List;

public class CategoryFeatureImpl implements ICategoryFeature {

    public static List<Category> categoryList=new ArrayList<>();

    public CategoryFeatureImpl() {
        categoryList = IOFileCategory.readFromFile(IOFileCategory.PATH_CATEGORY);
    }


    @Override
    public void saveOrUpdate(Category category) {
        int indexCheck = findIndexById(category.getCategoryId());
        if (indexCheck < 0) {
            // chức năng thêm mới
            categoryList.add(category);
            System.out.println("Add successfully");
        } else {
            // chức năng cập nhật
            categoryList.set(indexCheck, category);
            System.out.println("Update successfully");
        }
        IOFileCategory.writeToFile(IOFileCategory.PATH_CATEGORY,categoryList);
    }

    @Override
    public void deleteById(int idDelete) {
        int indexDelete = findIndexById(idDelete);
        if (indexDelete >= 0) {
            categoryList.remove(indexDelete);
            System.out.println("Delete successfully");
            IOFileCategory.writeToFile(IOFileCategory.PATH_CATEGORY,categoryList);
        } else {
            System.err.println("ID does not exist = " + idDelete);
        }
    }

    @Override
    public int findIndexById(int idFind) {
        for (int i = 0; i < categoryList.size(); i++) {
            if (categoryList.get(i).getCategoryId() == idFind) {
                return i;
            }
        }
        return -1;
    }
}
