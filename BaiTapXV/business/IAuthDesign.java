package BaiTapXV.business;
import BaiTapXV.entity.User;

public interface IAuthDesign {
    User signIn(String userName, String password);

    void signUp(User user);
}
