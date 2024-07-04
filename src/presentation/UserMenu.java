package presentation;

import business.entity.Address;
import business.entity.Category;
import business.entity.Products;
import business.entity.User;
import business.feature.IAddressFeature;
import business.feature.ICategoryFeature;
import business.feature.IProductFeature;
import business.feature.IUserFeature;
import business.feature.impl.AddressFeatureImpl;
import business.feature.impl.CategoryFeatureImpl;
import business.feature.impl.ProductFeatureImpl;
import business.feature.impl.UserFeatureImpl;

import java.util.Scanner;

public class UserMenu {
    private static final ICategoryFeature categoryFeature=new CategoryFeatureImpl();
    private static final IProductFeature productFeature =new ProductFeatureImpl();
    private static final IUserFeature userFeature =new UserFeatureImpl();
    private static final IAddressFeature addressFeature =new AddressFeatureImpl();
    public static void menuUser(Scanner scanner) {

        boolean isLoop = true;
        do {
            System.out.println("================== MENU AUTHOR ==================\n" +
                    "1.\tLấy địa chỉ người dùng theo addressId\n" +
                    "2.\tLấy danh sách địa chỉ của người dùng\n" +
                    "3.\tXóa 1 địa chỉ theo mã địa chỉ\n" +
                    "4.\tThêm mới địa chỉ\n" +
                    "5.\tCập nhật thông tin người dùng\n" +
                    "6.\tThông tin tài khoản người dùng\n" +
                    "7.\tBack\n");
            System.out.println("Please enter: ");
            int choice = inputNumber(scanner);
            switch (choice) {
                case 1:
                    getUserbyAddressId(scanner);
                    break;
                case 2:
                    getUserByAddress(scanner);
                    break;
                case 3:
                    deleteAddressByAddressId(scanner);
                    break;
                case 4:
                    addAddress(scanner);
                    break;
                case 5:
                    updateUser(scanner);
                    break;
                case 6:
                    showUser(scanner);
                    break;
                case 7:
                    isLoop = false;
                    break;
                default:
                    System.err.println("Please re-enter 1 -> 8");
            }
        } while (isLoop);

    }

    private static void addAddress(Scanner scanner) {
        System.out.println("Enter the quantity you want to add to the product: ");
        int number = inputNumber(scanner);
        for (int i = 0; i < number; i++) {
            Address address = new Address();
            address.inputData(scanner);
            addressFeature.saveOrUpdate(address);
        }
    }

    private static void deleteAddressByAddressId(Scanner scanner) {
        System.out.println("Enter the ID you want to delete: ");
        int idDelete = inputNumber(scanner);
        addressFeature.deleteById(idDelete);
    }

    private static void getUserByAddress(Scanner scanner) {
        for (User user : UserFeatureImpl.userList) {

            System.out.printf("[ ID: %d | Name: %s ]\n", user.getUserId(), user.getFullName());
        }
        int userId = inputNumber(scanner);
        int count=0;
        for (Address address:AddressFeatureImpl.addressList){
            if (userId == address.getUserId().getUserId()) {
                address.displayData();
                count++;
            }
        }
        System.out.println("Có "+ count+ " địa chỉ.");

    }

    private static void getUserbyAddressId(Scanner scanner) {
        if (AddressFeatureImpl.addressList.isEmpty()) {
            System.err.println("Empty list");
            return;
        }
        boolean hasProduct=false;
        System.out.println("Enter the ID you want to search:");
        int searchUserId=inputNumber(scanner);

        for (Address address:AddressFeatureImpl.addressList){
            if(address.getAddressId()==searchUserId){
                hasProduct=true;
                address.displayData();
            }
        }
        if(!hasProduct){
            System.err.println("ID not found : " + searchUserId);
        }
    }

    private static void updateUser(Scanner scanner) {
        System.out.println("Enter the ID you want to update: ");
        int idUpdate = inputNumber(scanner);
        int indexUpdate = userFeature.findIndexById(idUpdate);
        if (indexUpdate < 0) {
            System.err.println("ID does not exist = " + idUpdate);
            return;
        }
        User userUpdate = UserFeatureImpl.userList.get(indexUpdate);
        boolean isLoop = true;
        do {
            System.out.println("1. Cập nhật tên người dùng");
            System.out.println("2. Cập nhật email");
            System.out.println("3. Cập nhật họ và tên");
            System.out.println("3. Cập nhật trạng thái");
            System.out.println("3. Cập nhật mật khẩu");
            System.out.println("3. Cập nhật ảnh");
            System.out.println("3. Cập nhật số điện thoại");
            System.out.println("4. Back");
            System.out.println("Your choice: ");
            int choice = inputNumber(scanner);
            switch (choice) {
                case 1:
                    userUpdate.setUserName(userUpdate.inputUserName(scanner));
                    userUpdate.setUpdatedAt(userUpdate.getUpdatedAt());
                    break;
                case 2:
                    userUpdate.setEmail(userUpdate.inputEmail(scanner));
                    break;
                case 3:
                    userUpdate.setFullName(userUpdate.inputFullName(scanner));
                    break;
                case 4:
                    userUpdate.setStatus(userUpdate.inputStatus(scanner));
                    break;
                case 5:
                    userUpdate.setPassword(userUpdate.inputPassWord(scanner));
                    break;
                case 6:
                    userUpdate.setAvatar(userUpdate.inputAvatar(scanner));
                    break;
                case 7:
                    userUpdate.setPhone(userUpdate.inputPhone(scanner));
                    break;
                case 8:
                    userUpdate.setAddress(userUpdate.inputAddress(scanner));
                    break;
                case 9:
                    isLoop = false;
                    break;
                default:
                    System.err.println("Please re-enter 1 -> 9");
            }
        } while (isLoop);
    }

    private static void showUser(Scanner scanner) {
        if (UserFeatureImpl.userList.isEmpty()) {
            System.err.println("Empty list");
            return;
        }

        UserFeatureImpl.userList.forEach(User::displayData);
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
