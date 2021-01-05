
package com.homework.web;

import com.homework.exception.DBException;
import com.homework.model.DB;
import com.homework.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "RegistUserServlet", urlPatterns = {"/regist-user"})
public class RegistUserServlet extends HttpServlet {

      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String paramEmail = request.getParameter("email");
        String paramPwd = request.getParameter("pwd");
        String paramName = request.getParameter("name");
        String paramLastname = request.getParameter("lastname");

        String msgErrorEmail = null;
        String msgErrorPwd = null;
        String msgErrorName = null;
        String msgErrorLastname = null;
        String msgErrorRegister = null;

        boolean correct = true;
       
        if (paramEmail == null || paramEmail.trim().length() == 0) {
            msgErrorEmail = "Please indicate the email";
            correct = false;
        }

        if (paramPwd == null || paramPwd.trim().length() == 0) {
            msgErrorPwd = "Please indicate the password";
            correct = false;
        }

        if (paramName == null || paramName.trim().length() == 0) {
            msgErrorName = "Please indicate the name ";
            correct = false;
        }

        if (paramLastname == null || paramLastname.trim().length() == 0) {
            msgErrorLastname = "Please indicate the lastname ";
            correct = false;
        }

        if (correct) {
            User user = new User(paramEmail,paramPwd,paramName,paramLastname);
            try {
                DB.RegistUser(user);
           HttpSession session = request.getSession();
           session.setAttribute("user",user);    
                
            } catch (DBException ex) {
                msgErrorRegister = ex.getMessage();
                correct = false;              }
        }

        String jspShow = "";
        if (correct) {
            jspShow = "user-list.jsp";
        } else {
            jspShow = "form-regist-user.jsp";
            request.setAttribute("msgErrorEmail", msgErrorEmail);
            request.setAttribute("msgErrorPwd", msgErrorPwd);
            request.setAttribute("msgErrorName", msgErrorName);
            request.setAttribute("msgErrorLastname", msgErrorLastname);
            request.setAttribute("msgErrorRegister", msgErrorRegister);
        }
        
        RequestDispatcher rd = request.getRequestDispatcher(jspShow);
        rd.forward(request, response);

    }
}