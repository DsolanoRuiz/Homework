
package com.homework.model;

import com.homework.exception.DBException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import com.homework.model.Status;
import com.homework.model.Homework;
import com.homework.model.User;
import java.util.Set;

public class DB {

 private static HashMap<Integer, Homework>homeworks;
    private static HashSet<User> users;

    static {
        homeworks = new HashMap<Integer, Homework>();
        homeworks.put(1, new Homework(1, "Handling and management of social networks", Status.Done));
        homeworks.put(2, new Homework(2, "Assistance in measuring and managing KPI's", Status.Done));
        homeworks.put(3, new Homework(3, "Measurement and control of production efficiency", Status.In_Progress));
        homeworks.put(4, new Homework(4, "Reporting support", Status.In_Progress));
        homeworks.put(5, new Homework(5, "Complex business problems analysis", Status.In_Progress));
        homeworks.put(6, new Homework(6, "Targeted search in value creation applications", Status.To_do));
        homeworks.put(7, new Homework(7, "Collect, analyze and interpret Big Data", Status.In_Progress));
        homeworks.put(8, new Homework(8, "Provide business-relevant predictive analysis", Status.To_do));
        homeworks.put(9, new Homework(9, "Modeling, classification and prediction of business requirements", Status.To_do));
        homeworks.put(10, new Homework(10, "Design and communicate reports and conclusions for the shareholders'meeting", Status.To_do));

        users = new HashSet<>();
        users.add(new User("aaaaa@gmail.com", "1234", "Ainara", "Artea"));
        users.add(new User("bbbbb@gmail.com", "2345", "Begoña", "Bilbao"));
        users.add(new User("ddddd@gmail.com", "3456", "Aduri", "Deusto"));
        users.add(new User("eeeee@gmail.com", "4567", "Endika", "Enbeitia"));
        users.add(new User("iiiiii@gmail.com", "5678", "Iker", "Etxauri"));
        users.add(new User("llllll@gmail.com", "6789", "Leire", "Lezeaga"));

    }

   
    private DB() {
    }

    public synchronized static Collection<Homework> getAllHomework() {
        return homeworks.values();
    }
    
     
    public synchronized static Homework getHomeworkbyId(int id){    
        Homework h = homeworks.get(id);
        return h;
    }

    public synchronized static Collection<Homework> getHomeworkToDoUser(String nameUser) {
        Set<Homework> homeworkToDoUser = new HashSet<Homework>();
        for (Homework h : homeworks.values()) {
            if (h.getNameUser().equals(nameUser) && h.getStatus().equals("To Do")) {
                homeworkToDoUser.add(h);
            }
        }
        return homeworkToDoUser;
    }    
     public synchronized static Collection<Homework> getHomeworkInProgressUser(String nameUser) {
        Set<Homework> homeworkInProgressUser = new HashSet<Homework>();
        for (Homework h : homeworks.values()) {
            if (h.getNameUser().equals(nameUser) && h.getStatus().equals("In Progress")) {
                homeworkInProgressUser.add(h);
            }
        }
        return homeworkInProgressUser;
    } 
    
    public synchronized static Collection<Homework> getHomeworkDoneUser(String nameUser) {
        Set<Homework> homeworkDoneUser = new HashSet<Homework>();
        for (Homework h : homeworks.values()) {
            if (h.getNameUser().equals(nameUser) && h.getStatus().equals("Done")) {
                homeworkDoneUser.add(h);
            }
        }
        return homeworkDoneUser;
    } 

    public static Collection<Homework> getHomeworkStatus( Status s) {
        Set<Homework> status = new HashSet<Homework>();
        for (Homework h : homeworks.values()) {
            if (h.getStatus()==s) {
                status.add(h);
            }
        }
        return status;
    }

    public synchronized static void ChangeStatus(int id) {
        homeworks.get(id).setStatus(Status.To_do);
    }

    public synchronized static void RegistHomework(Homework homework) throws DBException {
        if (homeworks.containsKey(homework.getId())) {
            throw new DBException("The homework exist with this id " + homework.getId());
        } else {
            homeworks.put(homework.getId(), homework);
        }
       
    }

    public synchronized static Collection<User> getUser() {
        return users;
    }

    public synchronized static void RegistUser(User u) throws DBException {
        boolean Added = users.add(u);
        if (!Added) {
            throw new DBException("Not added because the user do not exist");
        }

    }
    
     public static void ChangeStatus(Homework h, String status) {
     }

    
}