package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> allUsers();
    void addUser(User user);
    void deleteUser(long id);
    void editUser(User user);
    User getById(long id);
}
