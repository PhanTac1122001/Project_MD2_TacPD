package business.feature.impl;

import business.entity.Category;
import business.entity.Products;
import business.feature.IProductFeature;
import business.utils.IOFileCategory;
import business.utils.IOFileProduct;

import java.util.ArrayList;
import java.util.List;

public class ProductFeatureImpl implements IProductFeature {
    public static List<Products> productsList = new ArrayList<>();
    public ProductFeatureImpl() {
        productsList = IOFileProduct.readFromFile(IOFileProduct.PATH_PRODUCT);
    }
    @Override
    public void saveOrUpdate(Products products) {
        int indexCheck = findIndexById(products.getProductId());
        if (indexCheck < 0) {
            // chức năng thêm mới
            productsList.add(products);
            System.out.println("Add successfully");
        } else {
            // chức năng cập nhật
            productsList.set(indexCheck, products);
            System.out.println("Update successfully");
        }
        IOFileProduct.writeToFile(IOFileProduct.PATH_PRODUCT,productsList);
    }

    @Override
    public void deleteById(int idDelete) {

    }

    @Override
    public int findIndexById(int idFind) {
        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i).getProductId() == idFind) {
                return i;
            }
        }
        return -1;
    }
}
