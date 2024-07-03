package presentation;

import business.entity.Category;
import business.entity.Products;
import business.feature.ICategoryFeature;
import business.feature.IProductFeature;
import business.feature.impl.CategoryFeatureImpl;
import business.feature.impl.ProductFeatureImpl;

import java.util.Scanner;

public class AdminMenu {

    private static final ICategoryFeature categoryFeature=new CategoryFeatureImpl();
    private static final IProductFeature productFeature =new ProductFeatureImpl();
    public static void menuAdmin(Scanner scanner) {
        boolean isLoop = true;
        do {
            System.out.println("================== MENU AUTHOR ==================\n" +
                    "1.\tGet a list of all products\n" +
                    "2.\tAdd new product\n" +
                    "3.\tGet a list of all categories\n" +
                    "4.\tGet category information by id\n" +
                    "5.\tAdd new category\n" +
                    "6.\tEdit category information\n" +
                    "7.\tDelete category\n" +
                    "8.\tBack\n");
            System.out.println("Please enter: ");
            int choice = inputNumber(scanner);
            switch (choice) {
                case 1:
                    showAllProduct();
                    break;
                case 2:
                    addProduct(scanner);
                    break;
                case 3:
                    showAllCategory();
                    break;
                case 4:
                    showByIdCategory(scanner);
                    break;
                case 5:
                    addCategory(scanner);
                    break;
                case 6:
                    updateCategory(scanner);
                    break;
                case 7:
                    deleteCategory(scanner);
                    break;
                case 8:
                    isLoop = false;
                    break;
                default:
                    System.err.println("Please re-enter 1 -> 8");
            }
        } while (isLoop);

    }

    private static void showByIdCategory(Scanner scanner) {
        if (CategoryFeatureImpl.categoryList.isEmpty()) {
            System.err.println("Empty list");
            return;
        }
        boolean hasCategory=false;
        System.out.println("Enter the ID you want to search:");
        int searchCategory=inputNumber(scanner);

        for (Category category:CategoryFeatureImpl.categoryList){
            if(category.getCategoryId()==searchCategory){
                hasCategory=true;
                category.displayData();
            }
        }
        if(!hasCategory){
            System.err.println("ID not found : " + searchCategory);
        }

    }

    private static void addProduct(Scanner scanner) {
        System.out.println("Enter the quantity you want to add to the product: ");
        int number = inputNumber(scanner);
        for (int i = 0; i < number; i++) {
                Products products = new Products();
            products.inputData(scanner);
            productFeature.saveOrUpdate(products);
        }
    }

    private static void showAllProduct() {
        if (ProductFeatureImpl.productsList.isEmpty()) {
            System.err.println("Empty list");
            return;
        }
        // method referance
        ProductFeatureImpl.productsList.forEach(Products::displayData);
    }

    private static void deleteCategory(Scanner scanner) {
        System.out.println("Enter the ID you want to delete: ");
        int idDelete = inputNumber(scanner);
        categoryFeature.deleteById(idDelete);
    }

    private static void updateCategory(Scanner scanner) {
        System.out.println("Enter the ID you want to update: ");
        int idUpdate = inputNumber(scanner);
        int indexUpdate = categoryFeature.findIndexById(idUpdate);
        if (indexUpdate < 0) {
            System.err.println("ID does not exist = " + idUpdate);
            return;
        }
        Category categoryUpdate = CategoryFeatureImpl.categoryList.get(indexUpdate);
        boolean isLoop = true;
        do {
            System.out.println("1. Update Category Name");
            System.out.println("2. Update Description");
            System.out.println("3. Update Status");
            System.out.println("4. Back");
            System.out.println("Your choice: ");
            int choice = inputNumber(scanner);
            switch (choice) {
                case 1:
                    categoryUpdate.setCategoryName(categoryUpdate.inputCategoryName(scanner));
                    break;
                case 2:
                    categoryUpdate.setDescription(categoryUpdate.inputDescription(scanner));
                    break;
                case 3:
                    categoryUpdate.setStatus(categoryUpdate.inputStatus(scanner));
                    break;
                case 4:
                    isLoop = false;
                    break;
                default:
                    System.err.println("Please re-enter 1 -> 4");
            }
        } while (isLoop);
    }

    private static void addCategory(Scanner scanner) {
        System.out.println("Enter the quantity you want to add to the category: ");
        int number = inputNumber(scanner);
        for (int i = 0; i < number; i++) {
            Category category = new Category();
            category.inputData(scanner);
            categoryFeature.saveOrUpdate(category);
        }
    }

    private static void showAllCategory() {
        if (CategoryFeatureImpl.categoryList.isEmpty()) {
            System.err.println("Empty list");
            return;
        }

        CategoryFeatureImpl.categoryList.forEach(Category::displayData);
    }
    public static int inputNumber(Scanner scanner) {
        do {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Please enter number");
            }
        } while (true);
    }
}
