package pl.coderslab.login;

import pl.coderslab.users.User;
import pl.coderslab.users.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/login")
public class Login extends HttpServlet {

    private final static String USER = "admin";
    private final static String PASSWORD = "coderslab";
    private final String printUser = "SELECT * FROM users WHERE email = ?";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/users/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("login");
        String pass = req.getParameter("password");
        HttpSession session = req.getSession();
        UserDao userDao = new UserDao();
        User user = userDao.read(email,printUser);
        if (USER.equals(email) && PASSWORD.equals(pass)) {
            List<String> list = new ArrayList<>();
            list.add(email);
            list.add(pass);
            session.setAttribute("username",list);
            resp.sendRedirect("/user/list");
        } else if (user!=null) {
            if(user.getPassword().equals(pass)){
                List<String> list = new ArrayList<>();
                list.add(email);
                list.add(pass);
                session.setAttribute("username",list);
                resp.sendRedirect("/user/list");
            }else{
                req.setAttribute("error", "błędne dane, spróbuj ponownie");
                getServletContext().getRequestDispatcher("/users/login.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("error", "błędne dane, spróbuj ponownie");
            getServletContext().getRequestDispatcher("/users/login.jsp").forward(req, resp);
        }
    }
}