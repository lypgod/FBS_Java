package com.lypgod.fbs.Controller;

import com.lypgod.fbs.Common.Exception.ValidationException;
import com.lypgod.fbs.Model.Entity.User;
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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public User user(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult);
        }
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") Integer id) {
        userService.deletaUserById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public User updateUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult);
        }
        if (user.getId() == null) {
            throw new RuntimeException("No id");
        }
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable(value="id") Integer id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult);
        }
        return userService.login(user);
    }
}
