package business.entity;

import business.feature.impl.AddressFeatureImpl;
import business.feature.impl.CategoryFeatureImpl;
import business.feature.impl.UserFeatureImpl;

import java.io.Serializable;
import java.util.Scanner;

public class Address implements Serializable {
    public int addressId;
    private User userId;
    private String fullAddress;
    private String phone;
    private String receiveName;

    public Address() {
    }

    public Address(int addressId, User userId, String fullAddress, String phone, String receiveName) {
        this.addressId = addressId;
        this.userId = userId;
        this.fullAddress = fullAddress;
        this.phone = phone;
        this.receiveName = receiveName;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }
    public void inputData(Scanner scanner){
        this.addressId=inputAddressId();

        this.userId=inputUserId(scanner);

        this.fullAddress=inputFullAddress(scanner);

        this.phone=inputPhone(scanner);

        this.receiveName=inputReceiveName(scanner);
    }

    private String inputReceiveName(Scanner scanner) {
        System.out.println("Mời nhập người nhận:");
        do {
            String receiveName =scanner.nextLine();
            if (receiveName.trim().isEmpty()){
                System.err.println("Không được để trống, vui lòng nhập lại.");
            }else {
                return receiveName;

            }
        }while (true);
    }

    private String inputPhone(Scanner scanner) {
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

    private String inputFullAddress(Scanner scanner) {
        System.out.println("Mời nhập địa chỉ chi tiết:");
        do {
            String fullAddress =scanner.nextLine();
            if (fullAddress.trim().isEmpty()){
                System.err.println("Không được để trống, vui lòng nhập lại.");
            }else {
                    return fullAddress;

            }
        }while (true);
    }

    private User inputUserId(Scanner scanner) {

        for (User user : UserFeatureImpl.userList) {

            System.out.printf("[ ID: %d | Name: %s ]\n", user.getUserId(), user.getFullName());
        }

        System.out.println("Nhập vào ID tác giả muốn thêm: ");
        do {
            int userIdChoice = Integer.parseInt(scanner.nextLine());
            int indexUser = findUserIndexById(userIdChoice);
            if (indexUser >= 0) {
                return UserFeatureImpl.userList.get(indexUser);
            } else {
                System.err.println("không tìm thây author, vui lòng nhập lại id");
            }
        } while (true);
    }
    public int findUserIndexById(int userId) {
        for (int i = 0; i < UserFeatureImpl.userList.size(); i++) {
            if (UserFeatureImpl.userList.get(i).getUserId() == userId) {
                return i;
            }
        }
        return -1;
    }
    private int inputAddressId() {
        int maxId = 0;
        for (Address address : AddressFeatureImpl.addressList) {
            if (address.getAddressId() > maxId) {
                maxId = address.getAddressId();
            }
        }
        return maxId + 1;
    }
    public void displayData(){
        System.out.printf(
                "[ ID: %5d | Name: %10s | Full Address: %10s | Phone: %s | Receive Name: %s ]\n",
                this.addressId,
                this.userId.getFullName(),
                this.fullAddress,
                this.phone,
                this.receiveName

        );
    }
}
