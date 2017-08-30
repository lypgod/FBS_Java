package com.lypgod.fbs.Controller;

import com.lypgod.fbs.Common.Exception.ValidationException;
import com.lypgod.fbs.Model.Entity.User;
import com.lypgod.fbs.Model.Entity.UserList;
import com.lypgod.fbs.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public User addUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult);
        }
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    public User getUserByName(@PathVariable(value = "userName") String userName) {
        return userService.findByUserName(userName);
    }

    @RequestMapping(value = "/{userName}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable(value = "userName") String userName, @RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult);
        }

        return userService.updateUser(userName, user);
    }

    @RequestMapping(value = "/{userName}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("userName") String userName) {
        userService.deleteUserByName(userName);
    }

    @RequestMapping(value = "/createWithList", method = RequestMethod.POST)
    public List<User> createUsersWithList(@RequestBody @Valid UserList users, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult);
        }
        return userService.saveUsers(users.getUsers());
    }

    @RequestMapping(value = "/checkRegistered/{userName}", method = RequestMethod.GET)
    public Boolean checkRegistered(@PathVariable(value = "userName") String userName) {
        return userService.checkRegistered(userName);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User loginUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult);
        }
        return userService.login(user);
    }
}
