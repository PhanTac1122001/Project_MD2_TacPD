package business.entity;

import business.feature.impl.ProductFeatureImpl;
import business.feature.impl.UserFeatureImpl;

import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;

public class User implements Serializable {
    private int userId;
    private String userName;
    private String email;
    private String fullName;
    private boolean status;
    private String password;
    private String avatar;
    private String phone;
    private String address;
    private Date createdAt;
    private Date updatedAt;
    private boolean isDeleted;

    public User() {
    }

    public User(int userId, String userName, String email, String fullName, boolean status, String password, String avatar, String phone, String address, Date createdAt, Date updatedAt, boolean isDeleted) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.fullName = fullName;
        this.status = status;
        this.password = password;
        this.avatar = avatar;
        this.phone = phone;
        this.address = address;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isDeleted = isDeleted;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void inputData(Scanner scanner) {
        this.userId = inputUserId();

        this.userName=inputUserName(scanner);

        this.email=inputEmail(scanner);

        this.fullName=inputFullName(scanner);

        this.status=inputStatus(scanner);
//
        this.password=inputPassWord(scanner);
//
        this.avatar=inputAvatar(scanner);
//
        this.phone=inputPhone(scanner);
//
        this.address=inputAddress(scanner);
//
        this.createdAt=new Date();
//
        this.updatedAt=new Date();
//
        this.isDeleted=inputIsDeleted(scanner);

    }

    public boolean inputIsDeleted(Scanner scanner) {
        boolean isDeleted=true;
        return isDeleted;
    }

    public String inputAddress(Scanner scanner) {
        System.out.println("Mời nhập địa chỉ:");
        do {
            String address=scanner.nextLine();
            if (address.trim().isEmpty()){
                System.err.println("Không được để trống, vui lòng nhập lại.");
            }else {
                return address;
            }
        }while (true);
    }

    public String inputPhone(Scanner scanner) {
        String phoneRegex="0\\d{9}";
        System.out.println("Mời nhập số điện thoại:");
        do {
            String phone =scanner.nextLine();
            if (phone.trim().isEmpty()){
                System.err.println("Không được để trống, vui lòng nhập lại.");
            }else {
                if (phone.matches(phoneRegex)){
                    return phone;
                }else {
                    System.err.println("Mời nhập đúng định dạng");
                }
            }
        }while (true);
    }

    public String inputAvatar(Scanner scanner) {
        System.out.println("Mời nhập hình đại diện:");
        do {
            String avatar=scanner.nextLine();
            if (avatar.trim().isEmpty()){
                System.err.println("Không được để trống, vui lòng nhập lại.");
            }
            else {
                return avatar;
            }
        }while (true);
    }

    public String inputPassWord(Scanner scanner) {
        System.out.println("Mời nhập mật khẩu:");
        do {
            String password=scanner.nextLine();
            if (password.trim().isEmpty()){
                System.err.println("Không được để trống, vui lòng nhập lại.");
            }
            else {
                return password;
            }
        }while (true);
    }

    public boolean inputStatus(Scanner scanner) {
        System.out.println("Mời nhập trạng thái user:");
        do {
            String status=scanner.nextLine();
            if(fullName.trim().isEmpty()){
                System.err.println("Không được để trống, vui lòng nhập lại.");
            }else {
                if (status.equals("true")||status.equals("false")){
                    return Boolean.parseBoolean(status);
                }else {
                    System.err.println("Chỉ nhập trạng thái True | False, Vui lòng nhập lại");
                }
            }
        }while (true);
    }

    public String inputFullName(Scanner scanner) {
        System.out.println("Mời nhập họ và tên:");
        do {
            String fullName=scanner.nextLine();
            if (fullName.trim().isEmpty()){
                System.err.println("Không được để trống, vui lòng nhập lại.");
            }
            else {
                return fullName;
            }
        }while (true);
    }

    public String inputEmail(Scanner scanner) {
        String emailRegex="^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        System.out.println("Mời nhập email:");
        do {
            String email=scanner.nextLine();
            if (email.trim().isEmpty()){
                System.err.println("Không được để trống, vui lòng nhập lại.");
            }else {
                if(email.matches(emailRegex)){

                    return email;
                }else {
                    System.err.println("Mời nhập đúng định dạng");
                }
            }
        }while (true);

    }

    public String inputUserName(Scanner scanner) {
        System.out.println("Mời nhập tên đăng nhập:");
        do {
            String userName=scanner.nextLine();
            if(userName.trim().isEmpty()){
                System.err.println("Category name cannot be empty, please re-enter");
            }
            else if (userName.length()<=6||userName.length()>100){
                System.err.println("Tối thiểu 6 ký tự, tối đa 100 kí tự");
            }
            else {
                boolean isExist = ProductFeatureImpl.productsList.stream().anyMatch(item -> item.getProductName().equals(userName));
                if (isExist) {
                    System.err.println("The product is duplicated, please re-enter");
                } else {
                    return userName;
                }
            }

        }while (true);
    }

    private int inputUserId() {
        int maxId = 0;
        for (User user : UserFeatureImpl.userList) {
            if (user.getUserId() > maxId) {
                maxId = user.getUserId();
            }
        }
        return maxId + 1;
    }

    public void displayData(){
        System.out.printf(
                "[ ID: %5d | Name: %10s | Email: %10s | FullName: %10s | Status:%s | Password:%s | Avartar: %s | Phone: %s | Address: %s |CreatedAt: %s | UpdatedAt: %s]\n",
                this.userId,
                this.userName,
                this.email,
                this.fullName,
                this.status ==true ?"Hoạt động":"Khóa",
                this.password,
                this.avatar,
                this.phone,
                this.address,
                this.createdAt.toString(),
                this.updatedAt.toString(),
                this.isDeleted ==true?"Bị xóa":"Hoạt động"
        );
    }
}
