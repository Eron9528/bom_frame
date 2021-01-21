package cn.com.taiji.service.user.impl;

import cn.com.taiji.domain.user.*;
import cn.com.taiji.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PermissionRepo permissionRepo;
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public List<User> listUser() {
        List<User> users = userRepo.findAll();
        return users;
    }

    @Override
    public User changeStateById(long id, boolean state) {
        User user = userRepo.findById(id).orElse(null);
        user.setState(state);
        userRepo.save(user);
        return user;
    }

    @Override
    public User addUser(User user) {
        user.setState(true);
        userRepo.save(user);
        return user;
    }

    @Override
    public User updateUserById(User account, long id) {
        User user = userRepo.findById(id).orElse(null);
        user.setEmail(account.getEmail());
        user.setPhone(account.getPhone());
        userRepo.save(user);
        return user;
    }

    @Override
    public User getUserById(long id) {
        User user = userRepo.findById(id).orElse(null);
        return user;
    }

    @Override
    public User deleteById(long id) {
        User user = userRepo.findById(id).orElse(null);
        if (user != null)
          userRepo.deleteById(id);
        return user;
    }


}
