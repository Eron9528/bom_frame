package cn.com.taiji.service.user;

import cn.com.taiji.domain.user.User;

import java.util.List;

public interface UserService {
    List<User> listUser();

    User changeStateById(long id, boolean state);

    User addUser(User user);

    User updateUserById(User user, long id);

    User getUserById(long id);

    User deleteById(long id);
}
