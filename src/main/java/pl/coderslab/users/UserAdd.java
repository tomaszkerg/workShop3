package pl.coderslab.users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/add")
public class UserAdd extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/users/addUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        UserDao userDao = new UserDao();
        User user = new User();
        User[] users =userDao.usersAll();
        boolean check = false;
        for(User user1:users){
            if(user1.getEmail().equals(email)||user1.getUserName().equals(username)) check = true;
        }
        if(username==null||email==null||password==null||check){
            req.setAttribute("error", "błędne dane lub taki użytkownik juz istnieje");
            getServletContext().getRequestDispatcher("/users/addUser.jsp").forward(req, resp);
        }else {
            user.setUserName(username);
            user.setEmail(email);
            user.setPassword(password);
            userDao.create(user);
            resp.sendRedirect("/user/list");
        }
    }
}
