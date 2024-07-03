package business.entity;

import business.feature.impl.CategoryFeatureImpl;
import business.feature.impl.ProductFeatureImpl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Products implements Serializable {
    private int productId;
    private String sku;
    private String productName;
    private String description;
    private double unitPrice;
    private int stockQuantity;
    private String image;
    private Category categoryId;
    private Date createdAt;
    private Date updatedAt;

    public Products() {
    }

    public Products(int productId, String sku, String productName, String description, double unitPrice,
                    int stockQuantity, String image, Category categoryId, Date createdAt, Date updatedAt) {
        this.productId = productId;
        this.sku = sku;
        this.productName = productName;
        this.description = description;
        this.unitPrice = unitPrice;
        this.stockQuantity = stockQuantity;
        this.image = image;
        this.categoryId = categoryId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void inputData(Scanner scanner) {
        this.productId = inputProductId();

        this.sku = inputSku();

        this.productName = inputProductName(scanner);

        this.description = inputDescription(scanner);

        this.unitPrice = inputUnitPrice(scanner);

        this.stockQuantity = inputStockQuantity(scanner);

        this.image = inputImage(scanner);

        this.categoryId=inputCategoryId(scanner);
        
        this.createdAt=new Date();

        this.updatedAt=new Date();
    }

    private Category inputCategoryId(Scanner scanner) {
        for (Category category : CategoryFeatureImpl.categoryList) {

            System.out.printf("[ ID: %d | Name: %s ]\n", category.getCategoryId(), category.getCategoryName());
        }

        System.out.println("Nhập vào ID tác giả muốn thêm: ");
        do {
            int categoryIdChoice = Integer.parseInt(scanner.nextLine());
            int indexCategory = findCategoryIndexById(categoryIdChoice);
            if (indexCategory >= 0) {
                return CategoryFeatureImpl.categoryList.get(indexCategory);
            } else {
                System.err.println("không tìm thây author, vui lòng nhập lại id");
            }
        } while (true);

    }
    public int findCategoryIndexById(int categoryId) {
        for (int i = 0; i < CategoryFeatureImpl.categoryList.size(); i++) {
            if (CategoryFeatureImpl.categoryList.get(i).getCategoryId() == categoryId) {
                return i;
            }
        }
        return -1;
    }

    private String inputImage(Scanner scanner) {
        System.out.println("Please enter your image:");
        do {
            String image=scanner.nextLine();
            if (image.trim().isEmpty()){
                System.err.println("Product image cannot be empty, please re-enter");
            }else {
                return image;
            }
        }while (true);
    }

    private int inputStockQuantity(Scanner scanner) {
        System.out.println("Please enter quantity in stock:");
        do {
            String stockQuantity = scanner.nextLine();
            if (stockQuantity.trim().isEmpty()) {
                System.err.println("Product quantity in stock cannot be empty, please re-enter");
            } else if (Integer.parseInt(stockQuantity) <= 0) {
                System.err.println("Product The quantity in stock must be larger 0, please re-enter");
            } else {
                return Integer.parseInt(stockQuantity);
            }
        } while (true);

    }

    private double inputUnitPrice(Scanner scanner) {
        System.out.println("Please enter unit price:");
        do {
            String uintPrice = scanner.nextLine();
            if (uintPrice.trim().isEmpty()) {
                System.err.println("Product unit price cannot be empty, please re-enter");
            } else {
                return Double.parseDouble(uintPrice);
            }
        } while (true);

    }

    private String inputDescription(Scanner scanner) {
        System.out.println("Please enter product description:");
        do {
            String description = scanner.nextLine();
            if (description.trim().isEmpty()) {
                System.err.println("Product description cannot be empty, please re-enter");
            } else {
                return description;
            }
        } while (true);
    }

    private String inputProductName(Scanner scanner) {
        System.out.println("Please enter a product name:");
        do {
            String productName = scanner.nextLine();
            if (productName.trim().isEmpty()) {
                System.err.println("Product name cannot be empty, please re-enter");
            } else {
                boolean isExist = ProductFeatureImpl.productsList.stream().anyMatch(item -> item.getProductName().equals(productName));
                if (isExist) {
                    System.err.println("The product is duplicated, please re-enter");
                } else {
                    return productName;
                }
            }
        } while (true);

    }

    private String inputSku() {
        UUID uuid = UUID.randomUUID();
        String sku = String.valueOf(uuid);
        return sku;
    }

    private int inputProductId() {
        int maxId = 0;
        for (Products products : ProductFeatureImpl.productsList) {
            if (products.getProductId() > maxId) {
                maxId = products.getProductId();
            }
        }
        return maxId + 1;
    }

    public void displayData() {
        System.out.printf(
                "[ ID: %5d | Sku: %10s | Product Name: %10s | Description: %10s | Unit Price: %.2f | Stock Quantity: %10d | Image:%s | Category Name: %s | CreatedAt: %s | UpdatedAt: %s]\n",
                this.productId,
                this.sku,
                this.productName,
                this.description,
                this.unitPrice,
                this.stockQuantity,
                this.image,
                this.categoryId.getCategoryName(),
                this.createdAt.toString(),
                this.updatedAt.toString()
        );

    }
}
