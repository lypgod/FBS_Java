package com.lypgod.fbs.Service;

import com.lypgod.fbs.Common.Exception.LoginException;
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

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deletaUserById(Integer id) {
        userRepository.delete(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findOne(id);
    }

    public User login(User user) {
        User resultUser = userRepository.findByUserName(user.getUserName());
        if (resultUser == null) throw new LoginException("invalid username.");
        if (!resultUser.getPassword().equals(user.getPassword())) throw new LoginException("password incorrect.");
        return resultUser;
    }
}
