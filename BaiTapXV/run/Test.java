package BaiTapXV.run;

import org.mindrot.jbcrypt.BCrypt;
import BaiTapXV.entity.RoleName;
import BaiTapXV.entity.User;
import BaiTapXV.util.IOFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User user = new User(1, "Nguyen văn a", "a@gmail.com", BCrypt.hashpw("123456", BCrypt.gensalt(5)), "09756547656", LocalDate.of(1999, 5, 5), "HCM", RoleName.USER, false);
        User admin = new User(2, "admin", "admin@gmail.com", BCrypt.hashpw("admin123", BCrypt.gensalt(5)), null, null, null, RoleName.ADMIN, false);

        users.add(user);
        users.add(admin);
        IOFile.writeToFile(IOFile.USER_PATH, users);
    }
}