package com.lypgod.fbs.Model.Entity;

import javax.validation.Valid;
import java.util.List;

public class UserList {
    @Valid
    private List<User> users;

    public UserList() {
    }

    public UserList(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
