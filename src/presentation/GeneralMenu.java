package presentation;

import business.entity.Category;
import business.entity.Products;
import business.feature.ICategoryFeature;
import business.feature.IProductFeature;
import business.feature.impl.CategoryFeatureImpl;
import business.feature.impl.ProductFeatureImpl;

import java.util.Comparator;
import java.util.Scanner;

public class GeneralMenu {
    private static final ICategoryFeature categoryFeature=new CategoryFeatureImpl();
    private static final IProductFeature productFeature =new ProductFeatureImpl();
    public static void menuGeneral(Scanner scanner) {

        boolean isLoop = true;
        do {
            System.out.println("================== MENU AUTHOR ==================\n" +
                    "1.\tChi tiết thông tin sản phẩm theo id\n" +
                    "2.\tDanh sách sản phẩm theo danh mục\n" +
                    "3.\tDanh sách sản phẩm mới\n" +
                    "4.\tDanh sách sản phẩm được bán\n" +
                    "5.\tTìm kiếm sản phẩm theo tên hoặc mô tả\n" +
                    "6.\tBack\n");
            System.out.println("Please enter: ");
            int choice = inputNumber(scanner);
            switch (choice) {
                case 1:
                    showIdProduct(scanner);
                    break;
                case 2:
                    showProductByCategory(scanner);
                    break;
                case 3:
                    showProductNew(scanner);
                    break;
                case 4:
                    showAllProduct(scanner);
                    break;
                case 5:
                    searchProduct(scanner);
                    break;
                case 6:
                    isLoop = false;
                    break;
                default:
                    System.err.println("Please re-enter 1 -> 8");
            }
        } while (isLoop);

    }

    private static void showIdProduct(Scanner scanner) {
        if (ProductFeatureImpl.productsList.isEmpty()) {
            System.err.println("Empty list");
            return;
        }
        boolean hasProduct=false;
        System.out.println("Enter the ID you want to search:");
        int searchProductId=inputNumber(scanner);

        for (Products products:ProductFeatureImpl.productsList){
            if(products.getProductId()==searchProductId){
                hasProduct=true;
                products.displayData();
            }
        }
        if(!hasProduct){
            System.err.println("ID not found : " + searchProductId);
        }
    }

    private static void showProductNew(Scanner scanner) {
        if(ProductFeatureImpl.productsList.isEmpty()){
            System.err.println("Danh sách trống");
        }else {
            ProductFeatureImpl.productsList.sort(Comparator.comparing(Products::getCreatedAt).reversed());
            for (Products products:ProductFeatureImpl.productsList){
                products.displayData();
            }
        }
    }

    private static void showProductByCategory(Scanner scanner) {
        for (Category category : CategoryFeatureImpl.categoryList) {

            System.out.printf("[ ID: %d | Name: %s ]\n", category.getCategoryId(), category.getCategoryName());
        }
            int categoryId = inputNumber(scanner);
        int count=0;
            for (Products products:ProductFeatureImpl.productsList){
                if (categoryId == products.getCategoryId().getCategoryId()) {
                    products.displayData();
                    count++;
                }
            }
        System.out.println("Có "+ count+ " sản phẩm.");
    }

    private static void showAllProduct(Scanner scanner) {
        if(ProductFeatureImpl.productsList.isEmpty()){
            System.err.println("Danh sách trống");
        }else {
            for (Products products:ProductFeatureImpl.productsList){
                if (products.getStockQuantity()>=0){
                    products.displayData();

                }
            }
        }
    }

    private static void searchProduct(Scanner scanner) {
        if (ProductFeatureImpl.productsList.isEmpty()) {
            System.err.println("Empty list");
            return;
        }
        boolean hasProduct=false;
        System.out.println("Mời bạn nhập tên hoặc mô tả sản phẩm muốn tìm kiếm:");
        String searchProduct=scanner.nextLine();

        for (Products products:ProductFeatureImpl.productsList){
            if(products.getProductName().toLowerCase().contains(searchProduct)||products.getDescription().toLowerCase().contains(searchProduct)){
                hasProduct=true;
                products.displayData();
            }
        }
        if(!hasProduct){
            System.err.println("ID not found : " + searchProduct);
        }
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
