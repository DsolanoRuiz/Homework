
package com.homework.web;

import com.homework.model.DB;
import com.homework.model.Homework;
import com.homework.model.Status;
import com.homework.model.User;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "HomeworkServlet", urlPatterns = {"/homework"})
public class HomeworkServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
           
        String sId = req.getParameter("id");
        String user = req.getParameter("user");
        String message = null;
        String changeStatus = req.getParameter("changeStatus");
        String status = null;

        int id = 0;
        if (sId == null || sId.trim().length() == 0) {
            message = "Please indicate the id of the homework to be changed";
        } else {
            try {
                id = Integer.parseInt(sId);
            } catch (NumberFormatException e) {
                message = "Please indicate the id of the homework in an integer";
            }
        }

        if (user == null || user.trim().length() == 0) {
            message = "Please indicate the name of user";
        }

        if (message == null) {
            Homework h = DB.getHomeworkbyId(id);
            message = "Change in status made";
            
            if (changeStatus.equals("doing")){
                if (h.getStatus().equals("To Do")) {
                            status = "In Progress";
                }
                if (h.getStatus().equals("In Progress"))
                            status = "Done";                            
                    }
            
                DB.ChangeStatus(h, status);           

        }

        RequestDispatcher rd = req.getRequestDispatcher("homework-list.jsp");
        req.setAttribute("user", user);
        req.setAttribute("message", message);
        rd.forward(req, resp);

    }

    
}