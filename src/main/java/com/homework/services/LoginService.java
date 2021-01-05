package com.homework.services;

import com.homework.model.DB;
import com.homework.model.User;
import java.util.Collection;
import com.homework.exception.LoginException;
import javax.servlet.http.HttpSession;

public class LoginService {

    public void login(String email, String password, HttpSession session) throws LoginException {

        Collection<User> users = DB.getUser();
        User userFound = null;
        for (User u : users) {
            if (u.getEmail().equals(email)) {
                userFound = u;
                break;
            }
        }

        if (userFound == null) {
            throw new LoginException("The user not exist. Please register");
        } else {
            if (userFound.getPassword().equals(password)) {
                session.setAttribute("user", userFound);
            } else {
                throw new LoginException("Wrong password");
            }
        }

    }//fin login

    public void logout(HttpSession session) {
        session.invalidate();
    }

    public void setAttribute() {
    }

}
