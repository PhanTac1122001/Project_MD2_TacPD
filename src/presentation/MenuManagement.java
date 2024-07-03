package presentation;

import java.util.Scanner;

public class MenuManagement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("================== MENU ==================\n" +
                    "1.\tAdmin Menu\n" +
                    "2.\tUser Menu\n" +
                    "3.\tGeneral Menu\n" +
                    "4.\tThoát\n");
            System.out.println("Nhập vào lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    AdminMenu.menuAdmin(scanner);
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn lại từ 1 -> 3");
            }
        } while (true);
    }
}
