package by.tms.home.storage;

import by.tms.home.model.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserStorage {
    private static final List<User> users = new ArrayList<>();

    public boolean save(User user) {
        if (users.contains(user)) {
            return false;
        }
        users.add(user);
        return true;
    }

    public User getByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public boolean passwordLength(String password) {
        if (password.length() > 3 && password.length() < 10) {
            return true;
        }
        return false;
    }

    /*public User uniqueLogin(String login){

    }*/

}
