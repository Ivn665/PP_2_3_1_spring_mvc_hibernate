package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> allUsers();
    void addUser(User user);
    void deleteUser(long id);
    void editUser(User user);
    User getById(long id);
}
