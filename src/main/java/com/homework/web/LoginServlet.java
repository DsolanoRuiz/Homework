
package com.homework.web;

import com.homework.model.User;
import com.homework.services.LoginService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.login.LoginException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
      
        String email = req.getParameter("email");
        String pwd = req.getParameter("pwd");

        String msgErrorEmail = null;
        String msgErrorPwd = null;
        String msgErrorLogin = null;

        boolean correct = true;

        if (email == null || email.trim().length() == 0) {
            msgErrorEmail = "Please indicate the email";
            correct = false;
        }

        if (pwd == null || pwd.trim().length() == 0) {
            msgErrorPwd = "please indicate the password";
            correct = false;
        }
        if (correct) {
            
            try{
            HttpSession sesion = req.getSession();
            LoginService servicio = new LoginService();
            servicio.login(email, pwd, sesion);
            }
            
            catch (com.homework.exception.LoginException ex) {
            msgErrorLogin = ex.getMessage();
            correct = false;
            }
        }

        String jspShow = "";
        if (correct) {
            jspShow = "index.jsp";
        } else {
            jspShow = "login.jsp";
            req.setAttribute("msgErrorEmail", msgErrorEmail);
            req.setAttribute("msgErrorPwd", msgErrorPwd);
            req.setAttribute("msgErrorLogin", msgErrorLogin);
        }

        RequestDispatcher rd = req.getRequestDispatcher(jspShow);
        rd.forward(req, resp);
    }

}
