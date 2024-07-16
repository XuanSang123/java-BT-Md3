package BaiTapXV.business;

import org.mindrot.jbcrypt.BCrypt;
import BaiTapXV.entity.RoleName;
import BaiTapXV.entity.User;
import BaiTapXV.exception.UsernameAndPasswordException;
import BaiTapXV.util.IOFile;

import java.util.List;

public class AuthBussiness implements IAuthDesign {
    private static List<User> users;

    static {
        users = IOFile.readFromFile(IOFile.USER_PATH);
    }

    @Override
    public User signIn(String username, String password) {
        return users.stream().filter(u -> u.getEmail().equals(username) && BCrypt.checkpw(password, u.getPassword()))
                .findFirst().orElseThrow(() -> new UsernameAndPasswordException("username or password incorrect!"));
    }

    @Override
    public void signUp(User user) {
        user.setBlocked(false);
        user.setRoleName(RoleName.USER);
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(5)));
        users.add(user);
        IOFile.writeToFile(IOFile.USER_PATH, users);
    }
}
