package BaiTapXV.run;

import BaiTapXV.business.AuthBussiness;
import BaiTapXV.business.IAuthDesign;
import BaiTapXV.entity.RoleName;
import BaiTapXV.entity.User;
import BaiTapXV.exception.UsernameAndPasswordException;
import BaiTapXV.util.IOFile;
import BaiTapXV.util.InputMethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AuthenticationMenu {
    private static final IAuthDesign iAuthdesign = new AuthBussiness();

    public static void main(String[] args) {
        while (true) {
            System.out.println("-------------------Store-----------------");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng kí");
            System.out.println("3. Thoát");
            System.out.println("----- Nhập lựa chọn -------");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    login();
                    // đăng nhập
                    break;
                case 2:
                    register();
                    // đăng kí
                    break;
                case 3:
                    // thoát
                    System.out.println("Tạm biệt");
                    break;
                default:
                    System.err.println("ko đúng lựa chọn");
            }
            if (choice == 3) {
                break;
            }
        }
    }

    private static void login() {
        System.out.println("=================Đăng nhập=================");
        System.out.println("Nhập username/ email :");
        String userName = InputMethods.getString();
        System.out.println("Nhập password");
        String password = InputMethods.getString();
        try {
            User userLogin = iAuthdesign.signIn(userName, password);
            //luu thong tin user login vao file
            IOFile.writeUserLogin(userLogin);
            //xet quyen user
            if (userLogin.getRoleName().equals(RoleName.ADMIN)) {
                menuAdmin();
            } else if (userLogin.getRoleName().equals(RoleName.USER)) {
                if (userLogin.isBlocked()) {
                    System.out.println("TK bi khoa, vui long lien he 02348219");
                } else {
                    menuUser();
                }
            }
        } catch (UsernameAndPasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void register() {
        System.out.println("------------------Register----------------");
        User user = new User();
        while (true) {
            System.out.println("Nhập tên đăng nhập: ");
            String name = InputMethods.getString();
            if (name.length() > 0) {
                user.setFullName(name);
                break;
            } else {
                System.out.println("Tên đăng nhập không hợp lệ. Vui lòng nhập lại.");
            }
        }
        //Nhập và kiểm tra email
        while (true) {
            System.out.println("Nhập email: ");
            String email = InputMethods.getString();
            if (email.matches("^[a-zA-Z0-9_]+@[a-zA-Z]+\\.[a-zA-Z]+$")) {
                user.setEmail(email);
                break;
            } else {
                System.out.println("Email không hợp lệ. Vui lòng nhập lại.");
            }
        }
        //Nhập và kiểm tra mật khẩu
        while (true) {
            System.out.println("Nhập mật khẩu: ");
            String password = InputMethods.getString();
            if (password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")) {
                user.setPassword(password);
                break;
            } else {
                System.out.println("Mật khẩu phải có 1 chữ viết hoa, 1 chữ viết thường, 1 số và có 8 kí tự trở lên. Vui lòng nhập lại.");
            }
        }
        // Confirm pass
        while (true) {
            System.out.println("Confirm password: ");
            String confirmPassword = InputMethods.getString();
            if (confirmPassword.equals(user.getPassword())) {
                //Nhập và kiểm tra số điện thoại
                while (true) {
                    System.out.println("Nhập số điện thoại: ");
                    String phone = InputMethods.getString();
                    if (phone.matches("^(\\+84|0)\\d{8,9}$")) {
                        user.setPhone(phone);
                        break;
                    } else {
                        System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại.");
                    }
                }
                //Nhập và kiểm tra address
                while (true) {
                    System.out.println("Nhập địa chỉ: ");
                    String address = InputMethods.getString();
                    if (address.length() > 0) {
                        user.setAddress(address);
                        break;
                    } else {
                        System.out.println("Địa chỉ không hợp lệ. Vui lòng nhập lại.");
                    }
                }
                //Nhập và kiểm tra birthday
                while (true) {
                    System.out.println("Nhập ngày tháng năm sinh (dd/MM/yyyy): ");
                    String birthdayInput = InputMethods.getString();
                    if (!birthdayInput.isEmpty()) {
                        try {
                            LocalDate birthday = LocalDate.parse(birthdayInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                            user.setBirthday(birthday);
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.println("Ngày tháng không hợp lệ. Vui lòng nhập lại.");
                        }
                    } else {
                        System.out.println("Ngày tháng không được để trống. Vui lòng nhập lại.");
                    }
                }
                break; // If passwords match, exit the loop
            } else {
                System.out.println("Mật khẩu không khớp, vui lòng thử lại");
            }
        }
        iAuthdesign.signUp(user);
        System.out.println("Đăng kí thành công");
        login();
    }

    private static void menuAdmin() {
        System.out.println("chào mừng bạn đến trang admin");
        InputMethods.pressAnyKey();
    }

    private static void menuUser() {
        System.out.println("chào mừng đê cửa hàng để mua sắm");
        InputMethods.pressAnyKey();
    }
}