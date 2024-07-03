package business.entity;

import business.feature.impl.CategoryFeatureImpl;

import java.io.Serializable;
import java.util.Scanner;

public class Category implements Serializable {
    private int categoryId;
    private String categoryName;
    private String description;
    private boolean status;

    public Category() {
    }

    public Category(int categoryId, String categoryName, String description, boolean status) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.status = status;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner scanner) {

        this.categoryId = inputCategoryId();

        this.categoryName=inputCategoryName(scanner);

        this.description=inputDescription(scanner);

        this.status=inputStatus(scanner);
    }

    public boolean inputStatus(Scanner scanner) {
        System.out.println("Please enter category status:");
        do {
            String status=scanner.nextLine();
            if (status.trim().isEmpty()){
                System.err.println("Category status can only be true | false, please re-enter");
            }else {
                return Boolean.parseBoolean(status);
            }
        }while (true);
    }

    public String inputDescription(Scanner scanner) {
        System.out.println("Please enter category description:");
        do {
            String description=scanner.nextLine();
            if(description.trim().isEmpty()){
                System.err.println("Category description cannot be empty, please re-enter");
            }else {
                return description;
            }
        }while (true);

    }

    public String inputCategoryName(Scanner scanner) {
        System.out.println("Please enter a category name:");
        do {
            String categoryName=scanner.nextLine();
            if(categoryName.trim().isEmpty()){
                System.err.println("Category name cannot be empty, please re-enter");
            }
            else {
                return categoryName;
            }
        }while (true);
    }

    public int inputCategoryId() {
        int maxId = 0;
        for (Category category : CategoryFeatureImpl.categoryList) {
            if (category.getCategoryId() > maxId) {
                maxId = category.getCategoryId();
            }
        }
        return maxId + 1;
    }

    public void displayData() {
        System.out.printf(
                "[ ID: %10s | Name: %10s | Description: %10s | Status: %10s ]\n",
                this.categoryId,
                this.categoryName,
                this.description,
                this.status == true?"Active": "Inactive"
        );
    }
}
