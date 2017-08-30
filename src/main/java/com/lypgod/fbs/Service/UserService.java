package com.lypgod.fbs.Service;

import com.lypgod.fbs.Common.Exception.LoginFailedException;
import com.lypgod.fbs.Common.Exception.NotFoundException;
import com.lypgod.fbs.Common.Exception.ValidationException;
import com.lypgod.fbs.Model.Entity.User;
import com.lypgod.fbs.Model.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        if (userRepository.findByUserName(user.getUserName()) != null) {
            throw new ValidationException("用户名已经被注册！");
        }
        return userRepository.save(user);
    }

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public User updateUser(String userName, User user) {
        User currentUser = userRepository.findByUserName(userName);
        if (currentUser == null) {
            throw new NotFoundException("用户名未找到！");
        }
        if (!currentUser.getUserName().equals(user.getUserName())
                && userRepository.findByUserName(user.getUserName()) != null) {
            throw new ValidationException("用户名已经被注册！");
        }

        user.setId(currentUser.getId());
        return userRepository.save(user);
    }

    public void deleteUserByName(String userName) {
        User currentUser = userRepository.findByUserName(userName);
        if (currentUser == null) {
            throw new NotFoundException("用户名未找到！");
        }

        userRepository.delete(currentUser);
    }

    public List<User> saveUsers(List<User> users) {
        return userRepository.save(users);
    }

    public User login(User user) {
        User resultUser = userRepository.findByUserName(user.getUserName());
        if (resultUser == null) throw new LoginFailedException("用户名未找到！");
        if (!resultUser.getPassword().equals(user.getPassword())) throw new LoginFailedException("密码错误！");
        return resultUser;
    }
    public Boolean checkRegistered(String userName) {
        return userRepository.findByUserName(userName) == null;
    }

    public User register(User user) {
//        User resultUser = userRepository.findByUserName(user.getUserName());
//        if (resultUser == null) throw new LoginFailedException("用户名未找到！");
//        if (!resultUser.getPassword().equals(user.getPassword())) throw new LoginFailedException("密码错误！");
        return user;
    }

}
